package suppliers;

import products.CarBody;
import storages.Storages;

public class CarBodySupplier extends AbstractSupplier {
    public CarBodySupplier(String name) {
        super(name);
    }

    @Override
    protected void createDetail() {
        var storage = Storages.getCarBodyStorage();
        storage.add(new CarBody());
    }
}
