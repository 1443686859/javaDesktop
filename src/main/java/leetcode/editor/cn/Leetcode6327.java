package leetcode.editor.cn;

import java.util.Arrays;

public class Leetcode6327 {
    public int minNumber(int[] nums1, int[] nums2) {
        int[] count = new int[10];
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        for (int i : nums1) {
            count[i]++;
        }
        for (int i : nums2) {
            count[i]++;
        }
        int index = 1;
        for (; index < count.length; index++) {
            if (count[index] == 2) {
                return index;
            }
        }
        return Math.min(nums1[0], nums2[0]) * 10 + Math.max(nums1[0], nums2[0]);
    }
}
