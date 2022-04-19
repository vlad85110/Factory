package dealers;

import parse.FactoryConfig;
import products.Car;
import storages.Storages;
import thread.AbstractFactoryThread;
import view.Viewer;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Dealer extends AbstractFactoryThread {
    private final int logSale = FactoryConfig.logSale;
    private final FileWriter writer;

    public Dealer(String name, FileWriter writer) {
        super(name);
        this.writer = writer;
    }

    @Override
    protected void doTask() {
        var storage = Storages.getCarStorage();
        var car = (Car)storage.get();

        if (logSale == 1)
            log(car);

        var viewer = Viewer.getInstance();
        viewer.updateDealersTotal();
    }

    @Override
    protected long getProcessTime() {
        return FactoryConfig.dealerProcess;
    }

    private void log(Car car) {
        synchronized (writer) {
            var dtf = DateTimeFormatter.ofPattern("HH:mm:ss");
            var localTime = LocalTime.now();

            try {
                writer.write(dtf.format(localTime));
                writer.write(":" + Thread.currentThread().getName() + ":");
                writer.write(car.getName() + "\n");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void end() {
        super.end();

        try {
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
