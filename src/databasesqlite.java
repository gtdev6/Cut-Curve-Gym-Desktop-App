import org.apache.poi.util.IOUtils;

import javax.swing.*;
import java.awt.*;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.text.MessageFormat;
import java.time.LocalDate;
import java.util.ArrayList;

public class databasesqlite {
    protected Connection connection;
    protected Statement statement;
    private ResultSet resultset;
    // private ResultSet rs;
    private String admin="Sheraz Awan",initialpassword="Boyka123",usertype="Admin";
    private long phone=3138882285l;
    protected ArrayList<LoginUser> loginuser=new ArrayList<LoginUser>();
    protected ArrayList<gymclient> clients=new ArrayList<gymclient>();

    databasesqlite(){
        if(connection==null){
            initialize();
        }
    }

    public boolean checktable(String tablename)
    {
        boolean result=false;


        try {
            DatabaseMetaData dbm = connection.getMetaData();
            ResultSet tables =dbm.getTables(null, null, tablename, null);
            if(tables.next())
            {
                result=true;
            }
            else{
                result=false;
            }

        } catch (SQLException e) {

            showerror(e);
        }
//        String createTable="SELECT Name From cutandcurvegym Where type='table' AND name={0}";
//
//            try {
//                Statement sate=connection.createStatement();
//                ResultSet res=sate.executeQuery(MessageFormat.format(createTable, tablename));
//                if(res.next())
//                {
//                    result=true;
//                }
//                else{
//                    result=false;
//                }
//
//            } catch (SQLException e) {
//
//                showerror(e);
//            }
//
////        }


        return result;
    }

