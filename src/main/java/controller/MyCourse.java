package controller;

import com.alibaba.fastjson.JSONObject;
import domain.Course;
import service.CourseService;
import util.MySpring;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

@WebServlet("/view/allCourse")
public class MyCourse extends HttpServlet {
    CourseService courseService =(CourseService) MySpring.getBean("service.CourseService");
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        HttpSession session = req.getSession();
        String userid =(String) session.getAttribute("userid");

        ArrayList<HashMap<String,Object>> result = courseService.allCourse(userid);
        System.out.println(result);
        JSONObject jsonObject =new JSONObject();
        jsonObject.put("course",result);

        resp.setCharacterEncoding("utf-8");
        resp.getWriter().write(jsonObject.toJSONString());

    }
}
