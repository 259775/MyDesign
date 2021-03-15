package service;

import dao.SelectDao;
import domain.Student;
import util.MySpring;
import util.ThreadLocalManager;

public class UserService {

    private SelectDao sd = (SelectDao) MySpring.getBean(MySpring.DaoSelect);

    public Boolean loginCheck(String id,String password){
        String sql="select * from student where sId = ? ";
        Student user = sd.selectOne(sql,"domain.Student",id);
        if(user!=null && user.getsId().equals(id) && user.getsPassword().equals(password)){
            ThreadLocal userLocal=new ThreadLocal();
            userLocal.set(user);
            ThreadLocalManager.setlocal(id,userLocal);
            return true;
        }
        return false;
    }

    public Student userFind(String id){
        String sql="select * from student where sId = ? ";
        Student user = sd.selectOne(sql,"domain.Student",id);
        return user;
    }

}