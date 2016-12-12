package com.yx.statistics.common;

import com.alibaba.fastjson.JSONObject;
import com.yx.statistics.Util.CommonUtil;
import org.apache.log4j.Logger;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by zhang on 2016/12/12.
 */
public class CorsResponseFilter implements Filter {
    private static final Logger LOG=Logger.getLogger(CorsResponseFilter.class);

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        LOG.info(String.format("处理跨域请求 ip:%s\t\tparams:%s",CommonUtil.getRemoteHost((HttpServletRequest) request),JSONObject.toJSONString(request.getParameterMap())));
        HttpServletResponse httpServletResponse=(HttpServletResponse)response;
        httpServletResponse.setHeader("Pragma", "No-cache");
        httpServletResponse.setHeader("Cache-Control", "no-cache");
        httpServletResponse.setCharacterEncoding("UTF-8");
        httpServletResponse.setHeader("Access-Control-Allow-Origin", "*");
        httpServletResponse.setHeader("Access-Control-Allow-Methods", "GET,POST,OPTIONS");
        httpServletResponse.setHeader("Access-Control-Allow-Headers", "x-requested-with,content-type");
        chain.doFilter(request,response);
    }

    @Override
    public void destroy() {

    }
}
