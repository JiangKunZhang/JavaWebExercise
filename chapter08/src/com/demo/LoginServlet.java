package com.demo;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.*;

import com.model.User;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login.do")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html;charset=gb2312");
		PrintWriter out = response.getWriter();

		String username=request.getParameter("username");
		String password=request.getParameter("password");
		DataSource dataSource=(DataSource)this.getServletContext().getAttribute("dataSource");
		try{
			Connection conn=dataSource.getConnection();
			String sql="select * from users where username=? and password=?";
			PreparedStatement pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, username);
			pstmt.setString(2, password);
			ResultSet rst=pstmt.executeQuery();
			boolean valid=rst.next();
			if(valid){
				User validuser=new User(username,password);
				request.getSession().setAttribute("user", validuser);
				out.println("欢迎您,"+username);
			}else{
				out.println("您的登录信息有误，请重新登录！");
				this.getServletContext().getRequestDispatcher("/login.jsp").forward(request, response);
			}
		}catch(Exception e){
			log("An Exception is occurred!");
		}
	}

}
