package controller;

import com.alibaba.fastjson.JSONObject;
import domain.Student;
import service.UserService;
import util.MySpring;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/view/selectInformation")
public class SelectInformation extends HttpServlet {

    UserService service =(UserService) MySpring.getBean("service.UserService");

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        HttpSession session = req.getSession();
        String userid =(String) session.getAttribute("userid");

        Student student = service.userFind(userid);

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("nowUser",student);

        resp.setCharacterEncoding("UTF-8");
        resp.getWriter().write(jsonObject.toJSONString());
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req,resp);
    }
}
