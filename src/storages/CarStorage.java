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
    public synchronized void add(Product detail) {
        while (isFull()) {
            notify();
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        addDetail(detail);
        size.incrementAndGet();
        viewer.updateDetailStorage(size.toString(), this);
        notifyAll();
    }

    @Override
    public synchronized Product get() {
        while (isVoid()) {
            controller.notifyController();
            notify();
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

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
        return cars.get(size.intValue() - 1);
    }

    public int getFreePlace() {
        return maxSize - size.intValue();
    }
}
