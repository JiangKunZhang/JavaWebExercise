package com.demo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.*;

/**
 * @author PineappleSnow
 * @version 1.0
 * @date 2020/4/20 0:23
 */

@WebServlet(name="ConfigDemoServlet",
        urlPatterns = {"/config-demo"},
        initParams = {
                @WebInitParam(name = "email", value = "hacker@163.com"),
                @WebInitParam(name = "telephone", value = "8899123")
        })
public class ConfigDemoServlet extends HttpServlet{
    String servletName = null;
    ServletConfig config = null;
    String email = null;
    String telephone = null;
    String admin_email=null;
    String admin_tel=null;
    private ServletContext servletContext;

    public void init(ServletConfig config) {
        this.config = config;
        servletName = config.getServletName();
        email = config.getInitParameter("email");
        telephone = config.getInitParameter("telephone");
    }
    public void doGet(HttpServletRequest request,
                      HttpServletResponse response)
            throws ServletException,IOException{
        response.setContentType("text/html;charset=UTF-8");
//写入日志文件
        this.servletContext=config.getServletContext();
        String admin_email = servletContext.getInitParameter("admin-email");//利用名字获取值
        String admin_tel = servletContext.getInitParameter("admin-tel");//利用名字获取值

        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<head><title>配置对象</title></head>");
        out.println("Servlet名称："+servletName+"<br>");
        out.println("Email地址："+email+"<br>");
        out.println("电话："+telephone);
        out.println("</body></html>");

        out.println("<br><br>");
        out.println("web.xml文件中的初始化参数值admin-email: " + admin_email);
        out.println("web.xml文件中的初始化参数值admin-tel: " + admin_tel);

    }
}
