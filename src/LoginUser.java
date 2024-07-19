
public class LoginUser {
    private String Username;
    private String Password;
    private String Usertype;
    private Long phoneNumber;

    LoginUser(String name,String pass)
    {
        this.Username=name;
        this.Password=pass;        
    }
    LoginUser(String name,String pass,String type,Long no)
    {
        this.Username=name;
        this.Password=pass;
        this.Usertype=type;
        this.phoneNumber=no;
    }

    public String getUserName()
    {
        return this.Username;
    }
    public String getPassword()
    {
        return this.Password;
    }
    public String getUserType()
    {
        return this.Usertype;
    }
    public Long getPhone()
    {
        return this.phoneNumber;
    }
    
}
