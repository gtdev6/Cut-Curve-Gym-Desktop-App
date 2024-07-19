import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.Statement;
import java.text.MessageFormat;
import java.time.LocalDate;
import java.time.Month;
// import java.time.Year;
import java.util.ArrayList;
// import java.util.Date;
// import java.util.Date;


import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.UIManager;


import java.awt.*;
import java.io.InputStream;

public class databaseconnector {
    private Connection connection;
    protected Statement statement;
    private ResultSet resultset;
    private ResultSet rs;
    private String admin="Sheraz Awan",initialpassword="Boyka123",usertype="Admin";
    private long phone=3138882285l;
    protected ArrayList<LoginUser> loginuser=new ArrayList<LoginUser>();
    protected ArrayList<gymclient> clients=new ArrayList<gymclient>();


    databaseconnector()
    {
        try {

            // String createTable="Create Table logindata(\nName varchar(20) NOT NULL UNIQUE,Password varchar(20) NOT NUll,UserType varchar(20) Not Null,PRIMARY KEY(Name));";

            connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/","root","TAhir8303");
            statement=connection.createStatement();
            // statement.execute(createTable);

        } catch (SQLException e) {

            showerror(e);
        }
    }

    public void createtable()
    {
        // String createTable="Use cutandcurvegym;\nCREATE TABLE logindata(\r\nName varchar(20) NOT NULL UNIQUE,\r\nPassword varchar(20) NOT NUll,\r\nUserType varchar(20) Not Null,\r\nPhoneNumber BigInt Not Null,\r\nPRIMARY KEY(Name)\n);";
        String createTable=
                "Create Table cutandcurvegym.logindata(\nName varchar(20) NOT NULL UNIQUE,"+
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

    public void DropTable()
    {
        String createTable="Drop Table cutandcurvegym.logindata;";
        try {
            statement.execute(createTable);
        } catch (SQLException e) {
            showerror(e);
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
            // System.out.println(pStatement);
            pStatement.executeUpdate();
            // int result=pStatement.executeUpdate();
            // System.out.println(result);
        } catch (SQLException e) {

            showerror(e);

        }

    }
    public void readtable()
    {
        try {

            // statement.execute("Delete From logindata Where Name='Sheraz'");
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
    public Boolean checkdatabase(String name)
    {
        Boolean result=false;
        try {
            rs=connection.getMetaData().getCatalogs();
            while(rs.next())
            {
                String Catalog=rs.getString(1);
                if(name.equals(Catalog))
                {
                    result= true;
                    break;
                }

            }
        } catch (SQLException e) {

            showerror(e);
        }

        return result;
    }

    public Boolean createDatabase(String name)
    {
        Boolean result=false;
        String query="Create Database IF NOT EXISTS "+name;

        try {

            statement.executeUpdate(query);
            result=true;
        } catch (SQLException e) {
            // showerror(e);

            System.out.println("Database Already Exists");
        }
        return result;
    }

    public boolean checktable(String tablename,String databasename1)
    {
        Boolean result=false;
        try {
            rs=connection.getMetaData().getCatalogs();
            while(rs.next())
            {
                String Catalog=rs.getString(1);
                if(databasename1.equals(Catalog))
                {
                    result= true;
                    break;
                }

            }
        } catch (SQLException e) {

            showerror(e);
        }
        if(result==true)
        {
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

        }


        return result;
    }

    public void createtable(String tablename,String databasename)
    {
        String createTable="Use cutandcurvegym;"+
                "Create Table logindata(\nName varchar(20) NOT NULL,"+
                "Password varchar(20) NOT NUll,"
                +"UserType varchar(20) Not Null,"
                +"PhoneNumber BigInt Not Null,"
                +"PRIMARY KEY(Name));";
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
        String insertinto1="Insert Into cutandcurvegym.logindata (Name,Password,UserType,PhoneNumber)\r\nVALUES (?,?,?,?);";


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

    public boolean removeuser(String name1)
    {
        Boolean result=false;
        String insertinto1="Delete From cutandcurvegym.logindata Where (Name)=(?);";


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

    public String selectfrom(String name1)
    {

        String data1=null;
        String query="Select Name From cutandcurvegym.logindata where Name=(?);";

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

    public void updateUserName(String previos,String newname)
    {
        if(!previos.isBlank()&&!newname.isBlank())
        {
            String check=selectfrom(previos);
            String replacecheck=selectfrom(newname);
            if(check!=null)
            {
                if(replacecheck==null){

                    String query="Update cutandcurvegym.logindata \r\n Set Name=(?) Where Name=(?);";

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
                    String query="Update cutandcurvegym.logindata \r\n Set Password=(?) Where Name =(?)";
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
            String query="Select Password From cutandcurvegym.logindata Where Name=(?);";
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
        String usedatabase="USE cutandcurvegym;";
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
            statement.execute(usedatabase);
            statement.execute(MessageFormat.format(createTable, tablename));
        } catch (SQLException e) {
            showerror(e);

        }
    }

    boolean checktabledatagym(){
        LocalDate date=LocalDate.now();
        // Month Month=date.getMonth();
        // int month=date.getMonthValue()-1;
        int year=date.getYear();
        int month=date.getMonthValue()-1;
        Month m1=Month.of(month);

        String name=m1.toString().concat(String.valueOf(year));
        // LocalDate date=LocalDate.now();
        // Month Month=date.getMonth();
        // int year=date.getYear();
        // System.out.println(name);


        return checktable(name, "cutandcurvegym");
    }

    boolean enterdataintotable(String tablename,String name,String Id,Long phone,String cnic,int fee,boolean feecheck,String nameofadmin,LocalDate dateofjoin,LocalDate dateoffee,InputStream image1){
        Boolean result=false;
        String usedatabase="Use cutandcurvegym;";
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
                insertstatement.setBlob(10, image1);

                statement.executeQuery(usedatabase);
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
        String query="Select * From cutandcurvegym.{0};";
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

                        i1=new gymclient(r1.getString(1), r1.getString(2), r1.getLong(3), r1.getInt(4), r1.getBoolean(5), r1.getString(6), r1.getDate(7).toLocalDate(), r1.getString(8),d3,r1.getBlob(10).getBinaryStream());
                        client.add(i1);
                    } while (r1.next());
                }

            } catch (SQLException e) {

                showerror(e);
            }

        }

        return client;

    }

    public gymclient selectfromtablesingle(String tablename,String name1)
    {

        gymclient client=null;
        String query="Select * From cutandcurvegym.{0} where Name=(?);";
        // String query="Select * From cutandcurvegym.{0};";
        String queryfinal=MessageFormat.format(query, tablename);
        // System.out.println(queryfinal);

        if(!name1.isBlank()){
            try {
                PreparedStatement insertstatement=connection.prepareStatement(queryfinal);
                insertstatement.setString(1, name1);

                insertstatement.execute();
                ResultSet r1=insertstatement.getResultSet();
                // r1.next();
                if (r1.next() == false)
                {

                }
                else {
                    do {
                        LocalDate d3=null;
                        if(r1.getDate(9)!=null){
                            d3=r1.getDate(9).toLocalDate();
                        }

                        client=new gymclient(r1.getString(1), r1.getString(2), r1.getLong(3), r1.getInt(4), r1.getBoolean(5), r1.getString(6), r1.getDate(7).toLocalDate(), r1.getString(8),d3,r1.getBlob(10).getBinaryStream());


                    } while (r1.next());
                }

            } catch (SQLException e) {

                showerror(e);
            }

        }

        return client;

    }

    protected ArrayList<String> returndatatables()
    {
        ArrayList<String> tablenames=new ArrayList<>();
        try {

            statement.executeQuery("Use cutandcurvegym;");
            ResultSet tables =statement.executeQuery("Show Tables;");

            while(tables.next())
            {
                tablenames.add(tables.getString(1));
            }
            // System.out.println(tablenames.size());

        } catch (SQLException e) {

            showerror(e);
        }
        return tablenames;

    }


    public boolean removeuserfromdata(String name1,String tablename)
    {
        Boolean result=false;
        String insertinto1="Delete From cutandcurvegym.{0} Where (Name)=(?);";
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
            String query="UPDATE cutandcurvegym.{0} \n SET fee=(?),feecheck=(?) Where Name=(?);";

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
            String query="UPDATE cutandcurvegym.{0} \n SET fee=(?),feecheck=(?),DateofFee=(?) Where Name=(?);";

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
        String insertinto1="Update cutandcurvegym.{0} \n Set Name=?,ID=?,fee=?,PhoneNumber=?,feecheck=?,NameofAdmin=?,DateofJoin=?,CNIC=?,DateofFee=?,Image=? \nWhere Name=?; ";


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
                insertstatement.setBlob(10, image1);
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
