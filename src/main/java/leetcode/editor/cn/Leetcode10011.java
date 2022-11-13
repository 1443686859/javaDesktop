package leetcode.editor.cn;

import java.util.Arrays;

public class Leetcode10011 {
    class BookMyShow {
        int[] rest;
        int[] sum;
        public BookMyShow(int n, int m) {
            rest = new int[n];
            Arrays.fill(rest, m);
            sum = new int[n];
            sum[0] = m;
            for (int i = 1; i < n; i++) {
                sum[i] = sum[i - 1] + m;
            }
        }

        public int[] gather(int k, int maxRow) {
            int left = 0;
            int right = maxRow;
            int result = -1;
            while (left <= right) {
                int mid = (left + right) / 2;
                if (rest[mid] >= k) {
                    result = mid;
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }

            if (result != -1) {
                return new int[0];
            } else {
                int[] ans = new int[2];
                ans[0] = result;
                ans[1] = rest[result] - k;
                rest[result] -= k;
                return ans;
            }
        }

        public boolean scatter(int k, int maxRow) {
            return false;
        }
    }
}
