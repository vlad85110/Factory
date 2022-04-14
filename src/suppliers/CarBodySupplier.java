package suppliers;

import storages.CarBodyStorage;
import storages.Storages;

public class CarBodySupplier extends AbstractSupplier {
    @Override
    protected void doTask() {
        var storage = Storages.getCarBodyStorage();
        storage.add();
    }
}
