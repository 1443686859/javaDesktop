//给你一个整数数组 arr 和一个整数 difference，请你找出并返回 arr 中最长等差子序列的长度，该子序列中相邻元素之间的差等于 
//difference 。 
//
// 子序列 是指在不改变其余元素顺序的情况下，通过删除一些元素或不删除任何元素而从 arr 派生出来的序列。 
//
// 
//
// 示例 1： 
//
// 
//输入：arr = [1,2,3,4], difference = 1
//输出：4
//解释：最长的等差子序列是 [1,2,3,4]。 
//
// 示例 2： 
//
// 
//输入：arr = [1,3,5,7], difference = 1
//输出：1
//解释：最长的等差子序列是任意单个元素。
// 
//
// 示例 3： 
//
// 
//输入：arr = [1,5,7,8,5,3,4,2,1], difference = -2
//输出：4
//解释：最长的等差子序列是 [7,5,3,1]。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= arr.length <= 10⁵ 
// -10⁴ <= arr[i], difference <= 10⁴ 
// 
// Related Topics 数组 哈希表 动态规划 👍 164 👎 0


package leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

//Java：最长定差子序列
public class T1218_LongestArithmeticSubsequenceOfGivenDifference{
    public static void main(String[] args) {
        Solution solution = new T1218_LongestArithmeticSubsequenceOfGivenDifference().new Solution();
        // TO TEST
        System.out.println(solution.longestSubsequence(new int[]{3,4,-3,-2,-4}, -5));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int longestSubsequence(int[] arr, int difference) {
        Map<Integer, Integer> resultMap = new HashMap<>();
        int max = 1;
        for (int i : arr) {
            resultMap.put(i, resultMap.getOrDefault(i - difference, 0) + 1);
            max = Math.max(max, resultMap.get(i));
        }
        return max;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}