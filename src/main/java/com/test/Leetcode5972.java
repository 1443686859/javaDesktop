package com.test;

public class Leetcode5972 {
    public static void main(String[] args) {
        Leetcode5972 solution = new Leetcode5972();
        System.out.println(solution.numberOfArrays(new int[]{3,-4,5,1,-2}, -4, 5));
    }

    public int numberOfArrays(int[] differences, int lower, int upper) {
        int startMin = lower;
        int startMax = upper;
        if (differences[0] > 0) {
            startMax = upper - differences[0];
        } else {
            startMin = lower - differences[0];
        }
        int n = differences.length;
        int result = 0;
        int[] sums = new int[n];
        sums[0] = differences[0];
        int max = sums[0];
        int min = sums[0];
        for (int i = 1; i < n; i++) {
            sums[i] = sums[i - 1] + differences[i];
            max = Math.max(sums[i], max);
            min = Math.min(min, sums[i]);
        }
        for (int i = startMin; i <= startMax; i++) {
            if (i + max > upper || i + max < lower) {
                continue;
            }
            if (i + min > upper || i + min < lower) {
                continue;
            }
            result++;
        }
        return result;
    }
}
