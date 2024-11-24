//给你一个整数数组 nums，返回 nums 中最长等差子序列的长度。 
//
// 回想一下，nums 的子序列是一个列表 nums[i1], nums[i2], ..., nums[ik] ，且 0 <= i1 < i2 < ... <
// ik <= nums.length - 1。并且如果 seq[i+1] - seq[i]( 0 <= i < seq.length - 1) 的值都相同，那么
//序列 seq 是等差的。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [3,6,9,12]
//输出：4
//解释： 
//整个数组是公差为 3 的等差数列。
// 
//
// 示例 2： 
//
// 
//输入：nums = [9,4,7,2,10]
//输出：3
//解释：
//最长的等差子序列是 [4,7,10]。
// 
//
// 示例 3： 
//
// 
//输入：nums = [20,1,15,3,10,5,8]
//输出：4
//解释：
//最长的等差子序列是 [20,15,10,5]。
// 
//
// 
//
// 提示： 
//
// 
// 2 <= nums.length <= 1000 
// 0 <= nums[i] <= 500 
// 
//
// Related Topics 数组 哈希表 二分查找 动态规划 👍 231 👎 0

package leetcode.editor.cn; //如果你的算法题是中文的，后缀就是cn，如果是英文的就是en

import java.util.HashMap;
import java.util.Map;

/**
 * @author  YourName
 * @date 2023-04-22 00:47:52
 */
public class LongestArithmeticSubsequence{
    public static void main(String[] args) {
        Solution solution = new LongestArithmeticSubsequence().new Solution();
        System.out.println(solution.longestArithSeqLength(new int[]{22,8,57,41,36,46,42,28,42,14,9,43,27,51,0,0,38,50,31,60,29,31,20,23,37,53,27,1,47,42,28,31,10,35,39,12,15,6,35,31,45,21,30,19,5,5,4,18,38,51,10,7,20,38,28,53,15,55,60,56,43,48,34,53,54,55,14,9,56,52}));
   }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int longestArithSeqLength(int[] nums) {
        Map<Integer, Integer>[] maps = new HashMap[nums.length];
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            maps[i] = new HashMap<>();
        }
        int max = 1;
        for (int i = 0; i < n; i++) {
            for (int j = i - 1; j >= 0; j--) {
                int count = nums[i] - nums[j];
                if (!maps[i].containsKey(count)) {
                    int defaultResult = maps[j].getOrDefault(count, 1);
                    maps[i].put(count, defaultResult + 1);
                    max = Math.max(max, maps[i].get(count));
                }

            }
        }
        return max;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}