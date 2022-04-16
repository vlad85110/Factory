package assembly;

import parse.FactoryConfig;
import products.Accessories;
import products.Car;
import products.CarBody;
import products.Engine;
import storages.*;

import java.util.concurrent.TimeUnit;

public class Worker implements Runnable {

    public void doTask() {
        EngineStorage engineStorage = Storages.getEngineStorage();
        CarBodyStorage carBodyStorage = Storages.getCarBodyStorage();
        AccessoriesStorage accessoriesStorage = Storages.getAccessoriesStorage();

        var engine = (Engine) engineStorage.get();
        var carBody = (CarBody) carBodyStorage.get();
        var accessories = (Accessories) accessoriesStorage.get();

        try {
            TimeUnit.MILLISECONDS.sleep(getProcessTime());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        var car = new Car(engine, carBody, accessories);

        CarStorage carStorage = Storages.getCarStorage();
        carStorage.add(car);
    }

    @Override
    public void run() {
        doTask();
    }

    protected long getProcessTime() {
        return FactoryConfig.workerProcess;
    }
}
