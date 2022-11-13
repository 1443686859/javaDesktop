package com.test;

import java.util.Arrays;

public class Leetcode5971 {
    public int minimumCost(int[] cost) {
        Arrays.sort(cost);
        int sum = 0;
        int n = cost.length;
        for (int i = n - 1; i >= 0; i--) {
            if (i - 1 >= 0) {
                sum += cost[i] + cost[i - 1];
                i -= 2;
            } else {
                sum += cost[i];
            }
        }
        return sum;
    }
}
