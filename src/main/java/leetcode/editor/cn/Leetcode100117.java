package leetcode.editor.cn;

public class Leetcode100117 {
    public int minOperations(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int changeCount = 0;
        int count = 0;
        for (int i = 0; i < n - 1; i++) {
            if (Math.max(nums1[i], nums2[i]) <= Math.min(nums1[n - 1], nums2[n - 1])) {
                continue;
            }
            if (Math.min(nums1[i], nums2[i]) > Math.min(nums1[n - 1], nums2[n - 1]) || Math.min(nums1[i], nums2[i]) > Math.max(nums1[n - 1], nums2[n - 1])) {
                return -1;
            }
            if (nums1[i] <= nums1[n - 1] && nums1[i] > nums2[n - 1] || nums2[i] <= nums2[n - 1] && nums2[i] > nums1[n -1]) {
                changeCount++;
            }
            if (nums1[i] > nums1[n - 1] || nums2[i] > nums2[n - 1]) {
                count++;
            }
        }
        return Math.min(count, 1 + changeCount);
    }
}
