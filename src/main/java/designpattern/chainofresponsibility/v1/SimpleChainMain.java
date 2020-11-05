package designpattern.chainofresponsibility.v1;

import java.util.ArrayList;
import java.util.List;

/**
 * 简单的责任链模式
 *
 * @author wangdongxing
 * @since 2020/10/12 4:48 下午
 */
public class SimpleChainMain {
    public static void main(String[] args) {
        String text = "<我是html>和我日敏感词";
        Msg msg = new Msg(text);
        ChainFilter chainFilter = new ChainFilter();
        chainFilter.addFilter(new HtmlFilter());
        chainFilter.addFilter(new SensitiveWordFilter());
        chainFilter.doFilter(msg);
        System.out.println(msg.text);
    }
}

class Msg {
    String text;
    
    Msg(String text) {
        this.text = text;
    }
}

interface Filter {
    boolean doFilter(Msg msg);
}

class HtmlFilter implements Filter {
    
    @Override
    public boolean doFilter(Msg msg) {
        msg.text = msg.text.replace('<', '[').replace('>', ']');
        msg.text += "-(HtmlFilter作用)";
        return true;
    }
}

class SensitiveWordFilter implements Filter {
    
    @Override
    public boolean doFilter(Msg msg) {
        msg.text = msg.text.replace('日', '*');
        msg.text += "-(SensitiveWordFilter作用)";
        return true;
    }
}

class ChainFilter implements Filter {
    List<Filter> filterList = new ArrayList<>();
    
    public void addFilter(Filter filter) {
        filterList.add(filter);
    }
    
    @Override
    public boolean doFilter(Msg msg) {
        for (Filter filter : filterList) {
            boolean result = filter.doFilter(msg);
            if (!result) {
                return false;
            }
        }
        return true;
    }
}