package com.valensmarcos.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet (name = "loginController", urlPatterns = "/login")
public class LoginFormController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("loginForm.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userName = req.getParameter("user");
        String password = req.getParameter("password");
        if (userName.equals("admin") && password.equals("admin")){

            //Create the session

            HttpSession session = req.getSession();
            session.setAttribute("userName",userName);
            session.setAttribute("authenticate","YES");
            session.setMaxInactiveInterval(5*60);
            resp.sendRedirect("planet");
        } else {
            req.setAttribute("errorValidation",true);
            req.getRequestDispatcher("loginForm.jsp").forward(req,resp);
        }
    }
}
