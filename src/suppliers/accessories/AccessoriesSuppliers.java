package suppliers.accessories;

import parse.FactoryConfig;
import thread.AbstractFactoryThread;

import java.util.ArrayList;

public class AccessoriesSuppliers {
    private final ArrayList<AccessoriesSupplier> suppliers;
    private final int size;

    public AccessoriesSuppliers() {
        size = FactoryConfig.accessorySuppliers;
        suppliers = new ArrayList<>(size);
    }

    public void start() {
        for (int i = 0; i < size; i++) {
            suppliers.add(new AccessoriesSupplier("Accessories-" + i));
        }
        suppliers.forEach(AbstractFactoryThread::start);
    }

    public void end() {
        suppliers.forEach(AbstractFactoryThread::end);
    }
}
