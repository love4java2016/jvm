package com;

import java.util.Vector;

public class TestXmx {

    public static void main(String[] args) {
/*      byte[] b = new byte[4*1024*1024];
        System.gc();
        System.out.println(Runtime.getRuntime().maxMemory()/1024.0/1024 + "M");
        System.out.println(Runtime.getRuntime().freeMemory()/1024.0/1024 + "M");
        System.out.println(Runtime.getRuntime().totalMemory()/1024.0/1024 + "M");*/
/*        byte[] b= null;
        for (int i = 0; i < 10; i++) {
            b=new byte[1*1024*1024];
        }*/
        /*Vector v = new Vector();
        for (int i = 0; i < 25; i++) {
            v.add(new byte[1*1024*1024]);
        }*/
        long[] arr = new long[0];       
        for (int i=1; i<=10000000; i*=2) {  
            arr = new long[i]; 
            System.out.println("size : " + i);  
            Runtime runtime = Runtime.getRuntime();  
            System.out.printf("maxMemory : %.2fM\n", runtime.maxMemory()*1.0/1024/1024);  
            System.out.printf("totalMemory : %.2fM\n", runtime.totalMemory()*1.0/1024/1024);  
            System.out.printf("freeMemory : %.2fM\n", runtime.freeMemory()*1.0/1024/1024);  
        } 
    }

}
