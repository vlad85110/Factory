package suppliers;

import storages.EngineStorage;

public class EngineSupplier extends AbstractSupplier {
    private final EngineStorage storage;

    public EngineSupplier(EngineStorage storage) {
        this.storage = storage;
    }
}
