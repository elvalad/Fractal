package com.elvalad;

import java.awt.*;

/**
 * Created by elvalad on 2014/12/28.
 */
public class Koch {
    private double x1;
    private double y1;
    private double x2;
    private double y2;
    private Color color = new Color(43, 77, 219);

    /**
     * Koch曲线构造函数
     * @param x1 Koch曲线起始点横坐标
     * @param y1 Koch曲线起始点纵坐标
     * @param x2 Koch曲线终止点横坐标
     * @param y2 Koch曲线终止点纵坐标
     * @param color Koch曲线的颜色
     */
    public Koch(double x1, double y1, double x2, double y2, Color color) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
        this.color = color;
    }

    /**
     * @param g
     */
    public void draw(Graphics g) {
        g.setColor(this.color);
        this.drawShape(g, this.x1, this.y1, this.x2, this.y2);
    }

    /**
     *
     * @param g
     * @param x1 Koch曲线起始点横坐标
     * @param y1 Koch曲线起始点纵坐标
     * @param x2 Koch曲线终止点横坐标
     * @param y2 Koch曲线终止点纵坐标
     */
    private void drawShape(Graphics g, double x1, double y1, double x2, double y2) {
        double c = 1.0;
        double x3 = 0;
        double y3 = 0;
        double x4 = 0;
        double y4 = 0;
        double x5 = 0;
        double y5 = 0;
        double l = 0;
        double alpha = 0;
        g.setColor(this.color);
        if (((x2 - x1)*(x2 - x1) + (y2 - y1)*(y2 - y2)) < c) {
            g.drawLine((int)x1, 500 - (int)y1, (int)x2, 500 - (int)y2);
        } else {
            x3 = x1 + (x2 - x1) / 3;
            y3 = y1 + (y2 - y1) / 3;
            x4 = x2 - (x2 - x1) / 3;
            y4 = y2 - (y2 - y1) / 3;
            l = Math.sqrt(((y2 - y1)*(y2 - y1) + (x2 - x1)*(x2 - x1))) / 3;
            alpha = Math.atan((y4 - y3) / (x4 - x3));
            if ((alpha >= 0) && (x4 - x3) < 0 ||
                    (alpha <= 0) && (x4 - x3 < 0)) {
                alpha = alpha + Math.PI;
            }
            x5 = x3 + Math.cos(alpha + Math.PI / 3)*l;
            y5 = y3 + Math.sin(alpha + Math.PI / 3)*l;
            drawShape(g, x1, y1, x3, y3);
            drawShape(g, x3, y3, x5, y5);
            drawShape(g, x5, y5, x4, y4);
            drawShape(g, x4, y4, x2, y2);
        }
    }
}
