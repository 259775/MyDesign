package dao;

import connectionPool.ConnectionPool;
import domain.ConfigureField;
import domain.Course;
import domain.MyConnection;
import domain.Student;
import util.MySpring;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class SelectDao {

    ConnectionPool conPool=(ConnectionPool) MySpring.getBean("connectionPool.ConnectionPool");

//    private ConfigureField configureField;

    public <T>T selectOne(String sql,String classname,Object... parameter){
        ArrayList<Object> value = this.selectByClassName(sql, classname,parameter);
        return (T)value.get(0);
    }

    public <T>ArrayList<T> select(String sql,Object... parameter){
        return this.selectByClassName(sql,null,parameter);
    }

    public <T>ArrayList<T> selectByClassName(String sql, String classname, Object... parameter){
        MyConnection connection = conPool.getConnection();
        PreparedStatement pst = connection.prepareStatement(sql);
        try {
            if(parameter!=null){
                for (int i = 0; i < parameter.length; i++) {
                    pst.setObject(i + 1, parameter[i]);
                }
            }

            ResultSet resultSet = pst.executeQuery();

            if(classname!=null) {
                //有对象的记录
                Class clazz = Class.forName(classname);
                Constructor constructor = clazz.getConstructor();
                ArrayList<T> result = new ArrayList<T>();
                HashMap<String, Method> methods = this.getMethods(resultSet, classname);
                Set<String> keys = methods.keySet();

                while (resultSet.next()) {
                    //获取迭代器
                    Iterator<String> iterator = keys.iterator();
                    //生成每一条记录对应的对象
                    Object obj = constructor.newInstance();
                    //遍历迭代器
                    while (iterator.hasNext()) {
                        //取出当前key
                        String value = iterator.next();
                        // 查询到的值
                        Object fieldValue = resultSet.getObject(value);
                        //找到相应方法，并给对象属性赋值
                        methods.get(value).invoke(obj, fieldValue);
                    }
                    result.add((T) obj);
                }
                return result;
            }else {
                ArrayList<HashMap<String,Object>> resultMap = new ArrayList<HashMap<String,Object>>();
                //调用方法获取所有的keys
                ArrayList<String> keys = this.getKeys(resultSet);
                //遍历行
                while (resultSet.next()){
                    //存储每一列的值
                    HashMap<String,Object> oneColumn = new HashMap<>();
                    //获取每一列的值
                    for (String value : keys){
                        //将值对应键
                        oneColumn.put(value,resultSet.getObject(value));
                    }
                    resultMap.add(oneColumn);
                }
                return (ArrayList<T>) resultMap;
            }
            }catch (Exception throwables) {
                    throwables.printStackTrace();
                }finally {
            connection.close();
            }
        return null;
        }




//    public static void main(String[] args) {
//        SelectDao se =(SelectDao) MySpring.getBean("dao.SelectDao");
//        String sql="select * from course where cId=?";
//        System.out.println((Course)(se.selectOne(sql,"domain.Course","002")));
//
//    }


    private ArrayList<String> getKeys(ResultSet resultSet) throws SQLException {
        ResultSetMetaData metaData = resultSet.getMetaData();
        ArrayList<String> keys = new ArrayList<>();
        for(int i=1;i<=metaData.getColumnCount();i++){
            keys.add(metaData.getColumnName(i));
        }
        return keys;
    }


    private HashMap<String,Method> getMethods(ResultSet resultSet, String classname) throws SQLException {
        ResultSetMetaData metaData = resultSet.getMetaData();
        HashMap<String,Method> methodMap = new HashMap<>();
        try {
            Class clazz = Class.forName(classname);
            for (byte i=1 ; i<=metaData.getColumnCount();i++) {
                Class aClass = this.parseDateType(metaData.getColumnTypeName(i));
                String methodName = "set";
                String columnName = metaData.getColumnName(i);methodName += columnName;
                Method method = clazz.getDeclaredMethod(methodName,aClass);
                methodMap.put(columnName,method);
            }
        } catch (Exception e) {
                        e.printStackTrace();
        }
        return methodMap;
    }

    private Class parseDateType(String columnType){
        Class colType = null;
        if(columnType.equals("VARCHAR") || columnType.equals("TEXT")){
            colType = String.class;
        }else if(columnType.equals("INT")){
            colType = Integer.class;
        }
        return colType;
    }




}


