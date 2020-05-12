package com.demo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author PineappleSnow
 * @version 1.0
 * @date 2020/5/12 14:01
 */
@WebServlet("/CheckUserServlet")
public class CheckUserServlet extends HttpServlet {
    String message = null;
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        String value1 = "", value2 = "";
        Cookie cookie = null;
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (int i = 0; i < cookies.length; i++) {
                cookie = cookies[i];
                if (cookie.getName().equals("username"))
                    value1 = cookie.getValue();
                if (cookie.getName().equals("password"))
                    value2 = cookie.getValue();
            }
            if (value1.equals("admin") && value2.equals("admin")) {
                message = "欢迎您: " + value1 + "再次登录该页面！";
                request.getSession().setAttribute("message", message);
                response.sendRedirect("welcome.jsp");

            } else {
                response.sendRedirect("login.jsp");
            }
        } else {
            response.sendRedirect("login.jsp");
        }

    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        String username = request.getParameter("userName").trim();
        String password = request.getParameter("password").trim();
        if(!username.equals("admin") || !password.equals("admin")){
            message = "用户名或口令不正确，请重试！";
            request.getSession().setAttribute("message",message);
            response.sendRedirect("login.jsp");
        }else{
            // 如果用户选中了“自动登录”复选框，向浏览器发送2个Cookie
            if((request.getParameter("check")!=null) &&
                    (request.getParameter("check").equals("check"))){
                Cookie nameCookie = new Cookie("username", username);
                Cookie pswdCookie = new Cookie("password", password);
                nameCookie.setMaxAge(60*60);
                pswdCookie.setMaxAge(60*60);
                response.addCookie(nameCookie);
                response.addCookie(pswdCookie);
            }
            message = "你已成功登录！";
            request.getSession().setAttribute("message",message);
            response.sendRedirect("welcome.jsp");
        }
    }
}
