package com.wdx.jvm.outofmemoryerror;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wangdongxing
 * @since 2019-07-04 11:09
 */
public class JVMHeapOOM {

    static class OOMObject {
    }

    public static void main(String[] args) {

        List<OOMObject> list = new ArrayList<>();

        while (true) {
            list.add(new OOMObject());
        }

        // Runtime runtime = Runtime.getRuntime();
        // long maxMemory = runtime.maxMemory();
        // long totalMemory = runtime.totalMemory();
        // long freeMemory = runtime.freeMemory();
        // System.out.println("最大内存 = " + maxMemory / 1024 / 1024);
        // System.out.println("已分配内存 = " + totalMemory / 1024 / 1024);
        // System.out.println("已分配内存中的剩余空间 = " + freeMemory / 1024 / 1024);
    }

}
