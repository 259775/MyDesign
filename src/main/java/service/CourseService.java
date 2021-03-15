package service;

import dao.SelectDao;
import domain.Course;
import util.MySpring;

import java.util.ArrayList;

public class CourseService {
    SelectDao selectDao =(SelectDao) MySpring.getBean(MySpring.DaoSelect);


    public <T>ArrayList<T> allCourse(String userId){
        String sql = "select c.cName,c.cIconPath,c.cId from course c inner join stu_curse st on c.cId=st.cId where st.sId = ?";
        return selectDao.select(sql,userId);
    }

//    public static void main(String[] args) {
//        CourseService courseService= new CourseService();
//        System.out.println(courseService.allCourse("2017305002"));
//
//    }
}
