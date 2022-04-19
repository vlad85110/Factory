package storages;

import products.Accessories;
import products.Product;

import java.util.ArrayList;

public class AccessoriesStorage extends AbstractStorage {
    private final ArrayList<Accessories> details;

    private AccessoriesStorage(int size) {
        super(size);
        details = new ArrayList<>(size);
    }

    @Override
    protected void addDetail(Product detail) {
        details.add((Accessories) detail);
    }

    @Override
    protected Product getDetail() {
        return details.remove(size.intValue() - 1);
    }
}
