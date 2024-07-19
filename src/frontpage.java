import java.awt.Color;
import java.awt.Dimension;
import java.awt.*;
import java.awt.image.*;
import java.io.IOException;
import java.util.Objects;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
// import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.SwingConstants;
import javax.swing.border.Border;



public class frontpage {

    BufferedImage backimg;
    JLabel motiv0,motiv1,motiv1_1,motiv2,motiv3,motiv3_1,motiv4,motiv4_1,motiv5,motiv6;

    JFrame firstframe;
    GiveGradientpanelstart panel1,panel2,signaturelbl;
    JLabel backlabel,logolbl,labelprogress,lbldisignedby;
    Border line=BorderFactory.createEmptyBorder(5, 5, 0, 5);
    Border b1=BorderFactory.createLineBorder((new Color(235,207,47)), 1);
    private JProgressBar bar1;


    frontpage(){
        try {
            backimg=ImageIO.read(Objects.requireNonNull(getClass().getResource("icons/frontback.png")));
        } catch (IOException e) {
            e.printStackTrace();
        }



        signaturelbl=new GiveGradientpanelstart(new Font("Edwardian Script ITC",0,20), "Ghulam Tahir", 10, 20, 0, 5, 5, 0);
        signaturelbl.setBounds(90, 390, 150, 40);

        
        bar1=new JProgressBar(SwingConstants.HORIZONTAL,0,100);
        bar1.setValue(0);
        bar1.setBounds(0,420,900,5);
        // bar1.setBackground(new Color(235,207,47));
        bar1.setBackground(Color.black);
        bar1.setForeground(new Color(255,66,0));
        bar1.setVisible(true);


        
        labelprogress=new JLabel();
        labelprogress.setBounds(405,390,80,50);
        labelprogress.setText(bar1.getValue()+"%");
        labelprogress.setFont(new Font("Gabriola",0,24));
        labelprogress.setForeground(new Color(235,207,47));
        labelprogress.setOpaque(false);

        lbldisignedby=new JLabel("Developed By ");
        lbldisignedby.setFont(new Font("Century Gothic",0,12));
        lbldisignedby.setBounds(10, 395, 100, 20);
        lbldisignedby.setForeground(Color.darkGray);
        lbldisignedby.setOpaque(false);
        lbldisignedby.setVisible(true);

        motiv0=new JLabel();
        motiv0.setIcon(new ImageIcon(new ImageIcon(Objects.requireNonNull(getClass().getResource("icons/HazratAliQuote.png"))).getImage().getScaledInstance(300, 150, Image.SCALE_SMOOTH)));
        motiv0.setBounds(550, 190, 350, 200);
        motiv0.setOpaque(false);
        motiv0.setVisible(false);


        motiv1=new JLabel();
        motiv1.setIcon(new ImageIcon(new ImageIcon(Objects.requireNonNull(getClass().getResource("icons/mot1.png"))).getImage().getScaledInstance(230, 150, Image.SCALE_SMOOTH)));
        motiv1.setBounds(600, 250, 260, 175);
        motiv1.setOpaque(false);
        motiv1.setVisible(false);

        motiv1_1=new JLabel();
        motiv1_1.setIcon(new ImageIcon(new ImageIcon(Objects.requireNonNull(getClass().getResource("icons/Boyka1.png"))).getImage().getScaledInstance(150, 240, Image.SCALE_SMOOTH)));
        motiv1_1.setBounds(640, 10, 200, 260);
        motiv1_1.setOpaque(false);
        motiv1_1.setVisible(false);

        motiv2=new JLabel();
        motiv2.setIcon(new ImageIcon(new ImageIcon(Objects.requireNonNull(getClass().getResource("icons/mot2.png"))).getImage().getScaledInstance(230, 320, Image.SCALE_SMOOTH)));
        motiv2.setBounds(600, 50, 260, 320);
        motiv2.setOpaque(false);
        motiv2.setVisible(false);

        motiv3=new JLabel();
        motiv3.setIcon(new ImageIcon(new ImageIcon(Objects.requireNonNull(getClass().getResource("icons/mot3.png"))).getImage().getScaledInstance(320, 120, Image.SCALE_SMOOTH)));
        motiv3.setBounds(550, 250, 320, 120);
        motiv3.setOpaque(false);
        motiv3.setVisible(false);

        motiv3_1=new JLabel();
        motiv3_1.setIcon(new ImageIcon(new ImageIcon(Objects.requireNonNull(getClass().getResource("icons/ALI.png"))).getImage().getScaledInstance(320, 250, Image.SCALE_SMOOTH)));
        motiv3_1.setBounds(550, 20, 320, 250);
        motiv3_1.setOpaque(false);
        motiv3_1.setVisible(false);

        motiv4=new JLabel();
        motiv4.setIcon(new ImageIcon(new ImageIcon(Objects.requireNonNull(getClass().getResource("icons/brucelee.png"))).getImage().getScaledInstance(240, 200, Image.SCALE_SMOOTH)));
        motiv4.setBounds(600, 5, 320, 250);
        motiv4.setOpaque(false);
        motiv4.setVisible(false);

        motiv4_1=new JLabel();
        motiv4_1.setIcon(new ImageIcon(new ImageIcon(Objects.requireNonNull(getClass().getResource("icons/bruceleequote.png"))).getImage().getScaledInstance(250, 200, Image.SCALE_SMOOTH)));
        motiv4_1.setBounds(600, 200, 250, 200);
        motiv4_1.setOpaque(false);
        motiv4_1.setVisible(false);

        motiv5=new JLabel();
        motiv5.setIcon(new ImageIcon(new ImageIcon(Objects.requireNonNull(getClass().getResource("icons/bodyAsset 5.png"))).getImage().getScaledInstance(250, 250, Image.SCALE_SMOOTH)));
        motiv5.setBounds(600, 70, 250, 250);
        motiv5.setOpaque(false);
        motiv5.setVisible(false);

        motiv6=new JLabel();
        motiv6.setIcon(new ImageIcon(new ImageIcon(Objects.requireNonNull(getClass().getResource("icons/motiv6.png"))).getImage().getScaledInstance(281, 300, Image.SCALE_SMOOTH)));
        motiv6.setBounds(600, 70, 281, 300);
        motiv6.setOpaque(false);
        motiv6.setVisible(false);


        logolbl=new JLabel();
        logolbl.setIcon(new ImageIcon(new ImageIcon(Objects.requireNonNull(getClass().getResource("icons/Asset1.png"))).getImage().getScaledInstance(260, 190, Image.SCALE_SMOOTH)));
        logolbl.setBounds(110, 20, 260, 200);
        logolbl.setOpaque(false);


        panel1=new GiveGradientpanelstart(new Font("Gabriola",0,120), "Cut & Curve", 10, 70, 0, 5, 5, 0);
        panel1.setBounds(20, 210, 500, 200);
        panel2=new GiveGradientpanelstart(new Font("Gabriola",0,120), "Gym", 10, 70, 0, 5, 5, 0);
        panel2.setBounds(140, 290, 400, 200);

       

        backlabel=new JLabel(){

            public void paintComponent(Graphics g) {
                g.drawImage(backimg, 0, 0,900,500, null);
            }

        };

        backlabel.setBounds(0, 0, 900, 432);
        backlabel.setBorder(b1);
        backlabel.setBackground(new Color(20,20,20));
        backlabel.setOpaque(true);



        firstframe=new JFrame("Cut & Curve Gym");
        firstframe.setLayout(null);
        firstframe.setSize(900, 432);
        firstframe.setUndecorated(true);
        firstframe.setResizable(false);
        firstframe.setAlwaysOnTop(true);
        firstframe.setMinimumSize(new Dimension(768, 432));
        firstframe.setLocationRelativeTo(null);
//        firstframe.setIconImage(new ImageIcon(Objects.requireNonNull(getClass().getResource("icons/Imagetop.png"))).getImage());
        firstframe.setIconImage(new ImageIcon(getClass().getResource("icons/256x256.png")).getImage().getScaledInstance(32, 32, Image.SCALE_SMOOTH));
        firstframe.add(signaturelbl);
        firstframe.add(lbldisignedby);
        firstframe.add(motiv4_1);
        firstframe.add(motiv6);
        firstframe.add(motiv5);
        firstframe.add(motiv4);
        firstframe.add(motiv3_1);
        firstframe.add(motiv3);
        firstframe.add(motiv2);
        firstframe.add(motiv1_1);
        firstframe.add(motiv1);
        firstframe.add(motiv0);
        firstframe.add(bar1);
        firstframe.add(labelprogress);
        firstframe.add(logolbl);
        firstframe.add(panel1);
        firstframe.add(panel2);
        firstframe.add(backlabel);
        firstframe.setVisible(true);

        
    }


