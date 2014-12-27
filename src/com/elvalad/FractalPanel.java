package com.elvalad;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Administrator on 2014/12/27.
 */
public class FractalPanel extends JPanel {
    private Cantor cantor = new Cantor(100, 100, 800, 100, new Color(108, 187, 219));
    private ShapeStyle style;

    public FractalPanel() {
        this.style = ShapeStyle.BLANK;
    }

    public void setPaintStype(ShapeStyle s) {
        this.style = s;
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        switch (this.style) {
            case CANTOR: {
                this.drawCantor(g);
                break;
            }
            case BLANK: {
                break;
            }
        }
    }

    private void drawCantor(Graphics g) {
        this.cantor.draw(g);
    }
}
