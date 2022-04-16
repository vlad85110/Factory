package view;

import parse.FactoryConfig;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class WorkersListener implements ChangeListener {
    @Override
    public void stateChanged(ChangeEvent e) {
        var source = (JSlider) e.getSource();
        FactoryConfig.workerProcess = -source.getValue();
    }
}
