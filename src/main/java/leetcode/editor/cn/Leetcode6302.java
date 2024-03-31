package leetcode.editor.cn;

import java.util.Arrays;
import java.util.PriorityQueue;

public class Leetcode6302 {
    public long maxScore(int[] nums1, int[] nums2, int k) {
        int n = nums1.length;
        int[][] count = new int[n][2];
        for (int i = 0; i < n; i++) {
            count[i][0] = nums1[i];
            count[i][1] = nums2[i];
        }
        Arrays.sort(count, (a, b) -> {
            return a[1] - b[1];
        });
        PriorityQueue<Integer> queue = new PriorityQueue<>((a, b) -> {return a - b;});
        long result = 0;
        long sum = 0;
        for (int i = n - 1; i >= 0; i--) {
            if (queue.size() < k) {
                queue.offer(count[i][0]);
                sum += count[i][0];
            }
            if (queue.size() == k) {
                int current = queue.poll();
                result = Math.max(result, count[i][1] * sum);
                sum -= current;
            }
        }
        return result;
    }
}