    private void initialize() {
        try {
            Class.forName("org.sqlite.JDBC");
            connection= DriverManager.getConnection("jdbc:sqlite:cutandcurvegym.db");
            statement=connection.createStatement();
            Statement sate=connection.createStatement();
            ResultSet res=sate.executeQuery("SELECT Name From sqlite_master Where type='table' AND name='logindata'");
            if(!res.next()){
                String createTable=
                        "Create Table logindata(\nName varchar(20) NOT NULL UNIQUE,"+
                                "Password varchar(20) NOT NUll,"
                                +"UserType varchar(20) Not Null,"
                                +"PhoneNumber BigInt Not Null,"
                                +"PRIMARY KEY(Name));";
                Statement state2=connection.createStatement();
                state2.execute(createTable);

                PreparedStatement prep=connection.prepareStatement("Insert Into logindata (Name,Password,UserType,PhoneNumber)\n"+"VALUES (?,?,?,?)");
                prep.setString(1,"Sheraz Awan");
                prep.setString(2,"Boyka123");
                prep.setString(3,"Admin");
                prep.setLong(4,3138882285l);
                prep.execute();

                PreparedStatement prep1=connection.prepareStatement("Insert Into logindata (Name,Password,UserType,PhoneNumber)\n"+"VALUES (?,?,?,?)");
                prep1.setString(1,"Ghulam Tahir");
                prep1.setString(2,"Aladin");
                prep1.setString(3,"Admin");
                prep1.setLong(4,3119763645l);
                prep1.execute();
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

    public void initialAdmin()
    {
        String insertinto="Insert Into logindata (Name,Password,UserType,PhoneNumber)\r\nVALUES (?,?,?,?);";

        try {
            PreparedStatement pStatement=connection.prepareStatement(insertinto);
            pStatement.setString(1, this.admin);
            pStatement.setString(2, this.initialpassword);
            pStatement.setString(3, this.usertype);
            pStatement.setLong(4, this.phone);
            pStatement.executeUpdate();
            PreparedStatement prep1=connection.prepareStatement("Insert Into logindata (Name,Password,UserType,PhoneNumber)\n"+"VALUES (?,?,?,?)");
            prep1.setString(1,"Ghulam Tahir");
            prep1.setString(2,"Aladin");
            prep1.setString(3,"Admin");
            prep1.setLong(4,3119763645l);
            prep1.execute();
        } catch (SQLException e) {

            showerror(e);

        }

    }

    public void readtable()
    {
        try {

            resultset=statement.executeQuery("Select * From logindata");

            while(resultset.next())
            {
                LoginUser l1=new LoginUser(resultset.getString(1), resultset.getString(2), resultset.getString(3), resultset.getLong(4));
                loginuser.add(l1);
            }

        } catch (SQLException e) {

            showerror(e);
        }



    }
    public void createtable()
    {

        String createTable=
                "Create Table logindata(\nName varchar(20) NOT NULL UNIQUE,"+
                        "Password varchar(20) NOT NUll,"
                        +"UserType varchar(20) Not Null,"
                        +"PhoneNumber BigInt Not Null,"
                        +"PRIMARY KEY(Name));";

        // System.out.println(createTable);
        try {
            statement.executeUpdate(createTable);
            System.out.println("Table Created");
        } catch (SQLException e) {
            showerror(e);
        }
    }

    public boolean insertuser(String name1,String password,String usertype,Long phone)
    {
        Boolean result=false;
        String insertinto1="Insert Into logindata (Name,Password,UserType,PhoneNumber)\r\nVALUES (?,?,?,?);";


        if((!name1.isBlank())&&!password.isBlank()&&!usertype.isBlank()&&phone!=0L){

            PreparedStatement insertstatement;
            try {


                insertstatement = connection.prepareStatement(insertinto1);
                insertstatement.setString(1, name1);
                insertstatement.setString(2, password);
                insertstatement.setString(3, usertype);
                insertstatement.setLong(4, phone);

                insertstatement.executeUpdate();
                result=true;
            } catch (SQLIntegrityConstraintViolationException  e) {
                JDialog.setDefaultLookAndFeelDecorated(true);
                UIManager.put("OptionPane.messageFont",new Font("Times New Roman",0,24));
                UIManager.put("OptionPane.background",Color.black);
                UIManager.put("Panel.background",Color.BLACK);
                UIManager.put("OptionPane.messageForeground",Color.WHITE);

                JOptionPane.showMessageDialog(null, "Duplicate Entry", "Result", JOptionPane.ERROR_MESSAGE);

            }
            catch(SQLException e){
                showerror(e);
            }



        }
        else
        {
            JDialog.setDefaultLookAndFeelDecorated(true);
            UIManager.put("OptionPane.messageFont",new Font("Times New Roman",0,24));
            UIManager.put("OptionPane.background",Color.black);
            UIManager.put("Panel.background",Color.black);
            UIManager.put("OptionPane.buttonFont",new Font("MV Boli",0,12));
            UIManager.put("OptionPane.messageForeground",Color.red);
            JOptionPane.showMessageDialog(null, "Some Field Is Empty", "Result", JOptionPane.ERROR_MESSAGE);
        }

        return result;
    }

    public String selectfrom(String name1)
    {

        String data1=null;
        String query="Select Name From logindata where Name=(?);";

        if(!name1.isBlank()){
            try {
                PreparedStatement insertstatement=connection.prepareStatement(query);
                insertstatement.setString(1, name1);

                insertstatement.execute();
                ResultSet r1=insertstatement.getResultSet();
                // r1.next();
                if (r1.next() == false)
                {

                }
                else {
                    do {

                        String data = r1.getString(1);
                        data1=data;
                    } while (r1.next());
                }

            } catch (SQLException e) {

                showerror(e);
            }

        }

        return data1;

    }


    public boolean removeuser(String name1)
    {
        Boolean result=false;
        String insertinto1="Delete From logindata Where (Name)=(?);";


        if(name1!=null){

            String check=selectfrom(name1);

            if(check!=null)
            {
                try {
                    PreparedStatement insertstatement=connection.prepareStatement(insertinto1);
                    insertstatement.setString(1, name1);
                    insertstatement.executeUpdate();
                    result=true;


                } catch (SQLException e) {

                    showerror(e);
                }
            }
            else{
                JDialog.setDefaultLookAndFeelDecorated(true);
                UIManager.put("OptionPane.messageFont",new Font("Times New Roman",0,24));
                UIManager.put("OptionPane.background",Color.black);
                UIManager.put("Panel.background",Color.black);
                UIManager.put("OptionPane.buttonFont",new Font("MV Boli",0,12));
                UIManager.put("OptionPane.messageForeground",Color.red);
                JOptionPane.showMessageDialog(null, "Such UserName Does Not Exist!! ", "Result", JOptionPane.ERROR_MESSAGE);
            }

        }
        else
        {
            JDialog.setDefaultLookAndFeelDecorated(true);
            UIManager.put("OptionPane.messageFont",new Font("Times New Roman",0,24));
            UIManager.put("OptionPane.background",Color.black);
            UIManager.put("Panel.background",Color.black);
            UIManager.put("OptionPane.buttonFont",new Font("MV Boli",0,12));
            UIManager.put("OptionPane.messageForeground",Color.red);
            JOptionPane.showMessageDialog(null, "Field Is Empty", "Result", JOptionPane.ERROR_MESSAGE);
        }

        return result;
    }

    public void updateUserName(String previos,String newname)
    {
        if(!previos.isBlank()&&!newname.isBlank())
        {
            String check=selectfrom(previos);
            String replacecheck=selectfrom(newname);
            if(check!=null)
            {
                if(replacecheck==null){

                    String query="Update logindata \r\n Set Name=(?) Where Name=(?);";

                    try {
                        PreparedStatement prestatement=connection.prepareStatement(query);
                        prestatement.setString(1, newname);
                        prestatement.setString(2, previos);
                        prestatement.executeUpdate();
                        JDialog.setDefaultLookAndFeelDecorated(true);
                        UIManager.put("OptionPane.messageFont", new Font("Times New Roman",0,20));
                        UIManager.put("OptionPane.background",new Color(20,20,20));
                        UIManager.put("Panel.background", new Color(20,20,20));
                        UIManager.put("OptionPane.messageForeground",Color.green);
                        UIManager.put("OptionPane.buttonFont", new Font("MV Boli",0,15));

                        JOptionPane.showMessageDialog(null, "Successfully Changed UserName", "Result", JOptionPane.INFORMATION_MESSAGE);

                    } catch (SQLException e) {
                        showerror(e);
                    }
                }
                else
                {
                    JDialog.setDefaultLookAndFeelDecorated(true);
                    UIManager.put("OptionPane.messageFont", new Font("Times New Roman",0,20));
                    UIManager.put("OptionPane.background", new Color(20,20,20));
                    UIManager.put("OptionPane.messageForeground", Color.red);
                    UIManager.put("Panel.background", new Color(20,20,20));
                    UIManager.put("OptionPane.buttonFont", new Font("MV Boli",0,15));

                    JOptionPane.showMessageDialog(null, "Failed! This UserName is Not available.", "Result", JOptionPane.ERROR_MESSAGE);
                }
            }
            else{
                JDialog.setDefaultLookAndFeelDecorated(true);
                UIManager.put("OptionPane.messageFont", new Font("Times New Roman",0,20));
                UIManager.put("OptionPane.background", new Color(20,20,20));
                UIManager.put("OptionPane.messageForeground", Color.red);
                UIManager.put("Panel.background", new Color(20,20,20));
                UIManager.put("OptionPane.buttonFont", new Font("MV Boli",0,15));

                JOptionPane.showMessageDialog(null, "Failed! Such UserName Does Not Exist.", "Result", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    public void upatePassword(String username,String currentPassword,String newpassword){
        if(!username.isBlank()&&!currentPassword.isBlank()&&!newpassword.isBlank())
        {
            String name=selectfrom(username);
            if(name!=null)
            {
                String checkpas=getPass(name);
                if(checkpas.equals(currentPassword))
                {
                    String query="Update logindata \r\n Set Password=(?) Where Name =(?)";
                    try {
                        PreparedStatement p2=connection.prepareStatement(query);
                        p2.setString(1, newpassword);
                        p2.setString(2, username);

                        if(!currentPassword.equals(newpassword))
                        {
                            p2.executeUpdate();
                            JDialog.setDefaultLookAndFeelDecorated(true);
                            UIManager.put("OptionPane.messageFont", new Font("Times New Roman",0,20));
                            UIManager.put("OptionPane.background",new Color(20,20,20));
                            UIManager.put("Panel.background", new Color(20,20,20));
                            UIManager.put("OptionPane.messageForeground",Color.green);
                            UIManager.put("OptionPane.buttonFont", new Font("MV Boli",0,15));

                            JOptionPane.showMessageDialog(null, "Successfully Changed Password", "Result", JOptionPane.INFORMATION_MESSAGE);
                        }
                        else{
                            JDialog.setDefaultLookAndFeelDecorated(true);
                            UIManager.put("OptionPane.messageFont", new Font("Times New Roman",0,20));
                            UIManager.put("OptionPane.background",new Color(20,20,20));
                            UIManager.put("Panel.background", new Color(20,20,20));
                            UIManager.put("OptionPane.messageForeground",Color.RED);
                            UIManager.put("OptionPane.buttonFont", new Font("MV Boli",0,15));

                            JOptionPane.showMessageDialog(null, "Failed, Enter New Password, Password Cannot be Same.", "Result", JOptionPane.ERROR_MESSAGE);
                        }
                    } catch (SQLException e) {
                        showerror(e);
                    }
                }
                else{
                    JDialog.setDefaultLookAndFeelDecorated(true);
                    UIManager.put("OptionPane.messageFont", new Font("Times New Roman",0,20));
                    UIManager.put("OptionPane.background",new Color(20,20,20));
                    UIManager.put("Panel.background", new Color(20,20,20));
                    UIManager.put("OptionPane.messageForeground",Color.RED);
                    UIManager.put("OptionPane.buttonFont", new Font("MV Boli",0,15));

                    JOptionPane.showMessageDialog(null, "Current Password is Not Correct", "Result", JOptionPane.ERROR_MESSAGE);
                }
            }
            else
            {
                JDialog.setDefaultLookAndFeelDecorated(true);
                UIManager.put("OptionPane.messageFont", new Font("Times New Roman",0,20));
                UIManager.put("OptionPane.background",new Color(20,20,20));
                UIManager.put("Panel.background", new Color(20,20,20));
                UIManager.put("OptionPane.messageForeground",Color.RED);
                UIManager.put("OptionPane.buttonFont", new Font("MV Boli",0,15));

                JOptionPane.showMessageDialog(null, "No Such User Found!!", "Result", JOptionPane.ERROR_MESSAGE);
            }

        }
    }

    protected String getPass(String username)
    {
        String pass=null;
        if(!username.isBlank())
        {
            String query="Select Password From logindata Where Name=(?);";
            try {
                PreparedStatement p1=connection.prepareStatement(query);
                p1.setString(1, username);
                ResultSet s1=p1.executeQuery();
                while(s1.next())
                {
                    pass=s1.getString(1);
                }

            } catch (SQLException e) {
                showerror(e);
            }
        }

        return pass;
    }

    public void createtabledata(String tablename)
    {
//        String usedatabase="USE cutandcurvegym;";
        String createTable=
                "Create Table {0} (\nID varchar(20) NOT NULL UNIQUE,"
                        +"Name varchar(20) NOT NULL,"
                        +"PhoneNumber BIGINT NOT NUll,"
                        +"fee INT,"
                        +"feecheck BOOLEAN Not Null,"
                        +"NameofAdmin varchar(20) Not Null,"
                        +"DateofJoin DATE Not Null,"
                        +"CNIC varchar(20) Not Null,"
                        +"DateofFee DATE,"
                        +"Image MEDIUMBLOB Not Null,"
                        +"PRIMARY KEY(Name));";


        try {
//            statement.execute(usedatabase);
            statement.execute(MessageFormat.format(createTable, tablename));
        } catch (SQLException e) {
            showerror(e);

        }
    }

    boolean enterdataintotable(String tablename, String name, String Id, Long phone, String cnic, int fee, boolean feecheck, String nameofadmin, LocalDate dateofjoin, LocalDate dateoffee, InputStream image1){
        Boolean result=false;
//        String usedatabase="Use cutandcurvegym;";
        String insertinto1="Insert Into {0} (Name,ID,fee,PhoneNumber,feecheck,NameofAdmin,DateofJoin,CNIC,DateofFee,Image)\r\nVALUES (?,?,?,?,?,?,?,?,?,?);";

        String insertstament=MessageFormat.format(insertinto1, tablename);
        //    System.out.println(insertstament);
        if(!(tablename.isBlank())){
            PreparedStatement insertstatement;

            java.sql.Date d1=java.sql.Date.valueOf(dateofjoin);
            java.sql.Date d2=null;
            if(dateoffee!=null)
            {
                d2=java.sql.Date.valueOf(dateoffee);
            }
            try {

                insertstatement = connection.prepareStatement(insertstament);
                insertstatement.setString(1, name);
                insertstatement.setString(2, Id);
                insertstatement.setInt(3, fee);
                insertstatement.setLong(4, phone);
                insertstatement.setBoolean(5, feecheck);
                insertstatement.setString(6, nameofadmin);
                insertstatement.setDate(7, d1);
                insertstatement.setString(8, cnic);
                insertstatement.setDate(9, d2);
                try {
                    insertstatement.setBytes(10, IOUtils.toByteArray(image1));
                } catch (IOException e) {
                   showerror(e);
                }

            //      statement.executeQuery(usedatabase);
                insertstatement.executeUpdate();
                result=true;
            } catch (SQLIntegrityConstraintViolationException  e) {
                JDialog.setDefaultLookAndFeelDecorated(true);
                UIManager.put("OptionPane.messageFont",new Font("Times New Roman",0,24));
                UIManager.put("OptionPane.background",Color.black);
                UIManager.put("Panel.background",Color.BLACK);
                UIManager.put("OptionPane.messageForeground",Color.WHITE);

                JOptionPane.showMessageDialog(null, "Duplicate Entry", "Result", JOptionPane.ERROR_MESSAGE);

            }
            catch(SQLException e){
                showerror(e);
            }



        }
        else
        {
            JDialog.setDefaultLookAndFeelDecorated(true);
            UIManager.put("OptionPane.messageFont",new Font("Times New Roman",0,24));
            UIManager.put("OptionPane.background",Color.black);
            UIManager.put("Panel.background",Color.black);
            UIManager.put("OptionPane.buttonFont",new Font("MV Boli",0,12));
            UIManager.put("OptionPane.messageForeground",Color.red);
            JOptionPane.showMessageDialog(null, "Some Field Is Empty", "Result", JOptionPane.ERROR_MESSAGE);
        }
        return result;
    }

    public ArrayList<gymclient> selectfromtable(String tablename)
    {

        ArrayList<gymclient> client=new ArrayList<>();
        // String query="Select * From cutandcurvegym.{0} where Name=(?);";
        String query="Select * From {0};";
        String queryfinal=MessageFormat.format(query, tablename);
        // System.out.println(queryfinal);

        if(!tablename.isBlank()){
            try {
                PreparedStatement insertstatement=connection.prepareStatement(queryfinal);
                // insertstatement.setString(1, name1);

                insertstatement.execute();
                ResultSet r1=insertstatement.getResultSet();
                // r1.next();
                if (r1.next() == false)
                {

                }
                else {
                    gymclient i1;
                    do {
                        LocalDate d3=null;
                        if(r1.getDate(9)!=null){
                            d3=r1.getDate(9).toLocalDate();
                        }

                        i1=new gymclient(r1.getString(1), r1.getString(2), r1.getLong(3), r1.getInt(4), r1.getBoolean(5), r1.getString(6), r1.getDate(7).toLocalDate(), r1.getString(8),d3,new ByteArrayInputStream(r1.getBytes(10)));
                        client.add(i1);
                    } while (r1.next());
                }

            } catch (SQLException e) {

                showerror(e);
            }

        }

        return client;

    }

    public boolean removeuserfromdata(String name1,String tablename)
    {
        Boolean result=false;
        String insertinto1="Delete From {0} Where (Name)=(?);";
        String finalinsert=MessageFormat.format(insertinto1, tablename);

        if(name1!=null){



            try {
                PreparedStatement insertstatement=connection.prepareStatement(finalinsert);
                insertstatement.setString(1, name1);
                insertstatement.executeUpdate();
                result=true;


            } catch (SQLException e) {

                showerror(e);
            }



        }
        else
        {
            JDialog.setDefaultLookAndFeelDecorated(true);
            UIManager.put("OptionPane.messageFont",new Font("Times New Roman",0,24));
            UIManager.put("OptionPane.background",Color.black);
            UIManager.put("Panel.background",Color.black);
            UIManager.put("OptionPane.buttonFont",new Font("MV Boli",0,12));
            UIManager.put("OptionPane.messageForeground",Color.red);
            JOptionPane.showMessageDialog(null, "Field Is Empty", "Result", JOptionPane.ERROR_MESSAGE);
        }

        return result;
    }

    public boolean updatetabledateoffee(String Nameofclient,String TableName){
        boolean result=false;

        if(!Nameofclient.isEmpty()){
            String query="UPDATE {0} \n SET fee=(?),feecheck=(?) Where Name=(?);";

            String queryfinal=MessageFormat.format(query, TableName);
            try {
                PreparedStatement insertquery=connection.prepareStatement(queryfinal);
                insertquery.setInt(1, 0);
                insertquery.setBoolean(2, false);
                insertquery.setString(3, Nameofclient);

                insertquery.executeUpdate();
                result=true;

            } catch (Exception e) {
            }
        }

        return result;

    }
    public boolean updatetabledateoffee(String Nameofclient,String TableName,int amountfee){
        boolean result=false;

        if(!Nameofclient.isEmpty()){
            String query="UPDATE {0} \n SET fee=(?),feecheck=(?),DateofFee=(?) Where Name=(?);";

            String queryfinal=MessageFormat.format(query, TableName);
            try {

                PreparedStatement insertquery=connection.prepareStatement(queryfinal);
                insertquery.setInt(1, amountfee);
                insertquery.setBoolean(2, true);
                insertquery.setDate(3,java.sql.Date.valueOf(LocalDate.now()));
                insertquery.setString(4, Nameofclient);


                insertquery.executeUpdate();
                result=true;

            } catch (Exception e) {
            }
        }

        return result;

    }


    boolean updatedataintotable(String tablename,String name,String Id,Long phone,String cnic,int fee,boolean feecheck,String nameofadmin,LocalDate dateofjoin,LocalDate dateoffee,InputStream image1,String oldname){
        Boolean result=false;
        String insertinto1="Update {0} \n Set Name=?,ID=?,fee=?,PhoneNumber=?,feecheck=?,NameofAdmin=?,DateofJoin=?,CNIC=?,DateofFee=?,Image=? \nWhere Name=?; ";


        String insertstament=MessageFormat.format(insertinto1, tablename);
        //    System.out.println(insertstament);
        if(!(tablename.isBlank())){
            PreparedStatement insertstatement;

            java.sql.Date d1=java.sql.Date.valueOf(dateofjoin);
            java.sql.Date d2=null;
            if(dateoffee!=null)
            {
                d2=java.sql.Date.valueOf(dateoffee);
            }
            try {

                insertstatement = connection.prepareStatement(insertstament);
                insertstatement.setString(1, name);
                insertstatement.setString(2, Id);
                insertstatement.setInt(3, fee);
                insertstatement.setLong(4, phone);
                insertstatement.setBoolean(5, feecheck);
                insertstatement.setString(6, nameofadmin);
                insertstatement.setDate(7, d1);
                insertstatement.setString(8, cnic);
                insertstatement.setDate(9, d2);
                try {
                    insertstatement.setBytes(10, IOUtils.toByteArray(image1));
                } catch (IOException e) {
                   showerror(e);
                }
                insertstatement.setString(11, oldname);

                insertstatement.executeUpdate();
                result=true;
            } catch (SQLIntegrityConstraintViolationException  e) {
                JDialog.setDefaultLookAndFeelDecorated(true);
                UIManager.put("OptionPane.messageFont",new Font("Times New Roman",0,24));
                UIManager.put("OptionPane.background",Color.black);
                UIManager.put("Panel.background",Color.BLACK);
                UIManager.put("OptionPane.messageForeground",Color.WHITE);

                JOptionPane.showMessageDialog(null, "Duplicate Entry", "Result", JOptionPane.ERROR_MESSAGE);

            }
            catch(SQLException e){
                showerror(e);
            }



        }
        else
        {
            JDialog.setDefaultLookAndFeelDecorated(true);
            UIManager.put("OptionPane.messageFont",new Font("Times New Roman",0,24));
            UIManager.put("OptionPane.background",Color.black);
            UIManager.put("Panel.background",Color.black);
            UIManager.put("OptionPane.buttonFont",new Font("MV Boli",0,12));
            UIManager.put("OptionPane.messageForeground",Color.red);
            JOptionPane.showMessageDialog(null, "Some Field Is Empty", "Result", JOptionPane.ERROR_MESSAGE);
        }
        return result;
    }

    protected ArrayList<String> returndatatables()
    {
        ArrayList<String> tablenames=new ArrayList<>();
        try {
//            DatabaseMetaData dbm = connection.getMetaData();
//            ResultSet tables =dbm.getTables(null, null, null, null);
            String query="SELECT name FROM sqlite_master WHERE \n" +
                    "    type ='table' ";
//                    "    name NOT LIKE 'sqlite_%';";
            ResultSet tables=statement.executeQuery(query);
            while(tables.next())
            {
                tablenames.add(tables.getString(1));
            }

        } catch (SQLException e) {

                showerror(e);
            }
        return tablenames;

    }



    // public static void main(String[] args) {
    //     new databasesqlite();
    // }

    private void setlookandfeelRed()
    {
        JDialog.setDefaultLookAndFeelDecorated(true);
        UIManager.put("OptionPane.messageFont", new Font("Goudy Old Style",0,20));
        UIManager.put("OptionPane.background", new Color(20,20,20));
        UIManager.put("OptionPane.messageForeground", Color.WHITE);
        UIManager.put("Panel.background", new Color(20,20,20));
        UIManager.put("OptionPane.buttonFont", new Font("Mv Boli",0,15));
    }

    public void showerror(Throwable e){
        setlookandfeelRed();
        JOptionPane.showMessageDialog(null, e.getMessage(), "Error", 0);
    }
}

