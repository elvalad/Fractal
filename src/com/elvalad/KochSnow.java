package com.elvalad;

import java.awt.*;

/**
 * Created by elvalad on 2014/12/29.
 */
public class KochSnow extends Koch {
    private double x1;
    private double y1;
    private double x2;
    private double y2;
    private double x3;
    private double y3;
    private Color color = new Color(43, 77, 219);

    /**
     * KochSnow曲线构造函数
     */
    public KochSnow() {
        super();
    }

    /**
     * KochSnow曲线构造函数
     * @param x1    KochSnow曲线初始三角形顶点1横坐标
     * @param y1    KochSnow曲线初始三角形顶点1纵坐标
     * @param x2    KochSnow曲线初始三角形顶点2横坐标
     * @param y2    KochSnow曲线初始三角形顶点2纵坐标
     * @param x3    KochSnow曲线初始三角形顶点3横坐标
     * @param y3    KochSnow曲线初始三角形顶点3纵坐标
     * @param color KochSnow曲线的颜色
     */
    public KochSnow(double x1, double y1, double x2, double y2, double x3, double y3, Color color) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
        this.x3 = x3;
        this.y3 = y3;
        this.color = color;
    }

    /**
     *
     * @param g
     */
    @Override
    public void draw(Graphics g) {
        g.setColor(this.color);
        super.drawShape(g, this.x1, this.y1, this.x2, this.y2);
        super.drawShape(g, this.x2, this.y2, this.x3, this.y3);
        super.drawShape(g, this.x3, this.y3, this.x1, this.y1);
    }
}
