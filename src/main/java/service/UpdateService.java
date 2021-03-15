package service;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import dao.UpdateDao;
import domain.Student;
import util.MySpring;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class UpdateService {

    UpdateDao updateDao =(UpdateDao) MySpring.getBean(MySpring.DaoUpdate);
    //此方法通用性低,待改进
    public String saveStudent(String value, String factor){
        String[] parameters = this.parseParameter(value,factor);
        //拼接sql
        String sql = "update student set sName=?,sAge= ?,sSex=?," +
                "sNative =? ,sPhone=?,sEmail=?,sIntroduce=?,sPicture=? where sId = ?";
        if(updateDao.update(sql,parameters)!=0){
            return "修改成功";
        }else {
            return "修改失败";
        }
    }

    //这里应该写在DAO层
    private String[] parseParameter(String value,String factor){
        String[] parameters =new String[9];
        HashMap hashMap = JSONObject.parseObject(value, HashMap.class);

        //Dao层可以重载一个参数时list的方法
        List<Object> values = this.getValues(hashMap);
        for(int i=0;i<values.size();i++){
            parameters[i] =(String) values.get(i);
        }
        parameters[8] = factor;
        return parameters;
    }

    //这里应该写在DAO层
    private List<Object> getValues(HashMap map){
        List<Object> ls =new ArrayList<>();
        ls.add(map.get("sName"));
        ls.add(map.get("sAge"));
        ls.add(map.get("sSex"));
        ls.add(map.get("sNative"));
        ls.add(map.get("sPhone"));
        ls.add(map.get("sEmail"));
        ls.add(map.get("sIntroduce"));
        ls.add(map.get("sPicture"));
        return ls;
    }
}
