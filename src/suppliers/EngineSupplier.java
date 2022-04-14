package suppliers;

import storages.EngineStorage;
import storages.Storages;

public class EngineSupplier extends AbstractSupplier {
    @Override
    protected void doTask() {
        var storage = Storages.getEngineStorage();
        storage.add();
    }
}
