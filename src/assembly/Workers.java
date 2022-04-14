package assembly;

import storages.AccessoriesStorage;
import storages.CarBodyStorage;
import storages.EngineStorage;
import storages.ProductStorage;

import java.util.ArrayList;

public class Workers {
    private final ArrayList<Worker> workers;

    public Workers(int size, AccessoriesStorage accessoriesStorage, CarBodyStorage carBodyStorage,
                   EngineStorage engineStorage, ProductStorage productStorage) {
        workers = new ArrayList<>(size);

        for (int i = 0; i < size; i++) {
            workers.add(new Worker(accessoriesStorage, carBodyStorage, engineStorage, productStorage));
        }
    }
}
