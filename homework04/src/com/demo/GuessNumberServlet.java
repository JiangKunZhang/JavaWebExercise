package com.demo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

/**
 * @author PineappleSnow
 * @version 1.0
 * @date 2020/5/12 12:36
 */
@WebServlet("/GuessNumberServlet")

public class GuessNumberServlet extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int magic = new Random().nextInt(100)+1;
        System.out.println("magic="+magic);
        HttpSession session = request.getSession();
        session.setAttribute("num",new Integer(magic));
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        out.println("<HTML><BODY>");
        out.println("Please guess a number,the number is between 0 and 100!");
        out.println("<form action='/homework04/GuessNumberServlet' method='post'> ");
        out.println("<input type='text' name='guess'>");
        out.println("<input type='submit' value='确定'>");
        out.println("</form>");
        out.println("</BODY></HTML>");
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int guess = Integer.parseInt(request.getParameter("guess"));
        HttpSession session = request.getSession();
        int magic = (Integer) session.getAttribute("num");

        response.setContentType("textml;charset=utf-8");
        PrintWriter out = response.getWriter();
        out.println("<HTML><BODY>");
        if (guess == magic) {
            session.invalidate();
            out.println("Congratulation,you're right!  ");
            out.println("<a href='/homework04/GuessNumberServlet'>Guess again</a> ");
        } else if (guess < magic) {
            out.println("It's too little,please try again! ");
        } else {
            out.println("It's too large,please try again! ");
        }
        out.println("<form action='/homework04/GuessNumberServlet' method='post'> ");
        out.println("<input type='text' name='guess'>");
        out.println("<input type='submit' value='submit'>");
        out.println("</form>");
        out.println("  </BODY></HTML>");
    }

}

