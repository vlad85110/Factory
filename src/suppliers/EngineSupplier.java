package suppliers;

import products.Engine;
import storages.Storages;

public class EngineSupplier extends AbstractSupplier {
    public EngineSupplier(String name) {
        super(name);
    }

    @Override
    protected void createDetail() {
        var storage = Storages.getEngineStorage();
        storage.add(new Engine());
    }
}
