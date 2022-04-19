package storages;

import products.Product;
import view.Viewer;

import java.util.concurrent.atomic.AtomicInteger;

public abstract class AbstractStorage {
    protected AtomicInteger size;
    protected final int maxSize;
    protected final Viewer viewer;

    protected AbstractStorage(Integer size) {
        this.viewer = Viewer.getInstance();
        this.size = new AtomicInteger(0);
        this.maxSize = size;
    }

    public synchronized void add(Product detail) {
        while (isFull()) {
            notifyGet();
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        addDetail(detail);
        size.incrementAndGet();
        viewer.updateDetailStorage(size.toString(), this);
        notifyGet();
    }

    public synchronized Product get() {
        while (isVoid()) {
            notifyAdd();
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        var detail = getDetail();
        size.decrementAndGet();
        viewer.updateDetailStorage(size.toString(), this);
        notifyAdd();
        return detail;
    }

    protected void notifyAdd() {
        notify();
    }

    protected void notifyGet() {
        notify();
    }

    public boolean isFull() {
        return size.intValue() >= maxSize;
    }

    public boolean isVoid() {
        return size.intValue() == 0;
    }

    protected abstract void addDetail(Product detail);

    protected abstract Product getDetail();
}
