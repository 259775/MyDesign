package domain;

public class Course {
    private String cId;
    private String cName;
    private String cIntroduce;
    private String cIconPath;
    private String cVideoPath;
    private String cTextPath;

    @Override
    public String toString() {
        return "Course{" +
                "cId='" + cId + '\'' +
                ", cName='" + cName + '\'' +
                ", cIntroduce='" + cIntroduce + '\'' +
                ", cIconPath='" + cIconPath + '\'' +
                ", cVideoPath='" + cVideoPath + '\'' +
                ", cTextPath='" + cTextPath + '\'' +
                '}';
    }

    public String getcId() {
        return cId;
    }

    public void setcId(String cId) {
        this.cId = cId;
    }

    public String getcName() {
        return cName;
    }

    public void setcName(String cName) {
        this.cName = cName;
    }

    public String getcIntroduce() {
        return cIntroduce;
    }

    public void setcIntroduce(String cIntroduce) {
        this.cIntroduce = cIntroduce;
    }

    public String getcIconPath() {
        return cIconPath;
    }

    public void setcIconPath(String cIconPath) {
        this.cIconPath = cIconPath;
    }

    public String getcVideoPath() {
        return cVideoPath;
    }

    public void setcVideoPath(String cVideoPath) {
        this.cVideoPath = cVideoPath;
    }

    public String getcTextPath() {
        return cTextPath;
    }

    public void setcTextPath(String cTextPath) {
        this.cTextPath = cTextPath;
    }
}
