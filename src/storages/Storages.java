package storages;

import parse.FactoryConfig;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

//todo suppliers in storages

public class Storages {
    private static volatile AccessoriesStorage accessoriesStorage;
    private static volatile CarBodyStorage carBodyStorage;
    private static volatile EngineStorage engineStorage;
    private static volatile ProductStorage productStorage;

    public static AccessoriesStorage getAccessoriesStorage() {
        return (AccessoriesStorage)getInstance(accessoriesStorage.getClass(), FactoryConfig.storageAccessorySize);
    }

    public static CarBodyStorage getCarBodyStorage() {
        return (CarBodyStorage)getInstance(carBodyStorage.getClass(), FactoryConfig.storageCarSize);
    }

    public static EngineStorage getEngineStorage() {
        return (EngineStorage)getInstance(engineStorage.getClass(), FactoryConfig.storageEngineSize);
    }

    public static ProductStorage getProductStorage() {
        return (ProductStorage)getInstance(productStorage.getClass(), FactoryConfig.storageCarSize);
    }

    private static AbstractStorage getInstance(Class<?> product, int num) {
        Field field = null;
        try {
            field = Storages.class.getField(product.getName());
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
        assert field != null;

        Object localInstance = null;
        try {
            localInstance = field.get(null);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        if (localInstance == null) {
            synchronized (Storages.class) {
                try {
                    localInstance = field.get(null);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }

                if (localInstance == null) {
                    try {
                        localInstance = product.getConstructor(int.class).newInstance(num);
                    } catch (InstantiationException | NoSuchMethodException | InvocationTargetException |
                            IllegalAccessException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        return (AbstractStorage)localInstance;
    }
}
