package leetcode.editor.cn;

import java.util.Arrays;

public class Leetcode6258 {
    public static void main(String[] args) {
        Leetcode6258 leetcode6258 = new Leetcode6258();
        System.out.println(leetcode6258.longestSquareStreak(new int[]{4,3,6,16,8,2}));
    }
    public int longestSquareStreak(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int[] result = new int[n];
        Arrays.fill(result, 1);
        int max = 1;
        int countOne = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] == 1) {
                countOne++;
            }
        }
        int start = 1;
        if (countOne != 0) {
            max = countOne;
            start = countOne;
        }
        for (int i = start; i < n; i ++) {
            if (nums[i] == nums[i - 1]) {
                result[i] = result[i - 1];
            }
            int current = (int) Math.sqrt(nums[i]);
            if (current * current != nums[i]) {
                continue;
            }
            int right = i - 1;
            int left = 0;
            int currentResult = -1;
            while (left <= right) {
                int mid = (left + right) / 2;
                if (current == nums[mid]) {
                    currentResult = mid;
                    break;
                } else if (current > nums[mid]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
            if (currentResult != -1) {
                result[i] = result[currentResult] + 1;
                max = Math.max(max, result[i]);
            }
        }

        return max != 1 ? max : - 1;
    }
}
