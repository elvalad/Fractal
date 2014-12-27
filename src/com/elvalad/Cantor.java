package com.elvalad;

import java.awt.*;

/**
 * Created by Administrator on 2014/12/27.
 */
public class Cantor {
    private double x1;
    private double y1;
    private double x2;
    private double y2;
    private Color color = new Color(108, 187, 219);

    /**
     * Cantor的构造函数
     * @param x1 Cantor起始点的横坐标
     * @param y1 Cantor起始点的纵坐标
     * @param x2 Cantor终止点的横坐标
     * @param y2 Cantor终止点的纵坐标
     */
    public Cantor(int x1, int y1, int x2, int y2, Color color) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
        this.color = color;
    }

    /**
     *
     * @param
     */
    public void draw(Graphics g) {
        g.setColor(this.color);
        this.drawShape(g, this.x1, this.y1, this.x2, this.y2);
    }

    /**
     *
     * @param g
     * @param x1
     * @param y1
     * @param x2
     * @param y2
     */
    private void drawShape(Graphics g, double x1, double y1, double x2, double y2) {
        g.setColor(this.color);
        double c = 1.0;
        if ((x2 - x1) < c) {
            g.drawLine((int)x1, (int)y1, (int)x2, (int)y2);
        } else {
            double x3 = 0;
            double y3 = 0;
            double x4 = 0;
            double y4 = 0;

            g.drawLine((int)x1, (int)y1, (int)x2, (int)y2);
            x3 = x1 + (x2 - x1) / 3;
            y3 = y1 + 50;
            x4 = x2 - (x2 - x1) / 3;
            y4 = y2 + 50;
            y1 = y1 + 50;
            y2 = y2 + 50;

            drawShape(g, x1, y1, x3, y3);
            drawShape(g, x4, y4, x2, y2);
        }
    }
}
