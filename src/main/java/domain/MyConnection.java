package domain;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class MyConnection extends AbstractCon{

    private Boolean state=false;
    private Connection con;

    {
        try {
            Class.forName(ConfigureField.getPath());
            con= DriverManager.getConnection(ConfigureField.getUrl(), ConfigureField.getUsername(), ConfigureField.getPassword());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public PreparedStatement prepareStatement(String sql){
        PreparedStatement pst=null;
        try {
            pst= con.prepareStatement(sql);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return pst;
    }

    public void close(){
        this.state=false;
    }

    public Boolean getState() {
        return state;
    }

    public void setState(Boolean state) {
        this.state = state;
    }

    public Connection getConnection() {
        return con;
    }

}
