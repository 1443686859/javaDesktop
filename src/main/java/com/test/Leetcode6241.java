package com.test;

public class Leetcode6241 {
    public int unequalTriplets(int[] nums) {
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                for (int z = j + 1; z < nums.length; z++) {
                    if (nums[i]!= nums[j] && nums[i] != nums[z] && nums[z] != nums[j]) {
                        result++;
                    }
                }
            }
        }
        return result;
    }
}
