package com.cheney.satisfy.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cheney.satisfy.exception.UnLoginException;
import com.cheney.satisfy.model.User;

//@WebFilter("/*")
//@Component
//@ServletComponentScan
public class LoginFilter implements Filter {

    public LoginFilter() {
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response,
            FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;



        String uri = req.getRequestURI();
        if (uri.indexOf("login") >= 0) {
            chain.doFilter(req, resp);
            return;
        }

        HttpSession session = req.getSession();
        User user = (User) session.getAttribute("user");
        if (user != null) {
            chain.doFilter(req, resp);
        } else {
            throw new UnLoginException();
        }
    }

    @Override
    public void destroy() {

    }

}
