package com.ciklum.interceptor;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by olegnikitindev on 05.08.2016.
 */
public class HandleNameInterceptor extends HandlerInterceptorAdapter {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if (request.getSession().getAttribute("userName") != null || request.getRequestURI().equals("/auth")) {
            return true;
        }
        request.getSession().getServletContext().getNamedDispatcher("enterNameServlet").forward(request, response);
        return false;
    }
}
