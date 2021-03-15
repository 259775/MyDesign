package controller;

import com.alibaba.fastjson.JSONObject;
import service.TextService;
import util.MySpring;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet("/view/selectText")
public class TextListServlet extends HttpServlet {

    TextService textService = (TextService)MySpring.getBean("service.TextService");

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        HttpSession session = req.getSession();
        String userid =(String) session.getAttribute("userid");
        //调用service层方法
        List allText = textService.allText(userid);

        JSONObject jsonObject =new JSONObject();
        jsonObject.put("texts",allText);

        resp.setCharacterEncoding("utf-8");
        resp.getWriter().write(jsonObject.toJSONString());
    }
}
