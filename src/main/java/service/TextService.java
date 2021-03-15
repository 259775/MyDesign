package service;

import dao.SelectDao;
import util.MySpring;

import java.util.ArrayList;
import java.util.List;

public class TextService {

    SelectDao selectDao =(SelectDao) MySpring.getBean(MySpring.DaoSelect);

    public List allText(String userId){
        String sql ="select sc.sId,g.cId,g.cName,g.textName,g.grade,c.cVideoPath from grade g inner join course c on c.cId=g.cId inner join stu_curse sc on c.cId = sc.cId where sc.sId = ?";
        //调用底层查询方法
        return selectDao.select(sql, userId);
    }

//    public static void main(String[] args) {
//        TextService textService =new TextService();
//        System.out.println(textService.allText("2017305002"));
//
//    }
}

