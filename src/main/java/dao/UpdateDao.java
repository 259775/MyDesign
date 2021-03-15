package dao;

import connectionPool.ConnectionPool;
import domain.MyConnection;
import util.MySpring;

import java.sql.PreparedStatement;

public class UpdateDao {
    ConnectionPool conPool=(ConnectionPool) MySpring.getBean("connectionPool.ConnectionPool");

    public int update(String sql,String... parameter){
        MyConnection connection = conPool.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        Integer result=null;
        try{
            if (parameter != null || parameter.length != 0) {
                for (int i = 0; i < parameter.length; i++) {
                    preparedStatement.setObject(i + 1, parameter[i]);
                }
            }

           result = preparedStatement.executeUpdate();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            connection.close();
        }
        return result;
    }
}
