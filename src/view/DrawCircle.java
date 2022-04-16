package view;

import javax.swing.*;
import java.awt.*;

public class DrawCircle extends JPanel {
    @Override
    public void paint(Graphics g) {
        g.drawOval(50,50, 15, 15);
    }
}
