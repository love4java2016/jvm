package com;

import java.util.HashMap;

public class TestStopTheWorld {
    public static class PrintThread extends Thread {
        public static final long starttime = System.currentTimeMillis();

        @Override
        public void run() {

            try {
                while (true) {
                    long t = System.currentTimeMillis() - starttime;
                    System.out.println("time:" + t);
                    Thread.sleep(100);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

    public static class MyThread extends Thread {
        HashMap<Long, byte[]> map = new HashMap<Long, byte[]>();

        @Override
        public void run() {
            try {
                while (true) {
                    //System.out.println(map.size()*512/1024/1024);
                    if ((map.size()*512/1024/1024) >= 440) {//440这个数值在不同jdk下不同，需要自己调整
                        System.out.println("=====准备清理=====：" + map.size());
                        map.clear();
                    }
                    for (int i = 0; i < 1024; i++) {
                        map.put(System.nanoTime(), new byte[512]);
                    }
                    Thread.sleep(1);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        //需要设置VM arguments如下：
        //-Xmx512m -Xms512m -XX:+UseSerialGC -Xloggc:gc.log -XX:+PrintGCDetails -Xmn1m -XX:PretenureSizeThreshold=50 -XX:MaxTenuringThreshold=1
        PrintThread t = new PrintThread();
        MyThread t1 = new MyThread();
        t.start();
        t1.start();
        t.join();
        t1.join();
    }

}
