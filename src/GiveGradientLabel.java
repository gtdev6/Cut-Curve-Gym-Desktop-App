import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GradientPaint;
import java.awt.RenderingHints;
import javax.swing.*;


public class GiveGradientLabel extends JPanel {
    Font fontmain;
    String text,text1;
    int X,Y;
    boolean noconstructor=false;
    boolean constructor=false;
    boolean constructor2=false;
    boolean constructor3=false;
    Color c1=new Color(235,247,0);
    Color c2=new Color(235,151,0);

    GiveGradientLabel(Font font,String Text)
    {
        this.fontmain=font;
        this.text=Text;
        this.noconstructor=true;
        this.setOpaque(false);
    }
    GiveGradientLabel(Font font,String Text,int x,int y,Color w1,Color w2)
    {
        this.fontmain=font;
        this.text=Text;
        constructor=true;
        this.c1=w1;
        this.c2=w2;
        this.X=x;
        this.Y=y;
        this.setOpaque(false);
    }
    GiveGradientLabel(Font font,String Text,int x,int y)
    {
        this.fontmain=font;
        this.text=Text;
        constructor2=true;
        this.X=x;
        this.Y=y;
        this.setOpaque(false);
    }

    GiveGradientLabel(Font font,String Text,String Text2,int x,int y)
    {
        this.fontmain=font;
        this.text=Text;
        this.text1=Text2;
        constructor3=true;
        this.X=x;
        this.Y=y;
        this.setOpaque(false);
    }

    protected void paintComponent(Graphics g)
    {
        super.paintComponent(g);

        Graphics2D g2d=(Graphics2D)g;
        g2d.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
        GradientPaint g2=new GradientPaint(0, 5, c1, 5, 0, c2, true);
        g2d.setFont(this.fontmain);
        g2d.setPaint(g2);
        if(noconstructor)
        {
            g2d.drawString(this.text,10,25);
        }
        if(constructor)
        {
            g2d.drawString(this.text,X,Y);
        }
        if(constructor2)
        {
            g2d.drawString(this.text,X,Y);
        }
        if(this.text1!=null)
        {
            g2d.drawString(this.text1,X,Y);
        }

    }


    
}
