package Test;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Point2D;

class GradientPanel extends JPanel {
    private Color color1;
    private Color color2;

    public GradientPanel(Color color1, Color color2) {
        this.color1 = color1;
        this.color2 = color2;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        // Set up a gradient paint with 45-degree direction
        int width = getWidth();
        int height = getHeight();
        Point2D start = new Point2D.Float(0, 0);
        Point2D end = new Point2D.Float(width, height);

        LinearGradientPaint gradientPaint = new LinearGradientPaint(start, end,
                new float[] {0f, 1f}, new Color[] {color1, color2});

        g2d.setPaint(gradientPaint);
        g2d.fillRect(0, 0, width, height);
    }
}
