package suppliers;

import storages.AccessoriesStorage;

import java.util.ArrayList;

public class AccessoriesSuppliers {
    private final ArrayList<AccessoriesSupplier> suppliers;

    public AccessoriesSuppliers(int size, AccessoriesStorage storage) {
        suppliers = new ArrayList<>(size);

        for (int i = 0; i < size; i++) {
            suppliers.add(new AccessoriesSupplier(storage));
        }
    }
}
