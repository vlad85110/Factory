package suppliers;

import parse.FactoryConfig;
import thread.AbstractFactoryThread;

public abstract class AbstractSupplier extends AbstractFactoryThread {
    public AbstractSupplier(String name) {
        super(name);
    }

    @Override
    protected void doTask() {
        createDetail();
    }

    @Override
    protected long getProcessTime() {
        return FactoryConfig.suppliersProcess;
    }

    protected abstract void createDetail();
}
