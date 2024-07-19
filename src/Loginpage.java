
import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.Border;


import java.awt.*;
import java.awt.image.*;
import java.io.IOException;
// import java.awt.KeyEvent.*;
import java.awt.event.*;



public class Loginpage extends databasesqlite implements ActionListener, KeyListener{
    String usernamestrg,passwordstrg;

    JFrame loginframe;
    JLabel backlbl;
    JTextField userNamField;
    JPasswordField passworField;
    JLabel userNamelbl,passwordlbl,toplogolbl;
    JButton loginbtn,exitbtn,hide,visible;
    Border border=BorderFactory.createEmptyBorder();
    Border line=BorderFactory.createEmptyBorder(5, 5, 0, 5);
    Border b1=BorderFactory.createLineBorder((new Color(235,207,47)), 2);
    Border c1=BorderFactory.createCompoundBorder(line, b1);
    private GiveGradientpanelstart gradientlbl,gradientlbl1,toplbl;
    JPanel container,loginlblcon;
    protected LoginUser loginuer;
    protected boolean loginvalue;
    BufferedImage loginbackimg;
    Border a4=BorderFactory.createMatteBorder(1, 1, 0, 1, new Color(235,207,47));
    Loginpage()
    {
        super();
        try {
            loginbackimg=ImageIO.read(getClass().getResource("icons/loginback.png"));
        } catch (IOException e) {
            showerror(e);
        }

        toplogolbl=new JLabel();
        toplogolbl.setBounds(150, 15, 186, 148);
        toplogolbl.setIcon(new ImageIcon(new ImageIcon(getClass().getResource("icons/Asset1.png")).getImage().getScaledInstance(186, 130, Image.SCALE_SMOOTH)));

        toplogolbl.setOpaque(false);

        toplogolbl.setVisible(true);

        toplbl=new GiveGradientpanelstart(new Font("Gabriola",0,40), "Login", 20, 30, 0, 5, 5, 0);
        toplbl.setBounds(0, 0, 120, 45);
        toplbl.setVisible(true);

        gradientlbl=new GiveGradientpanelstart(new Font("Colonna MT",0,60), "Cut & Curve", 0, 45, 0, 5, 5, 0);
        gradientlbl.setBounds(100, 140, 320, 100);

        gradientlbl1=new GiveGradientpanelstart(new Font("Colonna MT",0,60), "Gym", 0, 45, 0, 5, 5, 0);
        gradientlbl1.setBounds(180, 180, 250, 100);

        visible=new JButton();
        visible.setBounds(415, 165, 30, 30);
        visible.setIcon(new ImageIcon(new ImageIcon(getClass().getResource("icons/visible_2.png")).getImage().getScaledInstance(24, 24, Image.SCALE_SMOOTH)));
        visible.setContentAreaFilled(false);
        visible.setMnemonic('V');
        visible.setBorder(border);
        visible.setFocusable(false);
        visible.addActionListener(this);
        visible.setVisible(true);

        hide=new JButton();
        hide.setBounds(415, 165, 30, 30);
        hide.setIcon(new ImageIcon(new ImageIcon(getClass().getResource("icons/hide12.png")).getImage().getScaledInstance(30, 20, Image.SCALE_SMOOTH)));
        hide.setContentAreaFilled(false);
        hide.setBorder(border);
        hide.setMnemonic('H');
        hide.setFocusable(false);
        hide.addActionListener(this);
        hide.setVisible(false);

        loginlblcon=new JPanel();
        loginlblcon.setBounds(210, 275, 120, 45);
        loginlblcon.setLayout(new BorderLayout());
        loginlblcon.add(toplbl);
        loginlblcon.setBackground(new Color(20,20,20));
        loginlblcon.setBorder(a4);
        loginlblcon.setOpaque(true);


        exitbtn=new JButton();
        exitbtn.setBounds(330,610,80,30);
        exitbtn.setFocusable(false);
        exitbtn.addActionListener(this);
        exitbtn.setText("Exit");
        exitbtn.setForeground(new Color(0,0,0));
        exitbtn.setFont(new Font("Colonna MT",0,24));
        exitbtn.setHorizontalAlignment(0);
        exitbtn.setVerticalAlignment(0);

        container=new JPanel();
        container.setBounds(1, 320, 506, 358);
        container.setBorder(BorderFactory.createDashedBorder(new Color(235,207,47), 3, 2));
        container.setBackground(Color.black);
        container.setLayout(null);
        container.setOpaque(false);



        loginbtn=new JButton();
        loginbtn.setBounds(120, 610, 100, 30);
        loginbtn.setFocusable(true);
        loginbtn.addActionListener(this);
        loginbtn.setText("Login");
        loginbtn.setForeground(new Color(0,0,0));
        loginbtn.setFont(new Font("Colonna MT",0,24));
        loginbtn.setHorizontalAlignment(0);
        loginbtn.setVerticalAlignment(0);
        loginbtn.setMnemonic('L');
        loginbtn.addKeyListener(this);



        userNamelbl=new JLabel();
        userNamelbl.setBounds(10, 50, 175, 40);
        userNamelbl.setText("UserName :");
        userNamelbl.setOpaque(false);
        userNamelbl.setForeground(new Color(235,207,47));
        userNamelbl.setFont(new Font("Colonna MT",0,36));
        userNamelbl.setVisible(true);

        passwordlbl=new JLabel();
        passwordlbl.setBounds(10,130, 240, 40);
        passwordlbl.setText("Password :");
        passwordlbl.setOpaque(false);
        passwordlbl.setForeground(new Color(235,207,47));
        passwordlbl.setFont(new Font("Colonna MT",0,36));
        passwordlbl.setVisible(true);



        userNamField=new JTextField();
        userNamField.setBounds(200, 50, 240, 40);
        userNamField.setOpaque(false);
        userNamField.setForeground(new Color(235,207,47));
        userNamField.setFont(new Font("Times New Roman",1,24));
        userNamField.setVisible(true);
        userNamField.addActionListener(this);
        userNamField.addKeyListener(this);




        passworField=new JPasswordField();
        passworField.setBounds(200, 130, 240, 40);
        passworField.setOpaque(false);
        passworField.setForeground(new Color(235,207,47));
        passworField.setFont(new Font("Times New Roman",1,24));
        passworField.setVisible(true);
        passworField.addKeyListener(this);
        passworField.addActionListener(this);


        container.add(hide);
        container.add(visible);
        container.add(userNamelbl);
        container.add(passwordlbl);
        container.add(userNamField);
        container.add(passworField);



        backlbl=new JLabel(){
            protected void paintComponent(Graphics g) {
                g.drawImage(loginbackimg, 0, 0,506,768, null);

            }
        };
        backlbl.setBounds(0, 0, 506, 768);
        backlbl.setBorder(b1);





        loginframe=new JFrame("Cut And Curve Gym");
        loginframe.setDefaultCloseOperation(3);
        loginframe.setLayout(null);
        loginframe.setSize(506, 768);
        loginframe.setUndecorated(true);
        loginframe.setResizable(false);
        loginframe.setMinimumSize(new Dimension(506,768));
        loginframe.setLocationRelativeTo(null);
        loginframe.getRootPane().setDefaultButton(loginbtn);
//        loginframe.setIconImage(new ImageIcon(getClass().getResource("icons/Imagetop.png")).getImage());
        loginframe.setIconImage(new ImageIcon(getClass().getResource("icons/256x256.png")).getImage().getScaledInstance(32, 32, Image.SCALE_SMOOTH));
        loginframe.add(toplogolbl);
        loginframe.add(gradientlbl);
        loginframe.add(gradientlbl1);
        loginframe.add(loginlblcon);
        loginframe.add(exitbtn);
        loginframe.add(loginbtn);
        loginframe.add(container);
        loginframe.add(backlbl);
        loginframe.setVisible(false);

    }

