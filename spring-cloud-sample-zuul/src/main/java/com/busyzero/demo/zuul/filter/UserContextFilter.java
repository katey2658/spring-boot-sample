package com.busyzero.demo.zuul.filter;

import com.busyzero.demo.stream.utils.UserContextHolder;
import com.busyzero.demo.stream.vo.UserContext;
import com.busyzero.demo.zuul.utils.UserContextHolder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@Component
public class UserContextFilter implements Filter {
    private static final Logger logger = LoggerFactory.getLogger(UserContextFilter.class);
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        UserContextHolder.curUserContenxt().setCorrelationId(request.getHeader(UserContext.CORRELATION_ID));
        UserContextHolder.curUserContenxt().setUserId(request.getHeader(UserContext.USER_ID));
        UserContextHolder.curUserContenxt().setOrgId(request.getHeader(UserContext.ORG_ID));
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {

    }
}
