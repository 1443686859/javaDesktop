/**
给你一个整数数组 nums ，如果 nums 至少 包含 2 个元素，你可以执行以下操作中的 任意 一个： 

 
 选择 nums 中最前面两个元素并且删除它们。 
 选择 nums 中最后两个元素并且删除它们。 
 选择 nums 中第一个和最后一个元素并且删除它们。 
 

 一次操作的 分数 是被删除元素的和。 

 在确保 所有操作分数相同 的前提下，请你求出 最多 能进行多少次操作。 

 请你返回按照上述要求 最多 可以进行的操作次数。 

 

 示例 1： 

 
输入：nums = [3,2,1,2,3,4]
输出：3
解释：我们执行以下操作：
- 删除前两个元素，分数为 3 + 2 = 5 ，nums = [1,2,3,4] 。
- 删除第一个元素和最后一个元素，分数为 1 + 4 = 5 ，nums = [2,3] 。
- 删除第一个元素和最后一个元素，分数为 2 + 3 = 5 ，nums = [] 。
由于 nums 为空，我们无法继续进行任何操作。
 

 示例 2： 

 
输入：nums = [3,2,6,1,4]
输出：2
解释：我们执行以下操作：
- 删除前两个元素，分数为 3 + 2 = 5 ，nums = [6,1,4] 。
- 删除最后两个元素，分数为 1 + 4 = 5 ，nums = [6] 。
至多进行 2 次操作。
 

 

 提示： 

 
 2 <= nums.length <= 2000 
 1 <= nums[i] <= 1000 
 

 👍 11 👎 0

*/
package leetcode.editor.cn; //如果你的算法题是中文的，后缀就是cn，如果是英文的就是en

import java.util.*;

/**
 * @author  YourName
 * @date 2024-06-08 00:11:24
 */
public class MaximumNumberOfOperationsWithTheSameScoreIi{
    public static void main(String[] args) {
        Solution solution = new MaximumNumberOfOperationsWithTheSameScoreIi().new Solution();
        System.out.println(solution.maxOperations(new int[]{1,7,4,5}));
   }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    int[][] memo;
    public int maxOperations(int[] nums) {
        int n = nums.length;
        memo = new int[n][n];
        for (int[] m : memo) {
            Arrays.fill(m, -1);
        }
        return Math.max(Math.max(get(nums, nums[0] + nums[nums.length - 1], 1, nums.length - 2), get(nums, nums[0] + nums[1], 2, nums.length - 1)),
                get(nums, nums[nums.length - 1] + nums[nums.length -2], 0, nums.length - 3)) + 1;
    }
    public int get(int[] nums, int target, int left, int right) {
        if (left >= right) {
            return 0;
        }

        if (memo[left][right] != -1) {
            return memo[left][right];
        }
        int result = 0;
        if (nums[left] + nums[right] == target) {
            result = Math.max(result, 1 + get(nums, target, left + 1, right - 1));
        }
        if (nums[left] + nums[left + 1] == target) {
            result = Math.max(result, 1 + get(nums, target, left + 2, right));
        }
        if (nums[right] + nums[right - 1] == target) {
            result = Math.max(result, 1 + get(nums, target, left , right - 2));
        }
        memo[left][right] = result;
        return result;
    }
    public String clearDigits(String s) {
        Deque<Character> characters = new ArrayDeque<>();
        for (int i = 0; i < s.length(); i++) {
            if (Character.isDigit(s.charAt(i))) {
                characters.removeLast();
            } else {
                characters.addLast(s.charAt(i));
            }
        }
        StringBuilder result = new StringBuilder();
        while (!characters.isEmpty()) {
            result.append(characters.removeFirst());
        }
        return result.toString();
    }

    public int findWinningPlayer(int[] skills, int k) {
        int max = 0;
        for (int i = 0; i < skills.length; i++) {
            max = Math.max(max, skills[i]);
        }
        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = 0; i < skills.length; i++) {
            if (!deque.isEmpty() && skills[deque.getLast()] < skills[i]) {
                int current =  deque.removeLast();
                int ans = i - current + (current == 0 ? - 1 : 0);
                if (ans >= k) {
                    return current;
                }
            }
            if (skills[i] == max) {
                return i;
            }
            if (deque.isEmpty() || skills[deque.getLast()] < skills[i]) {
                deque.add(i);
            }
        }
        return - 1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}