package storages;

import java.util.concurrent.atomic.AtomicInteger;

public abstract class AbstractStorage {
    protected AtomicInteger size;
    protected AtomicInteger maxSize;

    protected AbstractStorage(Integer size) {
        this.size = new AtomicInteger(0);
        this.maxSize = new AtomicInteger(size);
    }

    public void add() {
        this.size.updateAndGet(operand -> operand++);
    }

    public boolean isFull () {
        return size.equals(maxSize);
    }
}
