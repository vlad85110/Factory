package suppliers.accessories;

import storages.AccessoriesStorage;
import storages.Storages;

import java.util.ArrayList;

public class AccessoriesSuppliers {
    private final ArrayList<AccessoriesSupplier> suppliers;
    private volatile boolean end = false;

    public AccessoriesSuppliers(int size, AccessoriesStorage storage) {
        suppliers = new ArrayList<>(size);

        for (int i = 0; i < size; i++) {
            suppliers.add(new AccessoriesSupplier());
        }
    }
    //todo подумaть
    public void start() {
        var storage = Storages.getAccessoriesStorage();

        while (!end) {
            while (!storage.isFull()) {
                for (var sup : suppliers) {
                    if (!sup.isBusy()) {
                        sup.notify();
                    }
                }
            }

            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void setEnd() {
        this.end = true;
    }
}
