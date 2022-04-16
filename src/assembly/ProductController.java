package assembly;

import parse.FactoryConfig;
import storages.*;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ProductController extends Thread {
    private static volatile ProductController controller;
    private final ExecutorService pool;
    private final int size;
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
        size = FactoryConfig.workers;
        pool = Executors.newFixedThreadPool(size);
    }

    @Override
    public synchronized void run() {
        CarStorage storage = Storages.getCarStorage();
        while (!end) {
            var count = storage.getFreePlace();

            for (int i = 0; i < count; i++) {
                pool.execute(new Worker());
            }

            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public synchronized void notifyController() {
        notify();
    }

    public void end() {
        this.end = true;
    }
}
