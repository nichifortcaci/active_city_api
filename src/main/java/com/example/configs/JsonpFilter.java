package com.example.configs;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class JsonpFilter implements Filter {

    private String functionName;

    @Override
    public void destroy() {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse servletResponse,
                         FilterChain chain) throws IOException, ServletException {

        if (!(request instanceof HttpServletRequest)) {
            throw new ServletException("This filter can "
                    + " only process HttpServletRequest requests");
        }

        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        if (isJSONPRequest(httpRequest)) {
            ServletOutputStream out = response.getOutputStream();

            out.println(getCallbackMethod(httpRequest) + "(");
            chain.doFilter(request, response);
            out.println(");");

            response.setContentType("text/javascript");
        } else {
            response.addHeader("Access-Control-Allow-Origin", "*");
            chain.doFilter(request, response);
        }

    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        this.functionName = filterConfig.getInitParameter("encoding");
        if (this.functionName == null || this.functionName.length() <= 0) {
            this.functionName = "callback";
        }
    }

    private String getCallbackMethod(HttpServletRequest httpRequest) {
        return httpRequest.getParameter(this.functionName);
    }

    private boolean isJSONPRequest(HttpServletRequest httpRequest) {
        String callbackMethod = getCallbackMethod(httpRequest);
        return (callbackMethod != null && callbackMethod.length() > 0);
    }
}