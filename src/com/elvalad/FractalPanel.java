package com.elvalad;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Administrator on 2014/12/27.
 */
public class FractalPanel extends JPanel {
    private Color color = new Color(43, 77, 219);
    private Cantor cantor = new Cantor(100, 100, 800, 100, this.color);
    private Koch koch = new Koch(100, 100, 800, 100, this.color);
    private KochSnow kochSnow = new KochSnow(200, 250, 800, 250, 500, 250 - 600 * Math.sin(Math.PI / 3), this.color);
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
            case KOCH: {
                this.drawKoch(g);
                break;
            }
            case KOCHSNOW: {
                this.drawKochSnow(g);
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

    private void drawKoch(Graphics g) {
        this.koch.draw(g);
    }

    private void drawKochSnow(Graphics g) {
        this.kochSnow.draw(g);
    }
}
