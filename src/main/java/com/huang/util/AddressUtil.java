package com.huang.util;

import sun.misc.Unsafe;

import java.lang.reflect.Field;

/**
 * @author huangkuanyi huang_kuan_yi@163.com
 * @date 2019/10/15 8:05
 */
public class AddressUtil {
    private static Unsafe unsafe;
    static{
        try {
            Field field=Unsafe.class.getDeclaredField("theUnsafe");
            field.setAccessible(true);
            unsafe=(Unsafe)field.get(null);
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }
    public static Long getAddressOf(Object o){
        Object[] array=new Object[]{0};
        long addressOfArray=unsafe.arrayBaseOffset(Object[].class);
        int addressSize=unsafe.addressSize();
        long objectAddress;
        switch (addressSize){
            case 4:
                objectAddress=unsafe.getInt(array,addressOfArray);
                break;
            case 8:
                objectAddress=unsafe.getLong(array,addressOfArray);
                break;
            default:
                throw new Error("unsupported address size: " + addressSize);
        }
        return objectAddress;
    }
    public static void printBytes(long objectAddress, int num)
    {
        for (long i = 0; i < num; i++)
        {
            int cur = unsafe.getByte(objectAddress + i);
            System.out.print((char)cur);
        }
        System.out.println();
    }

}
