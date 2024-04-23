package config;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;


public class customField extends JTextField{

    public customField() {
        setBackground(new Color(0,0,0,0));
        setBorder(new EmptyBorder(10, 10, 10, 10));
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D)g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(Color.white);
        g2.fillRoundRect(0, 0, getWidth(), getHeight(), getHeight(), getHeight());
        super.paintComponent(g);
    }
    
    
}

