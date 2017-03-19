package com.qccr.livtrip.biz.test;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author xierongli
 * @version $Id:Test1.java v 0.1 2017年02月13日 9:49 xierongli
 */
public class Test1 {
    public  static AtomicInteger count = new AtomicInteger(0);

    public static void inc() {

        //这里延迟1毫秒，使得结果明显
        try {
            Thread.sleep(1);
        } catch (InterruptedException e) {
        }
        count.getAndIncrement();
    }

    public static void main(String[] args) throws InterruptedException {
//        final CountDownLatch latch = new CountDownLatch(1000);
//        //同时启动1000个线程，去进行i++计算，看看实际结果
//        for (int i = 0; i < 1000; i++) {
//            new Thread(new Runnable() {
//                @Override
//                public void run() {
//                    Test1.inc();
//                    latch.countDown();
//                }
//            }).start();
//        }
//        latch.await();
//        //这里每次运行的值都有可能不同,可能为1000
//        System.out.println("运行结果:Counter.count=" + Test1.count);

        try {
            TestLoadingCache();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public static void TestLoadingCache() throws Exception{
        LoadingCache<String,String> cahceBuilder= CacheBuilder
                .newBuilder()
                .build(new CacheLoader<String, String>(){
                    @Override
                    public String load(String key) throws Exception {
                        String strProValue="hello "+key+"!";
                        return strProValue;
                    }
         });

        System.out.println("jerry value:"+cahceBuilder.apply("jerry"));
        System.out.println("jerry value:"+cahceBuilder.get("jerry"));
        System.out.println("peida value:"+cahceBuilder.get("peida"));
        System.out.println("peida value:"+cahceBuilder.apply("peida"));
        System.out.println("lisa value:"+cahceBuilder.apply("lisa"));
        cahceBuilder.put("harry", "ssdded");
        System.out.println("harry value:"+cahceBuilder.get("harry"));
    }
}
