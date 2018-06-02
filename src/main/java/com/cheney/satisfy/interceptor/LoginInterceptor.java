package com.cheney.satisfy.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.cheney.satisfy.exception.UnLoginException;
import com.cheney.satisfy.model.User;

public class LoginInterceptor implements HandlerInterceptor {

    public LoginInterceptor() {
    }

    @Override
    public boolean preHandle(HttpServletRequest request,
            HttpServletResponse response, Object handler) {
        String uri = request.getRequestURI();
        System.out.println(uri);
        if (uri.indexOf("login") >= 0 || uri.indexOf("register") >= 0 || uri.indexOf("session") >= 0 || uri.indexOf("logout") >= 0 || uri.indexOf("emailOrName") >= 0) {
            return true;
        }

        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        System.out.println("......" + uri);
        if (user != null) {
            return true;
        } else {
            throw new UnLoginException();
        }
    }

    @Override
    public void postHandle(HttpServletRequest request,
            HttpServletResponse response, Object handler,
            ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request,
            HttpServletResponse response, Object handler, Exception ex)
            throws Exception {

    }

}
