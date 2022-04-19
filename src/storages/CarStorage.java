package storages;

import assembly.ProductController;
import products.Car;
import products.Product;

import java.util.ArrayList;

public class CarStorage extends AbstractStorage {
    private final ArrayList<Car> cars;
    private final ProductController controller;
    private Long total = 0L;

    private CarStorage(int size) {
        super(size);
        cars = new ArrayList<>(size);
        controller = ProductController.getInstance();
    }

    @Override
    public synchronized Product get() {
        while (isVoid()) {
            controller.notifyController();
            notifyAdd();
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println(Thread.currentThread().getName());

        var detail = getDetail();
        size.decrementAndGet();
        viewer.updateDetailStorage(size.toString(), this);
        notifyAll();
        return detail;
    }

    @Override
    protected void addDetail(Product detail) {
        cars.add((Car) detail);
        total++;
        viewer.updateCarStorage(total.toString());
    }

    @Override
    protected Product getDetail() {
        return cars.remove(size.intValue() - 1);
    }

    public int getFreePlace() {
        return maxSize - size.intValue();
    }
}
