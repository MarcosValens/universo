package com.valensmarcos.interceptor;

import com.valensmarcos.controller.LoginFormController;
import com.valensmarcos.controller.PlanetFormController;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

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
        String authenticate = (String) session.getAttribute("authenticate");

        if (authenticate != null && authenticate.equals("YES")) {
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