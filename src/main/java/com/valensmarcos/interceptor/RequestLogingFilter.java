package com.valensmarcos.interceptor;

import com.valensmarcos.controller.LoginFormController;
import com.valensmarcos.controller.PlanetFormController;
import com.valensmarcos.dao.DAOUser;
import com.valensmarcos.model.User;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Arrays;

@WebFilter(servletNames = {"PlanetFormController", "PlanetController"})
public class RequestLogingFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("Init");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse resp = (HttpServletResponse) servletResponse;
        HttpSession session = req.getSession();
        Cookie[] cookies = req.getCookies();
        Cookie cookie = Arrays.stream(cookies).filter(cookie1 -> "userName".equals(cookie1.getName())).findAny().orElse(null);

        String authenticate = (String) session.getAttribute("authenticate");
        if (authenticate != null && authenticate.equals("YES")) {
            filterChain.doFilter(servletRequest, servletResponse);
        } else if (cookie != null) {
            String userName = cookie.getValue();
            User user = DAOUser.getInstance().getByName(userName);
            session.setAttribute("userName", userName);
            session.setAttribute("authenticate", "YES");
            session.setAttribute("userObject",user);
            session.setMaxInactiveInterval(10);
            filterChain.doFilter(servletRequest, servletResponse);
        } else {
            resp.sendRedirect("login");
        }
    }

    @Override
    public void destroy() {
        System.out.println("Destroy");
    }
}
