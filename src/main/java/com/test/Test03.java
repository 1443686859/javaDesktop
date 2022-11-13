package com.test;

public class Test03 {
    public int getMax(int n) {
        // 设置初值
        int first = n & 1;
        // 处理跳过第一个
        int temp = n >> 1;
        // 初始结果
        int count = 1;
        int result = 0;
        while (temp != 0) {
            if (first != (temp & 1)) {
                // 失联处判断重新设置初值
                result = Math.max(result, count);
                first = temp & 1;
                count = 1;
            } else {
                count++;
            }
            temp >>= 1;
        }
        return Math.max(result, count);
    }

    public static void main(String[] args) {
        Test03 test03 = new Test03();
        System.out.println(test03.getMax(3));
        System.out.println(test03.getMax(195));
        System.out.println(test03.getMax(170));
        System.out.println(test03.getMax(99));

    }
}
