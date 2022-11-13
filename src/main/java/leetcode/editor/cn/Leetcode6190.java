package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class Leetcode6190 {
    public static void main(String[] args) {
        Leetcode6190 leetcode6190 = new Leetcode6190();
        System.out.println(leetcode6190.goodIndices(new int[]{878724,201541,179099,98437,35765,327555,475851,598885,849470,943442}, 4));
    }
    public List<Integer> goodIndices(int[] nums, int k) {
        int n = nums.length;
        int[] left = new int[n];
        int[] right = new int[n];
        for (int i = 1; i < n; i++) {
            if (nums[i] <= nums[i - 1]) {
                left[i] = left[i - 1] + 1;
            }
            int index = n - 1 - i;
            if (nums[index + 1] >= nums[index]) {
                right[index] = right[index + 1] + 1;
            }
        }
        List<Integer> result = new ArrayList<>();
        for (int i = k; i < n - 1; i++) {
            if (left[i - 1] >= k - 1 && right[i + 1] >= k - 1) {
                result.add(i);
            }
        }
        return result;
    }
}
