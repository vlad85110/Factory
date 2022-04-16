package suppliers.accessories;

import products.Accessories;
import storages.Storages;
import suppliers.AbstractSupplier;

public class AccessoriesSupplier extends AbstractSupplier {
    public AccessoriesSupplier(String name) {
        super(name);
    }

    @Override
    protected void createDetail() {
        var storage = Storages.getAccessoriesStorage();
        storage.add(new Accessories());
    }
}
