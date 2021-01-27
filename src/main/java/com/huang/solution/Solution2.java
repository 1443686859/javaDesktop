package com.huang.solution;

/**
 * @author huangkuanyi huang_kuan_yi@163.com
 * @date 2019/10/15 20:18
 */
public class Solution2 {
    public static void main(String[] args) {
        String str="tHe      qUIcK     BrOwn fox JUmPs    oVEr tHE     laZy  DOG";
        String[] strs=str.split("\\s+");
        System.out.println(strs.length);
        StringBuilder stringBuilder=new StringBuilder();
        for (int i = 0; i <strs.length ; i++) {
            if(strs[i]!=" ")
            stringBuilder.append(Upper(strs[i])+" ");
        }
        System.out.println(stringBuilder.toString());
    }
    public static String Upper(String str){
        str=str.toLowerCase();
        String s=str.substring(0,1);
        s=s.toUpperCase();
        System.out.println(s);
        str=str.substring(1);
        StringBuilder stringBuilder=new StringBuilder();
        stringBuilder.append(s);
        stringBuilder.append(str);
        return stringBuilder.toString();
    }
}
