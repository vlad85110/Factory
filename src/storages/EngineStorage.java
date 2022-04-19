package storages;

import products.Product;
import products.Engine;

import java.util.ArrayList;

public class EngineStorage extends AbstractStorage {
    private final ArrayList<Engine> details;

    private EngineStorage(int size) {
        super(size);
        details = new ArrayList<>(size);
    }

    @Override
    protected void addDetail(Product detail) {
        details.add((Engine) detail);
    }

    @Override
    protected Product getDetail() {
        return details.remove(size.intValue() - 1);
    }
}
