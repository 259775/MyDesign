package domain;

public class Student {
    private String sId;
    private String sPassword;
    private String sName;
    private Integer sAge;
    private String sSex;
    private String sNative;
    private String sPhone;
    private String sEmail;
    private String sSchool;
    private String sIntroduce;
    private String sPicture;

    public String getsPhone() {
        return sPhone;
    }

    public void setsPhone(String sPhone) {
        this.sPhone = sPhone;
    }
    public String getsPassword() {
        return sPassword;
    }

    public void setsPassword(String sPassword) {
        this.sPassword = sPassword;
    }


    public String getsId() {
        return sId;
    }

    public void setsId(String sId) {
        this.sId = sId;
    }

    public String getsName() {
        return sName;
    }

    public void setsName(String sName) {
        this.sName = sName;
    }

    public Integer getsAge() {
        return sAge;
    }

    public void setsAge(Integer sAge) {
        this.sAge = sAge;
    }

    @Override
    public String toString() {
        return "Student{" +
                "sId='" + sId + '\'' +
                ", sPassword='" + sPassword + '\'' +
                ", sName='" + sName + '\'' +
                ", sAge='" + sAge + '\'' +
                ", sSex='" + sSex + '\'' +
                ", sNative='" + sNative + '\'' +
                ", sEmail='" + sEmail + '\'' +
                ", sSchool='" + sSchool + '\'' +
                ", sIntroduce='" + sIntroduce + '\'' +
                ", sPicture='" + sPicture + '\'' +
                '}';
    }

    public String getsSex() {
        return sSex;
    }

    public void setsSex(String sSex) {
        this.sSex = sSex;
    }

    public String getsNative() {
        return sNative;
    }

    public void setsNative(String sNative) {
        this.sNative = sNative;
    }

    public String getsEmail() {
        return sEmail;
    }

    public void setsEmail(String sEmail) {
        this.sEmail = sEmail;
    }

    public String getsSchool() {
        return sSchool;
    }

    public void setsSchool(String sSchool) {
        this.sSchool = sSchool;
    }

    public String getsIntroduce() {
        return sIntroduce;
    }

    public void setsIntroduce(String sIntroduce) {
        this.sIntroduce = sIntroduce;
    }

    public String getsPicture() {
        return sPicture;
    }

    public void setsPicture(String sPicture) {
        this.sPicture = sPicture;
    }
}
