package assembly;

import storages.AccessoriesStorage;
import storages.CarBodyStorage;
import storages.EngineStorage;
import storages.ProductStorage;

public class Worker {
    private final AccessoriesStorage accessoriesStorage;
    private final CarBodyStorage carBodyStorage;
    private final EngineStorage engineStorage;
    private final ProductStorage productStorage;

    public Worker(AccessoriesStorage accessoriesStorage, CarBodyStorage carBodyStorage,
                  EngineStorage engineStorage, ProductStorage productStorage) {
        this.accessoriesStorage = accessoriesStorage;
        this.carBodyStorage = carBodyStorage;
        this.engineStorage = engineStorage;
        this.productStorage = productStorage;
    }
}
