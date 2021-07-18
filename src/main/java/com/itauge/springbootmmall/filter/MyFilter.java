package com.itauge.springbootmmall.filter;

import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

//@Component
//@WebFilter(urlPatterns = "/*",filterName = "userfilter")
public class MyFilter implements Filter {

    private static final Set<String> ALLOWED_PATHS = Collections.unmodifiableSet(new HashSet<>(
            Arrays.asList("","/product/list","/user/login","/user/register","/productCategory/list","/login.html", "/logout", "/register.html","/menu","/order","/account/login","/user","")));

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException, IOException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        HttpSession session = request.getSession();
//        User user = (User) session.getAttribute("user");

        String path = request.getRequestURI().substring(request.getContextPath().length()).replaceAll("[/]+$", "");
        boolean loggedInUser = (session != null && session.getAttribute("user") != null);
        boolean loggedInAdmin = (session != null && session.getAttribute("admin") != null);

        boolean allowedPath = ALLOWED_PATHS.contains(path);

        if (loggedInUser || allowedPath || loggedInAdmin) {
            filterChain.doFilter(servletRequest, servletResponse);
        }
        else {
            response.sendRedirect(request.getContextPath() + "/login.html");
        }

//        String url = request.getRequestURI();
//        int idx = url.lastIndexOf("/");
//        String endWith = url.substring(idx + 1);
//
//
//        if(!endWith.equals("login.html")){
//            if (user == null){
//                response.sendRedirect("/login.html");
//            }else{
//                filterChain.doFilter(servletRequest,servletResponse);
//            }
//        }
//        filterChain.doFilter(servletRequest,servletResponse);

    }

    @Override
    public void destroy() {
    }
}
