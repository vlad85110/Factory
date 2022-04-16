package view;

import parse.FactoryConfig;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class SuppliersListener implements ChangeListener {
    @Override
    public void stateChanged(ChangeEvent e) {
        var source = (JSlider) e.getSource();
        FactoryConfig.suppliersProcess = -source.getValue();
    }
}
