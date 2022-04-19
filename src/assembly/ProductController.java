package assembly;

import parse.FactoryConfig;
import storages.*;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ProductController extends Thread {
    private static volatile ProductController controller;
    private final ExecutorService pool;
    private final ArrayList<Future<?>> futures;
    private volatile boolean end;

    public static ProductController getInstance() {
        ProductController localInstance = controller;
        if (localInstance == null) {
            synchronized (ProductController.class) {
                localInstance = controller;
                if (localInstance == null) {
                    controller = localInstance = new ProductController("controller");
                }
            }
        }
        return localInstance;
    }

    public ProductController(String name) {
        super(name);
        int size = FactoryConfig.workers;
        pool = Executors.newFixedThreadPool(size);
        futures = new ArrayList<>(size);
    }

    @Override
    public void run() {
        CarStorage storage = Storages.getCarStorage();
        while (!end) {
            var count = storage.getFreePlace();

            for (int i = 0; i < count; i++) {
               var future = pool.submit(new Worker());
               futures.add(future);
            }

            for (var i : futures) {
                try {
                    i.get();
                } catch (InterruptedException | ExecutionException e) {
                    e.printStackTrace();
                }
            }

            synchronized (this) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public synchronized void notifyController() {
        notify();
    }

    public void end() {
        pool.shutdown();
        this.end = true;
    }
}
