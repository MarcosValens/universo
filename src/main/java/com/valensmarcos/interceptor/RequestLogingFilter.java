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
import java.time.Duration;
import java.time.LocalDateTime;
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
        /*Cookie[] cookies = req.getCookies();
        Cookie cookie = Arrays.stream(cookies).filter(cookie1 -> "remember".equals(cookie1.getName())).findAny().orElse(null);*/
        Duration duration;

        String authenticate = (String) session.getAttribute("authenticate");
        LocalDateTime lastActivity = (LocalDateTime) session.getAttribute("lastActivity");
        LocalDateTime now = LocalDateTime.now();
        if (lastActivity != null) {
            duration = Duration.between(now, lastActivity);
            Duration.between(now, lastActivity);
            long diff = Math.abs(duration.toMinutes());
            if (diff > 5) {
                session.invalidate();
                resp.sendRedirect("login");
            } else {
                session.setAttribute("lastActivity", lastActivity);
            }
        }

        if (authenticate != null && authenticate.equals("YES")) {
            filterChain.doFilter(servletRequest, servletResponse);
        }/* else if (cookie != null) {
            String userName = cookie.getValue();
            User user = DAOUser.getInstance().getByName(userName);
            session.setAttribute("userName", userName);
            session.setAttribute("authenticate", "YES");
            session.setAttribute("userObject", user);
            session.setMaxInactiveInterval(0);
            filterChain.doFilter(servletRequest, servletResponse);
        }*/ else {
            resp.sendRedirect("login");
        }
    }

    @Override
    public void destroy() {
        System.out.println("Destroy");
    }
}
