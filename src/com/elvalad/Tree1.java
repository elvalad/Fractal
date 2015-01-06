package com.elvalad;

import java.awt.*;

/**
 * Created by elvalad on 2015/1/4.
 */
public class Tree1 {
    private double x;
    private double y;
    private double alpha;
    private int depth;
    private double height;
    private Color color = new Color(43, 77, 219);

    public Tree1(double x, double y, double alpha, int depth, double height, Color color) {
        this.x = x;
        this.y = y;
        this.alpha = alpha;
        this.depth = depth;
        this.color = color;
        this.height = height;
    }

    public void draw(Graphics g) {
        g.setColor(this.color);
        //this.drawShape(g, this.x, this.y, this.alpha, this.depth);
        this.drawShape(g, this.x, this.y, this.alpha, this.depth, this.height);
    }

    private void drawShape(Graphics g, double x1, double y1, double angle, double depth) {
        if (depth == 0) {
        } else {
            double x2 = x1 + Math.cos(Math.toRadians(angle)) * depth * 15.0;
            double y2 = y1 + Math.sin(Math.toRadians(angle)) * depth * 15.0;

            Graphics2D g2d = (Graphics2D) g;
            g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,     RenderingHints.VALUE_ANTIALIAS_ON);
            g2d.setStroke(new BasicStroke((float) (0.5f * depth)));
            g.drawLine((int)x1, (int)y1, (int)x2, (int)y2);

            drawShape(g, x2, y2, angle + 25, depth - 1);
            drawShape(g, x2, y2, angle - 25, depth - 1);
        }
    }

    private void drawShape(Graphics g, double x1, double y1, double angle, double depth, double height) {
        if (depth == 0) {
        } else {
            double x2 = x1 + Math.cos(Math.toRadians(angle)) * depth * height;
            double y2 = y1 + Math.sin(Math.toRadians(angle)) * depth * height;
            double x3 = x1 + Math.cos(Math.toRadians(angle)) * depth * 2 * height;
            double y3 = y1 + Math.sin(Math.toRadians(angle)) * depth * 2 * height;
            Graphics2D g2d = (Graphics2D) g;
            g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,     RenderingHints.VALUE_ANTIALIAS_ON);
            g2d.setStroke(new BasicStroke((float) (0.2f * height)));
            g.drawLine((int)x1, (int)y1, (int)x2, (int)y2);
            g.drawLine((int)x2, (int)y2, (int)x3, (int)y3);

            drawShape(g, x2, y2, angle - 15, depth - 1, 0.6 * height);
            drawShape(g, x2, y2, angle + 15, depth - 1, 0.7 * height);
            drawShape(g, x3, y3, angle - 15, depth - 1, 0.6 * height);
            drawShape(g, x3, y3, angle + 15, depth - 1, 0.8 * height);
        }
    }
}
