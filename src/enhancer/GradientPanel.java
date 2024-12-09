package enhancer;

import java.awt.*;
import javax.swing.*;

public class GradientPanel extends JPanel {
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g); // Call the superclass method

        // Cast Graphics to Graphics2D
        Graphics2D g2d = (Graphics2D) g;

        // Set the gradient colors
        Color startColor = new Color(27, 55, 77);  // Dark blue
        Color endColor = new Color(0, 72, 102);    // Slightly darker blue

        // Create the gradient paint (top to bottom)
        int width = getWidth();
        int height = getHeight();
        GradientPaint gradientPaint = new GradientPaint(
            0, 0, startColor, // Start point (top-left) and color
            0, height, endColor // End point (bottom-left) and color
        );

        // Apply the gradient paint
        g2d.setPaint(gradientPaint);
        g2d.fillRect(0, 0, width, height); // Fill the entire panel
    }
}
