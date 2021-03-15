package controller;

import com.alibaba.fastjson.JSONObject;
import domain.Course;
import service.VideoService;
import util.MySpring;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/findVideo")
public class VideoServlet extends HttpServlet {

    VideoService videoService =(VideoService) MySpring.getBean("service.VideoService");
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String cId = req.getParameter("cId");
        Course course = videoService.findCourse(cId);
        System.out.println(course);

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("course",course);
        resp.setCharacterEncoding("UTF-8");
        resp.getWriter().write(jsonObject.toJSONString());
    }
}
