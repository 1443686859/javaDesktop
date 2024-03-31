//给你一个整数数组 nums （下标 从 0 开始 计数）以及两个整数：low 和 high ，请返回 漂亮数对 的数目。 
//
// 漂亮数对 是一个形如 (i, j) 的数对，其中 0 <= i < j < nums.length 且 low <= (nums[i] XOR nums[
//j]) <= high 。 
//
// 
//
// 示例 1： 
//
// 输入：nums = [1,4,2,7], low = 2, high = 6
//输出：6
//解释：所有漂亮数对 (i, j) 列出如下：
//    - (0, 1): nums[0] XOR nums[1] = 5 
//    - (0, 2): nums[0] XOR nums[2] = 3
//    - (0, 3): nums[0] XOR nums[3] = 6
//    - (1, 2): nums[1] XOR nums[2] = 6
//    - (1, 3): nums[1] XOR nums[3] = 3
//    - (2, 3): nums[2] XOR nums[3] = 5
// 
//
// 示例 2： 
//
// 输入：nums = [9,8,4,2,1], low = 5, high = 14
//输出：8
//解释：所有漂亮数对 (i, j) 列出如下：
//​​​​​    - (0, 2): nums[0] XOR nums[2] = 13
//    - (0, 3): nums[0] XOR nums[3] = 11
//    - (0, 4): nums[0] XOR nums[4] = 8
//    - (1, 2): nums[1] XOR nums[2] = 12
//    - (1, 3): nums[1] XOR nums[3] = 10
//    - (1, 4): nums[1] XOR nums[4] = 9
//    - (2, 3): nums[2] XOR nums[3] = 6
//    - (2, 4): nums[2] XOR nums[4] = 5 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 2 * 10⁴ 
// 1 <= nums[i] <= 2 * 10⁴ 
// 1 <= low <= high <= 2 * 10⁴ 
// 
//
// Related Topics 位运算 字典树 数组 👍 135 👎 0

package leetcode.editor.cn; //如果你的算法题是中文的，后缀就是cn，如果是英文的就是en

import java.util.HashMap;
import java.util.Map;

/**
 * @author  YourName
 * @date 2023-01-05 20:52:18
 */
public class CountPairsWithXorInARange{
    public static void main(String[] args) {
        Solution solution = new CountPairsWithXorInARange().new Solution();
   }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int countPairs(int[] nums, int low, int high) {
        Map<Integer, Integer> countMap = new HashMap<>();
        for (int i : nums) {
            countMap.put(i, countMap.getOrDefault(i, 0) + 1);
        }
        int ans = 0;
        for (++high; high > 0; high >>= 1, low >>=1) {
            Map<Integer, Integer> nxtMap = new HashMap<>();
            for (Map.Entry<Integer, Integer> entry : countMap.entrySet()) {
                int x = entry.getKey();
                int v = entry.getValue();
                ans += v * (high & 1) * (countMap.getOrDefault((high - 1) ^ x , 0)) - v * (low & 1) * (countMap.getOrDefault((low - 1) ^ x , 0));
                nxtMap.put(x >> 1, nxtMap.getOrDefault(x >> 1, 0) + v);
            }
            countMap = nxtMap;
        }
        return ans / 2;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}