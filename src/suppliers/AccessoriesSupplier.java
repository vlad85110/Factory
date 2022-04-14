package suppliers;

import storages.AccessoriesStorage;

public class AccessoriesSupplier extends AbstractSupplier {
    private final AccessoriesStorage storage;

    public AccessoriesSupplier(AccessoriesStorage storage) {
        this.storage = storage;
    }
}
