package com;

public class IntegerTest {
    public static String fillZeros(String str){
        int count=(32-str.length());
        String re="";
        for(int i=0;i<count;i++){
            re+="0";
        }
        return re+str;
    }
    public static void main(String[] args) {
        int ivalue=12;
//        System.out.println(Integer.toBinaryString(ivalue));
//        System.out.println(Integer.lowestOneBit(ivalue));
//        System.out.println(Integer.highestOneBit(ivalue));
//        System.out.println(Integer.toBinaryString(Integer.reverse(ivalue)));
//        System.out.println(Integer.numberOfLeadingZeros(ivalue));
//        System.out.println(Integer.numberOfTrailingZeros(ivalue));
//        System.out.println(Integer.toBinaryString(Integer.rotateLeft(ivalue, 1)));
//        System.out.println(Integer.toBinaryString(Integer.rotateRight(ivalue, 1)));
        int a= -6;
        for (int i = 0; i < 32; i++) {
            int t = (a & 0x80000000 >>> i) >>>(31-i);
            System.out.println(t);
        }
    }
}