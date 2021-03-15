package controller;

import service.UserService;
import util.MySpring;
import util.ThreadLocalManager;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    UserService service =(UserService) MySpring.getBean("service.UserService");
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String userid = request.getParameter("userid");
        String password = request.getParameter("password");
        System.out.println(userid + password);
        if(userid == "" || password==""){
            request.setAttribute("errorMes","账号/密码不能为空");
            request.getRequestDispatcher("./login.jsp").forward(request,response);
        }else {
            ThreadLocal threadLocal = null;
            if(service.loginCheck(userid,password)){
                System.out.println("成功");
                HttpSession session = request.getSession();
                session.setAttribute("userid",userid);
                threadLocal = ThreadLocalManager.getThreadLocal(userid);
                //使用异步传输把user对象穿过去
//            JSONObject jsonObject = new JSONObject();
//            jsonObject.put("user",threadLocal.get());
                session.setAttribute("user",threadLocal.get());
                //设置传输对象
                RequestDispatcher rd = request.getRequestDispatcher("./index.jsp");
//            response.getWriter().write(jsonObject.toJSONString());
                rd.forward(request,response);
                threadLocal.remove();
            }else {
                request.setAttribute("errorMes","账号或密码错误 ");
                request.getRequestDispatcher("./login.jsp").forward(request,response);
            }
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req,resp);
    }
}
