package view;

import storages.*;

import javax.swing.*;

public class FactoryView extends JFrame implements Viewer {
    private static volatile FactoryView instance;
    private JPanel main;
    private JLabel accessoriesStorage;
    private JPanel storages;
    private JLabel engineStorage;
    private JLabel carBodyStorage;
    private JPanel assembly;
    private JLabel carStorage;
    private JLabel carsTotal;
    private JLabel waiting;
    private JSlider workerSlider;
    private JSlider suppliersSlider;
    private JPanel dealers;
    private JLabel dealersTotal;
    private JSlider dealersSlider;

    public static FactoryView getInstance() {
        FactoryView localInstance = instance;
        if (localInstance == null) {
            synchronized (FactoryView.class) {
                localInstance = instance;
                if (localInstance == null) {
                    instance = localInstance = new FactoryView();
                }
            }
        }
        return localInstance;
    }

    public FactoryView() {
        super("Car factory");
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(700,300);
        Location.centreWindow(this);
        setContentPane(main);
        suppliersSlider.addChangeListener(new SuppliersListener());
        workerSlider.addChangeListener(new WorkersListener());
    }

    @Override
    public void updateDetailStorage(String text, Object obj) {
        if (obj instanceof AccessoriesStorage) accessoriesStorage.setText(text);
        if (obj instanceof EngineStorage) engineStorage.setText(text);
        if (obj instanceof CarBodyStorage) carBodyStorage.setText(text);
        if (obj instanceof CarStorage) carStorage.setText(text);
    }

    @Override
    public void updateCarStorage(String text) {
        carsTotal.setText(text);
    }

    @Override
    public synchronized void updateDealersTotal() {
        var prev = Long.parseLong(dealersTotal.getText());
        var current = prev + 1;
        dealersTotal.setText(String.valueOf(current));
    }
}
