package storages;

import products.CarBody;
import products.Product;

import java.util.ArrayList;

public class CarBodyStorage extends AbstractStorage {
    private final ArrayList<CarBody> details;

    private CarBodyStorage(int size) {
        super(size);
        details = new ArrayList<>(size);
    }

    @Override
    protected void addDetail(Product detail) {
        details.add((CarBody) detail);
    }

    @Override
    protected Product getDetail() {
        return details.remove(size.intValue() - 1);
    }
}
