package com.zp.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class LoginFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.out.println ("LoginFilter拦截了");
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;

        HttpSession session = req.getSession ();
        Object username = session.getAttribute ("username");

        if (username == null){
            resp.sendRedirect (req.getContextPath () + "/back/login.jsp");
        }else {
            chain.doFilter (req,resp);
        }
    }

    @Override
    public void destroy() {

    }
}
