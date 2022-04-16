package storages;

import parse.FactoryConfig;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public class Storages {
    private static volatile AccessoriesStorage accessoriesStorage;
    private static volatile CarBodyStorage carBodyStorage;
    private static volatile EngineStorage engineStorage;
    private static volatile CarStorage carStorage;

    private static final Field[] fields = Storages.class.getDeclaredFields();

    public static AccessoriesStorage getAccessoriesStorage() {
        return (AccessoriesStorage) getInstance(accessoriesStorage, AccessoriesStorage.class,
                FactoryConfig.storageAccessorySize);
    }

    public static CarBodyStorage getCarBodyStorage() {
        return (CarBodyStorage) getInstance(carBodyStorage, CarBodyStorage.class, FactoryConfig.storageBodySize);
    }

    public static EngineStorage getEngineStorage() {
        return (EngineStorage) getInstance(engineStorage, EngineStorage.class, FactoryConfig.storageEngineSize);
    }

    public static CarStorage getCarStorage() {
        return (CarStorage) getInstance(carStorage, CarStorage.class, FactoryConfig.storageCarSize);
    }

    private static AbstractStorage getInstance(AbstractStorage storage,
                                               Class<? extends AbstractStorage> product, int num) {

        var field = getFieldOfType(product);
        assert field != null;

        AbstractStorage localInstance = null;
        try {
            localInstance = (AbstractStorage)field.get(null);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        if (localInstance == null) {
            synchronized (Storages.class) {
                try {
                    localInstance = (AbstractStorage)field.get(null);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }

                if (localInstance == null) {
                    try {
                        var constructor = product.getDeclaredConstructor(int.class);
                        constructor.setAccessible(true);
                        localInstance = constructor.newInstance(num);
                        field.set(null, localInstance);
                    } catch (InstantiationException | NoSuchMethodException | InvocationTargetException |
                            IllegalAccessException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        return localInstance;
    }

    private static Field getFieldOfType(Class<?> searchType) {
        for (var f : fields) {
            if(f.getType().equals(searchType)) {
                return f;
            }
        }
        return null;
    }
}
