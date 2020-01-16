package com.vue.chy.interceptor;


import org.apache.commons.lang.StringUtils;
import org.eclipse.jdt.internal.compiler.ast.FalseLiteral;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginInterceptor implements HandlerInterceptor {

    //目标方法执行之前
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HttpSession session = request.getSession();
        String contextPath = session.getServletContext().getContextPath();
        String[] requireAuthPages = new String[]{
                "index",
        };
        String requestURI = request.getRequestURI();
        String uri = StringUtils.remove(requestURI, contextPath + "/");
        String page = uri;

        if(beginwith(page,requireAuthPages)){

        }
        return true;
    }

    private boolean beginwith(String page,String[] requireAuthPages){
        boolean Result= false;
        for (String requireAuthpage:requireAuthPages ) {
            if (StringUtils.startsWith(page,requireAuthpage)){
               Result= true;
                break;
            }
        }
        return  Result;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {

    }
}
