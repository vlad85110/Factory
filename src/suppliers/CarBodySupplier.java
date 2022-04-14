package suppliers;

import storages.CarBodyStorage;

public class CarBodySupplier extends AbstractSupplier {
    private final CarBodyStorage storage;

    public CarBodySupplier(CarBodyStorage storage) {
        this.storage = storage;
    }
}
