package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class LeetCode5938 {
    public static void main(String[] args) {
        LeetCode5938 solution = new LeetCode5938();
        System.out.println(solution.targetIndices(new int[]{1,2,5,2,3}, 3));
    }
    public List<Integer> targetIndices(int[] nums, int target) {
        int smallCount = 0;
        int count = 0;
        for (int num : nums) {
            if (num < target) {
                smallCount++;
            } else if (num == target) {
                count ++;
            }
        }
        if (smallCount == nums.length || count == 0) {
            return new ArrayList<>();
        }
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            result.add(smallCount + i);
        }
        return result;
    }
}