    @Override
    public void actionPerformed(ActionEvent e) {


    }


    void method()
    {
        super.readtable();
        if(super.loginuser.isEmpty())
        {
            super.initialAdmin();
            super.readtable();
            if(!super.loginuser.isEmpty())
            {
                usernamestrg=this.userNamField.getText();
                passwordstrg=String.valueOf(this.passworField.getPassword());
                LoginUser check=new LoginUser(usernamestrg, passwordstrg);
                boolean loginvalue1=false;
                for (LoginUser loginUser1 : super.loginuser) {

                    if(checkobjs(loginUser1,check))
                    {
                        JDialog.setDefaultLookAndFeelDecorated(true);

                        UIManager.put("OptionPane.messageFont", new Font("Times New Roman",1,24));
                        UIManager.put("OptionPane.background", Color.BLACK);
                        UIManager.put("OptionPane.titlePane.background", Color.BLACK);
                        UIManager.put("Panel.background", Color.BLACK);
                        UIManager.put("OptionPane.buttonFont", new Font("Times New Roman",0,16));
                        UIManager.put("OptionPane.messageForeground", Color.GREEN);
                        // JOptionPane.showMessageDialog(loginframe, "Login Successfull", "Result", 1);
                        loginvalue1=true;
                        this.loginvalue=loginvalue1;
                        this.loginuer=loginUser1;
                        break;
                    }


                }
                if(!loginvalue1)
                {

                    {
                        JDialog.setDefaultLookAndFeelDecorated(true);

                        UIManager.put("OptionPane.messageFont", new Font("Times New Roman",1,24));
                        UIManager.put("OptionPane.background", Color.BLACK);
                        UIManager.put("Panel.background", Color.BLACK);
                        UIManager.put("OptionPane.buttonFont", new Font("Times New Roman",0,16));
                        UIManager.put("OptionPane.messageForeground", Color.RED);
                        JOptionPane.showMessageDialog(loginframe, "Login Failed", "Result", 0);
                        passworField.requestFocus();

                    }
                }
            }


        }
        else if(!super.loginuser.isEmpty())
        {
            usernamestrg=this.userNamField.getText();
            passwordstrg=String.valueOf(this.passworField.getPassword());
            LoginUser check=new LoginUser(usernamestrg, passwordstrg);
            boolean loginvalue1=false;
            for (LoginUser loginUser1 : super.loginuser) {

                if(checkobjs(loginUser1,check))
                {
                    JDialog.setDefaultLookAndFeelDecorated(true);

                    UIManager.put("OptionPane.messageFont", new Font("Times New Roman",1,24));
                    UIManager.put("OptionPane.background", Color.BLACK);
                    UIManager.put("OptionPane.titlePane.background", Color.BLACK);
                    UIManager.put("Panel.background", Color.BLACK);
                    UIManager.put("OptionPane.buttonFont", new Font("Times New Roman",0,16));
                    UIManager.put("OptionPane.messageForeground", Color.GREEN);

                    // JOptionPane.showMessageDialog(loginframe, "Login Successfull", "Result", 1);
                    loginvalue1=true;
                    this.loginvalue=loginvalue1;
                    this.loginuer=loginUser1;
                    break;
                }


            }
            if(!loginvalue1)
            {

                {
                    JDialog.setDefaultLookAndFeelDecorated(true);
                    this.loginvalue=false;
                    UIManager.put("OptionPane.messageFont", new Font("Times New Roman",1,24));
                    UIManager.put("OptionPane.background", Color.BLACK);
                    UIManager.put("Panel.background", Color.BLACK);
                    UIManager.put("OptionPane.buttonFont", new Font("Times New Roman",0,16));
                    UIManager.put("OptionPane.messageForeground", Color.RED);
                    JOptionPane.showMessageDialog(loginframe, "Login Failed", "Result", 0);
                    passworField.requestFocus();

                }
            }
        }





    }
    boolean checkobjs(LoginUser obj1, LoginUser obj2)
    {
        return (obj1.getUserName().equals(obj2.getUserName())&&obj1.getPassword().equals(obj2.getPassword()));
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }





}