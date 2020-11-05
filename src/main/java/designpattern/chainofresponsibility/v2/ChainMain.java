package designpattern.chainofresponsibility.v2;

import java.util.ArrayList;
import java.util.List;

/**
 * 模拟springMVC请求响应过滤器
 * Request经过Filter1、Filter2过滤
 * Response经过Filter2、Filter1反向过滤
 *
 * @author wangdongxing
 * @since 2020/10/12 4:48 下午
 */
public class ChainMain {
    public static void main(String[] args) {
        String requestText = "request<我是html>和我日敏感词";
        Request request = new Request(requestText);
        String responseText = "response<我是html>和我日敏感词";
        Response response = new Response(responseText);
        ChainFilter chainFilter = new ChainFilter();
        chainFilter.addFilter(new HtmlFilter());
        chainFilter.addFilter(new SensitiveWordFilter());
        chainFilter.doFilter(request, chainFilter, response);
        System.out.println(request.text);
        System.out.println(response.text);
    }
}

class Request {
    String text;
    
    Request(String text) {
        this.text = text;
    }
}

class Response {
    String text;
    
    Response(String text) {
        this.text = text;
    }
}

interface Filter {
    void doFilter(Request request, ChainFilter chainFilter, Response response);
}

class HtmlFilter implements Filter {
    
    @Override
    public void doFilter(Request request, ChainFilter chainFilter, Response response) {
        request.text = request.text.replace('<', '[').replace('>', ']');
        request.text += "-(HtmlFilter作用)";
        chainFilter.doFilter(request, chainFilter, response);
        response.text = response.text.replace('<', '[').replace('>', ']');
        response.text += "-(HtmlFilter作用)";
    }
}

class SensitiveWordFilter implements Filter {
    
    @Override
    public void doFilter(Request request, ChainFilter chainFilter, Response response) {
        request.text = request.text.replace('日', '*');
        request.text += "-(SensitiveWordFilter作用)";
        chainFilter.doFilter(request, chainFilter, response);
        response.text = response.text.replace('日', '*');
        response.text += "-(SensitiveWordFilter作用)";
    }
}

class ChainFilter implements Filter {
    int index = 0;
    
    List<Filter> filterList = new ArrayList<>();
    
    public void addFilter(Filter filter) {
        filterList.add(filter);
    }
    
    @Override
    public void doFilter(Request request, ChainFilter chainFilter, Response response) {
        if (index < filterList.size()) {
            Filter filter = chainFilter.filterList.get(index);
            index++;
            filter.doFilter(request, chainFilter, response);
        }
    }
}