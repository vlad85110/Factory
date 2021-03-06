package view;

import thread.Factory;

public interface Viewer {
    static Viewer getInstance() {
        return FactoryView.getInstance();
    }

    void updateDetailStorage(String text, Object obj);

    void updateCarStorage(String text);

    void updateDealersTotal();

    void connect(Factory factory);
}
