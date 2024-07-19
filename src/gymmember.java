
import java.awt.*;
import java.awt.image.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.*;
import java.awt.event.*;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Month;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.Date;
import com.toedter.calendar.JDateChooser;
import com.toedter.components.JSpinField;
import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;


import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.fxml.FXMLLoader;
// import javafx.fxml.LoadException;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;





public class gymmember extends Loginpage implements ItemListener, MouseListener{
    Dimension Screensize;
    BufferedImage img,img2,logo;
    char echochar;
    boolean isready=false;

    //............Export Excel Panel ........................................................
    GiveGradientLabel toplblEE,toplblEE1,toplblEE2;
    JPanel exportexcelEE,toplabelcoverEE;
    JLabel SelectmonthEE;
    JComboBox<String> monthsoptionaEE;
    JButton exportButtonEE;
    

    //............Export Text Panel ........................................................
    GiveGradientLabel toplblET,toplblET1,toplblET2;
    JPanel exporttextET,toplabelcoverET;
    JLabel SelectmonthET;
    JComboBox<String> monthsoptionaET;
    JTextArea exportfileareaET;
    JScrollPane textpaneET;
    JPanel containerET;
    JButton exportButtonET;
    File filepath;
    String path;
    JLabel boykalbl;




    //............Export Text Panel ........................................................


    //............Monthly Fee Record ........................................................
    GiveGradientLabel monthyfeelbl1,monthyfeelbl2,monthyfeelbl3;
    JPanel toplabelcoverMF;
    JPanel monthlyfeepanelMF;
    JLabel monthslblMF,totalstrengthlblMF,feecollectedlblMF,feependingMF,totalfeelblMF,reveueMF,ExpensesMF,ProfitMF;
    JComboBox<String> monthsoptionaMF;
    JTextField strengthfldMF,feecollectionfldMF,feependfldMF,totalfeefldMF,revenuefldMF,expensefldMF,profitfldMF;
    JButton showtableMF,HidetableMF;
    DefaultTableCellRenderer tablecellrendererMF;
    String[] headerMF={"ID","Name","CNIC","Phone","fee","Name of Admin","D/o/LastFee","D/o/Join"};
    JScrollPane tablepaneMF;
    JPanel tablecontainerMF;
    JTable monthtableMF;

    JLabel imagelblMF;
    JLabel nameilblMF,idilblMF,cnicilblMF,phoneilblMF,dateofjoinilblMF,feeilblMF;
    JTextField nameifldMF,idifldMF,cnicifldMF,phoneifldMF,dateofjoinifldMF,feeifldMF;
    JButton backbtnMF;



    //......................Replace Information of Client.................................................
    GiveGradientLabel replacelbl1,replacelbl2,replacelbl3;
    JPanel toplabelcoverRI;
    JPanel replacepanelRI;
    JLabel selectlblRI,namelblRI,idlblRI,cniclblRI,phonelblRI,dateofjoinlblRI;
    JTextField namesfldRI,idsfldRI;
    JComboBox<String> optionsRI;
    JButton searchbtnRI,clearbtnRI,SelectbtnRI,replacebtnRI;
    JTable tableRI;
    JScrollPane paneRI;
    JPanel tableContainerRI;
    String[] headerRI={"ID","Name","CNIC","Phone","fee","Name of Admin","D/o/LastFee","D/o/Join"};
    String[] optionsfldsRI={"Select","ID","Name"};
    JTextField namefldRI,idfldRI,cnicfldRI,phonefldRI;
    DefaultTableCellRenderer tablecellrendererRI;
    String nameofmemRI=null;
    JButton backbtnRI;
    JLabel imagelblRI;
    private JButton replaceimagebtnRI;
    BufferedImage imageRI;
    File imagefileRI;
    JDateChooser datechooserRI;
    JButton calenbtnRI;
    JTextField fielddateRI;

    //......................Add Fee of Client.................................................
    GiveGradientLabel addfeelbl1,addfeelbl2,addfeelbl3;
    JPanel toplabelcoverAF,tablecontainerAF;
    JTable searchtableAF;
    JScrollPane tablepaneAF;
    DefaultTableCellRenderer tablecellrendererAF;
    JPanel feepanelAF;
    JTextField namefldAF,idfldAF,feefldAF;
    JLabel searchlblAF,instructionAF,feelblAF;
    JButton searchbtnAF,clearbtnAF,addfeeAF;
    JComboBox<String> searchoptionsAF;
    String[] headerAF={"ID","Name","CNIC","Phone","fee","Name of Admin","D/o/LastFee","D/o/Join"};


    JLabel imagelblAF;
    JLabel nameilblAF,idilblAF,cnicilblAF,phoneilblAF,dateofjoinilblAF,feeilblAF;
    JTextField nameifldAF,idifldAF,cnicifldAF,phoneifldAF,dateofjoinifldAF,feeifldAF;
    JButton backbtnAF;







    
    //......................Search Gym Client.................................................
    GiveGradientLabel searchgymclientlbl,searchgymclientlbl2,searchgymclientlbl3;
    JPanel toplabelcoverSGC,tablecontainerSGC;
    JPanel searchgymmem;
    JLabel searchlblSGC;
    JComboBox<String> searchoptionsSGC;
    JTextField idfldSGC,namefldSGC,cnicfldSGC,nameofAdminfldSGC,phonefldSGC,datefldSGC2;
    JTable searchtable;
    JScrollPane tablepaneSGC;
    DefaultTableCellRenderer tablecellrendererSGC;
    JButton searchSGC,clearSGC;
    ArrayList<gymclient> AllMatchesSGC=new ArrayList<>();

    JLabel imagelblSGC;
    JLabel nameilblSGC,idilblSGC,cnicilblSGC,phoneilblSGC,dateofjoinilblSGC,feeilblSGC;
    JTextField nameifldSGC,idifldSGC,cnicifldSGC,phoneifldSGC,dateofjoinifldSGC,feeifldSGC;
    JButton backbtnSGC;
    JDateChooser datechooserSGC;
    JButton calenbtnSGC;
    JTextField fielddateSGC;



    //......................Remove Gym Client.................................................
    GiveGradientLabel removegymclientlbl,removegymclientlbl2,removegymclientlbl3;
    JPanel toplabelcoverRGC,tablecontainerRGC;
    JLabel nameofmemlblRGC,idofmemlblRGC;
    JTextField namememRGC,idmemRGC; 
    JTable removetable;
    JPanel removegymmem;
    JButton searchRGC,removememRGC,clearRGC;
    DefaultTableCellRenderer tablecellrenderer;
    JScrollPane tablepane;
    String[] headerRGC={"ID","Name","CNIC","Phone","fee","Name of Admin","D/o/Join"};
    JTableHeader header1;
    ArrayList<gymclient> AllMatches=new ArrayList<>();

    //......................Add Gym Client....................................................

    GiveGradientLabel addgymmem1,addgymmem2,addgymmem3;
    JPanel toplabelcover1;
    JLabel nameofmem,idofmem,phonemem,feememlblACG,Dateofjoinmem,cnicmem;
    JTextField namememAGC,idAGC,phoneAGC,feeAGC,cnicAGC;
    JComboBox<String> feeoptions;
    JButton addmemAGC,clearAGC,cancelAGC;
    JLabel expcnic,expphone,lbldate;
    JCheckBox confirmallfielsAGC;
    String namevalueAGC,cnicvalueAGC;
    int feevalueAGC,realid;
    Long phone;
    LocalDate datevalueAGC;
    private JButton addimagebtnAGC;
    JPanel addgymmem;
    BufferedImage imageAGC;
    File imagefile;
    JDateChooser datechooserAG;
    JButton calenbtn;
    JTextField fielddate;

    //......................Music....................................................
    JPanel musix,musix2,musix3,videopanel,videopanel2,videopanel3;
    JLabel topimagemusic;
    GradientText text1920,text1536,text1280;
    FXMLLoader fxmlLoader=new FXMLLoader(getClass().getResource("scene.fxml"));
    FXMLLoader fxmlLoader2=new FXMLLoader(getClass().getResource("scene2.fxml"));
    FXMLLoader fxmlLoader3=new FXMLLoader(getClass().getResource("scene3.fxml"));
    FXMLLoader fxmlLoadervideo=new FXMLLoader(getClass().getResource("videoscene.fxml"));
    FXMLLoader fxmlLoadervideo1536=new FXMLLoader(getClass().getResource("videoscene1536.fxml"));
    FXMLLoader fxmlLoadervideo1280=new FXMLLoader(getClass().getResource("videoscene1280.fxml"));
    JFXPanel musicpanel,musicpanel2,musicpanel3,jfxvideopanel,jfxvideopanel1536,jfxvideopanel1280;
    Parent root,root1536,root1280,rootvideo,rootvideo1536,rootvideo1280;
    Scene  scene,scene1536,scene1280,scenevideo,scenevideo1536,scenevideo1280;





    //....................menuPanel...................................................
    JPanel menupanel;
    JPanel homelblmenupanel,homelblmenupanel2,homelblmenupanel3;
    JButton addmem,removemem,replacemem,searchmem,search,feemem,music,video,calculatemonthbugjet,excel,text;
    JPanel p1,p2,p3;



    //..................Admin Controls............................................................
    
    private JPanel Admincontrols;
    private JPanel gradientlbl1,gradientlbl4;
    private DisplayLine linelblcntrl;
    private JButton adduserctrl,removeuserctrl,changeusernamectrl,changepasswordctrl;
    private JPanel adduserpnlctl,remveusrpnlctl,chngeusrnmectl,chngepswctl;
    private JButton viewAdminControls;
    private JButton closeAdminPanel;
    private Image i1;
    private Image admincontrols,control2;

    //........adduserpnl......
    private JButton adduserButton,cancelUbtnAU,clearbtnAU,hideAU,showAU;
    private JPanel gradientlblAU,gradientlblAU1;
    private JLabel usrNamelblAU,pswlblAU,utypeAU,phoneAU;
    private JTextField userNamefldAU,phonefldAU;
    private JPasswordField pswfldAU;
    private JCheckBox confirmfldAU;
    private DisplayLine linelblAU;
    private JComboBox<String> utypefldAU;
    private JLabel imagelabelAGC;


    //........removeuserpnl......
    private JButton removeuserButton,cancelUbtnRU,clearbtnRU,hideRU,showRU;
    private JPanel gradientlblRU,gradientlblRU1;
    private JLabel usrNamelblRU,pswlblRU;
    private JTextField userNamefldRU;
    private JPasswordField pswfldR;
    private JCheckBox confirmfldRU;
    private DisplayLine linelblRU;

    //........changeusernamepnl......
    private JButton chguserNameButton,cancelUbtnCUN,clearbtnCUN,hideCUN,showCUN;
    private JPanel gradientlbCUN,gradientlbCUN1;
    private JLabel usrNamelblCUN,pswlblCUN,newUserNamelblCUN;
    private JTextField userNamefldCUN,newuserNamefldCUN;

    private JPasswordField pswfldRCUN;
    private JCheckBox confirmfldCUN;
    private DisplayLine linelblCUN;

    //........changepasswordpnl......
    private JButton chgpassButton,cancelUbtnCP,clearbtnCP,hideCP,showCP,hideCP1,showCP1;
    private JPanel gradientlbCP,gradientlbCP1;
    private JLabel usrNamelblCP,pswlblCP,pswnewlblCP;
    private JTextField userNamefldCP;
    private JPasswordField newPassCP,pwsfldCP;
    private JCheckBox confirmfldCP;
    private DisplayLine linelblCP;


    //............................................................................................

    private JFrame menuframe;
    private JLabel adminlbl,phonelbl;
    private JLabel datenow,timenow;
    private JButton minimizebtn,closewindowbtn,home,logout,back,graphics;
    private JPanel panel1;
    private JPanel labellogo;
    private JPopupMenu popgraphics;
    private JPanel panelback;
    JMenuItem p1920;
    JMenuItem p1536;
    JMenuItem p1280;
    // private int width,height;


    Border b1=BorderFactory.createLineBorder((new Color(235,207,47)), 1);
    Border b2=BorderFactory.createLineBorder(Color.white, 1);
    Border b3=BorderFactory.createLineBorder(Color.green, 1);
    Border cb4=BorderFactory.createCompoundBorder(b1, b3);
    Border emptyBorder=BorderFactory.createEmptyBorder();
    private GradientText gradientlbl,gradientlbl2,gradientlbl3;
    Border a1=BorderFactory.createDashedBorder(new Color(235,207,47), 3, 2);
    Border a2=BorderFactory.createBevelBorder(BevelBorder.RAISED, Color.ORANGE,  Color.black,new Color(235,207,47), Color.black);
    ArrayList<String> tablenamesdatabase;
    String nameofTabelenow=null;

    Color midblack=new Color(20,20,20);


    gymmember() throws IOException {
   
        menuframe=new JFrame("Cut And Curve Gym");

        Screensize=Toolkit.getDefaultToolkit().getScreenSize();
        
        if(Screensize.getWidth()==1920)
        {
            Screensize.setSize(new Dimension(1920,1080));
            menuframe.setSize(Screensize);
        }
        else if(Screensize.getWidth()>=1536&&Screensize.getWidth()<1920){
            Screensize.setSize(new Dimension(1536,864));
            menuframe.setSize(Screensize);
        }
        else
        {
            Screensize.setSize(new Dimension(1280,720));
            menuframe.setSize(Screensize);
        }
        
        try {
            img=ImageIO.read(getClass().getResource("icons/menuframeback1.jpg"));
            logo=ImageIO.read(getClass().getResource("icons/Imagetop.png"));
        } catch (IOException e) {
           
           
        }
        Border a3=BorderFactory.createEmptyBorder(30, 10, 10, 10);
        Border a4=BorderFactory.createMatteBorder(1, 1, 0, 1, new Color(235,207,47));

        //..........................Data..Record..Update.........................................
        
        if(super.connection!=null){
            LocalDate datenow=LocalDate.now();
            int yearnow=datenow.getYear();
            Month monthnow=datenow.getMonth();
            nameofTabelenow=String.valueOf(monthnow)+String.valueOf(yearnow);
            // Month monthprevious=null;
            int monthno=0;
            int yearprevious=datenow.getYear();

            if(datenow.getMonthValue()!=1)
            {
                monthno=datenow.getMonthValue()-1;
            }
            else if(datenow.getMonthValue()==1)
            {
                monthno=12;
                yearprevious=yearprevious-1;
            }
            
            tablenamesdatabase=super.returndatatables();
            String checktemptable=String.valueOf(Month.of(monthno))+String.valueOf(yearprevious);

            for(int i=0;i<tablenamesdatabase.size();i++)
            {
                // monthprevious=Month.of(monthnow.getValue()-1);
                if(tablenamesdatabase.get(i).equals("logindata")||tablenamesdatabase.get(i).equalsIgnoreCase(nameofTabelenow))
                {
                    continue;
                }
                else{
                    // System.out.println(monthno);
                    if(checktable(checktemptable)){
                        if(selectfromtable(checktemptable).isEmpty())
                        {
                            if(monthno!=1)
                            {
                                monthno--;
                            }
                            else if(monthno==1)
                            {
                                monthno=12;
                                yearprevious--;
                            }
                            checktemptable=String.valueOf(Month.of(monthno))+String.valueOf(yearprevious);
                        }
                        else{
                            // System.out.println("This is the Table"+"         ,       "+checktemptable);
                            break;
                        }

                    }
                    
                    // selectfromtable(tablename)
                }
                // System.out.println(tablenamesdatabase.get(i));
            }





            String nameofPreviousTable=String.valueOf(Month.of(monthno))+String.valueOf(yearprevious);

            if(!checktable(nameofTabelenow))
            {
                createtabledata(nameofTabelenow);
                ArrayList<gymclient> datatransfernewmonth=new ArrayList<>();
                if(super.checktable(nameofPreviousTable)){
                    datatransfernewmonth=selectfromtable(nameofPreviousTable);
                }
                if(!datatransfernewmonth.isEmpty()){

                    for (gymclient i : datatransfernewmonth) {
                        LocalDate datefee=null;
                        if(i.getDateoffee()!=null){
                            datefee=i.getDateoffee();
                        }
                        enterdataintotable(nameofTabelenow, i.getNameUser(), i.getIDuser(), i.getPhone(), i.getCnic(), i.getFee(), i.isFeecheck(), i.getNameofAdmin(), i.getJoining(),datefee,i.getImage());
                    }
                }

            }
            else{
                if(selectfromtable(nameofTabelenow).isEmpty()){
                    ArrayList<gymclient> datatransfernewmonth=new ArrayList<>();
                    if(super.checktable(nameofPreviousTable)){
                        datatransfernewmonth=selectfromtable(nameofPreviousTable);
                    }
                    if(!datatransfernewmonth.isEmpty()){

                        for (gymclient i : datatransfernewmonth) {
                            LocalDate datefee=null;
                            if(i.getDateoffee()!=null){
                                datefee=i.getDateoffee();
                            }
                            enterdataintotable(nameofTabelenow, i.getNameUser(), i.getIDuser(), i.getPhone(), i.getCnic(), i.getFee(), i.isFeecheck(), i.getNameofAdmin(), i.getJoining(),datefee,i.getImage());
                        }
                    }
                }

            }

        }


        //.............Data..Record..Update .....................................................


        //.............Fee.. Record.. Update.....................................................

        if(!selectfromtable(nameofTabelenow).isEmpty()){
            
            ArrayList<gymclient> mems=selectfromtable(nameofTabelenow);
            if(!mems.isEmpty()){

                for (gymclient client : mems) {
                    if(client.getJoining()!=null){
                        LocalDate datetobenoted=client.getJoining();
                        int year1=datetobenoted.getYear();
                        int month1=datetobenoted.getMonthValue();
                        int day=datetobenoted.getDayOfMonth();
                        
                        // System.out.println(datetobenoted);
                        

                        if(month1<LocalDate.now().getMonthValue()&&day<LocalDate.now().getDayOfMonth()&&year1<=LocalDate.now().getYear()){
                            if(client.isFeecheck()){
                                updatetabledateoffee(client.getNameUser(), nameofTabelenow);
                            }
                        }  
                        else if(month1>LocalDate.now().getMonthValue()&&year1<LocalDate.now().getYear()&&day<LocalDate.now().getDayOfMonth()){
                            if(client.isFeecheck()){
                                updatetabledateoffee(client.getNameUser(), nameofTabelenow);
                            }
                        }                      

                        
                    }
                    
                }
            }

        }

        //.............Fee.. Record.. Update.....................................................

        //............Export Excel Panel ........................................................

        SelectmonthEE=new JLabel("Month :");
        SelectmonthEE.setForeground(Color.white);
        SelectmonthEE.setOpaque(false);
        SelectmonthEE.setHorizontalAlignment(0);
        SelectmonthEE.setVerticalAlignment(0);

        boykalbl=new JLabel();
        boykalbl.setOpaque(false);


    



        ArrayList<String> monthtablesEE=returndatatables();
        String[] monthopsEE=null;
        if(!monthtablesEE.isEmpty()){
            monthopsEE=new String[monthtablesEE.size()-1];
            int j=0;
            for(int i=0;i<monthtablesEE.size()-1;i++){
                if(monthtablesEE.get(j).equalsIgnoreCase("logindata")){
                    j++;
                }
                monthopsEE[i]=monthtablesEE.get(j);
                j++;
            }
        }
        monthsoptionaEE=new JComboBox<>(monthopsEE);
        monthsoptionaEE.setBackground(new Color(20,20,20));
        monthsoptionaEE.setForeground(Color.WHITE);
        monthsoptionaEE.setOpaque(true);
        monthsoptionaEE.setSelectedItem(nameofTabelenow.toLowerCase());
        monthsoptionaEE.addItemListener(this);

        exportButtonEE=new JButton("Export");
        exportButtonEE.setForeground(Color.green);
        exportButtonEE.setBackground(new Color(20,20,20));
        exportButtonEE.setOpaque(false);
        exportButtonEE.setFocusable(false);
        exportButtonEE.addActionListener(this);


        toplabelcoverEE=new JPanel();
        toplabelcoverEE.setBorder(BorderFactory.createCompoundBorder(a4, a3));
        toplabelcoverEE.setLayout(null);
        toplabelcoverEE.setVisible(false);
        
        
        
        exportexcelEE=new JPanel();
        exportexcelEE.setBorder(BorderFactory.createCompoundBorder(a1, a2));
        exportexcelEE.setLayout(null);
        exportexcelEE.add(SelectmonthEE);
        exportexcelEE.add(monthsoptionaEE);
        exportexcelEE.add(exportButtonEE);
        exportexcelEE.add(boykalbl);
        

        //............Export Text Panel ........................................................


        SelectmonthET=new JLabel("Month :");
        ArrayList<String> monthtables=returndatatables();
        String[] monthopsET=null;
        if(!monthtables.isEmpty()){
            monthopsET=new String[monthtables.size()-1];
            int j=0;
            for(int i=0;i<monthtables.size()-1;i++){
                if(monthtables.get(j).equalsIgnoreCase("logindata")){
                    j++;
                }
                monthopsET[i]=monthtables.get(j);
                j++;
            }
        }
        monthsoptionaET=new JComboBox<>(monthopsET);

        
        exportfileareaET=new JTextArea();
        exportfileareaET.setBackground(new Color(20,20,20));
        exportfileareaET.setForeground(Color.white);
        exportfileareaET.setEditable(false);

        textpaneET=new JScrollPane(exportfileareaET);
        textpaneET.getVerticalScrollBar().setBackground(new Color(20,20,20));
        textpaneET.getHorizontalScrollBar().setBackground(new Color(20,20,20));

        containerET=new JPanel();
        containerET.setLayout(new BorderLayout());
        containerET.setBackground(new Color(235,207,47));
        containerET.add(textpaneET);

        SelectmonthET.setForeground(Color.white);
        SelectmonthET.setOpaque(false);
        SelectmonthET.setHorizontalAlignment(0);
        SelectmonthET.setVerticalAlignment(0);

        monthsoptionaET.setBackground(new Color(20,20,20));
        monthsoptionaET.setForeground(Color.WHITE);
        monthsoptionaET.setOpaque(true);
        monthsoptionaET.setSelectedItem(nameofTabelenow.toLowerCase());
        monthsoptionaET.addItemListener(this);


        exportButtonET=new JButton("Export");
        exportButtonET.setForeground(Color.green);
        exportButtonET.setBackground(new Color(20,20,20));
        exportButtonET.setOpaque(false);
        exportButtonET.setFocusable(false);
        exportButtonET.addActionListener(this);





        toplabelcoverET=new JPanel();
        toplabelcoverET.setBorder(BorderFactory.createCompoundBorder(a4, a3));
        toplabelcoverET.setLayout(null);
        toplabelcoverET.setVisible(false);


        exporttextET=new JPanel();
        exporttextET.setBorder(BorderFactory.createCompoundBorder(a1, a2));
        exporttextET.setLayout(null);
        exporttextET.add(SelectmonthET);
        exporttextET.add(monthsoptionaET);
        // exporttextET.add(exportfileareaET);
        exporttextET.add(containerET);
        exporttextET.add(exportButtonET);


        //............Monthly Fee Record ........................................................
        nameifldMF=new JTextField();
        idifldMF=new JTextField();
        cnicifldMF=new JTextField();
        phoneifldMF=new JTextField();
        dateofjoinifldMF=new JTextField();
        feeifldMF=new JTextField();

        imagelblMF=new JLabel();
        nameilblMF=new JLabel();
        idilblMF=new JLabel();
        cnicilblMF=new JLabel();
        phoneilblMF=new JLabel();
        dateofjoinilblMF=new JLabel();
        feeilblMF=new JLabel();
        backbtnMF=new JButton();

        
        backbtnMF.setBackground(new Color(20,20,20));
        backbtnMF.setForeground(Color.orange);
        backbtnMF.setBorder(BorderFactory.createEmptyBorder());
        backbtnMF.setOpaque(false);
        backbtnMF.setFocusable(false);
        backbtnMF.setVisible(false);
        backbtnMF.addActionListener(this);

        feeifldMF.setBackground(new Color(20,20,20));
        feeifldMF.setForeground(Color.white);
        feeifldMF.setOpaque(true);
        feeifldMF.setVisible(false);
        feeifldMF.setEditable(false);

        dateofjoinifldMF.setBackground(new Color(20,20,20));
        dateofjoinifldMF.setForeground(Color.white);
        dateofjoinifldMF.setOpaque(true);
        dateofjoinifldMF.setVisible(false);
        dateofjoinifldMF.setEditable(false);

        phoneifldMF.setBackground(new Color(20,20,20));
        phoneifldMF.setForeground(Color.white);
        phoneifldMF.setOpaque(true);
        phoneifldMF.setVisible(false);
        phoneifldMF.setEditable(false);

        cnicifldMF.setBackground(new Color(20,20,20));
        cnicifldMF.setForeground(Color.white);
        cnicifldMF.setOpaque(true);
        cnicifldMF.setVisible(false);
        cnicifldMF.setEditable(false);

        idifldMF.setBackground(new Color(20,20,20));
        idifldMF.setForeground(Color.white);
        idifldMF.setOpaque(true);
        idifldMF.setVisible(false);
        idifldMF.setEditable(false);

        nameifldMF.setBackground(new Color(20,20,20));
        nameifldMF.setForeground(Color.white);
        nameifldMF.setOpaque(true);
        nameifldMF.setVisible(false);
        nameifldMF.setEditable(false);

        feeilblMF.setText("Fee :");
        feeilblMF.setHorizontalAlignment(10);
        feeilblMF.setVerticalAlignment(0);
        feeilblMF.setForeground(Color.white);
        feeilblMF.setOpaque(false);

        dateofjoinilblMF.setText("Date of Join :");
        dateofjoinilblMF.setHorizontalAlignment(10);
        dateofjoinilblMF.setVerticalAlignment(0);
        dateofjoinilblMF.setForeground(Color.white);
        dateofjoinilblMF.setOpaque(false);

        phoneilblMF.setText("Phone :");
        phoneilblMF.setHorizontalAlignment(10);
        phoneilblMF.setVerticalAlignment(0);
        phoneilblMF.setForeground(Color.white);
        phoneilblMF.setOpaque(false);

        cnicilblMF.setText("CNIC :");
        cnicilblMF.setHorizontalAlignment(10);
        cnicilblMF.setVerticalAlignment(0);
        cnicilblMF.setForeground(Color.white);
        cnicilblMF.setOpaque(false);

        idilblMF.setText("ID :");
        idilblMF.setHorizontalAlignment(10);
        idilblMF.setVerticalAlignment(0);
        idilblMF.setForeground(Color.white);
        idilblMF.setOpaque(false);

        nameilblMF.setText("Name :");
        nameilblMF.setHorizontalAlignment(10);
        nameilblMF.setVerticalAlignment(0);
        nameilblMF.setForeground(Color.white);
        nameilblMF.setOpaque(false);

        imagelblMF.setBorder(b1);
        imagelblMF.setHorizontalAlignment(0);
        imagelblMF.setVerticalAlignment(0);
        nameilblMF.setForeground(Color.white);
        imagelblMF.setOpaque(false);

        imagelblMF.setVisible(false);
        nameilblMF.setVisible(false);
        idilblMF.setVisible(false);
        cnicilblMF.setVisible(false);
        phoneilblMF.setVisible(false);
        dateofjoinilblMF.setVisible(false);
        feeilblMF.setVisible(false);

        tablecontainerMF=new JPanel();
        tablecontainerMF.setBackground(new Color(20,20,20));

        tablecellrendererMF=new DefaultTableCellRenderer();
        tablecellrendererMF.setHorizontalAlignment(0);
        monthtableMF=new JTable();
        monthtableMF.setModel(new DefaultTableModel(null, headerMF){
            @Override
            public boolean isCellEditable(int row, int column) {

                return false;
            }

        });
        monthtableMF.setDefaultRenderer(Object.class, tablecellrendererMF);
        monthtableMF.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        monthtableMF.setGridColor(Color.darkGray);
        monthtableMF.getTableHeader().setResizingAllowed(false);
        monthtableMF.getTableHeader().setReorderingAllowed(false);
        monthtableMF.setBackground(new Color(20,20,20));
        monthtableMF.setForeground(new Color(207, 204, 68));
        monthtableMF.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        tablepaneMF=new JScrollPane(monthtableMF);
        tablepaneMF.setOpaque(false);

        tablecontainerMF.setLayout(new BorderLayout());
        tablecontainerMF.setOpaque(false);
        tablecontainerMF.add(tablepaneMF);
        tablecontainerMF.setVisible(true);


        monthslblMF=new JLabel("Month :");
        ArrayList<String> datatables=returndatatables();
        String[] monthops=null;
        if(!datatables.isEmpty()){
            monthops=new String[datatables.size()-1];
            int j=0;
            for(int i=0;i<datatables.size()-1;i++){
                if(datatables.get(j).equalsIgnoreCase("logindata")){
                    j++;
                }
                monthops[i]=datatables.get(j);
                j++;
            }
        }

        showtableMF=new JButton("Show Table");
        HidetableMF=new JButton("Hide Table");


        showtableMF.setBackground(new Color(20,20,20));
        showtableMF.setForeground(Color.green);
        showtableMF.setFocusable(false);
        showtableMF.setOpaque(false);
        showtableMF.setVisible(true);
        showtableMF.addActionListener(this);


        HidetableMF.setBackground(new Color(20,20,20));
        HidetableMF.setForeground(Color.orange);
        HidetableMF.setFocusable(false);
        HidetableMF.setOpaque(false);
        HidetableMF.setVisible(false);
        HidetableMF.addActionListener(this);



        monthsoptionaMF=new JComboBox<>(monthops);
        totalstrengthlblMF=new JLabel("Total Strength :");
        feecollectedlblMF=new JLabel("Fee Collected By :");
        feependingMF=new JLabel("Fee Pending :");
        totalfeelblMF=new JLabel("Total Amount : ");
        strengthfldMF=new JTextField();
        feecollectionfldMF=new JTextField();
        feependfldMF=new JTextField();
        totalfeefldMF=new JTextField();

        reveueMF=new JLabel("Revenue :");
        ExpensesMF=new JLabel("Expenses :");
        ProfitMF=new JLabel("Profit :");

        revenuefldMF=new JTextField();
        expensefldMF=new JTextField();
        profitfldMF=new JTextField();

        
        reveueMF.setForeground(Color.white);
        reveueMF.setOpaque(false);
        reveueMF.setHorizontalAlignment(0);
        reveueMF.setVerticalAlignment(0);

        ExpensesMF.setForeground(Color.white);
        ExpensesMF.setOpaque(false);
        ExpensesMF.setHorizontalAlignment(0);
        ExpensesMF.setVerticalAlignment(0);
        

        ProfitMF.setForeground(Color.white);
        ProfitMF.setOpaque(false);
        ProfitMF.setHorizontalAlignment(0);
        ProfitMF.setVerticalAlignment(0);

        revenuefldMF.setBackground(new Color(20,20,20));
        revenuefldMF.setForeground(Color.white);
        revenuefldMF.setOpaque(true);
        revenuefldMF.setEditable(false);
        revenuefldMF.setHorizontalAlignment(0);
        revenuefldMF.getDocument().addDocumentListener(new DocumentListener(){

            @Override
            public void insertUpdate(DocumentEvent e) {
                int value=0;
                if(!revenuefldMF.getText().isEmpty()){
                    value=Integer.valueOf(revenuefldMF.getText());
                }
                if(!expensefldMF.getText().isEmpty()){
                    
                    int expensevalue=Integer.valueOf(expensefldMF.getText());
                    int profitvalue=value-expensevalue;
                    profitfldMF.setText(String.valueOf(profitvalue));
                    totalfeefldMF.setText("Rs "+profitfldMF.getText());
                }

                
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                int value=0;
                if(!revenuefldMF.getText().isEmpty()){
                    value=Integer.valueOf(revenuefldMF.getText());
                }
                if(!expensefldMF.getText().isEmpty()){
                    
                    int expensevalue=Integer.valueOf(expensefldMF.getText());
                    int profitvalue=value-expensevalue;
                    profitfldMF.setText(String.valueOf(profitvalue));
                    totalfeefldMF.setText("Rs "+profitfldMF.getText());
                }
            }

            @Override
            public void changedUpdate(DocumentEvent e) {

                
            }
            
        });

        expensefldMF.setBackground(new Color(20,20,20));
        expensefldMF.setForeground(Color.white);
        expensefldMF.setOpaque(true);
        expensefldMF.setEditable(true);
        expensefldMF.setHorizontalAlignment(0);
        expensefldMF.addKeyListener(this);
        expensefldMF.getDocument().addDocumentListener(new DocumentListener(){

            @Override
            public void insertUpdate(DocumentEvent e) {
                int value=0;
                if(!expensefldMF.getText().isEmpty()){
                    value=Integer.valueOf(expensefldMF.getText());
                }
                if(!revenuefldMF.getText().isEmpty()){
                    
                    int reveuevalue=Integer.valueOf(revenuefldMF.getText());
                    int profitvalue=reveuevalue-value;
                    profitfldMF.setText(String.valueOf(profitvalue));
                    totalfeefldMF.setText("Rs "+profitfldMF.getText());
                }

                
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                int value=0;
                if(!expensefldMF.getText().isEmpty()){
                    value=Integer.valueOf(expensefldMF.getText());
                }
                if(!revenuefldMF.getText().isEmpty()){
                    int reveuevalue=Integer.valueOf(revenuefldMF.getText());
                    int profitvalue=reveuevalue-value;
                    profitfldMF.setText(String.valueOf(profitvalue));
                    totalfeefldMF.setText("Rs "+profitfldMF.getText());
                }
                
            }

            @Override
            public void changedUpdate(DocumentEvent e) {

                
            }
            
        });


        profitfldMF.setBackground(new Color(20,20,20));
        profitfldMF.setForeground(Color.white);
        profitfldMF.setOpaque(true);
        profitfldMF.setHorizontalAlignment(0);
        profitfldMF.setEditable(false);


        strengthfldMF.setBackground(new Color(20,20,20));
        strengthfldMF.setForeground(Color.white);
        strengthfldMF.setOpaque(true);
        strengthfldMF.setHorizontalAlignment(0);
        strengthfldMF.setEditable(false);

        feecollectionfldMF.setBackground(new Color(20,20,20));
        feecollectionfldMF.setForeground(Color.white);
        feecollectionfldMF.setOpaque(true);
        feecollectionfldMF.setHorizontalAlignment(0);
        feecollectionfldMF.setEditable(false);

        feependfldMF.setBackground(new Color(20,20,20));
        feependfldMF.setForeground(Color.white);
        feependfldMF.setOpaque(true);
        feependfldMF.setHorizontalAlignment(0);
        feependfldMF.setEditable(false);

        totalfeefldMF.setBackground(new Color(20,20,20));
        totalfeefldMF.setForeground(Color.white);
        totalfeefldMF.setOpaque(true);
        totalfeefldMF.setHorizontalAlignment(0);
        totalfeefldMF.setEditable(false);


        totalstrengthlblMF.setForeground(Color.white);
        totalstrengthlblMF.setOpaque(false);
        totalstrengthlblMF.setHorizontalAlignment(0);
        totalstrengthlblMF.setVerticalAlignment(0);

        feecollectedlblMF.setForeground(Color.white);
        feecollectedlblMF.setOpaque(false);
        feecollectedlblMF.setHorizontalAlignment(0);
        feecollectedlblMF.setVerticalAlignment(0);

        feependingMF.setForeground(Color.white);
        feependingMF.setOpaque(false);
        feependingMF.setHorizontalAlignment(0);
        feependingMF.setVerticalAlignment(0);

        totalfeelblMF.setForeground(Color.white);
        totalfeelblMF.setOpaque(false);
        totalfeelblMF.setHorizontalAlignment(0);
        totalfeelblMF.setVerticalAlignment(0);


        monthslblMF.setForeground(Color.white);
        monthslblMF.setOpaque(false);
        monthslblMF.setHorizontalAlignment(0);
        monthslblMF.setVerticalAlignment(0);

        monthsoptionaMF.setBackground(new Color(20,20,20));
        monthsoptionaMF.setForeground(Color.WHITE);
        monthsoptionaMF.setOpaque(true);
        monthsoptionaMF.setSelectedItem(nameofTabelenow.toLowerCase());
        monthsoptionaMF.addItemListener(this);


        toplabelcoverMF=new JPanel();
        toplabelcoverMF.setBorder(BorderFactory.createCompoundBorder(a4, a3));
        toplabelcoverMF.setLayout(null);
        toplabelcoverMF.setVisible(false);


        monthlyfeepanelMF=new JPanel();
        monthlyfeepanelMF.setBorder(BorderFactory.createCompoundBorder(a1, a2));
        monthlyfeepanelMF.setLayout(null);
        monthlyfeepanelMF.add(backbtnMF);
        monthlyfeepanelMF.add(feeifldMF);
        monthlyfeepanelMF.add(dateofjoinifldMF);
        monthlyfeepanelMF.add(cnicifldMF);
        monthlyfeepanelMF.add(phoneifldMF);
        monthlyfeepanelMF.add(idifldMF);
        monthlyfeepanelMF.add(nameifldMF);
        monthlyfeepanelMF.add(feeilblMF);
        monthlyfeepanelMF.add(dateofjoinilblMF);
        monthlyfeepanelMF.add(cnicilblMF);
        monthlyfeepanelMF.add(phoneilblMF);
        monthlyfeepanelMF.add(idilblMF);
        monthlyfeepanelMF.add(nameilblMF);
        monthlyfeepanelMF.add(imagelblMF);
        monthlyfeepanelMF.add(tablecontainerMF);
        monthlyfeepanelMF.add(showtableMF);
        monthlyfeepanelMF.add(HidetableMF);
        monthlyfeepanelMF.add(monthslblMF);
        monthlyfeepanelMF.add(monthsoptionaMF);
        monthlyfeepanelMF.add(feecollectedlblMF);
        monthlyfeepanelMF.add(feependingMF);
        monthlyfeepanelMF.add(totalfeelblMF);
        monthlyfeepanelMF.add(totalstrengthlblMF);
        monthlyfeepanelMF.add(strengthfldMF);
        monthlyfeepanelMF.add(feependfldMF);
        monthlyfeepanelMF.add(feecollectionfldMF);
        monthlyfeepanelMF.add(totalfeefldMF);
        monthlyfeepanelMF.add(revenuefldMF);
        monthlyfeepanelMF.add(expensefldMF);
        monthlyfeepanelMF.add(profitfldMF);
        monthlyfeepanelMF.add(reveueMF);
        monthlyfeepanelMF.add(ExpensesMF);
        monthlyfeepanelMF.add(ProfitMF);
        


        //............Replace Information of Gym Client .......................................
        datechooserRI=new JDateChooser();
        Date date1RI=new Date();
        datechooserRI.setDate(date1RI);
        datechooserRI.setBackground(new Color(20,20,20));
        datechooserRI.setBorder(b1);
        datechooserRI.setMaxSelectableDate(date1RI);
        LocalDate dlcalRI=LocalDate.of(2000, 1, 1);
        ZonedDateTime zdtRI = dlcalRI.atStartOfDay(ZoneId.systemDefault());
        datechooserRI.setMinSelectableDate(Date.from(zdtRI.toInstant()));
        datechooserRI.getCalendarButton().setBackground(new Color(20,20,20));
        datechooserRI.setDateFormatString("dd-MM-yyyy");
        datechooserRI.getComponent(1).setBackground(new Color(20,20,20));
        datechooserRI.getComponent(1).setForeground(Color.WHITE);
        datechooserRI.getComponent(0).setBackground(new Color(20,20,20));
        datechooserRI.getComponent(0).setForeground(Color.WHITE);
        datechooserRI.getCalendarButton().addMouseListener(new MouseListener(){

            @Override
            public void mouseClicked(MouseEvent e) {
                if(e.getSource()==datechooserRI.getCalendarButton()){
                    replacebtnRI.setVisible(true);
                }
            }

            @Override
            public void mousePressed(MouseEvent e) {
              
                
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                
                
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                
                
            }

            @Override
            public void mouseExited(MouseEvent e) {
                
                
            }
            
        });
        
        fielddateRI=(JTextField)datechooserRI.getComponent(1);
        fielddateRI.setEditable(false);
        fielddateRI.setBorder(b1);
        calenbtnRI=(JButton)datechooserRI.getComponent(0);
        calenbtnRI.setPreferredSize(new Dimension(40,40));


        JPanel s1RI=(JSpinField)datechooserRI.getJCalendar().getYearChooser();
        s1RI.setBackground(midblack);
        s1RI.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        JSpinner spnRI=(JSpinner)s1RI.getComponent(0);
        spnRI.getEditor().setBackground(midblack);
        
        spnRI.setForeground(Color.white);
        spnRI.getEditor().setBorder(BorderFactory.createLineBorder(Color.BLACK));
        s1RI.setForeground(Color.white);

        JTextField spntxtRI=(JTextField)spnRI.getEditor();
        spntxtRI.setForeground(Color.white);
        spntxtRI.setEditable(false);
        spntxtRI.addPropertyChangeListener(new PropertyChangeListener(){

            @Override
            public void propertyChange(PropertyChangeEvent evt) {
                
                if(evt.getNewValue()==Color.black){
                    spntxtRI.setForeground(Color.WHITE);
                }
                
            }

        });
        

        ((JTextField)datechooserRI.getComponent(1)).setOpaque(true);
        ((JTextField)datechooserRI.getComponent(1)).addPropertyChangeListener(new PropertyChangeListener(){

            @Override
            public void propertyChange(PropertyChangeEvent evt) {
                
                if(evt.getNewValue()==Color.black){
                    ((JTextField)datechooserRI.getComponent(1)).setForeground(Color.white);
                    
                }
                
            }

        });


        datechooserRI.setBorder(b1);
        datechooserRI.getJCalendar().getDayChooser().setBackground(midblack);
        datechooserRI.getJCalendar().getMonthChooser().getComboBox().setBackground(midblack);
        datechooserRI.getJCalendar().getMonthChooser().getComboBox().setForeground(Color.WHITE);
        datechooserRI.getJCalendar().getDayChooser().getDayPanel().setBackground(midblack);
        Object[] btsRI=datechooserRI.getJCalendar().getDayChooser().getDayPanel().getComponents();
        datechooserRI.getJCalendar().getDayChooser().setWeekdayForeground(Color.green);
        datechooserRI.getJCalendar().setBackground(midblack);
        datechooserRI.getJCalendar().getDayChooser().getComponent(1).setBackground(Color.BLACK);
        Object[] btRI=((JPanel)datechooserRI.getJCalendar().getDayChooser().getComponent(1)).getComponents();
        datechooserRI.getJCalendar().getDayChooser().setForeground(Color.WHITE);
        datechooserRI.getJCalendar().setBorder(b1);
        for (Object i : btsRI) {

            if(i instanceof JButton ){
                if(((JButton)i)!=null){
                    ((JButton)i).setBackground(midblack);
                    ((JButton)i).setOpaque(false);
                    ((JButton)i).setContentAreaFilled(false);
                    JButton buttonRI=((JButton)i);
                    char[] textRI=buttonRI.getText().toCharArray();
                    if(textRI.length>0){
                        if(Character.isDigit(textRI[0])){
                            ((JButton)i).setBackground(midblack);
                            ((JButton)i).setForeground(Color.WHITE);
                            // ((JButton)i).setOpaque(true);
                            buttonRI.setVisible(false);
                        }
                    }
                   
                }
            }
           

        }

        for (Object l : btRI) {

            if(l instanceof JButton ){
                ((JButton)l).setBackground(midblack);
            }
            
        }
        
        datechooserRI.setVisible(false);

        tableContainerRI=new JPanel();
        tableContainerRI.setBackground(new Color(20,20,20));

        tablecellrendererRI=new DefaultTableCellRenderer();
        tablecellrendererRI.setHorizontalAlignment(0);
        tableRI=new JTable();
        tableRI.setModel(new DefaultTableModel(null,headerRI){
            @Override
            public boolean isCellEditable(int row, int column) {

                return false;
            }

        });
        tableRI.setDefaultRenderer(Object.class, tablecellrendererRI);
        tableRI.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        tableRI.setGridColor(Color.darkGray);
        tableRI.getTableHeader().setResizingAllowed(false);
        tableRI.getTableHeader().setReorderingAllowed(false);
        tableRI.setBackground(new Color(20,20,20));
        tableRI.setForeground(new Color(207, 204, 68));
        tableRI.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        paneRI=new JScrollPane(tableRI);
        paneRI.setOpaque(false);

        tableContainerRI.setLayout(new BorderLayout());
        tableContainerRI.setOpaque(false);
        tableContainerRI.add(paneRI);
        tableContainerRI.setVisible(true);


        namelblRI=new JLabel("Name :");
        namelblRI.setForeground(Color.white);
        namelblRI.setHorizontalAlignment(0);
        namelblRI.setVerticalAlignment(0);
        namelblRI.setOpaque(false);
        namelblRI.setVisible(false);

        namefldRI=new JTextField();
        namefldRI.setBackground(new Color(20,20,20));
        namefldRI.setForeground(Color.white);
        namefldRI.setOpaque(true);
        namefldRI.setVisible(false);
        namefldRI.addKeyListener(this);


        idlblRI=new JLabel("ID :");
        idlblRI.setForeground(Color.white);
        idlblRI.setHorizontalAlignment(0);
        idlblRI.setVerticalAlignment(0);
        idlblRI.setOpaque(false);
        idlblRI.setVisible(false);

        idfldRI=new JTextField();
        idfldRI.setBackground(new Color(20,20,20));
        idfldRI.setForeground(Color.white);
        idfldRI.addKeyListener(this);
        idfldRI.setOpaque(true);
        idfldRI.setVisible(false);

        cniclblRI=new JLabel("CNIC :");
        cniclblRI.setForeground(Color.white);
        cniclblRI.setHorizontalAlignment(0);
        cniclblRI.setVerticalAlignment(0);
        cniclblRI.setOpaque(false);
        cniclblRI.setVisible(false);

        cnicfldRI=new JTextField();
        cnicfldRI.setBackground(new Color(20,20,20));
        cnicfldRI.setForeground(Color.white);
        cnicfldRI.setOpaque(true);
        cnicfldRI.setVisible(false);
        cnicfldRI.addKeyListener(this);

        phonelblRI=new JLabel("Phone Number :");
        phonelblRI.setForeground(Color.white);
        phonelblRI.setHorizontalAlignment(4);
        phonelblRI.setVerticalAlignment(0);
        phonelblRI.setOpaque(false);
        phonelblRI.setVisible(false);

        phonefldRI=new JTextField();
        phonefldRI.setBackground(new Color(20,20,20));
        phonefldRI.setForeground(Color.white);
        phonefldRI.setOpaque(true);
        phonefldRI.setVisible(false);
        phonefldRI.addKeyListener(this);


        dateofjoinlblRI=new JLabel("Date of Join :");
        dateofjoinlblRI.setForeground(Color.white);
        dateofjoinlblRI.setHorizontalAlignment(0);
        dateofjoinlblRI.setVerticalAlignment(0);
        dateofjoinlblRI.setOpaque(false);
        dateofjoinlblRI.setVisible(false);



        replacebtnRI=new JButton("Replace Information");
        replacebtnRI.setForeground(Color.green);
        replacebtnRI.setBackground(new Color(20,20,20));
        replacebtnRI.setOpaque(false);
        replacebtnRI.setFocusable(false);
        replacebtnRI.addActionListener(this);




        SelectbtnRI=new JButton("Select");
        SelectbtnRI.setForeground(Color.green);
        SelectbtnRI.setBackground(new Color(20,20,20));
        SelectbtnRI.setOpaque(false);
        SelectbtnRI.setFocusable(false);
        SelectbtnRI.addActionListener(this);

        
        selectlblRI=new JLabel("Select :");
        selectlblRI.setForeground(Color.white);
        selectlblRI.setHorizontalAlignment(0);
        selectlblRI.setVerticalAlignment(0);
        selectlblRI.setOpaque(false);
        
        optionsRI=new JComboBox<String>(optionsfldsRI);
        optionsRI.setBackground(new Color(20,20,20));
        optionsRI.setForeground(Color.white);
        optionsRI.setOpaque(true);
        optionsRI.addItemListener(this);

        replaceimagebtnRI=new JButton("Change Image");
        replaceimagebtnRI.setForeground(Color.ORANGE);
        replaceimagebtnRI.setBackground(new Color(20,20,20));
        replaceimagebtnRI.setFocusable(false);
        replaceimagebtnRI.setHorizontalTextPosition(0);
        replaceimagebtnRI.setVerticalTextPosition(0);
        replaceimagebtnRI.addActionListener(this);

        
        imagelblRI=new JLabel();
        imagelblRI.setBorder(b1);
        imagelblRI.setHorizontalAlignment(0);
        imagelblRI.setVerticalAlignment(0);
        imagelblRI.setForeground(Color.white);
        imagelblRI.setOpaque(false);
        imagelblRI.setVisible(false);

        backbtnRI=new JButton();
        backbtnRI.setBackground(new Color(20,20,20));
        backbtnRI.setForeground(Color.orange);
        backbtnRI.setBorder(BorderFactory.createEmptyBorder());
        backbtnRI.setOpaque(false);
        backbtnRI.setFocusable(false);
        backbtnRI.setVisible(false);
        backbtnRI.addActionListener(this);

        namesfldRI=new JTextField();
        namesfldRI.setBackground(new Color(20,20,20));
        namesfldRI.setForeground(Color.white);
        namesfldRI.setOpaque(true);
        namesfldRI.setVisible(false);

        idsfldRI=new JTextField();
        idsfldRI.setBackground(new Color(20,20,20));
        idsfldRI.setForeground(Color.white);
        idsfldRI.addKeyListener(this);
        idsfldRI.setOpaque(true);
        idsfldRI.setVisible(false);

        searchbtnRI=new JButton("Search");
        searchbtnRI.setForeground(Color.green);
        searchbtnRI.setBackground(new Color(20,20,20));
        searchbtnRI.setOpaque(false);
        searchbtnRI.setFocusable(false);
        searchbtnRI.addActionListener(this);

        clearbtnRI=new JButton("Clear");
        clearbtnRI.setForeground(Color.ORANGE);
        clearbtnRI.setBackground(new Color(20,20,20));
        clearbtnRI.setOpaque(false);
        clearbtnRI.setFocusable(false);
        clearbtnRI.addActionListener(this);
        


        toplabelcoverRI=new JPanel();
        toplabelcoverRI.setBorder(BorderFactory.createCompoundBorder(a4, a3));
        toplabelcoverRI.setLayout(null);
        toplabelcoverRI.setVisible(false);


        replacepanelRI=new JPanel();
        replacepanelRI.setBorder(BorderFactory.createCompoundBorder(a1, a2));
        replacepanelRI.setLayout(null);
        replacepanelRI.add(datechooserRI);
        replacepanelRI.add(replaceimagebtnRI);
        replacepanelRI.add(backbtnRI);
        replacepanelRI.add(imagelblRI);
        replacepanelRI.add(replacebtnRI);
        replacepanelRI.add(SelectbtnRI);
        replacepanelRI.add(phonefldRI);
        replacepanelRI.add(cnicfldRI);
        replacepanelRI.add(idsfldRI);
        replacepanelRI.add(namesfldRI);
        replacepanelRI.add(idfldRI);
        replacepanelRI.add(namefldRI);
        replacepanelRI.add(dateofjoinlblRI);
        replacepanelRI.add(phonelblRI);
        replacepanelRI.add(cniclblRI);
        replacepanelRI.add(idlblRI);
        replacepanelRI.add(namelblRI);
        replacepanelRI.add(tableContainerRI);
        replacepanelRI.add(clearbtnRI);
        replacepanelRI.add(searchbtnRI);
        replacepanelRI.add(optionsRI);
        replacepanelRI.add(selectlblRI);
        


        //............Add Fee of Gym Client .......................................
        searchlblSGC=new JLabel();
        tablecontainerAF=new JPanel();
        tablecontainerAF.setBackground(new Color(20,20,20));
        backbtnAF=new JButton();

        tablecellrendererAF=new DefaultTableCellRenderer();
        tablecellrendererAF.setHorizontalAlignment(0);
        searchtableAF=new JTable();
        searchtableAF.setModel(new DefaultTableModel(null, headerAF){
            @Override
            public boolean isCellEditable(int row, int column) {

                return false;
            }

        });
        searchtableAF.setDefaultRenderer(Object.class, tablecellrendererAF);
        searchtableAF.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        searchtableAF.setGridColor(Color.darkGray);
        searchtableAF.getTableHeader().setResizingAllowed(false);
        searchtableAF.getTableHeader().setReorderingAllowed(false);
        searchtableAF.setBackground(new Color(20,20,20));
        searchtableAF.setForeground(new Color(207, 204, 68));
        searchtableAF.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        tablepaneAF=new JScrollPane(searchtableAF);
        tablepaneAF.setOpaque(false);

        tablecontainerAF=new JPanel();
        tablecontainerAF.setLayout(new BorderLayout());
        tablecontainerAF.setOpaque(false);
        tablecontainerAF.add(tablepaneAF);
        tablecontainerAF.setVisible(true);

        searchlblAF=new JLabel("Search :");
        namefldAF=new JTextField();
        idfldAF=new JTextField();
        searchbtnAF=new JButton();
        clearbtnAF=new JButton();
        addfeeAF=new JButton();
        instructionAF=new JLabel();
        feelblAF=new JLabel();
        feefldAF=new JTextField();

        nameifldAF=new JTextField();
        idifldAF=new JTextField();
        cnicifldAF=new JTextField();
        phoneifldAF=new JTextField();
        dateofjoinifldAF=new JTextField();
        feeifldAF=new JTextField();

        imagelblAF=new JLabel();
        nameilblAF=new JLabel();
        idilblAF=new JLabel();
        cnicilblAF=new JLabel();
        phoneilblAF=new JLabel();
        dateofjoinilblAF=new JLabel();
        feeilblAF=new JLabel();

        
        backbtnAF.setBackground(new Color(20,20,20));
        backbtnAF.setForeground(Color.orange);
        backbtnAF.setBorder(BorderFactory.createEmptyBorder());
        backbtnAF.setOpaque(false);
        backbtnAF.setFocusable(false);
        backbtnAF.setVisible(false);
        backbtnAF.addActionListener(this);

        feeifldAF.setBackground(new Color(20,20,20));
        feeifldAF.setForeground(Color.white);
        feeifldAF.setOpaque(true);
        feeifldAF.setVisible(false);
        feeifldAF.setEditable(false);

        dateofjoinifldAF.setBackground(new Color(20,20,20));
        dateofjoinifldAF.setForeground(Color.white);
        dateofjoinifldAF.setOpaque(true);
        dateofjoinifldAF.setVisible(false);
        dateofjoinifldAF.setEditable(false);

        phoneifldAF.setBackground(new Color(20,20,20));
        phoneifldAF.setForeground(Color.white);
        phoneifldAF.setOpaque(true);
        phoneifldAF.setVisible(false);
        phoneifldAF.setEditable(false);

        cnicifldAF.setBackground(new Color(20,20,20));
        cnicifldAF.setForeground(Color.white);
        cnicifldAF.setOpaque(true);
        cnicifldAF.setVisible(false);
        cnicifldAF.setEditable(false);

        idifldAF.setBackground(new Color(20,20,20));
        idifldAF.setForeground(Color.white);
        idifldAF.setOpaque(true);
        idifldAF.setVisible(false);
        idifldAF.setEditable(false);

        nameifldAF.setBackground(new Color(20,20,20));
        nameifldAF.setForeground(Color.white);
        nameifldAF.setOpaque(true);
        nameifldAF.setVisible(false);
        nameifldAF.setEditable(false);

        feeilblAF.setText("Fee :");
        feeilblAF.setHorizontalAlignment(10);
        feeilblAF.setVerticalAlignment(0);
        feeilblAF.setForeground(Color.white);
        feeilblAF.setOpaque(false);

        dateofjoinilblAF.setText("Date of Join :");
        dateofjoinilblAF.setHorizontalAlignment(10);
        dateofjoinilblAF.setVerticalAlignment(0);
        dateofjoinilblAF.setForeground(Color.white);
        dateofjoinilblAF.setOpaque(false);

        phoneilblAF.setText("Phone :");
        phoneilblAF.setHorizontalAlignment(10);
        phoneilblAF.setVerticalAlignment(0);
        phoneilblAF.setForeground(Color.white);
        phoneilblAF.setOpaque(false);

        cnicilblAF.setText("CNIC :");
        cnicilblAF.setHorizontalAlignment(10);
        cnicilblAF.setVerticalAlignment(0);
        cnicilblAF.setForeground(Color.white);
        cnicilblAF.setOpaque(false);

        idilblAF.setText("ID :");
        idilblAF.setHorizontalAlignment(10);
        idilblAF.setVerticalAlignment(0);
        idilblAF.setForeground(Color.white);
        idilblAF.setOpaque(false);

        nameilblAF.setText("Name :");
        nameilblAF.setHorizontalAlignment(10);
        nameilblAF.setVerticalAlignment(0);
        nameilblAF.setForeground(Color.white);
        nameilblAF.setOpaque(false);

        imagelblAF.setBorder(b1);
        imagelblAF.setHorizontalAlignment(0);
        imagelblAF.setVerticalAlignment(0);
        nameilblAF.setForeground(Color.white);
        imagelblAF.setOpaque(false);

        imagelblAF.setVisible(false);
        nameilblAF.setVisible(false);
        idilblAF.setVisible(false);
        cnicilblAF.setVisible(false);
        phoneilblAF.setVisible(false);
        dateofjoinilblAF.setVisible(false);
        feeilblAF.setVisible(false);

        String[] optionaf={"Select","Name","ID","Fee Remainings"};
        searchoptionsAF=new JComboBox<>(optionaf);

        feelblAF.setText("Enter Fee :");
        feelblAF.setHorizontalAlignment(0);
        feelblAF.setVerticalAlignment(0);
        feelblAF.setForeground(Color.WHITE);
        feelblAF.setOpaque(false);
        feelblAF.setVisible(false);

        feefldAF.setBackground(new Color(20,20,20));
        feefldAF.setOpaque(true);
        feefldAF.setForeground(Color.white);
        feefldAF.addKeyListener(this);
        feefldAF.setVisible(false);



        addfeeAF.setText("Add Fee");
        addfeeAF.setBackground(new Color(20,20,20));
        addfeeAF.setForeground(Color.green);
        addfeeAF.setOpaque(false);
        addfeeAF.setFocusable(false);
        addfeeAF.addActionListener(this);

        instructionAF.setText("Select Gym Member and click Add Fee Button");
        instructionAF.setForeground(Color.green);
        instructionAF.setOpaque(false);



        searchlblAF.setHorizontalAlignment(0);
        searchlblAF.setVerticalAlignment(0);
        searchlblAF.setForeground(Color.white);
        searchlblAF.setOpaque(false);

        namefldAF.setBackground(new Color(20,20,20));
        namefldAF.setForeground(Color.white);
        namefldAF.setOpaque(true);
        namefldAF.setVisible(false);

        
        idfldAF.setBackground(new Color(20,20,20));
        idfldAF.setForeground(Color.white);
        idfldAF.setOpaque(true);
        idfldAF.addKeyListener(this);
        idfldAF.setVisible(false);

        searchoptionsAF.setSelectedIndex(0);
        searchoptionsAF.setBackground(new Color(20,20,20));
        searchoptionsAF.setForeground(Color.white);
        searchoptionsAF.setOpaque(true);
        searchoptionsAF.addItemListener(this);



        searchbtnAF.setText("Search");
        searchbtnAF.setBackground(new Color(20,20,20));
        searchbtnAF.setForeground(Color.green);
        searchbtnAF.setOpaque(false);
        searchbtnAF.setFocusable(false);
        searchbtnAF.addActionListener(this);
        searchbtnAF.setEnabled(false);

        clearbtnAF.setText("Clear");
        clearbtnAF.setBackground(new Color(20,20,20));
        clearbtnAF.setForeground(Color.orange);
        clearbtnAF.setOpaque(false);
        clearbtnAF.setFocusable(false);
        clearbtnAF.addActionListener(this);

        toplabelcoverAF=new JPanel();
        toplabelcoverAF.setBorder(BorderFactory.createCompoundBorder(a4, a3));
        toplabelcoverAF.setLayout(null);
        toplabelcoverAF.setVisible(false);


        feepanelAF=new JPanel();
        feepanelAF.setBorder(BorderFactory.createCompoundBorder(a1, a2));
        feepanelAF.setLayout(null);
        feepanelAF.add(feeifldAF);
        feepanelAF.add(dateofjoinifldAF);
        feepanelAF.add(cnicifldAF);
        feepanelAF.add(phoneifldAF);
        feepanelAF.add(idifldAF);
        feepanelAF.add(nameifldAF);
        feepanelAF.add(feeilblAF);
        feepanelAF.add(dateofjoinilblAF);
        feepanelAF.add(cnicilblAF);
        feepanelAF.add(phoneilblAF);
        feepanelAF.add(idilblAF);
        feepanelAF.add(nameilblAF);
        feepanelAF.add(imagelblAF);
        feepanelAF.add(feelblAF);
        feepanelAF.add(feefldAF);
        feepanelAF.add(addfeeAF);
        feepanelAF.add(instructionAF);
        feepanelAF.add(tablecontainerAF);
        feepanelAF.add(searchoptionsAF);
        feepanelAF.add(backbtnAF);
        feepanelAF.add(clearbtnAF);
        feepanelAF.add(searchbtnAF);
        feepanelAF.add(namefldAF);
        feepanelAF.add(idfldAF);
        feepanelAF.add(searchlblAF);
        

        //............Search Gym Client .......................................
        datechooserSGC=new JDateChooser();
        Date date1SGC=new Date();
        datechooserSGC.setDate(date1SGC);
        datechooserSGC.setBackground(new Color(20,20,20));
        datechooserSGC.setBorder(b1);
        datechooserSGC.setMaxSelectableDate(date1SGC);
        LocalDate dlcalSGC=LocalDate.of(2000, 1, 1);
        ZonedDateTime zdtSGC = dlcalSGC.atStartOfDay(ZoneId.systemDefault());
        datechooserSGC.setMinSelectableDate(Date.from(zdtSGC.toInstant()));
        datechooserSGC.getCalendarButton().setBackground(new Color(20,20,20));
        datechooserSGC.setDateFormatString("dd-MM-yyyy");
        datechooserSGC.getComponent(1).setBackground(new Color(20,20,20));
        datechooserSGC.getComponent(1).setForeground(Color.WHITE);
        datechooserSGC.getComponent(0).setBackground(new Color(20,20,20));
        datechooserSGC.getComponent(0).setForeground(Color.WHITE);
        fielddateSGC=(JTextField)datechooserSGC.getComponent(1);
        fielddateSGC.setEditable(false);
        fielddateSGC.setBorder(b1);
        calenbtnSGC=(JButton)datechooserSGC.getComponent(0);
        calenbtnSGC.setPreferredSize(new Dimension(40,40));

        JPanel s1SGC=(JSpinField)datechooserSGC.getJCalendar().getYearChooser();
        s1SGC.setBackground(midblack);
        s1SGC.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        JSpinner spnSGC=(JSpinner)s1SGC.getComponent(0);
        spnSGC.getEditor().setBackground(midblack);
        
        spnSGC.setForeground(Color.white);
        spnSGC.getEditor().setBorder(BorderFactory.createLineBorder(Color.BLACK));
        s1SGC.setForeground(Color.white);

        JTextField spntxtSGC=(JTextField)spnSGC.getEditor();
        spntxtSGC.setForeground(Color.white);
        spntxtSGC.setEditable(false);
        spntxtSGC.addPropertyChangeListener(new PropertyChangeListener(){

            @Override
            public void propertyChange(PropertyChangeEvent evt) {
                
                if(evt.getNewValue()==Color.black){
                    spntxtSGC.setForeground(Color.WHITE);
                }
                
            }

        });
        

        ((JTextField)datechooserSGC.getComponent(1)).setOpaque(true);
        ((JTextField)datechooserSGC.getComponent(1)).addPropertyChangeListener(new PropertyChangeListener(){

            @Override
            public void propertyChange(PropertyChangeEvent evt) {
                
                if(evt.getNewValue()==Color.black){
                    ((JTextField)datechooserSGC.getComponent(1)).setForeground(Color.white);
                }
                
            }

        });


        datechooserSGC.setBorder(b1);
        datechooserSGC.getJCalendar().getDayChooser().setBackground(midblack);
        datechooserSGC.getJCalendar().getMonthChooser().getComboBox().setBackground(midblack);
        datechooserSGC.getJCalendar().getMonthChooser().getComboBox().setForeground(Color.WHITE);
        datechooserSGC.getJCalendar().getDayChooser().getDayPanel().setBackground(midblack);
        Object[] btsSGC=datechooserSGC.getJCalendar().getDayChooser().getDayPanel().getComponents();
        datechooserSGC.getJCalendar().getDayChooser().setWeekdayForeground(Color.green);
        datechooserSGC.getJCalendar().setBackground(midblack);
        datechooserSGC.getJCalendar().getDayChooser().getComponent(1).setBackground(Color.BLACK);
        Object[] btSGC=((JPanel)datechooserSGC.getJCalendar().getDayChooser().getComponent(1)).getComponents();
        datechooserSGC.getJCalendar().getDayChooser().setForeground(Color.WHITE);
        datechooserSGC.getJCalendar().setBorder(b1);
        for (Object i : btsSGC) {

            if(i instanceof JButton ){
                if(((JButton)i)!=null){
                    ((JButton)i).setBackground(midblack);
                    ((JButton)i).setOpaque(false);
                    ((JButton)i).setContentAreaFilled(false);
                    JButton buttonSGC=((JButton)i);
                    char[] textSGC=buttonSGC.getText().toCharArray();
                    if(textSGC.length>0){
                        if(Character.isDigit(textSGC[0])){
                            ((JButton)i).setBackground(midblack);
                            ((JButton)i).setForeground(Color.WHITE);
                            // ((JButton)i).setOpaque(true);
                            buttonSGC.setVisible(false);
                        }
                    }
                   
                }
            }
           

        }

        for (Object l : btSGC) {

            if(l instanceof JButton ){
                ((JButton)l).setBackground(midblack);
            }
            
        }
        

        datechooserSGC.setVisible(false);

        searchlblSGC=new JLabel();
        String[] soptions={"Select","ID","Name","CNIC","Name of Admin","Date of Join","Phone Number"};
        searchoptionsSGC=new JComboBox<String>(soptions);
        searchSGC=new JButton();
        clearSGC=new JButton();
        idfldSGC=new JTextField();
        namefldSGC=new JTextField();
        cnicfldSGC=new JTextField();
        nameofAdminfldSGC=new JTextField();
        datefldSGC2=new JTextField();
        phonefldSGC=new JTextField();
        tablecontainerSGC=new JPanel();

        tablecontainerSGC.setBackground(new Color(20,20,20));

        tablecellrendererSGC=new DefaultTableCellRenderer();
        tablecellrendererSGC.setHorizontalAlignment(0);
        searchtable=new JTable();
        searchtable.setModel(new DefaultTableModel(null, headerRGC){
            @Override
            public boolean isCellEditable(int row, int column) {

                return false;
            }

        });
        searchtable.setDefaultRenderer(Object.class, tablecellrendererSGC);
        searchtable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        searchtable.setGridColor(Color.darkGray);
        searchtable.getTableHeader().setResizingAllowed(false);
        searchtable.getTableHeader().setReorderingAllowed(false);
        searchtable.setBackground(new Color(20,20,20));
        searchtable.setForeground(new Color(207, 204, 68));
        tablepaneSGC=new JScrollPane(searchtable);
        tablepaneSGC.setOpaque(false);

        tablecontainerSGC=new JPanel();
        tablecontainerSGC.setLayout(new BorderLayout());
        tablecontainerSGC.setOpaque(false);
        tablecontainerSGC.add(tablepaneSGC);
        tablecontainerSGC.setVisible(true);

        nameifldSGC=new JTextField();
        idifldSGC=new JTextField();
        cnicifldSGC=new JTextField();
        phoneifldSGC=new JTextField();
        dateofjoinifldSGC=new JTextField();
        feeifldSGC=new JTextField();

        imagelblSGC=new JLabel();
        nameilblSGC=new JLabel();
        idilblSGC=new JLabel();
        cnicilblSGC=new JLabel();
        phoneilblSGC=new JLabel();
        dateofjoinilblSGC=new JLabel();
        feeilblSGC=new JLabel();
        backbtnSGC=new JButton();

        
        backbtnSGC.setBackground(new Color(20,20,20));
        backbtnSGC.setForeground(Color.orange);
        backbtnSGC.setBorder(BorderFactory.createEmptyBorder());
        backbtnSGC.setOpaque(false);
        backbtnSGC.setFocusable(false);
        backbtnSGC.setVisible(false);
        backbtnSGC.addActionListener(this);

        feeifldSGC.setBackground(new Color(20,20,20));
        feeifldSGC.setForeground(Color.white);
        feeifldSGC.setOpaque(true);
        feeifldSGC.setVisible(false);
        feeifldSGC.setEditable(false);

        dateofjoinifldSGC.setBackground(new Color(20,20,20));
        dateofjoinifldSGC.setForeground(Color.white);
        dateofjoinifldSGC.setOpaque(true);
        dateofjoinifldSGC.setVisible(false);
        dateofjoinifldSGC.setEditable(false);

        phoneifldSGC.setBackground(new Color(20,20,20));
        phoneifldSGC.setForeground(Color.white);
        phoneifldSGC.setOpaque(true);
        phoneifldSGC.setVisible(false);
        phoneifldSGC.setEditable(false);

        cnicifldSGC.setBackground(new Color(20,20,20));
        cnicifldSGC.setForeground(Color.white);
        cnicifldSGC.setOpaque(true);
        cnicifldSGC.setVisible(false);
        cnicifldSGC.setEditable(false);

        idifldSGC.setBackground(new Color(20,20,20));
        idifldSGC.setForeground(Color.white);
        idifldSGC.setOpaque(true);
        idifldSGC.setVisible(false);
        idifldSGC.setEditable(false);

        nameifldSGC.setBackground(new Color(20,20,20));
        nameifldSGC.setForeground(Color.white);
        nameifldSGC.setOpaque(true);
        nameifldSGC.setVisible(false);
        nameifldSGC.setEditable(false);

        feeilblSGC.setText("Fee :");
        feeilblSGC.setHorizontalAlignment(10);
        feeilblSGC.setVerticalAlignment(0);
        feeilblSGC.setForeground(Color.white);
        feeilblSGC.setOpaque(false);

        dateofjoinilblSGC.setText("Date of Join :");
        dateofjoinilblSGC.setHorizontalAlignment(10);
        dateofjoinilblSGC.setVerticalAlignment(0);
        dateofjoinilblSGC.setForeground(Color.white);
        dateofjoinilblSGC.setOpaque(false);

        phoneilblSGC.setText("Phone :");
        phoneilblSGC.setHorizontalAlignment(10);
        phoneilblSGC.setVerticalAlignment(0);
        phoneilblSGC.setForeground(Color.white);
        phoneilblSGC.setOpaque(false);

        cnicilblSGC.setText("CNIC :");
        cnicilblSGC.setHorizontalAlignment(10);
        cnicilblSGC.setVerticalAlignment(0);
        cnicilblSGC.setForeground(Color.white);
        cnicilblSGC.setOpaque(false);

        idilblSGC.setText("ID :");
        idilblSGC.setHorizontalAlignment(10);
        idilblSGC.setVerticalAlignment(0);
        idilblSGC.setForeground(Color.white);
        idilblSGC.setOpaque(false);

        nameilblSGC.setText("Name :");
        nameilblSGC.setHorizontalAlignment(10);
        nameilblSGC.setVerticalAlignment(0);
        nameilblSGC.setForeground(Color.white);
        nameilblSGC.setOpaque(false);

        imagelblSGC.setBorder(b1);
        imagelblSGC.setHorizontalAlignment(0);
        imagelblSGC.setVerticalAlignment(0);
        nameilblSGC.setForeground(Color.white);
        imagelblSGC.setOpaque(false);

        imagelblSGC.setVisible(false);
        nameilblSGC.setVisible(false);
        idilblSGC.setVisible(false);
        cnicilblSGC.setVisible(false);
        phoneilblSGC.setVisible(false);
        dateofjoinilblSGC.setVisible(false);
        feeilblSGC.setVisible(false);


        idfldSGC.setForeground(Color.white);
        idfldSGC.setBackground(new Color(20,20,20));

        namefldSGC.setForeground(Color.white);
        namefldSGC.setBackground(new Color(20,20,20));

        cnicfldSGC.setForeground(Color.white);
        cnicfldSGC.setBackground(new Color(20,20,20));

        nameofAdminfldSGC.setForeground(Color.white);
        nameofAdminfldSGC.setBackground(new Color(20,20,20));

        
        phonefldSGC.setForeground(Color.white);
        phonefldSGC.setBackground(new Color(20,20,20));

        searchlblSGC.setText("Search :");
        searchlblSGC.setForeground(Color.white);
        searchlblSGC.setOpaque(false);
        searchlblSGC.setVisible(true);

        searchoptionsSGC.setSelectedIndex(0);
        searchoptionsSGC.setBackground(new Color(20,20,20));
        searchoptionsSGC.setForeground(Color.white);
        searchoptionsSGC.addItemListener(this);
        searchoptionsSGC.setOpaque(true);
        searchoptionsSGC.setVisible(true);

        searchSGC.setText("Search");
        searchSGC.setForeground(Color.green);
        searchSGC.setBackground(Color.black);
        searchSGC.setHorizontalAlignment(0);
        searchSGC.setFocusable(false);
        searchSGC.setOpaque(false);
        searchSGC.addActionListener(this);


        clearSGC.setText("Clear");
        clearSGC.setForeground(Color.orange);
        clearSGC.setBackground(Color.black);
        clearSGC.setHorizontalAlignment(0);
        clearSGC.setFocusable(false);
        clearSGC.setOpaque(false);
        clearSGC.addActionListener(this);

        idfldSGC.setVisible(false);
        namefldSGC.setVisible(false);
        cnicfldSGC.setVisible(false);
        nameofAdminfldSGC.setVisible(false);
        phonefldSGC.setVisible(false);

        idfldSGC.addKeyListener(this);
        cnicfldSGC.addKeyListener(this);
        phonefldSGC.addKeyListener(this);


        toplabelcoverSGC=new JPanel();
        toplabelcoverSGC.setBorder(BorderFactory.createCompoundBorder(a4, a3));
        toplabelcoverSGC.setLayout(null);
        toplabelcoverSGC.setVisible(false);


        searchgymmem=new JPanel();
        searchgymmem.setBorder(BorderFactory.createCompoundBorder(a1, a2));
        searchgymmem.setLayout(null);
        searchgymmem.add(datechooserSGC);
        searchgymmem.add(backbtnSGC);
        searchgymmem.add(feeifldSGC);
        searchgymmem.add(dateofjoinifldSGC);
        searchgymmem.add(cnicifldSGC);
        searchgymmem.add(phoneifldSGC);
        searchgymmem.add(idifldSGC);
        searchgymmem.add(nameifldSGC);
        searchgymmem.add(feeilblSGC);
        searchgymmem.add(dateofjoinilblSGC);
        searchgymmem.add(cnicilblSGC);
        searchgymmem.add(phoneilblSGC);
        searchgymmem.add(idilblSGC);
        searchgymmem.add(nameilblSGC);
        searchgymmem.add(imagelblSGC);
        searchgymmem.add(phonefldSGC);
        searchgymmem.add(searchlblSGC);
        searchgymmem.add(searchoptionsSGC);
        searchgymmem.add(searchSGC);
        searchgymmem.add(clearSGC);
        searchgymmem.add(idfldSGC);
        searchgymmem.add(namefldSGC);
        searchgymmem.add(cnicfldSGC);
        searchgymmem.add(nameofAdminfldSGC);
        searchgymmem.add(tablecontainerSGC);



        //............Search Gym Client .......................................


        //............Remove Gym Client .......................................

        this.nameofmemlblRGC=new JLabel();
        this.idofmemlblRGC=new JLabel();
        namememRGC=new JTextField();
        idmemRGC=new JTextField();
        searchRGC=new JButton();
        clearRGC=new JButton();
        removememRGC=new JButton();
        tablecontainerRGC=new JPanel();

        tablecontainerRGC.setBackground(new Color(20,20,20));

        tablecellrenderer=new DefaultTableCellRenderer();
        tablecellrenderer.setHorizontalAlignment(0);
        removetable=new JTable();
        removetable.setModel(new DefaultTableModel(null, headerRGC){
            @Override
            public boolean isCellEditable(int row, int column) {

                return false;
            }

        });
        removetable.setDefaultRenderer(Object.class, tablecellrenderer);
        removetable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        removetable.getTableHeader().setResizingAllowed(false);
        removetable.getTableHeader().setReorderingAllowed(false);
        removetable.setBackground(new Color(20,20,20));
        removetable.setForeground(new Color(207, 204, 68));

        tablepane=new JScrollPane(removetable);
        tablepane.setOpaque(false);

        tablecontainerRGC=new JPanel();
        tablecontainerRGC.setLayout(new BorderLayout());
        tablecontainerRGC.setOpaque(false);
        tablecontainerRGC.add(tablepane);
        tablecontainerRGC.setVisible(true);

        searchRGC.setText("Search");
        searchRGC.setForeground(Color.green);
        searchRGC.setBackground(new Color(20,20,20));
        searchRGC.setOpaque(false);
        searchRGC.setFocusable(false);
        searchRGC.addActionListener(this);

        clearRGC.setText("Clear");
        clearRGC.setForeground(Color.orange);
        clearRGC.setBackground(Color.black);
        clearRGC.setHorizontalAlignment(0);
        clearRGC.setFocusable(false);
        clearRGC.setOpaque(false);
        clearRGC.addActionListener(this);
        

        removememRGC.setText("Remove");
        removememRGC.setForeground(Color.orange);
        removememRGC.setBackground(new Color(20,20,20));
        removememRGC.setOpaque(false);
        removememRGC.setFocusable(false);
        removememRGC.addActionListener(this);
        removememRGC.setVisible(true);


        nameofmemlblRGC.setText("Name :");
        idofmemlblRGC.setText("ID :");

        nameofmemlblRGC.setHorizontalTextPosition(0);
        nameofmemlblRGC.setVerticalTextPosition(0);
        nameofmemlblRGC.setOpaque(false);
        nameofmemlblRGC.setForeground(Color.white);

        idofmemlblRGC.setHorizontalTextPosition(0);
        idofmemlblRGC.setVerticalTextPosition(0);
        idofmemlblRGC.setOpaque(false);
        idofmemlblRGC.setForeground(Color.white);

        namememRGC.setBackground(new Color(20,20,20));
        namememRGC.setForeground(Color.white);
        namememRGC.setOpaque(true);

        idmemRGC.setBackground(new Color(20,20,20));
        idmemRGC.setForeground(Color.white);
        idmemRGC.setOpaque(true);



        
        toplabelcoverRGC=new JPanel();
        toplabelcoverRGC.setBorder(BorderFactory.createCompoundBorder(a4, a3));
        toplabelcoverRGC.setLayout(null);
        toplabelcoverRGC.setVisible(false);


        removegymmem=new JPanel();
        removegymmem.setBorder(BorderFactory.createCompoundBorder(a1, a2));
        removegymmem.setLayout(null);
        removegymmem.add(clearRGC);
        removegymmem.add(removememRGC);
        removegymmem.add(tablecontainerRGC);
        removegymmem.add(nameofmemlblRGC);
        removegymmem.add(idofmemlblRGC);
        removegymmem.add(namememRGC);
        removegymmem.add(idmemRGC);
        removegymmem.add(searchRGC);


        //............Remove Gym Client .......................................


        //............Add Gym Client .......................................




        imagelabelAGC=new JLabel();
        imagelabelAGC.setBorder(b1);
        imagelabelAGC.setOpaque(false);
        imagelabelAGC.setHorizontalAlignment(0);
        imagelabelAGC.setVerticalAlignment(0);


        datechooserAG=new JDateChooser();
        Date date1=new Date();
        datechooserAG.setDate(date1);
        datechooserAG.setBackground(new Color(20,20,20));
        datechooserAG.setBorder(b1);
        datechooserAG.setMaxSelectableDate(date1);
        LocalDate dlcal=LocalDate.of(2000, 1, 1);
        ZonedDateTime zdt = dlcal.atStartOfDay(ZoneId.systemDefault());
        datechooserAG.setMinSelectableDate(Date.from(zdt.toInstant()));
        datechooserAG.getCalendarButton().setBackground(new Color(20,20,20));
        datechooserAG.setDateFormatString("dd-MM-yyyy");
        datechooserAG.getComponent(1).setBackground(new Color(20,20,20));
        datechooserAG.getComponent(1).setForeground(Color.WHITE);
        datechooserAG.getComponent(0).setBackground(new Color(20,20,20));
        datechooserAG.getComponent(0).setForeground(Color.WHITE);
        fielddate=(JTextField)datechooserAG.getComponent(1);
        fielddate.setEditable(false);
        fielddate.setBorder(b1);
        calenbtn=(JButton)datechooserAG.getComponent(0);
        calenbtn.setPreferredSize(new Dimension(40,40));


        JPanel s1=(JSpinField)datechooserAG.getJCalendar().getYearChooser();
        s1.setBackground(midblack);
        s1.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        JSpinner spn=(JSpinner)s1.getComponent(0);
        spn.getEditor().setBackground(midblack);
        
        spn.setForeground(Color.white);
        spn.getEditor().setBorder(BorderFactory.createLineBorder(Color.BLACK));
        s1.setForeground(Color.white);

        JTextField spntxt=(JTextField)spn.getEditor();
        spntxt.setForeground(Color.white);
        spntxt.setEditable(false);
        spntxt.addPropertyChangeListener(new PropertyChangeListener(){

            @Override
            public void propertyChange(PropertyChangeEvent evt) {
                
                if(evt.getNewValue()==Color.black){
                    spntxt.setForeground(Color.WHITE);
                }
                
            }

        });
        

        ((JTextField)datechooserAG.getComponent(1)).setOpaque(true);
        ((JTextField)datechooserAG.getComponent(1)).addPropertyChangeListener(new PropertyChangeListener(){

            @Override
            public void propertyChange(PropertyChangeEvent evt) {
                
                if(evt.getNewValue()==Color.black){
                    ((JTextField)datechooserAG.getComponent(1)).setForeground(Color.white);
                }
                
            }

        });


        datechooserAG.setBorder(b1);
        datechooserAG.getJCalendar().getDayChooser().setBackground(midblack);
        datechooserAG.getJCalendar().getMonthChooser().getComboBox().setBackground(midblack);
        datechooserAG.getJCalendar().getMonthChooser().getComboBox().setForeground(Color.WHITE);
        datechooserAG.getJCalendar().getDayChooser().getDayPanel().setBackground(midblack);
        Object[] bts=datechooserAG.getJCalendar().getDayChooser().getDayPanel().getComponents();
        datechooserAG.getJCalendar().getDayChooser().setWeekdayForeground(Color.green);
        datechooserAG.getJCalendar().setBackground(midblack);
        datechooserAG.getJCalendar().getDayChooser().getComponent(1).setBackground(Color.BLACK);
        Object[] bt=((JPanel)datechooserAG.getJCalendar().getDayChooser().getComponent(1)).getComponents();
        datechooserAG.getJCalendar().getDayChooser().setForeground(Color.WHITE);
        datechooserAG.getJCalendar().setBorder(b1);
        for (Object i : bts) {

            if(i instanceof JButton ){
                if(((JButton)i)!=null){
                    ((JButton)i).setBackground(midblack);
                    ((JButton)i).setOpaque(false);
                    ((JButton)i).setContentAreaFilled(false);
                    JButton button=((JButton)i);
                    char[] text=button.getText().toCharArray();
                    if(text.length>0){
                        if(Character.isDigit(text[0])){
                            ((JButton)i).setBackground(midblack);
                            ((JButton)i).setForeground(Color.WHITE);
                            // ((JButton)i).setOpaque(true);
                            button.setVisible(false);
                        }
                    }
                   
                }
            }
           

        }

        for (Object l : bt) {

            if(l instanceof JButton ){
                ((JButton)l).setBackground(midblack);
            }
            
        }
        



        addimagebtnAGC=new JButton("Add Image");
        addimagebtnAGC.setForeground(Color.ORANGE);
        addimagebtnAGC.setBackground(new Color(20,20,20));
        addimagebtnAGC.setFocusable(false);
        addimagebtnAGC.setHorizontalTextPosition(0);
        addimagebtnAGC.setVerticalTextPosition(0);
        addimagebtnAGC.addActionListener(this);

        



        confirmallfielsAGC=new JCheckBox();
        confirmallfielsAGC.setText("Confirm All Fields");
        confirmallfielsAGC.setIconTextGap(20);
        confirmallfielsAGC.setFocusable(false);
        confirmallfielsAGC.setVerticalTextPosition(0);
        confirmallfielsAGC.setIcon(new ImageIcon(getClass().getResource("icons/normal.png")));
        confirmallfielsAGC.setSelectedIcon(new ImageIcon(getClass().getResource("icons/Selected.png")));
        confirmallfielsAGC.setForeground(Color.YELLOW);
        confirmallfielsAGC.setToolTipText("Confirm Fields");
        confirmallfielsAGC.addItemListener(this);


        expcnic=new JLabel("eg.  3450760448567");
        expcnic.setFont(new Font("Gabriola",0,20));
        expcnic.setForeground(Color.green);
        expcnic.setBackground(new Color(20,20,20));
        expcnic.setVerticalTextPosition(0);
        expcnic.setHorizontalTextPosition(0);

        expphone=new JLabel("eg.  03008004655");
        expphone.setFont(new Font("Gabriola",0,20));
        expphone.setForeground(Color.green);
        expphone.setBackground(new Color(20,20,20));
        expphone.setVerticalTextPosition(0);
        expphone.setHorizontalTextPosition(0);
        
        
        lbldate=new JLabel("dd - MM - yyyy");
        lbldate.setFont(new Font("Gabriola",0,20));
        lbldate.setForeground(Color.green);
        lbldate.setBackground(new Color(20,20,20));
        lbldate.setVerticalTextPosition(0);
        lbldate.setHorizontalTextPosition(0);


        addmemAGC=new JButton("Add Member");
        addmemAGC.setForeground(Color.GREEN);
        addmemAGC.setBackground(new Color(20,20,20));
        addmemAGC.setFocusable(false);
        addmemAGC.setContentAreaFilled(false);
        addmemAGC.setHorizontalTextPosition(0);
        addmemAGC.setVerticalTextPosition(0);
        addmemAGC.addActionListener(this);
        
        clearAGC=new JButton("Clear");
        clearAGC.setForeground(Color.ORANGE);
        clearAGC.setBackground(new Color(20,20,20));
        clearAGC.setFocusable(false);
        clearAGC.setContentAreaFilled(false);
        clearAGC.setHorizontalTextPosition(0);
        clearAGC.setVerticalTextPosition(0);
        clearAGC.addActionListener(this);

        cancelAGC=new JButton("Cancel");
        cancelAGC.setForeground(Color.RED);
        cancelAGC.setBackground(new Color(20,20,20));
        cancelAGC.setFocusable(false);
        cancelAGC.setContentAreaFilled(false);
        cancelAGC.setHorizontalTextPosition(0);
        cancelAGC.setVerticalTextPosition(0);
        cancelAGC.addActionListener(this);



        addgymmem=new JPanel();
        addgymmem.setBorder(BorderFactory.createCompoundBorder(a1, a2));



        
        toplabelcover1=new JPanel();
        toplabelcover1.setBorder(BorderFactory.createCompoundBorder(a4, a3));
        toplabelcover1.setLayout(null);
        toplabelcover1.setVisible(false);


        nameofmem=new JLabel();
        idofmem=new JLabel();
        phonemem=new JLabel();
        feememlblACG=new JLabel();
        Dateofjoinmem=new JLabel();
        cnicmem=new JLabel();




        addgymmem.add(nameofmem);
        addgymmem.add(idofmem);
        addgymmem.add(phonemem);
        addgymmem.add(feememlblACG);
        addgymmem.add(Dateofjoinmem);
        addgymmem.add(cnicmem);


        namememAGC=new JTextField();
        idAGC=new JTextField();
        phoneAGC=new JTextField();
        cnicAGC=new JTextField();
        feeoptions=new JComboBox<>(new String[]{"null","Add Fee"});
        feeoptions.addItemListener(this);
        feeAGC=new JTextField();

        namememAGC.setFocusable(true);
        idAGC.setFocusable(true);
        phoneAGC.setFocusable(true);
        cnicAGC.setFocusable(true);
        feeAGC.setFocusable(true);


        namememAGC.addKeyListener(this);
        idAGC.addKeyListener(this);
        cnicAGC.addKeyListener(this);
        phoneAGC.addKeyListener(this);
        feeAGC.addKeyListener(this);
        

        addgymmem.add(datechooserAG);
        addgymmem.add(imagelabelAGC);
        addgymmem.add(addimagebtnAGC);
        addgymmem.add(lbldate);
        addgymmem.add(confirmallfielsAGC);
        addgymmem.add(expcnic);
        addgymmem.add(expphone);
        addgymmem.add(addmemAGC);
        addgymmem.add(clearAGC);
        addgymmem.add(cancelAGC);
        addgymmem.add(namememAGC);
        addgymmem.add(idAGC);
        addgymmem.add(phoneAGC);
        addgymmem.add(cnicAGC);
        addgymmem.add(feeoptions);
        addgymmem.add(feeAGC);



        //..........................Video Panel...............................................

        videopanel=new JPanel();
        videopanel2=new JPanel();
        videopanel3=new JPanel();
       
        
        // videopanel.setBorder(BorderFactory.createCompoundBorder(a1, a2));
        videopanel.setVisible(false);


        
        jfxvideopanel=new JFXPanel();
        jfxvideopanel1536=new JFXPanel();
        jfxvideopanel1280=new JFXPanel();

        //..........................Music Panel...............................................

        musix=new JPanel();
        musix2=new JPanel();
        musix3=new JPanel();
        

        musicpanel2=new JFXPanel();
        musicpanel3=new JFXPanel();
        musicpanel=new JFXPanel();

        // musix.setBorder(BorderFactory.createCompoundBorder(a1, a2));
        // musix2.setBorder(BorderFactory.createCompoundBorder(a1, a2));
        // musix3.setBorder(BorderFactory.createCompoundBorder(a1, a2));
        musix.setVisible(false);
        musix2.setVisible(false);
        musix3.setVisible(false);



        //..............Menu Panel.....................................................

        p1=new JPanel();
        p2=new JPanel();
        p3=new JPanel();
        addmem=new JButton();
        removemem=new JButton();
        searchmem=new JButton();
        replacemem=new JButton();
        search=new JButton();
        feemem=new JButton();
        calculatemonthbugjet=new JButton();
        music=new JButton();
        video=new JButton();
        excel=new JButton();
        text=new JButton();


        addmem.addActionListener(this);
        removemem.addActionListener(this);
        searchmem.addActionListener(this);
        replacemem.addActionListener(this);
        search.addActionListener(this);
        feemem.addActionListener(this);
        calculatemonthbugjet.addActionListener(this);
        excel.addActionListener(this);
        text.addActionListener(this);      
        music.addActionListener(this);
        video.addActionListener(this);

        menupanel=new JPanel();
        menupanel.setLayout(null);
        menupanel.setOpaque(false);
        menupanel.setBorder(BorderFactory.createCompoundBorder(a1, a2));

        homelblmenupanel=new GiveGradientLabel((new Font("Colonna MT",0,52)),"Home",10,40);
        homelblmenupanel2=new GiveGradientLabel((new Font("Colonna MT",0,46)),"Home",10,30);
        homelblmenupanel3=new GiveGradientLabel((new Font("Colonna MT",0,32)),"Home",10,25);

        homelblmenupanel.setBorder(BorderFactory.createCompoundBorder(a4, a3));
        homelblmenupanel2.setBorder(BorderFactory.createCompoundBorder(a4, a3));
        // homelblmenupanel3.setBorder(BorderFactory.createCompoundBorder(a4, a3));


        homelblmenupanel.setVisible(false);
        homelblmenupanel2.setVisible(false);
        homelblmenupanel3.setVisible(false);

        p1.setVisible(false);
        p2.setVisible(false);
        p3.setVisible(false);




        //.............Change Password Panel.............................................................
        gradientlbCP=new GiveGradientLabel(new Font("Colonna MT",Font.PLAIN,32),"Change Password",15,28);

        
        // gradientlbCP.setBounds(360, 2, 290, 40);
        gradientlbCP.setBorder(b1);
        gradientlbCP.setOpaque(true);
        gradientlbCP.setBackground(new Color(20,20,20));

        gradientlbCP1=new GiveGradientLabel(new Font("Colonna MT",Font.PLAIN,24),"Change Password",15,28);
        gradientlbCP1.setBorder(b1);
        gradientlbCP1.setOpaque(true);
        gradientlbCP1.setBackground(new Color(20,20,20));

        linelblCP=new DisplayLine();


        showCP1=new JButton();
        showCP1.setIcon(new ImageIcon(getClass().getResource("icons/visible_2.png")));
        showCP1.setBorder(BorderFactory.createEmptyBorder());
        
        showCP1.setBackground(new Color(20,20,20));
        showCP1.setFocusable(false);
        showCP1.setOpaque(false);
        showCP1.addActionListener(this);
        showCP1.setVisible(true);

        hideCP1=new JButton();
  
        hideCP1.setIcon(new ImageIcon(getClass().getResource("icons/hide_2.png")));
        hideCP1.setBorder(BorderFactory.createEmptyBorder());
        hideCP1.setBackground(new Color(20,20,20));
        hideCP1.setOpaque(false);
        hideCP1.setFocusable(false);
        hideCP1.addActionListener(this);
        hideCP1.setVisible(false);

        showCP=new JButton();
        showCP.setIcon(new ImageIcon(getClass().getResource("icons/visible_2.png")));
        showCP.setBorder(BorderFactory.createEmptyBorder());
        
        showCP.setBackground(new Color(20,20,20));
        showCP.setFocusable(false);
        showCP.setOpaque(false);
        showCP.addActionListener(this);
        showCP.setVisible(true);

        hideCP=new JButton();
      
        hideCP.setIcon(new ImageIcon(getClass().getResource("icons/hide_2.png")));
        hideCP.setBorder(BorderFactory.createEmptyBorder());
        hideCP.setBackground(new Color(20,20,20));
        hideCP.setOpaque(false);
        hideCP.setFocusable(false);
        hideCP.addActionListener(this);
        hideCP.setVisible(false);

        clearbtnCP=new JButton();
        clearbtnCP.setText("Clear");

        clearbtnCP.setForeground(Color.yellow);
        clearbtnCP.setFocusable(false);
        clearbtnCP.setBackground(new Color(20,20,20));
        clearbtnCP.addActionListener(this);
        clearbtnCP.setVisible(true);


        cancelUbtnCP=new JButton();
        cancelUbtnCP.setText("Cancel");
   
        cancelUbtnCP.setForeground(new Color(229,0,0));
        cancelUbtnCP.setFocusable(false);
        cancelUbtnCP.setBackground(new Color(20,20,20));
        cancelUbtnCP.addActionListener(this);
        cancelUbtnCP.setVisible(true);

        chgpassButton=new JButton();
 
        chgpassButton.setText("Change Password");

        chgpassButton.setForeground(new Color(0,229,0));
        chgpassButton.setBackground(new Color(20,20,20));
        chgpassButton.setFocusable(false);
        chgpassButton.addActionListener(this);
        chgpassButton.setVisible(true);
        chgpassButton.setEnabled(false);



        confirmfldCP=new JCheckBox();
        
        confirmfldCP.setIcon(new ImageIcon(getClass().getResource("icons/normal.png")));
        confirmfldCP.setSelectedIcon(new ImageIcon(getClass().getResource("icons/Selected.png")));
        confirmfldCP.setIconTextGap(10);
        confirmfldCP.setText("Confirm All Fields");
 
        confirmfldCP.setForeground(Color.YELLOW);
        confirmfldCP.setOpaque(false);
        confirmfldCP.setFocusable(false);
        confirmfldCP.addItemListener(this);
        confirmfldCP.setVisible(true);

        newPassCP=new JPasswordField();
    
        newPassCP.setOpaque(false);

        newPassCP.setForeground(Color.WHITE);
        newPassCP.setVisible(true);
        newPassCP.addActionListener(this);
        newPassCP.addKeyListener(this);

        
        pwsfldCP=new JPasswordField();
 
        pwsfldCP.setOpaque(false);
        pwsfldCP.setForeground(Color.WHITE);
        pwsfldCP.setVisible(true);
        pwsfldCP.addActionListener(this);
        pwsfldCP.addKeyListener(this);

        userNamefldCP=new JTextField();

        userNamefldCP.setOpaque(false);
        userNamefldCP.setForeground(Color.WHITE);
        userNamefldCP.setVisible(true);
        userNamefldCP.addActionListener(this);
        userNamefldCP.addKeyListener(this);

        pswnewlblCP=new JLabel("Enter New Password :");

        pswnewlblCP.setForeground(Color.white);
        pswnewlblCP.setOpaque(false);
        pswnewlblCP.setVisible(true);
        
        pswlblCP=new JLabel("Enter Current Password : ");

        pswlblCP.setForeground(Color.white);
        pswlblCP.setOpaque(false);
        pswlblCP.setVisible(true);

        
        usrNamelblCP=new JLabel("Enter UserName :");

        usrNamelblCP.setForeground(Color.white);
        usrNamelblCP.setOpaque(false);
        usrNamelblCP.setVisible(true);

        chngepswctl=new JPanel();
        chngepswctl.add(chgpassButton);
        chngepswctl.add(cancelUbtnCP);
        chngepswctl.add(clearbtnCP);
        chngepswctl.add(hideCP);
        chngepswctl.add(showCP);
        chngepswctl.add(hideCP1);
        chngepswctl.add(showCP1);
        chngepswctl.add(gradientlbCP);
        chngepswctl.add(gradientlbCP1);
        chngepswctl.add(usrNamelblCP);
        chngepswctl.add(pswlblCP);
        chngepswctl.add(pswnewlblCP);
        chngepswctl.add(userNamefldCP);
        chngepswctl.add(newPassCP);
        chngepswctl.add(pwsfldCP);
        chngepswctl.add(confirmfldCP);
        chngepswctl.add(linelblCP);
        chngepswctl.setLayout(null);
        chngepswctl.setBorder(cb4);
        chngepswctl.setOpaque(false);
        chngepswctl.setVisible(false);

        //.............Change UserName Panel............................................................
        gradientlbCUN=new GiveGradientLabel(new Font("Colonna MT",Font.PLAIN,32),"Change UserName",15,28);
        gradientlbCUN.setBorder(b1);
        gradientlbCUN.setOpaque(true);
        gradientlbCUN.setBackground(new Color(20,20,20));

        gradientlbCUN1=new GiveGradientLabel(new Font("Colonna MT",Font.PLAIN,24),"Change UserName",15,28);
        gradientlbCUN1.setBorder(b1);
        gradientlbCUN1.setOpaque(true);
        gradientlbCUN1.setBackground(new Color(20,20,20));
        

        linelblCUN=new DisplayLine();


        showCUN=new JButton();
        showCUN.setIcon(new ImageIcon(getClass().getResource("icons/visible_2.png")));
        showCUN.setBorder(BorderFactory.createEmptyBorder());

        showCUN.setBackground(new Color(20,20,20));
        showCUN.setFocusable(false);
        showCUN.setOpaque(false);
        showCUN.addActionListener(this);
        showCUN.setVisible(true);

        hideCUN=new JButton();

        hideCUN.setIcon(new ImageIcon(getClass().getResource("icons/hide_2.png")));
        hideCUN.setBorder(BorderFactory.createEmptyBorder());
        hideCUN.setBackground(new Color(20,20,20));
        hideCUN.setOpaque(false);
        hideCUN.setFocusable(false);
        hideCUN.addActionListener(this);
        hideCUN.setVisible(false);

        clearbtnCUN=new JButton();
        clearbtnCUN.setText("Clear");

        clearbtnCUN.setForeground(Color.yellow);
        clearbtnCUN.setFocusable(false);
        clearbtnCUN.setBackground(new Color(20,20,20));
        clearbtnCUN.addActionListener(this);
        clearbtnCUN.setVisible(true);


        cancelUbtnCUN=new JButton();
        cancelUbtnCUN.setText("Cancel");

        cancelUbtnCUN.setForeground(new Color(229,0,0));
        cancelUbtnCUN.setFocusable(false);
        cancelUbtnCUN.setBackground(new Color(20,20,20));
        cancelUbtnCUN.addActionListener(this);
        cancelUbtnCUN.setVisible(true);

        chguserNameButton=new JButton();

        chguserNameButton.setText("Change UserName");

        chguserNameButton.setForeground(new Color(0,229,0));
        chguserNameButton.setBackground(new Color(20,20,20));
        chguserNameButton.setFocusable(false);
        chguserNameButton.addActionListener(this);
        chguserNameButton.setVisible(true);
        chguserNameButton.setEnabled(false);



        confirmfldCUN=new JCheckBox();
   
        confirmfldCUN.setIcon(new ImageIcon(getClass().getResource("icons/normal.png")));
        confirmfldCUN.setSelectedIcon(new ImageIcon(getClass().getResource("icons/Selected.png")));
        confirmfldCUN.setIconTextGap(10);
        confirmfldCUN.setText("Confirm All Fields");

        confirmfldCUN.setForeground(Color.YELLOW);
        confirmfldCUN.setOpaque(false);
        confirmfldCUN.setFocusable(false);
        confirmfldCUN.addItemListener(this);
        confirmfldCUN.setVisible(true);

        newuserNamefldCUN=new JTextField();

        newuserNamefldCUN.setOpaque(false);

        newuserNamefldCUN.setForeground(Color.WHITE);
        newuserNamefldCUN.setVisible(true);
        newuserNamefldCUN.addActionListener(this);
        newuserNamefldCUN.addKeyListener(this);

        
        pswfldRCUN=new JPasswordField();
 
        pswfldRCUN.setOpaque(false);

        pswfldRCUN.setForeground(Color.WHITE);
        pswfldRCUN.setVisible(true);
        pswfldRCUN.addActionListener(this);
        pswfldRCUN.addKeyListener(this);

        userNamefldCUN=new JTextField();

        userNamefldCUN.setOpaque(false);

        userNamefldCUN.setForeground(Color.WHITE);
        userNamefldCUN.setVisible(true);
        userNamefldCUN.addActionListener(this);
        userNamefldCUN.addKeyListener(this);

        newUserNamelblCUN=new JLabel("Enter New UserName :");

        newUserNamelblCUN.setForeground(Color.white);
        newUserNamelblCUN.setOpaque(false);
        newUserNamelblCUN.setVisible(true);
        
        pswlblCUN=new JLabel("Enter Password : ");

        pswlblCUN.setForeground(Color.white);
        pswlblCUN.setOpaque(false);
        pswlblCUN.setVisible(true);

        
        usrNamelblCUN=new JLabel("Enter Current UserName :");

        usrNamelblCUN.setForeground(Color.white);
        usrNamelblCUN.setOpaque(false);
        usrNamelblCUN.setVisible(true);


        chngeusrnmectl=new JPanel();
        chngeusrnmectl.setLayout(null);
        chngeusrnmectl.setBorder(cb4);
        chngeusrnmectl.add(chguserNameButton);
        chngeusrnmectl.add(cancelUbtnCUN);
        chngeusrnmectl.add(clearbtnCUN);
        chngeusrnmectl.add(hideCUN);
        chngeusrnmectl.add(showCUN);
        chngeusrnmectl.add(gradientlbCUN);
        chngeusrnmectl.add(gradientlbCUN1);
        chngeusrnmectl.add(usrNamelblCUN);
        chngeusrnmectl.add(pswlblCUN);
        chngeusrnmectl.add(newUserNamelblCUN);
        chngeusrnmectl.add(userNamefldCUN);
        chngeusrnmectl.add(newuserNamefldCUN);
        chngeusrnmectl.add(pswfldRCUN);
        chngeusrnmectl.add(confirmfldCUN);
        chngeusrnmectl.add(linelblCUN);
        chngeusrnmectl.setOpaque(false);
        chngeusrnmectl.setVisible(false);




        //..............Remove Login User Panel...........................................................



        gradientlblRU=new GiveGradientLabel(new Font("Colonna MT",Font.PLAIN,32),"Remove Login User",15,28);
        
        gradientlblRU.setBorder(b1);
        gradientlblRU.setOpaque(true);
        gradientlblRU.setBackground(new Color(20,20,20));

        gradientlblRU1=new GiveGradientLabel(new Font("Colonna MT",Font.PLAIN,24),"Remove Login User",15,28);
        gradientlblRU1.setBorder(b1);
        gradientlblRU1.setOpaque(true);
        gradientlblRU1.setBackground(new Color(20,20,20));

        linelblRU=new DisplayLine();

        showRU=new JButton();
        showRU.setIcon(new ImageIcon(getClass().getResource("icons/visible_2.png")));
        showRU.setBorder(BorderFactory.createEmptyBorder());

        showRU.setBackground(new Color(20,20,20));
        showRU.setFocusable(false);
        showRU.setOpaque(false);
        showRU.addActionListener(this);
        showRU.setVisible(true);

        hideRU=new JButton();

        hideRU.setIcon(new ImageIcon(getClass().getResource("icons/hide_2.png")));
        hideRU.setBorder(BorderFactory.createEmptyBorder());
        hideRU.setBackground(new Color(20,20,20));
        hideRU.setOpaque(false);
        hideRU.setFocusable(false);
        hideRU.addActionListener(this);
        hideRU.setVisible(false);

        clearbtnRU=new JButton();
        clearbtnRU.setText("Clear");

        clearbtnRU.setForeground(Color.yellow);
        clearbtnRU.setFocusable(false);
        clearbtnRU.setBackground(new Color(20,20,20));
        clearbtnRU.addActionListener(this);
        clearbtnRU.setVisible(true);


        cancelUbtnRU=new JButton();
        cancelUbtnRU.setText("Cancel");

        cancelUbtnRU.setForeground(new Color(229,0,0));
        cancelUbtnRU.setFocusable(false);
        cancelUbtnRU.setBackground(new Color(20,20,20));
        cancelUbtnRU.addActionListener(this);
        cancelUbtnRU.setVisible(true);

        removeuserButton=new JButton();

        removeuserButton.setText("Remove User");

        removeuserButton.setForeground(new Color(0,229,0));
        removeuserButton.setBackground(new Color(20,20,20));
        removeuserButton.setFocusable(false);
        removeuserButton.addActionListener(this);
        removeuserButton.setVisible(true);
        removeuserButton.setEnabled(false);



        confirmfldRU=new JCheckBox();

        confirmfldRU.setIcon(new ImageIcon(getClass().getResource("icons/normal.png")));
        confirmfldRU.setSelectedIcon(new ImageIcon(getClass().getResource("icons/Selected.png")));
        confirmfldRU.setIconTextGap(10);
        confirmfldRU.setText("Confirm All Fields");

        confirmfldRU.setForeground(Color.YELLOW);
        confirmfldRU.setOpaque(false);
        confirmfldRU.setFocusable(false);
        confirmfldRU.addItemListener(this);
        confirmfldRU.setVisible(true);
        

        pswfldR=new JPasswordField();

        pswfldR.setOpaque(false);

        pswfldR.setForeground(Color.WHITE);
        pswfldR.setVisible(true);
        pswfldR.addActionListener(this);
        pswfldR.addKeyListener(this);


        userNamefldRU=new JTextField();

        userNamefldRU.setOpaque(false);

        userNamefldRU.setForeground(Color.WHITE);
        userNamefldRU.setVisible(true);
        userNamefldRU.addActionListener(this);
        userNamefldRU.addKeyListener(this);
        


        pswlblRU=new JLabel("Enter Your Password :");

        pswlblRU.setForeground(Color.white);
        pswlblRU.setOpaque(false);
        pswlblRU.setVisible(true);

        usrNamelblRU=new JLabel("Enter UserName :");

        usrNamelblRU.setForeground(Color.white);
        usrNamelblRU.setOpaque(false);
        usrNamelblRU.setVisible(true);


        remveusrpnlctl=new JPanel();
        
        remveusrpnlctl.add(gradientlblRU);
        remveusrpnlctl.add(gradientlblRU1);
        remveusrpnlctl.add(linelblRU);
        remveusrpnlctl.add(showRU);
        remveusrpnlctl.add(hideRU);
        remveusrpnlctl.add(confirmfldRU);
        remveusrpnlctl.add(clearbtnRU);
        remveusrpnlctl.add(cancelUbtnRU);
        remveusrpnlctl.add(removeuserButton);
        remveusrpnlctl.add(userNamefldRU);
        remveusrpnlctl.add(pswfldR);
        remveusrpnlctl.add(usrNamelblRU);
        remveusrpnlctl.add(pswlblRU);
        remveusrpnlctl.setLayout(null);
        remveusrpnlctl.setBorder(cb4);
        remveusrpnlctl.setOpaque(false);
        remveusrpnlctl.setVisible(false);



        //..............    Add Login User Panel...........................................................

        gradientlblAU=new GiveGradientLabel(new Font("Colonna MT",Font.PLAIN,32),"Add Login User",15,28);
        gradientlblAU1=new GiveGradientLabel(new Font("Colonna MT",Font.PLAIN,24),"Add Login User",15,28);
        gradientlblAU.setBorder(b1);
        gradientlblAU.setOpaque(true);
        gradientlblAU.setBackground(new Color(20,20,20));
        gradientlblAU1.setBorder(b1);
        gradientlblAU1.setOpaque(true);
        gradientlblAU1.setBackground(new Color(20,20,20));

        linelblAU=new DisplayLine();



        showAU=new JButton();
        showAU.setIcon(new ImageIcon(getClass().getResource("icons/visible_2.png")));
        showAU.setBorder(BorderFactory.createEmptyBorder());

        showAU.setBackground(new Color(20,20,20));
        showAU.setFocusable(false);
        showAU.setOpaque(false);
        showAU.addActionListener(this);
        showAU.setVisible(true);

        hideAU=new JButton();
   
        hideAU.setIcon(new ImageIcon(getClass().getResource("icons/hide_2.png")));
        hideAU.setBorder(BorderFactory.createEmptyBorder());
        hideAU.setBackground(new Color(20,20,20));
        hideAU.setOpaque(false);
        hideAU.setFocusable(false);
        hideAU.addActionListener(this);
        hideAU.setVisible(false);
        
        clearbtnAU=new JButton();
        clearbtnAU.setText("Clear");

        clearbtnAU.setForeground(Color.yellow);
        clearbtnAU.setFocusable(false);
        clearbtnAU.setBackground(new Color(20,20,20));
        clearbtnAU.addActionListener(this);
        clearbtnAU.setVisible(true);


        cancelUbtnAU=new JButton();
        cancelUbtnAU.setText("Cancel");
 
        cancelUbtnAU.setForeground(new Color(229,0,0));
        cancelUbtnAU.setFocusable(false);
        cancelUbtnAU.setBackground(new Color(20,20,20));
        cancelUbtnAU.addActionListener(this);
        cancelUbtnAU.setVisible(true);

        adduserButton=new JButton();

        adduserButton.setText("Add User");

        adduserButton.setForeground(new Color(0,229,0));
        adduserButton.setBackground(new Color(20,20,20));
        adduserButton.setFocusable(false);
        adduserButton.addActionListener(this);
        adduserButton.setVisible(true);
        adduserButton.setEnabled(false);



        confirmfldAU=new JCheckBox();
    
        confirmfldAU.setIcon(new ImageIcon(getClass().getResource("icons/normal.png")));
        confirmfldAU.setSelectedIcon(new ImageIcon(getClass().getResource("icons/Selected.png")));
        confirmfldAU.setIconTextGap(10);
        confirmfldAU.setText("Confirm All Fields");

        confirmfldAU.setForeground(Color.YELLOW);
        confirmfldAU.setOpaque(false);
        confirmfldAU.setFocusable(false);
        confirmfldAU.addItemListener(this);
        confirmfldAU.setVisible(true);



        phonefldAU=new JTextField();

        phonefldAU.setOpaque(false);

        phonefldAU.setForeground(Color.WHITE);
        phonefldAU.setVisible(true);
        phonefldAU.addActionListener(this);
        phonefldAU.addKeyListener(this);


        String[] fieldsusertype={"Select","User","Admin"};
        utypefldAU=new JComboBox<String>(fieldsusertype);

        utypefldAU.setBackground(new Color(20,20,20));

        utypefldAU.setForeground(Color.WHITE);
        utypefldAU.setVisible(true);
        utypefldAU.addActionListener(this);
        utypefldAU.addKeyListener(this);



        pswfldAU=new JPasswordField();

        pswfldAU.setOpaque(false);

        pswfldAU.setForeground(Color.WHITE);
        pswfldAU.setVisible(true);
        pswfldAU.addActionListener(this);
        pswfldAU.addKeyListener(this);


        userNamefldAU=new JTextField();

        userNamefldAU.setForeground(Color.WHITE);
        userNamefldAU.setVisible(true);
        userNamefldAU.addActionListener(this);
        userNamefldAU.addKeyListener(this);

        
        phoneAU=new JLabel("Enter Phone No : ");

        phoneAU.setForeground(Color.white);
        phoneAU.setOpaque(false);
        phoneAU.setVisible(true);

        utypeAU=new JLabel("Enter UserType : ");

        utypeAU.setForeground(Color.white);
        utypeAU.setOpaque(false);
        utypeAU.setVisible(true);

        pswlblAU=new JLabel("Enter Password : ");

        pswlblAU.setForeground(Color.white);
        pswlblAU.setOpaque(false);
        pswlblAU.setVisible(true);

        usrNamelblAU=new JLabel("Enter UserName : ");
        usrNamelblAU.setForeground(Color.white);
        usrNamelblAU.setOpaque(false);
        usrNamelblAU.setVisible(true);


        //..............Admin Controls.....................................................................



        adduserpnlctl=new JPanel();
     
        adduserpnlctl.setLayout(null);
        adduserpnlctl.setBorder(cb4);
        adduserpnlctl.add(hideAU);
        adduserpnlctl.add(showAU);
        adduserpnlctl.add(gradientlblAU);
        adduserpnlctl.add(gradientlblAU1);
        adduserpnlctl.add(linelblAU);
        adduserpnlctl.add(clearbtnAU);
        adduserpnlctl.add(adduserButton);
        adduserpnlctl.add(cancelUbtnAU);
        adduserpnlctl.add(confirmfldAU);
        adduserpnlctl.add(phonefldAU);
        adduserpnlctl.add(utypefldAU);
        adduserpnlctl.add(pswfldAU);
        adduserpnlctl.add(phoneAU);
        adduserpnlctl.add(userNamefldAU);
        adduserpnlctl.add(utypeAU);
        adduserpnlctl.add(pswlblAU);
        adduserpnlctl.add(usrNamelblAU);
        adduserpnlctl.setOpaque(false);
        adduserpnlctl.setVisible(false);



        changepasswordctrl=new JButton();
        changepasswordctrl.setText("Change Password");
        changepasswordctrl.setForeground(Color.white);

        changepasswordctrl.setVerticalTextPosition(0);
        changepasswordctrl.setHorizontalTextPosition(JButton.RIGHT);
        changepasswordctrl.setVerticalAlignment(0);

        changepasswordctrl.setContentAreaFilled(false);
        changepasswordctrl.setFocusable(false);
        changepasswordctrl.addActionListener(this);

        
        changeusernamectrl=new JButton();  
        changeusernamectrl.setText("Change UserName");
        changeusernamectrl.setForeground(Color.white);            
        changeusernamectrl.setVerticalTextPosition(0);
        changeusernamectrl.setHorizontalTextPosition(JButton.RIGHT);
        changeusernamectrl.setVerticalAlignment(0);

        changeusernamectrl.setContentAreaFilled(false);
        changeusernamectrl.setFocusable(false);
        changeusernamectrl.addActionListener(this);

        removeuserctrl=new JButton();
        removeuserctrl.setText("Remove User");
        removeuserctrl.setForeground(Color.white);


        removeuserctrl.setVerticalTextPosition(0);
        removeuserctrl.setHorizontalTextPosition(JButton.RIGHT);
        removeuserctrl.setVerticalAlignment(0);


        removeuserctrl.setContentAreaFilled(false);
        removeuserctrl.setFocusable(false);
        removeuserctrl.addActionListener(this);


        adduserctrl=new JButton();
        adduserctrl.setText("Add Login User");
        adduserctrl.setForeground(Color.white);
        adduserctrl.setVerticalTextPosition(0);
        adduserctrl.setHorizontalTextPosition(JButton.RIGHT);
        adduserctrl.setVerticalAlignment(0);
        adduserctrl.setContentAreaFilled(false);
        adduserctrl.setFocusable(false);
        adduserctrl.addActionListener(this);

        closeAdminPanel=new JButton();
        try {
            control2=ImageIO.read(getClass().getResource("icons/closepanel.png"));
        } catch (IOException e2) {

            e2.printStackTrace();
        }

        closeAdminPanel.setIcon(new ImageIcon(control2.getScaledInstance(10, 20, Image.SCALE_SMOOTH)));
        closeAdminPanel.setBorder(b1);
        closeAdminPanel.setBackground(new Color(20,20,20));
        closeAdminPanel.setFocusable(false);
        closeAdminPanel.setOpaque(true);
        closeAdminPanel.addActionListener(this);


        gradientlbl1=new GiveGradientLabel(new Font("Colonna MT",Font.PLAIN,32),"Admin Controls");
        gradientlbl1.setBounds(30, 05, 250, 90);
        gradientlbl4=new GiveGradientLabel(new Font("Colonna MT",Font.PLAIN,26),"Admin Controls");


        linelblcntrl=new DisplayLine();
        linelblcntrl.setBounds(0, 40, 300, 40);


        Admincontrols=new JPanel();
        Admincontrols.setLayout(null);
        Admincontrols.setBorder(b1);
        Admincontrols.setBackground(new Color(20,20,20));
        Admincontrols.add(closeAdminPanel);
        Admincontrols.add(changepasswordctrl);
        Admincontrols.add(changeusernamectrl);
        Admincontrols.add(removeuserctrl);
        Admincontrols.add(adduserctrl);
        Admincontrols.add(linelblcntrl);
        Admincontrols.add(gradientlbl1);
        Admincontrols.add(gradientlbl4);


        // Admincontrols.setOpaque(false);
        Admincontrols.setVisible(false);


        viewAdminControls=new JButton();
        try {
            admincontrols=ImageIO.read(getClass().getResource("icons/imageadmin.png"));

        } catch (IOException e1) {
            showerror(e1);
        }

        viewAdminControls.setSize(300, 100);
        // viewAdminControls.setFont(new Font("Colonna MT",0,24));
        viewAdminControls.setBackground(new Color(20,20,20));
        // viewAdminControls.setPreferredSize(new Dimension(100,300));
        viewAdminControls.setBorder(BorderFactory.createEmptyBorder());
        viewAdminControls.setOpaque(false);
        // viewAdminControls.setVisible(true);
        viewAdminControls.setFocusable(false);
        viewAdminControls.addActionListener(this);


        //..................................................................................................
        graphics=new JButton();
 
        graphics.setForeground(Color.YELLOW);
        graphics.setFocusable(false);
        graphics.setBackground(new Color(20,20,20));
        graphics.setBorder(BorderFactory.createEmptyBorder());
        popgraphics=new JPopupMenu();
        
        graphics.setOpaque(false);
        graphics.setVisible(true);


        p1920=new JMenuItem();
        p1536=new JMenuItem();
        p1280=new JMenuItem();
        p1920.setIcon(new ImageIcon(getClass().getResource("icons/1920p.png")));
        p1536.setIcon(new ImageIcon(getClass().getResource("icons/1536p.png")));
        p1280.setIcon(new ImageIcon(getClass().getResource("icons/1280p.png")));
        p1920.setBorder(b1);
        p1536.setBorder(b1);
        p1280.setBorder(b1);
        p1920.setText("1920x1080 Pixels");
        p1536.setText("1536x1440 Pixels");
        p1280.setText("1280x720 Pixels");
        p1920.setForeground(new Color(235,207,47));
        p1536.setForeground(new Color(235,207,47));
        p1280.setForeground(new Color(235,207,47));


        p1920.setFont(new Font("MV Boli",0,14));
        p1536.setFont(new Font("MV Boli",0,14));
        p1280.setFont(new Font("MV Boli",0,14));
        p1920.setBackground(new Color(20,20,20));
        p1536.setBackground(new Color(20,20,20));
        p1280.setBackground(new Color(20,20,20));


        p1920.addActionListener(this);
        p1536.addActionListener(this);
        p1280.addActionListener(this);


       

        popgraphics.add(p1280);
        popgraphics.add(p1536);
        popgraphics.add(p1920);
        popgraphics.setBackground(new Color(20,20,20));
        popgraphics.setOpaque(true);
        graphics.addMouseListener(new MouseAdapter(){

            @Override
            public void mouseClicked(MouseEvent e) {

                super.mouseClicked(e);
                popgraphics.show(graphics, e.getX()-popgraphics.getWidth(), 40);
            }
            @Override
            public void mouseReleased(MouseEvent e) {
                popgraphics.setVisible(false);
            }

        });


        home=new JButton();
        home.setText("Home");
        home.setFont(new Font("MV Boli",0,14));
        home.setIconTextGap(-3);
        home.setForeground(Color.YELLOW);
        home.setVerticalTextPosition(JButton.BOTTOM);
        home.setHorizontalTextPosition(JButton.CENTER);
        home.setFocusable(false);
        home.setBackground(new Color(20,20,20));
        home.setBorder(BorderFactory.createEmptyBorder());
        home.addActionListener(this);
        home.setOpaque(false);
        home.setVisible(true);

        back=new JButton();
        back.setIcon(new ImageIcon(getClass().getResource("icons/Back_2.png")));


        back.setText("Back");
        back.setFont(new Font("MV Boli",0,14));
        back.setIconTextGap(-3);
        back.setForeground(Color.YELLOW);
        back.setVerticalTextPosition(JButton.BOTTOM);
        back.setHorizontalTextPosition(JButton.CENTER);
        back.setFocusable(false);
        back.setBackground(new Color(20,20,20));
        back.setBorder(BorderFactory.createEmptyBorder());
        back.addActionListener(this);
        back.setOpaque(false);
        back.setVisible(true);

        logout=new JButton();
        logout.setIcon(new ImageIcon(getClass().getResource("icons/Asset_1.png")));
        logout.setText("Logout");
        logout.setFont(new Font("MV Boli",0,14));
        logout.setIconTextGap(0);
        logout.setForeground(Color.YELLOW);
        logout.setVerticalTextPosition(JButton.BOTTOM);
        logout.setHorizontalTextPosition(JButton.CENTER);
        logout.setFocusable(false);
        logout.setBackground(new Color(20,20,20));
        logout.setBorder(BorderFactory.createEmptyBorder());
        logout.addActionListener(this);
        logout.setOpaque(false);
        logout.setVisible(true);



        panel1=new JPanel(null);
        panel1.setOpaque(false);
        panel1.add(new DisplayLine());

        phonelbl=new JLabel();
        phonelbl.setIcon(new ImageIcon(getClass().getResource("icons/phone.png")));
        phonelbl.setForeground(new Color(235,207,47));
        phonelbl.setIconTextGap(15);
        phonelbl.setVerticalTextPosition(0);
        phonelbl.setHorizontalTextPosition(JLabel.RIGHT);
        phonelbl.setHorizontalAlignment(JLabel.LEFT);
        phonelbl.setVerticalAlignment(0);
        
        timenow=new JLabel();
      

        timenow.setForeground(new Color(235,207,47));
        timenow.setIconTextGap(15);
        timenow.setHorizontalAlignment(JLabel.LEADING);
        timenow.setVerticalAlignment(0);
        timenow.setOpaque(false);
        timenow.setVisible(true);

        datenow=new JLabel();
        datenow.setForeground(new Color(235,207,47));
        datenow.setIconTextGap(15);
        datenow.setHorizontalAlignment(JLabel.LEADING);
        datenow.setVerticalAlignment(0);
        datenow.setOpaque(false);
        timenow.setVisible(true);

        adminlbl=new JLabel();

        adminlbl.setForeground(new Color(0,229,0));
        adminlbl.setIconTextGap(15);
        adminlbl.setVerticalTextPosition(1);
        adminlbl.setHorizontalTextPosition(JLabel.RIGHT);
        adminlbl.setHorizontalAlignment(JLabel.LEFT);
        adminlbl.setVerticalAlignment(1);
        

        closewindowbtn=new JButton();
       
        closewindowbtn.setFocusable(false);
        closewindowbtn.setContentAreaFilled(false);
        closewindowbtn.setBorder(emptyBorder);
        closewindowbtn.addActionListener(this);
        
        minimizebtn=new JButton();
     
        minimizebtn.setFocusable(false);
        minimizebtn.setBorder(emptyBorder);
        minimizebtn.setContentAreaFilled(false);
        minimizebtn.addActionListener(this);

        labellogo=new JPanel()
        {
            protected void paintComponent(Graphics g) {
                Image imagnew=null;
                if(Screensize.getWidth()==1920)
                {
                    imagnew=logo.getScaledInstance(186, 148, Image.SCALE_SMOOTH);
                }
                else if(Screensize.getWidth()>=1536&&Screensize.getWidth()<1920)
                {
                    imagnew=logo.getScaledInstance(156, 118, Image.SCALE_SMOOTH);
                }
                else
                {
                    imagnew=logo.getScaledInstance(100, 80, Image.SCALE_SMOOTH);
                }

                g.drawImage(imagnew, 0,0, null);

            }
        };
        
        panelback=new JPanel() {

            public void paintComponent(Graphics g) {
                g.drawImage(img, 0, 0,(int)Screensize.getWidth(),(int)Screensize.getHeight(), null);
            }
        };

        panelback.setBorder(b1);



        this.gradientlbl=new GradientText();
        this.gradientlbl2=new GradientText(44,10,40,70,65);
        this.gradientlbl3=new GradientText(36,10,40,70,60);

        menuframe.setIconImage(new ImageIcon(getClass().getResource("icons/256x256.png")).getImage().getScaledInstance(32, 32, Image.SCALE_SMOOTH));
        menuframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        menuframe.setLayout(null);
        menuframe.setUndecorated(true);
        menuframe.getContentPane().setBackground(new Color(20,20,20));
        menuframe.setResizable(true);
        menuframe.setLocationRelativeTo(null);

        menupanel.add(addmem);
        menupanel.add(removemem);
        menupanel.add(searchmem);
        menupanel.add(feemem);
        menupanel.add(calculatemonthbugjet);
        menupanel.add(music);
        menupanel.add(video);
        menupanel.add(excel);
        menupanel.add(replacemem);
        menupanel.add(text);


        setComponentSizes();

        menuframe.add(toplabelcoverEE);
        menuframe.add(exportexcelEE);
        menuframe.add(toplabelcoverET);
        menuframe.add(exporttextET);
        menuframe.add(toplabelcoverMF);
        menuframe.add(monthlyfeepanelMF);
        menuframe.add(toplabelcoverRI);
        menuframe.add(replacepanelRI);
        menuframe.add(toplabelcoverAF);
        menuframe.add(feepanelAF);
        menuframe.add(toplabelcoverSGC);
        menuframe.add(toplabelcoverRGC);
        menuframe.add(toplabelcover1);
        menuframe.add(minimizebtn);
        menuframe.add(addgymmem);
        menuframe.add(removegymmem);
        menuframe.add(searchgymmem);
        menuframe.add(videopanel);
        menuframe.add(videopanel2);
        menuframe.add(videopanel3);
        menuframe.add(musix);
        menuframe.add(musix2);
        menuframe.add(musix3);
        menuframe.add(p1);
        menuframe.add(p2);
        menuframe.add(p3);
        menuframe.add(menupanel);
        menuframe.add(viewAdminControls);
        menuframe.add(graphics);
        menuframe.add(logout);
        menuframe.add(home);
        menuframe.add(chngeusrnmectl);
        menuframe.add(chngepswctl);
        menuframe.add(remveusrpnlctl);
        menuframe.add(adduserpnlctl);
        menuframe.add(Admincontrols);
        menuframe.add(gradientlbl);
        menuframe.add(gradientlbl2);
        menuframe.add(gradientlbl3);
        menuframe.add(labellogo);
        menuframe.add(panel1);
        menuframe.add(phonelbl);
        menuframe.add(timenow);
        menuframe.add(datenow);
        menuframe.add(adminlbl);
        menuframe.add(closewindowbtn);
        menuframe.add(panelback);

        showDate();
        showTime();
     

        initFX2(jfxvideopanel);
        jfxvideopanel1536.setScene(createScene2());
        jfxvideopanel1280.setScene(createScene3());
        initFX(musicpanel);
        Scene sceneadd=createScene1536();
        musicpanel2.setScene(sceneadd);
        Scene sceneadd1280=createScene1280();
        musicpanel3.setScene(sceneadd1280);

        this.isready=true;

        
    }


    private  void initFX(JFXPanel fxPanel) {
        Scene scene1 = createScene();
        fxPanel.setScene(scene1);
    }
    private  void initFX2(JFXPanel fxPanel) {

        Scene scenev = createScene1();
        fxPanel.setScene(scenev);
    }
    private  Scene createScene() {
  
        try {
            
                root  =  fxmlLoader.load();

        } catch (IOException e3) {
          
            showerror(e3);
        }

          scene  =  new  Scene(this.root);

        return (scene);
    }
    private  Scene createScene1536() {
  
        try {
            
                root1536  =  fxmlLoader2.load();

        } catch (IOException e3) {
          
            showerror(e3);
        }

          scene1536  =  new  Scene(this.root1536);

        return (scene1536);
    }
    private  Scene createScene1280() {
  
        try {
            
                root1280  =  fxmlLoader3.load();

        } catch (IOException e3) {
          
            showerror(e3);
        }

          scene1280  =  new  Scene(this.root1280);

        return (scene1280);
    }
    private  Scene createScene1() {

        try {

                rootvideo=fxmlLoadervideo.load();
        } catch (IOException e3) {
          
            showerror(e3);
        }
   
       
            scenevideo =  new  Scene(this.rootvideo);
         

        return (scenevideo);
    }
    private  Scene createScene2() {

        try {

                rootvideo1536=fxmlLoadervideo1536.load();
        } catch (IOException e3) {
          
            showerror(e3);
        }
   
       
            scenevideo1536 =  new  Scene(this.rootvideo1536);
         

        return (scenevideo1536);
    }
    private  Scene createScene3() {

        try {

                rootvideo1280=fxmlLoadervideo1280.load();
        } catch (IOException e3) {
          
            showerror(e3);
        }
   
       
            scenevideo1280 =  new  Scene(this.rootvideo1280);
         

        return (scenevideo1280);
    }


    public void setComponentSizes() 
    {
        //............Export Excel Panel ........................................................



        if(Screensize.getWidth()==1920){

            boykalbl.setBounds(100, 80, 337, 600);
            boykalbl.setIcon(new ImageIcon(new ImageIcon(getClass().getResource("icons/Boyka.png")).getImage().getScaledInstance(337, 600, Image.SCALE_SMOOTH)));


            SelectmonthEE.setFont(new Font("Cooper Black",0,24));
            SelectmonthEE.setBounds(430, 100, 200, 40);

            monthsoptionaEE.setFont(new Font("Goudy Old Style",0,24));
            monthsoptionaEE.setBounds(600, 100, 250, 40);


            exportButtonEE.setBounds(550, 450, 150, 40);
            exportButtonEE.setFont(new Font("Goudy Old Style",0,24));

            toplblEE=new GiveGradientLabel(new Font("Gabriola",0,42),"Export Excel",10,35);
            toplblEE.setVisible(true);
            toplabelcoverEE.setBounds(880, 250, 180, 50);
            toplblEE.setBounds(0, 0, 425, 50);
            toplabelcoverEE.add(toplblEE);
            if(toplblEE1!=null){
                toplblEE1.setVisible(false);
            }
            else if(toplblEE2!=null){
                toplblEE2.setVisible(false);
            }
            toplabelcoverEE.setBackground(new Color(20,20,20));
            toplabelcoverEE.setOpaque(true);

            exportexcelEE.setBounds(320, 300, 1290, 680);
            exportexcelEE.setOpaque(false);
            exportexcelEE.setVisible(false);
        }
        else if(Screensize.getWidth()>=1536&&Screensize.getWidth()<1920){

            boykalbl.setBounds(100, 80, 269, 480);
            boykalbl.setIcon(new ImageIcon(new ImageIcon(getClass().getResource("icons/Boyka.png")).getImage().getScaledInstance(269, 480, Image.SCALE_SMOOTH)));

            SelectmonthEE.setFont(new Font("Cooper Black",0,24));
            SelectmonthEE.setBounds(350, 100, 200, 40);

            monthsoptionaEE.setFont(new Font("Goudy Old Style",0,24));
            monthsoptionaEE.setBounds(520, 100, 250, 40);


            exportButtonEE.setBounds(450, 450, 150, 40);
            exportButtonEE.setFont(new Font("Goudy Old Style",0,24));


            toplblEE1=new GiveGradientLabel(new Font("Gabriola",0,36),"Export Excel",10,30);
            toplblEE1.setVisible(true);
            toplabelcoverEE.setBounds(700, 200, 160, 40);
            toplblEE1.setBounds(0, 0, 370, 40);
            if(toplblEE!=null){
                toplblEE.setVisible(false);
            }
            else if(toplblEE2!=null){
                toplblEE2.setVisible(false);
            }
            toplabelcoverEE.add(toplblEE1);
            toplabelcoverEE.setBackground(new Color(20,20,20));
            toplabelcoverEE.setOpaque(true);

            exportexcelEE.setBounds(200, 240, 1120, 550);
            exportexcelEE.setBorder(BorderFactory.createCompoundBorder(a1, a2));
            exportexcelEE.setLayout(null);
            exportexcelEE.setOpaque(false);
            exportexcelEE.setVisible(false);
        }
        else{
            boykalbl.setBounds(100, 50, 224, 400);
            boykalbl.setIcon(new ImageIcon(new ImageIcon(getClass().getResource("icons/Boyka.png")).getImage().getScaledInstance(224, 400, Image.SCALE_SMOOTH)));

            SelectmonthEE.setFont(new Font("Cooper Black",0,20));
            SelectmonthEE.setBounds(250, 40, 200, 30);

            monthsoptionaEE.setFont(new Font("Goudy Old Style",0,20));
            monthsoptionaEE.setBounds(400, 40, 200, 30);


            exportButtonEE.setBounds(400, 300, 150, 30);
            exportButtonEE.setFont(new Font("Goudy Old Style",0,18));


            toplblEE2=new GiveGradientLabel(new Font("Gabriola",0,28),"Export Excel",10,25);
            toplblEE2.setVisible(true);
            toplabelcoverEE.setBounds(570, 170,130, 30);
            toplblEE2.setBounds(0, 0, 295, 30);
            toplabelcoverEE.add(toplblEE2);
            if(toplblEE!=null){
                toplblEE.setVisible(false);
            }
            else if(toplblEE1!=null){
                toplblEE1.setVisible(false);
            }
            toplabelcoverEE.setBackground(new Color(20,20,20));
            toplabelcoverEE.setOpaque(true);

            exportexcelEE.setBounds(210, 200, 900, 450);
            exportexcelEE.setBorder(BorderFactory.createCompoundBorder(a1, a2));
            exportexcelEE.setLayout(null);
            exportexcelEE.setOpaque(false);
            exportexcelEE.setVisible(false);
        }




        //............Export Text Panel ........................................................
        if(Screensize.getWidth()==1920){


            SelectmonthET.setFont(new Font("Cooper Black",0,24));
            SelectmonthET.setBounds(430, 20, 200, 40);

            monthsoptionaET.setFont(new Font("Goudy Old Style",0,24));
            monthsoptionaET.setBounds(600, 20, 250, 40);


            exportfileareaET.setFont(new Font("Times New Roman",0,20));
            exportfileareaET.setBounds(100, 150, 1090, 350);

            containerET.setBounds(80, 150, 1110, 350);
            containerET.setOpaque(false);

            exportButtonET.setBounds(550, 550, 150, 40);
            exportButtonET.setFont(new Font("Goudy Old Style",0,24));




            toplblET=new GiveGradientLabel(new Font("Gabriola",0,42),"Export Text",10,35);
            toplblET.setVisible(true);
            toplabelcoverET.setBounds(880, 250, 180, 50);
            toplblET.setBounds(0, 0, 425, 50);
            toplabelcoverET.add(toplblET);
            toplabelcoverET.setBackground(new Color(20,20,20));
            toplabelcoverET.setOpaque(true);

            exporttextET.setBounds(320, 300, 1290, 680);
            exporttextET.setOpaque(false);
            exporttextET.setVisible(false);

        }
        else if(Screensize.getWidth()>=1536&&Screensize.getWidth()<1920){


            SelectmonthET.setFont(new Font("Cooper Black",0,20));
            SelectmonthET.setBounds(370, 20, 200, 35);

            monthsoptionaET.setFont(new Font("Goudy Old Style",0,20));
            monthsoptionaET.setBounds(530, 20, 250, 35);

            exportfileareaET.setFont(new Font("Times New Roman",0,20));
            exportfileareaET.setBounds(100, 0, 950, 350);

            containerET.setBounds(80, 100, 950, 350);
            containerET.setOpaque(false);

            exportButtonET.setBounds(550, 490, 150, 30);
            exportButtonET.setFont(new Font("Goudy Old Style",0,18));


            toplblET1=new GiveGradientLabel(new Font("Gabriola",0,36),"Export Text",10,30);
            toplblET1.setVisible(true);
            toplabelcoverET.setBounds(700, 200, 160, 40);
            toplblET1.setBounds(0, 0, 370, 40);
            toplabelcoverET.add(toplblET1);
            toplabelcoverET.setBackground(new Color(20,20,20));
            toplabelcoverET.setOpaque(true);

            exporttextET.setBounds(200, 240, 1120, 550);
            exporttextET.setBorder(BorderFactory.createCompoundBorder(a1, a2));
            exporttextET.setLayout(null);
            exporttextET.setOpaque(false);
            exporttextET.setVisible(false);
        }
        else{

            SelectmonthET.setFont(new Font("Cooper Black",0,20));
            SelectmonthET.setBounds(300, 10, 150, 30);

            monthsoptionaET.setFont(new Font("Goudy Old Style",0,20));
            monthsoptionaET.setBounds(450, 10, 200, 30);

            exportfileareaET.setFont(new Font("Times New Roman",0,18));
            exportfileareaET.setBounds(100, 0, 860, 300);

            containerET.setBounds(20, 80, 860, 300);
            containerET.setOpaque(false);

            exportButtonET.setBounds(400, 400, 100, 30);
            exportButtonET.setFont(new Font("Goudy Old Style",0,18));

            toplblET2=new GiveGradientLabel(new Font("Gabriola",0,28),"Export Text",10,25);
            toplblET2.setVisible(true);
            toplabelcoverET.setBounds(570, 170,120, 30);
            toplblET2.setBounds(0, 0, 295, 30);
            toplabelcoverET.add(toplblET2);
            toplabelcoverET.setBackground(new Color(20,20,20));
            toplabelcoverET.setOpaque(true);

            exporttextET.setBounds(210, 200, 900, 450);
            exporttextET.setBorder(BorderFactory.createCompoundBorder(a1, a2));
            exporttextET.setLayout(null);
            exporttextET.setOpaque(false);
            exporttextET.setVisible(false);
        }



        //............Monthly Fee Record ....................................................

        if(Screensize.getWidth()==1920){

            imagelblMF.setBounds(700, 50, 600, 600);
            imagelblMF.setIcon(new ImageIcon(new ImageIcon(getClass().getResource("icons/deafultpic3.png")).getImage().getScaledInstance(400, 400, Image.SCALE_SMOOTH)));

            backbtnMF.setBounds(1400, 20, 40, 40);
            backbtnMF.setIcon(new ImageIcon(new ImageIcon(getClass().getResource("icons/Back_2.png")).getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH)));

            nameilblMF.setBounds(100, 100, 150, 40);
            nameilblMF.setFont(new Font("Cooper Black",0,24));

            idilblMF.setBounds(100, 170, 150, 40);
            idilblMF.setFont(new Font("Cooper Black",0,24));

            phoneilblMF.setBounds(100, 240, 150, 40);
            phoneilblMF.setFont(new Font("Cooper Black",0,24));

            cnicilblMF.setBounds(100, 310, 150, 40);
            cnicilblMF.setFont(new Font("Cooper Black",0,24));

            dateofjoinilblMF.setBounds(100, 380, 200, 40);
            dateofjoinilblMF.setFont(new Font("Cooper Black",0,24));

            feeilblMF.setBounds(100, 450, 150, 40);
            feeilblMF.setFont(new Font("Cooper Black",0,24));

            nameifldMF.setBounds(270, 100, 250, 40);
            nameifldMF.setFont(new Font("Goudy Old Style",0,24));

            idifldMF.setBounds(270, 170, 250, 40);
            idifldMF.setFont(new Font("Goudy Old Style",0,24));

            phoneifldMF.setBounds(270, 240, 250, 40);
            phoneifldMF.setFont(new Font("Goudy Old Style",0,24));

            cnicifldMF.setBounds(270, 310, 250, 40);
            cnicifldMF.setFont(new Font("Goudy Old Style",0,24));

            dateofjoinifldMF.setBounds(270, 380, 250, 40);
            dateofjoinifldMF.setFont(new Font("Goudy Old Style",0,24));

            feeifldMF.setBounds(270, 450, 250, 40);
            feeifldMF.setFont(new Font("Goudy Old Style",0,24));

            nameifldMF.setVisible(false);
            idifldMF.setVisible(false);
            phoneifldMF.setVisible(false);
            cnicifldMF.setVisible(false);
            dateofjoinifldMF.setVisible(false);
            feeifldMF.setVisible(false);

            nameilblMF.setVisible(false);
            idilblMF.setVisible(false);
            cnicilblMF.setVisible(false);
            phoneilblMF.setVisible(false);
            dateofjoinilblMF.setVisible(false);
            feeilblMF.setVisible(false);

            backbtnMF.setVisible(false);
            imagelblMF.setVisible(false);

            monthtableMF.getColumnModel().getColumn(0).setPreferredWidth(130);
            monthtableMF.getColumnModel().getColumn(1).setPreferredWidth(200);
            monthtableMF.getColumnModel().getColumn(2).setPreferredWidth(250);
            monthtableMF.getColumnModel().getColumn(3).setPreferredWidth(200);
            monthtableMF.getColumnModel().getColumn(4).setPreferredWidth(100);
            monthtableMF.getColumnModel().getColumn(5).setPreferredWidth(200);
            monthtableMF.getColumnModel().getColumn(6).setPreferredWidth(150);
            monthtableMF.getColumnModel().getColumn(7).setPreferredWidth(130);

            this.monthtableMF.setBounds(0, 10, 1400, 400);
            monthtableMF.setOpaque(false);
            monthtableMF.setRowHeight(28);
            header1=this.monthtableMF.getTableHeader();
            header1.setFont(new Font("Times New Roman",1,24));
            header1.setForeground(Color.WHITE);
            header1.setBackground(new Color(20, 20, 20));
            header1.setBorder(BorderFactory.createLineBorder(new Color(235,207,47), 2));

            monthtableMF.setFont(new Font("Goudy Old Style",0,24));
            monthtableMF.setOpaque(false);
            monthtableMF.setVisible(true);
            tablepaneMF.getViewport().setBackground(new Color(20,20,20));
            tablepaneMF.setBorder(BorderFactory.createLineBorder(Color.darkGray, 1));
            tablepaneMF.getHorizontalScrollBar().setBackground(new Color(20,20,20));
            tablepaneMF.getVerticalScrollBar().setBackground(new Color(20,20,20));
            tablepaneMF.getViewport().setOpaque(true);
            tablecontainerMF.setBounds(50, 280, 1400, 400);
            tablecontainerMF.setBorder(BorderFactory.createLineBorder(new Color(235,207,47), 1));
            tablecontainerMF.setBackground(new Color(20,20,20));
            tablecontainerMF.setOpaque(false);
            tablecontainerMF.setVisible(false);

            showtableMF.setFont(new Font("Goudy Old Style",0,14));
            showtableMF.setBounds(1350, 20, 100, 30);
            showtableMF.setVisible(true);
            HidetableMF.setFont(new Font("Goudy Old Style",0,14));
            HidetableMF.setBounds(1350, 20, 100, 30);
            HidetableMF.setVisible(false);



            strengthfldMF.setFont(new Font("Goudy Old Style",0,24));
            strengthfldMF.setBounds(350, 150, 150, 40);
            
            feecollectionfldMF.setFont(new Font("Goudy Old Style",0,24));
            feecollectionfldMF.setBounds(800, 150, 150, 40);

            feependfldMF.setFont(new Font("Goudy Old Style",0,24));
            feependfldMF.setBounds(1220, 150, 150, 40);

            
            feependingMF.setFont(new Font("Cooper Black",0,24));
            feependingMF.setBounds(1000, 150, 250, 40);
            
            feecollectedlblMF.setFont(new Font("Cooper Black",0,24));
            feecollectedlblMF.setBounds(550, 150, 250, 40);
            
            totalstrengthlblMF.setFont(new Font("Cooper Black",0,24));
            totalstrengthlblMF.setBounds(100, 150, 250, 40);

            reveueMF.setFont(new Font("Cooper Black",0,24));
            reveueMF.setBounds(100, 250, 250, 40);

            ExpensesMF.setFont(new Font("Cooper Black",0,24));
            ExpensesMF.setBounds(550, 250, 250, 40);


            ProfitMF.setFont(new Font("Cooper Black",0,24));
            ProfitMF.setBounds(1000, 250, 250, 40);

            revenuefldMF.setFont(new Font("Goudy Old Style",0,24));
            revenuefldMF.setBounds(350, 250, 150, 40);


            expensefldMF.setFont(new Font("Goudy Old Style",0,24));
            expensefldMF.setBounds(800, 250, 150, 40);

            profitfldMF.setFont(new Font("Goudy Old Style",0,24));
            profitfldMF.setBounds(1220, 250, 150, 40);



            monthslblMF.setFont(new Font("Cooper Black",0,24));
            monthslblMF.setBounds(500, 20, 200, 40);

            monthsoptionaMF.setFont(new Font("Goudy Old Style",0,24));
            monthsoptionaMF.setBounds(670, 20, 250, 40);

            totalfeefldMF.setFont(new Font("Goudy Old Style",0,24));
            totalfeefldMF.setBounds(750, 350, 250, 40);


            totalfeelblMF.setFont(new Font("Cooper Black",0,24));
            totalfeelblMF.setBounds(500, 350, 250, 40);

            tablecontainerMF.setVisible(false);
            if(tablecontainerMF.isVisible()){HidetableMF.setVisible(true);}
            else{tablecontainerMF.setVisible(false);}           
            strengthfldMF.setVisible(true);
            feecollectionfldMF.setVisible(true);
            feependfldMF.setVisible(true);
            feependingMF.setVisible(true);
            feecollectedlblMF.setVisible(true);
            totalstrengthlblMF.setVisible(true);
            reveueMF.setVisible(true);
            ExpensesMF.setVisible(true);
            ProfitMF.setVisible(true);
            revenuefldMF.setVisible(true);
            expensefldMF.setVisible(true);
            profitfldMF.setVisible(true);
            monthslblMF.setVisible(true);
            monthsoptionaMF.setVisible(true);
            totalfeefldMF.setVisible(true);
            totalfeelblMF.setVisible(true);




            monthyfeelbl1=new GiveGradientLabel(new Font("Gabriola",0,42),"Monthly Fee Record",10,35);
            monthyfeelbl1.setVisible(true);
            toplabelcoverMF.setBounds(810, 250, 300, 50);
            monthyfeelbl1.setBounds(0, 0, 320, 50);
            toplabelcoverMF.add(monthyfeelbl1);
            toplabelcoverMF.setBackground(new Color(20,20,20));
            toplabelcoverMF.setOpaque(true);

            monthlyfeepanelMF.setBounds(200, 300, 1500, 700);
            monthlyfeepanelMF.setBorder(BorderFactory.createCompoundBorder(a1, a2));
            monthlyfeepanelMF.setLayout(null);
            monthlyfeepanelMF.setOpaque(false);
            monthlyfeepanelMF.setVisible(false);

        }
        else if(Screensize.getWidth()>=1536&&Screensize.getWidth()<1920){
            imagelblMF.setBounds(650, 50, 450, 450);
            imagelblMF.setIcon(new ImageIcon(new ImageIcon(getClass().getResource("icons/deafultpic3.png")).getImage().getScaledInstance(350, 350, Image.SCALE_SMOOTH)));

            backbtnMF.setBounds(1200, 20, 40, 40);
            backbtnMF.setIcon(new ImageIcon(new ImageIcon(getClass().getResource("icons/Back_2.png")).getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH)));

            nameilblMF.setBounds(100, 100, 150, 35);
            nameilblMF.setFont(new Font("Cooper Black",0,22));

            idilblMF.setBounds(100, 160, 150, 35);
            idilblMF.setFont(new Font("Cooper Black",0,22));

            phoneilblMF.setBounds(100, 220, 150, 35);
            phoneilblMF.setFont(new Font("Cooper Black",0,22));

            cnicilblMF.setBounds(100, 280, 150, 35);
            cnicilblMF.setFont(new Font("Cooper Black",0,22));

            dateofjoinilblMF.setBounds(100, 340, 200, 35);
            dateofjoinilblMF.setFont(new Font("Cooper Black",0,22));

            feeilblMF.setBounds(100, 400, 150, 35);
            feeilblMF.setFont(new Font("Cooper Black",0,22));

            nameifldMF.setBounds(270, 100, 250, 35);
            nameifldMF.setFont(new Font("Goudy Old Style",0,22));

            idifldMF.setBounds(270, 160, 250, 35);
            idifldMF.setFont(new Font("Goudy Old Style",0,22));

            phoneifldMF.setBounds(270, 220, 250, 35);
            phoneifldMF.setFont(new Font("Goudy Old Style",0,22));

            cnicifldMF.setBounds(270, 280, 250, 35);
            cnicifldMF.setFont(new Font("Goudy Old Style",0,22));

            dateofjoinifldMF.setBounds(270, 340, 250, 35);
            dateofjoinifldMF.setFont(new Font("Goudy Old Style",0,22));

            feeifldMF.setBounds(270, 400, 250, 35);
            feeifldMF.setFont(new Font("Goudy Old Style",0,22));

            nameifldMF.setVisible(false);
            idifldMF.setVisible(false);
            phoneifldMF.setVisible(false);
            cnicifldMF.setVisible(false);
            dateofjoinifldMF.setVisible(false);
            feeifldMF.setVisible(false);

            nameilblMF.setVisible(false);
            idilblMF.setVisible(false);
            cnicilblMF.setVisible(false);
            phoneilblMF.setVisible(false);
            dateofjoinilblMF.setVisible(false);
            feeilblMF.setVisible(false);

            backbtnMF.setVisible(false);
            imagelblMF.setVisible(false);

            monthtableMF.getColumnModel().getColumn(0).setPreferredWidth(130);
            monthtableMF.getColumnModel().getColumn(1).setPreferredWidth(200);
            monthtableMF.getColumnModel().getColumn(2).setPreferredWidth(250);
            monthtableMF.getColumnModel().getColumn(3).setPreferredWidth(200);
            monthtableMF.getColumnModel().getColumn(4).setPreferredWidth(100);
            monthtableMF.getColumnModel().getColumn(5).setPreferredWidth(200);
            monthtableMF.getColumnModel().getColumn(6).setPreferredWidth(130);
            monthtableMF.getColumnModel().getColumn(7).setPreferredWidth(130);

            this.monthtableMF.setBounds(0, 10, 1200, 300);
            monthtableMF.setOpaque(false);
            monthtableMF.setRowHeight(28);
            header1=this.monthtableMF.getTableHeader();
            header1.setFont(new Font("Times New Roman",1,20));
            header1.setForeground(Color.WHITE);
            header1.setBackground(new Color(20, 20, 20));
            header1.setBorder(BorderFactory.createLineBorder(new Color(235,207,47), 2));

            monthtableMF.setFont(new Font("Goudy Old Style",0,20));
            monthtableMF.setOpaque(false);
            monthtableMF.setVisible(true);
            tablepaneMF.getViewport().setBackground(new Color(20,20,20));
            tablepaneMF.setBorder(BorderFactory.createLineBorder(Color.darkGray, 1));
            tablepaneMF.getHorizontalScrollBar().setBackground(new Color(20,20,20));
            tablepaneMF.getVerticalScrollBar().setBackground(new Color(20,20,20));
            tablepaneMF.getViewport().setOpaque(true);
            tablecontainerMF.setBounds(50, 240, 1200, 300);
            tablecontainerMF.setBorder(BorderFactory.createLineBorder(new Color(235,207,47), 1));
            tablecontainerMF.setBackground(new Color(20,20,20));
            tablecontainerMF.setOpaque(false);
            tablecontainerMF.setVisible(false);

            showtableMF.setFont(new Font("Goudy Old Style",0,14));
            showtableMF.setBounds(1150, 20, 100, 30);
            showtableMF.setVisible(true);

            HidetableMF.setFont(new Font("Goudy Old Style",0,14));
            HidetableMF.setBounds(1150, 20, 100, 30);
            HidetableMF.setVisible(false);

            strengthfldMF.setFont(new Font("Goudy Old Style",0,22));
            strengthfldMF.setBounds(300, 100, 150, 35);
            
            feecollectionfldMF.setFont(new Font("Goudy Old Style",0,22));
            feecollectionfldMF.setBounds(750, 100, 150, 35);

            feependfldMF.setFont(new Font("Goudy Old Style",0,22));
            feependfldMF.setBounds(1120, 100, 150, 35);

            
            feependingMF.setFont(new Font("Cooper Black",0,22));
            feependingMF.setBounds(900, 100, 250, 35);
            
            feecollectedlblMF.setFont(new Font("Cooper Black",0,22));
            feecollectedlblMF.setBounds(480, 100, 250, 35);
            
            totalstrengthlblMF.setFont(new Font("Cooper Black",0,22));
            totalstrengthlblMF.setBounds(50, 100, 250, 35);

            reveueMF.setFont(new Font("Cooper Black",0,22));
            reveueMF.setBounds(50, 200, 250, 35);

            ExpensesMF.setFont(new Font("Cooper Black",0,22));
            ExpensesMF.setBounds(480, 200, 250, 35);

            ProfitMF.setFont(new Font("Cooper Black",0,22));
            ProfitMF.setBounds(900, 200, 250, 35);

            revenuefldMF.setFont(new Font("Goudy Old Style",0,22));
            revenuefldMF.setBounds(300, 200, 150, 35);

            expensefldMF.setFont(new Font("Goudy Old Style",0,22));
            expensefldMF.setBounds(750, 200, 150, 35);

            profitfldMF.setFont(new Font("Goudy Old Style",0,22));
            profitfldMF.setBounds(1120, 200, 150, 35);



            monthslblMF.setFont(new Font("Cooper Black",0,22));
            monthslblMF.setBounds(400, 20, 200, 35);

            monthsoptionaMF.setFont(new Font("Goudy Old Style",0,22));
            monthsoptionaMF.setBounds(570, 20, 250, 35);

            totalfeefldMF.setFont(new Font("Goudy Old Style",0,22));
            totalfeefldMF.setBounds(650, 300, 250, 35);

            totalfeelblMF.setFont(new Font("Cooper Black",0,22));
            totalfeelblMF.setBounds(420, 300, 250, 35);

            tablecontainerMF.setVisible(false);
            if(tablecontainerMF.isVisible()){HidetableMF.setVisible(true);}
            else{tablecontainerMF.setVisible(false);}               
            strengthfldMF.setVisible(true);
            feecollectionfldMF.setVisible(true);
            feependfldMF.setVisible(true);
            feependingMF.setVisible(true);
            feecollectedlblMF.setVisible(true);
            totalstrengthlblMF.setVisible(true);
            reveueMF.setVisible(true);
            ExpensesMF.setVisible(true);
            ProfitMF.setVisible(true);
            revenuefldMF.setVisible(true);
            expensefldMF.setVisible(true);
            profitfldMF.setVisible(true);
            monthslblMF.setVisible(true);
            monthsoptionaMF.setVisible(true);
            totalfeefldMF.setVisible(true);
            totalfeelblMF.setVisible(true);



            monthyfeelbl2=new GiveGradientLabel(new Font("Gabriola",0,36),"Monthly Fee Record",10,30);
            monthyfeelbl2.setVisible(true);
            toplabelcoverMF.setBounds(640, 210, 250, 40);
            monthyfeelbl2.setBounds(0, 0, 250, 40);
            toplabelcoverMF.add(monthyfeelbl2);
            toplabelcoverMF.setBackground(new Color(20,20,20));
            toplabelcoverMF.setOpaque(true);

            monthlyfeepanelMF.setBounds(150, 250, 1300, 550);
            monthlyfeepanelMF.setBorder(BorderFactory.createCompoundBorder(a1, a2));
            monthlyfeepanelMF.setLayout(null);
            monthlyfeepanelMF.setOpaque(false);
            monthlyfeepanelMF.setVisible(false);

        }
        else{

            imagelblMF.setBounds(640, 40, 390, 390);
            imagelblMF.setIcon(new ImageIcon(new ImageIcon(getClass().getResource("icons/deafultpic3.png")).getImage().getScaledInstance(300, 300, Image.SCALE_SMOOTH)));

            backbtnMF.setBounds(1140, 20, 30, 30);
            backbtnMF.setIcon(new ImageIcon(new ImageIcon(getClass().getResource("icons/Back_2.png")).getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH)));

            nameilblMF.setBounds(40, 80, 120, 30);
            nameilblMF.setFont(new Font("Cooper Black",0,20));

            idilblMF.setBounds(40, 130, 120, 30);
            idilblMF.setFont(new Font("Cooper Black",0,20));

            phoneilblMF.setBounds(40, 180, 120, 30);
            phoneilblMF.setFont(new Font("Cooper Black",0,20));

            cnicilblMF.setBounds(40, 230, 120, 30);
            cnicilblMF.setFont(new Font("Cooper Black",0,20));

            dateofjoinilblMF.setBounds(40, 280, 180, 30);
            dateofjoinilblMF.setFont(new Font("Cooper Black",0,20));

            feeilblMF.setBounds(40, 330, 120, 30);
            feeilblMF.setFont(new Font("Cooper Black",0,20));

            nameifldMF.setBounds(230, 80, 220, 30);
            nameifldMF.setFont(new Font("Goudy Old Style",0,20));

            idifldMF.setBounds(230, 130, 220, 30);
            idifldMF.setFont(new Font("Goudy Old Style",0,20));

            phoneifldMF.setBounds(230, 180, 220, 30);
            phoneifldMF.setFont(new Font("Goudy Old Style",0,20));

            cnicifldMF.setBounds(230, 230, 220, 30);
            cnicifldMF.setFont(new Font("Goudy Old Style",0,20));

            dateofjoinifldMF.setBounds(230, 280, 220, 30);
            dateofjoinifldMF.setFont(new Font("Goudy Old Style",0,20));

            feeifldMF.setBounds(230, 330, 220, 30);
            feeifldMF.setFont(new Font("Goudy Old Style",0,20));

            nameifldMF.setVisible(false);
            idifldMF.setVisible(false);
            phoneifldMF.setVisible(false);
            cnicifldMF.setVisible(false);
            dateofjoinifldMF.setVisible(false);
            feeifldMF.setVisible(false);

            nameilblMF.setVisible(false);
            idilblMF.setVisible(false);
            cnicilblMF.setVisible(false);
            phoneilblMF.setVisible(false);
            dateofjoinilblMF.setVisible(false);
            feeilblMF.setVisible(false);

            backbtnMF.setVisible(false);
            imagelblMF.setVisible(false);

            monthtableMF.getColumnModel().getColumn(0).setPreferredWidth(130);
            monthtableMF.getColumnModel().getColumn(1).setPreferredWidth(200);
            monthtableMF.getColumnModel().getColumn(2).setPreferredWidth(250);
            monthtableMF.getColumnModel().getColumn(3).setPreferredWidth(200);
            monthtableMF.getColumnModel().getColumn(4).setPreferredWidth(100);
            monthtableMF.getColumnModel().getColumn(5).setPreferredWidth(200);
            monthtableMF.getColumnModel().getColumn(6).setPreferredWidth(130);
            monthtableMF.getColumnModel().getColumn(7).setPreferredWidth(130);

            this.monthtableMF.setBounds(0, 10, 1100, 260);
            monthtableMF.setOpaque(false);
            monthtableMF.setRowHeight(28);
            header1=this.monthtableMF.getTableHeader();
            header1.setFont(new Font("Times New Roman",1,20));
            header1.setForeground(Color.WHITE);
            header1.setBackground(new Color(20, 20, 20));
            header1.setBorder(BorderFactory.createLineBorder(new Color(235,207,47), 2));

            monthtableMF.setFont(new Font("Goudy Old Style",0,20));
            monthtableMF.setOpaque(false);
            monthtableMF.setVisible(true);
            tablepaneMF.getViewport().setBackground(new Color(20,20,20));
            tablepaneMF.setBorder(BorderFactory.createLineBorder(Color.darkGray, 1));
            tablepaneMF.getHorizontalScrollBar().setBackground(new Color(20,20,20));
            tablepaneMF.getVerticalScrollBar().setBackground(new Color(20,20,20));
            tablepaneMF.getViewport().setOpaque(true);
            tablecontainerMF.setBounds(50, 190, 1100, 260);
            tablecontainerMF.setBorder(BorderFactory.createLineBorder(new Color(235,207,47), 1));
            tablecontainerMF.setBackground(new Color(20,20,20));
            tablecontainerMF.setOpaque(false);
            tablecontainerMF.setVisible(false);

            showtableMF.setFont(new Font("Goudy Old Style",0,10));
            showtableMF.setBounds(1100, 20, 80, 26);
            
            HidetableMF.setFont(new Font("Goudy Old Style",0,10));
            HidetableMF.setBounds(1100, 20, 80, 26);

            showtableMF.setVisible(true);
            HidetableMF.setVisible(false);

            totalstrengthlblMF.setFont(new Font("Cooper Black",0,20));
            totalstrengthlblMF.setBounds(30, 80, 250, 30);
            
            strengthfldMF.setFont(new Font("Goudy Old Style",0,20));
            strengthfldMF.setBounds(250, 80, 150, 30);

            feecollectedlblMF.setFont(new Font("Cooper Black",0,20));
            feecollectedlblMF.setBounds(420, 80, 250, 30);
                        
            feecollectionfldMF.setFont(new Font("Goudy Old Style",0,20));
            feecollectionfldMF.setBounds(650, 80, 150, 30);

            feependingMF.setFont(new Font("Cooper Black",0,20));
            feependingMF.setBounds(800, 80, 250, 30);

            feependfldMF.setFont(new Font("Goudy Old Style",0,20));
            feependfldMF.setBounds(1020, 80, 150, 30);

               
            reveueMF.setFont(new Font("Cooper Black",0,20));
            reveueMF.setBounds(30, 160, 250, 30);

            ExpensesMF.setFont(new Font("Cooper Black",0,20));
            ExpensesMF.setBounds(420, 160, 250, 30);

            ProfitMF.setFont(new Font("Cooper Black",0,20));
            ProfitMF.setBounds(800, 160, 250, 30);

            revenuefldMF.setFont(new Font("Goudy Old Style",0,20));
            revenuefldMF.setBounds(250, 160, 150, 30);

            expensefldMF.setFont(new Font("Goudy Old Style",0,20));
            expensefldMF.setBounds(650, 160, 150, 30);

            profitfldMF.setFont(new Font("Goudy Old Style",0,20));
            profitfldMF.setBounds(1020, 160, 150, 30);



            monthslblMF.setFont(new Font("Cooper Black",0,20));
            monthslblMF.setBounds(350, 10, 150, 30);

            monthsoptionaMF.setFont(new Font("Goudy Old Style",0,20));
            monthsoptionaMF.setBounds(500, 10, 200, 30);

            totalfeefldMF.setFont(new Font("Goudy Old Style",0,20));
            totalfeefldMF.setBounds(570, 240, 220, 30);

            totalfeelblMF.setFont(new Font("Cooper Black",0,20));
            totalfeelblMF.setBounds(350, 240, 220, 30);

            tablecontainerMF.setVisible(false);
            if(tablecontainerMF.isVisible()){HidetableMF.setVisible(true);}
            else{tablecontainerMF.setVisible(false);}               
            strengthfldMF.setVisible(true);
            feecollectionfldMF.setVisible(true);
            feependfldMF.setVisible(true);
            feependingMF.setVisible(true);
            feecollectedlblMF.setVisible(true);
            totalstrengthlblMF.setVisible(true);
            reveueMF.setVisible(true);
            ExpensesMF.setVisible(true);
            ProfitMF.setVisible(true);
            revenuefldMF.setVisible(true);
            expensefldMF.setVisible(true);
            profitfldMF.setVisible(true);
            monthslblMF.setVisible(true);
            monthsoptionaMF.setVisible(true);
            totalfeefldMF.setVisible(true);
            totalfeelblMF.setVisible(true);


            monthyfeelbl3=new GiveGradientLabel(new Font("Gabriola",0,28),"Monthly Fee Record",10,25);
            monthyfeelbl3.setVisible(true);
            toplabelcoverMF.setBounds(520, 155, 210, 30);
            monthyfeelbl3.setBounds(0, 0, 220, 30);
            toplabelcoverMF.add(monthyfeelbl3);
            toplabelcoverMF.setBackground(new Color(20,20,20));
            toplabelcoverMF.setOpaque(true);

            monthlyfeepanelMF.setBounds(50, 185, 1200, 470);
            monthlyfeepanelMF.setBorder(BorderFactory.createCompoundBorder(a1, a2));
            monthlyfeepanelMF.setLayout(null);
            monthlyfeepanelMF.setOpaque(false);
            monthlyfeepanelMF.setVisible(false);

        }




        //............Monthly Fee Record ....................................................


        //............Replace Information of Gym Client .......................................
        if(Screensize.getWidth()==1920){
            imagelblRI.setBounds(700, 150, 350, 350);
            imagelblRI.setIcon(new ImageIcon(new ImageIcon(getClass().getResource("icons/deafultpic3.png")).getImage().getScaledInstance(350, 350, Image.SCALE_SMOOTH)));
            imagelblRI.setVisible(false);


            backbtnRI.setBounds(1200, 20, 40, 40);
            backbtnRI.setIcon(new ImageIcon(new ImageIcon(getClass().getResource("icons/Back_2.png")).getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH)));
            backbtnRI.setVisible(false);


            replaceimagebtnRI.setBounds(800, 510, 150, 30);
            replaceimagebtnRI.setFont(new Font("Cooper Black",0,14));
            replaceimagebtnRI.setVisible(false);


            replacebtnRI.setFont(new Font("Cooper Black",0,20));
            replacebtnRI.setBounds(530, 600, 300, 40);
            replacebtnRI.setVisible(false);

            dateofjoinlblRI.setFont(new Font("Cooper Black",0,22));
            dateofjoinlblRI.setBounds(50, 470, 250, 40);
            dateofjoinlblRI.setVisible(false);
            
            cniclblRI.setFont(new Font("Cooper Black",0,22));
            cniclblRI.setBounds(100, 390, 150, 40);
            cniclblRI.setVisible(false);

            cnicfldRI.setFont(new Font("Goudy Old Style",0,22));
            cnicfldRI.setBounds(280, 390, 250, 40);
            cnicfldRI.setVisible(false);

            phonelblRI.setFont(new Font("Cooper Black",0,22));
            phonelblRI.setBounds(0, 310, 250, 40);
            phonelblRI.setVisible(false);

            phonefldRI.setFont(new Font("Goudy Old Style",0,22));
            phonefldRI.setBounds(280, 310, 250, 40);
            phonefldRI.setVisible(false);

            idlblRI.setFont(new Font("Cooper Black",0,22));
            idlblRI.setBounds(100, 230, 150, 40);
            idlblRI.setVisible(false);

            idfldRI.setFont(new Font("Goudy Old Style",0,22));
            idfldRI.setBounds(280, 230, 250, 40);
            idfldRI.setVisible(false);

            idsfldRI.setFont(new Font("Goudy Old Style",0,22));
            idsfldRI.setBounds(280, 40, 250, 40);

            namelblRI.setFont(new Font("Cooper Black",0,22));
            namelblRI.setBounds(100, 150, 150, 40);
            namelblRI.setVisible(false);

            namefldRI.setFont(new Font("Goudy Old Style",0,22));
            namefldRI.setBounds(280, 150, 250, 40);
            namefldRI.setVisible(false);

            namesfldRI.setFont(new Font("Goudy Old Style",0,22));
            namesfldRI.setBounds(280, 40, 250, 40);

            SelectbtnRI.setFont(new Font("Cooper Black",0,20));
            SelectbtnRI.setBounds(500, 490, 150, 30);
            SelectbtnRI.setVisible(true);

            tableRI.getColumnModel().getColumn(0).setPreferredWidth(130);
            tableRI.getColumnModel().getColumn(1).setPreferredWidth(200);
            tableRI.getColumnModel().getColumn(2).setPreferredWidth(250);
            tableRI.getColumnModel().getColumn(3).setPreferredWidth(200);
            tableRI.getColumnModel().getColumn(4).setPreferredWidth(100);
            tableRI.getColumnModel().getColumn(5).setPreferredWidth(200);
            tableRI.getColumnModel().getColumn(6).setPreferredWidth(130);
            tableRI.getColumnModel().getColumn(7).setPreferredWidth(115);

            this.tableRI.setBounds(0, 10, 1190, 300);
            tableRI.setOpaque(false);
            tableRI.setRowHeight(28);
            header1=this.tableRI.getTableHeader();
            header1.setFont(new Font("Times New Roman",1,24));
            header1.setForeground(Color.WHITE);
            header1.setBackground(new Color(20, 20, 20));
            header1.setBorder(BorderFactory.createLineBorder(new Color(235,207,47), 2));

            tableRI.setFont(new Font("Goudy Old Style",0,24));
            tableRI.setOpaque(false);
            tableRI.setVisible(true);
            paneRI.getViewport().setBackground(new Color(20,20,20));
            paneRI.setBorder(BorderFactory.createLineBorder(Color.darkGray, 1));
            paneRI.getHorizontalScrollBar().setBackground(new Color(20,20,20));
            paneRI.getVerticalScrollBar().setBackground(new Color(20,20,20));
            paneRI.getViewport().setOpaque(true);
            tableContainerRI.setBounds(50, 150, 1190, 300);
            tableContainerRI.setBorder(BorderFactory.createLineBorder(new Color(235,207,47), 1));
            tableContainerRI.setBackground(new Color(20,20,20));
            tableContainerRI.setOpaque(false);
            tableContainerRI.setVisible(true);

            imagelblRI.setVisible(false);
            replaceimagebtnRI.setVisible(false);

            selectlblRI.setFont(new Font("Cooper Black",0,24));
            selectlblRI.setBounds(100, 40, 150, 40);

            optionsRI.setFont(new Font("Goudy Old Style",0,24));
            optionsRI.setBounds(280, 40, 250, 40);

            searchbtnRI.setFont(new Font("Cooper Black",0,20));
            searchbtnRI.setBounds(600, 45, 120, 30);
            
            clearbtnRI.setFont(new Font("Cooper Black",0,20));
            clearbtnRI.setBounds(790, 45, 120, 30);

            datechooserRI.setBounds(280, 470, 280, 40);
            datechooserRI.setFont(new Font("Goudy Old Style",0,18));
            fielddateRI.setFont(new Font("Goudy Old Style",0,24));
            calenbtnRI.setIcon(new ImageIcon(new ImageIcon(getClass().getResource("icons/calen.png")).getImage().getScaledInstance(30, 30, 4)));
            datechooserRI.setVisible(false);

            replacelbl1=new GiveGradientLabel(new Font("Gabriola",0,42),"Replace Information of Member",10,35);
            replacelbl1.setVisible(true);
            toplabelcoverRI.setBounds(740, 250, 425, 50);
            replacelbl1.setBounds(0, 0, 425, 50);
            toplabelcoverRI.add(replacelbl1);
            toplabelcoverRI.setBackground(new Color(20,20,20));
            toplabelcoverRI.setOpaque(true);

            replacepanelRI.setBounds(320, 300, 1290, 680);
            replacepanelRI.setBorder(BorderFactory.createCompoundBorder(a1, a2));
            replacepanelRI.setLayout(null);
            replacepanelRI.setOpaque(false);
            replacepanelRI.setVisible(false);
        }
        else if(Screensize.getWidth()>=1536&&Screensize.getWidth()<1920){
            imagelblRI.setBounds(700, 100, 300, 300);
            imagelblRI.setIcon(new ImageIcon(new ImageIcon(getClass().getResource("icons/deafultpic3.png")).getImage().getScaledInstance(300, 300, Image.SCALE_SMOOTH)));

            backbtnRI.setBounds(1040, 20, 40, 40);
            backbtnRI.setIcon(new ImageIcon(new ImageIcon(getClass().getResource("icons/Back_2.png")).getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH)));

            replaceimagebtnRI.setBounds(800, 410, 120, 25);
            replaceimagebtnRI.setFont(new Font("Cooper Black",0,12));

            imagelblRI.setVisible(false);
            backbtnRI.setVisible(false);
            replaceimagebtnRI.setVisible(false);

            replacebtnRI.setFont(new Font("Cooper Black",0,20));
            replacebtnRI.setBounds(450, 490, 300, 40);
            replacebtnRI.setVisible(false);

            dateofjoinlblRI.setFont(new Font("Cooper Black",0,20));
            dateofjoinlblRI.setBounds(50, 380, 250, 40);
            dateofjoinlblRI.setVisible(false);

            
            cniclblRI.setFont(new Font("Cooper Black",0,20));
            cniclblRI.setBounds(60, 310, 150, 40);
            cniclblRI.setVisible(false);

            cnicfldRI.setFont(new Font("Goudy Old Style",0,20));
            cnicfldRI.setBounds(280, 310, 250, 40);
            cnicfldRI.setVisible(false);

            phonelblRI.setFont(new Font("Cooper Black",0,20));
            phonelblRI.setBounds(0, 240, 250, 40);
            phonelblRI.setVisible(false);

            phonefldRI.setFont(new Font("Goudy Old Style",0,20));
            phonefldRI.setBounds(280, 240, 250, 40);
            phonefldRI.setVisible(false);

            idlblRI.setFont(new Font("Cooper Black",0,20));
            idlblRI.setBounds(60, 170, 150, 40);
            idlblRI.setVisible(false);

            idfldRI.setFont(new Font("Goudy Old Style",0,20));
            idfldRI.setBounds(280, 170, 250, 40);
            idfldRI.setVisible(false);

            namelblRI.setFont(new Font("Cooper Black",0,20));
            namelblRI.setBounds(60, 100, 150, 40);
            namelblRI.setVisible(false);

            namefldRI.setFont(new Font("Goudy Old Style",0,20));
            namefldRI.setBounds(280, 100, 250, 40);
            namefldRI.setVisible(false);

            SelectbtnRI.setFont(new Font("Cooper Black",0,20));
            SelectbtnRI.setBounds(450, 420, 150, 30);
            SelectbtnRI.setVisible(true);

            tableRI.getColumnModel().getColumn(0).setPreferredWidth(130);
            tableRI.getColumnModel().getColumn(1).setPreferredWidth(200);
            tableRI.getColumnModel().getColumn(2).setPreferredWidth(250);
            tableRI.getColumnModel().getColumn(3).setPreferredWidth(200);
            tableRI.getColumnModel().getColumn(4).setPreferredWidth(100);
            tableRI.getColumnModel().getColumn(5).setPreferredWidth(200);
            tableRI.getColumnModel().getColumn(6).setPreferredWidth(130);
            tableRI.getColumnModel().getColumn(7).setPreferredWidth(115);

            this.tableRI.setBounds(0, 10, 1020, 220);
            tableRI.setOpaque(false);
            tableRI.setRowHeight(28);
            header1=this.tableRI.getTableHeader();
            header1.setFont(new Font("Times New Roman",1,20));
            header1.setForeground(Color.WHITE);
            header1.setBackground(new Color(20, 20, 20));
            header1.setBorder(BorderFactory.createLineBorder(new Color(235,207,47), 2));

            tableRI.setFont(new Font("Goudy Old Style",0,20));
            tableRI.setOpaque(false);
            tableRI.setVisible(true);
            paneRI.getViewport().setBackground(new Color(20,20,20));
            paneRI.setBorder(BorderFactory.createLineBorder(Color.darkGray, 1));
            paneRI.getHorizontalScrollBar().setBackground(new Color(20,20,20));
            paneRI.getVerticalScrollBar().setBackground(new Color(20,20,20));
            paneRI.getViewport().setOpaque(true);
            tableContainerRI.setBounds(50, 150, 1020, 220);
            tableContainerRI.setBorder(BorderFactory.createLineBorder(new Color(235,207,47), 1));
            tableContainerRI.setBackground(new Color(20,20,20));
            tableContainerRI.setOpaque(false);
            tableContainerRI.setVisible(true);


            selectlblRI.setFont(new Font("Cooper Black",0,20));
            selectlblRI.setBounds(50, 40, 150, 40);

            optionsRI.setFont(new Font("Goudy Old Style",0,20));
            optionsRI.setBounds(240, 40, 250, 40);

            idsfldRI.setFont(new Font("Goudy Old Style",0,22));
            idsfldRI.setBounds(240, 40, 250, 40);

            namesfldRI.setFont(new Font("Goudy Old Style",0,22));
            namesfldRI.setBounds(240, 40, 250, 40);

            searchbtnRI.setFont(new Font("Cooper Black",0,20));
            searchbtnRI.setBounds(600, 45, 120, 30);
            
            clearbtnRI.setFont(new Font("Cooper Black",0,20));
            clearbtnRI.setBounds(790, 45, 120, 30);

            datechooserRI.setBounds(280, 380, 250, 40);
            datechooserRI.setFont(new Font("Goudy Old Style",0,16));
            fielddateRI.setFont(new Font("Goudy Old Style",0,22));
            calenbtnRI.setIcon(new ImageIcon(new ImageIcon(getClass().getResource("icons/calen.png")).getImage().getScaledInstance(30, 30, 4)));
            datechooserRI.setVisible(false);

            replacelbl2=new GiveGradientLabel(new Font("Gabriola",0,36),"Replace Information of Member",10,30);
            replacelbl2.setVisible(true);
            toplabelcoverRI.setBounds(580, 200, 370, 40);
            replacelbl2.setBounds(0, 0, 370, 40);
            toplabelcoverRI.add(replacelbl2);
            toplabelcoverRI.setBackground(new Color(20,20,20));
            toplabelcoverRI.setOpaque(true);

            replacepanelRI.setBounds(200, 240, 1120, 550);
            replacepanelRI.setBorder(BorderFactory.createCompoundBorder(a1, a2));
            replacepanelRI.setLayout(null);
            replacepanelRI.setOpaque(false);
            replacepanelRI.setVisible(false);

        }
        else{
            imagelblRI.setBounds(590, 100, 250, 250);
            imagelblRI.setIcon(new ImageIcon(new ImageIcon(getClass().getResource("icons/deafultpic3.png")).getImage().getScaledInstance(250, 250, Image.SCALE_SMOOTH)));

            backbtnRI.setBounds(850, 20, 30, 30);
            backbtnRI.setIcon(new ImageIcon(new ImageIcon(getClass().getResource("icons/Back_2.png")).getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH)));

            replaceimagebtnRI.setBounds(670, 360, 110, 20);
            replaceimagebtnRI.setFont(new Font("Cooper Black",0,10));

            imagelblRI.setVisible(false);
            backbtnRI.setVisible(false);
            replaceimagebtnRI.setVisible(false);

            replacebtnRI.setFont(new Font("Cooper Black",0,16));
            replacebtnRI.setBounds(350, 400, 220, 30);
            replacebtnRI.setVisible(false);

            dateofjoinlblRI.setFont(new Font("Cooper Black",0,18));
            dateofjoinlblRI.setBounds(10, 310, 200, 30);
            dateofjoinlblRI.setVisible(false);

            
            cniclblRI.setFont(new Font("Cooper Black",0,20));
            cniclblRI.setBounds(40, 260, 150, 30);
            cniclblRI.setVisible(false);

            cnicfldRI.setFont(new Font("Goudy Old Style",0,20));
            cnicfldRI.setBounds(200, 260, 200, 30);
            cnicfldRI.setVisible(false);
            cnicfldRI.addKeyListener(this);

            phonelblRI.setFont(new Font("Cooper Black",0,18));
            phonelblRI.setBounds(0, 210, 150, 30);
            phonelblRI.setVisible(false);

            phonefldRI.setFont(new Font("Goudy Old Style",0,20));
            phonefldRI.setBounds(200, 210, 200, 30);
            phonefldRI.setVisible(false);
            phonefldRI.addKeyListener(this);


            idlblRI.setFont(new Font("Cooper Black",0,20));
            idlblRI.setBounds(40, 160, 150, 30);
            idlblRI.setVisible(false);

            idfldRI.setFont(new Font("Goudy Old Style",0,20));
            idfldRI.setBounds(200, 160, 200, 30);
            idfldRI.setVisible(false);

            namelblRI.setFont(new Font("Cooper Black",0,20));
            namelblRI.setBounds(40, 110, 150, 30);
            namelblRI.setVisible(false);

            namefldRI.setFont(new Font("Goudy Old Style",0,20));
            namefldRI.setBounds(200, 110, 200, 30);
            namefldRI.setVisible(false);

            SelectbtnRI.setFont(new Font("Cooper Black",0,18));
            SelectbtnRI.setBounds(360, 380, 150, 30);
            SelectbtnRI.setVisible(true);

            tableRI.getColumnModel().getColumn(0).setPreferredWidth(130);
            tableRI.getColumnModel().getColumn(1).setPreferredWidth(200);
            tableRI.getColumnModel().getColumn(2).setPreferredWidth(250);
            tableRI.getColumnModel().getColumn(3).setPreferredWidth(200);
            tableRI.getColumnModel().getColumn(4).setPreferredWidth(100);
            tableRI.getColumnModel().getColumn(5).setPreferredWidth(200);
            tableRI.getColumnModel().getColumn(6).setPreferredWidth(130);
            tableRI.getColumnModel().getColumn(7).setPreferredWidth(115);

            this.tableRI.setBounds(0, 10, 800, 200);
            tableRI.setOpaque(false);
            tableRI.setRowHeight(28);
            header1=this.tableRI.getTableHeader();
            header1.setFont(new Font("Times New Roman",1,20));
            header1.setForeground(Color.WHITE);
            header1.setBackground(new Color(20, 20, 20));
            header1.setBorder(BorderFactory.createLineBorder(new Color(235,207,47), 2));

            tableRI.setFont(new Font("Goudy Old Style",0,20));
            tableRI.setOpaque(false);
            tableRI.setVisible(true);
            paneRI.getViewport().setBackground(new Color(20,20,20));
            paneRI.setBorder(BorderFactory.createLineBorder(Color.darkGray, 1));
            paneRI.getHorizontalScrollBar().setBackground(new Color(20,20,20));
            paneRI.getVerticalScrollBar().setBackground(new Color(20,20,20));
            paneRI.getViewport().setOpaque(true);
            tableContainerRI.setBounds(50, 130, 800, 200);
            tableContainerRI.setBorder(BorderFactory.createLineBorder(new Color(235,207,47), 1));
            tableContainerRI.setBackground(new Color(20,20,20));
            tableContainerRI.setOpaque(false);
            tableContainerRI.setVisible(true);


            selectlblRI.setFont(new Font("Cooper Black",0,20));
            selectlblRI.setBounds(40, 40, 150, 30);

            optionsRI.setFont(new Font("Goudy Old Style",0,20));
            optionsRI.setBounds(200, 40, 200, 30);

            idsfldRI.setFont(new Font("Goudy Old Style",0,22));
            idsfldRI.setBounds(200, 40, 200, 30);

            namesfldRI.setFont(new Font("Goudy Old Style",0,22));
            namesfldRI.setBounds(200, 40, 200, 30);

            searchbtnRI.setFont(new Font("Cooper Black",0,18));
            searchbtnRI.setBounds(500, 45, 120, 30);
            
            clearbtnRI.setFont(new Font("Cooper Black",0,18));
            clearbtnRI.setBounds(690, 45, 120, 30);

            datechooserRI.setBounds(200, 310, 200, 30);
            datechooserRI.setFont(new Font("Goudy Old Style",0,14));
            fielddateRI.setFont(new Font("Goudy Old Style",0,20));
            calenbtnRI.setIcon(new ImageIcon(new ImageIcon(getClass().getResource("icons/calen.png")).getImage().getScaledInstance(20, 20, 4)));
            datechooserRI.setVisible(false);


            replacelbl3=new GiveGradientLabel(new Font("Gabriola",0,28),"Replace Information of  Member",10,25);
            replacelbl3.setVisible(true);
            toplabelcoverRI.setBounds(480, 170, 295, 30);
            replacelbl3.setBounds(0, 0, 295, 30);
            toplabelcoverRI.add(replacelbl3);
            toplabelcoverRI.setBackground(new Color(20,20,20));
            toplabelcoverRI.setOpaque(true);

            replacepanelRI.setBounds(210, 200, 900, 450);
            replacepanelRI.setBorder(BorderFactory.createCompoundBorder(a1, a2));
            replacepanelRI.setLayout(null);
            replacepanelRI.setOpaque(false);
            replacepanelRI.setVisible(false);

        }



        //............Replace Information of Gym Client .......................................



        //............Fee of Gym Client .......................................

        if(Screensize.getWidth()==1920){
            imagelblAF.setBounds(700, 50, 350, 350);
            imagelblAF.setIcon(new ImageIcon(new ImageIcon(getClass().getResource("icons/deafultpic3.png")).getImage().getScaledInstance(350, 350, Image.SCALE_SMOOTH)));

            backbtnAF.setBounds(1200, 20, 40, 40);
            backbtnAF.setIcon(new ImageIcon(new ImageIcon(getClass().getResource("icons/Back_2.png")).getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH)));

            nameilblAF.setBounds(100, 50, 150, 40);
            nameilblAF.setFont(new Font("Cooper Black",0,24));

            idilblAF.setBounds(100, 120, 150, 40);
            idilblAF.setFont(new Font("Cooper Black",0,24));

            phoneilblAF.setBounds(100, 190, 150, 40);
            phoneilblAF.setFont(new Font("Cooper Black",0,24));

            cnicilblAF.setBounds(100, 260, 150, 40);
            cnicilblAF.setFont(new Font("Cooper Black",0,24));

            dateofjoinilblAF.setBounds(100, 330, 200, 40);
            dateofjoinilblAF.setFont(new Font("Cooper Black",0,24));

            feeilblAF.setBounds(100, 400, 150, 40);
            feeilblAF.setFont(new Font("Cooper Black",0,24));

            nameifldAF.setBounds(270, 50, 250, 40);
            nameifldAF.setFont(new Font("Goudy Old Style",0,24));

            idifldAF.setBounds(270, 120, 250, 40);
            idifldAF.setFont(new Font("Goudy Old Style",0,24));

            phoneifldAF.setBounds(270, 190, 250, 40);
            phoneifldAF.setFont(new Font("Goudy Old Style",0,24));

            cnicifldAF.setBounds(270, 260, 250, 40);
            cnicifldAF.setFont(new Font("Goudy Old Style",0,24));

            dateofjoinifldAF.setBounds(270, 330, 250, 40);
            dateofjoinifldAF.setFont(new Font("Goudy Old Style",0,24));

            feeifldAF.setBounds(270, 400, 250, 40);
            feeifldAF.setFont(new Font("Goudy Old Style",0,24));

            nameifldAF.setVisible(false);
            idifldAF.setVisible(false);
            phoneifldAF.setVisible(false);
            cnicifldAF.setVisible(false);
            dateofjoinifldAF.setVisible(false);
            feeifldAF.setVisible(false);

            nameilblAF.setVisible(false);
            idilblAF.setVisible(false);
            cnicilblAF.setVisible(false);
            phoneilblAF.setVisible(false);
            dateofjoinilblAF.setVisible(false);
            feeilblAF.setVisible(false);

            backbtnAF.setVisible(false);
            imagelblAF.setVisible(false);


            searchtableAF.getColumnModel().getColumn(0).setPreferredWidth(130);
            searchtableAF.getColumnModel().getColumn(1).setPreferredWidth(200);
            searchtableAF.getColumnModel().getColumn(2).setPreferredWidth(250);
            searchtableAF.getColumnModel().getColumn(3).setPreferredWidth(200);
            searchtableAF.getColumnModel().getColumn(4).setPreferredWidth(100);
            searchtableAF.getColumnModel().getColumn(5).setPreferredWidth(200);
            searchtableAF.getColumnModel().getColumn(6).setPreferredWidth(115);
            searchtableAF.getColumnModel().getColumn(7).setPreferredWidth(130);

            this.searchtableAF.setBounds(0, 10, 1190, 220);
            searchtableAF.setOpaque(false);
            searchtableAF.setRowHeight(28);
            header1=this.searchtableAF.getTableHeader();
            header1.setFont(new Font("Times New Roman",1,24));
            header1.setForeground(Color.WHITE);
            header1.setBackground(new Color(20, 20, 20));
            header1.setBorder(BorderFactory.createLineBorder(new Color(235,207,47), 2));

            searchtableAF.setFont(new Font("Goudy Old Style",0,24));
            searchtableAF.setOpaque(false);
            searchtableAF.setVisible(true);
            tablepaneAF.getViewport().setBackground(new Color(20,20,20));
            tablepaneAF.setBorder(BorderFactory.createLineBorder(Color.darkGray, 1));
            tablepaneAF.getHorizontalScrollBar().setBackground(new Color(20,20,20));
            tablepaneAF.getVerticalScrollBar().setBackground(new Color(20,20,20));
            tablepaneAF.getViewport().setOpaque(true);
            tablecontainerAF.setBounds(50, 150, 1190, 220);
            tablecontainerAF.setBorder(BorderFactory.createLineBorder(new Color(235,207,47), 1));
            tablecontainerAF.setBackground(new Color(20,20,20));
            tablecontainerAF.setOpaque(false);
            tablecontainerAF.setVisible(true);

            feelblAF.setFont(new Font("Goudy Old Style",0,24));
            feelblAF.setBounds(350, 480, 150, 40);

            feefldAF.setFont(new Font("Goudy Old Style",0,24));
            feefldAF.setBounds(550, 480, 250, 40);

            addfeeAF.setFont(new Font("Cooper Black",0,22));
            addfeeAF.setBounds(550, 550, 200, 35);

            instructionAF.setFont(new Font("Goudy Old Style",0,18));
            instructionAF.setBounds(80, 370, 300, 40);


            searchlblAF.setFont(new Font("Cooper Black",0,24));
            searchlblAF.setBounds(80, 50, 120, 40);
            searchlblAF.setText("Search :");
            searchlblAF.setVisible(true);

            namefldAF.setFont(new Font("Goudy Old Style",0,22));
            namefldAF.setBounds(250, 50, 250, 40);
            
            idfldAF.setFont(new Font("Goudy Old Style",0,22));
            idfldAF.setBounds(250, 50, 250, 40);

            searchoptionsAF.setFont(new Font("Goudy Old Style",0,22));
            searchoptionsAF.setBounds(250, 50, 250, 40);
            searchoptionsAF.setVisible(true);



            searchbtnAF.setFont(new Font("Cooper Black",0,22));
            searchbtnAF.setBounds(550, 55, 120, 30);
            searchbtnAF.setVisible(true);

            clearbtnAF.setFont(new Font("Cooper Black",0,22));
            clearbtnAF.setBounds(700, 55, 120, 30);
            clearbtnAF.setVisible(true);

            addfeelbl1=new GiveGradientLabel(new Font("Gabriola",0,42),"Add  Fee  of  Member",10,35);
            addfeelbl1.setVisible(true);
            toplabelcoverAF.setBounds(810, 250, 300, 50);
            addfeelbl1.setBounds(0, 0, 320, 50);
            toplabelcoverAF.add(addfeelbl1);
            toplabelcoverAF.setBackground(new Color(20,20,20));
            toplabelcoverAF.setOpaque(true);

            feepanelAF.setBounds(320, 300, 1290, 680);
            feepanelAF.setBorder(BorderFactory.createCompoundBorder(a1, a2));
            feepanelAF.setLayout(null);
            feepanelAF.setOpaque(false);
            feepanelAF.setVisible(false);
        }
        else if(Screensize.getWidth()>=1536&&Screensize.getWidth()<1920){

            imagelblAF.setBounds(700, 50, 300, 300);
            imagelblAF.setIcon(new ImageIcon(new ImageIcon(getClass().getResource("icons/deafultpic3.png")).getImage().getScaledInstance(300, 300, Image.SCALE_SMOOTH)));

            backbtnAF.setBounds(1040, 20, 40, 40);
            backbtnAF.setIcon(new ImageIcon(new ImageIcon(getClass().getResource("icons/Back_2.png")).getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH)));

            nameilblAF.setBounds(100, 50, 150, 35);
            nameilblAF.setFont(new Font("Cooper Black",0,22));

            idilblAF.setBounds(100, 110, 150, 35);
            idilblAF.setFont(new Font("Cooper Black",0,22));

            phoneilblAF.setBounds(100, 170, 150, 35);
            phoneilblAF.setFont(new Font("Cooper Black",0,22));

            cnicilblAF.setBounds(100, 230, 150, 35);
            cnicilblAF.setFont(new Font("Cooper Black",0,22));

            dateofjoinilblAF.setBounds(100, 290, 200, 35);
            dateofjoinilblAF.setFont(new Font("Cooper Black",0,22));

            feeilblAF.setBounds(100, 350, 150, 35);
            feeilblAF.setFont(new Font("Cooper Black",0,22));

            nameifldAF.setBounds(270, 50, 250, 35);
            nameifldAF.setFont(new Font("Goudy Old Style",0,22));

            idifldAF.setBounds(270, 110, 250, 35);
            idifldAF.setFont(new Font("Goudy Old Style",0,22));

            phoneifldAF.setBounds(270, 170, 250, 35);
            phoneifldAF.setFont(new Font("Goudy Old Style",0,22));

            cnicifldAF.setBounds(270, 230, 250, 35);
            cnicifldAF.setFont(new Font("Goudy Old Style",0,22));

            dateofjoinifldAF.setBounds(270, 290, 250, 35);
            dateofjoinifldAF.setFont(new Font("Goudy Old Style",0,22));

            feeifldAF.setBounds(270, 350, 250, 35);
            feeifldAF.setFont(new Font("Goudy Old Style",0,22));

            nameifldAF.setVisible(false);
            idifldAF.setVisible(false);
            phoneifldAF.setVisible(false);
            cnicifldAF.setVisible(false);
            dateofjoinifldAF.setVisible(false);
            feeifldAF.setVisible(false);

            nameilblAF.setVisible(false);
            idilblAF.setVisible(false);
            cnicilblAF.setVisible(false);
            phoneilblAF.setVisible(false);
            dateofjoinilblAF.setVisible(false);
            feeilblAF.setVisible(false);

            backbtnAF.setVisible(false);
            imagelblAF.setVisible(false);

            searchtableAF.getColumnModel().getColumn(0).setPreferredWidth(130);
            searchtableAF.getColumnModel().getColumn(1).setPreferredWidth(200);
            searchtableAF.getColumnModel().getColumn(2).setPreferredWidth(250);
            searchtableAF.getColumnModel().getColumn(3).setPreferredWidth(200);
            searchtableAF.getColumnModel().getColumn(4).setPreferredWidth(100);
            searchtableAF.getColumnModel().getColumn(5).setPreferredWidth(200);
            searchtableAF.getColumnModel().getColumn(6).setPreferredWidth(115);
            searchtableAF.getColumnModel().getColumn(7).setPreferredWidth(130);

            this.searchtableAF.setBounds(0, 10, 1030, 220);
            searchtableAF.setOpaque(false);
            searchtableAF.setRowHeight(28);
            header1=this.searchtableAF.getTableHeader();
            header1.setFont(new Font("Times New Roman",1,22));
            header1.setForeground(Color.WHITE);
            header1.setBackground(new Color(20, 20, 20));
            header1.setBorder(BorderFactory.createLineBorder(new Color(235,207,47), 2));

            searchtableAF.setFont(new Font("Goudy Old Style",0,20));
            searchtableAF.setOpaque(false);
            searchtableAF.setVisible(true);
            tablepaneAF.getViewport().setBackground(new Color(20,20,20));
            tablepaneAF.setBorder(BorderFactory.createLineBorder(Color.darkGray, 1));
            tablepaneAF.getHorizontalScrollBar().setBackground(new Color(20,20,20));
            tablepaneAF.getVerticalScrollBar().setBackground(new Color(20,20,20));
            tablepaneAF.getViewport().setOpaque(true);
            tablecontainerAF.setBounds(50, 130, 1030, 220);
            tablecontainerAF.setBorder(BorderFactory.createLineBorder(new Color(235,207,47), 1));
            tablecontainerAF.setBackground(new Color(20,20,20));
            tablecontainerAF.setOpaque(false);
            tablecontainerAF.setVisible(true);

            feelblAF.setFont(new Font("Goudy Old Style",0,22));
            feelblAF.setBounds(300, 430, 150, 35);

            feefldAF.setFont(new Font("Goudy Old Style",0,22));
            feefldAF.setBounds(450, 430, 200, 35);

            addfeeAF.setFont(new Font("Cooper Black",0,18));
            addfeeAF.setBounds(500, 480, 120, 35);

            instructionAF.setFont(new Font("Goudy Old Style",0,18));
            instructionAF.setBounds(80, 370, 300, 40);


            searchlblAF.setFont(new Font("Cooper Black",0,22));
            searchlblAF.setBounds(50, 50, 120, 40);

            namefldAF.setFont(new Font("Goudy Old Style",0,22));
            namefldAF.setBounds(220, 50, 250, 40);
            
            idfldAF.setFont(new Font("Goudy Old Style",0,22));
            idfldAF.setBounds(220, 50, 250, 40);

            searchoptionsAF.setFont(new Font("Goudy Old Style",0,22));
            searchoptionsAF.setBounds(220, 50, 250, 40);


            searchbtnAF.setFont(new Font("Cooper Black",0,22));
            searchbtnAF.setBounds(550, 55, 120, 30);

            clearbtnAF.setFont(new Font("Cooper Black",0,22));
            clearbtnAF.setBounds(700, 55, 120, 30);


            addfeelbl2=new GiveGradientLabel(new Font("Gabriola",0,36),"Add  Fee  of  Member",10,30);
            addfeelbl2.setVisible(true);
            toplabelcoverAF.setBounds(635, 200, 260, 40);
            addfeelbl2.setBounds(0, 0, 270, 40);
            toplabelcoverAF.add(addfeelbl2);
            toplabelcoverAF.setBackground(new Color(20,20,20));
            toplabelcoverAF.setOpaque(true);

            feepanelAF.setBounds(200, 240, 1120, 550);
            feepanelAF.setBorder(BorderFactory.createCompoundBorder(a1, a2));
            feepanelAF.setLayout(null);
            feepanelAF.setOpaque(false);
            feepanelAF.setVisible(false);

        }
        else{

            imagelblAF.setBounds(590, 50, 250, 250);
            imagelblAF.setIcon(new ImageIcon(new ImageIcon(getClass().getResource("icons/deafultpic3.png")).getImage().getScaledInstance(250, 250, Image.SCALE_SMOOTH)));

            backbtnAF.setBounds(850, 20, 30, 30);
            backbtnAF.setIcon(new ImageIcon(new ImageIcon(getClass().getResource("icons/Back_2.png")).getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH)));

            nameilblAF.setBounds(40, 40, 120, 30);
            nameilblAF.setFont(new Font("Cooper Black",0,20));

            idilblAF.setBounds(40, 90, 120, 30);
            idilblAF.setFont(new Font("Cooper Black",0,20));

            phoneilblAF.setBounds(40, 140, 120, 30);
            phoneilblAF.setFont(new Font("Cooper Black",0,20));

            cnicilblAF.setBounds(40, 190, 120, 30);
            cnicilblAF.setFont(new Font("Cooper Black",0,20));

            dateofjoinilblAF.setBounds(40, 240, 180, 30);
            dateofjoinilblAF.setFont(new Font("Cooper Black",0,20));

            feeilblAF.setBounds(40, 290, 120, 30);
            feeilblAF.setFont(new Font("Cooper Black",0,20));

            nameifldAF.setBounds(230, 40, 220, 30);
            nameifldAF.setFont(new Font("Goudy Old Style",0,20));

            idifldAF.setBounds(230, 90, 220, 30);
            idifldAF.setFont(new Font("Goudy Old Style",0,20));

            phoneifldAF.setBounds(230, 140, 220, 30);
            phoneifldAF.setFont(new Font("Goudy Old Style",0,20));

            cnicifldAF.setBounds(230, 190, 220, 30);
            cnicifldAF.setFont(new Font("Goudy Old Style",0,20));

            dateofjoinifldAF.setBounds(230, 240, 220, 30);
            dateofjoinifldAF.setFont(new Font("Goudy Old Style",0,20));

            feeifldAF.setBounds(230, 290, 220, 30);
            feeifldAF.setFont(new Font("Goudy Old Style",0,20));

            nameifldAF.setVisible(false);
            idifldAF.setVisible(false);
            phoneifldAF.setVisible(false);
            cnicifldAF.setVisible(false);
            dateofjoinifldAF.setVisible(false);
            feeifldAF.setVisible(false);

            nameilblAF.setVisible(false);
            idilblAF.setVisible(false);
            cnicilblAF.setVisible(false);
            phoneilblAF.setVisible(false);
            dateofjoinilblAF.setVisible(false);
            feeilblAF.setVisible(false);

            backbtnAF.setVisible(false);
            imagelblAF.setVisible(false);

            searchtableAF.getColumnModel().getColumn(0).setPreferredWidth(90);
            searchtableAF.getColumnModel().getColumn(1).setPreferredWidth(170);
            searchtableAF.getColumnModel().getColumn(2).setPreferredWidth(210);
            searchtableAF.getColumnModel().getColumn(3).setPreferredWidth(170);
            searchtableAF.getColumnModel().getColumn(4).setPreferredWidth(100);
            searchtableAF.getColumnModel().getColumn(5).setPreferredWidth(180);
            searchtableAF.getColumnModel().getColumn(6).setPreferredWidth(105);
            searchtableAF.getColumnModel().getColumn(7).setPreferredWidth(130);

            this.searchtableAF.setBounds(0, 10, 800, 220);
            searchtableAF.setOpaque(false);
            searchtableAF.setRowHeight(28);
            header1=this.searchtableAF.getTableHeader();
            header1.setFont(new Font("Times New Roman",1,20));
            header1.setForeground(Color.WHITE);
            header1.setBackground(new Color(20, 20, 20));
            header1.setBorder(BorderFactory.createLineBorder(new Color(235,207,47), 2));

            searchtableAF.setFont(new Font("Goudy Old Style",0,18));
            searchtableAF.setOpaque(false);
            searchtableAF.setVisible(true);
            tablepaneAF.getViewport().setBackground(new Color(20,20,20));
            tablepaneAF.setBorder(BorderFactory.createLineBorder(Color.darkGray, 1));
            tablepaneAF.getHorizontalScrollBar().setBackground(new Color(20,20,20));
            tablepaneAF.getVerticalScrollBar().setBackground(new Color(20,20,20));
            tablepaneAF.getViewport().setOpaque(true);
            tablecontainerAF.setBounds(50, 110, 800, 220);
            tablecontainerAF.setBorder(BorderFactory.createLineBorder(new Color(235,207,47), 1));
            tablecontainerAF.setBackground(new Color(20,20,20));
            tablecontainerAF.setOpaque(false);
            tablecontainerAF.setVisible(true);

            feelblAF.setFont(new Font("Goudy Old Style",0,20));
            feelblAF.setBounds(100, 370, 120, 30);

            feefldAF.setFont(new Font("Goudy Old Style",0,20));
            feefldAF.setBounds(250, 370, 200, 30);

            addfeeAF.setFont(new Font("Cooper Black",0,18));
            addfeeAF.setBounds(500, 390, 120, 30);

            instructionAF.setFont(new Font("Goudy Old Style",0,16));
            instructionAF.setBounds(50, 330, 250, 35);


            searchlblAF.setFont(new Font("Cooper Black",0,20));
            searchlblAF.setBounds(50, 40, 120, 35);

            namefldAF.setFont(new Font("Goudy Old Style",0,20));
            namefldAF.setBounds(220, 40, 200, 35);
            
            idfldAF.setFont(new Font("Goudy Old Style",0,20));
            idfldAF.setBounds(220, 40, 200, 35);

            searchoptionsAF.setFont(new Font("Goudy Old Style",0,20));
            searchoptionsAF.setBounds(220, 40, 200, 35);


            searchbtnAF.setFont(new Font("Cooper Black",0,18));
            searchbtnAF.setBounds(550, 45, 100, 25);

            clearbtnAF.setFont(new Font("Cooper Black",0,18));
            clearbtnAF.setBounds(700, 45, 100, 25);

            addfeelbl3=new GiveGradientLabel(new Font("Gabriola",0,28),"Add  Fee  of  Member",10,25);
            addfeelbl3.setVisible(true);
            toplabelcoverAF.setBounds(520, 170, 210, 30);
            addfeelbl3.setBounds(0, 0, 220, 30);
            toplabelcoverAF.add(addfeelbl3);
            toplabelcoverAF.setBackground(new Color(20,20,20));
            toplabelcoverAF.setOpaque(true);

            feepanelAF.setBounds(210, 200, 900, 450);
            feepanelAF.setBorder(BorderFactory.createCompoundBorder(a1, a2));
            feepanelAF.setLayout(null);
            feepanelAF.setOpaque(false);
            feepanelAF.setVisible(false);

        }

        //............Fee of Gym Client .......................................


        //............Search Gym Client .......................................

        if(Screensize.getWidth()==1920){
            imagelblSGC.setBounds(700, 100, 400, 400);
            imagelblSGC.setIcon(new ImageIcon(new ImageIcon(getClass().getResource("icons/deafultpic3.png")).getImage().getScaledInstance(400, 400, Image.SCALE_SMOOTH)));

            backbtnSGC.setBounds(1200, 20, 40, 40);
            backbtnSGC.setIcon(new ImageIcon(new ImageIcon(getClass().getResource("icons/Back_2.png")).getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH)));

            nameilblSGC.setBounds(100, 100, 150, 40);
            nameilblSGC.setFont(new Font("Cooper Black",0,24));

            idilblSGC.setBounds(100, 170, 150, 40);
            idilblSGC.setFont(new Font("Cooper Black",0,24));

            phoneilblSGC.setBounds(100, 240, 150, 40);
            phoneilblSGC.setFont(new Font("Cooper Black",0,24));

            cnicilblSGC.setBounds(100, 310, 150, 40);
            cnicilblSGC.setFont(new Font("Cooper Black",0,24));

            dateofjoinilblSGC.setBounds(100, 380, 200, 40);
            dateofjoinilblSGC.setFont(new Font("Cooper Black",0,24));

            feeilblSGC.setBounds(100, 450, 150, 40);
            feeilblSGC.setFont(new Font("Cooper Black",0,24));

            nameifldSGC.setBounds(270, 100, 250, 40);
            nameifldSGC.setFont(new Font("Goudy Old Style",0,24));

            idifldSGC.setBounds(270, 170, 250, 40);
            idifldSGC.setFont(new Font("Goudy Old Style",0,24));

            phoneifldSGC.setBounds(270, 240, 250, 40);
            phoneifldSGC.setFont(new Font("Goudy Old Style",0,24));

            cnicifldSGC.setBounds(270, 310, 250, 40);
            cnicifldSGC.setFont(new Font("Goudy Old Style",0,24));

            dateofjoinifldSGC.setBounds(270, 380, 250, 40);
            dateofjoinifldSGC.setFont(new Font("Goudy Old Style",0,24));

            feeifldSGC.setBounds(270, 450, 250, 40);
            feeifldSGC.setFont(new Font("Goudy Old Style",0,24));

            nameifldSGC.setVisible(false);
            idifldSGC.setVisible(false);
            phoneifldSGC.setVisible(false);
            cnicifldSGC.setVisible(false);
            dateofjoinifldSGC.setVisible(false);
            feeifldSGC.setVisible(false);

            nameilblSGC.setVisible(false);
            idilblSGC.setVisible(false);
            cnicilblSGC.setVisible(false);
            phoneilblSGC.setVisible(false);
            dateofjoinilblSGC.setVisible(false);
            feeilblSGC.setVisible(false);

            backbtnSGC.setVisible(false);
            imagelblSGC.setVisible(false);

            searchtable.getColumnModel().getColumn(0).setPreferredWidth(130);
            searchtable.getColumnModel().getColumn(1).setPreferredWidth(200);
            searchtable.getColumnModel().getColumn(2).setPreferredWidth(240);
            searchtable.getColumnModel().getColumn(3).setPreferredWidth(200);
            searchtable.getColumnModel().getColumn(4).setPreferredWidth(100);
            searchtable.getColumnModel().getColumn(5).setPreferredWidth(200);
            searchtable.getColumnModel().getColumn(6).setPreferredWidth(115);

            this.searchtable.setBounds(0, 10, 1190, 450);
            searchtable.setOpaque(false);
            searchtable.setRowHeight(30);
            header1=this.searchtable.getTableHeader();
            header1.setFont(new Font("Times New Roman",1,24));
            header1.setForeground(Color.WHITE);
            header1.setBackground(new Color(20, 20, 20));
            header1.setBorder(BorderFactory.createLineBorder(new Color(235,207,47), 2));

            searchtable.setFont(new Font("Goudy Old Style",0,22));
            searchtable.setOpaque(false);
            searchtable.setVisible(true);
            tablepaneSGC.getViewport().setBackground(new Color(20,20,20));
            tablepaneSGC.setBorder(BorderFactory.createLineBorder(Color.darkGray, 1));
            tablepaneSGC.getHorizontalScrollBar().setBackground(new Color(20,20,20));
            tablepaneSGC.getVerticalScrollBar().setBackground(new Color(20,20,20));
            tablepaneSGC.getViewport().setOpaque(true);
            tablecontainerSGC.setBounds(50, 180, 1190, 450);
            tablecontainerSGC.setBorder(BorderFactory.createLineBorder(new Color(235,207,47), 1));
            tablecontainerSGC.setBackground(new Color(20,20,20));
            tablecontainerSGC.setOpaque(false);
            tablecontainerSGC.setVisible(true);




            searchlblSGC.setBounds(100, 80, 200, 40);
            searchlblSGC.setFont(new Font("Cooper Black",0,24));
            searchlblSGC.setText("Search :");


            searchlblSGC.setVisible(true);

            searchoptionsSGC.setBounds(300, 80, 300, 40);
            searchoptionsSGC.setFont(new Font("Times New Roman",1,22));
            searchoptionsSGC.setSelectedIndex(0);
            searchoptionsSGC.setVisible(true);

            idfldSGC.setBounds(300, 80, 300, 40);
            namefldSGC.setBounds(300, 80, 300, 40);
            cnicfldSGC.setBounds(300, 80, 300, 40);
            nameofAdminfldSGC.setBounds(300, 80, 300, 40);


            idfldSGC.setFont(new Font("Goudy Old Style",0,20));
            namefldSGC.setFont(new Font("Goudy Old Style",0,20));
            cnicfldSGC.setFont(new Font("Goudy Old Style",0,20));
            nameofAdminfldSGC.setFont(new Font("Goudy Old Style",1,20));


            phonefldSGC.setBounds(300, 80, 300, 40);
            phonefldSGC.setFont(new Font("Goudy Old Style",0,20));



            searchSGC.setBounds(760, 80, 150, 35);
            searchSGC.setFont(new Font("Cooper Black",0,24));
            searchSGC.setVisible(true);

            clearSGC.setBounds(960, 80, 150, 35);
            clearSGC.setFont(new Font("Cooper Black",0,24));
            clearSGC.setVisible(true);

            namefldSGC.setText(null);
            idfldSGC.setText(null);
            cnicfldSGC.setText(null);
            phonefldSGC.setText(null);
            nameofAdminfldSGC.setText(null);

            namefldSGC.setVisible(false);
            idfldSGC.setVisible(false);
            cnicfldSGC.setVisible(false);
            phonefldSGC.setVisible(false);

            datechooserSGC.setBounds(300, 80, 280, 40);
            datechooserSGC.setFont(new Font("Goudy Old Style",0,18));
            fielddateSGC.setFont(new Font("Goudy Old Style",0,24));
            calenbtnSGC.setIcon(new ImageIcon(new ImageIcon(getClass().getResource("icons/calen.png")).getImage().getScaledInstance(30, 30, 4)));
            datechooserSGC.setVisible(false);


            searchgymclientlbl=new GiveGradientLabel(new Font("Gabriola",0,42),"Search  Gym  Member",10,35);
            searchgymclientlbl.setVisible(true);
            toplabelcoverSGC.setBounds(800, 250, 320, 50);
            searchgymclientlbl.setBounds(0, 0, 320, 50);
            toplabelcoverSGC.add(searchgymclientlbl);
            toplabelcoverSGC.setBackground(new Color(20,20,20));
            toplabelcoverSGC.setOpaque(true);

            searchgymmem.setBounds(320, 300, 1290, 680);
            searchgymmem.setBorder(BorderFactory.createCompoundBorder(a1, a2));
            searchgymmem.setLayout(null);
            searchgymmem.setOpaque(false);
            searchgymmem.setVisible(false);
        }
        else if(Screensize.getWidth()>=1536&&Screensize.getWidth()<1920)
        {
            imagelblSGC.setBounds(650, 100, 350, 350);
            imagelblSGC.setIcon(new ImageIcon(new ImageIcon(getClass().getResource("icons/deafultpic3.png")).getImage().getScaledInstance(350, 350, Image.SCALE_SMOOTH)));

            backbtnSGC.setBounds(1040, 20, 40, 40);
            backbtnSGC.setIcon(new ImageIcon(new ImageIcon(getClass().getResource("icons/Back_2.png")).getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH)));

            nameilblSGC.setBounds(100, 100, 150, 35);
            nameilblSGC.setFont(new Font("Cooper Black",0,22));

            idilblSGC.setBounds(100, 160, 150, 35);
            idilblSGC.setFont(new Font("Cooper Black",0,22));

            phoneilblSGC.setBounds(100, 220, 150, 35);
            phoneilblSGC.setFont(new Font("Cooper Black",0,22));

            cnicilblSGC.setBounds(100, 280, 150, 35);
            cnicilblSGC.setFont(new Font("Cooper Black",0,22));

            dateofjoinilblSGC.setBounds(100, 340, 200, 35);
            dateofjoinilblSGC.setFont(new Font("Cooper Black",0,22));

            feeilblSGC.setBounds(100, 400, 150, 35);
            feeilblSGC.setFont(new Font("Cooper Black",0,22));

            nameifldSGC.setBounds(270, 100, 250, 35);
            nameifldSGC.setFont(new Font("Goudy Old Style",0,22));

            idifldSGC.setBounds(270, 160, 250, 35);
            idifldSGC.setFont(new Font("Goudy Old Style",0,22));

            phoneifldSGC.setBounds(270, 220, 250, 35);
            phoneifldSGC.setFont(new Font("Goudy Old Style",0,22));

            cnicifldSGC.setBounds(270, 280, 250, 35);
            cnicifldSGC.setFont(new Font("Goudy Old Style",0,22));

            dateofjoinifldSGC.setBounds(270, 340, 250, 35);
            dateofjoinifldSGC.setFont(new Font("Goudy Old Style",0,22));

            feeifldSGC.setBounds(270, 400, 250, 35);
            feeifldSGC.setFont(new Font("Goudy Old Style",0,22));

            nameifldSGC.setVisible(false);
            idifldSGC.setVisible(false);
            phoneifldSGC.setVisible(false);
            cnicifldSGC.setVisible(false);
            dateofjoinifldSGC.setVisible(false);
            feeifldSGC.setVisible(false);

            nameilblSGC.setVisible(false);
            idilblSGC.setVisible(false);
            cnicilblSGC.setVisible(false);
            phoneilblSGC.setVisible(false);
            dateofjoinilblSGC.setVisible(false);
            feeilblSGC.setVisible(false);

            backbtnSGC.setVisible(false);
            imagelblSGC.setVisible(false);

            searchtable.getColumnModel().getColumn(0).setPreferredWidth(90);
            searchtable.getColumnModel().getColumn(1).setPreferredWidth(170);
            searchtable.getColumnModel().getColumn(2).setPreferredWidth(210);
            searchtable.getColumnModel().getColumn(3).setPreferredWidth(170);
            searchtable.getColumnModel().getColumn(4).setPreferredWidth(100);
            searchtable.getColumnModel().getColumn(5).setPreferredWidth(180);
            searchtable.getColumnModel().getColumn(6).setPreferredWidth(105);

            this.searchtable.setBounds(0, 10, 1030, 350);
            searchtable.setOpaque(false);
            searchtable.setRowHeight(28);
            header1=this.searchtable.getTableHeader();
            header1.setFont(new Font("Times New Roman",1,22));
            header1.setForeground(Color.WHITE);
            header1.setBackground(new Color(20, 20, 20));
            header1.setBorder(BorderFactory.createLineBorder(new Color(235,207,47), 2));

            searchtable.setFont(new Font("Goudy Old Style",0,20));
            searchtable.setOpaque(false);
            searchtable.setVisible(true);
            tablepaneSGC.getViewport().setBackground(new Color(20,20,20));
            tablepaneSGC.setBorder(BorderFactory.createLineBorder(Color.darkGray, 1));
            tablepaneSGC.getHorizontalScrollBar().setBackground(new Color(20,20,20));
            tablepaneSGC.getVerticalScrollBar().setBackground(new Color(20,20,20));
            tablepaneSGC.getViewport().setOpaque(true);
            tablecontainerSGC.setBounds(50, 150, 1030, 350);
            tablecontainerSGC.setBorder(BorderFactory.createLineBorder(new Color(235,207,47), 1));
            tablecontainerSGC.setBackground(new Color(20,20,20));
            tablecontainerSGC.setOpaque(false);
            tablecontainerSGC.setVisible(true);


            searchlblSGC.setBounds(50, 50, 200, 35);
            searchlblSGC.setFont(new Font("Cooper Black",0,22));

            searchoptionsSGC.setBounds(250, 50, 200, 35);
            searchoptionsSGC.setFont(new Font("Times New Roman",1,20));

            searchlblSGC.setText("Search :");
            searchoptionsSGC.setSelectedIndex(0);

            idfldSGC.setBounds(250, 50, 200, 35);
            namefldSGC.setBounds(250, 50, 200, 35);
            cnicfldSGC.setBounds(250, 50, 200, 35);
            nameofAdminfldSGC.setBounds(250, 50, 200, 35);

            idfldSGC.setFont(new Font("Goudy Old Style",0,20));
            namefldSGC.setFont(new Font("Goudy Old Style",0,20));
            cnicfldSGC.setFont(new Font("Goudy Old Style",0,20));
            nameofAdminfldSGC.setFont(new Font("Goudy Old Style",1,20));

            phonefldSGC.setBounds(250, 50, 200, 35);
            phonefldSGC.setFont(new Font("Goudy Old Style",0,20));



            searchSGC.setBounds(560, 50, 120, 30);
            searchSGC.setFont(new Font("Cooper Black",0,24));

            clearSGC.setBounds(760, 50, 120, 30);
            clearSGC.setFont(new Font("Cooper Black",0,24));
            

            namefldSGC.setText(null);
            idfldSGC.setText(null);
            cnicfldSGC.setText(null);
            phonefldSGC.setText(null);
            nameofAdminfldSGC.setText(null);

            namefldSGC.setVisible(false);
            idfldSGC.setVisible(false);
            cnicfldSGC.setVisible(false);
            phonefldSGC.setVisible(false);

            datechooserSGC.setBounds(250, 50, 200, 35);
            datechooserSGC.setFont(new Font("Goudy Old Style",0,16));
            fielddateSGC.setFont(new Font("Goudy Old Style",0,24));
            calenbtnSGC.setIcon(new ImageIcon(new ImageIcon(getClass().getResource("icons/calen.png")).getImage().getScaledInstance(30, 30, 4)));
            datechooserSGC.setVisible(false);

            searchlblSGC.setVisible(true);
            searchoptionsSGC.setVisible(true);
            searchSGC.setVisible(true);
            clearSGC.setVisible(true);

            searchgymclientlbl2=new GiveGradientLabel(new Font("Gabriola",0,36),"Search  Gym  Member",10,30);
            searchgymclientlbl2.setVisible(true);
            toplabelcoverSGC.setBounds(635, 200, 270, 40);
            searchgymclientlbl2.setBounds(0, 0, 270, 40);
            toplabelcoverSGC.add(searchgymclientlbl2);
            toplabelcoverSGC.setBackground(new Color(20,20,20));
            toplabelcoverSGC.setOpaque(true);

            searchgymmem.setBounds(200, 240, 1120, 550);
            searchgymmem.setBorder(BorderFactory.createCompoundBorder(a1, a2));
            searchgymmem.setLayout(null);
            searchgymmem.setOpaque(false);
            searchgymmem.setVisible(false);
        }
        else
        {
            imagelblSGC.setBounds(540, 80, 300, 300);
            imagelblSGC.setIcon(new ImageIcon(new ImageIcon(getClass().getResource("icons/deafultpic3.png")).getImage().getScaledInstance(300, 300, Image.SCALE_SMOOTH)));

            backbtnSGC.setBounds(850, 20, 30, 30);
            backbtnSGC.setIcon(new ImageIcon(new ImageIcon(getClass().getResource("icons/Back_2.png")).getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH)));

            nameilblSGC.setBounds(40, 80, 120, 30);
            nameilblSGC.setFont(new Font("Cooper Black",0,20));

            idilblSGC.setBounds(40, 130, 120, 30);
            idilblSGC.setFont(new Font("Cooper Black",0,20));

            phoneilblSGC.setBounds(40, 180, 120, 30);
            phoneilblSGC.setFont(new Font("Cooper Black",0,20));

            cnicilblSGC.setBounds(40, 230, 120, 30);
            cnicilblSGC.setFont(new Font("Cooper Black",0,20));

            dateofjoinilblSGC.setBounds(40, 280, 180, 30);
            dateofjoinilblSGC.setFont(new Font("Cooper Black",0,20));

            feeilblSGC.setBounds(40, 330, 120, 30);
            feeilblSGC.setFont(new Font("Cooper Black",0,20));

            nameifldSGC.setBounds(230, 80, 220, 30);
            nameifldSGC.setFont(new Font("Goudy Old Style",0,20));

            idifldSGC.setBounds(230, 130, 220, 30);
            idifldSGC.setFont(new Font("Goudy Old Style",0,20));

            phoneifldSGC.setBounds(230, 180, 220, 30);
            phoneifldSGC.setFont(new Font("Goudy Old Style",0,20));

            cnicifldSGC.setBounds(230, 230, 220, 30);
            cnicifldSGC.setFont(new Font("Goudy Old Style",0,20));

            dateofjoinifldSGC.setBounds(230, 280, 220, 30);
            dateofjoinifldSGC.setFont(new Font("Goudy Old Style",0,20));

            feeifldSGC.setBounds(230, 330, 220, 30);
            feeifldSGC.setFont(new Font("Goudy Old Style",0,20));

            nameifldSGC.setVisible(false);
            idifldSGC.setVisible(false);
            phoneifldSGC.setVisible(false);
            cnicifldSGC.setVisible(false);
            dateofjoinifldSGC.setVisible(false);
            feeifldSGC.setVisible(false);

            nameilblSGC.setVisible(false);
            idilblSGC.setVisible(false);
            cnicilblSGC.setVisible(false);
            phoneilblSGC.setVisible(false);
            dateofjoinilblSGC.setVisible(false);
            feeilblSGC.setVisible(false);

            backbtnSGC.setVisible(false);
            imagelblSGC.setVisible(false);

            searchtable.getColumnModel().getColumn(0).setPreferredWidth(90);
            searchtable.getColumnModel().getColumn(1).setPreferredWidth(170);
            searchtable.getColumnModel().getColumn(2).setPreferredWidth(210);
            searchtable.getColumnModel().getColumn(3).setPreferredWidth(170);
            searchtable.getColumnModel().getColumn(4).setPreferredWidth(100);
            searchtable.getColumnModel().getColumn(5).setPreferredWidth(180);
            searchtable.getColumnModel().getColumn(6).setPreferredWidth(105);

            this.searchtable.setBounds(0, 10, 800, 290);
            searchtable.setOpaque(false);
            searchtable.setRowHeight(28);
            header1=this.searchtable.getTableHeader();
            header1.setFont(new Font("Times New Roman",1,20));
            header1.setForeground(Color.WHITE);
            header1.setBackground(new Color(20, 20, 20));
            header1.setBorder(BorderFactory.createLineBorder(new Color(235,207,47), 2));

            searchtable.setFont(new Font("Goudy Old Style",0,20));
            searchtable.setOpaque(false);
            searchtable.setVisible(true);
            tablepaneSGC.getViewport().setBackground(new Color(20,20,20));
            tablepaneSGC.setBorder(BorderFactory.createLineBorder(Color.darkGray, 1));
            tablepaneSGC.getHorizontalScrollBar().setBackground(new Color(20,20,20));
            tablepaneSGC.getVerticalScrollBar().setBackground(new Color(20,20,20));
            tablepaneSGC.getViewport().setOpaque(true);
            tablecontainerSGC.setBounds(50, 120, 800, 290);
            tablecontainerSGC.setBorder(BorderFactory.createLineBorder(new Color(235,207,47), 1));
            tablecontainerSGC.setBackground(new Color(20,20,20));
            tablecontainerSGC.setOpaque(false);
            tablecontainerSGC.setVisible(true);


            searchlblSGC.setBounds(50, 50, 150, 35);
            searchlblSGC.setFont(new Font("Cooper Black",0,20));

            searchoptionsSGC.setBounds(250, 50, 200, 35);
            searchoptionsSGC.setFont(new Font("Times New Roman",1,20));

            searchlblSGC.setText("Search :");
            searchoptionsSGC.setSelectedIndex(0);

            idfldSGC.setBounds(250, 50, 200, 35);
            namefldSGC.setBounds(250, 50, 200, 35);
            cnicfldSGC.setBounds(250, 50, 200, 35);
            nameofAdminfldSGC.setBounds(250, 50, 200, 35);

            idfldSGC.setFont(new Font("Goudy Old Style",0,20));
            namefldSGC.setFont(new Font("Goudy Old Style",0,20));
            cnicfldSGC.setFont(new Font("Goudy Old Style",0,20));
            nameofAdminfldSGC.setFont(new Font("Goudy Old Style",1,20));


            phonefldSGC.setBounds(250, 50, 200, 35);
            phonefldSGC.setFont(new Font("Goudy Old Style",0,20));



            searchSGC.setBounds(560, 50, 120, 30);
            searchSGC.setFont(new Font("Cooper Black",0,20));

            clearSGC.setBounds(700, 50, 120, 30);
            clearSGC.setFont(new Font("Cooper Black",0,20));

            searchlblSGC.setVisible(true);
            searchoptionsSGC.setVisible(true);
            searchSGC.setVisible(true);
            clearSGC.setVisible(true);

            namefldSGC.setText(null);
            idfldSGC.setText(null);
            cnicfldSGC.setText(null);
            phonefldSGC.setText(null);
            nameofAdminfldSGC.setText(null);

            namefldSGC.setVisible(false);
            idfldSGC.setVisible(false);
            cnicfldSGC.setVisible(false);
            phonefldSGC.setVisible(false);

            datechooserSGC.setBounds(250, 50, 200, 35);
            datechooserSGC.setFont(new Font("Goudy Old Style",0,14));
            fielddateSGC.setFont(new Font("Goudy Old Style",0,20));
            calenbtnSGC.setIcon(new ImageIcon(new ImageIcon(getClass().getResource("icons/calen.png")).getImage().getScaledInstance(20, 20, 4)));
            datechooserSGC.setVisible(false);

            searchgymclientlbl3=new GiveGradientLabel(new Font("Gabriola",0,28),"Search  Gym  Member",10,25);
            searchgymclientlbl3.setVisible(true);
            toplabelcoverSGC.setBounds(520, 170, 220, 30);
            searchgymclientlbl3.setBounds(0, 0, 220, 30);
            toplabelcoverSGC.add(searchgymclientlbl3);
            toplabelcoverSGC.setBackground(new Color(20,20,20));
            toplabelcoverSGC.setOpaque(true);

            searchgymmem.setBounds(210, 200, 900, 450);
            searchgymmem.setBorder(BorderFactory.createCompoundBorder(a1, a2));
            searchgymmem.setLayout(null);
            searchgymmem.setOpaque(false);
            searchgymmem.setVisible(false);
        }

        //............Search Gym Client .......................................

        
        //............Remove Gym Client .......................................


        if(Screensize.getWidth()==1920){

            removetable.getColumnModel().getColumn(0).setPreferredWidth(130);
            removetable.getColumnModel().getColumn(1).setPreferredWidth(200);
            removetable.getColumnModel().getColumn(2).setPreferredWidth(250);
            removetable.getColumnModel().getColumn(3).setPreferredWidth(200);
            removetable.getColumnModel().getColumn(4).setPreferredWidth(100);
            removetable.getColumnModel().getColumn(5).setPreferredWidth(200);
            removetable.getColumnModel().getColumn(6).setPreferredWidth(105);

            this.removetable.setBounds(0, 10, 1190, 290);
            removetable.setOpaque(false);
            removetable.setRowHeight(28);
            header1=this.removetable.getTableHeader();
            header1.setFont(new Font("Times New Roman",1,24));
            header1.setForeground(Color.WHITE);
            header1.setBackground(new Color(20, 20, 20));
            header1.setBorder(BorderFactory.createLineBorder(new Color(235,207,47), 2));

            removetable.setFont(new Font("Goudy Old Style",0,24));
            removetable.setOpaque(false);
            removetable.setVisible(true);
            tablepane.getViewport().setBackground(new Color(20,20,20));
            tablepane.setBorder(BorderFactory.createLineBorder(Color.darkGray, 1));
            tablepane.getHorizontalScrollBar().setBackground(new Color(20,20,20));
            tablepane.getVerticalScrollBar().setBackground(new Color(20,20,20));
            tablepane.getViewport().setOpaque(true);
            tablecontainerRGC.setBounds(50, 250, 1190, 300);
            tablecontainerRGC.setBorder(BorderFactory.createLineBorder(new Color(235,207,47), 1));
            tablecontainerRGC.setBackground(new Color(20,20,20));
            tablecontainerRGC.setOpaque(false);
            tablecontainerRGC.setVisible(true);


            searchRGC.setFont(new Font("Cooper Black",0,22));
            searchRGC.setBounds(900, 160, 150, 40);

            clearRGC.setFont(new Font("Cooper Black",0,22));
            clearRGC.setBounds(1080, 160, 150, 40);

            removememRGC.setFont(new Font("Cooper Black",0,22));
            removememRGC.setBounds(550, 590, 150, 40);

            nameofmemlblRGC.setFont(new Font("Cooper Black",0,24));
            nameofmemlblRGC.setBounds(100, 80, 150, 50);

            idofmemlblRGC.setFont(new Font("Cooper Black",0,24));
            idofmemlblRGC.setBounds(550, 80, 150, 50);

            namememRGC.setFont(new Font("Goudy Old Style",0,24));
            idmemRGC.setFont(new Font("Goudy Old Style",0,24));

            namememRGC.setBounds(250, 80, 250, 50);
            idmemRGC.setBounds(650, 80, 250, 50);

            removegymclientlbl=new GiveGradientLabel(new Font("Gabriola",0,42),"Remove  Gym  Member",10,35);
            removegymclientlbl.setVisible(true);
            toplabelcoverRGC.setBounds(800, 250, 320, 50);
            removegymclientlbl.setBounds(0, 0, 320, 50);
            toplabelcoverRGC.add(removegymclientlbl);
            toplabelcoverRGC.setBackground(new Color(20,20,20));
            toplabelcoverRGC.setOpaque(true);

            removegymmem.setBounds(320, 300, 1290, 680);
            removegymmem.setBorder(BorderFactory.createCompoundBorder(a1, a2));
            removegymmem.setLayout(null);
            removegymmem.setOpaque(false);
            removegymmem.setVisible(false);
        }
        else if(Screensize.getWidth()>=1536&&Screensize.getWidth()<1920){

            removetable.getColumnModel().getColumn(0).setPreferredWidth(90);
            removetable.getColumnModel().getColumn(1).setPreferredWidth(170);
            removetable.getColumnModel().getColumn(2).setPreferredWidth(210);
            removetable.getColumnModel().getColumn(3).setPreferredWidth(170);
            removetable.getColumnModel().getColumn(4).setPreferredWidth(100);
            removetable.getColumnModel().getColumn(5).setPreferredWidth(180);
            removetable.getColumnModel().getColumn(6).setPreferredWidth(105);

            this.removetable.setBounds(0, 10, 1030, 290);
            removetable.setOpaque(false);
            removetable.setRowHeight(26);
            header1=this.removetable.getTableHeader();
            header1.setFont(new Font("Times New Roman",1,22));
            header1.setForeground(Color.WHITE);
            header1.setBackground(new Color(20, 20, 20));
            header1.setBorder(BorderFactory.createLineBorder(new Color(235,207,47), 2));

            removetable.setFont(new Font("Goudy Old Style",0,20));
            removetable.setOpaque(false);
            removetable.setVisible(true);
            tablepane.getViewport().setBackground(new Color(20,20,20));
            tablepane.setBorder(BorderFactory.createLineBorder(Color.darkGray, 1));
            tablepane.getVerticalScrollBar().setBackground(new Color(20,20,20));
            tablepane.getHorizontalScrollBar().setBackground(new Color(20,20,20));
            tablepane.getViewport().setOpaque(true);
            tablecontainerRGC.setBounds(50, 200, 1030, 250);
            tablecontainerRGC.setBorder(BorderFactory.createLineBorder(new Color(235,207,47), 1));
            tablecontainerRGC.setBackground(new Color(20,20,20));
            tablecontainerRGC.setOpaque(false);
            tablecontainerRGC.setVisible(true);


            searchRGC.setFont(new Font("Cooper Black",0,20));
            searchRGC.setBounds(800, 120, 120, 30);

            clearRGC.setFont(new Font("Cooper Black",0,20));
            clearRGC.setBounds(940, 120, 120, 30);

            removememRGC.setFont(new Font("Cooper Black",0,22));
            removememRGC.setBounds(500, 470, 150, 30);

            nameofmemlblRGC.setFont(new Font("Cooper Black",0,22));
            nameofmemlblRGC.setBounds(50, 50, 150, 40);

            idofmemlblRGC.setFont(new Font("Cooper Black",0,22));
            idofmemlblRGC.setBounds(550, 50, 150, 40);

            namememRGC.setFont(new Font("Goudy Old Style",0,22));
            idmemRGC.setFont(new Font("Goudy Old Style",0,22));

            namememRGC.setBounds(250, 50, 250, 40);
            idmemRGC.setBounds(650, 50, 250, 40);

            removegymclientlbl2=new GiveGradientLabel(new Font("Gabriola",0,36),"Remove  Gym  Member",10,30);
            removegymclientlbl2.setVisible(true);
            toplabelcoverRGC.setBounds(635, 200, 270, 40);
            removegymclientlbl2.setBounds(0, 0, 270, 40);
            toplabelcoverRGC.add(removegymclientlbl2);
            toplabelcoverRGC.setBackground(new Color(20,20,20));
            toplabelcoverRGC.setOpaque(true);

            removegymmem.setBounds(200, 240, 1120, 550);
            removegymmem.setBorder(BorderFactory.createCompoundBorder(a1, a2));
            removegymmem.setLayout(null);
            removegymmem.setOpaque(false);
            removegymmem.setVisible(false);
        }
        else
        {

            removetable.getColumnModel().getColumn(0).setPreferredWidth(90);
            removetable.getColumnModel().getColumn(1).setPreferredWidth(170);
            removetable.getColumnModel().getColumn(2).setPreferredWidth(210);
            removetable.getColumnModel().getColumn(3).setPreferredWidth(170);
            removetable.getColumnModel().getColumn(4).setPreferredWidth(100);
            removetable.getColumnModel().getColumn(5).setPreferredWidth(180);
            removetable.getColumnModel().getColumn(6).setPreferredWidth(105);

            this.removetable.setBounds(0, 10, 800, 150);
            removetable.setOpaque(false);
            removetable.setRowHeight(25);
            header1=this.removetable.getTableHeader();
            header1.setFont(new Font("Times New Roman",1,18));
            header1.setForeground(Color.WHITE);
            header1.setBackground(new Color(20, 20, 20));
            header1.setBorder(BorderFactory.createLineBorder(new Color(235,207,47), 2));

            removetable.setFont(new Font("Goudy Old Style",0,18));
            removetable.setOpaque(false);
            removetable.setVisible(true);
            tablepane.getViewport().setBackground(new Color(20,20,20));
            tablepane.setBorder(BorderFactory.createLineBorder(Color.darkGray, 1));
            tablepane.getViewport().setOpaque(true);
            tablepane.getVerticalScrollBar().setBackground(new Color(20,20,20));
            tablepane.getHorizontalScrollBar().setBackground(new Color(20,20,20));
            // tablepane.getHorizontalScrollBar()
            tablecontainerRGC.setBounds(50, 120, 800, 250);
            tablecontainerRGC.setBorder(BorderFactory.createLineBorder(new Color(235,207,47), 1));
            tablecontainerRGC.setBackground(new Color(20,20,20));
            tablecontainerRGC.setOpaque(false);
            tablecontainerRGC.setVisible(true);


            searchRGC.setFont(new Font("Cooper Black",0,18));
            searchRGC.setBounds(600, 80, 100, 25);

            clearRGC.setFont(new Font("Cooper Black",0,18));
            clearRGC.setBounds(720, 80, 100, 25);

            removememRGC.setFont(new Font("Cooper Black",0,18));
            removememRGC.setBounds(400, 390, 120, 25);

            nameofmemlblRGC.setFont(new Font("Cooper Black",0,20));
            nameofmemlblRGC.setBounds(50, 40, 150, 30);

            idofmemlblRGC.setFont(new Font("Cooper Black",0,20));
            idofmemlblRGC.setBounds(400, 40, 150, 30);

            namememRGC.setFont(new Font("Goudy Old Style",0,20));
            idmemRGC.setFont(new Font("Goudy Old Style",0,20));

            namememRGC.setBounds(150, 40, 200, 30);
            idmemRGC.setBounds(450, 40, 200, 30);

            removegymclientlbl3=new GiveGradientLabel(new Font("Gabriola",0,28),"Remove  Gym  Member",10,25);
            removegymclientlbl3.setVisible(true);
            toplabelcoverRGC.setBounds(520, 170, 220, 30);
            removegymclientlbl3.setBounds(0, 0, 220, 30);
            toplabelcoverRGC.add(removegymclientlbl3);
            toplabelcoverRGC.setBackground(new Color(20,20,20));
            toplabelcoverRGC.setOpaque(true);

            removegymmem.setBounds(210, 200, 900, 450);
            removegymmem.setBorder(BorderFactory.createCompoundBorder(a1, a2));
            removegymmem.setLayout(null);
            removegymmem.setOpaque(false);
            removegymmem.setVisible(false);
        }
       
        //............Remove Gym Client .......................................
       

        //............Add Gym Client ..........................................

        if(Screensize.getWidth()==1920)
        {
            imagelabelAGC.setBounds(840, 50, 350, 350);
            imagelabelAGC.setIcon(new ImageIcon(new ImageIcon(getClass().getResource("icons/deafultpic3.png")).getImage().getScaledInstance(350, 350, Image.SCALE_SMOOTH)));
            
            addimagebtnAGC.setBounds(960, 410, 130, 30);
            addimagebtnAGC.setFont(new Font("Cooper Black",0,14));

            confirmallfielsAGC.setFont(new Font("Cooper Black",0,20));
            confirmallfielsAGC.setBounds(200, 550, 350, 50);
            confirmallfielsAGC.setOpaque(false);

            addmemAGC.setFont(new Font("Cooper Black",0,18));
            clearAGC.setFont(new Font("Cooper Black",0,18));
            cancelAGC.setFont(new Font("Cooper Black",0,18));

            addmemAGC.setBounds(650, 600, 170, 35);
            clearAGC.setBounds(900, 600, 120, 35);
            cancelAGC.setBounds(1100, 600, 120, 35);

            nameofmem.setBounds(100, 50, 250, 50);
            nameofmem.setText("Name of Member :");
            nameofmem.setFont(new Font("Cooper Black",0,24));
            nameofmem.setForeground(Color.WHITE);
            nameofmem.setOpaque(false);
            nameofmem.setVisible(true);
            
            idofmem.setBounds(100, 130, 250, 50);
            idofmem.setText("ID of Member :");
            idofmem.setFont(new Font("Cooper Black",0,24));
            idofmem.setForeground(Color.WHITE);
            idofmem.setOpaque(false);
            idofmem.setVisible(true);
            
            cnicmem.setBounds(100,300,250,50);
            cnicmem.setText("CNIC of Member :");
            cnicmem.setFont(new Font("Cooper Black",0,24));
            cnicmem.setForeground(Color.WHITE);
            cnicmem.setOpaque(false);
            cnicmem.setVisible(true);



            phonemem.setBounds(100, 210, 250, 50);
            phonemem.setText("Phone Number :");
            phonemem.setFont(new Font("Cooper Black",0,24));
            phonemem.setForeground(Color.WHITE);
            phonemem.setOpaque(false);
            phonemem.setVisible(true);
            
            feememlblACG.setBounds(100, 470, 250, 50);
            feememlblACG.setText("Fee :");
            feememlblACG.setFont(new Font("Cooper Black",0,24));
            feememlblACG.setForeground(Color.WHITE);
            feememlblACG.setOpaque(false);
            feememlblACG.setVisible(true);
    
            Dateofjoinmem.setBounds(100, 380, 250, 50);
            Dateofjoinmem.setText("Date of Join :");
            Dateofjoinmem.setFont(new Font("Cooper Black",0,24));
            Dateofjoinmem.setForeground(Color.WHITE);
            Dateofjoinmem.setOpaque(false);
            Dateofjoinmem.setVisible(true);
            

            namememAGC.setFont(new Font("Goudy Old Style",0,26));
            namememAGC.setForeground(new Color(255,255,255));
            namememAGC.setOpaque(false);
            namememAGC.setBounds(350, 50, 250, 50);

            idAGC.setFont(new Font("Goudy Old Style",0,26));
            idAGC.setForeground(new Color(255,255,255));
            idAGC.setOpaque(false);
            idAGC.setBounds(350, 130, 250, 50);

            phoneAGC.setFont(new Font("Goudy Old Style",0,26));
            phoneAGC.setForeground(new Color(255,255,255));
            phoneAGC.setOpaque(false);
            phoneAGC.setBounds(350, 210, 250, 50);
            expphone.setFont(new Font("Gabriola",0,20));
            expphone.setBounds(500, 265, 150, 30);


            
            cnicAGC.setFont(new Font("Goudy Old Style",0,26));
            cnicAGC.setForeground(new Color(255,255,255));
            cnicAGC.setOpaque(false);
            cnicAGC.setBounds(350, 300, 250, 50);
            expcnic.setFont(new Font("Gabriola",0,20));
            expcnic.setBounds(500, 355, 150, 30);


            feeoptions.setFont(new Font("Goudy Old Style",0,26));
            feeoptions.setForeground(new Color(255,255,255));
            feeoptions.setBackground(new Color(20,20,20));
            feeoptions.setBounds(350, 470, 250, 50);


            feeAGC.setFont(new Font("Goudy Old Style",0,26));
            feeAGC.setForeground(new Color(255,255,255));
            feeAGC.setOpaque(false);
            feeAGC.setBounds(350, 470, 250, 50);
            feeAGC.setVisible(false);


            lbldate.setFont(new Font("Gabriola",0,20));
            lbldate.setBounds(475, 440, 150, 30);
            lbldate.setOpaque(false);

            datechooserAG.setBounds(350, 380, 280, 50);
            datechooserAG.setFont(new Font("Goudy Old Style",0,18));
            fielddate.setFont(new Font("Goudy Old Style",0,24));
            calenbtn.setIcon(new ImageIcon(new ImageIcon(getClass().getResource("icons/calen.png")).getImage().getScaledInstance(30, 30, 4)));


            addgymmem1=new GiveGradientLabel(new Font("Gabriola",0,42),"Add  Gym  Member",10,35);
            addgymmem1.setVisible(true);
            toplabelcover1.setBounds(820, 250, 270, 50);
            addgymmem1.setBounds(0, 0, 270, 50);
            toplabelcover1.add(addgymmem1);
            toplabelcover1.setBackground(new Color(20,20,20));
            toplabelcover1.setOpaque(true);


            addgymmem.setBounds(320, 300, 1290, 680);
            addgymmem.setBorder(BorderFactory.createCompoundBorder(a1, a2));
            addgymmem.setLayout(null);
            addgymmem.setOpaque(false);
            addgymmem.setVisible(false);


            
        }
        else if(Screensize.getWidth()>=1536&&Screensize.getWidth()<1920)
        {
            imagelabelAGC.setBounds(740, 50, 300, 300);
            imagelabelAGC.setIcon(new ImageIcon(new ImageIcon(getClass().getResource("icons/deafultpic3.png")).getImage().getScaledInstance(300, 300, Image.SCALE_SMOOTH)));
            
            addimagebtnAGC.setBounds(850, 360, 100, 25);
            addimagebtnAGC.setFont(new Font("Cooper Black",0,12));

            confirmallfielsAGC.setFont(new Font("Cooper Black",0,16));
            confirmallfielsAGC.setBounds(150, 460, 250, 30);
            confirmallfielsAGC.setOpaque(false);


            addmemAGC.setFont(new Font("Cooper Black",0,16));
            clearAGC.setFont(new Font("Cooper Black",0,16));
            cancelAGC.setFont(new Font("Cooper Black",0,16));

            addmemAGC.setBounds(680, 480, 140, 30);
            clearAGC.setBounds(840, 480, 100, 30);
            cancelAGC.setBounds(960, 480, 100, 30);

            nameofmem.setBounds(60, 40, 250, 40);
            nameofmem.setText("Name of Member :");
            nameofmem.setFont(new Font("Cooper Black",0,22));
            nameofmem.setForeground(Color.WHITE);
            nameofmem.setOpaque(false);
            nameofmem.setVisible(true);

            
            namememAGC.setFont(new Font("Goudy Old Style",0,22));
            namememAGC.setForeground(new Color(255,255,255));
            namememAGC.setOpaque(false);
            namememAGC.setBounds(310, 40, 250, 40);
            
            idofmem.setBounds(60, 110, 250, 40);
            idofmem.setText("ID of Member :");
            idofmem.setFont(new Font("Cooper Black",0,22));
            idofmem.setForeground(Color.WHITE);
            idofmem.setOpaque(false);
            idofmem.setVisible(true);
            
            cnicmem.setBounds(60,260,250,40);
            cnicmem.setText("CNIC of Member :");
            cnicmem.setFont(new Font("Cooper Black",0,22));
            cnicmem.setForeground(Color.WHITE);
            cnicmem.setOpaque(false);
            cnicmem.setVisible(true);



            phonemem.setBounds(60, 180, 250, 40);
            phonemem.setText("Phone Number :");
            phonemem.setFont(new Font("Cooper Black",0,22));
            phonemem.setForeground(Color.WHITE);
            phonemem.setOpaque(false);
            phonemem.setVisible(true);
            
            feememlblACG.setBounds(60, 400, 250, 40);
            feememlblACG.setText("Fee :");
            feememlblACG.setFont(new Font("Cooper Black",0,22));
            feememlblACG.setForeground(Color.WHITE);
            feememlblACG.setOpaque(false);
            feememlblACG.setVisible(true);
    
            Dateofjoinmem.setBounds(60, 330, 250, 40);
            Dateofjoinmem.setText("Date of Join :");
            Dateofjoinmem.setFont(new Font("Cooper Black",0,22));
            Dateofjoinmem.setForeground(Color.WHITE);
            Dateofjoinmem.setOpaque(false);
            Dateofjoinmem.setVisible(true);
            



            idAGC.setFont(new Font("Goudy Old Style",0,22));
            idAGC.setForeground(new Color(255,255,255));
            idAGC.setOpaque(false);
            idAGC.setBounds(310, 110, 250, 40);

            phoneAGC.setFont(new Font("Goudy Old Style",0,22));
            phoneAGC.setForeground(new Color(255,255,255));
            phoneAGC.setOpaque(false);
            phoneAGC.setBounds(310, 180, 250, 40);
            expphone.setFont(new Font("Gabriola",0,18));
            expphone.setBounds(460, 225, 150, 30);


            
            cnicAGC.setFont(new Font("Goudy Old Style",0,22));
            cnicAGC.setForeground(new Color(255,255,255));
            cnicAGC.setOpaque(false);
            cnicAGC.setBounds(310, 260, 250, 40);
            expcnic.setFont(new Font("Gabriola",0,18));
            expcnic.setBounds(460, 305, 150, 30);


            feeoptions.setFont(new Font("Goudy Old Style",0,22));
            feeoptions.setForeground(new Color(255,255,255));
            feeoptions.setBackground(new Color(20,20,20));
            feeoptions.setBounds(310, 400, 250, 40);


            feeAGC.setFont(new Font("Goudy Old Style",0,22));
            feeAGC.setForeground(new Color(255,255,255));
            feeAGC.setOpaque(false);
            feeAGC.setBounds(310, 400, 250, 40);
            feeAGC.setVisible(false);


            lbldate.setFont(new Font("Gabriola",0,18));
            lbldate.setBounds(435, 375, 150, 30);
            lbldate.setOpaque(false);

            datechooserAG.setBounds(310, 330, 250, 40);
            datechooserAG.setFont(new Font("Goudy Old Style",0,16));
            fielddate.setFont(new Font("Goudy Old Style",0,24));
            calenbtn.setIcon(new ImageIcon(new ImageIcon(getClass().getResource("icons/calen.png")).getImage().getScaledInstance(30, 30, 4)));


            addgymmem2=new GiveGradientLabel(new Font("Gabriola",0,36),"Add  Gym  Member",10,30);
            addgymmem2.setVisible(true);
            toplabelcover1.setBounds(650, 200, 240, 40);
            addgymmem2.setBounds(0, 0, 240, 40);
            toplabelcover1.add(addgymmem2);
            toplabelcover1.setBackground(new Color(20,20,20));
            toplabelcover1.setOpaque(true);



            addgymmem.setBounds(200, 240, 1120, 550);
            addgymmem.setBorder(BorderFactory.createCompoundBorder(a1, a2));
            addgymmem.setLayout(null);
            addgymmem.setOpaque(false);
            addgymmem.setVisible(false);
        }
        else{
            imagelabelAGC.setBounds(600, 40, 250, 250);
            imagelabelAGC.setIcon(new ImageIcon(new ImageIcon(getClass().getResource("icons/deafultpic3.png")).getImage().getScaledInstance(250, 250, Image.SCALE_SMOOTH)));
            
            addimagebtnAGC.setBounds(700, 300, 90, 20);
            addimagebtnAGC.setFont(new Font("Cooper Black",0,10));

            confirmallfielsAGC.setFont(new Font("Cooper Black",0,14));
            confirmallfielsAGC.setBounds(100, 390, 200, 30);
            confirmallfielsAGC.setOpaque(false);

            addmemAGC.setFont(new Font("Cooper Black",0,16));
            clearAGC.setFont(new Font("Cooper Black",0,16));
            cancelAGC.setFont(new Font("Cooper Black",0,16));

            addmemAGC.setBounds(450, 400, 140, 25);
            clearAGC.setBounds(610, 400, 100, 25);
            cancelAGC.setBounds(730, 400, 100, 25);



            nameofmem.setBounds(40, 40, 170, 30);
            nameofmem.setText("Name of Member :");
            nameofmem.setFont(new Font("Cooper Black",0,18));
            nameofmem.setForeground(Color.WHITE);
            nameofmem.setOpaque(false);
            nameofmem.setVisible(true);
            
            idofmem.setBounds(40, 100, 170, 30);
            idofmem.setText("ID of Member :");
            idofmem.setFont(new Font("Cooper Black",0,18));
            idofmem.setForeground(Color.WHITE);
            idofmem.setOpaque(false);
            idofmem.setVisible(true);
            
            cnicmem.setBounds(40,220,170,30);
            cnicmem.setText("CNIC of Member :");
            cnicmem.setFont(new Font("Cooper Black",0,18));
            cnicmem.setForeground(Color.WHITE);
            cnicmem.setOpaque(false);
            cnicmem.setVisible(true);



            phonemem.setBounds(40, 160, 170, 30);
            phonemem.setText("Phone Number :");
            phonemem.setFont(new Font("Cooper Black",0,18));
            phonemem.setForeground(Color.WHITE);
            phonemem.setOpaque(false);
            phonemem.setVisible(true);
            
            feememlblACG.setBounds(40, 340, 170, 30);
            feememlblACG.setText("Fee :");
            feememlblACG.setFont(new Font("Cooper Black",0,18));
            feememlblACG.setForeground(Color.WHITE);
            feememlblACG.setOpaque(false);
            feememlblACG.setVisible(true);
    
            Dateofjoinmem.setBounds(40, 280, 170, 40);
            Dateofjoinmem.setText("Date of Join :");
            Dateofjoinmem.setFont(new Font("Cooper Black",0,18));
            Dateofjoinmem.setForeground(Color.WHITE);
            Dateofjoinmem.setOpaque(false);
            Dateofjoinmem.setVisible(true);
            


            namememAGC.setFont(new Font("Goudy Old Style",0,20));
            namememAGC.setForeground(new Color(255,255,255));
            namememAGC.setOpaque(false);
            namememAGC.setBounds(230, 40, 170, 30);

            idAGC.setFont(new Font("Goudy Old Style",0,20));
            idAGC.setForeground(new Color(255,255,255));
            idAGC.setOpaque(false);
            idAGC.setBounds(230, 100, 170, 30);

            phoneAGC.setFont(new Font("Goudy Old Style",0,20));
            phoneAGC.setForeground(new Color(255,255,255));
            phoneAGC.setOpaque(false);
            phoneAGC.setBounds(230, 160, 170, 30);
            expphone.setFont(new Font("Gabriola",0,14));
            expphone.setBounds(300, 200, 150, 20);



            
            cnicAGC.setFont(new Font("Goudy Old Style",0,20));
            cnicAGC.setForeground(new Color(255,255,255));
            cnicAGC.setOpaque(false);
            cnicAGC.setBounds(230, 220, 170, 30);
            expcnic.setFont(new Font("Gabriola",0,14));
            expcnic.setBounds(310, 260, 150, 20);


            feeoptions.setFont(new Font("Goudy Old Style",0,20));
            feeoptions.setForeground(new Color(255,255,255));
            feeoptions.setBackground(new Color(20,20,20));
            feeoptions.setBounds(230, 340, 170, 30);


            feeAGC.setFont(new Font("Goudy Old Style",0,20));
            feeAGC.setForeground(new Color(255,255,255));
            feeAGC.setOpaque(false);
            feeAGC.setBounds(230, 340, 170, 30);
            feeAGC.setVisible(false);


            lbldate.setFont(new Font("Gabriola",0,14));
            lbldate.setBounds(320, 315, 150, 20);
            lbldate.setOpaque(false);

            datechooserAG.setBounds(230, 280, 170, 30);
            datechooserAG.setFont(new Font("Goudy Old Style",0,14));
            fielddate.setFont(new Font("Goudy Old Style",0,20));
            calenbtn.setIcon(new ImageIcon(new ImageIcon(getClass().getResource("icons/calen.png")).getImage().getScaledInstance(20, 20, 4)));

            addgymmem3=new GiveGradientLabel(new Font("Gabriola",0,28),"Add  Gym  Member",10,25);
            addgymmem3.setVisible(true);

            toplabelcover1.setBounds(530, 170, 200, 30);
            addgymmem3.setBounds(0, 0, 200, 30);
            toplabelcover1.add(addgymmem3);
            toplabelcover1.setBackground(new Color(20,20,20));
            toplabelcover1.setOpaque(true);



            addgymmem.setBounds(210, 200, 900, 450);
            addgymmem.setBorder(BorderFactory.createCompoundBorder(a1, a2));
            addgymmem.setLayout(null);
            addgymmem.setOpaque(false);
            addgymmem.setVisible(false);
        }


        //............Add Gym Client ..........................................


        //............VideoPanel.......................................

        if(Screensize.getWidth()==1920)
        {
            videopanel.setBounds(320, 270, 1290, 740);
            videopanel.setLayout(null);
            videopanel2.setVisible(false);
            videopanel3.setVisible(false);


            jfxvideopanel.setBounds(5, 5, 1280, 727);
            jfxvideopanel.setBackground(Color.white);
            jfxvideopanel.setOpaque(true);
            jfxvideopanel.setVisible(true);


            videopanel.add(jfxvideopanel);
            videopanel.setBackground(new Color(20,20,20));
            videopanel.setOpaque(true);
            videopanel.setVisible(false);


         

        }
        else if(Screensize.getWidth()>=1536&&Screensize.getWidth()<1920)
        {
            videopanel2.setBounds(320, 210, 880, 610);
            videopanel2.setLayout(null);
            videopanel.setVisible(false);
            videopanel3.setVisible(false);

            jfxvideopanel1536.setBounds(10, 10, 860, 590);
            jfxvideopanel1536.setBackground(Color.white);
            jfxvideopanel1536.setOpaque(true);
            jfxvideopanel1536.setVisible(true);


            videopanel2.add(jfxvideopanel1536);
            videopanel2.setBackground(new Color(20,20,20));
            videopanel2.setOpaque(true);
            videopanel2.setVisible(false);
        }
        else
        {
            videopanel3.setBounds(210, 160, 825, 520);
            videopanel3.setLayout(null);
            videopanel.setVisible(false);
            videopanel2.setVisible(false);

            jfxvideopanel1280.setBounds(5, 5, 816, 510);
            jfxvideopanel1280.setBackground(Color.white);
            jfxvideopanel1280.setOpaque(true);
            jfxvideopanel1280.setVisible(true);


            videopanel3.add(jfxvideopanel1280);
            videopanel3.setBackground(new Color(20,20,20));
            videopanel3.setOpaque(true);
            videopanel3.setVisible(false);
        }

        //............VideoPanel.......................................


        //............MusicPanel.......................................

        if(Screensize.getWidth()==1920)
        {
            musix.setBounds(400, 300, 1210, 360);
            musix.setLayout(null);
            
            musicpanel.setBounds(5, 5, 1200, 350);
            musicpanel.setBackground(Color.white);
            musicpanel.setOpaque(true);
            musicpanel.setVisible(true);

            musix2.setVisible(false);           
            musix3.setVisible(false);           

           

            musix.add(musicpanel);
            musix.setBackground(new Color(20,20,20));
            musix.setOpaque(true);
            musix.setVisible(false);

        }
        else if(Screensize.getWidth()>=1536&&Screensize.getWidth()<1920)
        {
            musix2.setBounds(290, 240, 1010, 310);
            musix2.setLayout(null);
            
            musix.setVisible(false);           
            musix3.setVisible(false);           

            musicpanel2.setBounds(5, 5, 1000, 300);
            musicpanel2.setBackground(Color.white);           
            musicpanel2.setOpaque(true);
            musicpanel2.setVisible(true);



            // musix.add(musicpanel);
            musix2.add(musicpanel2);
            musix2.setBackground(new Color(20,20,20));
            musix2.setOpaque(true);
            musix2.setVisible(true);


        }
        else
        {
            musix3.setBounds(210, 200, 860, 310);
            musix3.setLayout(null);
            
            musix.setVisible(false);           
            musix2.setVisible(false);           

            musicpanel3.setBounds(5, 5, 850, 300);
            musicpanel3.setBackground(Color.white);           
            musicpanel3.setOpaque(true);
            musicpanel3.setVisible(true);



            // musix.add(musicpanel);
            musix3.add(musicpanel3);
            musix3.setBackground(new Color(20,20,20));
            musix3.setOpaque(true);
            musix3.setVisible(true);
        }


        //............MusicPanel.......................................


        //............Main Menu Panel.................................


        if(Screensize.getWidth()==1920)
        {
            menupanel.setBounds(200, 300, 1500, 700);
            p1.setBounds(880, 250, 150, 50);
            p1.setBackground(new Color(20,20,20));
            p1.setLayout(null);


            homelblmenupanel.setBounds(0, 0, 150, 50);

            homelblmenupanel2.setVisible(false);
            homelblmenupanel3.setVisible(false);
            homelblmenupanel.setVisible(true);

            p1.setVisible(true);
            p2.setVisible(false);
            p3.setVisible(false);


            addmem.setBounds(200, 50, 200, 200);
            addmem.setIcon(new ImageIcon(new ImageIcon(getClass().getResource("icons/addmem.png")).getImage().getScaledInstance(120, 120, Image.SCALE_SMOOTH)));
            addmem.setBackground(new Color(20,20,20));
            addmem.setForeground(Color.white);
            addmem.setText("New Member");
            addmem.setFont(new Font("Cooper Black",0,24));
            addmem.setHorizontalAlignment(0);
            addmem.setVerticalAlignment(0);
            addmem.setHorizontalTextPosition(0);
            addmem.setVerticalTextPosition(JButton.BOTTOM);
            addmem.setBorder(BorderFactory.createEmptyBorder());
            addmem.setFocusable(false);
            addmem.setOpaque(false);


            removemem.setBounds(500, 50, 200, 200);
            removemem.setIcon(new ImageIcon(new ImageIcon(getClass().getResource("icons/removemem.png")).getImage().getScaledInstance(120, 120, Image.SCALE_SMOOTH)));
            removemem.setBackground(new Color(20,20,20));
            removemem.setForeground(Color.white);
            removemem.setText("Remove Member");
            removemem.setFont(new Font("Cooper Black",0,22));
            removemem.setHorizontalAlignment(0);
            removemem.setVerticalAlignment(0);
            removemem.setHorizontalTextPosition(0);
            removemem.setVerticalTextPosition(JButton.BOTTOM);
            removemem.setBorder(BorderFactory.createEmptyBorder());
            removemem.setFocusable(false);
            removemem.setOpaque(false);


            searchmem.setBounds(800, 50, 200, 200);
            searchmem.setIcon(new ImageIcon(new ImageIcon(getClass().getResource("icons/searchmem.png")).getImage().getScaledInstance(120, 120, Image.SCALE_SMOOTH)));
            searchmem.setBackground(new Color(20,20,20));
            searchmem.setForeground(Color.white);
            searchmem.setText("Search Member");
            searchmem.setFont(new Font("Cooper Black",0,22));
            searchmem.setHorizontalAlignment(0);
            searchmem.setVerticalAlignment(0);
            searchmem.setHorizontalTextPosition(0);
            searchmem.setVerticalTextPosition(JButton.BOTTOM);
            searchmem.setBorder(BorderFactory.createEmptyBorder());
            searchmem.setFocusable(false);
            searchmem.setOpaque(false);


            feemem.setBounds(1100, 50, 200, 200);
            feemem.setIcon(new ImageIcon(new ImageIcon(getClass().getResource("icons/fee.png")).getImage().getScaledInstance(120, 120, Image.SCALE_SMOOTH)));
            feemem.setBackground(new Color(20,20,20));
            feemem.setForeground(Color.white);
            feemem.setText("Add Fee");
            feemem.setFont(new Font("Cooper Black",0,22));
            feemem.setHorizontalAlignment(0);
            feemem.setVerticalAlignment(0);
            feemem.setHorizontalTextPosition(0);
            feemem.setVerticalTextPosition(JButton.BOTTOM);
            feemem.setBorder(BorderFactory.createEmptyBorder());
            feemem.setFocusable(false);
            feemem.setOpaque(false);


            calculatemonthbugjet.setBounds(170, 260, 250, 200);
            calculatemonthbugjet.setIcon(new ImageIcon(new ImageIcon(getClass().getResource("icons/monthly.png")).getImage().getScaledInstance(120, 120, Image.SCALE_SMOOTH)));
            calculatemonthbugjet.setBackground(new Color(20,20,20));
            calculatemonthbugjet.setForeground(Color.white);
            calculatemonthbugjet.setText("Monthly Fee Record");
            calculatemonthbugjet.setFont(new Font("Cooper Black",0,22));
            calculatemonthbugjet.setHorizontalAlignment(0);
            calculatemonthbugjet.setVerticalAlignment(0);
            calculatemonthbugjet.setHorizontalTextPosition(0);
            calculatemonthbugjet.setVerticalTextPosition(JButton.BOTTOM);
            calculatemonthbugjet.setBorder(BorderFactory.createEmptyBorder());
            calculatemonthbugjet.setFocusable(false);
            calculatemonthbugjet.setOpaque(false);


            text.setBounds(800, 260, 200, 200);
            text.setIcon(new ImageIcon(new ImageIcon(getClass().getResource("icons/txt.png")).getImage().getScaledInstance(120, 120, Image.SCALE_SMOOTH)));
            text.setBackground(new Color(20,20,20));
            text.setForeground(Color.white);
            text.setText("Export Text");
            text.setFont(new Font("Cooper Black",0,22));
            text.setHorizontalAlignment(0);
            text.setVerticalAlignment(0);
            text.setHorizontalTextPosition(0);
            text.setVerticalTextPosition(JButton.BOTTOM);
            text.setBorder(BorderFactory.createEmptyBorder());
            text.setFocusable(false);
            text.setOpaque(false);


            replacemem.setBounds(470, 260, 250, 200);
            replacemem.setIcon(new ImageIcon(new ImageIcon(getClass().getResource("icons/replace.png")).getImage().getScaledInstance(120, 120, Image.SCALE_SMOOTH)));
            replacemem.setBackground(new Color(20,20,20));
            replacemem.setForeground(Color.white);
            replacemem.setText("Change Information");
            replacemem.setFont(new Font("Cooper Black",0,22));
            replacemem.setHorizontalAlignment(0);
            replacemem.setVerticalAlignment(0);
            replacemem.setHorizontalTextPosition(0);
            replacemem.setVerticalTextPosition(JButton.BOTTOM);
            replacemem.setBorder(BorderFactory.createEmptyBorder());
            replacemem.setFocusable(false);
            replacemem.setOpaque(false);

            excel.setBounds(1100, 260, 200, 200);            
            excel.setIcon(new ImageIcon(new ImageIcon(getClass().getResource("icons/Excel_Icon.png")).getImage().getScaledInstance(120, 120, Image.SCALE_SMOOTH)));
            excel.setBackground(new Color(20,20,20));
            excel.setForeground(Color.white);
            excel.setText("Export Excel");
            excel.setFont(new Font("Cooper Black",0,22));
            excel.setHorizontalAlignment(0);
            excel.setVerticalAlignment(0);
            excel.setHorizontalTextPosition(0);
            excel.setVerticalTextPosition(JButton.BOTTOM);
            excel.setBorder(BorderFactory.createEmptyBorder());
            excel.setFocusable(false);
            excel.setOpaque(false);


            music.setBounds(500, 480, 200, 200);
            music.setIcon(new ImageIcon(new ImageIcon(getClass().getResource("icons/music.png")).getImage().getScaledInstance(120, 120, Image.SCALE_SMOOTH)));
            music.setBackground(new Color(20,20,20));
            music.setForeground(Color.white);
            music.setText("Play Music");
            music.setFont(new Font("Cooper Black",0,22));
            music.setHorizontalAlignment(0);
            music.setVerticalAlignment(0);
            music.setHorizontalTextPosition(0);
            music.setVerticalTextPosition(JButton.BOTTOM);
            music.setBorder(BorderFactory.createEmptyBorder());
            music.setFocusable(false);
            music.setOpaque(false);

            video.setBounds(800, 480, 200, 200);
            video.setBounds(800, 480, 200, 200);
            video.setIcon(new ImageIcon(new ImageIcon(getClass().getResource("icons/video.png")).getImage().getScaledInstance(120, 120, Image.SCALE_SMOOTH)));
            video.setBackground(new Color(20,20,20));
            video.setForeground(Color.white);
            video.setText("Play Mp4 Songs");
            video.setFont(new Font("Cooper Black",0,22));
            video.setHorizontalAlignment(0);
            video.setVerticalAlignment(0);
            video.setHorizontalTextPosition(0);
            video.setVerticalTextPosition(JButton.BOTTOM);
            video.setBorder(BorderFactory.createEmptyBorder());
            video.setFocusable(false);
            video.setOpaque(false);


            p1.add(homelblmenupanel);
            menupanel.setVisible(true);

        }
        else if(Screensize.getWidth()>=1536&&Screensize.getWidth()<1920)
        {
            menupanel.setLayout(null);
            
            p2.setBounds(720, 210, 130, 40);
            p2.setBackground(new Color(20,20,20));
            p2.setLayout(null);

            
            homelblmenupanel.setVisible(false);
            homelblmenupanel3.setVisible(false);
            homelblmenupanel2.setBounds(0, 0, 130, 40);
            homelblmenupanel2.setVisible(true);

            p2.setVisible(true);
            p1.setVisible(false);
            p3.setVisible(false);

            addmem.setBounds(50, 50, 150, 110);
            

            addmem.setIcon(new ImageIcon(new ImageIcon(getClass().getResource("icons/addmem.png")).getImage().getScaledInstance(80, 80, Image.SCALE_SMOOTH)));
            addmem.setBackground(new Color(20,20,20));
            addmem.setForeground(Color.white);
            addmem.setText("New Member");
            addmem.setFont(new Font("Cooper Black",0,20));
            addmem.setHorizontalAlignment(0);
            addmem.setVerticalAlignment(0);
            addmem.setHorizontalTextPosition(0);
            addmem.setVerticalTextPosition(JButton.BOTTOM);
            addmem.setBorder(BorderFactory.createEmptyBorder());
            addmem.setFocusable(false);
            addmem.setOpaque(false);

            
            removemem.setBounds(250, 50, 200, 110);
            removemem.setIcon(new ImageIcon(new ImageIcon(getClass().getResource("icons/removemem.png")).getImage().getScaledInstance(80, 80, Image.SCALE_SMOOTH)));
            removemem.setBackground(new Color(20,20,20));
            removemem.setForeground(Color.white);
            removemem.setText("Remove Member");
            removemem.setFont(new Font("Cooper Black",0,20));
            removemem.setHorizontalAlignment(0);
            removemem.setVerticalAlignment(0);
            removemem.setHorizontalTextPosition(0);
            removemem.setVerticalTextPosition(JButton.BOTTOM);
            removemem.setBorder(BorderFactory.createEmptyBorder());
            removemem.setFocusable(false);
            removemem.setOpaque(false);

            
            searchmem.setBounds(500, 50, 200, 110);
            searchmem.setIcon(new ImageIcon(new ImageIcon(getClass().getResource("icons/searchmem.png")).getImage().getScaledInstance(80, 80, Image.SCALE_SMOOTH)));
            searchmem.setBackground(new Color(20,20,20));
            searchmem.setForeground(Color.white);
            searchmem.setText("Search Member");
            searchmem.setFont(new Font("Cooper Black",0,22));
            searchmem.setHorizontalAlignment(0);
            searchmem.setVerticalAlignment(0);
            searchmem.setHorizontalTextPosition(0);
            searchmem.setVerticalTextPosition(JButton.BOTTOM);
            searchmem.setBorder(BorderFactory.createEmptyBorder());
            searchmem.setFocusable(false);
            searchmem.setOpaque(false);

            
            feemem.setBounds(1050, 50, 200, 110);
            feemem.setIcon(new ImageIcon(new ImageIcon(getClass().getResource("icons/fee.png")).getImage().getScaledInstance(80, 80, Image.SCALE_SMOOTH)));
            feemem.setBackground(new Color(20,20,20));
            feemem.setForeground(Color.white);
            feemem.setText("Add Fee");
            feemem.setFont(new Font("Cooper Black",0,22));
            feemem.setHorizontalAlignment(0);
            feemem.setVerticalAlignment(0);
            feemem.setHorizontalTextPosition(0);
            feemem.setVerticalTextPosition(JButton.BOTTOM);
            feemem.setBorder(BorderFactory.createEmptyBorder());
            feemem.setFocusable(false);
            feemem.setOpaque(false);

            
            calculatemonthbugjet.setBounds(10, 250, 230, 110);
            calculatemonthbugjet.setIcon(new ImageIcon(new ImageIcon(getClass().getResource("icons/monthly.png")).getImage().getScaledInstance(80, 80, Image.SCALE_SMOOTH)));
            calculatemonthbugjet.setBackground(new Color(20,20,20));
            calculatemonthbugjet.setForeground(Color.white);
            calculatemonthbugjet.setText("Monthly Fee Record");
            calculatemonthbugjet.setFont(new Font("Cooper Black",0,22));
            calculatemonthbugjet.setHorizontalAlignment(0);
            calculatemonthbugjet.setVerticalAlignment(0);
            calculatemonthbugjet.setHorizontalTextPosition(0);
            calculatemonthbugjet.setVerticalTextPosition(JButton.BOTTOM);
            calculatemonthbugjet.setBorder(BorderFactory.createEmptyBorder());
            calculatemonthbugjet.setFocusable(false);
            calculatemonthbugjet.setOpaque(false);

            
            text.setBounds(770, 250, 200, 110);
            text.setIcon(new ImageIcon(new ImageIcon(getClass().getResource("icons/txt.png")).getImage().getScaledInstance(80, 80, Image.SCALE_SMOOTH)));
            text.setBackground(new Color(20,20,20));
            text.setForeground(Color.white);
            text.setText("Export Text");
            text.setFont(new Font("Cooper Black",0,22));
            text.setHorizontalAlignment(0);
            text.setVerticalAlignment(0);
            text.setHorizontalTextPosition(0);
            text.setVerticalTextPosition(JButton.BOTTOM);
            text.setBorder(BorderFactory.createEmptyBorder());
            text.setFocusable(false);
            text.setOpaque(false);

            
            replacemem.setBounds(750, 50, 250, 110);
            replacemem.setIcon(new ImageIcon(new ImageIcon(getClass().getResource("icons/replace.png")).getImage().getScaledInstance(80, 80, Image.SCALE_SMOOTH)));
            replacemem.setBackground(new Color(20,20,20));
            replacemem.setForeground(Color.white);
            replacemem.setText("Change Information");
            replacemem.setFont(new Font("Cooper Black",0,22));
            replacemem.setHorizontalAlignment(0);
            replacemem.setVerticalAlignment(0);
            replacemem.setHorizontalTextPosition(0);
            replacemem.setVerticalTextPosition(JButton.BOTTOM);
            replacemem.setBorder(BorderFactory.createEmptyBorder());
            replacemem.setFocusable(false);
            replacemem.setOpaque(false);

            
            excel.setBounds(1060, 250, 170, 110);
            excel.setIcon(new ImageIcon(new ImageIcon(getClass().getResource("icons/Excel_Icon.png")).getImage().getScaledInstance(80, 80, Image.SCALE_SMOOTH)));
            excel.setBackground(new Color(20,20,20));
            excel.setForeground(Color.white);
            excel.setText("Export Excel");
            excel.setFont(new Font("Cooper Black",0,22));
            excel.setHorizontalAlignment(0);
            excel.setVerticalAlignment(0);
            excel.setHorizontalTextPosition(0);
            excel.setVerticalTextPosition(JButton.BOTTOM);
            excel.setBorder(BorderFactory.createEmptyBorder());
            excel.setFocusable(false);
            excel.setOpaque(false);

            
            music.setBounds(280, 250, 160, 110);
            music.setIcon(new ImageIcon(new ImageIcon(getClass().getResource("icons/music.png")).getImage().getScaledInstance(80, 80, Image.SCALE_SMOOTH)));
            music.setBackground(new Color(20,20,20));
            music.setForeground(Color.white);
            music.setText("Play Music");
            music.setFont(new Font("Cooper Black",0,22));
            music.setHorizontalAlignment(0);
            music.setVerticalAlignment(0);
            music.setHorizontalTextPosition(0);
            music.setVerticalTextPosition(JButton.BOTTOM);
            music.setBorder(BorderFactory.createEmptyBorder());
            music.setFocusable(false);
            music.setOpaque(false);

            
            video.setBounds(500, 250, 200, 110);
            video.setIcon(new ImageIcon(new ImageIcon(getClass().getResource("icons/video.png")).getImage().getScaledInstance(80, 80, Image.SCALE_SMOOTH)));
            video.setBackground(new Color(20,20,20));
            video.setForeground(Color.white);
            video.setText("Play Mp4 Songs");
            video.setFont(new Font("Cooper Black",0,22));
            video.setHorizontalAlignment(0);
            video.setVerticalAlignment(0);
            video.setHorizontalTextPosition(0);
            video.setVerticalTextPosition(JButton.BOTTOM);
            video.setBorder(BorderFactory.createEmptyBorder());
            video.setFocusable(false);
            video.setOpaque(false);


            p2.add(homelblmenupanel2);
            menupanel.setBounds(150, 250, 1300, 550);
            menupanel.setVisible(true);
        }
        else
        {
            menupanel.setBounds(50, 180, 1200, 450);
            
            p3.setBounds(570, 150, 100, 30);
            p3.setBackground(new Color(20,20,20));
            p3.setBorder(b1);
            p3.setLayout(null);

            
            homelblmenupanel.setVisible(false);
            homelblmenupanel2.setVisible(false);
            homelblmenupanel3.setBounds(0, 0, 130, 30);
            homelblmenupanel3.setVisible(true);

            p2.setVisible(false);
            p1.setVisible(false);
            p3.setVisible(true);
            
            addmem.setBounds(50, 50, 150, 110);
            addmem.setIcon(new ImageIcon(new ImageIcon(getClass().getResource("icons/addmem.png")).getImage().getScaledInstance(60, 60, Image.SCALE_SMOOTH)));
            addmem.setBackground(new Color(20,20,20));
            addmem.setForeground(Color.white);
            addmem.setText("New Member");
            addmem.setFont(new Font("Cooper Black",0,18));
            addmem.setHorizontalAlignment(0);
            addmem.setVerticalAlignment(0);
            addmem.setHorizontalTextPosition(0);
            addmem.setVerticalTextPosition(JButton.BOTTOM);
            addmem.setBorder(BorderFactory.createEmptyBorder());
            addmem.setFocusable(false);
            addmem.setOpaque(false);

            
            removemem.setBounds(250, 50, 200, 110);
            removemem.setIcon(new ImageIcon(new ImageIcon(getClass().getResource("icons/removemem.png")).getImage().getScaledInstance(60, 60, Image.SCALE_SMOOTH)));
            removemem.setBackground(new Color(20,20,20));
            removemem.setForeground(Color.white);
            removemem.setText("Remove Member");
            removemem.setFont(new Font("Cooper Black",0,18));
            removemem.setHorizontalAlignment(0);
            removemem.setVerticalAlignment(0);
            removemem.setHorizontalTextPosition(0);
            removemem.setVerticalTextPosition(JButton.BOTTOM);
            removemem.setBorder(BorderFactory.createEmptyBorder());
            removemem.setFocusable(false);
            removemem.setOpaque(false);

            
            searchmem.setBounds(500, 50, 200, 110);
            searchmem.setIcon(new ImageIcon(new ImageIcon(getClass().getResource("icons/searchmem.png")).getImage().getScaledInstance(60, 60, Image.SCALE_SMOOTH)));
            searchmem.setBackground(new Color(20,20,20));
            searchmem.setForeground(Color.white);
            searchmem.setText("Search Member");
            searchmem.setFont(new Font("Cooper Black",0,18));
            searchmem.setHorizontalAlignment(0);
            searchmem.setVerticalAlignment(0);
            searchmem.setHorizontalTextPosition(0);
            searchmem.setVerticalTextPosition(JButton.BOTTOM);
            searchmem.setBorder(BorderFactory.createEmptyBorder());
            searchmem.setFocusable(false);
            searchmem.setOpaque(false);

            
            feemem.setBounds(1000, 50, 150, 110);
            feemem.setIcon(new ImageIcon(new ImageIcon(getClass().getResource("icons/fee.png")).getImage().getScaledInstance(60, 60, Image.SCALE_SMOOTH)));
            feemem.setBackground(new Color(20,20,20));
            feemem.setForeground(Color.white);
            feemem.setText("Add Fee");
            feemem.setFont(new Font("Cooper Black",0,18));
            feemem.setHorizontalAlignment(0);
            feemem.setVerticalAlignment(0);
            feemem.setHorizontalTextPosition(0);
            feemem.setVerticalTextPosition(JButton.BOTTOM);
            feemem.setBorder(BorderFactory.createEmptyBorder());
            feemem.setFocusable(false);
            feemem.setOpaque(false);

            
            calculatemonthbugjet.setBounds(10, 250, 230, 110);
            calculatemonthbugjet.setIcon(new ImageIcon(new ImageIcon(getClass().getResource("icons/monthly.png")).getImage().getScaledInstance(60, 60, Image.SCALE_SMOOTH)));
            calculatemonthbugjet.setBackground(new Color(20,20,20));
            calculatemonthbugjet.setForeground(Color.white);
            calculatemonthbugjet.setText("Monthly Fee Record");
            calculatemonthbugjet.setFont(new Font("Cooper Black",0,18));
            calculatemonthbugjet.setHorizontalAlignment(0);
            calculatemonthbugjet.setVerticalAlignment(0);
            calculatemonthbugjet.setHorizontalTextPosition(0);
            calculatemonthbugjet.setVerticalTextPosition(JButton.BOTTOM);
            calculatemonthbugjet.setBorder(BorderFactory.createEmptyBorder());
            calculatemonthbugjet.setFocusable(false);
            calculatemonthbugjet.setOpaque(false);

           
            text.setBounds(770, 250, 200, 110);
            text.setIcon(new ImageIcon(new ImageIcon(getClass().getResource("icons/txt.png")).getImage().getScaledInstance(60, 60, Image.SCALE_SMOOTH)));
            text.setBackground(new Color(20,20,20));
            text.setForeground(Color.white);
            text.setText("Export Text");
            text.setFont(new Font("Cooper Black",0,18));
            text.setHorizontalAlignment(0);
            text.setVerticalAlignment(0);
            text.setHorizontalTextPosition(0);
            text.setVerticalTextPosition(JButton.BOTTOM);
            text.setBorder(BorderFactory.createEmptyBorder());
            text.setFocusable(false);
            text.setOpaque(false);

            
            replacemem.setBounds(750, 50, 250, 110);
            replacemem.setIcon(new ImageIcon(new ImageIcon(getClass().getResource("icons/replace.png")).getImage().getScaledInstance(60, 60, Image.SCALE_SMOOTH)));
            replacemem.setBackground(new Color(20,20,20));
            replacemem.setForeground(Color.white);
            replacemem.setText("Change Information");
            replacemem.setFont(new Font("Cooper Black",0,18));
            replacemem.setHorizontalAlignment(0);
            replacemem.setVerticalAlignment(0);
            replacemem.setHorizontalTextPosition(0);
            replacemem.setVerticalTextPosition(JButton.BOTTOM);
            replacemem.setBorder(BorderFactory.createEmptyBorder());
            replacemem.setFocusable(false);
            replacemem.setOpaque(false);

            
            excel.setBounds(1000, 250, 170, 110);
            excel.setIcon(new ImageIcon(new ImageIcon(getClass().getResource("icons/Excel_Icon.png")).getImage().getScaledInstance(60, 60, Image.SCALE_SMOOTH)));
            excel.setBackground(new Color(20,20,20));
            excel.setForeground(Color.white);
            excel.setText("Export Excel");
            excel.setFont(new Font("Cooper Black",0,18));
            excel.setHorizontalAlignment(0);
            excel.setVerticalAlignment(0);
            excel.setHorizontalTextPosition(0);
            excel.setVerticalTextPosition(JButton.BOTTOM);
            excel.setBorder(BorderFactory.createEmptyBorder());
            excel.setFocusable(false);
            excel.setOpaque(false);

            
            music.setBounds(280, 250, 160, 110);
            music.setIcon(new ImageIcon(new ImageIcon(getClass().getResource("icons/music.png")).getImage().getScaledInstance(60, 60, Image.SCALE_SMOOTH)));
            music.setBackground(new Color(20,20,20));
            music.setForeground(Color.white);
            music.setText("Play Music");
            music.setFont(new Font("Cooper Black",0,18));
            music.setHorizontalAlignment(0);
            music.setVerticalAlignment(0);
            music.setHorizontalTextPosition(0);
            music.setVerticalTextPosition(JButton.BOTTOM);
            music.setBorder(BorderFactory.createEmptyBorder());
            music.setFocusable(false);
            music.setOpaque(false);

           
            video.setBounds(500, 250, 200, 110);
            video.setIcon(new ImageIcon(new ImageIcon(getClass().getResource("icons/video.png")).getImage().getScaledInstance(60, 60, Image.SCALE_SMOOTH)));
            video.setBackground(new Color(20,20,20));
            video.setForeground(Color.white);
            video.setText("Play Mp4 Songs");
            video.setFont(new Font("Cooper Black",0,18));
            video.setHorizontalAlignment(0);
            video.setVerticalAlignment(0);
            video.setHorizontalTextPosition(0);
            video.setVerticalTextPosition(JButton.BOTTOM);
            video.setBorder(BorderFactory.createEmptyBorder());
            video.setFocusable(false);
            video.setOpaque(false);


            p3.add(homelblmenupanel3);
            
            menupanel.setVisible(true);
        }


        //............Main Menu Panel.................................


        //............Change Password Name Panel.................................




        if(Screensize.getWidth()==1920)
        {
            chngepswctl.setBounds(330, 230,(int)Screensize.getWidth()-380, 550);


            showCP1.setBounds(617, 377, 24, 24);
            hideCP1.setBounds(617, 377, 24, 24);
            showCP.setBounds(617, 287, 24, 24);
            hideCP.setBounds(617, 287, 24, 24);
            clearbtnCP.setBounds(550, 480, 150, 40);
            clearbtnCP.setFont(new Font("Cooper Black",0,24));
            cancelUbtnCP.setBounds(750, 480, 150, 40);
            cancelUbtnCP.setFont(new Font("Cooper Black",0,24));
            chgpassButton.setBounds(280, 480, 250, 40);
            chgpassButton.setFont(new Font("Cooper Black",0,24));
            confirmfldCP.setBounds(50, 400, 300, 50);
            confirmfldCP.setFont(new Font("Goudy Old Style",0,20));
            newPassCP.setBounds(310, 335, 300, 50);
            newPassCP.setFont(new Font("Goudy Old Style",0,20));
            pwsfldCP.setBounds(310, 240, 300, 50);
            pwsfldCP.setFont(new Font("Goudy Old Style",0,20));
            userNamefldCP.setBounds(310, 135, 300, 50);
            userNamefldCP.setFont(new Font("Goudy Old Style",0,20));
            pswnewlblCP.setBounds(50, 285, 300, 50);
            pswnewlblCP.setFont(new Font("Cooper Black",0,24));
            pswlblCP.setBounds(50, 185, 350, 50);
            pswlblCP.setFont(new Font("Cooper Black",0,24));
            usrNamelblCP.setBounds(50, 90, 300, 50);
            usrNamelblCP.setFont(new Font("Cooper Black",0,24));
            linelblCP.setBounds(0, 40,chngepswctl.getWidth() , 40);



        }
        else if(Screensize.getWidth()>=1536&&Screensize.getWidth()<1920)
        {
            chngepswctl.setBounds(330, 230,(int)Screensize.getWidth()-380, 550);
            showCP1.setBounds(617, 377, 24, 24);
            hideCP1.setBounds(617, 377, 24, 24);
            showCP.setBounds(617, 287, 24, 24);
            hideCP.setBounds(617, 287, 24, 24);
            clearbtnCP.setBounds(550, 480, 150, 40);
            clearbtnCP.setFont(new Font("Cooper Black",0,24));
            cancelUbtnCP.setBounds(750, 480, 150, 40);
            cancelUbtnCP.setFont(new Font("Cooper Black",0,24));
            chgpassButton.setBounds(280, 480, 250, 40);
            chgpassButton.setFont(new Font("Cooper Black",0,24));
            confirmfldCP.setBounds(50, 400, 300, 50);
            confirmfldCP.setFont(new Font("Goudy Old Style",0,20));
            newPassCP.setBounds(310, 335, 300, 50);
            newPassCP.setFont(new Font("Goudy Old Style",0,20));
            pwsfldCP.setBounds(310, 240, 300, 50);
            pwsfldCP.setFont(new Font("Goudy Old Style",0,20));
            userNamefldCP.setBounds(310, 135, 300, 50);
            userNamefldCP.setFont(new Font("Goudy Old Style",0,20));
            pswnewlblCP.setBounds(50, 285, 300, 50);
            pswnewlblCP.setFont(new Font("Cooper Black",0,24));
            pswlblCP.setBounds(50, 185, 350, 50);
            pswlblCP.setFont(new Font("Cooper Black",0,24));
            usrNamelblCP.setBounds(50, 90, 300, 50);
            usrNamelblCP.setFont(new Font("Cooper Black",0,24));
            linelblCP.setBounds(0, 40,chngepswctl.getWidth() , 40);


        }
        else
        {
            chngepswctl.setBounds(220, 150, (int)Screensize.getWidth()-250, 500);
            showCP1.setBounds(615, 325, 24, 24);
            hideCP1.setBounds(615, 325, 24, 24);
            showCP.setBounds(615, 235, 24, 24);
            hideCP.setBounds(615, 235, 24, 24);
            clearbtnCP.setBounds(550, 400, 150, 40);
            clearbtnCP.setFont(new Font("Cooper Black",0,20));
            cancelUbtnCP.setBounds(750, 400, 150, 40);
            cancelUbtnCP.setFont(new Font("Cooper Black",0,20));
            chgpassButton.setBounds(280, 400, 250, 40);
            chgpassButton.setFont(new Font("Cooper Black",0,20));
            confirmfldCP.setBounds(50, 350, 300, 40);
            confirmfldCP.setFont(new Font("Goudy Old Style",0,18));
            newPassCP.setBounds(310, 295, 300, 40);
            newPassCP.setFont(new Font("Goudy Old Style",0,20));
            pwsfldCP.setBounds(310, 205, 300, 40);
            pwsfldCP.setFont(new Font("Goudy Old Style",0,20));
            userNamefldCP.setBounds(310, 105, 300, 40);
            userNamefldCP.setFont(new Font("Goudy Old Style",0,20));
            pswnewlblCP.setBounds(50, 250, 300, 40);
            pswnewlblCP.setFont(new Font("Cooper Black",0,20));
            pswlblCP.setBounds(50, 155, 350, 40);
            pswlblCP.setFont(new Font("Cooper Black",0,20));
            usrNamelblCP.setBounds(50, 60, 300, 40);
            usrNamelblCP.setFont(new Font("Cooper Black",0,20));
            linelblCP.setBounds(0, 40,chngepswctl.getWidth() , 40);


        }


        if(Screensize.getWidth()==1920)
        {
            gradientlbCP.setBounds(480, 2, 290, 40);
            gradientlbCP1.setVisible(false);
            gradientlbCP.setVisible(true);

        }
        else if(Screensize.getWidth()>=1536&&Screensize.getWidth()<1920)
        {
            gradientlbCP.setBounds(310, 2, 290, 40);
            gradientlbCP1.setVisible(false);
            gradientlbCP.setVisible(true);

        }
        else
        {
            gradientlbCP1.setBounds(300, 2, 230, 40);
            gradientlbCP.setVisible(false);
            gradientlbCP1.setVisible(true);
        }

        //............Change Password Name Panel.................................


        //............Change User Name Panel.................................

            if(Screensize.getWidth()==1920)
            {
                chngeusrnmectl.setBounds(330, 230,(int)Screensize.getWidth()-380, 550);
                showCUN.setBounds(600, 280, 24, 24);
                hideCUN.setBounds(600, 280, 24, 24);
                clearbtnCUN.setBounds(550, 480, 150, 40);
                clearbtnCUN.setFont(new Font("Cooper Black",0,24));
                cancelUbtnCUN.setBounds(750, 480, 150, 40);
                cancelUbtnCUN.setFont(new Font("Cooper Black",0,24));
                chguserNameButton.setBounds(250, 480, 270, 40);
                chguserNameButton.setFont(new Font("Cooper Black",0,24));
                confirmfldCUN.setBounds(50, 400, 300, 50);
                confirmfldCUN.setFont(new Font("Goudy Old Style",0,20));
                newuserNamefldCUN.setBounds(310, 340, 300, 50);
                newuserNamefldCUN.setFont(new Font("Goudy Old Style",0,20));
                pswfldRCUN.setBounds(310, 235, 300, 50);
                pswfldRCUN.setFont(new Font("Goudy Old Style",0,20));
                userNamefldCUN.setBounds(310, 140, 300, 50);
                userNamefldCUN.setFont(new Font("Goudy Old Style",0,20));
                newUserNamelblCUN.setBounds(50, 290, 350, 50);
                newUserNamelblCUN.setFont(new Font("Cooper Black",0,24));
                pswlblCUN.setBounds(50, 190, 300, 50);
                pswlblCUN.setFont(new Font("Cooper Black",0,24));
                usrNamelblCUN.setBounds(50, 90, 350, 50);
                usrNamelblCUN.setFont(new Font("Cooper Black",0,24));
                linelblCUN.setBounds(0, 40, chngeusrnmectl.getWidth(), 40);


            }
            else if(Screensize.getWidth()>=1536&&Screensize.getWidth()<1920)
            {
                chngeusrnmectl.setBounds(330, 230,(int)Screensize.getWidth()-380, 550);
                showCUN.setBounds(600, 280, 24, 24);
                hideCUN.setBounds(600, 280, 24, 24);
                clearbtnCUN.setBounds(550, 480, 150, 40);
                clearbtnCUN.setFont(new Font("Cooper Black",0,24));
                cancelUbtnCUN.setBounds(750, 480, 150, 40);
                cancelUbtnCUN.setFont(new Font("Cooper Black",0,24));
                chguserNameButton.setBounds(250, 480, 270, 40);
                chguserNameButton.setFont(new Font("Cooper Black",0,24));
                confirmfldCUN.setBounds(50, 400, 300, 50);
                confirmfldCUN.setFont(new Font("Goudy Old Style",0,20));
                newuserNamefldCUN.setBounds(310, 340, 300, 50);
                newuserNamefldCUN.setFont(new Font("Goudy Old Style",0,20));
                pswfldRCUN.setBounds(310, 235, 300, 50);
                pswfldRCUN.setFont(new Font("Goudy Old Style",0,20));
                userNamefldCUN.setBounds(310, 140, 300, 50);
                userNamefldCUN.setFont(new Font("Goudy Old Style",0,20));
                newUserNamelblCUN.setBounds(50, 290, 350, 50);
                newUserNamelblCUN.setFont(new Font("Cooper Black",0,24));
                pswlblCUN.setBounds(50, 190, 300, 50);
                pswlblCUN.setFont(new Font("Cooper Black",0,24));
                usrNamelblCUN.setBounds(50, 90, 350, 50);
                usrNamelblCUN.setFont(new Font("Cooper Black",0,24));
                linelblCUN.setBounds(0, 40, chngeusrnmectl.getWidth(), 40);


            }
            else
            {
                chngeusrnmectl.setBounds(220, 150, (int)Screensize.getWidth()-250, 500);
                showCUN.setBounds(610, 215, 24, 24);
                hideCUN.setBounds(610, 215, 24, 24);
                clearbtnCUN.setBounds(550, 400, 150, 40);
                clearbtnCUN.setFont(new Font("Cooper Black",0,20));
                cancelUbtnCUN.setBounds(750, 400, 150, 40);
                cancelUbtnCUN.setFont(new Font("Cooper Black",0,20));
                chguserNameButton.setBounds(250, 400, 270, 40);
                chguserNameButton.setFont(new Font("Cooper Black",0,20));
                confirmfldCUN.setBounds(50, 320, 300, 50);
                confirmfldCUN.setFont(new Font("Goudy Old Style",0,20));
                newuserNamefldCUN.setBounds(310, 275, 300, 40);
                newuserNamefldCUN.setFont(new Font("Goudy Old Style",0,20));
                pswfldRCUN.setBounds(310, 185, 300, 40);
                pswfldRCUN.setFont(new Font("Goudy Old Style",0,20));
                userNamefldCUN.setBounds(310, 110, 300, 40);
                userNamefldCUN.setFont(new Font("Goudy Old Style",0,20));
                newUserNamelblCUN.setBounds(50, 230, 350, 40);
                newUserNamelblCUN.setFont(new Font("Cooper Black",0,20));
                pswlblCUN.setBounds(50, 150, 300, 40);
                pswlblCUN.setFont(new Font("Cooper Black",0,20));
                usrNamelblCUN.setBounds(50, 60, 350, 40);
                usrNamelblCUN.setFont(new Font("Cooper Black",0,20));
                linelblCUN.setBounds(0, 40, chngeusrnmectl.getWidth(), 40);


            }

            if(Screensize.getWidth()==1920)
            {
                gradientlbCUN.setBounds(480, 2, 290, 40);

                gradientlbCUN1.setVisible(false);
                gradientlbCUN.setVisible(true);
    
            }
            else if(Screensize.getWidth()>=1536&&Screensize.getWidth()<1920)
            {
                gradientlbCUN.setBounds(310, 2, 290, 40);
                gradientlbCUN1.setVisible(false);
                gradientlbCUN.setVisible(true);
    
            }
            else{
                gradientlbCUN1.setBounds(300, 2, 230, 40);
                gradientlbCUN.setVisible(false);
                gradientlbCUN1.setVisible(true);
            }

        //............Change User Name Panel.................................


        //............Remove Login User Panel.................................
            if(Screensize.getWidth()==1920)
            {
                remveusrpnlctl.setBounds(330, 230,(int)Screensize.getWidth()-380, 550);
                showRU.setBounds(650, 320, 24, 24);
                hideRU.setBounds(650, 320, 24, 24);
                clearbtnRU.setBounds(550, 480, 150, 40);
                clearbtnRU.setFont(new Font("Cooper Black",0,24));
                cancelUbtnRU.setBounds(750, 480, 150, 40);
                cancelUbtnRU.setFont(new Font("Cooper Black",0,24));
                removeuserButton.setBounds(310, 480, 200, 40);
                removeuserButton.setFont(new Font("Cooper Black",0,24));
                confirmfldRU.setBounds(50, 380, 300, 50);
                confirmfldRU.setFont(new Font("Goudy Old Style",0,20));
                pswfldR.setBounds(360, 270, 300, 50);
                pswfldR.setFont(new Font("Goudy Old Style",0,20));
                userNamefldRU.setBounds(310, 140, 300, 50);
                userNamefldRU.setFont(new Font("Goudy Old Style",0,20));
                pswlblRU.setBounds(50, 220, 300, 50);
                pswlblRU.setFont(new Font("Cooper Black",0,24));
                usrNamelblRU.setBounds(50, 90, 300, 50);
                usrNamelblRU.setFont(new Font("Cooper Black",0,24));
                linelblRU.setBounds(0, 40, remveusrpnlctl.getWidth(), 40);
            }
            else if(Screensize.getWidth()>=1536&&Screensize.getWidth()<1920)
            {
                remveusrpnlctl.setBounds(330, 230,(int)Screensize.getWidth()-380, 550);
                showRU.setBounds(650, 320, 24, 24);
                hideRU.setBounds(650, 320, 24, 24);
                clearbtnRU.setBounds(550, 480, 150, 40);
                clearbtnRU.setFont(new Font("Cooper Black",0,24));
                cancelUbtnRU.setBounds(750, 480, 150, 40);
                cancelUbtnRU.setFont(new Font("Cooper Black",0,24));
                removeuserButton.setBounds(310, 480, 200, 40);
                removeuserButton.setFont(new Font("Cooper Black",0,24));
                confirmfldRU.setBounds(50, 380, 300, 50);
                confirmfldRU.setFont(new Font("Goudy Old Style",0,20));
                pswfldR.setBounds(360, 270, 300, 50);
                pswfldR.setFont(new Font("Goudy Old Style",0,20));
                userNamefldRU.setBounds(310, 140, 300, 50);
                userNamefldRU.setFont(new Font("Goudy Old Style",0,20));
                pswlblRU.setBounds(50, 220, 300, 50);
                pswlblRU.setFont(new Font("Cooper Black",0,24));
                usrNamelblRU.setBounds(50, 90, 300, 50);
                usrNamelblRU.setFont(new Font("Cooper Black",0,24));
                linelblRU.setBounds(0, 40, remveusrpnlctl.getWidth(), 40);

            }
            else
            {
                remveusrpnlctl.setBounds(220, 150, (int)Screensize.getWidth()-250, 500);
                showRU.setBounds(650, 280, 24, 24);
                hideRU.setBounds(650, 280, 24, 24);
                clearbtnRU.setBounds(550, 400, 150, 40);
                clearbtnRU.setFont(new Font("Cooper Black",0,18));
                cancelUbtnRU.setBounds(730, 400, 150, 40);
                cancelUbtnRU.setFont(new Font("Cooper Black",0,18));
                removeuserButton.setBounds(310, 400, 200, 40);
                removeuserButton.setFont(new Font("Cooper Black",0,18));
                confirmfldRU.setBounds(50, 350, 300, 40);
                confirmfldRU.setFont(new Font("Goudy Old Style",0,18));
                pswfldR.setBounds(360, 240, 300, 40);
                pswfldR.setFont(new Font("Goudy Old Style",0,20));
                userNamefldRU.setBounds(310, 110, 300, 40);
                userNamefldRU.setFont(new Font("Goudy Old Style",0,20));
                pswlblRU.setBounds(50, 190, 300, 40);
                pswlblRU.setFont(new Font("Cooper Black",0,20));
                usrNamelblRU.setBounds(50, 60, 300, 40);
                usrNamelblRU.setFont(new Font("Cooper Black",0,20));
                linelblRU.setBounds(0, 40, remveusrpnlctl.getWidth(), 40);

            }



        if(Screensize.getWidth()==1920){
            gradientlblRU.setBounds(480, 2, 290, 40);
            gradientlblRU1.setVisible(false);
            gradientlblRU.setVisible(true);

        }
        else if(Screensize.getWidth()>=1536&&Screensize.getWidth()<1920){
            gradientlblRU.setBounds(310, 2, 290, 40);
            gradientlblRU1.setVisible(false);
            gradientlblRU.setVisible(true);

        }
        else{
            gradientlblRU1.setBounds(300, 2, 230, 40);
            gradientlblRU.setVisible(false);
            gradientlblRU1.setVisible(true);
        }

        //............Remove Login User Panel.................................


        //............Add Login User Panel.................................

        if(Screensize.getWidth()==1920)
        {
            adduserpnlctl.setBounds(330, 230, (int)Screensize.getWidth()-380, 550);
            showAU.setBounds(660, 230, 24, 24);
            hideAU.setBounds(660, 230, 24, 24);
            clearbtnAU.setBounds(550, 480, 150, 40);
            clearbtnAU.setFont(new Font("Cooper Black",0,24));
            cancelUbtnAU.setBounds(750, 480, 150, 40);
            cancelUbtnAU.setFont(new Font("Cooper Black",0,24));
            adduserButton.setBounds(350, 480, 150, 40);
            adduserButton.setFont(new Font("Cooper Black",0,24));
            confirmfldAU.setBounds(50, 430, 300, 50);
            confirmfldAU.setFont(new Font("Goudy Old Style",0,20));
            phonefldAU.setBounds(360, 360, 300, 50);
            phonefldAU.setFont(new Font("Goudy Old Style",0,24));
            utypefldAU.setBounds(360, 270, 300, 50);
            utypefldAU.setFont(new Font("Goudy Old Style",0,24));
            pswfldAU.setBounds(360, 180, 300, 50);
            pswfldAU.setFont(new Font("Goudy Old Style",0,24));
            userNamefldAU.setBounds(360, 90, 300, 50);
            userNamefldAU.setOpaque(false);
            userNamefldAU.setFont(new Font("Goudy Old Style",0,24));
            phoneAU.setBounds(50, 360, 300, 50);
            phoneAU.setFont(new Font("Cooper Black",0,24));
            utypeAU.setBounds(50, 270, 300, 50);
            utypeAU.setFont(new Font("Cooper Black",0,24));
            pswlblAU.setBounds(50, 180, 300, 50);
            pswlblAU.setFont(new Font("Cooper Black",0,24));
            usrNamelblAU.setBounds(50, 90, 300, 50);
            usrNamelblAU.setFont(new Font("Cooper Black",0,24));
            linelblAU.setBounds(0, 40, adduserpnlctl.getWidth(), 40);

        }
        else if(Screensize.getWidth()>=1536&&Screensize.getWidth()<1920)
        {
            adduserpnlctl.setBounds(330, 230, (int)menuframe.getWidth()-365, 550);
            showAU.setBounds(660, 230, 24, 24);
            hideAU.setBounds(660, 230, 24, 24);
            clearbtnAU.setBounds(550, 480, 150, 40);
            clearbtnAU.setFont(new Font("Cooper Black",0,24));
            cancelUbtnAU.setBounds(750, 480, 150, 40);
            cancelUbtnAU.setFont(new Font("Cooper Black",0,24));
            adduserButton.setBounds(350, 480, 150, 40);
            adduserButton.setFont(new Font("Cooper Black",0,24));
            confirmfldAU.setBounds(50, 430, 300, 50);
            confirmfldAU.setFont(new Font("Goudy Old Style",0,20));
            phonefldAU.setBounds(360, 360, 300, 50);
            phonefldAU.setFont(new Font("Goudy Old Style",0,24));
            utypefldAU.setBounds(360, 270, 300, 50);
            utypefldAU.setFont(new Font("Goudy Old Style",0,24));
            pswfldAU.setBounds(360, 180, 300, 50);
            pswfldAU.setFont(new Font("Goudy Old Style",0,24));
            userNamefldAU.setBounds(360, 90, 300, 50);
            userNamefldAU.setOpaque(false);
            userNamefldAU.setFont(new Font("Goudy Old Style",0,24));
            phoneAU.setBounds(50, 360, 300, 50);
            phoneAU.setFont(new Font("Cooper Black",0,24));
            utypeAU.setBounds(50, 270, 300, 50);
            utypeAU.setFont(new Font("Cooper Black",0,24));
            pswlblAU.setBounds(50, 180, 300, 50);
            pswlblAU.setFont(new Font("Cooper Black",0,24));
            usrNamelblAU.setBounds(50, 90, 300, 50);
            usrNamelblAU.setFont(new Font("Cooper Black",0,24));
            linelblAU.setBounds(0, 40, adduserpnlctl.getWidth(), 40);

        }
        else
        {
            adduserpnlctl.setBounds(220, 150, (int)Screensize.getWidth()-250, 500);

            showAU.setBounds(630, 160, 24, 24);
            hideAU.setBounds(630, 160, 24, 24);
            clearbtnAU.setBounds(550, 400, 150, 30);
            clearbtnAU.setFont(new Font("Cooper Black",0,20));
            cancelUbtnAU.setBounds(730, 400, 150, 30);
            cancelUbtnAU.setFont(new Font("Cooper Black",0,20));
            adduserButton.setBounds(350, 400, 150, 30);
            adduserButton.setFont(new Font("Cooper Black",0,20));
            confirmfldAU.setBounds(50, 330, 300, 50);
            confirmfldAU.setFont(new Font("Goudy Old Style",0,18));
            phonefldAU.setBounds(330, 240, 300, 40);
            phonefldAU.setFont(new Font("Goudy Old Style",0,20));
            utypefldAU.setBounds(330, 180, 300, 40);
            utypefldAU.setFont(new Font("Goudy Old Style",0,20));
            pswfldAU.setBounds(330, 120, 300, 40);
            pswfldAU.setFont(new Font("Goudy Old Style",0,20));
            userNamefldAU.setBounds(330, 60, 300, 40);
            userNamefldAU.setOpaque(false);
            userNamefldAU.setFont(new Font("Goudy Old Style",0,20));
            phoneAU.setBounds(50, 240, 300, 40);
            phoneAU.setFont(new Font("Cooper Black",0,20));
            utypeAU.setBounds(50, 180, 300, 40);
            utypeAU.setFont(new Font("Cooper Black",0,20));
            pswlblAU.setBounds(50, 120, 300, 40);
            pswlblAU.setFont(new Font("Cooper Black",0,20));
            usrNamelblAU.setBounds(50, 60, 300, 40);
            usrNamelblAU.setFont(new Font("Cooper Black",0,20));
            linelblAU.setBounds(0, 40, adduserpnlctl.getWidth(), 40);

        }

        if(Screensize.getWidth()==1920){
            gradientlblAU.setBounds(500, 2, 240, 40);
            gradientlblAU1.setVisible(false);
            gradientlblAU.setVisible(true);

        }
        else if(Screensize.getWidth()>=1536&&Screensize.getWidth()<1920){
            gradientlblAU.setBounds(320, 2, 240, 40);
            gradientlblAU1.setVisible(false);
            gradientlblAU.setVisible(true);

        }
        else{
            gradientlblAU1.setBounds(320, 2, 180, 40);
            gradientlblAU.setVisible(false);
            gradientlblAU1.setVisible(true);
        }

        
        //............Add Login User Panel.................................



        //............Admin Control Panel.................................


        if(Screensize.getWidth()==1920)
        {
            Admincontrols.setBounds(0, 230, 300, 550);
            adduserctrl.setIcon(new ImageIcon(getClass().getResource("icons/adduser.png")));
            adduserctrl.setBounds(5, 60, 200, 65);
            changepasswordctrl.setIcon(new ImageIcon(getClass().getResource("icons/password.png")));
            changepasswordctrl.setBounds(5, 315, 200, 65);
            changeusernamectrl.setIcon(new ImageIcon(getClass().getResource("icons/user (2).png")));
            changeusernamectrl.setBounds(5, 230, 200, 65);
            removeuserctrl.setIcon(new ImageIcon(getClass().getResource("icons/removeUser.png")));
            removeuserctrl.setBounds(5, 145, 200, 65);

            changepasswordctrl.setFont(new Font("Cooper Black",0,14));
            changeusernamectrl.setFont(new Font("Cooper Black",0,13));        
            adduserctrl.setFont(new Font("Cooper Black",0,14));
            removeuserctrl.setFont(new Font("Cooper Black",0,14));

            changepasswordctrl.setIconTextGap(4);
            adduserctrl.setIconTextGap(5);
            removeuserctrl.setIconTextGap(15);
            changeusernamectrl.setIconTextGap(10);

            changepasswordctrl.setHorizontalAlignment(0);
            changeusernamectrl.setHorizontalAlignment(0);
            removeuserctrl.setHorizontalAlignment(0);
            adduserctrl.setHorizontalAlignment(0);

            gradientlbl1.setVisible(true);
            gradientlbl4.setVisible(false);



        }
        else if(Screensize.getWidth()>=1536&&Screensize.getWidth()<1920)
        {
            Admincontrols.setBounds(0, 230, 300, 550);
            adduserctrl.setIcon(new ImageIcon(getClass().getResource("icons/adduser.png")));
            adduserctrl.setBounds(5, 60, 200, 65);
            changepasswordctrl.setIcon(new ImageIcon(getClass().getResource("icons/password.png")));
            changepasswordctrl.setBounds(5, 315, 200, 65);
            changeusernamectrl.setIcon(new ImageIcon(getClass().getResource("icons/user (2).png")));
            changeusernamectrl.setBounds(5, 230, 200, 65);
            removeuserctrl.setIcon(new ImageIcon(getClass().getResource("icons/removeUser.png")));
            removeuserctrl.setBounds(5, 145, 200, 65);

            changepasswordctrl.setFont(new Font("Cooper Black",0,14));
            changeusernamectrl.setFont(new Font("Cooper Black",0,13));        
            adduserctrl.setFont(new Font("Cooper Black",0,14));
            removeuserctrl.setFont(new Font("Cooper Black",0,14));

            changepasswordctrl.setIconTextGap(4);
            adduserctrl.setIconTextGap(5);
            removeuserctrl.setIconTextGap(15);
            changeusernamectrl.setIconTextGap(10);

            changepasswordctrl.setHorizontalAlignment(0);
            changeusernamectrl.setHorizontalAlignment(0);
            removeuserctrl.setHorizontalAlignment(0);
            adduserctrl.setHorizontalAlignment(0);
            gradientlbl1.setVisible(true);
            gradientlbl4.setVisible(false);
        }
        else
        {
            Admincontrols.setBounds(0, 150, 200, 500);
            adduserctrl.setIcon(new ImageIcon(new ImageIcon(getClass().getResource("icons/adduser.png")).getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH)));
            adduserctrl.setBounds(5, 60, 150, 40);
            changepasswordctrl.setIcon(new ImageIcon(new ImageIcon(getClass().getResource("icons/password.png")).getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH)));
            changepasswordctrl.setBounds(5, 195, 150, 40);
            changeusernamectrl.setIcon(new ImageIcon(new ImageIcon(getClass().getResource("icons/user (2).png")).getImage().getScaledInstance(15, 15, Image.SCALE_SMOOTH)));
            changeusernamectrl.setBounds(5, 150, 150, 40);
            removeuserctrl.setIcon(new ImageIcon(new ImageIcon(getClass().getResource("icons/removeUser.png")).getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH)));
            removeuserctrl.setBounds(5, 105, 150, 40);

            changepasswordctrl.setFont(new Font("Cooper Black",0,10));
            changeusernamectrl.setFont(new Font("Cooper Black",0,10));        
            adduserctrl.setFont(new Font("Cooper Black",0,10));
            removeuserctrl.setFont(new Font("Cooper Black",0,10));

            
            changepasswordctrl.setIconTextGap(1);
            adduserctrl.setIconTextGap(2);
            removeuserctrl.setIconTextGap(2);
            changeusernamectrl.setIconTextGap(2);

            changepasswordctrl.setHorizontalAlignment(0);
            changeusernamectrl.setHorizontalAlignment(0);
            removeuserctrl.setHorizontalAlignment(0);
            adduserctrl.setHorizontalAlignment(0);

            gradientlbl1.setVisible(false);
            gradientlbl4.setBounds(0, 05, 250, 50);
            gradientlbl4.setVisible(true);
            
        }

        //............Admin Control Panel.................................
        
        
        //............Graphics Button.................................

        if(Screensize.getWidth()==1920){
            graphics.setBounds((int)Screensize.getWidth()-150, 160, 55, 55);
            graphics.setIcon(new ImageIcon(new ImageIcon(getClass().getResource("icons/graphics.png")).getImage().getScaledInstance(45, 40,Image.SCALE_SMOOTH)));

        }
        else if(Screensize.getWidth()>=1536&&Screensize.getWidth()<1920){graphics.setBounds((int)Screensize.getWidth()-150, 160, 55, 55);
            graphics.setIcon(new ImageIcon(new ImageIcon(getClass().getResource("icons/graphics.png")).getImage().getScaledInstance(40, 35,Image.SCALE_SMOOTH)));
        }
        else{
            graphics.setBounds((int)Screensize.getWidth()-150, 90, 55, 55);
            graphics.setIcon(new ImageIcon(new ImageIcon(getClass().getResource("icons/graphics.png")).getImage().getScaledInstance(35, 30,Image.SCALE_SMOOTH)));
        }

        //............Gradient Label.................................

        if(menuframe.getWidth()==1920)
        {
            this.gradientlbl.setVisible(false);
            if(gradientlbl2!=null)
            {
                this.gradientlbl2.setVisible(false);
            }
            if(gradientlbl3!=null)
            {
                this.gradientlbl3.setVisible(false);
            }
            this.gradientlbl.setBounds((int)((Screensize.getWidth()/2)-(0.13*(Screensize.getWidth()/2))), 135, 275, 90);

            gradientlbl.repaintlbl();
            this.gradientlbl.setVisible(true);

        }
        else if(Screensize.getWidth()>=1536&&Screensize.getWidth()<1920)
        {
            
            if(gradientlbl!=null)
            {
                this.gradientlbl.setVisible(false);
            }
            if(gradientlbl3!=null)
            {
                this.gradientlbl3.setVisible(false);
            }
            this.gradientlbl2.setBounds((int)((Screensize.getWidth()/2)-(0.15*(Screensize.getWidth()/2))), 100, 275, 90);
            gradientlbl2.repaintlbl();

            this.gradientlbl2.setVisible(true);


        }
        else
        {
            if(gradientlbl!=null)
            {
                this.gradientlbl.setVisible(false);
            }
            if(gradientlbl2!=null)
            {
                this.gradientlbl2.setVisible(false);
            }
            this.gradientlbl3.setBounds((int)((Screensize.getWidth()/2)-(0.18*(Screensize.getWidth()/2))), 60, 275, 90);
            this.gradientlbl3.repaintlbl();
            this.gradientlbl3.setVisible(true);


        }

        //.............Panel1........................................

        if(Screensize.getWidth()==1920){panel1.setBounds((int)((Screensize.getWidth()/2)-(0.08*Screensize.getWidth())), 215, 300, 50);}
        else if(Screensize.getWidth()>=1536&&Screensize.getWidth()<1920){panel1.setBounds((int)((Screensize.getWidth()/2)-(0.09*Screensize.getWidth())), 180, 280, 50);}
        else{panel1.setBounds((int)((Screensize.getWidth()/2)-(0.1*Screensize.getWidth())), 135, 240, 50);}

        //.............Phone........................................

        if(Screensize.getWidth()==1920)
        {
            phonelbl.setIcon(new ImageIcon(getClass().getResource("icons/phone.png")));
            phonelbl.setFont(new Font("Goudy Old Style",0,24));
            phonelbl.setBounds(10, 70, 400, 40);

        }
        else if(Screensize.getWidth()>=1536&&Screensize.getWidth()<1920){
            Image img1=null;
            try {
                img1 = ImageIO.read(getClass().getResource("icons/phone.png"));
            } catch (IOException e) {
                showerror(e);
            }
            phonelbl.setBounds(10, 45, 400, 40);
            phonelbl.setIcon(new ImageIcon(img1.getScaledInstance(28,28,Image.SCALE_SMOOTH)));
            phonelbl.setFont(new Font("Goudy Old Style",0,20));
        }
        else
        {
            
            Image img1=null;
            try {
                img1 = ImageIO.read(getClass().getResource("icons/phone.png"));
            } catch (IOException e) {
                showerror(e);
            }
            phonelbl.setBounds(10, 35, 400, 40);
            phonelbl.setIcon(new ImageIcon(img1.getScaledInstance(20,20,Image.SCALE_SMOOTH)));
            phonelbl.setFont(new Font("Goudy Old Style",0,18));
        }

        //.............DateNow......................................

        if(Screensize.getWidth()==1920)
        {
            datenow.setIcon(new ImageIcon(getClass().getResource("icons/calen.png")));
            datenow.setFont(new Font("Goudy Old Style",0,24));
            datenow.setBounds(10, 160, 160, 50);

        }
        else if
        (Screensize.getWidth()==1536){
            Image img1=null;
            try {
                img1 = ImageIO.read(getClass().getResource("icons/calen.png"));
            } catch (IOException e) {
                showerror(e);
            }
            datenow.setBounds(10, 115, 160, 50);
            datenow.setIcon(new ImageIcon(img1.getScaledInstance(28,28,Image.SCALE_SMOOTH)));
            datenow.setFont(new Font("Goudy Old Style",0,20));
        }
        else
        {
            
            Image img1=null;
            try {
                img1 = ImageIO.read(getClass().getResource("icons/calen.png"));
            } catch (IOException e) {
                showerror(e);
            }
            datenow.setBounds(10, 90, 160, 50);
            datenow.setIcon(new ImageIcon(img1.getScaledInstance(20,20,Image.SCALE_SMOOTH)));
            datenow.setFont(new Font("Goudy Old Style",0,18));
        }


        //.............TimeNow......................................

        if(Screensize.getWidth()==1920)
        {
            timenow.setIcon(new ImageIcon(getClass().getResource("icons/clock.png")));
            timenow.setFont(new Font("Goudy Old Style",0,24));
            timenow.setBounds(10, 115, 200, 50);

        }
        else if(Screensize.getWidth()>=1536&&Screensize.getWidth()<1920){
            Image img1=null;
            try {
                img1 = ImageIO.read(getClass().getResource("icons/clock.png"));
            } catch (IOException e) {
                showerror(e);
            }
            timenow.setBounds(10, 80, 200, 50);
            timenow.setIcon(new ImageIcon(img1.getScaledInstance(28,28,Image.SCALE_SMOOTH)));
            timenow.setFont(new Font("Goudy Old Style",0,20));
        }
        else
        {
            
            Image img1=null;
            try {
                img1 = ImageIO.read(getClass().getResource("icons/clock.png"));
            } catch (IOException e) {
                showerror(e);
            }
            timenow.setBounds(10, 60, 200, 50);
            timenow.setIcon(new ImageIcon(img1.getScaledInstance(20,20,Image.SCALE_SMOOTH)));
            timenow.setFont(new Font("Goudy Old Style",0,18));
        }

        //..............Home Button..........................................
        
        if(Screensize.getWidth()==1920){home.setBounds((int)Screensize.getWidth()-80, 160, 55, 55);home.setIcon(new ImageIcon(new ImageIcon(getClass().getResource("icons/Home_1.png")).getImage().getScaledInstance(45, 40,Image.SCALE_SMOOTH)));}
        else if(Screensize.getWidth()>=1536&&Screensize.getWidth()<1920){home.setBounds((int)Screensize.getWidth()-80, 160, 55, 55);home.setIcon(new ImageIcon(new ImageIcon(getClass().getResource("icons/Home_1.png")).getImage().getScaledInstance(40, 35,Image.SCALE_SMOOTH)));}
        else{home.setBounds((int)Screensize.getWidth()-80, 90, 55, 55);home.setIcon(new ImageIcon(new ImageIcon(getClass().getResource("icons/Home_1.png")).getImage().getScaledInstance(30, 25,Image.SCALE_SMOOTH)));}
        
        //...............Back Button.................................................

        if(Screensize.getWidth()==1920){back.setBounds((int)Screensize.getWidth()-80, 160, 55, 55);}
        else if(Screensize.getWidth()>=1536&&Screensize.getWidth()<1920){back.setBounds((int)Screensize.getWidth()-80, 160, 55, 55);}
        else{back.setBounds((int)Screensize.getWidth()-80, 90, 55, 55);}
        
        
        //...............Logout Button.....................................................

        if(Screensize.getWidth()==1920){logout.setBounds((int)Screensize.getWidth()-80,(int)Screensize.getHeight()-60, 55, 55);}
        else if(Screensize.getWidth()>=1536&&Screensize.getWidth()<1920){logout.setBounds((int)Screensize.getWidth()-80,(int)Screensize.getHeight()-60, 55, 55);}
        else{logout.setBounds((int)Screensize.getWidth()-80,(int)Screensize.getHeight()-60, 55, 55);}
        
        
        //...............Panel Back(Background)...........................................
        
        panelback.repaint();
        panelback.setSize(new Dimension((int)Screensize.getWidth(),(int)Screensize.getHeight()));
        minimizebtn.setBounds((int)Screensize.getWidth()-100, 20, 30, 20);
        
        //.............Minimize Window Button.........................................
        
        if(Screensize.getWidth()==1920)
        {
            minimizebtn.setIcon(new ImageIcon(getClass().getResource("icons/minimizewindow~1.png")));
        }
        else if(Screensize.getWidth()>=1536&&Screensize.getWidth()<1920){
            Image img1=null;
            try {
                img1 = ImageIO.read(getClass().getResource("icons/minimizewindow~1.png"));
            } catch (IOException e) {
                showerror(e);
            }
            minimizebtn.setBounds((int)Screensize.getWidth()-90, 20, 30, 20);
            minimizebtn.setIcon(new ImageIcon(img1.getScaledInstance(28,7,Image.SCALE_SMOOTH)));
        }
        else
        {
            
            Image img1=null;
            try {
                img1 = ImageIO.read(getClass().getResource("icons/minimizewindow~1.png"));
            } catch (IOException e) {
                showerror(e);
            }
            minimizebtn.setBounds(menuframe.getWidth()-80, 20, 30, 20);
            minimizebtn.setIcon(new ImageIcon(img1.getScaledInstance(20,5,Image.SCALE_SMOOTH)));
        }
        
        
        //............Close Window Button...............................................
        closewindowbtn.setBounds((int)Screensize.getWidth()-50, 15, 40, 30);
        if(Screensize.getWidth()==1920){closewindowbtn.setIcon(new ImageIcon(new ImageIcon(getClass().getResource("icons/close~1.png")).getImage().getScaledInstance(36, 30, 4)));}
        else if(Screensize.getWidth()>=1536&&Screensize.getWidth()<1920)
        {
            Image img1=null;
            try {
                img1 = ImageIO.read(getClass().getResource("icons/close~1.png"));
            } catch (IOException e) {
                showerror(e);
            }
            closewindowbtn.setBounds((int)Screensize.getWidth()-50, 15, 40, 30);
            closewindowbtn.setIcon(new ImageIcon(img1.getScaledInstance(30,25,Image.SCALE_SMOOTH)));
        }
        else
        {
            
            Image img1=null;
            try {
                img1 = ImageIO.read(getClass().getResource("icons/close~1.png"));
            } catch (IOException e) {
                showerror(e);
            }
            closewindowbtn.setBounds((int)Screensize.getWidth()-50, 15, 40, 30);
            closewindowbtn.setIcon(new ImageIcon(img1.getScaledInstance(20,16,Image.SCALE_SMOOTH)));
        }
        
        //..............Logo Label.....................................................

        labellogo.repaint();
        labellogo.setLocation((int)((Screensize.getWidth()/2)-(1*(Screensize.getWidth()/2)/10)), 3);
        labellogo.setSize(new Dimension(186,148));
        labellogo.setVisible(true);

        
        
        //..............Admin Label........................................................   
        if(Screensize.getWidth()==1920)
        {
            adminlbl.setIcon(new ImageIcon(new ImageIcon(getClass().getResource("icons/usericon.png")).getImage().getScaledInstance(35, 35, Image.SCALE_SMOOTH)));
            adminlbl.setFont(new Font("Gabriola",0,40));
            adminlbl.setBounds(10, 25, 400, 50);

        }
        else if(Screensize.getWidth()>=1536&&Screensize.getWidth()<1920){
            Image img1=null;
            try {
                img1 = ImageIO.read(getClass().getResource("icons/usericon.png"));
            } catch (IOException e) {
                showerror(e);
            }
            adminlbl.setBounds(10, 20, 400, 40);
            adminlbl.setIcon(new ImageIcon(img1.getScaledInstance(28,28,Image.SCALE_SMOOTH)));
            adminlbl.setFont(new Font("Gabriola",0,30));
        }
        else
        {
            
            Image img1=null;
            try {
                img1 = ImageIO.read(getClass().getResource("icons/usericon.png"));
            } catch (IOException e) {
                showerror(e);
            }
            adminlbl.setBounds(10, 20, 400, 30);
            adminlbl.setIcon(new ImageIcon(img1.getScaledInstance(20,20,Image.SCALE_SMOOTH)));
            adminlbl.setFont(new Font("Gabriola",0,24));
        }
        //..............................................


    }


    public void showAdminControls()
    {
        if(super.loginuer.getUserType().equals("Admin"))
        {
                if(Screensize.getWidth()==1920)
            {
                // viewAdminControls.setBounds(0, 230, 30, 550);
                // i3=control2.getScaledInstance(25, 50, Image.SCALE_SMOOTH);
                i1=admincontrols.getScaledInstance(40,300,Image.SCALE_SMOOTH);
                // closeAdminPanel.setIcon(new ImageIcon(i3));
                viewAdminControls.setIcon(new ImageIcon(i1));
                viewAdminControls.setLocation(0, 400);
                // closeAdminPanel.setBounds(Admincontrols.getWidth()-100, Admincontrols.getHeight()/2, 30, 50);
                // closeAdminPanel.setBounds(250,40, 10,  Admincontrols.getHeight()-40);
                closeAdminPanel.setBounds(Admincontrols.getWidth()-20,42, 20,  Admincontrols.getHeight()-42);


                // Admincontrols.add(closeAdminPanel);
                closeAdminPanel.setVisible(true);
                viewAdminControls.setSize(30, 300);
                viewAdminControls.setVisible(true);

            }
            else if(Screensize.getWidth()>=1536&&Screensize.getWidth()<1920)
            {
                // viewAdminControls.setBounds(0, 230, 30, 550);
                i1=admincontrols.getScaledInstance(40,300,Image.SCALE_SMOOTH);
                closeAdminPanel.setBounds(Admincontrols.getWidth()-20,42, 20,  Admincontrols.getHeight()-42);

                viewAdminControls.setIcon(new ImageIcon(i1));
                viewAdminControls.setLocation(0, 300);
                viewAdminControls.setSize(30, 300);
                viewAdminControls.setVisible(true);

            }
            else
            {
                // viewAdminControls.setBounds(0, 150, 30, 500);
                i1=admincontrols.getScaledInstance(25,200,Image.SCALE_SMOOTH);
                closeAdminPanel.setBounds(Admincontrols.getWidth()-18, 42, 18,  Admincontrols.getHeight()-42);

                viewAdminControls.setIcon(new ImageIcon(i1));
                viewAdminControls.setLocation(0, 260);
                viewAdminControls.setSize(25, 200);
                viewAdminControls.setVisible(true);


            }

        }

    }


    private void startupapp(){

        if(Admincontrols.isVisible()){closeAdminPanel.doClick();}
        this.remveusrpnlctl.setVisible(false);
        this.chngeusrnmectl.setVisible(false);
        this.chngepswctl.setVisible(false);
        this.adduserpnlctl.setVisible(false);
        this.popgraphics.setVisible(false);
        this.Admincontrols.setVisible(false);
        this.musix.setVisible(false);
        this.musix2.setVisible(false);
        this.musix3.setVisible(false);
        this.videopanel.setVisible(false);
        this.videopanel2.setVisible(false);
        this.videopanel3.setVisible(false);
        this.addgymmem.setVisible(false);
        this.toplabelcover1.setVisible(false);
        this.removegymmem.setVisible(false);
        this.toplabelcoverRGC.setVisible(false);
        this.searchgymmem.setVisible(false);
        this.toplabelcoverSGC.setVisible(false);
        this.feepanelAF.setVisible(false);
        this.toplabelcoverAF.setVisible(false);
        this.replacepanelRI.setVisible(false);
        this.toplabelcoverRI.setVisible(false);
        this.monthlyfeepanelMF.setVisible(false);
        this.toplabelcoverMF.setVisible(false);
        exporttextET.setVisible(false);
        toplabelcoverET.setVisible(false);
        exportexcelEE.setVisible(false);
        toplabelcoverEE.setVisible(false);
        if(addgymmem1!=null){addgymmem1.setVisible(false);}
        if(addgymmem2!=null){addgymmem2.setVisible(false);}
        if(addgymmem3!=null){addgymmem3.setVisible(false);}
        if(removegymclientlbl!=null){removegymclientlbl.setVisible(false);}
        if(removegymclientlbl2!=null){removegymclientlbl2.setVisible(false);}
        if(removegymclientlbl3!=null){removegymclientlbl3.setVisible(false);}
        if(searchgymclientlbl!=null){searchgymclientlbl.setVisible(false);}
        if(searchgymclientlbl2!=null){searchgymclientlbl2.setVisible(false);}
        if(searchgymclientlbl3!=null){searchgymclientlbl3.setVisible(false);}
        if(addfeelbl1!=null){addfeelbl1.setVisible(false);}
        if(addfeelbl2!=null){addfeelbl2.setVisible(false);}
        if(addfeelbl3!=null){addfeelbl3.setVisible(false);}
        if(monthyfeelbl1!=null){monthyfeelbl1.setVisible(false);}
        if(monthyfeelbl2!=null){monthyfeelbl2.setVisible(false);}
        if(monthyfeelbl3!=null){monthyfeelbl3.setVisible(false);}
        if(replacelbl1!=null){replacelbl1.setVisible(false);}
        if(replacelbl2!=null){replacelbl2.setVisible(false);}
        if(replacelbl3!=null){replacelbl3.setVisible(false);}
        if(toplblET!=null){toplblET.setVisible(false);}
        if(toplblET1!=null){toplblET1.setVisible(false);}
        if(toplblET2!=null){toplblET2.setVisible(false);}
        if(toplblEE!=null){toplblET.setVisible(false);}
        if(toplblEE1!=null){toplblEE1.setVisible(false);}
        if(toplblEE2!=null){toplblEE2.setVisible(false);}


        if(super.loginuer.getUserType().equals("Admin")){this.viewAdminControls.setVisible(true);} 
            if(Screensize.getWidth()==1920)
            {
                menupanel.setBounds(200, 300, 1500, 700);
                p1.setBounds(880, 250, 150, 50);
                this.p1.setVisible(true);
            }
            else if(Screensize.getWidth()>=1536&&Screensize.getWidth()<1920)
            {
                menupanel.setBounds(150, 250, 1300, 500);
                p2.setVisible(true);

            }
            else
            {
                menupanel.setBounds(50, 180, 1200, 450);
                p3.setVisible(true);
            }


            this.menupanel.setVisible(true);


            if(Screensize.getWidth()==1920)
            {
                this.removeuserctrl.setSize(200,65);
                this.changeusernamectrl.setSize(200,65);
                this.changepasswordctrl.setSize(200,65);
                this.adduserctrl.setSize(200,65);
            }
            else if(Screensize.getWidth()>=1536&&Screensize.getWidth()<1920)
            {
                this.removeuserctrl.setSize(200,65);
                this.changeusernamectrl.setSize(200,65);
                this.changepasswordctrl.setSize(200,65);
                this.adduserctrl.setSize(200,65);
            }
            else
            {
                this.removeuserctrl.setSize(150,40);
                this.changeusernamectrl.setSize(150,40);
                this.changepasswordctrl.setSize(150,40);
                this.adduserctrl.setSize(150,40);
            }
            
    }


    public void searchtable(){
        searchtable.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent mouseEvent) {

                super.mouseClicked(mouseEvent);
                JTable table =(JTable) mouseEvent.getSource();
                Point point = mouseEvent.getPoint();
                int row = table.rowAtPoint(point);
                if (mouseEvent.getClickCount() == 2 && table.getSelectedRow() != -1) {
                    searchlblSGC.setVisible(false);
                    searchoptionsSGC.setVisible(false);
                    namefldSGC.setVisible(false);
                    idfldSGC.setVisible(false);
                    cnicfldSGC.setVisible(false);
                    phonefldSGC.setVisible(false);
                    nameofAdminfldSGC.setVisible(false);
                    tablecontainerSGC.setVisible(false);
                    searchSGC.setVisible(false);
                    clearSGC.setVisible(false);

                    namefldSGC.setText(null);
                    idfldSGC.setText(null);
                    cnicfldSGC.setText(null);
                    phonefldSGC.setText(null);

                    nameofAdminfldSGC.setText(null);

                    String nameofclient=String.valueOf(searchtable.getValueAt(row, 1));
                    searchtable.setModel(new DefaultTableModel(null,headerRGC));

                    if(Screensize.getWidth()==1920){
                       
                        searchtable.getColumnModel().getColumn(0).setPreferredWidth(130);
                        searchtable.getColumnModel().getColumn(1).setPreferredWidth(200);
                        searchtable.getColumnModel().getColumn(2).setPreferredWidth(240);
                        searchtable.getColumnModel().getColumn(3).setPreferredWidth(200);
                        searchtable.getColumnModel().getColumn(4).setPreferredWidth(100);
                        searchtable.getColumnModel().getColumn(5).setPreferredWidth(200);
                        searchtable.getColumnModel().getColumn(6).setPreferredWidth(115);
                    }
                    else if(Screensize.getWidth()>=1536&&Screensize.getWidth()<1920){
                        
                        searchtable.getColumnModel().getColumn(0).setPreferredWidth(90);
                        searchtable.getColumnModel().getColumn(1).setPreferredWidth(170);
                        searchtable.getColumnModel().getColumn(2).setPreferredWidth(210);
                        searchtable.getColumnModel().getColumn(3).setPreferredWidth(170);
                        searchtable.getColumnModel().getColumn(4).setPreferredWidth(100);
                        searchtable.getColumnModel().getColumn(5).setPreferredWidth(180);
                        searchtable.getColumnModel().getColumn(6).setPreferredWidth(105);
                    }
                    else{
                        
                        searchtable.getColumnModel().getColumn(0).setPreferredWidth(90);
                        searchtable.getColumnModel().getColumn(1).setPreferredWidth(170);
                        searchtable.getColumnModel().getColumn(2).setPreferredWidth(210);
                        searchtable.getColumnModel().getColumn(3).setPreferredWidth(170);
                        searchtable.getColumnModel().getColumn(4).setPreferredWidth(100);
                        searchtable.getColumnModel().getColumn(5).setPreferredWidth(180);
                        searchtable.getColumnModel().getColumn(6).setPreferredWidth(105);
                    }
        



                    ArrayList<gymclient> names=selectfromtable(nameofTabelenow);
                    gymclient client1=null;
                    for (gymclient client : names) {
                        if(client.getNameUser().equals(nameofclient)){
                            client1=client;
                            break;
                        }
                    }

                    if(client1!=null){
                        nameifldSGC.setText(client1.getNameUser());
                        idifldSGC.setText(client1.getIDuser());
                        cnicifldSGC.setText(client1.getCnic());
                        phoneifldSGC.setText("+92"+String.valueOf(client1.getPhone()));
                        dateofjoinifldSGC.setText(client1.getJoining().toString());
                        feeifldSGC.setText(String.valueOf(client1.getFee()));
                        try {
                            BufferedImage ig=ImageIO.read(client1.getImage());
                            int widthimg=(ig.getWidth()*300)/ig.getHeight();
                            int heightimg=300;
    
                            if(Screensize.getWidth()==1920){
                                widthimg=(ig.getWidth()*400)/ig.getHeight();
                                heightimg=400;
                            }
                            else if(Screensize.getWidth()>=1536&&Screensize.getWidth()<1920){
                                widthimg=(ig.getWidth()*350)/ig.getHeight();
                                heightimg=350;
                            }
                            else{
                                widthimg=(ig.getWidth()*300)/ig.getHeight();
                                heightimg=300;
                            }
                            imagelblSGC.setIcon(new ImageIcon(ig.getScaledInstance(widthimg, heightimg, Image.SCALE_SMOOTH)));
    
                        } catch (IOException e1) {
                            showerror(e1);
                        }
                    }

                    nameifldSGC.setVisible(true);
                    idifldSGC.setVisible(true);
                    phoneifldSGC.setVisible(true);
                    cnicifldSGC.setVisible(true);
                    dateofjoinifldSGC.setVisible(true);
                    feeifldSGC.setVisible(true);
        
                    nameilblSGC.setVisible(true);
                    idilblSGC.setVisible(true);
                    cnicilblSGC.setVisible(true);
                    phoneilblSGC.setVisible(true);
                    dateofjoinilblSGC.setVisible(true);
                    feeilblSGC.setVisible(true);
        
                    backbtnSGC.setVisible(true);
                    imagelblSGC.setVisible(true);
        


                }


            }
        });
        
    }

    public void monthtableMF(){
        monthtableMF.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent mouseEvent) {

                super.mouseClicked(mouseEvent);
                JTable table =(JTable) mouseEvent.getSource();
                Point point = mouseEvent.getPoint();
                int row = table.rowAtPoint(point);
                if (mouseEvent.getClickCount() == 2 && table.getSelectedRow() != -1) {
                    

                    String nameofclient=String.valueOf(monthtableMF.getValueAt(row, 1));
                    monthtableMF.clearSelection();

                    
                    tablecontainerMF.setVisible(false);
                    showtableMF.setVisible(false);
                    HidetableMF.setVisible(false);
                    strengthfldMF.setVisible(false);
                    feecollectionfldMF.setVisible(false);
                    feependfldMF.setVisible(false);
                    feependingMF.setVisible(false);
                    feecollectedlblMF.setVisible(false);
                    totalstrengthlblMF.setVisible(false);
                    reveueMF.setVisible(false);
                    ExpensesMF.setVisible(false);
                    ProfitMF.setVisible(false);
                    revenuefldMF.setVisible(false);
                    expensefldMF.setVisible(false);
                    profitfldMF.setVisible(false);
                    monthslblMF.setVisible(false);
                    monthsoptionaMF.setVisible(false);
                    totalfeefldMF.setVisible(false);
                    totalfeelblMF.setVisible(false);


                    if(Screensize.getWidth()==1920){

                        monthtableMF.getColumnModel().getColumn(0).setPreferredWidth(130);
                        monthtableMF.getColumnModel().getColumn(1).setPreferredWidth(200);
                        monthtableMF.getColumnModel().getColumn(2).setPreferredWidth(250);
                        monthtableMF.getColumnModel().getColumn(3).setPreferredWidth(200);
                        monthtableMF.getColumnModel().getColumn(4).setPreferredWidth(100);
                        monthtableMF.getColumnModel().getColumn(5).setPreferredWidth(200);
                        monthtableMF.getColumnModel().getColumn(6).setPreferredWidth(150);
                        monthtableMF.getColumnModel().getColumn(7).setPreferredWidth(130);

                    }
                    else if(Screensize.getWidth()>=1536&&Screensize.getWidth()<1920){
                        monthtableMF.getColumnModel().getColumn(0).setPreferredWidth(90);
                        monthtableMF.getColumnModel().getColumn(1).setPreferredWidth(200);
                        monthtableMF.getColumnModel().getColumn(2).setPreferredWidth(200);
                        monthtableMF.getColumnModel().getColumn(3).setPreferredWidth(180);
                        monthtableMF.getColumnModel().getColumn(4).setPreferredWidth(100);
                        monthtableMF.getColumnModel().getColumn(5).setPreferredWidth(180);
                        monthtableMF.getColumnModel().getColumn(6).setPreferredWidth(125);
                        monthtableMF.getColumnModel().getColumn(7).setPreferredWidth(125);
                    }
                    else
                    {
                        monthtableMF.getColumnModel().getColumn(0).setPreferredWidth(90);
                        monthtableMF.getColumnModel().getColumn(1).setPreferredWidth(200);
                        monthtableMF.getColumnModel().getColumn(2).setPreferredWidth(200);
                        monthtableMF.getColumnModel().getColumn(3).setPreferredWidth(180);
                        monthtableMF.getColumnModel().getColumn(4).setPreferredWidth(100);
                        monthtableMF.getColumnModel().getColumn(5).setPreferredWidth(180);
                        monthtableMF.getColumnModel().getColumn(6).setPreferredWidth(125);
                        monthtableMF.getColumnModel().getColumn(7).setPreferredWidth(125);
                    }
    



                    ArrayList<gymclient> names=selectfromtable(monthsoptionaMF.getSelectedItem().toString());
                    gymclient client1=null;
                    for (gymclient client : names) {
                        if(client.getNameUser().equals(nameofclient)){
                            client1=client;
                            break;
                        }
                    }

                    if(client1!=null){
                        nameifldMF.setText(client1.getNameUser());
                        idifldMF.setText(client1.getIDuser());
                        cnicifldMF.setText(client1.getCnic());
                        phoneifldMF.setText("+92"+String.valueOf(client1.getPhone()));
                        dateofjoinifldMF.setText(client1.getJoining().toString());
                        feeifldMF.setText(String.valueOf(client1.getFee()));
                        try {
                            BufferedImage ig=ImageIO.read(client1.getImage());
                            int widthimg=(ig.getWidth()*300)/ig.getHeight();
                            int heightimg=300;
    
                            if(Screensize.getWidth()==1920){
                                widthimg=(ig.getWidth()*600)/ig.getHeight();
                                heightimg=600;
                            }
                            else if(Screensize.getWidth()>=1536&&Screensize.getWidth()<1920){
                                widthimg=(ig.getWidth()*450)/ig.getHeight();
                                heightimg=450;
                            }
                            else{
                                widthimg=(ig.getWidth()*390)/ig.getHeight();
                                heightimg=390;
                            }
                            imagelblMF.setIcon(new ImageIcon(ig.getScaledInstance(widthimg, heightimg, Image.SCALE_SMOOTH)));
    
                        } catch (IOException e1) {
                            showerror(e1);
                        }
                    }

                    nameifldMF.setVisible(true);
                    idifldMF.setVisible(true);
                    phoneifldMF.setVisible(true);
                    cnicifldMF.setVisible(true);
                    dateofjoinifldMF.setVisible(true);
                    feeifldMF.setVisible(true);
        
                    nameilblMF.setVisible(true);
                    idilblMF.setVisible(true);
                    cnicilblMF.setVisible(true);
                    phoneilblMF.setVisible(true);
                    dateofjoinilblMF.setVisible(true);
                    feeilblMF.setVisible(true);
        
                    backbtnMF.setVisible(true);
                    imagelblMF.setVisible(true);
        


                }


            }
        });
        

    }


    //...................................................Actions Performed.........................................................










    @Override
    public void actionPerformed(ActionEvent e) {
        
        if(e.getSource()==super.exitbtn)
        {
                JDialog.setDefaultLookAndFeelDecorated(true);

                JDialog.setDefaultLookAndFeelDecorated(true);

                if(Screensize.getWidth()==1920){UIManager.put("OptionPane.messageFont", new Font("Times New Roman",1,24));}
                else if(Screensize.getWidth()>=1536&&Screensize.getWidth()<1920){UIManager.put("OptionPane.messageFont", new Font("Times New Roman",0,20));}
                else{UIManager.put("OptionPane.messageFont", new Font("Times New Roman",0,18));}
                UIManager.put("OptionPane.background", Color.BLACK);
                UIManager.put("OptionPane.titlePane.background", Color.BLACK);
                UIManager.put("Panel.background", Color.BLACK);
                UIManager.put("OptionPane.buttonFont", new Font("Times New Roman",0,16));
                // UIManager.put("OptionPane.messageForeground", new Color(235,207,47));
                UIManager.put("OptionPane.messageForeground", new Color(0, 229, 0));
    
                int response=JOptionPane.showConfirmDialog(null, "Do you really want to close Program ?", "Confirmation", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE);
                if(response==0)
                {
                    System.exit(0);
                }
            }
        if(e.getSource()==super.visible)
        {
                if(!passworField.getPassword().equals(null))
                {
                    this.passworField.setEchoChar((char)0);
                    this.visible.setVisible(false);
                    this.hide.setVisible(true);
                }
            }
        if(e.getSource()==super.hide)
        {
                this.passworField.setEchoChar('*');
                this.hide.setVisible(false);
                this.visible.setVisible(true);
            }
        if(e.getSource()==super.loginbtn)
        {

            if(super.connection!=null)
            {
                if(!checktable("logindata"))
                {
                    createtable();
                    method();
                    if(super.loginvalue)
                    {
                        if(this.adminlbl!=null){adminlbl.setText(super.loginuer.getUserName());}
                        if(this.phonelbl!=null)phonelbl.setText("+92"+" "+String.valueOf(super.loginuer.getPhone()).substring(0, 3)+" "+String.valueOf(super.loginuer.getPhone()).substring(3));

                        if(isready){
                        loginframe.setVisible(false);
                        loginbtn.setEnabled(false);
                        menuframe.setVisible(true);
                        showAdminControls();
                        
                        startupapp();
                        }
                        else{
                            setlookandfeelBlue();
                            JOptionPane.showMessageDialog(null, "Please Wait!!! Press Login Button after a while so that contents may Load.", "Loading", 1);
                        }
                    }
                }
                else
                {
                    method();
                    if(super.loginvalue)
                    {
                        if(this.adminlbl!=null){adminlbl.setText(super.loginuer.getUserName());}
                        if(this.phonelbl!=null)phonelbl.setText("+92"+" "+String.valueOf(super.loginuer.getPhone()).substring(0, 3)+" "+String.valueOf(super.loginuer.getPhone()).substring(3));
                        if(isready){
                            loginframe.setVisible(false);
                            loginbtn.setEnabled(false);
                            menuframe.setVisible(true);
                            showAdminControls();
                            }
                            else{
                                setlookandfeelBlue();
                                JOptionPane.showMessageDialog(null, "Please Wait!!! Press Login Button after a while so that contents may Load.", "Loading", 1);
                            }
                        startupapp();
                    }
                }
            }
                
    
        }

        if(e.getSource()==closewindowbtn)
        {
            JDialog.setDefaultLookAndFeelDecorated(true);

            if(Screensize.getWidth()==1920){UIManager.put("OptionPane.messageFont", new Font("Times New Roman",1,24));}
            else if(Screensize.getWidth()>=1536&&Screensize.getWidth()<1920){UIManager.put("OptionPane.messageFont", new Font("Times New Roman",0,20));}
            else{UIManager.put("OptionPane.messageFont", new Font("Times New Roman",0,18));}
            UIManager.put("OptionPane.background", Color.BLACK);
            UIManager.put("OptionPane.titlePane.background", Color.BLACK);
            UIManager.put("Panel.background", Color.BLACK);
            UIManager.put("OptionPane.buttonFont", new Font("Times New Roman",0,16));
            // UIManager.put("OptionPane.messageForeground", new Color(235,207,47));
            UIManager.put("OptionPane.messageForeground", new Color(0, 229, 0));

            int response=JOptionPane.showConfirmDialog(menuframe, "Do you really want to close Program ?", "Confirmation", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE);
            if(response==0)
            {
                System.exit(0);
            }
        }
     
        if(e.getSource()==minimizebtn)
        {
            menuframe.setState(JFrame.ICONIFIED);
        }

        if(e.getSource()==adduserctrl)
        {
            this.remveusrpnlctl.setVisible(false);
            this.chngeusrnmectl.setVisible(false);
            this.chngepswctl.setVisible(false);
            this.adduserpnlctl.setVisible(true);
            this.menupanel.setVisible(false);
            this.p1.setVisible(false);
            this.p2.setVisible(false);
            this.p3.setVisible(false);
            this.addgymmem.setVisible(false);
            this.toplabelcover1.setVisible(false);
            this.removegymmem.setVisible(false);
            this.toplabelcoverRGC.setVisible(false);
            this.searchgymmem.setVisible(false);
            this.toplabelcoverSGC.setVisible(false);
            this.feepanelAF.setVisible(false);
            this.toplabelcoverAF.setVisible(false);
            this.replacepanelRI.setVisible(false);
            this.toplabelcoverRI.setVisible(false);
            this.monthlyfeepanelMF.setVisible(false);
            this.toplabelcoverMF.setVisible(false);
            exporttextET.setVisible(false);
            toplabelcoverET.setVisible(false);
            exportexcelEE.setVisible(false);
            toplabelcoverEE.setVisible(false);
            if(Screensize.getWidth()==1920)
            {
                this.removeuserctrl.setSize(200,65);
                this.changeusernamectrl.setSize(200,65);
                this.changepasswordctrl.setSize(200,65);
                this.adduserctrl.setSize(275,65);
            }
            else if(Screensize.getWidth()>=1536&&Screensize.getWidth()<1920)
            {
                this.removeuserctrl.setSize(200,65);
                this.changeusernamectrl.setSize(200,65);
                this.changepasswordctrl.setSize(200,65);
                this.adduserctrl.setSize(275,65);
            }
            else
            {
                this.removeuserctrl.setSize(150,40);
                this.changeusernamectrl.setSize(150,40);
                this.changepasswordctrl.setSize(150,40);
                this.adduserctrl.setSize(175,40);
            }
        }

        if(e.getSource()==removeuserctrl)
        {
            this.remveusrpnlctl.setVisible(true);
            this.chngeusrnmectl.setVisible(false);
            this.chngepswctl.setVisible(false);
            this.adduserpnlctl.setVisible(false);
            this.menupanel.setVisible(false);
            this.p1.setVisible(false);
            this.p2.setVisible(false);
            this.p3.setVisible(false);
            this.addgymmem.setVisible(false);
            this.toplabelcover1.setVisible(false);
            this.removegymmem.setVisible(false);
            this.toplabelcoverRGC.setVisible(false);
            this.searchgymmem.setVisible(false);
            this.toplabelcoverSGC.setVisible(false);
            this.feepanelAF.setVisible(false);
            this.toplabelcoverAF.setVisible(false);
            this.replacepanelRI.setVisible(false);
            this.toplabelcoverRI.setVisible(false);
            this.monthlyfeepanelMF.setVisible(false);
            this.toplabelcoverMF.setVisible(false);
            exporttextET.setVisible(false);
            toplabelcoverET.setVisible(false);
            exportexcelEE.setVisible(false);
            toplabelcoverEE.setVisible(false);
            if(Screensize.getWidth()==1920)
            {
                this.removeuserctrl.setSize(275,65);
            this.changeusernamectrl.setSize(200,65);
            this.changepasswordctrl.setSize(200,65);
            this.adduserctrl.setSize(200,65);
            }
            else if(Screensize.getWidth()>=1536&&Screensize.getWidth()<1920)
            {
                this.removeuserctrl.setSize(275,65);
                this.changeusernamectrl.setSize(200,65);
                this.changepasswordctrl.setSize(200,65);
                this.adduserctrl.setSize(200,65);
            }
            else
            {
                this.removeuserctrl.setSize(175,40);
                this.changeusernamectrl.setSize(150,40);
                this.changepasswordctrl.setSize(150,40);
                this.adduserctrl.setSize(150,40);
            }
        }

        if(e.getSource()==changeusernamectrl)
        {
            this.remveusrpnlctl.setVisible(false);
            this.chngeusrnmectl.setVisible(true);
            this.chngepswctl.setVisible(false);
            this.adduserpnlctl.setVisible(false);
            this.menupanel.setVisible(false);
            this.p1.setVisible(false);
            this.p2.setVisible(false);
            this.p3.setVisible(false);
            this.addgymmem.setVisible(false);
            this.toplabelcover1.setVisible(false);
            this.removegymmem.setVisible(false);
            this.toplabelcoverRGC.setVisible(false);
            this.searchgymmem.setVisible(false);
            this.toplabelcoverSGC.setVisible(false);
            this.feepanelAF.setVisible(false);
            this.toplabelcoverAF.setVisible(false);
            this.replacepanelRI.setVisible(false);
            this.toplabelcoverRI.setVisible(false);
            this.monthlyfeepanelMF.setVisible(false);
            this.toplabelcoverMF.setVisible(false);
            exporttextET.setVisible(false);
            toplabelcoverET.setVisible(false);
            exportexcelEE.setVisible(false);
            toplabelcoverEE.setVisible(false);
            if(Screensize.getWidth()==1920)
            {
                this.removeuserctrl.setSize(200,65);
                this.changeusernamectrl.setSize(275,65);
                this.changepasswordctrl.setSize(200,65);
                this.adduserctrl.setSize(200,65);
            }
            else if(Screensize.getWidth()>=1536&&Screensize.getWidth()<1920)
            {
                this.removeuserctrl.setSize(200,65);
                this.changeusernamectrl.setSize(275,65);
                this.changepasswordctrl.setSize(200,65);
                this.adduserctrl.setSize(200,65);
            }
            else
            {
                this.removeuserctrl.setSize(150,40);
                this.changeusernamectrl.setSize(175,40);
                this.changepasswordctrl.setSize(150,40);
                this.adduserctrl.setSize(150,40);
            }
        }

        if(e.getSource()==changepasswordctrl)
        {
            this.remveusrpnlctl.setVisible(false);
            this.chngeusrnmectl.setVisible(false);
            this.chngepswctl.setVisible(true);
            this.adduserpnlctl.setVisible(false);
            this.menupanel.setVisible(false);
            this.p1.setVisible(false);
            this.p2.setVisible(false);
            this.p3.setVisible(false);
            this.addgymmem.setVisible(false);
            this.toplabelcover1.setVisible(false);
            this.removegymmem.setVisible(false);
            this.toplabelcoverRGC.setVisible(false);
            this.searchgymmem.setVisible(false);
            this.toplabelcoverSGC.setVisible(false);
            this.feepanelAF.setVisible(false);
            this.toplabelcoverAF.setVisible(false);
            this.replacepanelRI.setVisible(false);
            this.toplabelcoverRI.setVisible(false);
            this.monthlyfeepanelMF.setVisible(false);
            this.toplabelcoverMF.setVisible(false);
            exporttextET.setVisible(false);
            toplabelcoverET.setVisible(false);
            exportexcelEE.setVisible(false);
            toplabelcoverEE.setVisible(false);
            if(Screensize.getWidth()==1920)
            {
                this.removeuserctrl.setSize(200,65);
                this.changeusernamectrl.setSize(200,65);
                this.changepasswordctrl.setSize(275,65);
                this.adduserctrl.setSize(200,65);
            }
            else if(Screensize.getWidth()>=1536&&Screensize.getWidth()<1920)
            {
                this.removeuserctrl.setSize(200,65);
                this.changeusernamectrl.setSize(200,65);
                this.changepasswordctrl.setSize(275,65);
                this.adduserctrl.setSize(200,65);
            }
            else
            {
                this.removeuserctrl.setSize(150,40);
                this.changeusernamectrl.setSize(150,40);
                this.changepasswordctrl.setSize(175,40);
                this.adduserctrl.setSize(150,40);
            }
        }
        if(e.getSource()==home)
        {
            this.remveusrpnlctl.setVisible(false);
            this.chngeusrnmectl.setVisible(false);
            this.chngepswctl.setVisible(false);
            this.adduserpnlctl.setVisible(false);
            this.popgraphics.setVisible(false);
            this.Admincontrols.setVisible(false);
            this.musix.setVisible(false);
            this.musix2.setVisible(false);
            this.musix3.setVisible(false);
            this.videopanel.setVisible(false);
            this.videopanel2.setVisible(false);
            this.videopanel3.setVisible(false);
            this.addgymmem.setVisible(false);
            this.toplabelcover1.setVisible(false);
            this.removegymmem.setVisible(false);
            this.toplabelcoverRGC.setVisible(false);
            this.searchgymmem.setVisible(false);
            this.toplabelcoverSGC.setVisible(false);
            this.feepanelAF.setVisible(false);
            this.toplabelcoverAF.setVisible(false);
            this.replacepanelRI.setVisible(false);
            this.toplabelcoverRI.setVisible(false);
            this.monthlyfeepanelMF.setVisible(false);
            this.toplabelcoverMF.setVisible(false);
            exporttextET.setVisible(false);
            toplabelcoverET.setVisible(false);
            exportexcelEE.setVisible(false);
            toplabelcoverEE.setVisible(false);
            if(viewAdminControls.isVisible()){
                viewAdminControls.setEnabled(true);
            }

            if(this.loginuer==null){this.viewAdminControls.setVisible(true);}
            else if(super.loginuer.getUserType().equals("Admin")){this.viewAdminControls.setVisible(true);} 
            if(Screensize.getWidth()==1920)
            {
                menupanel.setBounds(200, 300, 1500, 700);
                p1.setBounds(880, 250, 150, 50);
                this.p1.setVisible(true);
            }
            else if(Screensize.getWidth()>=1536&&Screensize.getWidth()<1920)
            {
                menupanel.setBounds(150, 250, 1300, 500);
                p2.setVisible(true);
                menupanel.setLayout(null);
                addmem.setBounds(50, 50, 150, 110);
                removemem.setBounds(250, 50, 200, 110);
                searchmem.setBounds(500, 50, 200, 110);
                feemem.setBounds(1050, 50, 200, 110);
                calculatemonthbugjet.setBounds(10, 250, 230, 110);
                text.setBounds(770, 250, 200, 110);
                replacemem.setBounds(750, 50, 250, 110);
                excel.setBounds(1060, 250, 170, 110);
                music.setBounds(280, 250, 160, 110);
                video.setBounds(500, 250, 200, 110);
                addgymmem.setBounds(210, 240, 1120, 550);
                removegymmem.setBounds(210, 240, 1120, 550);
                searchgymmem.setBounds(210, 240, 1120, 550);
                feepanelAF.setBounds(210, 240, 1120, 550);


            }
            else
            {
                menupanel.setBounds(50, 180, 1200, 450);
                p3.setVisible(true);
                menupanel.setLayout(null);
                p3.setBounds(570, 150, 100, 30);
                addmem.setBounds(50, 50, 150, 110);
                removemem.setBounds(250, 50, 200, 110);
                searchmem.setBounds(500, 50, 200, 110);
                feemem.setBounds(1000, 50, 150, 110);
                calculatemonthbugjet.setBounds(10, 250, 230, 110);
                text.setBounds(770, 250, 200, 110);
                replacemem.setBounds(750, 50, 250, 110);
                excel.setBounds(1000, 250, 170, 110);
                music.setBounds(280, 250, 160, 110);
                video.setBounds(500, 250, 200, 110);
            }


            this.menupanel.setVisible(true);


            if(Screensize.getWidth()==1920)
            {
                this.removeuserctrl.setSize(200,65);
                this.changeusernamectrl.setSize(200,65);
                this.changepasswordctrl.setSize(200,65);
                this.adduserctrl.setSize(200,65);
            }
            else if(Screensize.getWidth()>=1536&&Screensize.getWidth()<1920)
            {
                this.removeuserctrl.setSize(200,65);
                this.changeusernamectrl.setSize(200,65);
                this.changepasswordctrl.setSize(200,65);
                this.adduserctrl.setSize(200,65);
            }
            else
            {
                this.removeuserctrl.setSize(150,40);
                this.changeusernamectrl.setSize(150,40);
                this.changepasswordctrl.setSize(150,40);
                this.adduserctrl.setSize(150,40);
            }
            

        }

        if(e.getSource()==logout)
        {
            menuframe.setVisible(false);
            super.userNamField.setText(null);
            super.passworField.setText(null);
            super.loginbtn.setEnabled(true);
            this.viewAdminControls.setVisible(false);
            this.Admincontrols.setVisible(false);
            super.loginframe.setVisible(true);


            //.....................Method to Stop Playing Music ...... When Logout........................................................
            javafx.application.Platform.runLater(new Runnable(){

                @Override
                public void run() {
                    controller Controller = fxmlLoader.<controller>getController();
                    Controller.stopmedia();
                    controller Controller1 = fxmlLoader2.<controller>getController();
                    Controller1.stopmedia();
                    controller Controller2 = fxmlLoader3.<controller>getController();
                    Controller2.stopmedia();
                    videocontroller videoController3 = fxmlLoadervideo.<videocontroller>getController();
                    videoController3.stopmedia();
                    videocontroller videoController4 = fxmlLoadervideo1536.<videocontroller>getController();
                    videoController4.stopmedia();
                    videocontroller videoController5 = fxmlLoadervideo1280.<videocontroller>getController();
                    videoController5.stopmedia();
                    
                }
                    

            });
            //.....................Method to Stop Playing Music ...... When Logout........................................................
           
            
        }
        
        if(e.getSource()==p1920)
        {
            if(Toolkit.getDefaultToolkit().getScreenSize().getWidth()==1920&&this.Screensize.getWidth()!=1920)
            {
                JDialog.setDefaultLookAndFeelDecorated(true);
                UIManager.put("OptionPane.messageFont", new Font("Goudy Old Style",1,16));
                UIManager.put("OptionPane.background", Color.BLACK);
                UIManager.put("OptionPane.titlePane.background", Color.BLACK);
                UIManager.put("Panel.background", Color.BLACK);
                UIManager.put("OptionPane.buttonFont", new Font("Goudy Old Style",0,14));
                UIManager.put("OptionPane.messageForeground", Color.GREEN);
                int response =JOptionPane.showConfirmDialog(menuframe, "Are You Sure, You Want to Change Graphics to 1920x1080p?", "Confirm", JOptionPane.YES_NO_OPTION);
                if(response==0)
                {
                    if(feepanelAF.isVisible()){backbtnAF.doClick();}
                    if(Admincontrols.isVisible()){closeAdminPanel.doClick();}
                    this.Screensize.setSize(1920, 1080);
                    menuframe.setVisible(false);
                    this.menuframe.setSize(Screensize);
                    this.setComponentSizes();
                    menuframe.setLocationRelativeTo(null);
                    menuframe.setVisible(true);
                    showAdminControls();
                    startupapp();


            }
            else{
                JDialog.setDefaultLookAndFeelDecorated(true);
                UIManager.put("OptionPane.messageFont", new Font("Goudy Old Style",1,16));
                UIManager.put("OptionPane.background", Color.BLACK);
                UIManager.put("OptionPane.titlePane.background", Color.BLACK);
                UIManager.put("Panel.background", Color.BLACK);
                UIManager.put("OptionPane.buttonFont", new Font("Goudy Old Style",0,14));
                UIManager.put("OptionPane.messageForeground", Color.GREEN);
                JOptionPane.showMessageDialog(menuframe, "Your Screen Size is Not Suitable for this Resolution", "Failed", JOptionPane.ERROR_MESSAGE);
            }
        }
            else{
                JDialog.setDefaultLookAndFeelDecorated(true);
                UIManager.put("OptionPane.messageFont", new Font("Goudy Old Style",1,16));
                UIManager.put("OptionPane.background", Color.BLACK);
                UIManager.put("OptionPane.titlePane.background", Color.BLACK);
                UIManager.put("Panel.background", Color.BLACK);
                UIManager.put("OptionPane.buttonFont", new Font("Goudy Old Style",0,14));
                UIManager.put("OptionPane.messageForeground", Color.GREEN);
                JOptionPane.showMessageDialog(menuframe, "Your Screen Size is Not Suitable for this Resolution", "Failed", JOptionPane.ERROR_MESSAGE);
            }
        }

        if(e.getSource()==p1536)
        {
            
            
            if(Toolkit.getDefaultToolkit().getScreenSize().getWidth()>=1536&&this.Screensize.getWidth()!=1536)
            {
                JDialog.setDefaultLookAndFeelDecorated(true);
                UIManager.put("OptionPane.messageFont", new Font("Goudy Old Style",1,16));
                UIManager.put("OptionPane.background", Color.BLACK);
                UIManager.put("OptionPane.titlePane.background", Color.BLACK);
                UIManager.put("Panel.background", Color.BLACK);
                UIManager.put("OptionPane.buttonFont", new Font("Goudy Old Style",0,14));
                UIManager.put("OptionPane.messageForeground", Color.GREEN);
                int response =JOptionPane.showConfirmDialog(menuframe, "Are You Sure, You Want to Change Graphics to 1536X864p?", "Confirm", JOptionPane.YES_NO_OPTION);
                if(response==0)
                {
                    if(feepanelAF.isVisible()){backbtnAF.doClick();}
                    this.Screensize=new Dimension(1536,864);
                    menuframe.setVisible(false);
                    this.menuframe.setSize(Screensize);
                    setComponentSizes();
                    homelblmenupanel.setVisible(false);
                    homelblmenupanel3.setVisible(false);

                    p1.setVisible(false);
                    p3.setVisible(false);
                    this.menuframe.setLocationRelativeTo(null);
                    menuframe.setVisible(true);


                    showAdminControls();
                    startupapp();

                    

                }


            }
            else{
                JDialog.setDefaultLookAndFeelDecorated(true);
                UIManager.put("OptionPane.messageFont", new Font("Goudy Old Style",1,16));
                UIManager.put("OptionPane.background", Color.BLACK);
                UIManager.put("OptionPane.titlePane.background", Color.BLACK);
                UIManager.put("Panel.background", Color.BLACK);
                UIManager.put("OptionPane.buttonFont", new Font("Goudy Old Style",0,14));
                UIManager.put("OptionPane.messageForeground", Color.GREEN);
                JOptionPane.showMessageDialog(menuframe, "Your Screen Size is Not Suitable for this Resolution", "Failed", JOptionPane.ERROR_MESSAGE);
            }
        }

        if(e.getSource()==p1280)
        {
            if(Toolkit.getDefaultToolkit().getScreenSize().getWidth()>=1280&&this.Screensize.getWidth()!=1280)
            {
                JDialog.setDefaultLookAndFeelDecorated(true);
                UIManager.put("OptionPane.messageFont", new Font("Goudy Old Style",1,16));
                UIManager.put("OptionPane.background", Color.BLACK);
                UIManager.put("OptionPane.titlePane.background", Color.BLACK);
                UIManager.put("Panel.background", Color.BLACK);
                UIManager.put("OptionPane.buttonFont", new Font("Goudy Old Style",0,14));
                UIManager.put("OptionPane.messageForeground", Color.GREEN);
                int response =JOptionPane.showConfirmDialog(menuframe, "Are You Sure, You Want to Change Graphics to 1280x720p?", "Confirm", JOptionPane.YES_NO_OPTION);
                if(response==0)
                {
                    if(feepanelAF.isVisible()){backbtnAF.doClick();}
                    this.Screensize.setSize(1280, 720);
                    menuframe.setVisible(false);
                    this.menuframe.setSize(Screensize);
                    setComponentSizes();
                    this.menuframe.setLocationRelativeTo(null);
                    showAdminControls();
                    menuframe.setVisible(true);
                    startupapp();


                }


            }
            else{
                JDialog.setDefaultLookAndFeelDecorated(true);
                UIManager.put("OptionPane.messageFont", new Font("Goudy Old Style",1,16));
                UIManager.put("OptionPane.background", Color.BLACK);
                UIManager.put("OptionPane.titlePane.background", Color.BLACK);
                UIManager.put("Panel.background", Color.BLACK);
                UIManager.put("OptionPane.buttonFont", new Font("Goudy Old Style",0,14));
                UIManager.put("OptionPane.messageForeground", Color.GREEN);
                JOptionPane.showMessageDialog(menuframe, "Your Screen Size is Not Suitable for this Resolution", "Failed", JOptionPane.ERROR_MESSAGE);
            }
        }

        if(e.getSource()==viewAdminControls)
        {
            if(Screensize.getWidth()==1920){
               this.menupanel.setBounds(300, 300, 1500, 700);
               menupanel.setLayout(null);
               menupanel.setLayout(null);
               excel.setBounds(1100, 260, 200, 200);            
               video.setBounds(800, 480, 200, 200);
               music.setBounds(500, 480, 200, 200);
               replacemem.setBounds(470, 260, 250, 200);
               text.setBounds(800, 260, 200, 200);
               calculatemonthbugjet.setBounds(170, 260, 250, 200);
               feemem.setBounds(1100, 50, 200, 200);
               searchmem.setBounds(800, 50, 200, 200);
               removemem.setBounds(500, 50, 200, 200);
               addmem.setBounds(200, 50, 200, 200);
                this.Admincontrols.setVisible(true);
                this.closeAdminPanel.setVisible(true);
                this.viewAdminControls.setVisible(false);
            }
           else if(Screensize.getWidth()>=1536&&Screensize.getWidth()<1920){
               this.menupanel.setLayout(new GridLayout(4,3,90,20));
               this.menupanel.setBounds(320, 250, 1000, 570);
                addgymmem.setBounds(310, 240, 1120, 550);
                removegymmem.setBounds(310, 240, 1120, 550);
                searchgymmem.setBounds(310, 240, 1120, 550);
                feepanelAF.setBounds(310, 240, 1120, 550);
                this.Admincontrols.setVisible(true);
                this.closeAdminPanel.setVisible(true);
                this.viewAdminControls.setVisible(false);

            }
            else
            {
                menupanel.setBounds(250, 180, 800, 450);
                menupanel.setLayout(new GridLayout(4,3,20,20));
                p3.setBounds(570, 150, 100, 30);

                addmem.setBounds(50, 50, 150, 110);
                addmem.setIcon(new ImageIcon(new ImageIcon(getClass().getResource("icons/addmem.png")).getImage().getScaledInstance(60, 60, Image.SCALE_SMOOTH)));
                addmem.setText("New Member");
                addmem.setFont(new Font("Cooper Black",0,18));
                
    
                
                removemem.setBounds(250, 50, 200, 110);
                removemem.setIcon(new ImageIcon(new ImageIcon(getClass().getResource("icons/removemem.png")).getImage().getScaledInstance(60, 60, Image.SCALE_SMOOTH)));
                removemem.setText("Remove Member");
                removemem.setFont(new Font("Cooper Black",0,18));
                
    
                
                searchmem.setBounds(500, 50, 200, 110);
                searchmem.setIcon(new ImageIcon(new ImageIcon(getClass().getResource("icons/searchmem.png")).getImage().getScaledInstance(60, 60, Image.SCALE_SMOOTH)));
                searchmem.setText("Search Member");
                searchmem.setFont(new Font("Cooper Black",0,18));
    
                
                feemem.setBounds(1000, 50, 150, 110);
                feemem.setIcon(new ImageIcon(new ImageIcon(getClass().getResource("icons/fee.png")).getImage().getScaledInstance(60, 60, Image.SCALE_SMOOTH)));
                feemem.setText("Add Fee");
                feemem.setFont(new Font("Cooper Black",0,18));
    
                
                calculatemonthbugjet.setBounds(10, 250, 230, 110);
                calculatemonthbugjet.setIcon(new ImageIcon(new ImageIcon(getClass().getResource("icons/monthly.png")).getImage().getScaledInstance(60, 60, Image.SCALE_SMOOTH)));
                calculatemonthbugjet.setText("Monthly Fee Record");
                calculatemonthbugjet.setFont(new Font("Cooper Black",0,18));
    
               
                text.setBounds(770, 250, 200, 110);
                text.setIcon(new ImageIcon(new ImageIcon(getClass().getResource("icons/txt.png")).getImage().getScaledInstance(60, 60, Image.SCALE_SMOOTH)));
                text.setText("Export Text");
                text.setFont(new Font("Cooper Black",0,18));
                
                replacemem.setBounds(750, 50, 250, 110);
                replacemem.setIcon(new ImageIcon(new ImageIcon(getClass().getResource("icons/replace.png")).getImage().getScaledInstance(60, 60, Image.SCALE_SMOOTH)));
                replacemem.setText("Change Information");
                replacemem.setFont(new Font("Cooper Black",0,18));
    
                
                excel.setBounds(1000, 250, 170, 110);
                excel.setIcon(new ImageIcon(new ImageIcon(getClass().getResource("icons/Excel_Icon.png")).getImage().getScaledInstance(60, 60, Image.SCALE_SMOOTH)));
                excel.setText("Export Excel");
                excel.setFont(new Font("Cooper Black",0,18));
    
                
                music.setBounds(280, 250, 160, 110);
                music.setIcon(new ImageIcon(new ImageIcon(getClass().getResource("icons/music.png")).getImage().getScaledInstance(60, 60, Image.SCALE_SMOOTH)));
                music.setText("Play Music");
                music.setFont(new Font("Cooper Black",0,18));
    
               
                video.setBounds(500, 250, 200, 110);
                video.setIcon(new ImageIcon(new ImageIcon(getClass().getResource("icons/video.png")).getImage().getScaledInstance(60, 60, Image.SCALE_SMOOTH)));
                video.setText("Play Mp4 Songs");
                video.setFont(new Font("Cooper Black",0,18));
                this.Admincontrols.setVisible(true);
                this.closeAdminPanel.setVisible(true);
                this.viewAdminControls.setVisible(false);

            }
            


            if(Admincontrols.isVisible()&&(Screensize.getWidth()==1920))
            {
                adduserpnlctl.setBounds(330, 230, (int)Screensize.getWidth()-380, 550);
                remveusrpnlctl.setBounds(330, 230,(int)Screensize.getWidth()-380, 550);
                chngepswctl.setBounds(330, 230,(int)Screensize.getWidth()-380, 550);
                chngeusrnmectl.setBounds(330, 230,(int)Screensize.getWidth()-380, 550);


                this.linelblAU.setSize(adduserpnlctl.getWidth(),5);

                gradientlblAU.setBounds(500, 2, 240, 40);
                gradientlbCP.setBounds(480, 2, 290, 40);
                gradientlbCUN.setBounds(480, 2, 290, 40);
                gradientlblRU.setBounds(480, 2, 290, 40);

            }
            else if(Admincontrols.isVisible()&&(Screensize.getWidth()==1536))
            {
                adduserpnlctl.setBounds(330, 230, (int)menuframe.getWidth()-365, 550);
                remveusrpnlctl.setBounds(330, 230,(int)Screensize.getWidth()-380, 550);
                chngepswctl.setBounds(330, 230,(int)Screensize.getWidth()-380, 550);
                chngeusrnmectl.setBounds(330, 230,(int)Screensize.getWidth()-380, 550);


                this.linelblAU.setSize(adduserpnlctl.getWidth(),5);

                gradientlblAU.setBounds(320, 2, 240, 40);

                gradientlbCP.setBounds(320, 2, 290, 40);
                gradientlbCUN.setBounds(320, 2, 290, 40);
                gradientlblRU.setBounds(320, 2, 290, 40);

            }
            else if(Admincontrols.isVisible()&&(Screensize.getWidth()<1536))
            {
                adduserpnlctl.setBounds(220, 150, (int)Screensize.getWidth()-250, 500);
                remveusrpnlctl.setBounds(220, 150, (int)Screensize.getWidth()-250, 500);

                chngepswctl.setBounds(220, 150,(int)Screensize.getWidth()-250, 500);
                chngeusrnmectl.setBounds(220, 150,(int)Screensize.getWidth()-250, 500);


                this.linelblAU.setSize(adduserpnlctl.getWidth(),5);

                gradientlblAU1.setBounds(320, 2, 180, 40);
                gradientlbCP1.setBounds(320, 2, 220, 40);
                gradientlbCUN1.setBounds(320, 2, 220, 40);
                gradientlblRU1.setBounds(320, 2, 220, 40);

            }
        }

        if(e.getSource()==closeAdminPanel)
        {
            this.Admincontrols.setVisible(false);
            this.viewAdminControls.setVisible(true);
            if(Screensize.getWidth()==1920){
                menupanel.setBounds(200, 300, 1500, 700);
                menupanel.setLayout(null);
                excel.setBounds(1100, 260, 200, 200);            
                video.setBounds(800, 480, 200, 200);
                music.setBounds(500, 480, 200, 200);
                replacemem.setBounds(470, 260, 250, 200);
                text.setBounds(800, 260, 200, 200);
                calculatemonthbugjet.setBounds(170, 260, 250, 200);
                feemem.setBounds(1100, 50, 200, 200);
                searchmem.setBounds(800, 50, 200, 200);
                removemem.setBounds(500, 50, 200, 200);
                addmem.setBounds(200, 50, 200, 200);
            }
            else if(Screensize.getWidth()>=1536&&Screensize.getWidth()<1920)
            {
                menupanel.setBounds(150, 250, 1300, 500);
                menupanel.setLayout(null);
                addmem.setBounds(50, 50, 150, 110);
                removemem.setBounds(250, 50, 200, 110);
                searchmem.setBounds(500, 50, 200, 110);
                feemem.setBounds(1050, 50, 200, 110);
                calculatemonthbugjet.setBounds(10, 250, 230, 110);
                text.setBounds(770, 250, 200, 110);
                replacemem.setBounds(750, 50, 250, 110);
                excel.setBounds(1060, 250, 170, 110);
                music.setBounds(280, 250, 160, 110);
                video.setBounds(500, 250, 200, 110);
                addgymmem.setBounds(210, 240, 1120, 550);
                removegymmem.setBounds(210, 240, 1120, 550);
                searchgymmem.setBounds(210, 240, 1120, 550);
                feepanelAF.setBounds(210, 240, 1120, 550);

            }

            else
            {
                menupanel.setBounds(50, 180, 1200, 450);
                menupanel.setLayout(null);
                p3.setBounds(570, 150, 100, 30);
                addmem.setBounds(50, 50, 150, 110);
                removemem.setBounds(250, 50, 200, 110);
                searchmem.setBounds(500, 50, 200, 110);
                feemem.setBounds(1000, 50, 150, 110);
                calculatemonthbugjet.setBounds(10, 250, 230, 110);
                text.setBounds(770, 250, 200, 110);
                replacemem.setBounds(750, 50, 250, 110);
                excel.setBounds(1000, 250, 170, 110);
                music.setBounds(280, 250, 160, 110);
                video.setBounds(500, 250, 200, 110);

            }

            if(!Admincontrols.isVisible()&&Screensize.getWidth()==1920)
            {
                this.adduserpnlctl.setBounds(this.menuframe.getX()+100, this.adduserpnlctl.getY(),this.menuframe.getWidth()-200 , 550);
                this.remveusrpnlctl.setBounds(this.menuframe.getX()+100, this.remveusrpnlctl.getY(),this.menuframe.getWidth()-200 , 550);
                this.chngepswctl.setBounds(this.menuframe.getX()+100, this.chngepswctl.getY(),this.menuframe.getWidth()-200 , 550);
                this.chngeusrnmectl.setBounds(this.menuframe.getX()+100, this.chngeusrnmectl.getY(),this.menuframe.getWidth()-200 , 550);
                this.linelblAU.setSize(adduserpnlctl.getWidth(),5);
                this.linelblRU.setSize(adduserpnlctl.getWidth(),5);
                this.linelblCUN.setSize(adduserpnlctl.getWidth(),5);
                this.linelblCP.setSize(adduserpnlctl.getWidth(),5);
                this.gradientlblAU.setLocation(this.menuframe.getX()+740, 2);
                this.gradientlbCP.setLocation(this.menuframe.getX()+720, 2);
                this.gradientlbCUN.setLocation(this.menuframe.getX()+720, 2);
                this.gradientlblRU.setLocation(this.menuframe.getX()+720, 2);
            }
            else if(!Admincontrols.isVisible()&&(Screensize.getWidth()>=1536&&Screensize.getWidth()<1920))
            {
                this.adduserpnlctl.setBounds(100, this.adduserpnlctl.getY(),this.menuframe.getWidth()-200 , 550);
                this.remveusrpnlctl.setBounds(100, this.remveusrpnlctl.getY(),this.menuframe.getWidth()-200 , 550);
                this.chngepswctl.setBounds(100, this.chngepswctl.getY(),this.menuframe.getWidth()-200 , 550);
                this.chngeusrnmectl.setBounds(100, this.chngeusrnmectl.getY(),this.menuframe.getWidth()-200 , 550);
                this.linelblAU.setSize(adduserpnlctl.getWidth(),5);
                this.linelblRU.setSize(adduserpnlctl.getWidth(),5);
                this.linelblCUN.setSize(adduserpnlctl.getWidth(),5);
                this.linelblCP.setSize(adduserpnlctl.getWidth(),5);
                this.gradientlblAU.setLocation(adduserpnlctl.getX()+450, 2);
                this.gradientlbCP.setLocation(remveusrpnlctl.getX()+430, 2);
                this.gradientlbCUN.setLocation(chngepswctl.getX()+430, 2);
                this.gradientlblRU.setLocation(chngeusrnmectl.getX()+430, 2);

            }
            else if(!Admincontrols.isVisible()&&(Screensize.getWidth()<1536))
            {
                this.adduserpnlctl.setBounds(100, this.adduserpnlctl.getY(),this.menuframe.getWidth()-200 , 500);
                this.remveusrpnlctl.setBounds(100, this.remveusrpnlctl.getY(),this.menuframe.getWidth()-200 , 500);
                this.chngepswctl.setBounds(100, this.chngepswctl.getY(),this.menuframe.getWidth()-200 , 500);
                this.chngeusrnmectl.setBounds(100, this.chngeusrnmectl.getY(),this.menuframe.getWidth()-200 , 500);
                this.linelblAU.setSize(adduserpnlctl.getWidth(),5);
                this.linelblRU.setSize(adduserpnlctl.getWidth(),5);
                this.linelblCUN.setSize(adduserpnlctl.getWidth(),5);
                this.linelblCP.setSize(adduserpnlctl.getWidth(),5);
                this.gradientlblAU1.setLocation(adduserpnlctl.getX()+330, 2);
                this.gradientlbCP1.setLocation(remveusrpnlctl.getX()+330, 2);
                this.gradientlbCUN1.setLocation(chngepswctl.getX()+330, 2);
                this.gradientlblRU1.setLocation(chngeusrnmectl.getX()+330, 2);

            }

            

        }
        
        if(e.getSource()==clearbtnAU)
        {
            this.userNamefldAU.setText(null);
            this.pswfldAU.setText(null);
            this.utypefldAU.setSelectedIndex(0);
            this.phonefldAU.setText(null);
            this.confirmfldAU.setSelected(false);
        }
        if(e.getSource()==cancelUbtnAU)
        {
            this.clearbtnAU.doClick();
            this.home.doClick();
        }
        if(e.getSource()==clearbtnRU)
        {
            this.userNamefldRU.setText(null);
            this.pswfldR.setText(null);
            this.confirmfldRU.setSelected(false);
            
        }
        if(e.getSource()==cancelUbtnRU)
        {
            this.clearbtnAU.doClick();
            this.home.doClick();
        }
        if(e.getSource()==clearbtnCUN)
        {
            this.userNamefldCUN.setText(null);
            this.pswfldRCUN.setText(null);
            this.newuserNamefldCUN.setText(null);
            this.confirmfldCUN.setSelected(false);
        }
        if(e.getSource()==cancelUbtnCUN)
        {
            this.clearbtnCUN.doClick();
            this.home.doClick();
        }

        if(e.getSource()==clearbtnCP)
        {
            this.userNamefldCP.setText(null);
            this.pwsfldCP.setText(null);
            this.newPassCP.setText(null);
            this.confirmfldCP.setSelected(false);
        }
        if(e.getSource()==cancelUbtnCP)
        {
            this.clearbtnCP.doClick();
            this.home.doClick();
        }

        if(e.getSource()==adduserButton)
        {
            if(confirmfldAU.isSelected())
            {
                String name=this.userNamefldAU.getText();
                String password=String.valueOf(this.pswfldAU.getPassword());
                String usertype=String.valueOf(this.utypefldAU.getSelectedItem());
                Long phone=Long.valueOf(this.phonefldAU.getText());

                Boolean result=super.insertuser(name, password, usertype, phone);
                if(result)
                {
                    setlookandfeelGreen();
                    JOptionPane.showMessageDialog(null, "User Successfully Added", "Result", JOptionPane.INFORMATION_MESSAGE);
                    this.adduserButton.setEnabled(false);
                    this.clearbtnAU.doClick();
                }
                
            }
        }

        if(e.getSource()==showAU)
        {
            this.pswfldAU.getEchoChar();
            this.pswfldAU.setEchoChar((char)0);
            this.showAU.setVisible(false);
            this.hideAU.setVisible(true);
        }
        if(e.getSource()==hideAU)
        {
            this.pswfldAU.setEchoChar('*');
            this.showAU.setVisible(true);
            this.hideAU.setVisible(false);

        }

        if(e.getSource()==showRU)
        {
            
            this.pswfldR.setEchoChar((char)0);
            this.showRU.setVisible(false);
            this.hideRU.setVisible(true);
        }
        if(e.getSource()==hideRU)
        {
            this.pswfldR.setEchoChar('*');
            this.showRU.setVisible(true);
            this.hideRU.setVisible(false);
        }

        if(e.getSource()==removeuserButton)
        {
            if(confirmfldRU.isSelected())
            {
                String user=userNamefldRU.getText();
                String pass=String.valueOf(pswfldR.getPassword());

                if(super.loginuer.getPassword().equals(pass))
                {
                   if(!loginuer.getUserName().equals(user))
                   {
                        Boolean result=removeuser(user);
                        if(result)
                        {
                            setlookandfeelGreen();
                            JOptionPane.showMessageDialog(null, "Successfully Removed User", "Result", JOptionPane.INFORMATION_MESSAGE);
                            clearbtnRU.doClick();
                            removeuserButton.setEnabled(false);
                        }
                   }
                   else
                   {
                        setlookandfeelRed();
                        JOptionPane.showMessageDialog(null, "Cannot Remove Yourself!!", "Result", JOptionPane.WARNING_MESSAGE);
                        clearbtnRU.doClick();
                        removeuserButton.setEnabled(false);


                   }
                }
                else
                {
                    setlookandfeelGreen();
                    JOptionPane.showMessageDialog(null, "Failed, Your Password Does Not Matched", "Result", JOptionPane.ERROR_MESSAGE);
                    removeuserButton.setEnabled(false);
                    clearbtnRU.doClick();


                }

            }
        }

        if(e.getSource()==hideCUN)
        {
            this.pswfldRCUN.setEchoChar('*');
            this.showCUN.setVisible(true);
            this.hideCUN.setVisible(false);
        }
        if(e.getSource()==showCUN)
        {
            this.pswfldRCUN.setEchoChar((char)0);
            this.showCUN.setVisible(false);
            this.hideCUN.setVisible(true);
        }

        if(e.getSource()==showCP)
        {
            this.pwsfldCP.setEchoChar((char)0);
            this.showCP.setVisible(false);
            this.hideCP.setVisible(true);
        }
        if(e.getSource()==showCP1)
        {
            this.newPassCP.setEchoChar((char)0);
            this.showCP1.setVisible(false);
            this.hideCP1.setVisible(true);
        }
        if(e.getSource()==hideCP)
        {
            this.pwsfldCP.setEchoChar(('*'));
            this.showCP.setVisible(true);
            this.hideCP.setVisible(false);
        }
        if(e.getSource()==hideCP1)
        {
            this.newPassCP.setEchoChar('*');
            this.showCP1.setVisible(true);
            this.hideCP1.setVisible(false);
        }

        if(e.getSource()==chguserNameButton)
        {
            if(confirmfldCUN.isSelected())
            {
                String Currentuser=this.userNamefldCUN.getText();
                String pass=String.valueOf(this.pswfldRCUN.getPassword());
                String newusername=this.newuserNamefldCUN.getText();

                if(pass.equals(loginuer.getPassword()))
                {
                    super.updateUserName(Currentuser, newusername);
                    this.clearbtnCUN.doClick();
                }
                else
                {
                    setlookandfeelGreen();
                    JOptionPane.showMessageDialog(null, "Failed, Either UserName or Password is Wrong.", "Result", 2);
                }
            }
        }

        if(e.getSource()==chgpassButton)
        {
            if(confirmfldCP.isSelected())
            {
                String user=this.userNamefldCP.getText();
                String currentpass=String.valueOf(this.pwsfldCP.getPassword());
                String newpass=String.valueOf(this.newPassCP.getPassword());

                super.upatePassword(user, currentpass, newpass);
                this.clearbtnCP.doClick();


            }
        }

        if(e.getSource()==music)
        {
            this.viewAdminControls.setVisible(false);
            this.Admincontrols.setVisible(false);
            this.menupanel.setVisible(false);
            this.p1.setVisible(false);
            this.p2.setVisible(false);
            this.p3.setVisible(false);
            if(Screensize.getWidth()==1920){this.musix.setVisible(true);this.musix2.setVisible(false);this.musix3.setVisible(false);}
            else if(Screensize.getWidth()>=1536&&Screensize.getWidth()<1920){this.musix2.setVisible(true);this.musix.setVisible(false);this.musix3.setVisible(false);}
            else{this.musix3.setVisible(true);this.musix2.setVisible(false);this.musix.setVisible(false);}
            this.musicpanel.setVisible(true);
            this.videopanel.setVisible(false);
        }

        if(e.getSource()==video)
        {
            this.viewAdminControls.setVisible(false);
            this.Admincontrols.setVisible(false);
            this.menupanel.setVisible(false);
            this.p1.setVisible(false);
            this.p2.setVisible(false);
            this.p3.setVisible(false);
            this.musix.setVisible(false);
            this.musicpanel.setVisible(false);
            if(Screensize.getWidth()==1920){this.videopanel.setVisible(true);this.videopanel2.setVisible(false);this.videopanel3.setVisible(false);}
            else if(Screensize.getWidth()>=1536&&Screensize.getWidth()<1920){this.videopanel2.setVisible(true);this.videopanel.setVisible(false);this.videopanel3.setVisible(false);}
            else{this.videopanel3.setVisible(true);this.videopanel.setVisible(false);this.videopanel2.setVisible(false);}

        }

        if(e.getSource()==addmem)
        {
            this.addgymmem.setVisible(true);
            if(Screensize.getWidth()==1920){
                this.addgymmem1.setVisible(true);
                if(addgymmem2!=null){this.addgymmem2.setVisible(false);}
                if(addgymmem3!=null){this.addgymmem3.setVisible(false);}
            }
            else if(Screensize.getWidth()>=1536&&Screensize.getWidth()<1920){
                if(addgymmem1!=null){this.addgymmem1.setVisible(false);}
                this.addgymmem2.setVisible(true);
                if(addgymmem3!=null){this.addgymmem3.setVisible(false);}
            }
            else
            {
                if(addgymmem1!=null){this.addgymmem1.setVisible(false);}
                if(addgymmem2!=null){this.addgymmem2.setVisible(false);}
                this.addgymmem3.setVisible(true);
            }
            this.toplabelcover1.setVisible(true);
            this.menupanel.setVisible(false);
            this.p1.setVisible(false);
            this.p2.setVisible(false);
            this.p3.setVisible(false);

        }

        if(e.getSource()==addimagebtnAGC){

            // javafx.application.Platform.(new Runnable(){
            javafx.application.Platform.runLater(new Runnable(){

                @Override
                public void run() {
                    FileChooser fileChooser=new FileChooser();
                    FileChooser.ExtensionFilter filter1=new ExtensionFilter("Picture files", ("*.png"),("*.jpeg"),("*.jpg"));
                    fileChooser.getExtensionFilters().add(filter1);
                    File file1=fileChooser.showOpenDialog(null);

                    SwingUtilities.invokeLater(new Runnable(){

                        @Override
                        public void run() {
                            if(file1!=null){
                                try {
                                    imageAGC=ImageIO.read(file1);
                                    imagefile=file1;
                                    int widthimg=(imageAGC.getWidth()*250)/imageAGC.getHeight();
                                    int heightimg=250;

                                    if(Screensize.getWidth()==1920){
                                        widthimg=(imageAGC.getWidth()*350)/imageAGC.getHeight();
                                        heightimg=350;
                                    }
                                    else if(Screensize.getWidth()>=1536&&Screensize.getWidth()<1920){
                                        widthimg=(imageAGC.getWidth()*300)/imageAGC.getHeight();
                                        heightimg=300;
                                    }
                                    else{
                                        widthimg=(imageAGC.getWidth()*250)/imageAGC.getHeight();
                                        heightimg=250;
                                    }
                                    imagelabelAGC.setIcon(new ImageIcon(ImageIO.read(file1).getScaledInstance(widthimg, heightimg, Image.SCALE_SMOOTH)));
                                } catch (IOException e) {
                                    showerror(e);
                                }

                            }
                            
                        }
                        
                    });
                   
                    
                }
                
            });
        
        
        
        }

        if(e.getSource()==addmemAGC)
        {

            
            if(confirmallfielsAGC.isSelected())
            {
                this.namevalueAGC=this.namememAGC.getText();
                String idfinal="CCG-"+String.valueOf(this.realid);
                this.cnicvalueAGC=this.cnicAGC.getText();
                boolean feecheckvalue=false;
                this.datevalueAGC=LocalDate.ofInstant(datechooserAG.getDate().toInstant(),ZoneId.systemDefault());
                if(feevalueAGC!=0){
                    feecheckvalue=true;
                }
                LocalDate dateofee=null;
                if(feecheckvalue){
                    dateofee=LocalDate.now();
                }
                InputStream image=null;

                if(imagefile!=null){
                    try {
                        image=new FileInputStream(imagefile);
                    } catch (FileNotFoundException e1) {
                        showerror(e1);
                    }
                }
                else{
                    try {
                        ByteArrayOutputStream os=new ByteArrayOutputStream();
                        BufferedImage image1=ImageIO.read(getClass().getResource("icons/deafultpic3.png"));
                        ImageIO.write(image1,"png",os);
                        image=new ByteArrayInputStream(os.toByteArray());

                    }catch (IOException ioException) {
                        ioException.printStackTrace();
                    }
                }




                if(enterdataintotable(this.nameofTabelenow, namevalueAGC, idfinal, phone, cnicvalueAGC, feevalueAGC, feecheckvalue, this.adminlbl.getText(), this.datevalueAGC,dateofee,image))
                {
                    setlookandfeelBlue();
                    JOptionPane.showMessageDialog(null, "Client Successfully Added!!!", "Result", 1);
                    this.namevalueAGC=null;
                    this.realid=0;
                    this.cnicvalueAGC=null;
                    this.feevalueAGC=0;
                    this.confirmallfielsAGC.setSelected(false);
                    this.datevalueAGC=null;
                    this.clearAGC.doClick();
                    try {
                        image.close();
                    } catch (IOException e1) {
                        showerror(e1);
                    }
                }
                else{
                    setlookandfeelBlue();
                    JOptionPane.showMessageDialog(null, "Failed To Process Data!!!", "Result", 1);
                }
                
            }

        }

        if(e.getSource()==clearAGC)
        {
            confirmallfielsAGC.setSelected(false);
            datechooserAG.setDate(new Date());
            namememAGC.setText(null);
            idAGC.setText(null);
            cnicAGC.setText(null);
            phoneAGC.setText(null);
            feeAGC.setText(null);
            feeAGC.setVisible(false);
            feeoptions.setSelectedIndex(0);
            feeoptions.setVisible(true);
            if(Screensize.getWidth()==1920){imagelabelAGC.setIcon(new ImageIcon(new ImageIcon(getClass().getResource("icons/deafultpic3.png")).getImage().getScaledInstance(350, 350, Image.SCALE_SMOOTH)));}
            else if(Screensize.getWidth()>=1536&&Screensize.getWidth()<1920){
                imagelabelAGC.setIcon(new ImageIcon(new ImageIcon(getClass().getResource("icons/deafultpic3.png")).getImage().getScaledInstance(300, 300, Image.SCALE_SMOOTH)));
            }
            else{
                imagelabelAGC.setIcon(new ImageIcon(new ImageIcon(getClass().getResource("icons/deafultpic3.png")).getImage().getScaledInstance(250, 250, Image.SCALE_SMOOTH)));
            }

        }
        
        if(e.getSource()==cancelAGC)
        {
            clearAGC.doClick();
            home.doClick();
        }

        if(e.getSource()==removemem)
        {
            removegymmem.setVisible(true);
            if(Screensize.getWidth()==1920){
                this.removegymclientlbl.setVisible(true);
                if(removegymclientlbl2!=null){this.removegymclientlbl2.setVisible(false);}
                if(removegymclientlbl3!=null){this.removegymclientlbl3.setVisible(false);}
            }
            else if(Screensize.getWidth()>=1536&&Screensize.getWidth()<1920){
                if(removegymclientlbl!=null){this.removegymclientlbl.setVisible(false);}
                this.removegymclientlbl2.setVisible(true);
                if(removegymclientlbl3!=null){this.removegymclientlbl3.setVisible(false);}
            }
            else
            {
                if(removegymclientlbl!=null){this.removegymclientlbl.setVisible(false);}
                if(removegymclientlbl2!=null){this.removegymclientlbl2.setVisible(false);}
                this.removegymclientlbl3.setVisible(true);
            }
            toplabelcoverRGC.setVisible(true);
            this.addgymmem.setVisible(false);
            if(addgymmem1!=null){this.addgymmem1.setVisible(false);}
            this.toplabelcover1.setVisible(false);
            this.menupanel.setVisible(false);
            this.p1.setVisible(false);
            this.p2.setVisible(false);
            this.p3.setVisible(false);
        }

        if(e.getSource()==searchRGC)
        {
            if(!namememRGC.getText().isEmpty()&&idmemRGC.getText().isEmpty()){
                String Nameofmemsrch;
                Nameofmemsrch=namememRGC.getText();
                if(!super.selectfromtable(nameofTabelenow).isEmpty()){
                    ArrayList<gymclient> names= selectfromtable(nameofTabelenow);
                    ArrayList<gymclient> matches=new ArrayList<>();
                    for (gymclient gymclient1 : names) {
                        if(gymclient1.getNameUser().toLowerCase().contains(Nameofmemsrch.toLowerCase()))
                        {
                            matches.add(gymclient1);
                        }
                    }
                    this.AllMatches=matches;
                    for(int i=0;i<matches.size();i++){                       
                        for(int j=i+1;j<matches.size();j++){
                            gymclient i1=matches.get(i);
                            gymclient j1=matches.get(j);
                            int id1=Integer.valueOf(matches.get(i).getIDuser().substring(4));
                            int id2=Integer.valueOf(matches.get(j).getIDuser().substring(4));
                            if(id1>id2){
                                matches.set(i, j1);
                                matches.set(j, i1);
                            }                                                    
                        
                        }
                        
                    }
                    Object[][] rows=new Object[matches.size()][7];

                    for(int i=0;i<matches.size();i++){
                        for(int j=0;j<7;j++){
                            if(j==0){
                                rows[i][j]=matches.get(i).getIDuser();
                            }
                            if(j==1){
                                rows[i][j]=matches.get(i).getNameUser();
                            }
                            if(j==2){
                                rows[i][j]=matches.get(i).getCnic();
                            }
                            if(j==3){
                                rows[i][j]="+92".concat(matches.get(i).getPhone().toString());
                            }
                            if(j==4){
                                rows[i][j]=matches.get(i).getFee();
                            }
                            if(j==5){
                                rows[i][j]=matches.get(i).getNameofAdmin();
                            }
                            if(j==6){
                                rows[i][j]=matches.get(i).getJoining();
                            }
                        }

                    }
                    
                    if(Screensize.getWidth()==1920){removetable.setFont(new Font("Goudy Old Style",0,24));}
                    else if(Screensize.getWidth()>=1536&&Screensize.getWidth()<1920){removetable.setFont(new Font("Goudy Old Style",0,20));}
                    else{removetable.setFont(new Font("Goudy Old Style",0,18));}


                    removetable.setModel(new DefaultTableModel(rows, headerRGC){
                        @Override
                        public boolean isCellEditable(int row, int column) {
                            return false;
                        }
                    });
                    removetable.setSelectionBackground(new Color(245, 170, 100));
                    removetable.setSelectionForeground(Color.black);
                    removetable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);


                    


                    if(Screensize.getWidth()==1920){

                        removetable.getColumnModel().getColumn(0).setPreferredWidth(130);
                        removetable.getColumnModel().getColumn(1).setPreferredWidth(200);
                        removetable.getColumnModel().getColumn(2).setPreferredWidth(240);
                        removetable.getColumnModel().getColumn(3).setPreferredWidth(200);
                        removetable.getColumnModel().getColumn(4).setPreferredWidth(100);
                        removetable.getColumnModel().getColumn(5).setPreferredWidth(200);
                        removetable.getColumnModel().getColumn(6).setPreferredWidth(115);
                    }
                    else if(Screensize.getWidth()>=1536&&Screensize.getWidth()<1920){

                        removetable.getColumnModel().getColumn(0).setPreferredWidth(90);
                        removetable.getColumnModel().getColumn(1).setPreferredWidth(170);
                        removetable.getColumnModel().getColumn(2).setPreferredWidth(210);
                        removetable.getColumnModel().getColumn(3).setPreferredWidth(170);
                        removetable.getColumnModel().getColumn(4).setPreferredWidth(100);
                        removetable.getColumnModel().getColumn(5).setPreferredWidth(180);
                        removetable.getColumnModel().getColumn(6).setPreferredWidth(105);
                    }
                    else{

                        removetable.getColumnModel().getColumn(0).setPreferredWidth(90);
                        removetable.getColumnModel().getColumn(1).setPreferredWidth(170);
                        removetable.getColumnModel().getColumn(2).setPreferredWidth(210);
                        removetable.getColumnModel().getColumn(3).setPreferredWidth(170);
                        removetable.getColumnModel().getColumn(4).setPreferredWidth(100);
                        removetable.getColumnModel().getColumn(5).setPreferredWidth(180);
                        removetable.getColumnModel().getColumn(6).setPreferredWidth(105);
                    }
                    

                    
                }
            }

            if(!idmemRGC.getText().isEmpty()&&namememRGC.getText().isEmpty()){
                String id=idmemRGC.getText();
                if(!super.selectfromtable(nameofTabelenow).isEmpty()){
                    ArrayList<gymclient> idsArrayList= selectfromtable(nameofTabelenow);
                    ArrayList<gymclient> matches=new ArrayList<>();
                    for (gymclient gymclient1 : idsArrayList) {
                        if(gymclient1.getIDuser().toLowerCase().contains(id.toLowerCase()))
                        {
                            matches.add(gymclient1);
                        }
                    }
                    for(int i=0;i<matches.size();i++){                       
                        for(int j=i+1;j<matches.size();j++){
                            gymclient i1=matches.get(i);
                            gymclient j1=matches.get(j);
                            int id1=Integer.valueOf(matches.get(i).getIDuser().substring(4));
                            int id2=Integer.valueOf(matches.get(j).getIDuser().substring(4));
                            if(id1>id2){
                                matches.set(i, j1);
                                matches.set(j, i1);
                            }                                                    
                        
                        }
                        
                    }
                    this.AllMatches=matches;
                    Object[][] rows=new Object[matches.size()][7];

                    for(int i=0;i<matches.size();i++){
                        for(int j=0;j<7;j++){
                            if(j==0){
                                rows[i][j]=matches.get(i).getIDuser();
                            }
                            if(j==1){
                                rows[i][j]=matches.get(i).getNameUser();
                            }
                            if(j==2){
                                rows[i][j]=matches.get(i).getCnic();
                            }
                            if(j==3){
                                rows[i][j]="+92".concat(matches.get(i).getPhone().toString());
                            }
                            if(j==4){
                                rows[i][j]=matches.get(i).getFee();
                            }
                            if(j==5){
                                rows[i][j]=matches.get(i).getNameofAdmin();
                            }
                            if(j==6){
                                rows[i][j]=matches.get(i).getJoining();
                            }
                        }

                    }
                    
                    if(Screensize.getWidth()==1920){removetable.setFont(new Font("Goudy Old Style",0,24));}
                    else if(Screensize.getWidth()>=1536&&Screensize.getWidth()<1920){removetable.setFont(new Font("Goudy Old Style",0,20));}
                    else{removetable.setFont(new Font("Goudy Old Style",0,18));}


                    removetable.setModel(new DefaultTableModel(rows, headerRGC){
                        @Override
                        public boolean isCellEditable(int row, int column) {
                            return false;
                        }
                    });
                    removetable.setSelectionBackground(new Color(235,207,47));
                    removetable.setSelectionForeground(Color.black);
                    removetable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
                    if(Screensize.getWidth()==1920){
                        if(matches.size()>9){
                            tablecontainerRGC.setSize(1210, 300);
                        }
                        else{
                            tablecontainerRGC.setSize(1190, 300);
                        }
                        removetable.getColumnModel().getColumn(0).setPreferredWidth(130);
                        removetable.getColumnModel().getColumn(1).setPreferredWidth(200);
                        removetable.getColumnModel().getColumn(2).setPreferredWidth(240);
                        removetable.getColumnModel().getColumn(3).setPreferredWidth(200);
                        removetable.getColumnModel().getColumn(4).setPreferredWidth(100);
                        removetable.getColumnModel().getColumn(5).setPreferredWidth(200);
                        removetable.getColumnModel().getColumn(6).setPreferredWidth(115);
                    }
                    else if(Screensize.getWidth()>=1536&&Screensize.getWidth()<1920){
                        if(matches.size()>9){
                            tablecontainerRGC.setSize(1050, 250);
                        }
                        else{
                            tablecontainerRGC.setSize(1030, 250);
                        }
                        removetable.getColumnModel().getColumn(0).setPreferredWidth(90);
                        removetable.getColumnModel().getColumn(1).setPreferredWidth(170);
                        removetable.getColumnModel().getColumn(2).setPreferredWidth(210);
                        removetable.getColumnModel().getColumn(3).setPreferredWidth(170);
                        removetable.getColumnModel().getColumn(4).setPreferredWidth(100);
                        removetable.getColumnModel().getColumn(5).setPreferredWidth(180);
                        removetable.getColumnModel().getColumn(6).setPreferredWidth(105);
                    }
                    else{
                        if(matches.size()>9){
                            tablecontainerRGC.setSize(820, 150);
                        }
                        else{
                            tablecontainerRGC.setSize(800, 150);
                        }
                        removetable.getColumnModel().getColumn(0).setPreferredWidth(90);
                        removetable.getColumnModel().getColumn(1).setPreferredWidth(170);
                        removetable.getColumnModel().getColumn(2).setPreferredWidth(210);
                        removetable.getColumnModel().getColumn(3).setPreferredWidth(170);
                        removetable.getColumnModel().getColumn(4).setPreferredWidth(100);
                        removetable.getColumnModel().getColumn(5).setPreferredWidth(180);
                        removetable.getColumnModel().getColumn(6).setPreferredWidth(105);
                    }
                }

            }

            if(!namememRGC.getText().isEmpty()&&!idmemRGC.getText().isEmpty()){
                String Nameofmemsrch=namememRGC.getText();
                String id=idmemRGC.getText();

                if(!super.selectfromtable(nameofTabelenow).isEmpty()){
                    ArrayList<gymclient> names= selectfromtable(nameofTabelenow);
                    ArrayList<gymclient> matches=new ArrayList<>();
                    for (gymclient gymclient1 : names) {
                        if((gymclient1.getNameUser().toLowerCase().contains(Nameofmemsrch.toLowerCase()))
                        &&(gymclient1.getIDuser().toLowerCase().contains(id.toLowerCase())))
                        {
                            matches.add(gymclient1);
                        }
                    }
                    for(int i=0;i<matches.size();i++){                       
                        for(int j=i+1;j<matches.size();j++){
                            gymclient i1=matches.get(i);
                            gymclient j1=matches.get(j);
                            int id1=Integer.valueOf(matches.get(i).getIDuser().substring(4));
                            int id2=Integer.valueOf(matches.get(j).getIDuser().substring(4));
                            if(id1>id2){
                                matches.set(i, j1);
                                matches.set(j, i1);
                            }                                                    
                        
                        }
                        
                    }
                    this.AllMatches=matches;
                    Object[][] rows=new Object[matches.size()][7];

                    for(int i=0;i<matches.size();i++){
                        for(int j=0;j<7;j++){
                            if(j==0){
                                rows[i][j]=matches.get(i).getIDuser();
                            }
                            if(j==1){
                                rows[i][j]=matches.get(i).getNameUser();
                            }
                            if(j==2){
                                rows[i][j]=matches.get(i).getCnic();
                            }
                            if(j==3){
                                rows[i][j]="+92".concat(matches.get(i).getPhone().toString());
                            }
                            if(j==4){
                                rows[i][j]=matches.get(i).getFee();
                            }
                            if(j==5){
                                rows[i][j]=matches.get(i).getNameofAdmin();
                            }
                            if(j==6){
                                rows[i][j]=matches.get(i).getJoining();
                            }
                        }

                    }
                    
                    if(Screensize.getWidth()==1920){removetable.setFont(new Font("Goudy Old Style",0,24));}
                    else if(Screensize.getWidth()>=1536&&Screensize.getWidth()<1920){removetable.setFont(new Font("Goudy Old Style",0,20));}
                    else{removetable.setFont(new Font("Goudy Old Style",0,18));}


                    removetable.setModel(new DefaultTableModel(rows, headerRGC){
                        @Override
                        public boolean isCellEditable(int row, int column) {
                            return false;
                        }
                    });
                    removetable.setSelectionBackground(new Color(235,207,47));
                    removetable.setSelectionForeground(Color.black);
                    removetable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
                    if(Screensize.getWidth()==1920){
                        if(matches.size()>9){
                            tablecontainerRGC.setSize(1210, 300);
                        }
                        else{
                            tablecontainerRGC.setSize(1190, 300);
                        }
                        removetable.getColumnModel().getColumn(0).setPreferredWidth(130);
                        removetable.getColumnModel().getColumn(1).setPreferredWidth(200);
                        removetable.getColumnModel().getColumn(2).setPreferredWidth(240);
                        removetable.getColumnModel().getColumn(3).setPreferredWidth(200);
                        removetable.getColumnModel().getColumn(4).setPreferredWidth(100);
                        removetable.getColumnModel().getColumn(5).setPreferredWidth(200);
                        removetable.getColumnModel().getColumn(6).setPreferredWidth(115);
                    }
                    else if(Screensize.getWidth()>=1536&&Screensize.getWidth()<1920){
                        if(matches.size()>9){
                            tablecontainerRGC.setSize(1050, 250);
                        }
                        else{
                            tablecontainerRGC.setSize(1030, 250);
                        }
                        removetable.getColumnModel().getColumn(0).setPreferredWidth(90);
                        removetable.getColumnModel().getColumn(1).setPreferredWidth(170);
                        removetable.getColumnModel().getColumn(2).setPreferredWidth(210);
                        removetable.getColumnModel().getColumn(3).setPreferredWidth(170);
                        removetable.getColumnModel().getColumn(4).setPreferredWidth(100);
                        removetable.getColumnModel().getColumn(5).setPreferredWidth(180);
                        removetable.getColumnModel().getColumn(6).setPreferredWidth(105);
                    }
                    else{
                        if(matches.size()>9){
                            tablecontainerRGC.setSize(820, 150);
                        }
                        else{
                            tablecontainerRGC.setSize(800, 150);
                        }
                        removetable.getColumnModel().getColumn(0).setPreferredWidth(90);
                        removetable.getColumnModel().getColumn(1).setPreferredWidth(170);
                        removetable.getColumnModel().getColumn(2).setPreferredWidth(210);
                        removetable.getColumnModel().getColumn(3).setPreferredWidth(170);
                        removetable.getColumnModel().getColumn(4).setPreferredWidth(100);
                        removetable.getColumnModel().getColumn(5).setPreferredWidth(180);
                        removetable.getColumnModel().getColumn(6).setPreferredWidth(105);
                    }

                }    

            }

        }

        if(e.getSource()==clearRGC){

            namememRGC.setText(null);
            idmemRGC.setText(null);

            removetable.setModel(new DefaultTableModel(null,headerRGC));

            if(Screensize.getWidth()==1920){
               
                removetable.getColumnModel().getColumn(0).setPreferredWidth(130);
                removetable.getColumnModel().getColumn(1).setPreferredWidth(200);
                removetable.getColumnModel().getColumn(2).setPreferredWidth(250);
                removetable.getColumnModel().getColumn(3).setPreferredWidth(200);
                removetable.getColumnModel().getColumn(4).setPreferredWidth(100);
                removetable.getColumnModel().getColumn(5).setPreferredWidth(200);
                removetable.getColumnModel().getColumn(6).setPreferredWidth(105);
            }
            else if(Screensize.getWidth()>=1536&&Screensize.getWidth()<1920){
                
                removetable.getColumnModel().getColumn(0).setPreferredWidth(90);
                removetable.getColumnModel().getColumn(1).setPreferredWidth(170);
                removetable.getColumnModel().getColumn(2).setPreferredWidth(210);
                removetable.getColumnModel().getColumn(3).setPreferredWidth(170);
                removetable.getColumnModel().getColumn(4).setPreferredWidth(100);
                removetable.getColumnModel().getColumn(5).setPreferredWidth(180);
                removetable.getColumnModel().getColumn(6).setPreferredWidth(105);
            }
            else{
                
                removetable.getColumnModel().getColumn(0).setPreferredWidth(90);
                removetable.getColumnModel().getColumn(1).setPreferredWidth(170);
                removetable.getColumnModel().getColumn(2).setPreferredWidth(210);
                removetable.getColumnModel().getColumn(3).setPreferredWidth(170);
                removetable.getColumnModel().getColumn(4).setPreferredWidth(100);
                removetable.getColumnModel().getColumn(5).setPreferredWidth(180);
                removetable.getColumnModel().getColumn(6).setPreferredWidth(105);
            }
        }

        if(e.getSource()==removememRGC){

            if(removetable.getRowCount()>0){
                int[] selescted=removetable.getSelectedRows();
                ArrayList<String> Namestoremove=new ArrayList<>();
                if(!AllMatches.isEmpty()&&selescted.length>0){

                    for(int i=0;i<selescted.length;i++){
                        Namestoremove.add(AllMatches.get(selescted[i]).getNameUser());
                    }

                    for (String name1 : Namestoremove) {
                        setlookandfeelBlue();
                        int response=JOptionPane.showConfirmDialog(null, "Please Confirm to remove Member "+name1, "Confirmation", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                        
                        if(response==0){
                            if(super.removeuserfromdata(name1, nameofTabelenow)){
                                setlookandfeelGreen();
                                JOptionPane.showMessageDialog(null, "Successfully Removed!!! Member "+name1, "Result", JOptionPane.INFORMATION_MESSAGE);
                            }
                        }
                        searchRGC.doClick();
                    }

                }

            }

        }

        if(e.getSource()==searchmem){
            if(Screensize.getWidth()==1920){
                this.searchgymclientlbl.setVisible(true);
                if(searchgymclientlbl2!=null){this.searchgymclientlbl2.setVisible(false);}
                if(searchgymclientlbl3!=null){this.searchgymclientlbl3.setVisible(false);}
            }
            else if(Screensize.getWidth()>=1536&&Screensize.getWidth()<1920){
                if(searchgymclientlbl!=null){this.searchgymclientlbl.setVisible(false);}
                this.searchgymclientlbl2.setVisible(true);
                if(searchgymclientlbl3!=null){this.searchgymclientlbl3.setVisible(false);}
            }
            else
            {
                if(searchgymclientlbl!=null){this.searchgymclientlbl.setVisible(false);}
                if(searchgymclientlbl2!=null){this.searchgymclientlbl2.setVisible(false);}
                this.searchgymclientlbl3.setVisible(true);
            }

            searchgymmem.setVisible(true);
            toplabelcoverSGC.setVisible(true);
            removegymmem.setVisible(false);
            toplabelcoverRGC.setVisible(false);
            this.addgymmem.setVisible(false);
            if(addgymmem1!=null){this.addgymmem1.setVisible(false);}
            this.toplabelcover1.setVisible(false);
            this.menupanel.setVisible(false);
            this.p1.setVisible(false);
            this.p2.setVisible(false);
            this.p3.setVisible(false);
        }

        if(e.getSource()==clearSGC){
            searchlblSGC.setFont(new Font("Cooper Black",0,24));
            searchlblSGC.setText("Search :");
            namefldSGC.setText(null);
            idfldSGC.setText(null);
            cnicfldSGC.setText(null);
            nameofAdminfldSGC.setText(null);
            phonefldSGC.setText(null);
            searchoptionsSGC.setSelectedIndex(0);
            searchoptionsSGC.setVisible(true);
            idfldSGC.setVisible(false);
            namefldSGC.setVisible(false);
            cnicfldSGC.setVisible(false);
            nameofAdminfldSGC.setVisible(false);
            phonefldSGC.setVisible(false);
            datechooserSGC.setDate(new Date());
            datechooserSGC.setVisible(false);
            searchtable.setModel(new DefaultTableModel(null,headerRGC));

            if(Screensize.getWidth()==1920){
               
                searchtable.getColumnModel().getColumn(0).setPreferredWidth(130);
                searchtable.getColumnModel().getColumn(1).setPreferredWidth(200);
                searchtable.getColumnModel().getColumn(2).setPreferredWidth(240);
                searchtable.getColumnModel().getColumn(3).setPreferredWidth(200);
                searchtable.getColumnModel().getColumn(4).setPreferredWidth(100);
                searchtable.getColumnModel().getColumn(5).setPreferredWidth(200);
                searchtable.getColumnModel().getColumn(6).setPreferredWidth(115);
            }
            else if(Screensize.getWidth()>=1536&&Screensize.getWidth()<1920){
                
                searchtable.getColumnModel().getColumn(0).setPreferredWidth(90);
                searchtable.getColumnModel().getColumn(1).setPreferredWidth(170);
                searchtable.getColumnModel().getColumn(2).setPreferredWidth(210);
                searchtable.getColumnModel().getColumn(3).setPreferredWidth(170);
                searchtable.getColumnModel().getColumn(4).setPreferredWidth(100);
                searchtable.getColumnModel().getColumn(5).setPreferredWidth(180);
                searchtable.getColumnModel().getColumn(6).setPreferredWidth(105);
            }
            else{
                
                searchtable.getColumnModel().getColumn(0).setPreferredWidth(90);
                searchtable.getColumnModel().getColumn(1).setPreferredWidth(170);
                searchtable.getColumnModel().getColumn(2).setPreferredWidth(210);
                searchtable.getColumnModel().getColumn(3).setPreferredWidth(170);
                searchtable.getColumnModel().getColumn(4).setPreferredWidth(100);
                searchtable.getColumnModel().getColumn(5).setPreferredWidth(180);
                searchtable.getColumnModel().getColumn(6).setPreferredWidth(105);
            }


            
        }

        if(e.getSource()==searchSGC){

            if(!namefldSGC.getText().isEmpty()){
                String Nameofmemsrch;
                Nameofmemsrch=namefldSGC.getText();
                if(!super.selectfromtable(nameofTabelenow).isEmpty()){
                    ArrayList<gymclient> names= selectfromtable(nameofTabelenow);
                    ArrayList<gymclient> matches=new ArrayList<>();
                    for (gymclient gymclient1 : names) {
                        if(gymclient1.getNameUser().toLowerCase().contains(Nameofmemsrch.toLowerCase()))
                        {
                            matches.add(gymclient1);
                        }
                    }
                    for(int i=0;i<matches.size();i++){                       
                        for(int j=i+1;j<matches.size();j++){
                            gymclient i1=matches.get(i);
                            gymclient j1=matches.get(j);
                            int id1=Integer.valueOf(matches.get(i).getIDuser().substring(4));
                            int id2=Integer.valueOf(matches.get(j).getIDuser().substring(4));
                            if(id1>id2){
                                matches.set(i, j1);
                                matches.set(j, i1);
                            }                                                    
                        
                        }
                        
                    }

                    Object[][] rows=new Object[matches.size()][7];

                    for(int i=0;i<matches.size();i++){
                        for(int j=0;j<7;j++){
                            if(j==0){
                                rows[i][j]=matches.get(i).getIDuser();
                            }
                            if(j==1){
                                rows[i][j]=matches.get(i).getNameUser();
                            }
                            if(j==2){
                                rows[i][j]=matches.get(i).getCnic();
                            }
                            if(j==3){
                                rows[i][j]="+92".concat(matches.get(i).getPhone().toString());
                            }
                            if(j==4){
                                rows[i][j]=matches.get(i).getFee();
                            }
                            if(j==5){
                                rows[i][j]=matches.get(i).getNameofAdmin();
                            }
                            if(j==6){
                                rows[i][j]=matches.get(i).getJoining();
                            }
                        }

                    }
                    
                    if(Screensize.getWidth()==1920){searchtable.setFont(new Font("Goudy Old Style",0,22));}
                    else if(Screensize.getWidth()>=1536&&Screensize.getWidth()<1920){searchtable.setFont(new Font("Goudy Old Style",0,20));}
                    else{searchtable.setFont(new Font("Goudy Old Style",0,18));}


                    searchtable.setModel(new DefaultTableModel(rows, headerRGC){
                        @Override
                        public boolean isCellEditable(int row, int column) {
                            return false;
                        }
                    });
                    searchtable.setSelectionBackground(new Color(245, 170, 100));
                    searchtable.setSelectionForeground(Color.black);
                    searchtable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

                    if(Screensize.getWidth()==1920){
                        if(matches.size()>14){
                            tablecontainerSGC.setSize(1210, 450);
                        }
                        else{
                            tablecontainerSGC.setSize(1190, 450);
                        }
                        searchtable.getColumnModel().getColumn(0).setPreferredWidth(130);
                        searchtable.getColumnModel().getColumn(1).setPreferredWidth(200);
                        searchtable.getColumnModel().getColumn(2).setPreferredWidth(240);
                        searchtable.getColumnModel().getColumn(3).setPreferredWidth(200);
                        searchtable.getColumnModel().getColumn(4).setPreferredWidth(100);
                        searchtable.getColumnModel().getColumn(5).setPreferredWidth(200);
                        searchtable.getColumnModel().getColumn(6).setPreferredWidth(115);
                    }
                    else if(Screensize.getWidth()>=1536&&Screensize.getWidth()<1920){
                        if(matches.size()>14){
                            tablecontainerSGC.setSize(1055, 350);
                        }
                        else{
                            tablecontainerSGC.setSize(1030, 350);
                        }
                        searchtable.getColumnModel().getColumn(0).setPreferredWidth(90);
                        searchtable.getColumnModel().getColumn(1).setPreferredWidth(170);
                        searchtable.getColumnModel().getColumn(2).setPreferredWidth(210);
                        searchtable.getColumnModel().getColumn(3).setPreferredWidth(170);
                        searchtable.getColumnModel().getColumn(4).setPreferredWidth(100);
                        searchtable.getColumnModel().getColumn(5).setPreferredWidth(180);
                        searchtable.getColumnModel().getColumn(6).setPreferredWidth(105);
                    }
                    else{
                        if(matches.size()>9){
                            tablecontainerSGC.setSize(820, 290);
                        }
                        else{
                            tablecontainerSGC.setSize(800, 290);
                        }
                        searchtable.getColumnModel().getColumn(0).setPreferredWidth(90);
                        searchtable.getColumnModel().getColumn(1).setPreferredWidth(170);
                        searchtable.getColumnModel().getColumn(2).setPreferredWidth(210);
                        searchtable.getColumnModel().getColumn(3).setPreferredWidth(170);
                        searchtable.getColumnModel().getColumn(4).setPreferredWidth(100);
                        searchtable.getColumnModel().getColumn(5).setPreferredWidth(180);
                        searchtable.getColumnModel().getColumn(6).setPreferredWidth(105);
                    }
                    
                    searchtable();
                    
                    
                }
            }
        
            if(!idfldSGC.getText().isEmpty()){
                String idmem;
                idmem=idfldSGC.getText();
                if(!super.selectfromtable(nameofTabelenow).isEmpty()){
                    ArrayList<gymclient> ids= selectfromtable(nameofTabelenow);
                    ArrayList<gymclient> matches=new ArrayList<>();
                    for (gymclient gymclient1 : ids) {
                        if(gymclient1.getIDuser().toLowerCase().contains(idmem.toLowerCase()))
                        {
                            matches.add(gymclient1);
                        }
                    }

                    for(int i=0;i<matches.size();i++){                       
                        for(int j=i+1;j<matches.size();j++){
                            gymclient i1=matches.get(i);
                            gymclient j1=matches.get(j);
                            int id1=Integer.valueOf(matches.get(i).getIDuser().substring(4));
                            int id2=Integer.valueOf(matches.get(j).getIDuser().substring(4));
                            if(id1>id2){
                                matches.set(i, j1);
                                matches.set(j, i1);
                            }                                                    
                        
                        }
                        
                    }

                    Object[][] rows=new Object[matches.size()][7];

                    for(int i=0;i<matches.size();i++){
                        for(int j=0;j<7;j++){
                            if(j==0){
                                rows[i][j]=matches.get(i).getIDuser();
                            }
                            if(j==1){
                                rows[i][j]=matches.get(i).getNameUser();
                            }
                            if(j==2){
                                rows[i][j]=matches.get(i).getCnic();
                            }
                            if(j==3){
                                rows[i][j]="+92".concat(matches.get(i).getPhone().toString());
                            }
                            if(j==4){
                                rows[i][j]=matches.get(i).getFee();
                            }
                            if(j==5){
                                rows[i][j]=matches.get(i).getNameofAdmin();
                            }
                            if(j==6){
                                rows[i][j]=matches.get(i).getJoining();
                            }
                        }

                    }
                    
                    if(Screensize.getWidth()==1920){searchtable.setFont(new Font("Goudy Old Style",0,22));}
                    else if(Screensize.getWidth()>=1536&&Screensize.getWidth()<1920){searchtable.setFont(new Font("Goudy Old Style",0,20));}
                    else{searchtable.setFont(new Font("Goudy Old Style",0,18));}


                    searchtable.setModel(new DefaultTableModel(rows, headerRGC){
                        @Override
                        public boolean isCellEditable(int row, int column) {
                            return false;
                        }
                    });
                    searchtable.setSelectionBackground(new Color(245, 170, 100));
                    searchtable.setSelectionForeground(Color.black);
                    searchtable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

                    


                    if(Screensize.getWidth()==1920){
                        if(matches.size()>14){
                            tablecontainerSGC.setSize(1210, 450);
                        }
                        else{
                            tablecontainerSGC.setSize(1190, 450);
                        }
                        searchtable.getColumnModel().getColumn(0).setPreferredWidth(130);
                        searchtable.getColumnModel().getColumn(1).setPreferredWidth(200);
                        searchtable.getColumnModel().getColumn(2).setPreferredWidth(240);
                        searchtable.getColumnModel().getColumn(3).setPreferredWidth(200);
                        searchtable.getColumnModel().getColumn(4).setPreferredWidth(100);
                        searchtable.getColumnModel().getColumn(5).setPreferredWidth(200);
                        searchtable.getColumnModel().getColumn(6).setPreferredWidth(115);
                    }
                    else if(Screensize.getWidth()>=1536&&Screensize.getWidth()<1920){
                        if(matches.size()>14){
                            tablecontainerSGC.setSize(1055, 350);
                        }
                        else{
                            tablecontainerSGC.setSize(1030, 350);
                        }
                        searchtable.getColumnModel().getColumn(0).setPreferredWidth(90);
                        searchtable.getColumnModel().getColumn(1).setPreferredWidth(170);
                        searchtable.getColumnModel().getColumn(2).setPreferredWidth(210);
                        searchtable.getColumnModel().getColumn(3).setPreferredWidth(170);
                        searchtable.getColumnModel().getColumn(4).setPreferredWidth(100);
                        searchtable.getColumnModel().getColumn(5).setPreferredWidth(180);
                        searchtable.getColumnModel().getColumn(6).setPreferredWidth(105);
                    }
                    else{
                        if(matches.size()>9){
                            tablecontainerSGC.setSize(820, 290);
                        }
                        else{
                            tablecontainerSGC.setSize(800, 290);
                        }
                        searchtable.getColumnModel().getColumn(0).setPreferredWidth(90);
                        searchtable.getColumnModel().getColumn(1).setPreferredWidth(170);
                        searchtable.getColumnModel().getColumn(2).setPreferredWidth(210);
                        searchtable.getColumnModel().getColumn(3).setPreferredWidth(170);
                        searchtable.getColumnModel().getColumn(4).setPreferredWidth(100);
                        searchtable.getColumnModel().getColumn(5).setPreferredWidth(180);
                        searchtable.getColumnModel().getColumn(6).setPreferredWidth(105);
                    }
                    
                    searchtable();

                    
                }
            }
        
            if(!cnicfldSGC.getText().isEmpty()){
                String cnicmem;
                cnicmem=cnicfldSGC.getText();
                if(!super.selectfromtable(nameofTabelenow).isEmpty()){
                    ArrayList<gymclient> ids= selectfromtable(nameofTabelenow);
                    ArrayList<gymclient> matches=new ArrayList<>();
                    for (gymclient gymclient1 : ids) {
                        if(gymclient1.getCnic().toLowerCase().contains(cnicmem.toLowerCase()))
                        {
                            matches.add(gymclient1);
                        }
                    }
                    for(int i=0;i<matches.size();i++){                       
                        for(int j=i+1;j<matches.size();j++){
                            gymclient i1=matches.get(i);
                            gymclient j1=matches.get(j);
                            int id1=Integer.valueOf(matches.get(i).getIDuser().substring(4));
                            int id2=Integer.valueOf(matches.get(j).getIDuser().substring(4));
                            if(id1>id2){
                                matches.set(i, j1);
                                matches.set(j, i1);
                            }                                                    
                        
                        }
                        
                    }
                    Object[][] rows=new Object[matches.size()][7];

                    for(int i=0;i<matches.size();i++){
                        for(int j=0;j<7;j++){
                            if(j==0){
                                rows[i][j]=matches.get(i).getIDuser();
                            }
                            if(j==1){
                                rows[i][j]=matches.get(i).getNameUser();
                            }
                            if(j==2){
                                rows[i][j]=matches.get(i).getCnic();
                            }
                            if(j==3){
                                rows[i][j]="+92".concat(matches.get(i).getPhone().toString());
                            }
                            if(j==4){
                                rows[i][j]=matches.get(i).getFee();
                            }
                            if(j==5){
                                rows[i][j]=matches.get(i).getNameofAdmin();
                            }
                            if(j==6){
                                rows[i][j]=matches.get(i).getJoining();
                            }
                        }

                    }
                    
                    if(Screensize.getWidth()==1920){searchtable.setFont(new Font("Goudy Old Style",0,22));}
                    else if(Screensize.getWidth()>=1536&&Screensize.getWidth()<1920){searchtable.setFont(new Font("Goudy Old Style",0,20));}
                    else{searchtable.setFont(new Font("Goudy Old Style",0,18));}


                    searchtable.setModel(new DefaultTableModel(rows, headerRGC){
                        @Override
                        public boolean isCellEditable(int row, int column) {
                            return false;
                        }
                    });
                    searchtable.setSelectionBackground(new Color(245, 170, 100));
                    searchtable.setSelectionForeground(Color.black);
                    searchtable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

                    


                    if(Screensize.getWidth()==1920){
                        if(matches.size()>14){
                            tablecontainerSGC.setSize(1210, 450);
                        }
                        else{
                            tablecontainerSGC.setSize(1190, 450);
                        }
                        searchtable.getColumnModel().getColumn(0).setPreferredWidth(130);
                        searchtable.getColumnModel().getColumn(1).setPreferredWidth(200);
                        searchtable.getColumnModel().getColumn(2).setPreferredWidth(240);
                        searchtable.getColumnModel().getColumn(3).setPreferredWidth(200);
                        searchtable.getColumnModel().getColumn(4).setPreferredWidth(100);
                        searchtable.getColumnModel().getColumn(5).setPreferredWidth(200);
                        searchtable.getColumnModel().getColumn(6).setPreferredWidth(115);
                    }
                    else if(Screensize.getWidth()>=1536&&Screensize.getWidth()<1920){
                        if(matches.size()>14){
                            tablecontainerSGC.setSize(1055, 350);
                        }
                        else{
                            tablecontainerSGC.setSize(1030, 350);
                        }
                        searchtable.getColumnModel().getColumn(0).setPreferredWidth(90);
                        searchtable.getColumnModel().getColumn(1).setPreferredWidth(170);
                        searchtable.getColumnModel().getColumn(2).setPreferredWidth(210);
                        searchtable.getColumnModel().getColumn(3).setPreferredWidth(170);
                        searchtable.getColumnModel().getColumn(4).setPreferredWidth(100);
                        searchtable.getColumnModel().getColumn(5).setPreferredWidth(180);
                        searchtable.getColumnModel().getColumn(6).setPreferredWidth(105);
                    }
                    else{
                        if(matches.size()>9){
                            tablecontainerSGC.setSize(820, 290);
                        }
                        else{
                            tablecontainerSGC.setSize(800, 290);
                        }
                        searchtable.getColumnModel().getColumn(0).setPreferredWidth(90);
                        searchtable.getColumnModel().getColumn(1).setPreferredWidth(170);
                        searchtable.getColumnModel().getColumn(2).setPreferredWidth(210);
                        searchtable.getColumnModel().getColumn(3).setPreferredWidth(170);
                        searchtable.getColumnModel().getColumn(4).setPreferredWidth(100);
                        searchtable.getColumnModel().getColumn(5).setPreferredWidth(180);
                        searchtable.getColumnModel().getColumn(6).setPreferredWidth(105);
                    }
                    
                    searchtable();
                    
                }
            }

            if(!nameofAdminfldSGC.getText().isEmpty()){
                String nameofadminmem;
                nameofadminmem=nameofAdminfldSGC.getText();
                if(!super.selectfromtable(nameofTabelenow).isEmpty()){
                    ArrayList<gymclient> ids= selectfromtable(nameofTabelenow);
                    ArrayList<gymclient> matches=new ArrayList<>();
                    for (gymclient gymclient1 : ids) {
                        if(gymclient1.getNameofAdmin().toLowerCase().contains(nameofadminmem.toLowerCase()))
                        {
                            matches.add(gymclient1);
                        }
                    }

                    for(int i=0;i<matches.size();i++){                       
                        for(int j=i+1;j<matches.size();j++){
                            gymclient i1=matches.get(i);
                            gymclient j1=matches.get(j);
                            int id1=Integer.valueOf(matches.get(i).getIDuser().substring(4));
                            int id2=Integer.valueOf(matches.get(j).getIDuser().substring(4));
                            if(id1>id2){
                                matches.set(i, j1);
                                matches.set(j, i1);
                            }                                                    
                        
                        }
                        
                    }

                    Object[][] rows=new Object[matches.size()][7];

                    for(int i=0;i<matches.size();i++){
                        for(int j=0;j<7;j++){
                            if(j==0){
                                rows[i][j]=matches.get(i).getIDuser();
                            }
                            if(j==1){
                                rows[i][j]=matches.get(i).getNameUser();
                            }
                            if(j==2){
                                rows[i][j]=matches.get(i).getCnic();
                            }
                            if(j==3){
                                rows[i][j]="+92".concat(matches.get(i).getPhone().toString());
                            }
                            if(j==4){
                                rows[i][j]=matches.get(i).getFee();
                            }
                            if(j==5){
                                rows[i][j]=matches.get(i).getNameofAdmin();
                            }
                            if(j==6){
                                rows[i][j]=matches.get(i).getJoining();
                            }
                        }

                    }
                    
                    if(Screensize.getWidth()==1920){searchtable.setFont(new Font("Goudy Old Style",0,22));}
                    else if(Screensize.getWidth()>=1536&&Screensize.getWidth()<1920){searchtable.setFont(new Font("Goudy Old Style",0,20));}
                    else{searchtable.setFont(new Font("Goudy Old Style",0,18));}


                    searchtable.setModel(new DefaultTableModel(rows, headerRGC){
                        @Override
                        public boolean isCellEditable(int row, int column) {
                            return false;
                        }
                    });
                    searchtable.setSelectionBackground(new Color(245, 170, 100));
                    searchtable.setSelectionForeground(Color.black);
                    searchtable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

                    


                    if(Screensize.getWidth()==1920){
                        if(matches.size()>14){
                            tablecontainerSGC.setSize(1210, 450);
                        }
                        else{
                            tablecontainerSGC.setSize(1190, 450);
                        }
                        searchtable.getColumnModel().getColumn(0).setPreferredWidth(130);
                        searchtable.getColumnModel().getColumn(1).setPreferredWidth(200);
                        searchtable.getColumnModel().getColumn(2).setPreferredWidth(240);
                        searchtable.getColumnModel().getColumn(3).setPreferredWidth(200);
                        searchtable.getColumnModel().getColumn(4).setPreferredWidth(100);
                        searchtable.getColumnModel().getColumn(5).setPreferredWidth(200);
                        searchtable.getColumnModel().getColumn(6).setPreferredWidth(115);
                    }
                    else if(Screensize.getWidth()>=1536&&Screensize.getWidth()<1920){
                        if(matches.size()>14){
                            tablecontainerSGC.setSize(1055, 350);
                        }
                        else{
                            tablecontainerSGC.setSize(1030, 350);
                        }
                        searchtable.getColumnModel().getColumn(0).setPreferredWidth(90);
                        searchtable.getColumnModel().getColumn(1).setPreferredWidth(170);
                        searchtable.getColumnModel().getColumn(2).setPreferredWidth(210);
                        searchtable.getColumnModel().getColumn(3).setPreferredWidth(170);
                        searchtable.getColumnModel().getColumn(4).setPreferredWidth(100);
                        searchtable.getColumnModel().getColumn(5).setPreferredWidth(180);
                        searchtable.getColumnModel().getColumn(6).setPreferredWidth(105);
                    }
                    else{
                        if(matches.size()>9){
                            tablecontainerSGC.setSize(820, 290);
                        }
                        else{
                            tablecontainerSGC.setSize(800, 290);
                        }
                        searchtable.getColumnModel().getColumn(0).setPreferredWidth(90);
                        searchtable.getColumnModel().getColumn(1).setPreferredWidth(170);
                        searchtable.getColumnModel().getColumn(2).setPreferredWidth(210);
                        searchtable.getColumnModel().getColumn(3).setPreferredWidth(170);
                        searchtable.getColumnModel().getColumn(4).setPreferredWidth(100);
                        searchtable.getColumnModel().getColumn(5).setPreferredWidth(180);
                        searchtable.getColumnModel().getColumn(6).setPreferredWidth(105);
                    }
                    
                    searchtable();
                    
                }
            }

            if(datechooserSGC.isVisible()&&datechooserSGC.getDate()!=null){
                

                if(datechooserSGC.getDate()!=null){
                    String datemem;
                    datemem=LocalDate.ofInstant(datechooserSGC.getDate().toInstant(),ZoneId.systemDefault()).toString();
                    if(!super.selectfromtable(nameofTabelenow).isEmpty()){
                        ArrayList<gymclient> ids= selectfromtable(nameofTabelenow);
                        ArrayList<gymclient> matches=new ArrayList<>();
                        for (gymclient gymclient1 : ids) {
                            if(String.valueOf(gymclient1.getJoining()).equals(datemem))
                            {
                                matches.add(gymclient1);
                            }
                        }

                        
                    for(int i=0;i<matches.size();i++){                       
                        for(int j=i+1;j<matches.size();j++){
                            gymclient i1=matches.get(i);
                            gymclient j1=matches.get(j);
                            int id1=Integer.valueOf(matches.get(i).getIDuser().substring(4));
                            int id2=Integer.valueOf(matches.get(j).getIDuser().substring(4));
                            if(id1>id2){
                                matches.set(i, j1);
                                matches.set(j, i1);
                            }                                                    
                        
                        }
                        
                    }

    
                        Object[][] rows=new Object[matches.size()][7];
    
                        for(int i=0;i<matches.size();i++){
                            for(int j=0;j<7;j++){
                                if(j==0){
                                    rows[i][j]=matches.get(i).getIDuser();
                                }
                                if(j==1){
                                    rows[i][j]=matches.get(i).getNameUser();
                                }
                                if(j==2){
                                    rows[i][j]=matches.get(i).getCnic();
                                }
                                if(j==3){
                                    rows[i][j]="+92".concat(matches.get(i).getPhone().toString());
                                }
                                if(j==4){
                                    rows[i][j]=matches.get(i).getFee();
                                }
                                if(j==5){
                                    rows[i][j]=matches.get(i).getNameofAdmin();
                                }
                                if(j==6){
                                    rows[i][j]=matches.get(i).getJoining();
                                }
                            }
    
                        }
                        
                        if(Screensize.getWidth()==1920){searchtable.setFont(new Font("Goudy Old Style",0,22));}
                        else if(Screensize.getWidth()>=1536&&Screensize.getWidth()<1920){searchtable.setFont(new Font("Goudy Old Style",0,20));}
                        else{searchtable.setFont(new Font("Goudy Old Style",0,18));}
    
    
                        searchtable.setModel(new DefaultTableModel(rows, headerRGC){
                            @Override
                            public boolean isCellEditable(int row, int column) {
                                return false;
                            }
                        });
                        searchtable.setSelectionBackground(new Color(245, 170, 100));
                        searchtable.setSelectionForeground(Color.black);
                        searchtable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
    
                        
    
    
                        if(Screensize.getWidth()==1920){
                            if(matches.size()>14){
                                tablecontainerSGC.setSize(1210, 450);
                            }
                            else{
                                tablecontainerSGC.setSize(1190, 450);
                            }
                            searchtable.getColumnModel().getColumn(0).setPreferredWidth(130);
                            searchtable.getColumnModel().getColumn(1).setPreferredWidth(200);
                            searchtable.getColumnModel().getColumn(2).setPreferredWidth(240);
                            searchtable.getColumnModel().getColumn(3).setPreferredWidth(200);
                            searchtable.getColumnModel().getColumn(4).setPreferredWidth(100);
                            searchtable.getColumnModel().getColumn(5).setPreferredWidth(200);
                            searchtable.getColumnModel().getColumn(6).setPreferredWidth(115);
                        }
                        else if(Screensize.getWidth()>=1536&&Screensize.getWidth()<1920){
                            if(matches.size()>14){
                                tablecontainerSGC.setSize(1050, 350);
                            }
                            else{
                                tablecontainerSGC.setSize(1030, 350);
                            }
                            searchtable.getColumnModel().getColumn(0).setPreferredWidth(90);
                            searchtable.getColumnModel().getColumn(1).setPreferredWidth(170);
                            searchtable.getColumnModel().getColumn(2).setPreferredWidth(210);
                            searchtable.getColumnModel().getColumn(3).setPreferredWidth(170);
                            searchtable.getColumnModel().getColumn(4).setPreferredWidth(100);
                            searchtable.getColumnModel().getColumn(5).setPreferredWidth(180);
                            searchtable.getColumnModel().getColumn(6).setPreferredWidth(105);
                        }
                        else{
                            if(matches.size()>9){
                                tablecontainerSGC.setSize(820, 290);
                            }
                            else{
                                tablecontainerSGC.setSize(800, 290);
                            }
                            searchtable.getColumnModel().getColumn(0).setPreferredWidth(90);
                            searchtable.getColumnModel().getColumn(1).setPreferredWidth(170);
                            searchtable.getColumnModel().getColumn(2).setPreferredWidth(210);
                            searchtable.getColumnModel().getColumn(3).setPreferredWidth(170);
                            searchtable.getColumnModel().getColumn(4).setPreferredWidth(100);
                            searchtable.getColumnModel().getColumn(5).setPreferredWidth(180);
                            searchtable.getColumnModel().getColumn(6).setPreferredWidth(105);
                        }
                        searchtable();
                    }

                }
            
       
            }

            if(!phonefldSGC.getText().isEmpty()){
                String phonenumber;
                phonenumber=phonefldSGC.getText();
                if(!super.selectfromtable(nameofTabelenow).isEmpty()){
                    ArrayList<gymclient> names= selectfromtable(nameofTabelenow);
                    ArrayList<gymclient> matches=new ArrayList<>();
                    for (gymclient gymclient1 : names) {
                        if((gymclient1.getPhone()).equals(Long.valueOf(phonenumber)))
                        {
                            matches.add(gymclient1);
                        }
                    }

                    
                    for(int i=0;i<matches.size();i++){                       
                        for(int j=i+1;j<matches.size();j++){
                            gymclient i1=matches.get(i);
                            gymclient j1=matches.get(j);
                            int id1=Integer.valueOf(matches.get(i).getIDuser().substring(4));
                            int id2=Integer.valueOf(matches.get(j).getIDuser().substring(4));
                            if(id1>id2){
                                matches.set(i, j1);
                                matches.set(j, i1);
                            }                                                    
                        
                        }
                        
                    }

                    Object[][] rows=new Object[matches.size()][7];

                    for(int i=0;i<matches.size();i++){
                        for(int j=0;j<7;j++){
                            if(j==0){
                                rows[i][j]=matches.get(i).getIDuser();
                            }
                            if(j==1){
                                rows[i][j]=matches.get(i).getNameUser();
                            }
                            if(j==2){
                                rows[i][j]=matches.get(i).getCnic();
                            }
                            if(j==3){
                                rows[i][j]="+92".concat(matches.get(i).getPhone().toString());
                            }
                            if(j==4){
                                rows[i][j]=matches.get(i).getFee();
                            }
                            if(j==5){
                                rows[i][j]=matches.get(i).getNameofAdmin();
                            }
                            if(j==6){
                                rows[i][j]=matches.get(i).getJoining();
                            }
                        }

                    }
                    
                    if(Screensize.getWidth()==1920){searchtable.setFont(new Font("Goudy Old Style",0,22));}
                    else if(Screensize.getWidth()>=1536&&Screensize.getWidth()<1920){searchtable.setFont(new Font("Goudy Old Style",0,20));}
                    else{searchtable.setFont(new Font("Goudy Old Style",0,18));}


                    searchtable.setModel(new DefaultTableModel(rows, headerRGC){
                        @Override
                        public boolean isCellEditable(int row, int column) {
                            return false;
                        }
                    });
                    searchtable.setSelectionBackground(new Color(245, 170, 100));
                    searchtable.setSelectionForeground(Color.black);
                    searchtable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

                    


                    if(Screensize.getWidth()==1920){
                        if(matches.size()>14){
                            tablecontainerSGC.setSize(1210, 450);
                        }
                        else{
                            tablecontainerSGC.setSize(1190, 450);
                        }
                        searchtable.getColumnModel().getColumn(0).setPreferredWidth(130);
                        searchtable.getColumnModel().getColumn(1).setPreferredWidth(200);
                        searchtable.getColumnModel().getColumn(2).setPreferredWidth(240);
                        searchtable.getColumnModel().getColumn(3).setPreferredWidth(200);
                        searchtable.getColumnModel().getColumn(4).setPreferredWidth(100);
                        searchtable.getColumnModel().getColumn(5).setPreferredWidth(200);
                        searchtable.getColumnModel().getColumn(6).setPreferredWidth(115);
                    }
                    else if(Screensize.getWidth()>=1536&&Screensize.getWidth()<1920){
                        if(matches.size()>14){
                            tablecontainerSGC.setSize(1055, 350);
                        }
                        else{
                            tablecontainerSGC.setSize(1030, 350);
                        }
                        searchtable.getColumnModel().getColumn(0).setPreferredWidth(90);
                        searchtable.getColumnModel().getColumn(1).setPreferredWidth(170);
                        searchtable.getColumnModel().getColumn(2).setPreferredWidth(210);
                        searchtable.getColumnModel().getColumn(3).setPreferredWidth(170);
                        searchtable.getColumnModel().getColumn(4).setPreferredWidth(100);
                        searchtable.getColumnModel().getColumn(5).setPreferredWidth(180);
                        searchtable.getColumnModel().getColumn(6).setPreferredWidth(105);
                    }
                    else{
                        if(matches.size()>9){
                            tablecontainerSGC.setSize(820, 290);
                        }
                        else{
                            tablecontainerSGC.setSize(800, 290);
                        }
                        searchtable.getColumnModel().getColumn(0).setPreferredWidth(90);
                        searchtable.getColumnModel().getColumn(1).setPreferredWidth(170);
                        searchtable.getColumnModel().getColumn(2).setPreferredWidth(210);
                        searchtable.getColumnModel().getColumn(3).setPreferredWidth(170);
                        searchtable.getColumnModel().getColumn(4).setPreferredWidth(100);
                        searchtable.getColumnModel().getColumn(5).setPreferredWidth(180);
                        searchtable.getColumnModel().getColumn(6).setPreferredWidth(105);
                    }
                    
                    searchtable();
                }
                
            }

        }
    
        if(e.getSource()==backbtnSGC){
            searchlblSGC.setText("Search :");
            searchlblSGC.setVisible(true);
            searchoptionsSGC.setVisible(true);
            searchoptionsSGC.setSelectedIndex(0);
            tablecontainerSGC.setVisible(true);
            searchSGC.setVisible(true);
            clearSGC.setVisible(true);

            imagelblSGC.setVisible(false);
            nameilblSGC.setVisible(false);
            idilblSGC.setVisible(false);
            cnicilblSGC.setVisible(false);
            phoneilblSGC.setVisible(false);
            dateofjoinilblSGC.setVisible(false);
            backbtnSGC.setVisible(false);
            feeilblSGC.setVisible(false);

            nameifldSGC.setVisible(false);
            idifldSGC.setVisible(false);
            cnicifldSGC.setVisible(false);
            phoneifldSGC.setVisible(false);
            dateofjoinifldSGC.setVisible(false);
            feeifldSGC.setVisible(false);

            nameifldSGC.setText(null);
            idifldSGC.setText(null);
            cnicifldSGC.setText(null);
            phoneifldSGC.setText(null);
            dateofjoinifldSGC.setText(null);
            feeifldSGC.setText(null);
            datechooserSGC.setDate(new Date());
            if(Screensize.getWidth()==1920){imagelblSGC.setIcon(new ImageIcon(new ImageIcon(getClass().getResource("icons/deafultpic3.png")).getImage().getScaledInstance(400, 400, Image.SCALE_SMOOTH)));}
            else if(Screensize.getWidth()>=1536&&Screensize.getWidth()<1920){
                imagelblSGC.setIcon(new ImageIcon(new ImageIcon(getClass().getResource("icons/deafultpic3.png")).getImage().getScaledInstance(350, 350, Image.SCALE_SMOOTH)));
            }
            else{
                imagelblSGC.setIcon(new ImageIcon(new ImageIcon(getClass().getResource("icons/deafultpic3.png")).getImage().getScaledInstance(300, 300, Image.SCALE_SMOOTH)));
            }
            

        }

        if(e.getSource()==feemem){
            feepanelAF.setVisible(true);
            if(Screensize.getWidth()==1920){
                this.addfeelbl1.setVisible(true);
                if(addfeelbl2!=null){this.addfeelbl2.setVisible(false);}
                if(addfeelbl3!=null){this.addfeelbl3.setVisible(false);}
            }
            else if(Screensize.getWidth()>=1536&&Screensize.getWidth()<1920){
                if(addfeelbl1!=null){this.addfeelbl1.setVisible(false);}
                this.addfeelbl2.setVisible(true);
                if(addfeelbl3!=null){this.addfeelbl3.setVisible(false);}
            }
            else
            {
                if(addfeelbl1!=null){this.addfeelbl1.setVisible(false);}
                if(addfeelbl2!=null){this.addfeelbl2.setVisible(false);}
                this.addfeelbl3.setVisible(true);
            }
            toplabelcoverAF.setVisible(true);
            this.addgymmem.setVisible(false);
            if(addgymmem1!=null){this.addgymmem1.setVisible(false);}
            removegymmem.setVisible(false);
            toplabelcoverRGC.setVisible(false);
            this.toplabelcover1.setVisible(false);
            this.menupanel.setVisible(false);
            this.p1.setVisible(false);
            this.p2.setVisible(false);
            this.p3.setVisible(false);


        }
    
        if(e.getSource()==clearbtnAF){
            namefldAF.setVisible(false);
            idfldAF.setVisible(false);
            searchlblAF.setText("Search :");
            namefldAF.setText(null);
            idfldAF.setText(null);
            searchoptionsAF.setVisible(true);
            searchoptionsAF.setSelectedItem("Select");
            searchbtnAF.setEnabled(false);

            

            searchtableAF.setModel(new DefaultTableModel(null, headerAF){
                @Override
                public boolean isCellEditable(int row, int column) {
    
                    return false;
                }
    
            });
            if(Screensize.getWidth()==1920){
                searchtableAF.getColumnModel().getColumn(0).setPreferredWidth(130);
                searchtableAF.getColumnModel().getColumn(1).setPreferredWidth(200);
                searchtableAF.getColumnModel().getColumn(2).setPreferredWidth(250);
                searchtableAF.getColumnModel().getColumn(3).setPreferredWidth(200);
                searchtableAF.getColumnModel().getColumn(4).setPreferredWidth(100);
                searchtableAF.getColumnModel().getColumn(5).setPreferredWidth(200);
                searchtableAF.getColumnModel().getColumn(6).setPreferredWidth(115);
                searchtableAF.getColumnModel().getColumn(7).setPreferredWidth(130);
            }
            else if(Screensize.getWidth()>=1536&&Screensize.getWidth()<1920){
                searchtableAF.getColumnModel().getColumn(0).setPreferredWidth(130);
                searchtableAF.getColumnModel().getColumn(1).setPreferredWidth(200);
                searchtableAF.getColumnModel().getColumn(2).setPreferredWidth(250);
                searchtableAF.getColumnModel().getColumn(3).setPreferredWidth(200);
                searchtableAF.getColumnModel().getColumn(4).setPreferredWidth(100);
                searchtableAF.getColumnModel().getColumn(5).setPreferredWidth(200);
                searchtableAF.getColumnModel().getColumn(6).setPreferredWidth(115);
                searchtableAF.getColumnModel().getColumn(7).setPreferredWidth(130);
            }
            else{
                searchtableAF.getColumnModel().getColumn(0).setPreferredWidth(90);
                searchtableAF.getColumnModel().getColumn(1).setPreferredWidth(170);
                searchtableAF.getColumnModel().getColumn(2).setPreferredWidth(210);
                searchtableAF.getColumnModel().getColumn(3).setPreferredWidth(170);
                searchtableAF.getColumnModel().getColumn(4).setPreferredWidth(100);
                searchtableAF.getColumnModel().getColumn(5).setPreferredWidth(180);
                searchtableAF.getColumnModel().getColumn(6).setPreferredWidth(105);
                searchtableAF.getColumnModel().getColumn(7).setPreferredWidth(130);

            }
        }

        if(e.getSource()==replacemem){
            if(Admincontrols.isVisible()){closeAdminPanel.doClick();}

            if(Screensize.getWidth()==1920){
                this.replacelbl1.setVisible(true);
                if(replacelbl2!=null){this.replacelbl2.setVisible(false);}
                if(replacelbl3!=null){this.replacelbl3.setVisible(false);}
            }
            else if(Screensize.getWidth()>=1536&&Screensize.getWidth()<1920){
                if(replacelbl1!=null){this.replacelbl1.setVisible(false);}
                this.replacelbl2.setVisible(true);
                if(replacelbl3!=null){this.replacelbl3.setVisible(false);}
            }
            else
            {
                if(replacelbl1!=null){this.replacelbl1.setVisible(false);}
                if(replacelbl2!=null){this.replacelbl2.setVisible(false);}
                this.replacelbl3.setVisible(true);
            }
            replacepanelRI.setVisible(true);
            toplabelcoverRI.setVisible(true);
            this.addgymmem.setVisible(false);
            if(addgymmem1!=null){this.addgymmem1.setVisible(false);}
            removegymmem.setVisible(false);
            toplabelcoverRGC.setVisible(false);
            this.toplabelcover1.setVisible(false);
            this.menupanel.setVisible(false);
            this.p1.setVisible(false);
            this.p2.setVisible(false);
            this.p3.setVisible(false);
            viewAdminControls.setEnabled(false);

        }


        if(e.getSource()==calculatemonthbugjet){
            if(Admincontrols.isVisible()){closeAdminPanel.doClick();}
            monthsoptionaMF.setSelectedItem(nameofTabelenow.toLowerCase());
            
            if(Screensize.getWidth()==1920){
                this.monthyfeelbl1.setVisible(true);
                if(monthyfeelbl2!=null){this.monthyfeelbl2.setVisible(false);}
                if(monthyfeelbl3!=null){this.monthyfeelbl3.setVisible(false);}
            }
            else if(Screensize.getWidth()>=1536&&Screensize.getWidth()<1920){
                if(monthyfeelbl1!=null){this.monthyfeelbl1.setVisible(false);}
                this.monthyfeelbl2.setVisible(true);
                if(monthyfeelbl3!=null){this.monthyfeelbl3.setVisible(false);}
            }
            else
            {
                if(monthyfeelbl1!=null){this.monthyfeelbl1.setVisible(false);}
                if(monthyfeelbl2!=null){this.monthyfeelbl2.setVisible(false);}
                this.monthyfeelbl3.setVisible(true);
            }
            monthlyfeepanelMF.setVisible(true);
            toplabelcoverMF.setVisible(true);
            this.addgymmem.setVisible(false);
            if(addgymmem1!=null){this.addgymmem1.setVisible(false);}
            removegymmem.setVisible(false);
            toplabelcoverRGC.setVisible(false);
            this.toplabelcover1.setVisible(false);
            this.menupanel.setVisible(false);
            this.p1.setVisible(false);
            this.p2.setVisible(false);
            this.p3.setVisible(false);
            viewAdminControls.setEnabled(false);

            if(monthsoptionaMF.getSelectedItem().equals(nameofTabelenow)){
                ArrayList<gymclient> mems1=selectfromtable(nameofTabelenow);
                if(!mems1.isEmpty()){
                    strengthfldMF.setText(String.valueOf(mems1.size()));
                    int count=0;
                    int pending=0;
                    int reveuevalue=0;
                    for (gymclient i : mems1) {
                        if(i.isFeecheck()){
                            count++;
                            reveuevalue+=i.getFee();
                        }
                        else{
                            pending++;
                        }                        
                    }

                    feecollectionfldMF.setText(String.valueOf(count));
                    feependfldMF.setText(String.valueOf(pending));
                    revenuefldMF.setText(String.valueOf(reveuevalue));
                    if(expensefldMF.getText().isEmpty()){
                        expensefldMF.setText("0");
                    }

                    if(!super.selectfromtable(nameofTabelenow).isEmpty()){
                        ArrayList<gymclient> matches= selectfromtable(nameofTabelenow);

                        
                        for(int i=0;i<matches.size();i++){                       
                            for(int j=i+1;j<matches.size();j++){
                                gymclient i1=matches.get(i);
                                gymclient j1=matches.get(j);
                                int id1=Integer.valueOf(matches.get(i).getIDuser().substring(4));
                                int id2=Integer.valueOf(matches.get(j).getIDuser().substring(4));
                                if(id1>id2){
                                    matches.set(i, j1);
                                    matches.set(j, i1);
                                }                                                    
                            
                            }
                            
                        }
                           
                        Object[][] rows=new Object[matches.size()][8];

                        for(int i=0;i<matches.size();i++){
                            for(int j=0;j<8;j++){
                                if(j==0){
                                    rows[i][j]=matches.get(i).getIDuser();
                                }
                                if(j==1){
                                    rows[i][j]=matches.get(i).getNameUser();
                                }
                                if(j==2){
                                    rows[i][j]=matches.get(i).getCnic();
                                }
                                if(j==3){
                                    rows[i][j]="+92".concat(matches.get(i).getPhone().toString());
                                }
                                if(j==4){
                                    rows[i][j]=matches.get(i).getFee();
                                }
                                if(j==5){
                                    rows[i][j]=matches.get(i).getNameofAdmin();
                                }
                                if(j==6){
                                    if(matches.get(i).getDateoffee()!=null){
                                        rows[i][j]=matches.get(i).getDateoffee();
                                    }
                                    else{
                                        rows[i][j]="-";
                                    }
                                }
                                if(j==7){
                                    rows[i][j]=matches.get(i).getJoining();
                                }
                            }
    
                        }
                        
                        if(Screensize.getWidth()==1920){monthtableMF.setFont(new Font("Goudy Old Style",0,22));}
                        else if(Screensize.getWidth()>=1536&&Screensize.getWidth()<1920){monthtableMF.setFont(new Font("Goudy Old Style",0,20));}
                        else{monthtableMF.setFont(new Font("Goudy Old Style",0,18));}
    
    
                        monthtableMF.setModel(new DefaultTableModel(rows, headerMF){
                            @Override
                            public boolean isCellEditable(int row, int column) {
                                return false;
                            }
                        });
                        monthtableMF.setSelectionBackground(new Color(245, 170, 100));
                        monthtableMF.setSelectionForeground(Color.black);
                        monthtableMF.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);


                        if(Screensize.getWidth()==1920){

                            monthtableMF.getColumnModel().getColumn(0).setPreferredWidth(130);
                            monthtableMF.getColumnModel().getColumn(1).setPreferredWidth(200);
                            monthtableMF.getColumnModel().getColumn(2).setPreferredWidth(250);
                            monthtableMF.getColumnModel().getColumn(3).setPreferredWidth(200);
                            monthtableMF.getColumnModel().getColumn(4).setPreferredWidth(100);
                            monthtableMF.getColumnModel().getColumn(5).setPreferredWidth(200);
                            monthtableMF.getColumnModel().getColumn(6).setPreferredWidth(150);
                            monthtableMF.getColumnModel().getColumn(7).setPreferredWidth(130);

                        }
                        else if(Screensize.getWidth()>=1536&&Screensize.getWidth()<1920){
                            monthtableMF.getColumnModel().getColumn(0).setPreferredWidth(90);
                            monthtableMF.getColumnModel().getColumn(1).setPreferredWidth(200);
                            monthtableMF.getColumnModel().getColumn(2).setPreferredWidth(200);
                            monthtableMF.getColumnModel().getColumn(3).setPreferredWidth(180);
                            monthtableMF.getColumnModel().getColumn(4).setPreferredWidth(100);
                            monthtableMF.getColumnModel().getColumn(5).setPreferredWidth(180);
                            monthtableMF.getColumnModel().getColumn(6).setPreferredWidth(125);
                            monthtableMF.getColumnModel().getColumn(7).setPreferredWidth(125);
                        }
                        else
                        {
                            monthtableMF.getColumnModel().getColumn(0).setPreferredWidth(90);
                            monthtableMF.getColumnModel().getColumn(1).setPreferredWidth(200);
                            monthtableMF.getColumnModel().getColumn(2).setPreferredWidth(200);
                            monthtableMF.getColumnModel().getColumn(3).setPreferredWidth(180);
                            monthtableMF.getColumnModel().getColumn(4).setPreferredWidth(100);
                            monthtableMF.getColumnModel().getColumn(5).setPreferredWidth(180);
                            monthtableMF.getColumnModel().getColumn(6).setPreferredWidth(125);
                            monthtableMF.getColumnModel().getColumn(7).setPreferredWidth(125);
                        }
    
                        monthtableMF();
                        
                        
                    }
                    
                    
                    
                    
                }
            }


        }
    
        if(e.getSource()==addfeeAF){

            if(searchtableAF.getRowCount()>0&&searchtableAF.getSelectedRowCount()==1){
                searchlblAF.setVisible(false);
                searchoptionsAF.setVisible(false);
                namefldAF.setVisible(false);
                idfldAF.setVisible(false);
                searchbtnAF.setVisible(false);
                clearbtnAF.setVisible(false);
                tablecontainerAF.setVisible(false);
                instructionAF.setVisible(false);

                int row=searchtableAF.getSelectedRow();
                String nameofclient=String.valueOf(searchtableAF.getValueAt(row, 1));

            namefldAF.setVisible(false);
            idfldAF.setVisible(false);
            searchlblAF.setText("Search :");
            namefldAF.setText(null);
            idfldAF.setText(null);
            searchoptionsAF.setSelectedItem("Select");
            searchbtnAF.setEnabled(false);

            

            searchtableAF.setModel(new DefaultTableModel(null, headerAF){
                @Override
                public boolean isCellEditable(int row, int column) {
    
                    return false;
                }
    
            });
            if(Screensize.getWidth()==1920){
                searchtableAF.getColumnModel().getColumn(0).setPreferredWidth(130);
                searchtableAF.getColumnModel().getColumn(1).setPreferredWidth(200);
                searchtableAF.getColumnModel().getColumn(2).setPreferredWidth(250);
                searchtableAF.getColumnModel().getColumn(3).setPreferredWidth(200);
                searchtableAF.getColumnModel().getColumn(4).setPreferredWidth(100);
                searchtableAF.getColumnModel().getColumn(5).setPreferredWidth(200);
                searchtableAF.getColumnModel().getColumn(6).setPreferredWidth(115);
                searchtableAF.getColumnModel().getColumn(7).setPreferredWidth(130);
            }
            else if(Screensize.getWidth()>=1536&&Screensize.getWidth()<1920){
                searchtableAF.getColumnModel().getColumn(0).setPreferredWidth(130);
                searchtableAF.getColumnModel().getColumn(1).setPreferredWidth(200);
                searchtableAF.getColumnModel().getColumn(2).setPreferredWidth(250);
                searchtableAF.getColumnModel().getColumn(3).setPreferredWidth(200);
                searchtableAF.getColumnModel().getColumn(4).setPreferredWidth(100);
                searchtableAF.getColumnModel().getColumn(5).setPreferredWidth(200);
                searchtableAF.getColumnModel().getColumn(6).setPreferredWidth(115);
                searchtableAF.getColumnModel().getColumn(7).setPreferredWidth(130);
            }
            else{
                searchtableAF.getColumnModel().getColumn(0).setPreferredWidth(90);
                searchtableAF.getColumnModel().getColumn(1).setPreferredWidth(170);
                searchtableAF.getColumnModel().getColumn(2).setPreferredWidth(210);
                searchtableAF.getColumnModel().getColumn(3).setPreferredWidth(170);
                searchtableAF.getColumnModel().getColumn(4).setPreferredWidth(100);
                searchtableAF.getColumnModel().getColumn(5).setPreferredWidth(180);
                searchtableAF.getColumnModel().getColumn(6).setPreferredWidth(105);
                searchtableAF.getColumnModel().getColumn(7).setPreferredWidth(130);

            }

                ArrayList<gymclient> names=selectfromtable(nameofTabelenow);
                gymclient client1=null;
                for (gymclient client : names) {
                    if(client.getNameUser().equals(nameofclient)){
                        client1=client;
                        break;
                    }
                }

                if(client1!=null){
                    nameifldAF.setText(client1.getNameUser());
                    idifldAF.setText(client1.getIDuser());
                    cnicifldAF.setText(client1.getCnic());
                    phoneifldAF.setText("+92"+String.valueOf(client1.getPhone()));
                    dateofjoinifldAF.setText(client1.getJoining().toString());
                    feeifldAF.setText(String.valueOf(client1.getFee()));
                    try {
                        BufferedImage ig=ImageIO.read(client1.getImage());
                        int widthimg=(ig.getWidth()*250)/ig.getHeight();
                        int heightimg=250;

                        if(Screensize.getWidth()==1920){
                            widthimg=(ig.getWidth()*350)/ig.getHeight();
                            heightimg=350;
                        }
                        else if(Screensize.getWidth()>=1536&&Screensize.getWidth()<1920){
                            widthimg=(ig.getWidth()*300)/ig.getHeight();
                            heightimg=300;
                        }
                        else{
                            widthimg=(ig.getWidth()*250)/ig.getHeight();
                            heightimg=250;
                        }
                        imagelblAF.setIcon(new ImageIcon(ig.getScaledInstance(widthimg, heightimg, Image.SCALE_SMOOTH)));

                    } catch (IOException e1) {
                        showerror(e1);
                    }
                }


                imagelblAF.setVisible(true);
                nameilblAF.setVisible(true);
                idilblAF.setVisible(true);
                cnicilblAF.setVisible(true);
                phoneilblAF.setVisible(true);
                dateofjoinilblAF.setVisible(true);
                feeilblAF.setVisible(true);
                feelblAF.setVisible(true);
                addfeeAF.setVisible(true);
                backbtnAF.setVisible(true);


                nameifldAF.setVisible(true);
                idifldAF.setVisible(true);
                cnicifldAF.setVisible(true);
                phoneifldAF.setVisible(true);
                dateofjoinifldAF.setVisible(true);
                feeifldAF.setVisible(true);
                feefldAF.setVisible(true);
                
                

            }

            if(!nameifldAF.getText().isBlank()&&!feefldAF.getText().isBlank()){
                String nameofclient=nameifldAF.getText();

                ArrayList<gymclient> names=selectfromtable(nameofTabelenow);
                gymclient client1=null;
                for (gymclient client : names) {
                if(client.getNameUser().equals(nameofclient)){
                    client1=client;
                    break;
                }
            }
                if(client1!=null&&client1.getDateoffee()!=null){
                    if(!client1.isFeecheck()&&!LocalDate.now().isBefore(client1.getDateoffee().plusDays(30))){                        
                        if(updatetabledateoffee(client1.getNameUser(), nameofTabelenow,Integer.valueOf(feefldAF.getText())))
                        {
                            setlookandfeelGreen();
                            backbtnAF.doClick();
                            JOptionPane.showMessageDialog(null, "Fee Details have been Changed Successfully!!", "Fee Details Result", JOptionPane.INFORMATION_MESSAGE);
                            searchtableAF.clearSelection();
                            feelblAF.setVisible(false);
                            feefldAF.setVisible(false);                      
                            feefldAF.setText(null);
                        }
                        else{
                            setlookandfeelRed();
                            JOptionPane.showMessageDialog(null, "Some Error has Occurred During Alteration of Fee Details.", "Fee Details Result", JOptionPane.ERROR_MESSAGE);
                        }
                    }
                    else if(client1.isFeecheck()&&LocalDate.now().isBefore(client1.getDateoffee().plusDays(30))){
                        setlookandfeelGreen();
                        int response=JOptionPane.showConfirmDialog(null, "Do you really want to add fee before 30 Days of previous Fee!", "Fee Details Result", JOptionPane.YES_NO_OPTION);
                        if(response==0){
                            if(updatetabledateoffee(client1.getNameUser(), nameofTabelenow,Integer.valueOf(feefldAF.getText())))
                            {
                                backbtnAF.doClick();
                                setlookandfeelGreen();
                                JOptionPane.showMessageDialog(null, "Fee Details have been Changed Successfully!!", "Fee Details Result", JOptionPane.INFORMATION_MESSAGE);
                                searchtableAF.clearSelection();
                                feelblAF.setVisible(false);
                                feefldAF.setVisible(false);
                                feefldAF.setText(null);
                            }
                            else{
                                setlookandfeelRed();
                                JOptionPane.showMessageDialog(null, "Some Error has Occurred During Alteration of Fee Details.", "Fee Details Result", JOptionPane.ERROR_MESSAGE);

                            }
                        }
                    }
                }
                else if(client1!=null&&client1.getDateoffee()==null){
                    if(updatetabledateoffee(client1.getNameUser(), nameofTabelenow,Integer.valueOf(feefldAF.getText())))
                    {   
                        backbtnAF.doClick();
                        setlookandfeelGreen();
                        JOptionPane.showMessageDialog(null, "Fee Details have been Changed Successfully!!", "Fee Details Result", JOptionPane.INFORMATION_MESSAGE);
                        searchtableAF.clearSelection();
                        feelblAF.setVisible(false);
                        feefldAF.setVisible(false);
                        feefldAF.setText(null);
                    }
                    else{
                        setlookandfeelRed();
                        JOptionPane.showMessageDialog(null, "Some Error has Occurred During Alteration of Fee Details.", "Fee Details Result", JOptionPane.ERROR_MESSAGE);
                    }
                }
            
            
            }
            



        }
    
        if(e.getSource()==searchbtnAF){

            if(searchoptionsAF.getSelectedIndex()==1&&!namefldAF.getText().isEmpty()){
                String Nameofmemsrch;
                Nameofmemsrch=namefldAF.getText();
                if(!super.selectfromtable(nameofTabelenow).isEmpty()){
                    ArrayList<gymclient> names= selectfromtable(nameofTabelenow);
                    ArrayList<gymclient> matches=new ArrayList<>();
                    for (gymclient gymclient1 : names) {
                        if(gymclient1.getNameUser().toLowerCase().contains(Nameofmemsrch.toLowerCase()))
                        {
                            matches.add(gymclient1);
                        }
                    }
                    for(int i=0;i<matches.size();i++){                       
                        for(int j=i+1;j<matches.size();j++){
                            gymclient i1=matches.get(i);
                            gymclient j1=matches.get(j);
                            int id1=Integer.valueOf(matches.get(i).getIDuser().substring(4));
                            int id2=Integer.valueOf(matches.get(j).getIDuser().substring(4));
                            if(id1>id2){
                                matches.set(i, j1);
                                matches.set(j, i1);
                            }                                                    
                        
                        }
                        
                    }

                    Object[][] rows=new Object[matches.size()][8];

                    for(int i=0;i<matches.size();i++){
                        for(int j=0;j<8;j++){
                            if(j==0){
                                rows[i][j]=matches.get(i).getIDuser();
                            }
                            if(j==1){
                                rows[i][j]=matches.get(i).getNameUser();
                            }
                            if(j==2){
                                rows[i][j]=matches.get(i).getCnic();
                            }
                            if(j==3){
                                rows[i][j]="+92".concat(matches.get(i).getPhone().toString());
                            }
                            if(j==4){
                                rows[i][j]=matches.get(i).getFee();
                            }
                            if(j==5){
                                rows[i][j]=matches.get(i).getNameofAdmin();
                            }
                            if(j==6){
                                if(matches.get(i).getDateoffee()!=null){
                                    rows[i][j]=matches.get(i).getDateoffee();
                                }
                                else{
                                    rows[i][j]="-";
                                }
                            }
                            if(j==7){
                                rows[i][j]=matches.get(i).getJoining();
                            }
                        }

                    }
                    
                    if(Screensize.getWidth()==1920){searchtableAF.setFont(new Font("Goudy Old Style",0,22));}
                    else if(Screensize.getWidth()>=1536&&Screensize.getWidth()<1920){searchtableAF.setFont(new Font("Goudy Old Style",0,20));}
                    else{searchtableAF.setFont(new Font("Goudy Old Style",0,18));}


                    searchtableAF.setModel(new DefaultTableModel(rows, headerAF){
                        @Override
                        public boolean isCellEditable(int row, int column) {
                            return false;
                        }
                    });
                    searchtableAF.setSelectionBackground(new Color(245, 170, 100));
                    searchtableAF.setSelectionForeground(Color.black);
                    searchtableAF.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

                    


                    if(Screensize.getWidth()==1920){
                        // if(matches.size()>14){
                        //     tablecontainerAF.setSize(1190, 220);
                        // }
                        // else{
                        //     tablecontainerAF.setSize(2010, 220);
                        // }
                        searchtableAF.getColumnModel().getColumn(0).setPreferredWidth(130);
                        searchtableAF.getColumnModel().getColumn(1).setPreferredWidth(200);
                        searchtableAF.getColumnModel().getColumn(2).setPreferredWidth(240);
                        searchtableAF.getColumnModel().getColumn(3).setPreferredWidth(200);
                        searchtableAF.getColumnModel().getColumn(4).setPreferredWidth(100);
                        searchtableAF.getColumnModel().getColumn(5).setPreferredWidth(200);
                        searchtableAF.getColumnModel().getColumn(6).setPreferredWidth(115);
                        searchtableAF.getColumnModel().getColumn(7).setPreferredWidth(115);
                    }
                    else if(Screensize.getWidth()>=1536&&Screensize.getWidth()<1920){
                        // if(matches.size()>14){
                        //     tablecontainerAF.setSize(1055, 350);
                        // }
                        // else{
                        //     tablecontainerAF.setSize(1030, 350);
                        // }
                        searchtableAF.getColumnModel().getColumn(0).setPreferredWidth(90);
                        searchtableAF.getColumnModel().getColumn(1).setPreferredWidth(170);
                        searchtableAF.getColumnModel().getColumn(2).setPreferredWidth(210);
                        searchtableAF.getColumnModel().getColumn(3).setPreferredWidth(170);
                        searchtableAF.getColumnModel().getColumn(4).setPreferredWidth(100);
                        searchtableAF.getColumnModel().getColumn(5).setPreferredWidth(180);
                        searchtableAF.getColumnModel().getColumn(6).setPreferredWidth(105);
                        searchtableAF.getColumnModel().getColumn(7).setPreferredWidth(105);

                    }
                    else{
                        // if(matches.size()>9){
                        //     tablecontainerAF.setSize(820, 290);
                        // }
                        // else{
                        //     tablecontainerAF.setSize(800, 290);
                        // }
                        searchtableAF.getColumnModel().getColumn(0).setPreferredWidth(90);
                        searchtableAF.getColumnModel().getColumn(1).setPreferredWidth(170);
                        searchtableAF.getColumnModel().getColumn(2).setPreferredWidth(210);
                        searchtableAF.getColumnModel().getColumn(3).setPreferredWidth(170);
                        searchtableAF.getColumnModel().getColumn(4).setPreferredWidth(100);
                        searchtableAF.getColumnModel().getColumn(5).setPreferredWidth(180);
                        searchtableAF.getColumnModel().getColumn(6).setPreferredWidth(105);
                        searchtableAF.getColumnModel().getColumn(7).setPreferredWidth(105);

                    }
                    
                    
                }
            }
        
            if(searchoptionsAF.getSelectedIndex()==2&&!idfldAF.getText().isEmpty()){

                String idofmemsrch;
                idofmemsrch=idfldAF.getText();
                if(!super.selectfromtable(nameofTabelenow).isEmpty()){
                    ArrayList<gymclient> names= selectfromtable(nameofTabelenow);
                    ArrayList<gymclient> matches=new ArrayList<>();
                    for (gymclient gymclient1 : names) {
                        if(gymclient1.getIDuser().toLowerCase().contains(idofmemsrch.toLowerCase()))
                        {
                            matches.add(gymclient1);
                        }
                    }
                    for(int i=0;i<matches.size();i++){                       
                        for(int j=i+1;j<matches.size();j++){
                            gymclient i1=matches.get(i);
                            gymclient j1=matches.get(j);
                            int id1=Integer.valueOf(matches.get(i).getIDuser().substring(4));
                            int id2=Integer.valueOf(matches.get(j).getIDuser().substring(4));
                            if(id1>id2){
                                matches.set(i, j1);
                                matches.set(j, i1);
                            }                                                    
                        
                        }
                        
                    }

                    Object[][] rows=new Object[matches.size()][8];

                    for(int i=0;i<matches.size();i++){
                        for(int j=0;j<8;j++){
                            if(j==0){
                                rows[i][j]=matches.get(i).getIDuser();
                            }
                            if(j==1){
                                rows[i][j]=matches.get(i).getNameUser();
                            }
                            if(j==2){
                                rows[i][j]=matches.get(i).getCnic();
                            }
                            if(j==3){
                                rows[i][j]="+92".concat(matches.get(i).getPhone().toString());
                            }
                            if(j==4){
                                rows[i][j]=matches.get(i).getFee();
                            }
                            if(j==5){
                                rows[i][j]=matches.get(i).getNameofAdmin();
                            }
                            if(j==6){
                                if(matches.get(i).getDateoffee()!=null){
                                    rows[i][j]=matches.get(i).getDateoffee();
                                }
                                else{
                                    rows[i][j]="-";
                                }
                            }
                            if(j==7){
                                rows[i][j]=matches.get(i).getJoining();
                            }
                        }

                    }
                    
                    if(Screensize.getWidth()==1920){searchtableAF.setFont(new Font("Goudy Old Style",0,22));}
                    else if(Screensize.getWidth()>=1536&&Screensize.getWidth()<1920){searchtableAF.setFont(new Font("Goudy Old Style",0,20));}
                    else{searchtableAF.setFont(new Font("Goudy Old Style",0,18));}


                    searchtableAF.setModel(new DefaultTableModel(rows, headerAF){
                        @Override
                        public boolean isCellEditable(int row, int column) {
                            return false;
                        }
                    });
                    searchtableAF.setSelectionBackground(new Color(245, 170, 100));
                    searchtableAF.setSelectionForeground(Color.black);
                    searchtableAF.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

                    


                    if(Screensize.getWidth()==1920){
                        // if(matches.size()>14){
                        //     tablecontainerAF.setSize(1190, 220);
                        // }
                        // else{
                        //     tablecontainerAF.setSize(2010, 220);
                        // }
                        searchtableAF.getColumnModel().getColumn(0).setPreferredWidth(130);
                        searchtableAF.getColumnModel().getColumn(1).setPreferredWidth(200);
                        searchtableAF.getColumnModel().getColumn(2).setPreferredWidth(240);
                        searchtableAF.getColumnModel().getColumn(3).setPreferredWidth(200);
                        searchtableAF.getColumnModel().getColumn(4).setPreferredWidth(100);
                        searchtableAF.getColumnModel().getColumn(5).setPreferredWidth(200);
                        searchtableAF.getColumnModel().getColumn(6).setPreferredWidth(115);
                        searchtableAF.getColumnModel().getColumn(7).setPreferredWidth(115);
                    }
                    else if(Screensize.getWidth()>=1536&&Screensize.getWidth()<1920){
                        // if(matches.size()>14){
                        //     tablecontainerAF.setSize(1055, 350);
                        // }
                        // else{
                        //     tablecontainerAF.setSize(1030, 350);
                        // }
                        searchtableAF.getColumnModel().getColumn(0).setPreferredWidth(90);
                        searchtableAF.getColumnModel().getColumn(1).setPreferredWidth(170);
                        searchtableAF.getColumnModel().getColumn(2).setPreferredWidth(210);
                        searchtableAF.getColumnModel().getColumn(3).setPreferredWidth(170);
                        searchtableAF.getColumnModel().getColumn(4).setPreferredWidth(100);
                        searchtableAF.getColumnModel().getColumn(5).setPreferredWidth(180);
                        searchtableAF.getColumnModel().getColumn(6).setPreferredWidth(105);
                        searchtableAF.getColumnModel().getColumn(7).setPreferredWidth(105);

                    }
                    else{
                        // if(matches.size()>9){
                        //     tablecontainerAF.setSize(820, 290);
                        // }
                        // else{
                        //     tablecontainerAF.setSize(800, 290);
                        // }
                        searchtableAF.getColumnModel().getColumn(0).setPreferredWidth(90);
                        searchtableAF.getColumnModel().getColumn(1).setPreferredWidth(170);
                        searchtableAF.getColumnModel().getColumn(2).setPreferredWidth(210);
                        searchtableAF.getColumnModel().getColumn(3).setPreferredWidth(170);
                        searchtableAF.getColumnModel().getColumn(4).setPreferredWidth(100);
                        searchtableAF.getColumnModel().getColumn(5).setPreferredWidth(180);
                        searchtableAF.getColumnModel().getColumn(6).setPreferredWidth(105);
                        searchtableAF.getColumnModel().getColumn(7).setPreferredWidth(105);

                    }
                    
                    
                }
            }

            if(searchoptionsAF.getSelectedIndex()==3&&searchoptionsAF.isVisible()){
                if(!super.selectfromtable(nameofTabelenow).isEmpty()){
                    ArrayList<gymclient> names= selectfromtable(nameofTabelenow);
                    ArrayList<gymclient> matches=new ArrayList<>();
                    for (gymclient gymclient1 : names) {
                        if(gymclient1.getDateoffee()==null)
                        {
                            matches.add(gymclient1);
                        }
                        else if(LocalDate.now().isAfter(gymclient1.getDateoffee().plusDays(30))){
                            matches.add(gymclient1);

                        }
                        else if(LocalDate.now().isEqual(gymclient1.getDateoffee().plusDays(30))){
                            matches.add(gymclient1);
                        }
                    }
                    for(int i=0;i<matches.size();i++){                       
                        for(int j=i+1;j<matches.size();j++){
                            gymclient i1=matches.get(i);
                            gymclient j1=matches.get(j);
                            int id1=Integer.valueOf(matches.get(i).getIDuser().substring(4));
                            int id2=Integer.valueOf(matches.get(j).getIDuser().substring(4));
                            if(id1>id2){
                                matches.set(i, j1);
                                matches.set(j, i1);
                            }                                                    
                        
                        }
                        
                    }

                    Object[][] rows=new Object[matches.size()][8];

                    for(int i=0;i<matches.size();i++){
                        for(int j=0;j<8;j++){
                            if(j==0){
                                rows[i][j]=matches.get(i).getIDuser();
                            }
                            if(j==1){
                                rows[i][j]=matches.get(i).getNameUser();
                            }
                            if(j==2){
                                rows[i][j]=matches.get(i).getCnic();
                            }
                            if(j==3){
                                rows[i][j]="+92".concat(matches.get(i).getPhone().toString());
                            }
                            if(j==4){
                                rows[i][j]=matches.get(i).getFee();
                            }
                            if(j==5){
                                rows[i][j]=matches.get(i).getNameofAdmin();
                            }
                            if(j==6){
                                if(matches.get(i).getDateoffee()!=null){
                                    rows[i][j]=matches.get(i).getDateoffee();
                                }
                                else{
                                    rows[i][j]="-";
                                }
                            }
                            if(j==7){
                                rows[i][j]=matches.get(i).getJoining();
                            }
                        }

                    }
                    
                    if(Screensize.getWidth()==1920){searchtableAF.setFont(new Font("Goudy Old Style",0,22));}
                    else if(Screensize.getWidth()>=1536&&Screensize.getWidth()<1920){searchtableAF.setFont(new Font("Goudy Old Style",0,20));}
                    else{searchtableAF.setFont(new Font("Goudy Old Style",0,18));}


                    searchtableAF.setModel(new DefaultTableModel(rows, headerAF){
                        @Override
                        public boolean isCellEditable(int row, int column) {
                            return false;
                        }
                    });
                    searchtableAF.setSelectionBackground(new Color(245, 170, 100));
                    searchtableAF.setSelectionForeground(Color.black);
                    searchtableAF.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

                    


                    if(Screensize.getWidth()==1920){

                        searchtableAF.getColumnModel().getColumn(0).setPreferredWidth(130);
                        searchtableAF.getColumnModel().getColumn(1).setPreferredWidth(200);
                        searchtableAF.getColumnModel().getColumn(2).setPreferredWidth(240);
                        searchtableAF.getColumnModel().getColumn(3).setPreferredWidth(200);
                        searchtableAF.getColumnModel().getColumn(4).setPreferredWidth(100);
                        searchtableAF.getColumnModel().getColumn(5).setPreferredWidth(200);
                        searchtableAF.getColumnModel().getColumn(6).setPreferredWidth(115);
                        searchtableAF.getColumnModel().getColumn(7).setPreferredWidth(115);
                    }
                    else if(Screensize.getWidth()>=1536&&Screensize.getWidth()<1920){

                        searchtableAF.getColumnModel().getColumn(0).setPreferredWidth(90);
                        searchtableAF.getColumnModel().getColumn(1).setPreferredWidth(170);
                        searchtableAF.getColumnModel().getColumn(2).setPreferredWidth(210);
                        searchtableAF.getColumnModel().getColumn(3).setPreferredWidth(170);
                        searchtableAF.getColumnModel().getColumn(4).setPreferredWidth(100);
                        searchtableAF.getColumnModel().getColumn(5).setPreferredWidth(180);
                        searchtableAF.getColumnModel().getColumn(6).setPreferredWidth(105);
                        searchtableAF.getColumnModel().getColumn(7).setPreferredWidth(105);

                    }
                    else{
 
                        searchtableAF.getColumnModel().getColumn(0).setPreferredWidth(90);
                        searchtableAF.getColumnModel().getColumn(1).setPreferredWidth(170);
                        searchtableAF.getColumnModel().getColumn(2).setPreferredWidth(210);
                        searchtableAF.getColumnModel().getColumn(3).setPreferredWidth(170);
                        searchtableAF.getColumnModel().getColumn(4).setPreferredWidth(100);
                        searchtableAF.getColumnModel().getColumn(5).setPreferredWidth(180);
                        searchtableAF.getColumnModel().getColumn(6).setPreferredWidth(105);
                        searchtableAF.getColumnModel().getColumn(7).setPreferredWidth(105);

                    }
                    
                    
                }
            }

        }
    
        if(e.getSource()==showtableMF){
            showtableMF.setVisible(false);
            HidetableMF.setVisible(true);
            tablecontainerMF.setVisible(true);

            if(Screensize.getWidth()==1920){
                strengthfldMF.setFont(new Font("Goudy Old Style",0,20));
                strengthfldMF.setBounds(300, 80, 150, 35);
                
                feecollectionfldMF.setFont(new Font("Goudy Old Style",0,20));
                feecollectionfldMF.setBounds(800, 80, 150, 35);
    
                feependfldMF.setFont(new Font("Goudy Old Style",0,20));
                feependfldMF.setBounds(1220, 80, 150, 35);
                    
                feependingMF.setFont(new Font("Cooper Black",0,20));
                feependingMF.setBounds(1000, 80, 250, 35);
                
                feecollectedlblMF.setFont(new Font("Cooper Black",0,20));
                feecollectedlblMF.setBounds(550, 80, 250, 35);
                
                totalstrengthlblMF.setFont(new Font("Cooper Black",0,20));
                totalstrengthlblMF.setBounds(50, 80, 250, 35);
    
                reveueMF.setFont(new Font("Cooper Black",0,20));
                reveueMF.setBounds(50, 145, 250, 35);
    
                ExpensesMF.setFont(new Font("Cooper Black",0,20));
                ExpensesMF.setBounds(550, 145, 250, 35);
    
                ProfitMF.setFont(new Font("Cooper Black",0,20));
                ProfitMF.setBounds(1000, 145, 250, 35);
    
                revenuefldMF.setFont(new Font("Goudy Old Style",0,20));
                revenuefldMF.setBounds(300, 145, 150, 35);
    
                expensefldMF.setFont(new Font("Goudy Old Style",0,20));
                expensefldMF.setBounds(800, 145, 150, 35);
    
                profitfldMF.setFont(new Font("Goudy Old Style",0,20));
                profitfldMF.setBounds(1220, 145, 150, 35);
           
    
                totalfeefldMF.setFont(new Font("Goudy Old Style",0,22));
                totalfeefldMF.setBounds(750, 210, 250, 35);
    
                totalfeelblMF.setFont(new Font("Cooper Black",0,22));
                totalfeelblMF.setBounds(500, 210, 250, 35);
            }
            else if(Screensize.getWidth()>=1536&&Screensize.getWidth()<1920){

                strengthfldMF.setFont(new Font("Goudy Old Style",0,20));
                strengthfldMF.setBounds(300, 70, 150, 30);
                
                feecollectionfldMF.setFont(new Font("Goudy Old Style",0,20));
                feecollectionfldMF.setBounds(750, 70, 150, 30);
    
                feependfldMF.setFont(new Font("Goudy Old Style",0,20));
                feependfldMF.setBounds(1120, 70, 150, 30);
                    
                feependingMF.setFont(new Font("Cooper Black",0,20));
                feependingMF.setBounds(900, 70, 250, 30);
                
                feecollectedlblMF.setFont(new Font("Cooper Black",0,20));
                feecollectedlblMF.setBounds(520, 70, 250, 30);
                
                totalstrengthlblMF.setFont(new Font("Cooper Black",0,20));
                totalstrengthlblMF.setBounds(50, 70, 250, 30);
    
                reveueMF.setFont(new Font("Cooper Black",0,20));
                reveueMF.setBounds(50, 125, 250, 30);
    
                ExpensesMF.setFont(new Font("Cooper Black",0,20));
                ExpensesMF.setBounds(500, 125, 250, 30);
    
                ProfitMF.setFont(new Font("Cooper Black",0,20));
                ProfitMF.setBounds(900, 125, 250, 30);
    
                revenuefldMF.setFont(new Font("Goudy Old Style",0,20));
                revenuefldMF.setBounds(300, 125, 150, 30);
    
                expensefldMF.setFont(new Font("Goudy Old Style",0,20));
                expensefldMF.setBounds(750, 125, 150, 30);
    
                profitfldMF.setFont(new Font("Goudy Old Style",0,20));
                profitfldMF.setBounds(1120, 125, 150, 30);
           
    
                totalfeefldMF.setFont(new Font("Goudy Old Style",0,22));
                totalfeefldMF.setBounds(670, 180, 250, 35);
    
                totalfeelblMF.setFont(new Font("Cooper Black",0,22));
                totalfeelblMF.setBounds(450, 180, 250, 35);
            }
            else{

                showtableMF.setFont(new Font("Goudy Old Style",0,10));
                showtableMF.setBounds(1100, 20, 80, 26);
                
                HidetableMF.setFont(new Font("Goudy Old Style",0,10));
                HidetableMF.setBounds(1100, 20, 80, 26);
    
                totalstrengthlblMF.setFont(new Font("Cooper Black",0,20));
                totalstrengthlblMF.setBounds(30, 60, 250, 30);
                
                strengthfldMF.setFont(new Font("Goudy Old Style",0,20));
                strengthfldMF.setBounds(250, 60, 150, 30);
    
                feecollectedlblMF.setFont(new Font("Cooper Black",0,20));
                feecollectedlblMF.setBounds(420, 60, 250, 30);
                            
                feecollectionfldMF.setFont(new Font("Goudy Old Style",0,20));
                feecollectionfldMF.setBounds(650, 60, 150, 30);
    
                feependingMF.setFont(new Font("Cooper Black",0,20));
                feependingMF.setBounds(800, 60, 250, 30);
    
                feependfldMF.setFont(new Font("Goudy Old Style",0,20));
                feependfldMF.setBounds(1020, 60, 150, 30);
    
                   
                reveueMF.setFont(new Font("Cooper Black",0,20));
                reveueMF.setBounds(30, 105, 250, 30);
    
                ExpensesMF.setFont(new Font("Cooper Black",0,20));
                ExpensesMF.setBounds(420, 105, 250, 30);
    
                ProfitMF.setFont(new Font("Cooper Black",0,20));
                ProfitMF.setBounds(800, 105, 250, 30);
    
                revenuefldMF.setFont(new Font("Goudy Old Style",0,20));
                revenuefldMF.setBounds(250, 105, 150, 30);
    
                expensefldMF.setFont(new Font("Goudy Old Style",0,20));
                expensefldMF.setBounds(650, 105, 150, 30);
    
                profitfldMF.setFont(new Font("Goudy Old Style",0,20));
                profitfldMF.setBounds(1020, 105, 150, 30);
    
    
    
                monthslblMF.setFont(new Font("Cooper Black",0,20));
                monthslblMF.setBounds(350, 10, 150, 30);
    
                monthsoptionaMF.setFont(new Font("Goudy Old Style",0,20));
                monthsoptionaMF.setBounds(500, 10, 200, 30);
    
                totalfeefldMF.setFont(new Font("Goudy Old Style",0,20));
                totalfeefldMF.setBounds(570, 150, 220, 30);
    
                totalfeelblMF.setFont(new Font("Cooper Black",0,20));
                totalfeelblMF.setBounds(350, 150, 220, 30);

            }
        
        
        }

        if(e.getSource()==HidetableMF){
            showtableMF.setVisible(true);
            HidetableMF.setVisible(false);
            tablecontainerMF.setVisible(false);
            monthtableMF.clearSelection();
            if(Screensize.getWidth()==1920){
                
            showtableMF.setFont(new Font("Goudy Old Style",0,14));
            showtableMF.setBounds(1350, 20, 100, 30);
            
            HidetableMF.setFont(new Font("Goudy Old Style",0,14));
            HidetableMF.setBounds(1350, 20, 100, 30);


            strengthfldMF.setFont(new Font("Goudy Old Style",0,24));
            strengthfldMF.setBounds(350, 150, 150, 40);
            
            feecollectionfldMF.setFont(new Font("Goudy Old Style",0,24));
            feecollectionfldMF.setBounds(800, 150, 150, 40);

            feependfldMF.setFont(new Font("Goudy Old Style",0,24));
            feependfldMF.setBounds(1220, 150, 150, 40);

            
            feependingMF.setFont(new Font("Cooper Black",0,24));
            feependingMF.setBounds(1000, 150, 250, 40);
            
            feecollectedlblMF.setFont(new Font("Cooper Black",0,24));
            feecollectedlblMF.setBounds(550, 150, 250, 40);
            
            totalstrengthlblMF.setFont(new Font("Cooper Black",0,24));
            totalstrengthlblMF.setBounds(100, 150, 250, 40);

            reveueMF.setFont(new Font("Cooper Black",0,24));
            reveueMF.setBounds(100, 250, 250, 40);

            ExpensesMF.setFont(new Font("Cooper Black",0,24));
            ExpensesMF.setBounds(550, 250, 250, 40);

            ProfitMF.setFont(new Font("Cooper Black",0,24));
            ProfitMF.setBounds(1000, 250, 250, 40);

            revenuefldMF.setFont(new Font("Goudy Old Style",0,24));
            revenuefldMF.setBounds(350, 250, 150, 40);

            expensefldMF.setFont(new Font("Goudy Old Style",0,24));
            expensefldMF.setBounds(800, 250, 150, 40);

            profitfldMF.setFont(new Font("Goudy Old Style",0,24));
            profitfldMF.setBounds(1220, 250, 150, 40);



            monthslblMF.setFont(new Font("Cooper Black",0,24));
            monthslblMF.setBounds(500, 20, 200, 40);

            monthsoptionaMF.setFont(new Font("Goudy Old Style",0,24));
            monthsoptionaMF.setBounds(670, 20, 250, 40);

            totalfeefldMF.setFont(new Font("Goudy Old Style",0,24));
            totalfeefldMF.setBounds(750, 350, 250, 40);

            totalfeelblMF.setFont(new Font("Cooper Black",0,24));
            totalfeelblMF.setBounds(500, 350, 250, 40);

            }
            else if(Screensize.getWidth()>=1536&&Screensize.getWidth()<1920){
                showtableMF.setFont(new Font("Goudy Old Style",0,14));
                showtableMF.setBounds(1150, 20, 100, 30);
                
                HidetableMF.setFont(new Font("Goudy Old Style",0,14));
                HidetableMF.setBounds(1150, 20, 100, 30);
    
    
                strengthfldMF.setFont(new Font("Goudy Old Style",0,22));
                strengthfldMF.setBounds(300, 100, 150, 35);
                
                feecollectionfldMF.setFont(new Font("Goudy Old Style",0,22));
                feecollectionfldMF.setBounds(750, 100, 150, 35);
    
                feependfldMF.setFont(new Font("Goudy Old Style",0,22));
                feependfldMF.setBounds(1120, 100, 150, 35);
    
                
                feependingMF.setFont(new Font("Cooper Black",0,22));
                feependingMF.setBounds(900, 100, 250, 35);
                
                feecollectedlblMF.setFont(new Font("Cooper Black",0,22));
                feecollectedlblMF.setBounds(480, 100, 250, 35);
                
                totalstrengthlblMF.setFont(new Font("Cooper Black",0,22));
                totalstrengthlblMF.setBounds(50, 100, 250, 35);
    
                reveueMF.setFont(new Font("Cooper Black",0,22));
                reveueMF.setBounds(50, 200, 250, 35);
    
                ExpensesMF.setFont(new Font("Cooper Black",0,22));
                ExpensesMF.setBounds(480, 200, 250, 35);
    
                ProfitMF.setFont(new Font("Cooper Black",0,22));
                ProfitMF.setBounds(900, 200, 250, 35);
    
                revenuefldMF.setFont(new Font("Goudy Old Style",0,22));
                revenuefldMF.setBounds(300, 200, 150, 35);
    
                expensefldMF.setFont(new Font("Goudy Old Style",0,22));
                expensefldMF.setBounds(750, 200, 150, 35);
    
                profitfldMF.setFont(new Font("Goudy Old Style",0,22));
                profitfldMF.setBounds(1120, 200, 150, 35);
    
    
    
                monthslblMF.setFont(new Font("Cooper Black",0,22));
                monthslblMF.setBounds(400, 20, 200, 35);
    
                monthsoptionaMF.setFont(new Font("Goudy Old Style",0,22));
                monthsoptionaMF.setBounds(570, 20, 250, 35);
    
                totalfeefldMF.setFont(new Font("Goudy Old Style",0,22));
                totalfeefldMF.setBounds(650, 300, 250, 35);
    
                totalfeelblMF.setFont(new Font("Cooper Black",0,22));
                totalfeelblMF.setBounds(420, 300, 250, 35);
    
            }
            else{
                showtableMF.setFont(new Font("Goudy Old Style",0,10));
            showtableMF.setBounds(1100, 20, 80, 26);
            
            HidetableMF.setFont(new Font("Goudy Old Style",0,10));
            HidetableMF.setBounds(1100, 20, 80, 26);

            totalstrengthlblMF.setFont(new Font("Cooper Black",0,20));
            totalstrengthlblMF.setBounds(30, 80, 250, 30);
            
            strengthfldMF.setFont(new Font("Goudy Old Style",0,20));
            strengthfldMF.setBounds(250, 80, 150, 30);

            feecollectedlblMF.setFont(new Font("Cooper Black",0,20));
            feecollectedlblMF.setBounds(420, 80, 250, 30);
                        
            feecollectionfldMF.setFont(new Font("Goudy Old Style",0,20));
            feecollectionfldMF.setBounds(650, 80, 150, 30);

            feependingMF.setFont(new Font("Cooper Black",0,20));
            feependingMF.setBounds(800, 80, 250, 30);

            feependfldMF.setFont(new Font("Goudy Old Style",0,20));
            feependfldMF.setBounds(1020, 80, 150, 30);

               
            reveueMF.setFont(new Font("Cooper Black",0,20));
            reveueMF.setBounds(30, 160, 250, 30);

            ExpensesMF.setFont(new Font("Cooper Black",0,20));
            ExpensesMF.setBounds(420, 160, 250, 30);

            ProfitMF.setFont(new Font("Cooper Black",0,20));
            ProfitMF.setBounds(800, 160, 250, 30);

            revenuefldMF.setFont(new Font("Goudy Old Style",0,20));
            revenuefldMF.setBounds(250, 160, 150, 30);

            expensefldMF.setFont(new Font("Goudy Old Style",0,20));
            expensefldMF.setBounds(650, 160, 150, 30);

            profitfldMF.setFont(new Font("Goudy Old Style",0,20));
            profitfldMF.setBounds(1020, 160, 150, 30);



            monthslblMF.setFont(new Font("Cooper Black",0,20));
            monthslblMF.setBounds(350, 10, 150, 30);

            monthsoptionaMF.setFont(new Font("Goudy Old Style",0,20));
            monthsoptionaMF.setBounds(500, 10, 200, 30);

            totalfeefldMF.setFont(new Font("Goudy Old Style",0,20));
            totalfeefldMF.setBounds(570, 240, 220, 30);

            totalfeelblMF.setFont(new Font("Cooper Black",0,20));
            totalfeelblMF.setBounds(350, 240, 220, 30);
            }
        
        }
    
        if(e.getSource()==clearbtnRI){

            optionsRI.setSelectedIndex(0);
            optionsRI.setVisible(true);
            namesfldRI.setVisible(false);
            idsfldRI.setVisible(false);
            selectlblRI.setText("Select :");
            idsfldRI.setText(null);
            namesfldRI.setText(null);
            tableContainerRI.setVisible(true);
            SelectbtnRI.setVisible(true);
            namefldRI.setVisible(false);
            idfldRI.setVisible(false);
            cnicfldRI.setVisible(false);
            phonefldRI.setVisible(false);
            dateofjoinlblRI.setVisible(false);
            namelblRI.setVisible(false);
            phonelblRI.setVisible(false);
            idlblRI.setVisible(false);
            cniclblRI.setVisible(false);
            replacebtnRI.setVisible(false);
            imagelblRI.setVisible(false);
            datechooserRI.setDate(new Date());
            datechooserRI.setVisible(false);
            replaceimagebtnRI.setVisible(false);

            tableRI.setModel(new DefaultTableModel(null,headerRI){
                @Override
                public boolean isCellEditable(int row, int column) {

                    return false;
                }
            });


            if(Screensize.getWidth()==1920){
                tableRI.getColumnModel().getColumn(0).setPreferredWidth(130);
                tableRI.getColumnModel().getColumn(1).setPreferredWidth(200);
                tableRI.getColumnModel().getColumn(2).setPreferredWidth(250);
                tableRI.getColumnModel().getColumn(3).setPreferredWidth(200);
                tableRI.getColumnModel().getColumn(4).setPreferredWidth(100);
                tableRI.getColumnModel().getColumn(5).setPreferredWidth(200);
                tableRI.getColumnModel().getColumn(6).setPreferredWidth(130);
                tableRI.getColumnModel().getColumn(7).setPreferredWidth(115);
            }
            else if(Screensize.getWidth()>=1536&&Screensize.getWidth()<1920){
                tableRI.getColumnModel().getColumn(0).setPreferredWidth(130);
                tableRI.getColumnModel().getColumn(1).setPreferredWidth(200);
                tableRI.getColumnModel().getColumn(2).setPreferredWidth(250);
                tableRI.getColumnModel().getColumn(3).setPreferredWidth(200);
                tableRI.getColumnModel().getColumn(4).setPreferredWidth(100);
                tableRI.getColumnModel().getColumn(5).setPreferredWidth(200);
                tableRI.getColumnModel().getColumn(6).setPreferredWidth(130);
                tableRI.getColumnModel().getColumn(7).setPreferredWidth(115);

            }
            else{
                tableRI.getColumnModel().getColumn(0).setPreferredWidth(130);
                tableRI.getColumnModel().getColumn(1).setPreferredWidth(200);
                tableRI.getColumnModel().getColumn(2).setPreferredWidth(250);
                tableRI.getColumnModel().getColumn(3).setPreferredWidth(200);
                tableRI.getColumnModel().getColumn(4).setPreferredWidth(100);
                tableRI.getColumnModel().getColumn(5).setPreferredWidth(200);
                tableRI.getColumnModel().getColumn(6).setPreferredWidth(130);
                tableRI.getColumnModel().getColumn(7).setPreferredWidth(115);

            }


        }

        if(e.getSource()==searchbtnRI){
            
            if(optionsRI.getSelectedIndex()==2&&!namesfldRI.getText().isEmpty()){
                String Nameofmemsrch;
                Nameofmemsrch=namesfldRI.getText();
                if(!super.selectfromtable(nameofTabelenow).isEmpty()){
                    ArrayList<gymclient> names= selectfromtable(nameofTabelenow);
                    ArrayList<gymclient> matches=new ArrayList<>();
                    for (gymclient gymclient1 : names) {
                        if(gymclient1.getNameUser().toLowerCase().contains(Nameofmemsrch.toLowerCase()))
                        {
                            matches.add(gymclient1);
                        }
                    }
                    for(int i=0;i<matches.size();i++){                       
                        for(int j=i+1;j<matches.size();j++){
                            gymclient i1=matches.get(i);
                            gymclient j1=matches.get(j);
                            int id1=Integer.valueOf(matches.get(i).getIDuser().substring(4));
                            int id2=Integer.valueOf(matches.get(j).getIDuser().substring(4));
                            if(id1>id2){
                                matches.set(i, j1);
                                matches.set(j, i1);
                            }                                                    
                        
                        }
                        
                    }

                    Object[][] rows=new Object[matches.size()][8];

                    for(int i=0;i<matches.size();i++){
                        for(int j=0;j<8;j++){
                            if(j==0){
                                rows[i][j]=matches.get(i).getIDuser();
                            }
                            if(j==1){
                                rows[i][j]=matches.get(i).getNameUser();
                            }
                            if(j==2){
                                rows[i][j]=matches.get(i).getCnic();
                            }
                            if(j==3){
                                rows[i][j]="+92".concat(matches.get(i).getPhone().toString());
                            }
                            if(j==4){
                                rows[i][j]=matches.get(i).getFee();
                            }
                            if(j==5){
                                rows[i][j]=matches.get(i).getNameofAdmin();
                            }
                            if(j==6){
                                if(matches.get(i).getDateoffee()!=null){
                                    rows[i][j]=matches.get(i).getDateoffee();
                                }
                                else{
                                    rows[i][j]="-";
                                }
                            }
                            if(j==7){
                                rows[i][j]=matches.get(i).getJoining();
                            }
                        }

                    }
                    
                    if(Screensize.getWidth()==1920){tableRI.setFont(new Font("Goudy Old Style",0,22));}
                    else if(Screensize.getWidth()>=1536&&Screensize.getWidth()<1920){tableRI.setFont(new Font("Goudy Old Style",0,20));}
                    else{tableRI.setFont(new Font("Goudy Old Style",0,18));}


                    tableRI.setModel(new DefaultTableModel(rows, headerRI){
                        @Override
                        public boolean isCellEditable(int row, int column) {
                            return false;
                        }
                    });
                    tableRI.setSelectionBackground(new Color(245, 170, 100));
                    tableRI.setSelectionForeground(Color.black);
                    tableRI.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
                 
                    if(Screensize.getWidth()==1920){
                        tableRI.getColumnModel().getColumn(0).setPreferredWidth(130);
                        tableRI.getColumnModel().getColumn(1).setPreferredWidth(200);
                        tableRI.getColumnModel().getColumn(2).setPreferredWidth(250);
                        tableRI.getColumnModel().getColumn(3).setPreferredWidth(200);
                        tableRI.getColumnModel().getColumn(4).setPreferredWidth(100);
                        tableRI.getColumnModel().getColumn(5).setPreferredWidth(200);
                        tableRI.getColumnModel().getColumn(6).setPreferredWidth(130);
                        tableRI.getColumnModel().getColumn(7).setPreferredWidth(115);
                    }
                    else if(Screensize.getWidth()>=1536&&Screensize.getWidth()<1920){
                        tableRI.getColumnModel().getColumn(0).setPreferredWidth(130);
                        tableRI.getColumnModel().getColumn(1).setPreferredWidth(200);
                        tableRI.getColumnModel().getColumn(2).setPreferredWidth(250);
                        tableRI.getColumnModel().getColumn(3).setPreferredWidth(200);
                        tableRI.getColumnModel().getColumn(4).setPreferredWidth(100);
                        tableRI.getColumnModel().getColumn(5).setPreferredWidth(200);
                        tableRI.getColumnModel().getColumn(6).setPreferredWidth(130);
                        tableRI.getColumnModel().getColumn(7).setPreferredWidth(115);
        
                    }
                    else{
                        tableRI.getColumnModel().getColumn(0).setPreferredWidth(130);
                        tableRI.getColumnModel().getColumn(1).setPreferredWidth(200);
                        tableRI.getColumnModel().getColumn(2).setPreferredWidth(250);
                        tableRI.getColumnModel().getColumn(3).setPreferredWidth(200);
                        tableRI.getColumnModel().getColumn(4).setPreferredWidth(100);
                        tableRI.getColumnModel().getColumn(5).setPreferredWidth(200);
                        tableRI.getColumnModel().getColumn(6).setPreferredWidth(130);
                        tableRI.getColumnModel().getColumn(7).setPreferredWidth(115);
        
                    }
        
                    
                    
                }
            }
        
            if(optionsRI.getSelectedIndex()==1&&!idsfldRI.getText().isEmpty()){

                String idofmemsrch;
                idofmemsrch=idsfldRI.getText();
                if(!super.selectfromtable(nameofTabelenow).isEmpty()){
                    ArrayList<gymclient> names= selectfromtable(nameofTabelenow);
                    ArrayList<gymclient> matches=new ArrayList<>();
                    for (gymclient gymclient1 : names) {
                        if(gymclient1.getIDuser().toLowerCase().contains(idofmemsrch.toLowerCase()))
                        {
                            matches.add(gymclient1);
                        }
                    }
                    for(int i=0;i<matches.size();i++){                       
                        for(int j=i+1;j<matches.size();j++){
                            gymclient i1=matches.get(i);
                            gymclient j1=matches.get(j);
                            int id1=Integer.valueOf(matches.get(i).getIDuser().substring(4));
                            int id2=Integer.valueOf(matches.get(j).getIDuser().substring(4));
                            if(id1>id2){
                                matches.set(i, j1);
                                matches.set(j, i1);
                            }                                                    
                        
                        }
                        
                    }

                    Object[][] rows=new Object[matches.size()][8];

                    for(int i=0;i<matches.size();i++){
                        for(int j=0;j<8;j++){
                            if(j==0){
                                rows[i][j]=matches.get(i).getIDuser();
                            }
                            if(j==1){
                                rows[i][j]=matches.get(i).getNameUser();
                            }
                            if(j==2){
                                rows[i][j]=matches.get(i).getCnic();
                            }
                            if(j==3){
                                rows[i][j]="+92".concat(matches.get(i).getPhone().toString());
                            }
                            if(j==4){
                                rows[i][j]=matches.get(i).getFee();
                            }
                            if(j==5){
                                rows[i][j]=matches.get(i).getNameofAdmin();
                            }
                            if(j==6){
                                if(matches.get(i).getDateoffee()!=null){
                                    rows[i][j]=matches.get(i).getDateoffee();
                                }
                                else{
                                    rows[i][j]="-";
                                }
                            }
                            if(j==7){
                                rows[i][j]=matches.get(i).getJoining();
                            }
                        }

                    }
                    
                    if(Screensize.getWidth()==1920){tableRI.setFont(new Font("Goudy Old Style",0,22));}
                    else if(Screensize.getWidth()>=1536&&Screensize.getWidth()<1920){tableRI.setFont(new Font("Goudy Old Style",0,20));}
                    else{tableRI.setFont(new Font("Goudy Old Style",0,18));}


                    tableRI.setModel(new DefaultTableModel(rows, headerAF){
                        @Override
                        public boolean isCellEditable(int row, int column) {
                            return false;
                        }
                    });
                    tableRI.setSelectionBackground(new Color(245, 170, 100));
                    tableRI.setSelectionForeground(Color.black);
                    tableRI.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
                    
                    if(Screensize.getWidth()==1920){
                        tableRI.getColumnModel().getColumn(0).setPreferredWidth(130);
                        tableRI.getColumnModel().getColumn(1).setPreferredWidth(200);
                        tableRI.getColumnModel().getColumn(2).setPreferredWidth(250);
                        tableRI.getColumnModel().getColumn(3).setPreferredWidth(200);
                        tableRI.getColumnModel().getColumn(4).setPreferredWidth(100);
                        tableRI.getColumnModel().getColumn(5).setPreferredWidth(200);
                        tableRI.getColumnModel().getColumn(6).setPreferredWidth(130);
                        tableRI.getColumnModel().getColumn(7).setPreferredWidth(115);
                    }
                    else if(Screensize.getWidth()>=1536&&Screensize.getWidth()<1920){
                        tableRI.getColumnModel().getColumn(0).setPreferredWidth(130);
                        tableRI.getColumnModel().getColumn(1).setPreferredWidth(200);
                        tableRI.getColumnModel().getColumn(2).setPreferredWidth(250);
                        tableRI.getColumnModel().getColumn(3).setPreferredWidth(200);
                        tableRI.getColumnModel().getColumn(4).setPreferredWidth(100);
                        tableRI.getColumnModel().getColumn(5).setPreferredWidth(200);
                        tableRI.getColumnModel().getColumn(6).setPreferredWidth(130);
                        tableRI.getColumnModel().getColumn(7).setPreferredWidth(115);
        
                    }
                    else{
                        tableRI.getColumnModel().getColumn(0).setPreferredWidth(130);
                        tableRI.getColumnModel().getColumn(1).setPreferredWidth(200);
                        tableRI.getColumnModel().getColumn(2).setPreferredWidth(250);
                        tableRI.getColumnModel().getColumn(3).setPreferredWidth(200);
                        tableRI.getColumnModel().getColumn(4).setPreferredWidth(100);
                        tableRI.getColumnModel().getColumn(5).setPreferredWidth(200);
                        tableRI.getColumnModel().getColumn(6).setPreferredWidth(130);
                        tableRI.getColumnModel().getColumn(7).setPreferredWidth(115);
        
                    }
                           
                    
                }
            }

        }

        if(e.getSource()==SelectbtnRI){

            if(tableRI.getSelectedRowCount()==1){
                nameofmemRI=tableRI.getValueAt(tableRI.getSelectedRow(), 1).toString();
                tableContainerRI.setVisible(false);
                SelectbtnRI.setVisible(false);
                namefldRI.setVisible(true);
                idfldRI.setVisible(true);
                cnicfldRI.setVisible(true);
                phonefldRI.setVisible(true);
                datechooserRI.setVisible(true);
                dateofjoinlblRI.setVisible(true);
                namelblRI.setVisible(true);
                phonelblRI.setVisible(true);
                idlblRI.setVisible(true);
                cniclblRI.setVisible(true);
                imagelblRI.setVisible(true);
                backbtnRI.setVisible(true);
                imagelblRI.setVisible(true);
                replaceimagebtnRI.setVisible(true);
                idsfldRI.setEnabled(false);
                namesfldRI.setEnabled(false);
                searchbtnRI.setEnabled(false);
                clearbtnRI.setEnabled(false);

                ArrayList<gymclient> mem=selectfromtable(nameofTabelenow);
                gymclient reqperson=null;
                for (gymclient person : mem) {

                    if(person.getNameUser().equalsIgnoreCase(nameofmemRI)){
                        reqperson=person;
                    }
                    
                }

                if(reqperson!=null){
                    namefldRI.setText(reqperson.getNameUser());
                    idfldRI.setText(reqperson.getIDuser().substring(4)); 
                    String[] cincans=reqperson.getCnic().split("-",3);
                    String cnic=cincans[0]+cincans[1]+cincans[2];
                    cnicfldRI.setText(cnic);
                    phonefldRI.setText("0"+reqperson.getPhone().toString());
                    LocalDate datejoin=reqperson.getJoining();
                    datechooserRI.setDate(Date.from(datejoin.atStartOfDay(ZoneId.systemDefault()).toInstant()));
                    try {
                        BufferedImage ig=ImageIO.read(reqperson.getImage());
                        int widthimg=(ig.getWidth()*250)/ig.getHeight();
                        int heightimg=250;

                        if(Screensize.getWidth()==1920){
                            widthimg=(ig.getWidth()*350)/ig.getHeight();
                            heightimg=350;
                        }
                        else if(Screensize.getWidth()>=1536&&Screensize.getWidth()<1920){
                            widthimg=(ig.getWidth()*300)/ig.getHeight();
                            heightimg=300;
                        }
                        else{
                            widthimg=(ig.getWidth()*250)/ig.getHeight();
                            heightimg=250;
                        }
                        imagelblRI.setIcon(new ImageIcon(ig.getScaledInstance(widthimg, heightimg, Image.SCALE_SMOOTH)));

                    } catch (IOException e1) {
                        showerror(e1);
                    }
                    
                    namefldRI.getDocument().addDocumentListener(new DocumentListener(){

                        @Override
                        public void insertUpdate(DocumentEvent e) {
                            replacebtnRI.setVisible(true);                            
                        }

                        @Override
                        public void removeUpdate(DocumentEvent e) {
                            replacebtnRI.setVisible(true);                            
                            
                        }

                        @Override
                        public void changedUpdate(DocumentEvent e) {
                            
                        }
                        
                    });
                    idfldRI.getDocument().addDocumentListener(new DocumentListener(){

                        @Override
                        public void insertUpdate(DocumentEvent e) {
                            replacebtnRI.setVisible(true);                            
                        }

                        @Override
                        public void removeUpdate(DocumentEvent e) {
                            replacebtnRI.setVisible(true);                            
                            
                        }

                        @Override
                        public void changedUpdate(DocumentEvent e) {
                            
                        }
                        
                    });
                    cnicfldRI.getDocument().addDocumentListener(new DocumentListener(){

                        @Override
                        public void insertUpdate(DocumentEvent e) {
                            replacebtnRI.setVisible(true);                            
                        }

                        @Override
                        public void removeUpdate(DocumentEvent e) {
                            replacebtnRI.setVisible(true);                            
                            
                        }

                        @Override
                        public void changedUpdate(DocumentEvent e) {
                            
                        }
                        
                    });
                    phonefldRI.getDocument().addDocumentListener(new DocumentListener(){

                        @Override
                        public void insertUpdate(DocumentEvent e) {
                            replacebtnRI.setVisible(true);                            
                        }

                        @Override
                        public void removeUpdate(DocumentEvent e) {
                            replacebtnRI.setVisible(true);                            
                            
                        }

                        @Override
                        public void changedUpdate(DocumentEvent e) {
                            
                        }
                        
                    });
                    

                    replacebtnRI.setVisible(false);



                }
                

            }

        }

        if(e.getSource()==backbtnRI){
            optionsRI.setSelectedIndex(0);
            optionsRI.setVisible(true);
            namesfldRI.setVisible(false);
            idsfldRI.setVisible(false);
            selectlblRI.setText("Select :");
            idsfldRI.setText(null);
            namesfldRI.setText(null);

            namefldRI.setVisible(false);
            idfldRI.setVisible(false);
            cnicfldRI.setVisible(false);
            phonefldRI.setVisible(false);
            datechooserRI.setDate(new Date());
            datechooserRI.setVisible(false);
            dateofjoinlblRI.setVisible(false);
            namelblRI.setVisible(false);
            phonelblRI.setVisible(false);
            idlblRI.setVisible(false);
            cniclblRI.setVisible(false);
            imagelblRI.setVisible(false);
            backbtnRI.setVisible(false);
            imagelblRI.setVisible(false);
            replaceimagebtnRI.setVisible(false);
            replacebtnRI.setVisible(false);

            selectlblRI.setVisible(true);
            optionsRI.setVisible(true);
            tableContainerRI.setVisible(true);
            SelectbtnRI.setVisible(true);

            idsfldRI.setEnabled(true);
            namesfldRI.setEnabled(true);
            clearbtnRI.setEnabled(true);
            searchbtnRI.setEnabled(true);


            tableRI.setModel(new DefaultTableModel(null,headerRI){
                @Override
                public boolean isCellEditable(int row, int column) {

                    return false;
                }
            });


            if(Screensize.getWidth()==1920){
                tableRI.getColumnModel().getColumn(0).setPreferredWidth(130);
                tableRI.getColumnModel().getColumn(1).setPreferredWidth(200);
                tableRI.getColumnModel().getColumn(2).setPreferredWidth(250);
                tableRI.getColumnModel().getColumn(3).setPreferredWidth(200);
                tableRI.getColumnModel().getColumn(4).setPreferredWidth(100);
                tableRI.getColumnModel().getColumn(5).setPreferredWidth(200);
                tableRI.getColumnModel().getColumn(6).setPreferredWidth(130);
                tableRI.getColumnModel().getColumn(7).setPreferredWidth(115);
            }
            else if(Screensize.getWidth()>=1536&&Screensize.getWidth()<1920){
                tableRI.getColumnModel().getColumn(0).setPreferredWidth(130);
                tableRI.getColumnModel().getColumn(1).setPreferredWidth(200);
                tableRI.getColumnModel().getColumn(2).setPreferredWidth(250);
                tableRI.getColumnModel().getColumn(3).setPreferredWidth(200);
                tableRI.getColumnModel().getColumn(4).setPreferredWidth(100);
                tableRI.getColumnModel().getColumn(5).setPreferredWidth(200);
                tableRI.getColumnModel().getColumn(6).setPreferredWidth(130);
                tableRI.getColumnModel().getColumn(7).setPreferredWidth(115);

            }
            else{
                tableRI.getColumnModel().getColumn(0).setPreferredWidth(130);
                tableRI.getColumnModel().getColumn(1).setPreferredWidth(200);
                tableRI.getColumnModel().getColumn(2).setPreferredWidth(250);
                tableRI.getColumnModel().getColumn(3).setPreferredWidth(200);
                tableRI.getColumnModel().getColumn(4).setPreferredWidth(100);
                tableRI.getColumnModel().getColumn(5).setPreferredWidth(200);
                tableRI.getColumnModel().getColumn(6).setPreferredWidth(130);
                tableRI.getColumnModel().getColumn(7).setPreferredWidth(115);

            }

            replaceimagebtnRI.setVisible(false);


        }

        if(e.getSource()==replacebtnRI){

            LocalDate dateofjoinvalueRI=null;
            LocalDate replacevalue=null;
            Long cnicvaluefinal=0l;
            Long phonefinal=0l;
            String idfinal=null;
            String namefinal=null;

            dateofjoinvalueRI=LocalDate.ofInstant(datechooserRI.getDate().toInstant(),ZoneId.systemDefault());
            replacevalue=dateofjoinvalueRI;

            if(cnicfldRI.getText().length()!=13){
                setlookandfeelBlue();
                JOptionPane.showMessageDialog(null, "Invalid CNIC, Try Again", "CNIC Error", JOptionPane.INFORMATION_MESSAGE);
            }
            else{
                cnicvaluefinal=Long.valueOf(cnicfldRI.getText());
            }
            if(phonefldRI.getText().length()!=11){
                setlookandfeelBlue();
                JOptionPane.showMessageDialog(null, "Invalid Phone Number, Try Again", "Phone Number Error", JOptionPane.INFORMATION_MESSAGE);
            }
            else{
                phonefinal=Long.valueOf(phonefldRI.getText());
            }
            ArrayList<gymclient> allnames=selectfromtable(nameofTabelenow);
            gymclient manreq=null;

            for (gymclient gymclient1 : allnames) {

                if(gymclient1.getNameUser().equals(nameofmemRI)){
                    manreq=gymclient1;
                }
                
            }

            if(manreq!=null){
                if(!manreq.getIDuser().substring(4).equals(idfldRI.getText())){

                    for (gymclient gymclient : allnames) {
                        if(gymclient.getIDuser().substring(4).equals(String.valueOf(Integer.valueOf(idfldRI.getText())))){
                            setlookandfeelBlue();
                            JOptionPane.showMessageDialog(null, "This ID is not Valid, Try Another", "ID Error", 1); 
                        }
                        else{
                            idfinal="CCG-"+idfldRI.getText();
                        }
                    }

                }
                else{
                    idfinal=manreq.getIDuser();
                }

                if(!manreq.getNameUser().equals(namefldRI.getText())){

                    for (gymclient nameold : allnames) {

                        if(namefldRI.getText().equals(nameold.getNameUser())){
                            setlookandfeelBlue();
                            JOptionPane.showMessageDialog(null, "This Name is not Valid, Try Another", "Name Error", 1); 
                            break;
                        }
                        else{
                            namefinal=namefldRI.getText();
                        }
                        
                    }

                }
                else{
                    namefinal=manreq.getNameUser();
                }

            }

            if(replacevalue!=null&&cnicvaluefinal!=0l&&idfinal!=null&&namefinal!=null&&phonefinal!=0l){

                String cnicnew=String.valueOf(cnicvaluefinal).substring(0, 5)+"-"+String.valueOf(cnicvaluefinal).substring(5, 12)+"-"+String.valueOf(cnicvaluefinal).substring(12);
                InputStream image=null;

                if(imagefileRI!=null){
                    try {
                        image=new FileInputStream(imagefileRI);
                    } catch (FileNotFoundException e1) {
                        showerror(e1);
                    }
                }
                else{
                    image=manreq.getImage();
                }
                if(updatedataintotable(nameofTabelenow, namefinal, idfinal, phonefinal,cnicnew , manreq.getFee(), manreq.isFeecheck(), manreq.getNameofAdmin(), replacevalue, manreq.getDateoffee(),image, nameofmemRI)){
                    setlookandfeelGreen();
                    JOptionPane.showMessageDialog(null, "Data Successfully Updated!!!", "Result", 1);
                    namefldRI.setText(null);
                    idfldRI.setText(null);
                    cnicfldRI.setText(null);
                    phonefldRI.setText(null);
                    datechooserRI.setDate(new Date());
                    clearbtnRI.doClick();
                    replacebtnRI.setVisible(false);

                }
                else{
                    setlookandfeelRed();
                    JOptionPane.showMessageDialog(null, "Data Update Failed !!!", "Result", 1);
                }


            }





        }

        if(e.getSource()==replaceimagebtnRI){
            javafx.application.Platform.runLater(new Runnable(){

                @Override
                public void run() {
                    FileChooser fileChooser=new FileChooser();
                    FileChooser.ExtensionFilter filter1=new ExtensionFilter("Picture files", ("*.png"),("*.jpeg"),("*.jpg"));
                    fileChooser.getExtensionFilters().add(filter1);
                    File file1=fileChooser.showOpenDialog(null);

                    SwingUtilities.invokeLater(new Runnable(){

                        @Override
                        public void run() {
                            if(file1!=null){
                                try {
                                    imageRI=ImageIO.read(file1);
                                    imagefileRI=file1;
                                    int widthimg=(imageRI.getWidth()*250)/imageRI.getHeight();
                                    int heightimg=250;
                                    replacebtnRI.setVisible(true);

                                    if(Screensize.getWidth()==1920){
                                        widthimg=(imageRI.getWidth()*350)/imageRI.getHeight();
                                        heightimg=350;
                                    }
                                    else if(Screensize.getWidth()>=1536&&Screensize.getWidth()<1920){
                                        widthimg=(imageRI.getWidth()*300)/imageRI.getHeight();
                                        heightimg=300;
                                    }
                                    else{
                                        widthimg=(imageRI.getWidth()*250)/imageRI.getHeight();
                                        heightimg=250;
                                    }
                                    imagelblRI.setIcon(new ImageIcon(ImageIO.read(file1).getScaledInstance(widthimg, heightimg, Image.SCALE_SMOOTH)));
                                } catch (IOException e) {
                                    showerror(e);
                                }

                            }
                            
                        }
                        
                    });
                   
                    
                }
                
            });
        }

        if(e.getSource()==text){


            if(Screensize.getWidth()==1920){
                this.toplblET.setVisible(true);
                if(toplblET1!=null){this.toplblET1.setVisible(false);}
                if(toplblET2!=null){this.toplblET2.setVisible(false);}
            }
            else if(Screensize.getWidth()>=1536&&Screensize.getWidth()<1920){
                if(Admincontrols.isVisible()){closeAdminPanel.doClick();}
                if(toplblET!=null){this.toplblET.setVisible(false);}
                this.toplblET1.setVisible(true);
                if(toplblET2!=null){this.toplblET2.setVisible(false);}
            }
            else
            {
                if(Admincontrols.isVisible()){closeAdminPanel.doClick();}

                if(toplblET!=null){this.toplblET.setVisible(false);}
                if(toplblET1!=null){this.toplblET1.setVisible(false);}
                this.toplblET2.setVisible(true);
            }
            exporttextET.setVisible(true);
            toplabelcoverET.setVisible(true);
            this.addgymmem.setVisible(false);
            if(addgymmem1!=null){this.addgymmem1.setVisible(false);}
            removegymmem.setVisible(false);
            toplabelcoverRGC.setVisible(false);
            this.toplabelcover1.setVisible(false);
            this.menupanel.setVisible(false);
            this.p1.setVisible(false);
            this.p2.setVisible(false);
            this.p3.setVisible(false);
            viewAdminControls.setEnabled(false);

            if(Screensize.getWidth()==1920){
                String tablename=nameofTabelenow.substring(0, 1)+nameofTabelenow.substring(1,nameofTabelenow.length()-4).toLowerCase()+"  "+nameofTabelenow.substring(nameofTabelenow.length()-4,nameofTabelenow.length());
                if(monthsoptionaET.getSelectedItem().equals(nameofTabelenow)){

                    exportfileareaET.setText("\t\t\t\t   "+tablename+"\t\t\t\t\n");
                    exportfileareaET.append("\t\t\t\t--------------------\t\t\t\t\n");

                    exportfileareaET.append("\n");
                    exportfileareaET.append("-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------\n");
                    exportfileareaET.append(String.format("%-10s", "     ID")+"     \t          "+String.format("%-20s","    NAME   ")+"                "+String.format("%-20s","CNIC")+"           "+String.format("%-20s","       Phone")
                    +"         "+String.format("%-15s","       Fee")+"    "+String.format("%-15s","       Name of Admin")+"       "+String.format("%-20s","         Date of Last Fee")+"      "+String.format("%-20s","         Date of Join\n"));
                    exportfileareaET.append("-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------\n");
                    
                    ArrayList<gymclient> allmems=selectfromtable(nameofTabelenow);
                    for(int i=0;i<allmems.size();i++){                       
                        for(int j=i+1;j<allmems.size();j++){
                            gymclient i1=allmems.get(i);
                            gymclient j1=allmems.get(j);
                            int id1=Integer.valueOf(allmems.get(i).getIDuser().substring(4));
                            int id2=Integer.valueOf(allmems.get(j).getIDuser().substring(4));
                            if(id1>id2){
                                allmems.set(i, j1);
                                allmems.set(j, i1);
                            }                                                    
                        
                        }
                        
                    }

                    if(!allmems.isEmpty()){

                        for (gymclient i : allmems) {
                            String dateoffeee="       -";
                            String dateofjoin=i.getJoining().toString();
                            if(i.getDateoffee()!=null){
                                dateoffeee=i.getDateoffee().toString();
                            }
                            else{
                                dateofjoin="        "+i.getJoining().toString();
                            }
                            exportfileareaET.append(String.format("%-15s %20s  %-30s  %-30s %-20s %-30s %-30s %-30s","  "+i.getIDuser(),i.getNameUser()
                            ,"\t"+i.getCnic(),"+92"+i.getPhone().toString(),i.getFee(),i.getNameofAdmin(),
                            dateoffeee,dateofjoin));

                            exportfileareaET.append("\n");
                        
                            
                        }
                    }

                }


            } 
            else if(Screensize.getWidth()>=1536&&Screensize.getWidth()<1920){
                String tablename=nameofTabelenow.substring(0, 1)+nameofTabelenow.substring(1,nameofTabelenow.length()-4).toLowerCase()+"  "+nameofTabelenow.substring(nameofTabelenow.length()-4,nameofTabelenow.length());
                if(monthsoptionaET.getSelectedItem().equals(nameofTabelenow)){

                    exportfileareaET.setText("\t\t\t\t   "+tablename+"\t\t\t\t\n");
                    exportfileareaET.append("\t\t\t\t--------------------\t\t\t\t\n");

                    exportfileareaET.append("\n");
                    exportfileareaET.append("-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------\n");
                    exportfileareaET.append(String.format("%-10s", "     ID")+"     \t          "+String.format("%-20s","    NAME   ")+"                "+String.format("%-20s","CNIC")+"           "+String.format("%-20s","       Phone")
                    +"         "+String.format("%-15s","       Fee")+"    "+String.format("%-15s","       Name of Admin")+"       "+String.format("%-20s","         Date of Last Fee")+"      "+String.format("%-20s","         Date of Join\n"));
                    exportfileareaET.append("-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------\n");
                    
                    ArrayList<gymclient> allmems=selectfromtable(nameofTabelenow);
                    for(int i=0;i<allmems.size();i++){                       
                        for(int j=i+1;j<allmems.size();j++){
                            gymclient i1=allmems.get(i);
                            gymclient j1=allmems.get(j);
                            int id1=Integer.valueOf(allmems.get(i).getIDuser().substring(4));
                            int id2=Integer.valueOf(allmems.get(j).getIDuser().substring(4));
                            if(id1>id2){
                                allmems.set(i, j1);
                                allmems.set(j, i1);
                            }                                                    
                        
                        }
                        
                    }

                    if(!allmems.isEmpty()){

                        for (gymclient i : allmems) {
                            String dateoffeee="       -";
                            String dateofjoin=i.getJoining().toString();
                            if(i.getDateoffee()!=null){
                                dateoffeee=i.getDateoffee().toString();
                            }
                            else{
                                dateofjoin="        "+i.getJoining().toString();
                            }
                            exportfileareaET.append(String.format("%-15s %20s  %-30s  %-30s %-20s %-30s %-30s %-30s","  "+i.getIDuser(),i.getNameUser()
                            ,"\t"+i.getCnic(),"+92"+i.getPhone().toString(),i.getFee(),i.getNameofAdmin(),
                            dateoffeee,dateofjoin));

                            exportfileareaET.append("\n");
                        
                            
                        }
                    }

                }
            } 
            else{
                String tablename=nameofTabelenow.substring(0, 1)+nameofTabelenow.substring(1,nameofTabelenow.length()-4).toLowerCase()+"  "+nameofTabelenow.substring(nameofTabelenow.length()-4,nameofTabelenow.length());
                if(monthsoptionaET.getSelectedItem().equals(nameofTabelenow)){

                    exportfileareaET.setText("\t\t\t\t   "+tablename+"\t\t\t\t\n");
                    exportfileareaET.append("\t\t\t\t--------------------\t\t\t\t\n");

                    exportfileareaET.append("\n");
                    exportfileareaET.append("-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------\n");
                    exportfileareaET.append(String.format("%-10s", "     ID")+"     \t          "+String.format("%-20s","    NAME   ")+"                "+String.format("%-20s","CNIC")+"           "+String.format("%-20s","       Phone")
                    +"         "+String.format("%-15s","       Fee")+"    "+String.format("%-15s","       Name of Admin")+"       "+String.format("%-20s","         Date of Last Fee")+"      "+String.format("%-20s","         Date of Join\n"));
                    exportfileareaET.append("-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------\n");
                    
                    ArrayList<gymclient> allmems=selectfromtable(nameofTabelenow);
                    for(int i=0;i<allmems.size();i++){                       
                        for(int j=i+1;j<allmems.size();j++){
                            gymclient i1=allmems.get(i);
                            gymclient j1=allmems.get(j);
                            int id1=Integer.valueOf(allmems.get(i).getIDuser().substring(4));
                            int id2=Integer.valueOf(allmems.get(j).getIDuser().substring(4));
                            if(id1>id2){
                                allmems.set(i, j1);
                                allmems.set(j, i1);
                            }                                                    
                        
                        }
                        
                    }

                    if(!allmems.isEmpty()){

                        for (gymclient i : allmems) {
                            String dateoffeee="       -";
                            String dateofjoin=i.getJoining().toString();
                            if(i.getDateoffee()!=null){
                                dateoffeee=i.getDateoffee().toString();
                            }
                            else{
                                dateofjoin="        "+i.getJoining().toString();
                            }
                            exportfileareaET.append(String.format("%-15s %20s  %-30s  %-30s %-20s %-30s %-30s %-30s","  "+i.getIDuser(),i.getNameUser()
                            ,"\t"+i.getCnic(),"+92"+i.getPhone().toString(),i.getFee(),i.getNameofAdmin(),
                            dateoffeee,dateofjoin));

                            exportfileareaET.append("\n");
                        
                            
                        }
                    }

                }

            }
        
        }

        if(e.getSource()==exportButtonET){

            if(!exportfileareaET.getText().isEmpty()){
            
                javafx.application.Platform.runLater(new Runnable(){

                    @Override
                    public void run() {

                        FileChooser fileChooser=new FileChooser();
                        FileChooser.ExtensionFilter filter1=new ExtensionFilter("txt files", ("*.txt"));
                        fileChooser.getExtensionFilters().add(filter1);
                        File file1=fileChooser.showSaveDialog(null);


                        SwingUtilities.invokeLater(new Runnable(){

                            @Override
                            public void run() {


                                path=file1.toString();
                                if(path!=null){

                                    try {
                                        FileWriter frite=new FileWriter(path);
    
                                        if(monthsoptionaET.getSelectedItem().equals(nameofTabelenow)){
                                            String tablename=nameofTabelenow.substring(0, 1)+nameofTabelenow.substring(1,nameofTabelenow.length()-4).toLowerCase()+"  "+nameofTabelenow.substring(nameofTabelenow.length()-4,nameofTabelenow.length());
    
                                            frite.write("\t\t\t\t   "+tablename+"\t\t\t\t\n");
                                            frite.write("\t\t\t\t--------------------\t\t\t\t\n");
    
                                            frite.write("\n");
                                            frite.write("-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------\n");
                                            frite.write(String.format("%-10s", "     ID")+"     \t          "+String.format("%-20s","    NAME   ")+String.format("%-20s","CNIC")+" "+String.format("%-20s","       Phone")
                                            +"         "+String.format("%-15s","       Fee")+"    "+String.format("%-15s","       Name of Admin")+"       "+String.format("%-20s","         Date of Last Fee")+"      "+String.format("%-20s","         Date of Join\n"));
                                            frite.write("-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------\n");
                                            
                                            ArrayList<gymclient> allmems=selectfromtable(nameofTabelenow);
                                            for(int i=0;i<allmems.size();i++){                       
                                                for(int j=i+1;j<allmems.size();j++){
                                                    gymclient i1=allmems.get(i);
                                                    gymclient j1=allmems.get(j);
                                                    int id1=Integer.valueOf(allmems.get(i).getIDuser().substring(4));
                                                    int id2=Integer.valueOf(allmems.get(j).getIDuser().substring(4));
                                                    if(id1>id2){
                                                        allmems.set(i, j1);
                                                        allmems.set(j, i1);
                                                    }                                                    
                                                
                                                }
                                                
                                            }
    
                                            if(!allmems.isEmpty()){
    
                                                for (gymclient i : allmems) {
                                                    String dateoffeee="       -          ";
                                                    if(i.getDateoffee()!=null){
                                                        dateoffeee=i.getDateoffee().toString();
                                                    }
    
                                                    frite.write(String.format("%-15s %20s  %-30s  %-30s %-20s %-30s %-30s %-30s","  "+i.getIDuser(),i.getNameUser()
                                                    ,"\t"+i.getCnic(),"+92"+i.getPhone().toString(),i.getFee(),i.getNameofAdmin(),
                                                    dateoffeee,i.getJoining().toString()));
    
                                                    frite.write("\n");

                                                
                                                    
                                                }
                                                frite.close();
                                                setlookandfeelGreen();
                                                JOptionPane.showMessageDialog(null, "Text File Exported Successfully", "Result", JOptionPane.INFORMATION_MESSAGE);
                                            }
    
                                        }
                                        else{
                                            String optionselected=monthsoptionaET.getSelectedItem().toString();
                                            String tablename=optionselected.substring(0, 1)+optionselected.substring(1,optionselected.length()-4).toLowerCase()+"  "+optionselected.substring(optionselected.length()-4,optionselected.length());
    
                                            frite.write("\t\t\t\t   "+tablename+"\t\t\t\t\n");
                                            frite.write("\t\t\t\t--------------------\t\t\t\t\n");
    
                                            frite.write("\n");
                                            frite.write("-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------\n");
                                            frite.write(String.format("%-10s", "     ID")+"     \t          "+String.format("%-20s","    NAME   ")+String.format("%-20s","CNIC")+" "+String.format("%-20s","       Phone")
                                            +"         "+String.format("%-15s","       Fee")+"    "+String.format("%-15s","       Name of Admin")+"       "+String.format("%-20s","         Date of Last Fee")+"      "+String.format("%-20s","         Date of Join\n"));
                                            frite.write("-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------\n");
                                            
                                            ArrayList<gymclient> allmems=selectfromtable(optionselected);
                                            for(int i=0;i<allmems.size();i++){                       
                                                for(int j=i+1;j<allmems.size();j++){
                                                    gymclient i1=allmems.get(i);
                                                    gymclient j1=allmems.get(j);
                                                    int id1=Integer.valueOf(allmems.get(i).getIDuser().substring(4));
                                                    int id2=Integer.valueOf(allmems.get(j).getIDuser().substring(4));
                                                    if(id1>id2){
                                                        allmems.set(i, j1);
                                                        allmems.set(j, i1);
                                                    }                                                    
                                                
                                                }
                                                
                                            }
    
                                            if(!allmems.isEmpty()){
    
                                                for (gymclient i : allmems) {
                                                    String dateoffeee="       -         ";
                                                    if(i.getDateoffee()!=null){
                                                        dateoffeee=i.getDateoffee().toString();
                                                    }
    
                                                    frite.write(String.format("%-15s %20s  %-30s  %-30s %-20s %-30s %-30s %-30s","  "+i.getIDuser(),i.getNameUser()
                                                    ,"\t"+i.getCnic(),"+92"+i.getPhone().toString(),i.getFee(),i.getNameofAdmin(),
                                                    dateoffeee,i.getJoining().toString()));
    
                                                    frite.write("\n");


                                                
                                                    
                                                }
                                                frite.close();
                                                setlookandfeelGreen();
                                                JOptionPane.showMessageDialog(null, "Text File Exported Successfully", "Result", JOptionPane.INFORMATION_MESSAGE);

                                            }
    
                                        
                                        
                                        
                                        
                                        }
                                        
    
    
    
    
                                    } catch (IOException e) {
                                        setlookandfeelRed();
                                        JOptionPane.showMessageDialog(null, "Export Failed!!!  "+e.getLocalizedMessage(), "Export Failed", 0);
                                    }
    
                                }

                            }
                            
                        });
                        
                        
                        
                    }
                        

                });

            }
        }

    
        if(e.getSource()==excel){
            if(Screensize.getWidth()==1920){
                if(Admincontrols.isVisible()){closeAdminPanel.doClick();}
                this.toplblEE.setVisible(true);
                if(toplblEE1!=null){this.toplblEE1.setVisible(false);}
                if(toplblEE2!=null){this.toplblEE2.setVisible(false);}
            }
            else if(Screensize.getWidth()>=1536&&Screensize.getWidth()<1920){
                if(Admincontrols.isVisible()){closeAdminPanel.doClick();}
                if(toplblEE!=null){this.toplblEE.setVisible(false);}
                this.toplblEE1.setVisible(true);
                if(toplblEE2!=null){this.toplblEE2.setVisible(false);}
            }
            else
            {
                if(toplblEE!=null){this.toplblEE.setVisible(false);}
                if(toplblEE1!=null){this.toplblEE1.setVisible(false);}
                this.toplblEE2.setVisible(true);
            }
            exportexcelEE.setVisible(true);
            toplabelcoverEE.setVisible(true);
            this.addgymmem.setVisible(false);
            if(addgymmem1!=null){this.addgymmem1.setVisible(false);}
            removegymmem.setVisible(false);
            toplabelcoverRGC.setVisible(false);
            this.toplabelcover1.setVisible(false);
            this.menupanel.setVisible(false);
            this.p1.setVisible(false);
            this.p2.setVisible(false);
            this.p3.setVisible(false);
            viewAdminControls.setEnabled(false);

        }


        if(e.getSource()==exportButtonEE){

            if(monthsoptionaEE.getSelectedItem().equals(nameofTabelenow)){

                Platform.runLater(new Runnable(){

                    @Override
                    public void run() {
                        FileChooser fileChooser=new FileChooser();
                        FileChooser.ExtensionFilter filter1=new ExtensionFilter("Excel files", ("*.xlsx"));
                        fileChooser.getExtensionFilters().add(filter1);
                        File file1=fileChooser.showSaveDialog(null);

                        SwingUtilities.invokeLater(new Runnable(){

                            @Override
                            public void run() {

                                ArrayList<gymclient>  data=selectfromtable(nameofTabelenow);
                                for(int i=0;i<data.size();i++){                       
                                    for(int j=i+1;j<data.size();j++){
                                        gymclient i1=data.get(i);
                                        gymclient j1=data.get(j);
                                        int id1=Integer.valueOf(data.get(i).getIDuser().substring(4));
                                        int id2=Integer.valueOf(data.get(j).getIDuser().substring(4));
                                        if(id1>id2){
                                            data.set(i, j1);
                                            data.set(j, i1);
                                        }                                                    
                                    
                                    }                                 
                                }
                                if(!data.isEmpty()&&file1!=null){

                                    try {
                                
                                        XSSFWorkbook workbook=new XSSFWorkbook();
                                        XSSFSheet sheet1=workbook.createSheet(nameofTabelenow);
                                        XSSFFont font = workbook.createFont();
                                        XSSFFont font1= workbook.createFont();
                                        
                                        font.setFontHeightInPoints((short)20);		    
                                        font.setFontName("Times New Roman");                                        
                                        font.setItalic(false);
                                        font.setStrikeout(false);
                                        font.setBold(true);
                                        CellStyle style = workbook.createCellStyle();
                                        font1.setFontHeightInPoints((short)16);		    
                                        font1.setFontName("Goudy Old Style");
                                        font1.setItalic(true);
                                        font1.setStrikeout(false);
                                        font1.setBold(false);
                                        CellStyle style1 = workbook.createCellStyle();
                                        

                                       
                                        style.setFont(font);
                                        style1.setFont(font1);

                                        
                                        ArrayList<Integer> indexspreadsheet=new ArrayList<Integer>();

                                        for(int i=0;i<data.size();i++)
                                        {
                                            indexspreadsheet.add(i);
                                        }
                        
                
                                        for(int i=-1;i<indexspreadsheet.size();i++)
                                        {   
                                            XSSFRow row=sheet1.createRow(i+1);
                                           
                                            if(i==-1){
                                                for(int j=0;j<8;j++)
                                                {
                                                    XSSFCell cell=row.createCell(j);
                                                    cell.setCellStyle(style);
                                                    if(j==0)
                                                    {
                                                        cell.setCellValue("ID");
                                                        
                                                    }
                                                    if(j==1)
                                                    {
                                                        
                                                        cell.setCellValue("Name");
                                                        
                                                    }
                                                    if(j==2)
                                                    {
                                                        
                                                        
                                                        cell.setCellValue("CNIC");
                                                        
                                                    }
                                                    if(j==3)
                                                    {
                                                        
                                                        
                                                        cell.setCellValue("Phone Number");
                                                        
                                                    }
                                                    if(j==4)
                                                    {
                                                        
                                                        
                                                        cell.setCellValue("Fee");
                                                        
                                                    }
                                                    if(j==5)
                                                    {
                                                        
                                                        
                                                        cell.setCellValue("Name of Admin");
                                                        
                                                    }
                                                    if(j==6)
                                                    {
                                                        String dateofee="Date of Fee";                                                        
                                                        cell.setCellValue(dateofee);
                                                        
                                                    }
                                                    if(j==7)
                                                    {
                                                      
                                                        cell.setCellValue("Date of Join");
                                                        
                                                    }
                        
                                                }
                                            }
                                            else{
                                                for(int j=0;j<8;j++)
                                                {
                                                    XSSFCell cell=row.createCell(j);
                                                    cell.setCellStyle(style1);
                                                    if(j==0)
                                                    {
                                                        cell.setCellValue(data.get(i).getIDuser());
                                                    }
                                                    if(j==1)
                                                    {
                                                        
                                                        cell.setCellValue(data.get(i).getNameUser());
                                                        
                                                    }
                                                    if(j==2)
                                                    {
                                                        
                                                        
                                                        cell.setCellValue(data.get(i).getCnic());
                                                        
                                                    }
                                                    if(j==3)
                                                    {
                                                        
                                                        
                                                        cell.setCellValue(data.get(i).getPhone());
                                                        
                                                    }
                                                    if(j==4)
                                                    {
                                                        
                                                        
                                                        cell.setCellValue(data.get(i).getFee());
                                                        
                                                    }
                                                    if(j==5)
                                                    {
                                                        
                                                        
                                                        cell.setCellValue(data.get(i).getNameofAdmin());
                                                        
                                                    }
                                                    if(j==6)
                                                    {
                                                        String dateofee="-";
                                                        if((data.get(i).getDateoffee()!=null)){
                                                            dateofee=data.get(i).getDateoffee().toString();
                                                        }
                                                        
                                                        cell.setCellValue(dateofee);
                                                        
                                                    }
                                                    if(j==7)
                                                    {
                                                      
                                                        cell.setCellValue(data.get(i).getJoining().toString());
                                                        
                                                    }
                        
                                                }
                                            }

                                        
                                        }
                                    
                                        sheet1.autoSizeColumn(0);
                                        sheet1.autoSizeColumn(1);
                                        sheet1.autoSizeColumn(2);
                                        sheet1.autoSizeColumn(3);
                                        sheet1.autoSizeColumn(4);
                                        sheet1.autoSizeColumn(5);
                                        sheet1.autoSizeColumn(6);
                                        sheet1.autoSizeColumn(7);
                                        sheet1.autoSizeColumn(8);
                    
                                        FileOutputStream fileout=new FileOutputStream(file1);
                                        workbook.write(fileout);
                                        fileout.close();
                                        workbook.close();

                                        setlookandfeelGreen();
                                        JOptionPane.showMessageDialog(null,"Successfully Exported","Export Successfull", JOptionPane.INFORMATION_MESSAGE);

                                    } catch ( IOException e6) {
                                        setlookandfeelRed();
                                        JOptionPane.showMessageDialog(null,"Exporting Failed!!!  "+e6.getMessage(),"Export Failed", JOptionPane.ERROR_MESSAGE);
                                    }

                                }

                                
                            }
                            
                        });


                    }
                    
                });

            }
            else{
                String nameoftable=monthsoptionaEE.getSelectedItem().toString();
                Platform.runLater(new Runnable(){

                    @Override
                    public void run() {
                        FileChooser fileChooser=new FileChooser();
                        FileChooser.ExtensionFilter filter1=new ExtensionFilter("Excel files", ("*.xlsx"));
                        fileChooser.getExtensionFilters().add(filter1);
                        File file1=fileChooser.showSaveDialog(null);

                        SwingUtilities.invokeLater(new Runnable(){

                            @Override
                            public void run() {

                                ArrayList<gymclient>  data=selectfromtable(nameoftable);
                                for(int i=0;i<data.size();i++){                       
                                    for(int j=i+1;j<data.size();j++){
                                        gymclient i1=data.get(i);
                                        gymclient j1=data.get(j);
                                        int id1=Integer.valueOf(data.get(i).getIDuser().substring(4));
                                        int id2=Integer.valueOf(data.get(j).getIDuser().substring(4));
                                        if(id1>id2){
                                            data.set(i, j1);
                                            data.set(j, i1);
                                        }                                                    
                                    
                                    }                                 
                                }
                                if(!data.isEmpty()&&file1!=null){

                                    try {
                                
                                        XSSFWorkbook workbook=new XSSFWorkbook();
                                        XSSFSheet sheet1=workbook.createSheet(nameoftable.toUpperCase());
                                        XSSFFont font = workbook.createFont();
                                        XSSFFont font1= workbook.createFont();

                                        font.setFontHeightInPoints((short)20);		    
                                        font.setFontName("Times New Roman");
                                        font.setItalic(false);
                                        font.setStrikeout(false);
                                        font.setBold(true);
                                        CellStyle style = workbook.createCellStyle();
                                        font1.setFontHeightInPoints((short)16);		    
                                        font1.setFontName("Goudy Old Style");
                                        font1.setItalic(true);
                                        font1.setStrikeout(false);
                                        font1.setBold(false);
                                        CellStyle style1 = workbook.createCellStyle();

                                        
                                        style.setFont(font);
                                        style1.setFont(font1);

                                        ArrayList<Integer> indexspreadsheet=new ArrayList<Integer>();

                                        for(int i=0;i<data.size();i++)
                                        {
                                            indexspreadsheet.add(i);
                                        }
                        
                
                                       
                                        for(int i=-1;i<indexspreadsheet.size();i++)
                                        {   
                                            XSSFRow row=sheet1.createRow(i+1);
                                            
                                            if(i==-1){
                                                for(int j=0;j<8;j++)
                                                {
                                                    XSSFCell cell=row.createCell(j);
                                                    cell.setCellStyle(style);
                                                    if(j==0)
                                                    {
                                                        cell.setCellValue("ID");
                                                    }
                                                    if(j==1)
                                                    {
                                                        
                                                        cell.setCellValue("Name");
                                                        
                                                    }
                                                    if(j==2)
                                                    {
                                                        
                                                        
                                                        cell.setCellValue("CNIC");
                                                        
                                                    }
                                                    if(j==3)
                                                    {
                                                        
                                                        
                                                        cell.setCellValue("Phone Number");
                                                        
                                                    }
                                                    if(j==4)
                                                    {
                                                        
                                                        
                                                        cell.setCellValue("Fee");
                                                        
                                                    }
                                                    if(j==5)
                                                    {
                                                        
                                                        
                                                        cell.setCellValue("Name of Admin");
                                                        
                                                    }
                                                    if(j==6)
                                                    {
                                                        String dateofee="Date of Fee";                                                        
                                                        cell.setCellValue(dateofee);
                                                        
                                                    }
                                                    if(j==7)
                                                    {
                                                      
                                                        cell.setCellValue("Date of Join");
                                                        
                                                    }
                        
                                                }
                                            }
                                            else{
                                                for(int j=0;j<8;j++)
                                                {
                                                    XSSFCell cell=row.createCell(j);
                                                    cell.setCellStyle(style1);

                                                    if(j==0)
                                                    {
                                                        cell.setCellValue(data.get(i).getIDuser());
                                                    }
                                                    if(j==1)
                                                    {
                                                        
                                                        cell.setCellValue(data.get(i).getNameUser());
                                                        
                                                    }
                                                    if(j==2)
                                                    {
                                                        
                                                        
                                                        cell.setCellValue(data.get(i).getCnic());
                                                        
                                                    }
                                                    if(j==3)
                                                    {
                                                        
                                                        
                                                        cell.setCellValue(data.get(i).getPhone());
                                                        
                                                    }
                                                    if(j==4)
                                                    {
                                                        
                                                        
                                                        cell.setCellValue(data.get(i).getFee());
                                                        
                                                    }
                                                    if(j==5)
                                                    {
                                                        
                                                        
                                                        cell.setCellValue(data.get(i).getNameofAdmin());
                                                        
                                                    }
                                                    if(j==6)
                                                    {
                                                        String dateofee="-";
                                                        if((data.get(i).getDateoffee()!=null)){
                                                            dateofee=data.get(i).getDateoffee().toString();
                                                        }
                                                        
                                                        cell.setCellValue(dateofee);
                                                        
                                                    }
                                                    if(j==7)
                                                    {
                                                      
                                                        cell.setCellValue(data.get(i).getJoining().toString());
                                                        
                                                    }
                        
                                                }
                                            }

                                        
                                        }
                                    
                                    
                                        sheet1.autoSizeColumn(0);
                                        sheet1.autoSizeColumn(1);
                                        sheet1.autoSizeColumn(2);
                                        sheet1.autoSizeColumn(3);
                                        sheet1.autoSizeColumn(4);
                                        sheet1.autoSizeColumn(5);
                                        sheet1.autoSizeColumn(6);
                                        sheet1.autoSizeColumn(7);
                                        sheet1.autoSizeColumn(8);
                    
                                        FileOutputStream fileout=new FileOutputStream(file1);
                                        workbook.write(fileout);
                                        fileout.close();
                                        workbook.close();

                                        setlookandfeelGreen();
                                        JOptionPane.showMessageDialog(null,"Successfully Exported","Export Successfull", JOptionPane.INFORMATION_MESSAGE);

                                    } catch ( IOException e6) {
                                        setlookandfeelRed();
                                        JOptionPane.showMessageDialog(null,"Exporting Failed!!!   "+e6.getLocalizedMessage(),"Export Failed", JOptionPane.ERROR_MESSAGE);
                                    }

                                }

                                
                            }
                            
                        });


                    }
                    
                });

            }


        }

        if(e.getSource()==backbtnAF){
            searchlblAF.setVisible(true);
            searchoptionsAF.setVisible(true);
            namefldAF.setVisible(false);
            idfldAF.setVisible(false);
            searchbtnAF.setVisible(true);
            clearbtnAF.setVisible(true);
            tablecontainerAF.setVisible(true);
            instructionAF.setVisible(true);
            addfeeAF.setVisible(true);



            imagelblAF.setVisible(false);
            nameilblAF.setVisible(false);
            idilblAF.setVisible(false);
            cnicilblAF.setVisible(false);
            phoneilblAF.setVisible(false);
            dateofjoinilblAF.setVisible(false);
            feeilblAF.setVisible(false);
            feelblAF.setVisible(false);
            backbtnAF.setVisible(false);

            nameifldAF.setVisible(false);
            idifldAF.setVisible(false);
            cnicifldAF.setVisible(false);
            phoneifldAF.setVisible(false);
            dateofjoinifldAF.setVisible(false);
            feeifldAF.setVisible(false);
            feefldAF.setVisible(false);

            nameifldAF.setText(null);
            idifldAF.setText(null);
            cnicifldAF.setText(null);
            phoneifldAF.setText(null);
            dateofjoinifldAF.setText(null);
            feeifldAF.setText(null);
            if(Screensize.getWidth()==1920){imagelblAF.setIcon(new ImageIcon(new ImageIcon(getClass().getResource("icons/deafultpic3.png")).getImage().getScaledInstance(350, 350, Image.SCALE_SMOOTH)));}
            else if(Screensize.getWidth()>=1536&&Screensize.getWidth()<1920){
                imagelblAF.setIcon(new ImageIcon(new ImageIcon(getClass().getResource("icons/deafultpic3.png")).getImage().getScaledInstance(300, 300, Image.SCALE_SMOOTH)));
            }
            else{
                imagelblAF.setIcon(new ImageIcon(new ImageIcon(getClass().getResource("icons/deafultpic3.png")).getImage().getScaledInstance(250, 250, Image.SCALE_SMOOTH)));
            }
            
        }

        if(e.getSource()==backbtnMF){
            nameifldMF.setText(null);
            idifldMF.setText(null);
            cnicifldMF.setText(null);
            phoneifldMF.setText(null);
            dateofjoinifldMF.setText(null);
            feeifldMF.setText(null);
            if(Screensize.getWidth()==1920){imagelblMF.setIcon(new ImageIcon(new ImageIcon(getClass().getResource("icons/deafultpic3.png")).getImage().getScaledInstance(400, 400, Image.SCALE_SMOOTH)));}
            else if(Screensize.getWidth()>=1536&&Screensize.getWidth()<1920){
                imagelblMF.setIcon(new ImageIcon(new ImageIcon(getClass().getResource("icons/deafultpic3.png")).getImage().getScaledInstance(350, 350, Image.SCALE_SMOOTH)));
            }
            else{
                imagelblMF.setIcon(new ImageIcon(new ImageIcon(getClass().getResource("icons/deafultpic3.png")).getImage().getScaledInstance(300, 300, Image.SCALE_SMOOTH)));
            }

            
            nameifldMF.setVisible(false);
            idifldMF.setVisible(false);
            phoneifldMF.setVisible(false);
            cnicifldMF.setVisible(false);
            dateofjoinifldMF.setVisible(false);
            feeifldMF.setVisible(false);

            nameilblMF.setVisible(false);
            idilblMF.setVisible(false);
            cnicilblMF.setVisible(false);
            phoneilblMF.setVisible(false);
            dateofjoinilblMF.setVisible(false);
            feeilblMF.setVisible(false);

            backbtnMF.setVisible(false);
            imagelblMF.setVisible(false);

            tablecontainerMF.setVisible(true);
            showtableMF.setVisible(false);
            HidetableMF.setVisible(true);
            strengthfldMF.setVisible(true);
            feecollectionfldMF.setVisible(true);
            feependfldMF.setVisible(true);
            feependingMF.setVisible(true);
            feecollectedlblMF.setVisible(true);
            totalstrengthlblMF.setVisible(true);
            reveueMF.setVisible(true);
            ExpensesMF.setVisible(true);
            ProfitMF.setVisible(true);
            revenuefldMF.setVisible(true);
            expensefldMF.setVisible(true);
            profitfldMF.setVisible(true);
            monthslblMF.setVisible(true);
            monthsoptionaMF.setVisible(true);
            totalfeefldMF.setVisible(true);
            totalfeelblMF.setVisible(true);


        }

    }
 
    
    void setlookandfeelGreen()
    {
        JDialog.setDefaultLookAndFeelDecorated(true);
        UIManager.put("OptionPane.messageFont", new Font("Goudy Old Style",0,20));
        UIManager.put("OptionPane.background", new Color(20,20,20));
        UIManager.put("OptionPane.messageForeground", Color.green);
        UIManager.put("Panel.background", new Color(20,20,20));
        UIManager.put("OptionPane.buttonFont", new Font("Mv Boli",0,15));
    }

    void setlookandfeelRed()
    {
        JDialog.setDefaultLookAndFeelDecorated(true);
        UIManager.put("OptionPane.messageFont", new Font("Goudy Old Style",0,20));
        UIManager.put("OptionPane.background", new Color(20,20,20));
        UIManager.put("OptionPane.messageForeground", Color.WHITE);
        UIManager.put("Panel.background", new Color(20,20,20));
        UIManager.put("OptionPane.buttonFont", new Font("Mv Boli",0,15));
    }
    void setlookandfeelBlue()
    {
        JDialog.setDefaultLookAndFeelDecorated(true);
        UIManager.put("OptionPane.messageFont", new Font("Goudy Old Style",0,20));
        UIManager.put("OptionPane.background", new Color(20,20,20));
        UIManager.put("OptionPane.messageForeground", new Color(0,180,255));
        UIManager.put("Panel.background", new Color(20,20,20));
        UIManager.put("OptionPane.buttonFont", new Font("Mv Boli",0,10));
    }


    void showDate(){
        Date d = new Date();
        SimpleDateFormat D = new SimpleDateFormat("dd-MM-YYYY");
        datenow.setText(D.format(d));
        
        
    }

    void showTime(){
        
        new Timer(0 , new ActionListener(){
            
            @Override
            public void actionPerformed(ActionEvent e){
                Date d = new Date();
        
                SimpleDateFormat t = new SimpleDateFormat("HH:mm:ss a");
                timenow.setText(t.format(d));
            }
        }).start();

    }



    @Override
    public void itemStateChanged(ItemEvent e) 
    {
        if(confirmfldAU.isSelected())
        {
            Boolean name=false,password=false,usertype=false,phone=false;
            if(!this.userNamefldAU.getText().isBlank())
            {
                name=true;
            }
            else
            {
                setlookandfeelRed();
                JOptionPane.showMessageDialog(null, "Name Field cannot be Empty", "Error", JOptionPane.ERROR_MESSAGE);
            }
            if(!String.valueOf(this.pswfldAU.getPassword()).isBlank())
            {
                password=true;
            }
            else
            {
                setlookandfeelRed();
                JOptionPane.showMessageDialog(null, "Password Field cannot be Empty", "Error", JOptionPane.ERROR_MESSAGE);
            }
            if(this.utypefldAU.getSelectedIndex()!=0)
            {
                usertype=true;
            }
            else
            {
                setlookandfeelRed();
                JOptionPane.showMessageDialog(null, "Select User Type", "Error", JOptionPane.ERROR_MESSAGE);
            }
            if(!this.phonefldAU.getText().isBlank()&&Long.valueOf(phonefldAU.getText())!=0L)
            {
                phone=true;
            }
            else
            {
                setlookandfeelRed();
                JOptionPane.showMessageDialog(null, "Phone Field cannot be Empty", "Error", JOptionPane.ERROR_MESSAGE);
            }

            if(name&&password&&usertype&&phone)
            {
                this.confirmfldAU.setSelected(true);
                this.adduserButton.setEnabled(true);

            }
            else
            {
                this.confirmfldAU.setSelected(false);
                this.adduserButton.setEnabled(false);
            }
        }
     
        if(confirmfldRU.isSelected())
        {
            boolean name=false,passworde=false;
            if(!userNamefldRU.getText().isBlank())
            {
                name=true;
            }
            else
            {
                setlookandfeelRed();
                JOptionPane.showMessageDialog(null, "User Name Field cannot be Empty.", "Result", JOptionPane.ERROR_MESSAGE);
            }
            if((!String.valueOf(this.pswfldR.getPassword()).isBlank()))
            {
                passworde=true;
            }
            else
            {
                setlookandfeelRed();
                JOptionPane.showMessageDialog(null, "Password Field cannot be Empty.", "Result", JOptionPane.ERROR_MESSAGE);
            }

            if(name&&passworde)
            {
                this.confirmfldRU.setSelected(true);
                this.removeuserButton.setEnabled(true);
            }
            else
            {
                this.confirmfldRU.setSelected(false);
                this.removeuserButton.setEnabled(false);
            }


        }
        
        if(confirmfldCUN.isSelected())
        {
            boolean name=false,pass=false,newuser=false;
            if(!userNamefldCUN.getText().isBlank())
            {
                name=true;
            }
            else
            {
                setlookandfeelRed();
                JOptionPane.showMessageDialog(null, "Name Field Cannot bew Empty", "Result", 2);
            }
            if(!String.valueOf(pswfldRCUN.getPassword()).isBlank())
            {
                pass=true;
            }
            else
            {
                setlookandfeelRed();
                JOptionPane.showMessageDialog(null, "Password Field Cannot bew Empty", "Result", 2);
            }
            if(!newuserNamefldCUN.getText().isBlank())
            {
                newuser=true;
            }
            else
            {
                setlookandfeelRed();
                JOptionPane.showMessageDialog(null, "New User Field Cannot bew Empty", "Result", 2);
            }
            if(name&&pass&&newuser)
            {
                this.confirmfldCUN.setSelected(true);
                this.chguserNameButton.setEnabled(true);
            }
            else
            {
                this.confirmfldCUN.setSelected(false);
                this.chguserNameButton.setEnabled(false);
            }




        }
        if(confirmfldCP.isSelected())
        {
            Boolean username=false,currentpass=false,newpass=false;
            if(!userNamefldCP.getText().isBlank())
            {
                username=true;
            }
            else
            {
                setlookandfeelRed();
                JOptionPane.showMessageDialog(null, "User Name cannot be Empty.", "Result", 2);
            }
            if(!String.valueOf(pwsfldCP.getPassword()).isBlank())
            {
                currentpass=true;
            }
            else
            {
                setlookandfeelRed();
                JOptionPane.showMessageDialog(null, "Current Password field  cannot be Empty.", "Result", 2);
            }
            if(!String.valueOf(newPassCP.getPassword()).isBlank())
            {
                newpass=true;
            }
            else
            {
                setlookandfeelRed();
                JOptionPane.showMessageDialog(null, "New Password cannot be Empty.", "Result", 2);
            }
            if(username&&currentpass&&newpass)
            {
                this.confirmfldCP.setSelected(true);
                this.chgpassButton.setEnabled(true);
            }
            else
            {
                this.confirmfldCP.setSelected(false);
                this.chgpassButton.setEnabled(false);
            }

        }

        
        if(e.getSource()==feeoptions)
        {
            if(feeoptions.getSelectedIndex()==1)
            {
                if(confirmallfielsAGC.isSelected()){confirmallfielsAGC.setSelected(false);}
                feeoptions.setVisible(false);
                feeAGC.setVisible(true);
            }
        }


        if(confirmallfielsAGC.isSelected())
        {
            if(namememAGC.getText().isBlank()||idAGC.getText().isBlank()||phoneAGC.getText().isBlank()||cnicAGC.getText().isBlank()||(feeoptions.getSelectedIndex()==1&&feeAGC.getText().isBlank()))
            {
                setlookandfeelBlue();
                if(namememAGC.getText().isBlank())
                {
                    JOptionPane.showMessageDialog(null, "Name Cannot be Empty", "Input Error", JOptionPane.INFORMATION_MESSAGE);
                }
                if(idAGC.getText().isBlank())
                {
                    setlookandfeelBlue();
                    JOptionPane.showMessageDialog(null, "ID Cannot be Empty", "Input Error", JOptionPane.INFORMATION_MESSAGE);
                }
                if(phoneAGC.getText().isBlank())
                {
                    setlookandfeelBlue();
                    JOptionPane.showMessageDialog(null, "Phone Cannot be Empty", "Input Error", JOptionPane.INFORMATION_MESSAGE);
                }
                if(cnicAGC.getText().isBlank())
                {
                    setlookandfeelBlue();
                    JOptionPane.showMessageDialog(null, "CNIC Cannot be Empty", "Input Error", JOptionPane.INFORMATION_MESSAGE);
                }
                if(feeoptions.getSelectedIndex()==1&&feeAGC.getText().isBlank())
                {
                    setlookandfeelBlue();
                    JOptionPane.showMessageDialog(null, "Fee Cannot be Blank", "Input Error", JOptionPane.INFORMATION_MESSAGE);
                }

                confirmallfielsAGC.setSelected(false);
            }
            else
            {
                if(!namememAGC.getText().isBlank()){
                    ArrayList<gymclient> names=selectfromtable(this.nameofTabelenow);
                    ArrayList<String> allnames=new ArrayList<>();

                    for (gymclient member : names) {
                        allnames.add(member.getNameUser());
                    }

                    for (String namesingle : allnames) {

                        if(namesingle.equals(namememAGC.getText()))
                        {
                            this.namememAGC.setText(null);
                            setlookandfeelBlue();
                            JOptionPane.showMessageDialog(null, "This Name is Not Available, Try Another.(It Already has been Registered.)", "Name Error", 1);
                            this.confirmallfielsAGC.setSelected(false);
                            break;
                        }
                        
                    }

                }

                if(!phoneAGC.getText().isBlank()){

                    if(phoneAGC.getText().length()==11){
                        Long phone1;
                        phone1=Long.valueOf(phoneAGC.getText());
                        this.phone=phone1;
                        phoneAGC.setText("+92"+" "+phone1.toString().substring(0, 3)+" "+phone1.toString().substring(3, 10));
                    }
                    
                }
                if(!cnicAGC.getText().isBlank()){
                    if(cnicAGC.getText().length()==13){
                        String cnicnew=cnicAGC.getText().substring(0, 5)+"-"+cnicAGC.getText().substring(5, 12)+"-"+cnicAGC.getText().substring(12);
                        
                        cnicAGC.setText(cnicnew);
                    }
                }
                if(feeAGC.isVisible()&&(!feeAGC.getText().isBlank()))
                {
                    
                    if(!feeAGC.getText().contains("Rs ")){
                        try {
                            int fee=Integer.valueOf(feeAGC.getText());
                            this.feevalueAGC=fee;
                            feeAGC.setText("Rs "+fee);
                            feeAGC.setEditable(false);
                        } catch (NumberFormatException e12) {
                            this.feeAGC.setText(null);
                            this.confirmallfielsAGC.setSelected(false);
                            setlookandfeelBlue();
                            JOptionPane.showMessageDialog(null, "Enter Fee Again", "Fee Error", 1);
                            
                        }                        
                    }
                }
                if(!idAGC.getText().isBlank()){
                    ArrayList<gymclient> idsnos=selectfromtable(this.nameofTabelenow);
                    ArrayList<Integer> ids=new ArrayList<>();

                    for (gymclient member : idsnos) {
                        ids.add(Integer.valueOf(member.getIDuser().substring(4)));
                    }
                    


                    if(!idAGC.getText().contains("CCG-")){
                        
                        try {
                            int idtemp;
                            idtemp=Integer.valueOf(idAGC.getText());
                            for (Integer id : ids) {
                                if(idtemp==id)
                                {
                                    idAGC.setText(null);
                                    confirmallfielsAGC.setSelected(false);
                                    setlookandfeelBlue();
                                    JOptionPane.showMessageDialog(null, "ID is not Valid it already has been Registered, Try Another", "ID Error", JOptionPane.INFORMATION_MESSAGE);
                                    this.idAGC.setText(null);
                                    break;
                                }
                                else{

                                    this.realid=idtemp;
                                    idAGC.setText("CCG-"+realid);
                                    idAGC.setEditable(false);

                                }
         
                            }
                        } catch (NumberFormatException e123) {
                            
                        }
                    }
                }
            }
         
            
        }

        if(e.getSource()==searchoptionsSGC){

            if(searchoptionsSGC.getSelectedIndex()==1){
                idfldSGC.setVisible(true);
                searchlblSGC.setText("ID :");
                searchoptionsSGC.setVisible(false);
            }
            else if(searchoptionsSGC.getSelectedIndex()==2){
                searchlblSGC.setText("Name :");
                namefldSGC.setVisible(true);
                searchoptionsSGC.setVisible(false);
            }
            else if(searchoptionsSGC.getSelectedIndex()==3){
                searchlblSGC.setText("CNIC :");
                cnicfldSGC.setVisible(true);
                searchoptionsSGC.setVisible(false);
            }
            else if(searchoptionsSGC.getSelectedIndex()==4){
                searchlblSGC.setFont(new Font("Cooper Black",0,20));
                searchlblSGC.setText("Name of Admin :");
                nameofAdminfldSGC.setVisible(true);
                searchoptionsSGC.setVisible(false);
            }
            else if(searchoptionsSGC.getSelectedIndex()==5){
                searchlblSGC.setFont(new Font("Cooper Black",0,20));
                searchlblSGC.setText("Date of Join :");
                datechooserSGC.setVisible(true);
                searchoptionsSGC.setVisible(false);
            }

            else if(searchoptionsSGC.getSelectedIndex()==6){
                searchlblSGC.setFont(new Font("Cooper Black",0,20));
                searchlblSGC.setText("Phone Number :");
                phonefldSGC.setVisible(true);
                searchoptionsSGC.setVisible(false);

            }

        }
        
        if(e.getSource()==searchoptionsAF){

            if(searchoptionsAF.getSelectedIndex()==1){
                namefldAF.setVisible(true);
                searchlblAF.setText("Name :");
                searchoptionsAF.setVisible(false);
                searchbtnAF.setEnabled(true);
            }
            else if(searchoptionsAF.getSelectedIndex()==2){
                searchlblAF.setText("ID :");
                idfldAF.setVisible(true);
                searchoptionsAF.setVisible(false);
                searchbtnAF.setEnabled(true);

            }
            else if(searchoptionsAF.getSelectedIndex()==3){

                searchbtnAF.setEnabled(true);

            }

        }

        if(e.getSource()==monthsoptionaMF){
            if(!e.getItem().equals(nameofTabelenow)){
                ArrayList<gymclient> mems1=selectfromtable(e.getItem().toString());
                if(!mems1.isEmpty()){
                    strengthfldMF.setText(String.valueOf(mems1.size()));
                    int count=0;
                    int pending=0;
                    int reveuevalue=0;
                    for (gymclient i : mems1) {
                        if(i.isFeecheck()){
                            count++;
                            reveuevalue+=i.getFee();
                        }
                        else{
                            pending++;
                        }                        
                    }

                    feecollectionfldMF.setText(String.valueOf(count));
                    feependfldMF.setText(String.valueOf(pending));
                    revenuefldMF.setText(String.valueOf(reveuevalue));
                    if(expensefldMF.getText().isEmpty()){
                        expensefldMF.setText("0");
                    }
                    
                    if(!super.selectfromtable(e.getItem().toString()).isEmpty()){
                        ArrayList<gymclient> matches= selectfromtable(e.getItem().toString());

                        for(int i=0;i<matches.size();i++){                       
                            for(int j=i+1;j<matches.size();j++){
                                gymclient i1=matches.get(i);
                                gymclient j1=matches.get(j);
                                int id1=Integer.valueOf(matches.get(i).getIDuser().substring(4));
                                int id2=Integer.valueOf(matches.get(j).getIDuser().substring(4));
                                if(id1>id2){
                                    matches.set(i, j1);
                                    matches.set(j, i1);
                                }                                                    
                            
                            }
                            
                        }
                           
                        Object[][] rows=new Object[matches.size()][8];

                        for(int i=0;i<matches.size();i++){
                            for(int j=0;j<8;j++){
                                if(j==0){
                                    rows[i][j]=matches.get(i).getIDuser();
                                }
                                if(j==1){
                                    rows[i][j]=matches.get(i).getNameUser();
                                }
                                if(j==2){
                                    rows[i][j]=matches.get(i).getCnic();
                                }
                                if(j==3){
                                    rows[i][j]="+92".concat(matches.get(i).getPhone().toString());
                                }
                                if(j==4){
                                    rows[i][j]=matches.get(i).getFee();
                                }
                                if(j==5){
                                    rows[i][j]=matches.get(i).getNameofAdmin();
                                }
                                if(j==6){
                                    if(matches.get(i).getDateoffee()!=null){
                                        rows[i][j]=matches.get(i).getDateoffee();
                                    }
                                    else{
                                        rows[i][j]="-";
                                    }
                                }
                                if(j==7){
                                    rows[i][j]=matches.get(i).getJoining();
                                }
                            }
    
                        }
                        
                        if(Screensize.getWidth()==1920){monthtableMF.setFont(new Font("Goudy Old Style",0,22));}
                        else if(Screensize.getWidth()>=1536&&Screensize.getWidth()<1920){monthtableMF.setFont(new Font("Goudy Old Style",0,20));}
                        else{monthtableMF.setFont(new Font("Goudy Old Style",0,18));}
    
    
                        monthtableMF.setModel(new DefaultTableModel(rows, headerMF){
                            @Override
                            public boolean isCellEditable(int row, int column) {
                                return false;
                            }
                        });
                        monthtableMF.setSelectionBackground(new Color(245, 170, 100));
                        monthtableMF.setSelectionForeground(Color.black);
                        monthtableMF.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);


                        if(Screensize.getWidth()==1920){

                            monthtableMF.getColumnModel().getColumn(0).setPreferredWidth(130);
                            monthtableMF.getColumnModel().getColumn(1).setPreferredWidth(200);
                            monthtableMF.getColumnModel().getColumn(2).setPreferredWidth(250);
                            monthtableMF.getColumnModel().getColumn(3).setPreferredWidth(200);
                            monthtableMF.getColumnModel().getColumn(4).setPreferredWidth(100);
                            monthtableMF.getColumnModel().getColumn(5).setPreferredWidth(200);
                            monthtableMF.getColumnModel().getColumn(6).setPreferredWidth(150);
                            monthtableMF.getColumnModel().getColumn(7).setPreferredWidth(130);

                        }
                        else if(Screensize.getWidth()>=1536&&Screensize.getWidth()<1920){
                            monthtableMF.getColumnModel().getColumn(0).setPreferredWidth(90);
                            monthtableMF.getColumnModel().getColumn(1).setPreferredWidth(200);
                            monthtableMF.getColumnModel().getColumn(2).setPreferredWidth(200);
                            monthtableMF.getColumnModel().getColumn(3).setPreferredWidth(180);
                            monthtableMF.getColumnModel().getColumn(4).setPreferredWidth(100);
                            monthtableMF.getColumnModel().getColumn(5).setPreferredWidth(180);
                            monthtableMF.getColumnModel().getColumn(6).setPreferredWidth(125);
                            monthtableMF.getColumnModel().getColumn(7).setPreferredWidth(125);
                        }
                        else{
                            monthtableMF.getColumnModel().getColumn(0).setPreferredWidth(130);
                            monthtableMF.getColumnModel().getColumn(1).setPreferredWidth(200);
                            monthtableMF.getColumnModel().getColumn(2).setPreferredWidth(250);
                            monthtableMF.getColumnModel().getColumn(3).setPreferredWidth(200);
                            monthtableMF.getColumnModel().getColumn(4).setPreferredWidth(100);
                            monthtableMF.getColumnModel().getColumn(5).setPreferredWidth(200);
                            monthtableMF.getColumnModel().getColumn(6).setPreferredWidth(130);
                            monthtableMF.getColumnModel().getColumn(7).setPreferredWidth(130);
                        }
    
                        monthtableMF();

                        
                        
                    }
                    
                    
                }
            }
            else{
                ArrayList<gymclient> mems1=selectfromtable(nameofTabelenow);
                if(!mems1.isEmpty()){
                    strengthfldMF.setText(String.valueOf(mems1.size()));
                    int count=0;
                    int pending=0;
                    int reveuevalue=0;
                    for (gymclient i : mems1) {
                        if(i.isFeecheck()){
                            count++;
                            reveuevalue+=i.getFee();
                        }
                        else{
                            pending++;
                        }                        
                    }

                    feecollectionfldMF.setText(String.valueOf(count));
                    feependfldMF.setText(String.valueOf(pending));
                    revenuefldMF.setText(String.valueOf(reveuevalue));
                    if(expensefldMF.getText().isEmpty()){
                        expensefldMF.setText("0");
                    }
                    
                    if(!super.selectfromtable(nameofTabelenow).isEmpty()){
                        ArrayList<gymclient> matches= selectfromtable(nameofTabelenow);
                        for(int i=0;i<matches.size();i++){                       
                            for(int j=i+1;j<matches.size();j++){
                                gymclient i1=matches.get(i);
                                gymclient j1=matches.get(j);
                                int id1=Integer.valueOf(matches.get(i).getIDuser().substring(4));
                                int id2=Integer.valueOf(matches.get(j).getIDuser().substring(4));
                                if(id1>id2){
                                    matches.set(i, j1);
                                    matches.set(j, i1);
                                }                                                    
                            
                            }
                            
                        }
                           
                        Object[][] rows=new Object[matches.size()][8];

                        for(int i=0;i<matches.size();i++){
                            for(int j=0;j<8;j++){
                                if(j==0){
                                    rows[i][j]=matches.get(i).getIDuser();
                                }
                                if(j==1){
                                    rows[i][j]=matches.get(i).getNameUser();
                                }
                                if(j==2){
                                    rows[i][j]=matches.get(i).getCnic();
                                }
                                if(j==3){
                                    rows[i][j]="+92".concat(matches.get(i).getPhone().toString());
                                }
                                if(j==4){
                                    rows[i][j]=matches.get(i).getFee();
                                }
                                if(j==5){
                                    rows[i][j]=matches.get(i).getNameofAdmin();
                                }
                                if(j==6){
                                    if(matches.get(i).getDateoffee()!=null){
                                        rows[i][j]=matches.get(i).getDateoffee();
                                    }
                                    else{
                                        rows[i][j]="-";
                                    }
                                }
                                if(j==7){
                                    rows[i][j]=matches.get(i).getJoining();
                                }
                            }
    
                        }
                        
                        if(Screensize.getWidth()==1920){monthtableMF.setFont(new Font("Goudy Old Style",0,22));}
                        else if(Screensize.getWidth()>=1536&&Screensize.getWidth()<1920){monthtableMF.setFont(new Font("Goudy Old Style",0,20));}
                        else{monthtableMF.setFont(new Font("Goudy Old Style",0,18));}
    
    
                        monthtableMF.setModel(new DefaultTableModel(rows, headerMF){
                            @Override
                            public boolean isCellEditable(int row, int column) {
                                return false;
                            }
                        });
                        monthtableMF.setSelectionBackground(new Color(245, 170, 100));
                        monthtableMF.setSelectionForeground(Color.black);
                        monthtableMF.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);


                        if(Screensize.getWidth()==1920){

                            monthtableMF.getColumnModel().getColumn(0).setPreferredWidth(130);
                            monthtableMF.getColumnModel().getColumn(1).setPreferredWidth(200);
                            monthtableMF.getColumnModel().getColumn(2).setPreferredWidth(250);
                            monthtableMF.getColumnModel().getColumn(3).setPreferredWidth(200);
                            monthtableMF.getColumnModel().getColumn(4).setPreferredWidth(100);
                            monthtableMF.getColumnModel().getColumn(5).setPreferredWidth(200);
                            monthtableMF.getColumnModel().getColumn(6).setPreferredWidth(150);
                            monthtableMF.getColumnModel().getColumn(7).setPreferredWidth(130);

                        }
                        else if(Screensize.getWidth()>=1536&&Screensize.getWidth()<1920){
                            monthtableMF.getColumnModel().getColumn(0).setPreferredWidth(90);
                            monthtableMF.getColumnModel().getColumn(1).setPreferredWidth(200);
                            monthtableMF.getColumnModel().getColumn(2).setPreferredWidth(200);
                            monthtableMF.getColumnModel().getColumn(3).setPreferredWidth(180);
                            monthtableMF.getColumnModel().getColumn(4).setPreferredWidth(100);
                            monthtableMF.getColumnModel().getColumn(5).setPreferredWidth(180);
                            monthtableMF.getColumnModel().getColumn(6).setPreferredWidth(125);
                            monthtableMF.getColumnModel().getColumn(7).setPreferredWidth(125);
                        }
                        else{
                            monthtableMF.getColumnModel().getColumn(0).setPreferredWidth(130);
                            monthtableMF.getColumnModel().getColumn(1).setPreferredWidth(200);
                            monthtableMF.getColumnModel().getColumn(2).setPreferredWidth(250);
                            monthtableMF.getColumnModel().getColumn(3).setPreferredWidth(200);
                            monthtableMF.getColumnModel().getColumn(4).setPreferredWidth(100);
                            monthtableMF.getColumnModel().getColumn(5).setPreferredWidth(200);
                            monthtableMF.getColumnModel().getColumn(6).setPreferredWidth(130);
                            monthtableMF.getColumnModel().getColumn(7).setPreferredWidth(130);
                        }
                        monthtableMF();
                                               
                    }
                    
                    
                    
                }
            }
        }

        if(e.getSource()==optionsRI){

            if(e.getItem().equals("Name")){
                namesfldRI.setVisible(true);
                idsfldRI.setVisible(false);
                optionsRI.setVisible(false);
                selectlblRI.setText("Name :");

            }
            if(e.getItem().equals("ID")){
                namesfldRI.setVisible(false);
                idsfldRI.setVisible(true);
                optionsRI.setVisible(false);
                selectlblRI.setText("ID  :");
            }


        }

        if(e.getSource()==monthsoptionaET){

            
            if(!e.getItem().equals(nameofTabelenow)){
                String tablename=e.getItem().toString().substring(0, 1).toUpperCase()+e.getItem().toString().substring(1,e.getItem().toString().length()-4).toLowerCase()+"  "
                +e.getItem().toString().substring(e.getItem().toString().length()-4,e.getItem().toString().length());

                exportfileareaET.setText("\t\t\t\t   "+tablename+"\t\t\t\t\n");
                exportfileareaET.append("\t\t\t\t--------------------------------------\t\t\t\t\n");

                exportfileareaET.setFont(new Font("Times New Roman",1,20));
                exportfileareaET.append("\n");
                exportfileareaET.append("-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------\n");
                exportfileareaET.append(String.format("%-10s", "     ID")+"     \t          "+String.format("%-20s","    NAME   ")+"                "+String.format("%-20s","CNIC")+"           "+String.format("%-20s","       Phone")
                +"         "+String.format("%-15s","       Fee")+"    "+String.format("%-15s","       Name of Admin")+"       "+String.format("%-20s","         Date of Last Fee")+"      "+String.format("%-20s","         Date of Join\n"));
                exportfileareaET.setFont(new Font("Times New Roman",0,18));
                exportfileareaET.append("-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------\n");
                
                
                ArrayList<gymclient> allmems=selectfromtable(e.getItem().toString());

                for(int i=0;i<allmems.size();i++){                       
                    for(int j=i+1;j<allmems.size();j++){
                        gymclient i1=allmems.get(i);
                        gymclient j1=allmems.get(j);
                        int id1=Integer.valueOf(allmems.get(i).getIDuser().substring(4));
                        int id2=Integer.valueOf(allmems.get(j).getIDuser().substring(4));
                        if(id1>id2){
                            allmems.set(i, j1);
                            allmems.set(j, i1);
                        }                                                    
                    
                    }
                    
                }

                if(!allmems.isEmpty()){
                    
                    
                    for (gymclient i : allmems) {
                        String dateoffeee="       -";
                        String dateofjoin=i.getJoining().toString();
                        if(i.getDateoffee()!=null){
                            dateoffeee=i.getDateoffee().toString();
                        }
                        else{
                            dateofjoin="        "+i.getJoining().toString();
                        }

                        exportfileareaET.append(String.format("%-15s %20s  %-30s  %-30s %-20s %-30s %-30s %-30s","  "+i.getIDuser(),i.getNameUser()
                        ,"\t"+i.getCnic(),"+92"+i.getPhone().toString(),i.getFee(),i.getNameofAdmin(),
                        dateoffeee,dateofjoin));

                        exportfileareaET.append("\n");
                    
                        
                    }


                }
            }
            else{
                String tablename=nameofTabelenow.substring(0, 1)+nameofTabelenow.substring(1,nameofTabelenow.length()-4).toLowerCase()+"  "+nameofTabelenow.substring(nameofTabelenow.length()-4,nameofTabelenow.length());
                if(monthsoptionaET.getSelectedItem().equals(nameofTabelenow.toLowerCase())){

                    exportfileareaET.setText("\t\t\t\t   "+tablename+"\t\t\t\t\n");
                    exportfileareaET.append("\t\t\t\t--------------------------------------\t\t\t\t\n");


                    exportfileareaET.append("\n");
                    exportfileareaET.append("-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------\n");
                    exportfileareaET.append(String.format("%-10s", "     ID")+"     \t          "+String.format("%-20s","    NAME   ")+"                "+String.format("%-20s","CNIC")+"           "+String.format("%-20s","       Phone")
                    +"         "+String.format("%-15s","       Fee")+"    "+String.format("%-15s","       Name of Admin")+"       "+String.format("%-20s","         Date of Last Fee")+"      "+String.format("%-20s","         Date of Join\n"));
                    exportfileareaET.append("-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------\n");
                    
                    ArrayList<gymclient> allmems=selectfromtable(nameofTabelenow);
                    for(int i=0;i<allmems.size();i++){                       
                        for(int j=i+1;j<allmems.size();j++){
                            gymclient i1=allmems.get(i);
                            gymclient j1=allmems.get(j);
                            int id1=Integer.valueOf(allmems.get(i).getIDuser().substring(4));
                            int id2=Integer.valueOf(allmems.get(j).getIDuser().substring(4));
                            if(id1>id2){
                                allmems.set(i, j1);
                                allmems.set(j, i1);
                            }                                                    
                        
                        }
                        
                    }

                    if(!allmems.isEmpty()){

                        for (gymclient i : allmems) {
                            String dateoffeee="       -";
                            String dateofjoin=i.getJoining().toString();
                            if(i.getDateoffee()!=null){
                                dateoffeee=i.getDateoffee().toString();
                            }
                            else{
                                dateofjoin="        "+i.getJoining().toString();
                            }
                            exportfileareaET.append(String.format("%-15s %20s  %-30s  %-30s %-20s %-30s %-30s %-30s","  "+i.getIDuser(),i.getNameUser()
                            ,"\t"+i.getCnic(),"+92"+i.getPhone().toString(),i.getFee(),i.getNameofAdmin(),
                            dateoffeee,dateofjoin));

                            exportfileareaET.append("\n");
                        
                            
                        }
                    }
                }





            


            }
           
        
        }



    }



    public void setvisible(boolean b) {
        menuframe.setVisible(b);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        
    }

    @Override
    public void mousePressed(MouseEvent e) {

        
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        
    }

    @Override
    public void mouseExited(MouseEvent e) {
        
    }

    @Override
    public void keyTyped(KeyEvent e) {
       
           
        if(e.getSource()==phonefldAU)
        {
            char c=e.getKeyChar();
            if(Character.isDigit(c))
            {

                if(phonefldAU.getText().length()>10)
                {
                    this.phonefldAU.setEditable(false);
                }
                else
                {
                    this.phonefldAU.setEditable(true);
                }
            }
            else if(c==(char)8)
            {
                this.phonefldAU.setEditable(true);
            }
            else
            {
                this.phonefldAU.setEditable(false);
            }
            
        }
       

        if(e.getSource()==cnicAGC)
        {
            char c=e.getKeyChar();
            if(Character.isDigit(c))
            {
                if(cnicAGC.getText().length()>12)
                {
                    this.cnicAGC.setEditable(false);
                }
                else
                {
                    this.cnicAGC.setEditable(true);
                }
                
               
            }
            else if(c==(char)8)
            {
                if(cnicAGC.getText().length()<=12)
                {
                    this.cnicAGC.setEditable(true);
                }
            }
            else
            {
                cnicAGC.setEditable(false);
                
            }
        
        }
        if(e.getSource()==phoneAGC)
        {
            char c=e.getKeyChar();
            if(Character.isDigit(c))
            {
                if(phoneAGC.getText().length()>10)
                {
                    this.phoneAGC.setEditable(false);
                }
                else
                {
                    this.phoneAGC.setEditable(true);
                }
                
            }
            else if(c==(char)8)
            {
                if(phoneAGC.getText().length()<=10)
                {
                    this.phoneAGC.setEditable(true);
                }
            }
            else
            {
                phoneAGC.setEditable(false);
                
            }
        }

        if(e.getSource()==idAGC)
        {
            char c=e.getKeyChar();
            if(Character.isDigit(c))
            {
                    this.idAGC.setEditable(true);
            }
            else if(c==(char)8)
            {
               
                this.idAGC.setEditable(true);
                
            }
            else
            {
                idAGC.setEditable(false);
                
            }
        }
        
        if(e.getSource()==feeAGC)
        {
            char c=e.getKeyChar();
            if(Character.isDigit(c))
            {
                    this.feeAGC.setEditable(true);
            }
            else if(c==(char)8)
            {
               
                this.feeAGC.setEditable(true);
                
            }
            else
            {
                feeAGC.setEditable(false);
                
            }
        }
   
        
        if(e.getSource()==idmemRGC){
            char c=e.getKeyChar();
            if(Character.isDigit(c))
            {
                    this.idmemRGC.setEditable(true);
            }
            else if(c==(char)8)
            {
               
                this.idmemRGC.setEditable(true);
                
            }
            else
            {
                idmemRGC.setEditable(false);
                
            }
        }

        if(e.getSource()==idfldSGC){
            char c=e.getKeyChar();
            if(Character.isDigit(c))
            {
                    this.idfldSGC.setEditable(true);
            }
            else if(c==(char)8)
            {
               
                this.idfldSGC.setEditable(true);
                
            }
            else
            {
                idfldSGC.setEditable(false);
                
            }
        }

        if(e.getSource()==cnicfldSGC){
            char c=e.getKeyChar();
            // System.out.println(e.getKeyChar());
            if(Character.isDigit(c))
            {
                    this.cnicfldSGC.setEditable(true);
            }
            else if(c==(char)8)
            {
               
                this.cnicfldSGC.setEditable(true);
                
            }
            else if(c==(char)45)
            {
               
                this.cnicfldSGC.setEditable(true);
                
            }
            else
            {
                cnicfldSGC.setEditable(false);
            }
        }

        


        if(e.getSource()==idfldAF||e.getSource()==expensefldMF||e.getSource()==feefldAF||e.getSource()==idsfldRI||e.getSource()==idfldRI){
            char c=e.getKeyChar();
            if(Character.isDigit(c))
            {
                ((JTextField) e.getSource()).setEditable(true);
            }
            else if(c==(char)8)
            {
                ((JTextField) e.getSource()).setEditable(true);              
                
            }
            else
            {
                ((JTextField) e.getSource()).setEditable(false);              
                
            }
        }


        if(e.getSource()==cnicfldRI){
            char c=e.getKeyChar();
            if(Character.isDigit(c))
            {
                if(cnicfldRI.getText().length()>12)
                {
                    this.cnicfldRI.setEditable(false);
                }
                else
                {
                    this.cnicfldRI.setEditable(true);
                }
                
               
            }
            else if(c==(char)8)
            {
                if(cnicfldRI.getText().length()<=12)
                {
                    this.cnicfldRI.setEditable(true);
                }
            }
            else
            {
                cnicfldRI.setEditable(false);
                
            }
        
        }
        if(e.getSource()==phonefldRI){
            char c=e.getKeyChar();
            if(Character.isDigit(c))
            {
                if(phonefldRI.getText().length()>10)
                {
                    this.phonefldRI.setEditable(false);
                }
                else
                {
                    this.phonefldRI.setEditable(true);
                }
                
            }
            else if(c==(char)8)
            {
                if(phonefldRI.getText().length()<=10)
                {
                    this.phonefldRI.setEditable(true);
                }
            }
            else
            {
                phonefldRI.setEditable(false);
                
            }
        }

        if(e.getSource()==phonefldSGC){
            char c=e.getKeyChar();
            if(Character.isDigit(c))
            {
                if(phonefldSGC.getText().length()>10)
                {
                    this.phonefldSGC.setEditable(false);
                }
                else
                {
                    this.phonefldSGC.setEditable(true);
                }
                
            }
            else if(c==(char)8)
            {
                if(phonefldSGC.getText().length()<=10)
                {
                    this.phonefldSGC.setEditable(true);
                }
            }
            else
            {
                phonefldSGC.setEditable(false);
                
            }
        }





    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getSource()==userNamField){


            int c=e.getKeyCode();
            if(c==40)
            {

                passworField.requestFocus();

            }
        }
        if(e.getSource()==passworField)
        {
            int c=e.getKeyCode();
            if(c==38)
            {
                userNamField.requestFocus();

            }
            else if(c==40)
            {
                loginbtn.requestFocus();
                
            }
            else if(c==(int)KeyEvent.VK_ENTER){
                loginbtn.doClick();
            }

        }


        if(e.getSource()==userNamefldAU){
            int c=e.getKeyCode();
            if(c==40)
            {

                pswfldAU.requestFocus();

            }
            else if(c==38){
                phonefldAU.requestFocus();
            }
        }
        if(e.getSource()==pswfldAU){
            int c=e.getKeyCode();
            if(c==40)
            {

                utypefldAU.requestFocus();

            }
            else if(c==38){
                userNamefldAU.requestFocus();
            }
        }
        if(e.getSource()==utypefldAU){
            int c=e.getKeyCode();
            if(c==40)
            {

                phonefldAU.requestFocus();

            }
            else if(c==38){
                pswfldAU.requestFocus();
            }
        }
        if(e.getSource()==phonefldAU){
            int c=e.getKeyCode();
            if(c==40)
            {

                userNamefldAU.requestFocus();

            }
            else if(c==38){
                utypefldAU.requestFocus();
            }
        }


        if(e.getSource()==userNamefldRU){
            int c=e.getKeyCode();
            if(c==40)
            {

                pswfldR.requestFocus();

            }
            else if(c==38){
                pswfldR.requestFocus();
            }
        }
        if(e.getSource()==pswfldR){
            int c=e.getKeyCode();
            if(c==40)
            {

                userNamefldRU.requestFocus();

            }
            else if(c==38){
                userNamefldRU.requestFocus();
            }
        }


        if(e.getSource()==userNamefldCUN){
            int c=e.getKeyCode();
            if(c==40)
            {

                pswfldRCUN.requestFocus();

            }
            else if(c==38){
                newuserNamefldCUN.requestFocus();
            }
        }
        if(e.getSource()==pswfldRCUN){
            int c=e.getKeyCode();
            if(c==40)
            {

                newuserNamefldCUN.requestFocus();

            }
            else if(c==38){
                userNamefldCUN.requestFocus();
            }
        }
        if(e.getSource()==newuserNamefldCUN){
            int c=e.getKeyCode();
            if(c==40)
            {

                userNamefldCUN.requestFocus();

            }
            else if(c==38){
                pswfldRCUN.requestFocus();
            }

        }

        if(e.getSource()==userNamefldCP){
            int c=e.getKeyCode();
            if(c==40)
            {

                pwsfldCP.requestFocus();

            }
            else if(c==38){
                newPassCP.requestFocus();
            }
        }
        if(e.getSource()==pwsfldCP){
            int c=e.getKeyCode();
            if(c==40)
            {

                newPassCP.requestFocus();

            }
            else if(c==38){
                userNamefldCP.requestFocus();
            }
        }
        if(e.getSource()==newPassCP){
            int c=e.getKeyCode();
            if(c==40)
            {

                userNamefldCP.requestFocus();

            }
            else if(c==38){
                pwsfldCP.requestFocus();
            }

        }

        



        if(e.getSource()==namememAGC)
        {
            int c=e.getKeyCode();
            if(c==38)
            {
                feeAGC.requestFocus();                
            }
            else if(c==40)
            {
                idAGC.requestFocus();                
            }

        }
        if(e.getSource()==idAGC)
        {
            int c=e.getKeyCode();
            if(c==38)
            {
                namememAGC.requestFocus();
            }
            else if(c==40)
            {
                phoneAGC.requestFocus();
            }
        }
        if(e.getSource()==phoneAGC)
        {
            int c=e.getKeyCode();
            if(c==38)
            {
                idAGC.requestFocus();
            }
            else if(c==40)
            {
                cnicAGC.requestFocus();
            }
        }
        if(e.getSource()==cnicAGC)
        {
            int c=e.getKeyCode();
            if(c==38)
            {
                phoneAGC.requestFocus();
            }
        }
        if(e.getSource()==feeAGC)
        {
            int c=e.getKeyCode();
            if(c==40){
                namememAGC.requestFocus();
            }
        }
        
        
        if(e.getSource()==namefldRI)
        {
            int c=e.getKeyCode();
            if(c==40)
            {
                idfldRI.requestFocus();                
            }

        }
        if(e.getSource()==idfldRI)
        {
            int c=e.getKeyCode();
            if(c==38)
            {
                namefldRI.requestFocus();
            }
            else if(c==40)
            {
                phonefldRI.requestFocus();
            }
        }
        if(e.getSource()==phonefldRI)
        {
            int c=e.getKeyCode();
            if(c==38)
            {
                idfldRI.requestFocus();
            }
            else if(c==40)
            {
                cnicfldRI.requestFocus();
            }
        }
        if(e.getSource()==cnicfldRI)
        {
            int c=e.getKeyCode();
            if(c==38)
            {
                phonefldRI.requestFocus();
            }

        }
        
        
    }

    @Override
    public void keyReleased(KeyEvent e) {

        
    }


    




   


  

   


   


    




}
