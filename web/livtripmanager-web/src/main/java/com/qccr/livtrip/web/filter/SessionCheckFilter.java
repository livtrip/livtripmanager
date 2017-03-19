package com.qccr.livtrip.web.filter;

import com.qccr.livtrip.common.constant.Constant;
import org.springframework.stereotype.Component;
import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 *后台请求的拦截器
 * @author xierongli
 * @version $$Id: livtripmanager-parent, v 0.1 2016/10/26 11:14 user Exp $$
 */
@Component
//@WebFilter(filterName = "sessionCheckFilter", urlPatterns = ("/backend/*"), initParams = {@WebInitParam(name="loginPage",value="login.html"), @WebInitParam(name="loginServlet",value="loginProcess") })
public class SessionCheckFilter implements Filter{

    private FilterConfig config;


    public SessionCheckFilter(){}
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        this.config = filterConfig;
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        //获取初始化数据
        String loginPage = config.getInitParameter("loginPage");
        String loginServlet = config.getInitParameter("loginServlet");

        HttpSession session = ((HttpServletRequest)request).getSession();
        HttpServletRequest req = ((HttpServletRequest)request);
        HttpServletResponse res = ((HttpServletResponse)response);
        String requestPath = req.getRequestURI();
        requestPath = requestPath.substring(requestPath.lastIndexOf("/"), requestPath.length());

        if(session.getAttribute(Constant.SESSION_USER_NAME) != null
         || "".equals(requestPath) || requestPath.endsWith(loginPage) || requestPath.endsWith(loginServlet)){
            chain.doFilter(request, response);
        }else{
            req.setAttribute("tip", "您还未登录,请先登录!");
            //req.getRequestDispatcher("login.html").forward(request,response);
            res.sendRedirect(((HttpServletRequest)request).getContextPath() + "/login.html");
        }
    }

    @Override
    public void destroy() {
        this.config = null;
    }
}
