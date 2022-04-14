package thread;

public abstract class AbstractFactoryThread extends Thread {
    protected volatile boolean end = false;
    protected volatile boolean busy = false;
    protected abstract void doTask();

    @Override
    public void run() {
        while (!end) {
            busy = false;

            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (end) break;

            busy = true;
            doTask();
        }
    }

    public boolean isEnd() {
        return end;
    }

    public void setEnd(boolean end) {
        this.end = end;
    }

    public boolean isBusy() {
        return busy;
    }
}
