import java.awt.Color;
// import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GradientPaint;
// import java.awt.LinearGradientPaint;
// import java.awt.Paint;
import java.awt.RenderingHints;
import javax.swing.*;


public class GradientText extends JPanel {
    // private static final int PREF_W = 800;
    // private static final int PREF_H = 500;
    private int size,x1,x2,y1,y2;
    private Font FONT;
    private static final String TEXT = "Cut & Curve";
    private static final String TEXT1 = "Gym";
    boolean construct1=false,construct2=false,construct3=false;
    // private static final int COLOR_COUNT = 30;
    // private static final Color BG = Color.BLACK;
    // private Paint myPaint;

    public GradientText()
    {
        this.setOpaque(false);
        this.construct1=true;
    }

    public GradientText(int size) {
        // setPreferredSize(new Dimension(PREF_W, PREF_H));
        // float[] fractions = new float[2];
        // Color[] colors = new Color[2];
        // // for (int i = 0; i < colors.length; i++) {
        // //     fractions[i] = ((float)i) / COLOR_COUNT;
        // //     float hue = fractions[i];
        // //     colors[i] = Color.getHSBColor(hue, 1f, 1f);
         
        // // }
        // fractions[0]=0.00008f;
        // fractions[1]=0.5f;
        // // fractions[2]=0.06666f;
        // colors[0]=Color.yellow;
        // colors[1]=Color.black;
        // myPaint = new LinearGradientPaint(0, 0, 300,400, fractions, colors);
        // this.setBackground(BG);
        this.size=size;
        this.construct3=true;
        this.setOpaque(false);

    }
    public GradientText(int size,int x1,int y1,int x2,int y2)
    {
        this.size=size;
        this.x1=x1;
        this.y1=y1;
        this.x2=x2;
        this.y2=y2;
        this.setOpaque(false);
        this.construct2=true;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
        GradientPaint gb=new GradientPaint(0, 5, new Color(235,247,0), 5, 0, new Color(235,151,0), true);

        g2.setPaint(gb);
        if(construct1)
        {
            g2.setFont(new Font("Colonna MT", Font.PLAIN, 52));
            g2.drawString(TEXT, 0, 40);
            g2.drawString(TEXT1, 80, 70);
        }
        if(construct2)
        {
            FONT = new Font("Colonna MT", Font.PLAIN, size);
            g2.setFont(FONT);
            g2.drawString(TEXT, x1, y1);
            g2.drawString(TEXT1, x2, y2);
        }
        if(construct3){
            FONT = new Font("Colonna MT", Font.PLAIN, size);
            g2.setFont(FONT);
            g2.drawString(TEXT, 0, 40);
            g2.drawString(TEXT1, 80, 70);
        }

    }

    public void repaintlbl(){
        super.repaint();
    }

    // private static void createAndShowGui() {
    //     GradientText mainPanel = new GradientText();
    //     mainPanel.setBounds(0, 0, 265, 100);
    //     // mainPanel.setBackground(Color.BLACK);

    //     JFrame frame = new JFrame("GradientText");
    //     frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    //     frame.setLayout(null);
    //     frame.setMinimumSize(new Dimension(265,100));
    //     frame.getContentPane().add(mainPanel);
    //     frame.setUndecorated(true);
    //     frame.setLocationRelativeTo(null);
    //     frame.setVisible(true);
    // }

    // public static void main(String[] args) {
    //     SwingUtilities.invokeLater(() -> createAndShowGui());
    // }
}