package service;

import dao.SelectDao;
import domain.Course;
import util.MySpring;

public class VideoService {
    SelectDao selectDao =(SelectDao) MySpring.getBean("dao.SelectDao");

    public Course findCourse(String cId){
        String sql = "select * from course where cId = ?";
        Course result =(Course) (selectDao.selectOne(sql,"domain.Course",cId));
        return result;
    }
}
