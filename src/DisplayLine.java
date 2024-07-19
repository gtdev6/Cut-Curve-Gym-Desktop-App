import java.awt.*;
import java.awt.Graphics;

// import javax.swing.JFrame;
// import javax.swing.JLabel;
import javax.swing.JPanel;

public class DisplayLine extends JPanel{

    DisplayLine()
    {
        this.setSize(1200, 4);
        this.setVisible(true);
        this.setOpaque(false);
        

    }


    public void paint(Graphics g)
    { 
        Graphics2D g2d=(Graphics2D)g;
        g2d.setColor(new Color(235,207,47));
        g2d.setStroke(new BasicStroke(1));

        g2d.drawLine(0, 2, 1920, 2);
        // g2d.drawRect(100, 100, 200, 200);
    }
    
}