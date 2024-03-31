package leetcode.editor.cn;

import java.util.Arrays;

public class Leetcode6313 {
    int mod = (int)1e9 + 7;
    public int countWays(int[][] ranges) {

        Arrays.sort(ranges, (a, b) -> {
           if (a[0] == b[0]) {
               return a[1] - b[0];
           } else {
               return a[0] - b[0];
           }
        });
        int n = ranges.length;
        int[] count = new int[n];
        for (int i = 0; i < n; i++) {
            count[i] = i;
        }
        int result = 0;
        int pre = 0;
        int maxRight = ranges[0][1];
        for (int i = 1; i < n; i++) {
            if (ranges[i][0] <= maxRight) {
                count[i] = pre;
                maxRight = Math.max(maxRight, ranges[i][1]);
            } else {
                pre = count[i];
                maxRight = ranges[i][1];
            }
        }
        pre = -1;
        for (int i = 0; i < n; i++) {
            if (count[i] != pre) {
                result++;
                pre = count[i];
            }
        }
        return fastPow(2, result);
    }
    public int fastPow(int base, long n) {
        long temp = base;
        long result = 1;
        while (n != 0) {
            if ((n & 1) == 1) {
                result = (result * temp) % mod;
            }
            temp = (temp % mod * temp % mod) % mod;
            n >>= 1;
        }
        return (int)result;
    }
}
