package dealers;

import parse.FactoryConfig;
import storages.Storages;
import thread.AbstractFactoryThread;
import view.Viewer;

public class Dealer extends AbstractFactoryThread {
    public Dealer(String name) {
        super(name);
    }

    @Override
    protected void doTask() {
        var storage = Storages.getCarStorage();
        storage.get();
        var viewer = Viewer.getInstance();
        viewer.updateDealersTotal();
    }

    @Override
    protected long getProcessTime() {
        return FactoryConfig.dealerProcess;
    }
}
