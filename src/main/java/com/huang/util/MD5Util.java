package com.huang.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * 对字符串进行MD5加密
 * @author huangkuanyi huang_kuan_yi@163.com
 * @date 2019/10/14 22:35
 */
public class MD5Util {

    public  static String getInstance(String target) throws NoSuchAlgorithmException {
        MessageDigest messageDigest=MessageDigest.getInstance("MD5");
        byte[] bytes=target.getBytes();
        String str;
        StringBuilder stringBuilder=new StringBuilder();
        byte[] digest=messageDigest.digest(bytes);
        for (int i = 0; i <digest.length ; i++) {
            int j=digest[i];
            j=j&0x000000ff;
           str=Integer.toHexString(j);
           if(str.length()==1){
               str="0"+str;
           }
           stringBuilder.append(str);

        }
        return stringBuilder.toString();
    }
    public  static String getInstance(File file) throws NoSuchAlgorithmException, IOException {
        MessageDigest messageDigest=MessageDigest.getInstance("MD5");
        FileInputStream fileInputStream=new FileInputStream(file);
        byte[] bytes=new byte[1024*5];
        int len=-1;
        while((len=fileInputStream.read(bytes))!=-1){
            messageDigest.update(bytes,0,len);
        }
        String str;
        StringBuilder stringBuilder=new StringBuilder();
        byte[] digest=messageDigest.digest();
        for (int i = 0; i <digest.length ; i++) {
            int j=digest[i];
            j=j&0x000000ff;
            //保留后8位；
            str=Integer.toHexString(j);
            if(str.length()==1){
                //每个字节占用8位
                str="0"+str;
            }
            stringBuilder.append(str);

        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) throws Exception {
        Object mine = "Hi there".toCharArray();
        long address = AddressUtil.getAddressOf(mine);
        System.out.println("Addess: " + address);

        // Verify address works - should see the characters in the array in the output
        AddressUtil.printBytes(address, 27);
    }
}
