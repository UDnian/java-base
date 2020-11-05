package com.wdx.thread.msb.juc.executor;

import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;
import java.util.concurrent.RecursiveTask;

/**
 * 大任务切割为多个小任务，之后汇总结果
 *
 * @author wangdongxing
 * @since 2020/9/5 11:21 上午
 */
public class T05ForkJoinPool {
    
    /**
     * 10W个数字的数组
     */
    private static int[] NUMS = new int[10000000];
    
    /**
     * NUMS数组分片计算，每片MAX_NUM个数
     */
    private static int MAX_NUM = 1000000;
    
    private static Random RANDOM = new Random();
    
    /**
     * 初始化数组内部值
     */
    static {
        for (int i = 0; i < NUMS.length; i++) {
            NUMS[i] = RANDOM.nextInt(100);
        }
    }
    
    /**
     * 递归相加任务(不带返回值的继承 RecursiveAction)
     */
    static class AddTask extends RecursiveAction {
        private static final long serialVersionUID = 955353288471572209L;
        
        private int start;
        
        private int end;
        
        AddTask(int start, int end) {
            this.start = start;
            this.end = end;
        }
        
        @Override
        protected void compute() {
            if (end - start <= MAX_NUM) {
                int sum = 0;
                for (int i = start; i < end; i++) {
                    sum += NUMS[i];
                }
                System.out.println("索引From " + start + " to " + end + " 和为 " + sum);
            } else {
                // 分片内数的数量大于MAX_NUM，就再继续递归分片
                int middle = start + (end - start) / 2;
                AddTask subAddTask1 = new AddTask(start, middle);
                AddTask subAddTask2 = new AddTask(middle, end);
                subAddTask1.fork();
                subAddTask2.fork();
            }
        }
    }
    
    /**
     * 递归相加任务(带返回值的继承 RecursiveTask)
     */
    static class AddReturnTask extends RecursiveTask<Integer> {
        private static final long serialVersionUID = 955353288471572209L;
        
        private int start;
        
        private int end;
        
        AddReturnTask(int start, int end) {
            this.start = start;
            this.end = end;
        }
        
        @Override
        protected Integer compute() {
            if (end - start <= MAX_NUM) {
                int sum = 0;
                for (int i = start; i < end; i++) {
                    sum += NUMS[i];
                }
                // System.out.println("索引From " + start + " to " + end + " 和为 " + sum);
                return sum;
            } else {
                // 分片内数的数量大于MAX_NUM，就再继续递归分片
                int middle = start + (end - start) / 2;
                AddReturnTask subAddTask1 = new AddReturnTask(start, middle);
                AddReturnTask subAddTask2 = new AddReturnTask(middle, end);
                subAddTask1.fork();
                subAddTask2.fork();
                
                return subAddTask1.join() + subAddTask2.join();
            }
        }
    }
    
    public static void main(String[] args) throws InterruptedException {
        long start = System.currentTimeMillis();
        int sum = Arrays.stream(NUMS).sum();
        long end = System.currentTimeMillis();
        System.out.println(sum);
        System.out.println("Arrays.stream 耗时: " + (end - start));
        
        int sumFor = 0;
        start = System.currentTimeMillis();
        for (int i = 0; i < NUMS.length; i++) {
            sumFor += NUMS[i];
        }
        Arrays.stream(NUMS);
        end = System.currentTimeMillis();
        System.out.println("for 耗时: " + (end - start) + " sumFor: " + sumFor);
        
        start = System.currentTimeMillis();
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        // AddTask addTask = new AddTask(0, NUMS.length);
        // forkJoinPool.execute(addTask);
        AddReturnTask addReturnTask = new AddReturnTask(0, NUMS.length);
        forkJoinPool.execute(addReturnTask);
        Integer taskSum = addReturnTask.join();
        end = System.currentTimeMillis();
        System.out.println("ForkJoinPool 耗时: " + (end - start) + " taskSum: " + taskSum);
        forkJoinPool.shutdown();
        
        // TimeUnit.SECONDS.sleep(3);
    }
}
