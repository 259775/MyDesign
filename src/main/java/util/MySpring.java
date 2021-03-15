package util;

import java.util.HashMap;

public class MySpring {
    private static HashMap<String,Object> map = new HashMap<>();

    //dao下的查询方法名
    public static final String DaoSelect = "dao.SelectDao";
    public static final String DaoUpdate = "dao.UpdateDao";

    public static Object getBean(String objName){
        Object obj = map.get(objName);
        try {
            if( obj == null) {
                Class clazz = Class.forName(objName);
                obj = clazz.newInstance();
                map.put(objName,obj);
            }
            } catch (Exception e) {
                e.printStackTrace();
            }
        return obj;
        }
    }