    public boolean fill()
    {
        boolean value=false;
        int counter=0;
        while(counter<=100)
        {
            bar1.setValue(counter);
            labelprogress.setText(bar1.getValue()+" %");
            if(counter>=0&&counter<10){
                motiv0.setVisible(true);
            }
            else{
                motiv0.setVisible(false);
            }
            if(counter>=10&&counter<20){
                motiv2.setVisible(true);
            }
            else{
                motiv2.setVisible(false);
            }
            if(counter>20&&counter<30){
                motiv1.setVisible(true);
                motiv1_1.setVisible(true);
            }
            else{
                motiv1.setVisible(false);
                motiv1_1.setVisible(false);
            }
            if(counter>30&&counter<50){
                motiv3_1.setVisible(true);
                motiv3.setVisible(true);
            }
            else{
                motiv3_1.setVisible(false);
                motiv3.setVisible(false);
            }
            if(counter>50&&counter<70){
                motiv4_1.setVisible(true);
                motiv4.setVisible(true);
            }
            else{
                motiv4_1.setVisible(false);
                motiv4.setVisible(false);
            }
            if(counter>70&&counter<90){
                motiv5.setVisible(true);
            }
            else{
                motiv5.setVisible(false);
            }
            if(counter>90&&counter<100){
                motiv6.setVisible(true);
            }
            else{
                motiv6.setVisible(false);
            }
            if(counter==100){
                try {
                    Thread.sleep(10);
                    value=true;

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            
            try {
                Thread.sleep(150);
            } catch (Exception e) {
                
            e.printStackTrace();
            }
            counter+=1;
        }
    
        return value;
    
    }
    
}
