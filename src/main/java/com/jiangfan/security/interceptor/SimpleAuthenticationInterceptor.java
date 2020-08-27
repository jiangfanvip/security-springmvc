package com.jiangfan.security.interceptor;

import com.jiangfan.security.entity.UserDto;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * ClassName: SimpleAuthenticationInterceptor
 * Description:
 * date: 2020-8-21 13:51
 *
 * @author LENOVO
 * @since JDK 1.8
 */
public class SimpleAuthenticationInterceptor implements HandlerInterceptor {
    /**
     * 调用方法之前
     *
     * @param request
     * @param response
     * @param handler
     * @return
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        UserDto userDto = (UserDto) request.getSession().getAttribute("_user");
        if (userDto == null) {
            response.setCharacterEncoding("GBK");
            printWriteMessage(response,  "not...login 没有登录，请先登录!");
            return  false;
        }
        //验证权限
        String authentication = userDto.getAuthentication();  //"p1"  "p2"
        String requestURI = request.getRequestURI();
        if ("p1".equals(authentication) &&requestURI.contains("/resources1")) {
            return true;
        }
        if ("p2".equals(authentication) && requestURI.contains("/resources2")) {
            return true;
        }
        response.setCharacterEncoding("GBK");
        printWriteMessage(response, userDto.getUserName() + "权限:" + authentication + "无法访问" + request.getRequestURI());
        return false;
    }

    private void printWriteMessage(HttpServletResponse response, String message) throws IOException {
        PrintWriter writer = response.getWriter();
        writer.print(message);
    }

    /**
     * 方法处理之后，渲染之前
     *
     * @param request
     * @param response
     * @param handler
     * @param modelAndView
     * @throws Exception
     */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    /**
     * 渲染之后
     *
     * @param request
     * @param response
     * @param handler
     * @param ex
     * @throws Exception
     */
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
