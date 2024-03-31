package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Leetcode6357 {
    public static void main(String[] args) {
        Leetcode6357 leetcode6357 = new Leetcode6357();
        System.out.println(leetcode6357.minOperations(new int[]{2,9,6,3}, new int[]{10}));
    }
    public List<Long> minOperations(int[] nums, int[] queries) {
        List<Long> result = new ArrayList<>();
        int n = nums.length;
        long[] sum = new long[n + 1];
        Arrays.sort(nums);
        for (int i = 0; i < n; i++) {
            sum[i + 1] = sum[i] + nums[i];
        }
        long totalSum = sum[n];
        for (int i : queries) {
            int index = search(nums, i);
            long currentSum = (totalSum - sum[index]) - 1l * (n - index) * i + ( (index * 1l * i) - sum[index]);
            result.add(currentSum);
        }
        return result;
    }
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] >= target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return right + 1;
    }
}
