package dealers;

import parse.FactoryConfig;
import storages.CarStorage;
import suppliers.accessories.AccessoriesSupplier;
import thread.AbstractFactoryThread;

import java.util.ArrayList;

public class Dealers {
    private final ArrayList<Dealer> dealers;
    private final int size;

    public Dealers() {
        size = FactoryConfig.dealers;
        dealers = new ArrayList<>(size);
    }

    public void start() {
        for (int i = 0; i < size; i++) {
            dealers.add(new Dealer("Dealer-" + i));
        }
        dealers.forEach(AbstractFactoryThread::start);
    }
}
