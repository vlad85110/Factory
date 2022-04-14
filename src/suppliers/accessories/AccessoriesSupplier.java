package suppliers.accessories;

import storages.Storages;
import suppliers.AbstractSupplier;

public class AccessoriesSupplier extends AbstractSupplier {
    @Override
    protected void doTask() {
        var storage = Storages.getAccessoriesStorage();
        storage.add();
    }
}
