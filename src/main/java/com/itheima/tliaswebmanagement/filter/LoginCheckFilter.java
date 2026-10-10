package com.itheima.tliaswebmanagement.filter;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.util.StringUtil;
import com.itheima.tliaswebmanagement.pojo.Result;
import com.itheima.tliaswebmanagement.utils.JwtUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Slf4j
//@WebFilter(urlPatterns = "/*")
public class LoginCheckFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse resp = (HttpServletResponse) servletResponse;

        // 1. 获取请求url
        String url = req.getRequestURI().toString();
        log.info("请求的url:{}",url);
        // 2. 判断请求url中是否含有login,如果包含，说明是登陆操作，放行
        if(url.contains("login")){
            log.info("登陆操作，放行。。。。。。。");
            filterChain.doFilter(servletRequest, servletResponse);
            return;
        }
        // 3. 获取请求头中的令牌（token）
        String jwt = req.getHeader("token");

        // 4. 判断令牌是否存在，如果不存在返回错误结果（未登录）
        if(!StringUtils.hasLength(jwt)){
            log.info("请求头token为空，返回未登陆的信息");
            Result error = Result.error("NOT_LOGIN");
            // 手动将对象转换为json格式然后响应回去------> 阿里巴巴提供：  fastJSON
            String notLogin = JSONObject.toJSONString(error);
            resp.getWriter().write(notLogin);
            return;
        }
        // 5. 解析token，如果解析失败，返回错误结果（未登录）
        try {
            JwtUtils.parseJWT(jwt);
        } catch (Exception e) { // 解析失败
            e.printStackTrace();
            log.info("解析令牌失败，");
            Result error = Result.error("NOT_LOGIN");
            // 手动将对象转换为json格式然后响应回去------> 阿里巴巴提供：  fastJSON
            String notLogin = JSONObject.toJSONString(error);
            resp.getWriter().write(notLogin);
            return;
        }


        // 6. 放行
        log.info("令牌合法");
        filterChain.doFilter(servletRequest, servletResponse);
        log.info("放行后逻辑执行");
    }
}
