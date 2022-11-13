package com.test;

import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        Test test = new Test();
        System.out.println(test.getLength(new int[]{9,128,22,234,100,150, 10, 18,60, 120}));
        System.out.println(test.getLength(new int[]{9,18,60,120}));
        System.out.println(test.getLength(new int[]{9,15,7,120}));
    }
    public int getLength(int[] nums) {
        if (nums.length <= 2) {
            return 0;
        }
        Arrays.sort(nums);
        int length = nums.length;
        for (int i = length - 1; i >= 2; i--) {
            // 数组 nums 是按从小到大排， a >= b >= c;
            int a = nums[i];
            int b = nums[i - 1];
            int c = nums[i - 2];
            if (b + c > a) {
                // 如果出现符合情况的数据就是最大的,
                // 如果不是连续出现，则有 c' < c , 与 a, b 能组成三角形，必然满足 c' + b > a, 又因c' < c 则 不是最大的
                return a + b + c;
            }
        }
        return 0;
    }
}
