package com.valensmarcos.controller;

import com.valensmarcos.dao.DAOUser;
import com.valensmarcos.model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.lang.reflect.Array;
import java.time.LocalDateTime;
import java.util.Arrays;

@WebServlet(name = "loginController", urlPatterns = "/login")
public class LoginFormController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("loginForm.jsp").forward(req, resp);
        /*Cookie[] cookies = req.getCookies();
        System.out.println(Arrays.toString(cookies));
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("remember") && cookie.getComment().equals("true")) {

                }
            }
        }*/
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userName = req.getParameter("user");
        String password = req.getParameter("password");
        String remember = req.getParameter("remember");
        User user = DAOUser.getInstance().authenticated(userName, password);
        if (user != null) {
            if (remember != null && remember.equals("true")) {
                Cookie cookie = new Cookie("remember", "YES");
                //cookie.setSecure(true);
                cookie.setMaxAge(60*60);
                resp.addCookie(cookie);
            }

            //Create the session

            HttpSession session = req.getSession();
            session.setAttribute("userName", userName);
            session.setAttribute("authenticate", "YES");
            session.setAttribute("lastActivity", LocalDateTime.now());
            session.setMaxInactiveInterval(0);
            resp.sendRedirect("planet");
        } else {
            req.setAttribute("errorValidation", true);
            req.getRequestDispatcher("loginForm.jsp").forward(req, resp);
        }
    }
}

