package leetcode.editor.cn;

public class Leetcode6027 {
    public int countHillValley(int[] nums) {
        int size = 0;
        int n = nums.length;
        for (int i = 1; i < n -1; i++) {
            int leftSize = 0;
            int start = i - 1;
            while (start >= 0 && nums[start] == nums[i]) {
                start --;
                leftSize++;
            }
            if (start < 0) {
                continue;
            }
            int end = i + 1;
            while (end < n && nums[end] == nums[i]) {
                end++;
            }
            if (end >= n) {
                continue;
            }
            if (leftSize == 0 && ((nums[end] < nums[i] && nums[start] < nums[i]) || (nums[end] > nums[i] && nums[start] > nums[i]))) {
                size++;
            }
        }
        return size;
    }
}
