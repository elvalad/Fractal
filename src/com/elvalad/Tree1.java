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
    private Color color = new Color(43, 77, 219);

    public Tree1(double x, double y, double alpha, int depth, Color color) {
        this.x = x;
        this.y = y;
        this.alpha = alpha;
        this.depth = depth;
        this.color = color;
    }

    public void draw(Graphics g) {
        g.setColor(this.color);
        this.drawShape(g, this.x, this.y, this.alpha, this.depth);
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
}
