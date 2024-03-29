package com.zhq.neti.intercepter;

import cn.hutool.core.util.StrUtil;
import com.zhq.neti.common.Const;
import com.zhq.neti.common.SessionCache;
import com.zhq.neti.exception.NoSessionException;
import com.zhq.neti.pojo.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Map;

@Slf4j
public class SessionIntercepter implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object handler) throws Exception {
        /**
         * 请求中controller的方法名
         */
        HandlerMethod handlerMethod = (HandlerMethod) handler;
        /**
         * 解析handlerMethod
         */
        String methodName = handlerMethod.getMethod().getName();
        String className = handlerMethod.getBean().getClass().getSimpleName();
        /**
         * 解析参数,具体的参数key value值是什么,打印日志
         */
        StringBuffer requestParamBuffer = new StringBuffer();
        Map paramMap = httpServletRequest.getParameterMap();
        Iterator it = paramMap.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            String mapKey = (String) entry.getKey();
            String mapValue = StrUtil.EMPTY;
            /**
             * request这个参数的map,里面的value返回的是一个String[]
             */
            Object object = entry.getValue();
            if (object instanceof String[]) {
                String[] messages = (String[]) object;
                mapValue = Arrays.toString(messages);
            }
            requestParamBuffer.append(mapKey).append("=").append(mapValue);
        }

        String param = requestParamBuffer.toString();
        log.info("权限拦截器拦截的请求，className:{},methodName:{},param:{}", className, methodName, StrUtil.isEmpty(param)?"无参数":param);
        String token = httpServletRequest.getHeader(Const.TOKEN);
        User user = SessionCache.get(token);
        if (user == null) {
            throw new NoSessionException("用户未登录");
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object handler, ModelAndView modelAndView) throws Exception {
        //log.info("postHandle");
    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object handler, Exception e) throws Exception {
        //log.info("afterCompletion");
    }
}
