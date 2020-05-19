package com.zp.filter;

import cn.hutool.http.HttpRequest;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class FrontLoginFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest)request;
        HttpServletResponse resp = (HttpServletResponse) response;
        HttpSession session = req.getSession ();
        Object u = session.getAttribute ("u");
        if (u == null){
            resp.sendRedirect (req.getContextPath () + "/front/user/login_form.jsp");
            return;
        }
        chain.doFilter (req, resp);

    }

    @Override
    public void destroy() {

    }
}
