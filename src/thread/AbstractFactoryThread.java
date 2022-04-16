package thread;

import java.util.concurrent.TimeUnit;

public abstract class AbstractFactoryThread extends Thread {
    protected volatile boolean end = false;
    protected volatile boolean busy = false;

    public AbstractFactoryThread(String name) {
        super(name);
    }

    @Override
    public void run() {
        while (!end) {
            busy = true;

            try {
                TimeUnit.MILLISECONDS.sleep(getProcessTime());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            doTask();
            busy = false;
        }
    }

    protected abstract void doTask();

    protected abstract long getProcessTime();

    public boolean isEnd() {
        return end;
    }

    public void end() {
        this.end = true;
    }

    public boolean isBusy() {
        return busy;
    }
}
