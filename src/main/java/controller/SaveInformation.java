package controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import service.UpdateService;
import util.MySpring;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/view/saveInformation")
public class SaveInformation extends HttpServlet {

    UpdateService updateService =(UpdateService) MySpring.getBean("service.UpdateService");
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        String information = req.getParameter("information");
        String userid =(String) req.getSession().getAttribute("userid");

        //调用service
        String result = updateService.saveStudent(information,userid);

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("mes",result);

        resp.setCharacterEncoding("utf-8");
        resp.getWriter().write(jsonObject.toJSONString());
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req,resp);
    }
}
