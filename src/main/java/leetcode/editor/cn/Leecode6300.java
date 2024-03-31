package leetcode.editor.cn;

public class Leecode6300 {
    public int getCommon(int[] nums1, int[] nums2) {
        for (int i : nums1) {
            if (check(nums2, i)) {
                return i;
            }
        }
        return - 1;
    }
    public boolean check(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target) {
                return true;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return false;
    }
}
