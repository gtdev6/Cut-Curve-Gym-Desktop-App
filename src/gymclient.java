// import java.sql.Date;
// import java.time.LocalDate;
import java.time.LocalDate;
// import java.time.Month;
// import java.awt.image.*;
import java.io.InputStream;

// import javax.imageio.ImageIO;

public class gymclient {
    private String IDuser;
    private String NameUser;
    private Long Phone;
    private int fee;
    private boolean feecheck;
    private String NameofAdmin;
    private LocalDate Joining;
    private String cnic;
    private LocalDate dateoffee;
    private InputStream image;

    gymclient(String id,String name,Long phone,int fee,boolean feecheck,String adminname,LocalDate joining,String Cnic,LocalDate feedate,InputStream image1)
    {
        this.IDuser=id;
        this.NameUser=name;
        this.Phone=phone;
        this.fee=fee;
        this.feecheck=feecheck;
        this.NameofAdmin=adminname;
        this.Joining=joining;
        this.cnic=Cnic;
        this.dateoffee=feedate;
        this.image=image1;
    }
    

    


    /**
     * @return String return the IDuser
     */
    public String getIDuser() {
        return IDuser;
    }

    /**
     * @param IDuser the IDuser to set
     */
    public void setIDuser(String IDuser) {
        this.IDuser = IDuser;
    }

    /**
     * @return String return the NameUser
     */
    public String getNameUser() {
        return NameUser;
    }

    /**
     * @param NameUser the NameUser to set
     */
    public void setNameUser(String NameUser) {
        this.NameUser = NameUser;
    }

    /**
     * @return Long return the Phone
     */
    public Long getPhone() {
        return Phone;
    }

    /**
     * @param Phone the Phone to set
     */
    public void setPhone(Long Phone) {
        this.Phone = Phone;
    }

    /**
     * @return int return the fee
     */
    public int getFee() {
        return fee;
    }

    /**
     * @param fee the fee to set
     */
    public void setFee(int fee) {
        this.fee = fee;
    }

    /**
     * @return boolean return the feecheck
     */
    public boolean isFeecheck() {
        return feecheck;
    }

    /**
     * @param feecheck the feecheck to set
     */
    public void setFeecheck(boolean feecheck) {
        this.feecheck = feecheck;
    }

    /**
     * @return String return the NameofAdmin
     */
    public String getNameofAdmin() {
        return NameofAdmin;
    }

    /**
     * @param NameofAdmin the NameofAdmin to set
     */
    public void setNameofAdmin(String NameofAdmin) {
        this.NameofAdmin = NameofAdmin;
    }

    /**
     * @return Date return the Joining
     */
    public LocalDate getJoining() {
        return Joining;
    }

    /**
     * @param Joining the Joining to set
     */
    public void setJoining(LocalDate Joining) {
        this.Joining = Joining;
    }

    /**
     * @return Long return the cnic
     */
    public String getCnic() {
        return cnic;
    }

    /**
     * @param cnic the cnic to set
     */
    public void setCnic(String cnic) {
        this.cnic = cnic;
    }


    


    /**
     * @return LocalDate return the dateoffee
     */
    public LocalDate getDateoffee() {
        return dateoffee;
    }

    /**
     * @param dateoffee the dateoffee to set
     */
    public void setDateoffee(LocalDate dateoffee) {
        this.dateoffee = dateoffee;
    }


    /**
     * @return InputStream return the image
     */
    public InputStream getImage() {
        return image;
    }

    /**
     * @param image the image to set
     */
    public void setImage(InputStream image) {
        this.image = image;
    }

}
