package leetcode.editor.cn;

public class Leetcode6275 {
    public long minOperations(int[] nums1, int[] nums2, int k) {
        long sum1 = 0;
        long sum2 = 0;
        int n = nums1.length;
        for (int i = 0; i < n; i++) {
            sum1 += nums1[i];
            sum2 += nums2[i];
        }
        if (sum2 != sum1 || k == 0) {
            return - 1;
        }
        long count = 0;
        long ans = 0;
        for (int i = 0; i < n; i++) {
            if (nums1[i] != nums2[i]) {
                int cost = nums1[i] - nums2[i];
                if (Math.abs(cost) % k != 0) {
                    return - 1;
                }
                long currentCount = Math.abs(cost) / k;
                ans += currentCount;
                if (cost < 0) {
                    count -= currentCount;
                } else {
                    count += currentCount;
                }
            }
        }
        if (count != 0) {
            return -1;
        }
        return ans / 2;
    }
}
