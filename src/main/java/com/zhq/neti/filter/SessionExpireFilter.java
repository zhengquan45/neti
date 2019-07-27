package com.zhq.neti.filter;

import com.zhq.neti.common.Const;
import com.zhq.neti.common.RequestHolder;
import com.zhq.neti.common.SessionCache;
import com.zhq.neti.pojo.User;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * @author zhengquan
 */
public class SessionExpireFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        String token = req.getHeader(Const.TOKEN);
        User user = SessionCache.get(token);
        if (user != null) {
            RequestHolder.add(user);
            RequestHolder.add(req);
        }
        filterChain.doFilter(servletRequest, servletResponse);
        return;
    }

    @Override
    public void destroy() {

    }
}
