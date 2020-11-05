package com.wdx.web.interceptor.impl;

import com.alibaba.fastjson.JSONObject;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.io.Writer;

/**
 * Controller层返回异常处理
 *
 * @author wangdongxing
 * @since 2020-01-06 00:50
 */
public class ResponseExceptionHandler implements HandlerExceptionResolver {

    /**
     * Controller层返回异常处理
     *
     * @param request current HTTP request
     * @param response current HTTP response
     * @param handler the executed handler, or {@code null} if none chosen at the
     * time of the exception (for example, if multipart resolution failed)
     * @param ex the exception that got thrown during handler execution
     * @return a corresponding {@code ModelAndView} to forward to,
     * or {@code null} for default processing in the resolution chain
     */
    @Override
    public ModelAndView resolveException(HttpServletRequest request,
                                         HttpServletResponse response,
                                         Object handler,
                                         Exception ex) {
        ex.printStackTrace();
        try {
            response.addHeader("Content-Type", "application/json; charset=UTF-8");
            JSONObject json = new JSONObject();
            json.put("code", 2);
            json.put("message", "服务器异常");
            Writer writer = new BufferedWriter(new OutputStreamWriter(response.getOutputStream()));
            writer.append(json.toJSONString()).flush();
            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
