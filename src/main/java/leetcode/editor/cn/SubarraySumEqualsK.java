//给你一个整数数组 nums 和一个整数 k ，请你统计并返回 该数组中和为 k 的子数组的个数 。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,1,1], k = 2
//输出：2
// 
//
// 示例 2： 
//
// 
//输入：nums = [1,2,3], k = 3
//输出：2
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 2 * 10⁴ 
// -1000 <= nums[i] <= 1000 
// -10⁷ <= k <= 10⁷ 
// 
// Related Topics 数组 哈希表 前缀和 👍 1462 👎 0

package leetcode.editor.cn; //如果你的算法题是中文的，后缀就是cn，如果是英文的就是en

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author  YourName
 * @date 2022-05-05 21:21:22
 */
public class SubarraySumEqualsK{
    public static void main(String[] args) {
        Solution solution = new SubarraySumEqualsK().new Solution();
   }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int subarraySum(int[] nums, int k) {
        int n = nums.length;
        Map<Integer, Integer> result = new HashMap<>();
        int sum = 0;
        int resultCount = 0;
        result.put(0, 1);
        for (int i = 0; i < n; i++) {
            sum += nums[i];
            if (result.containsKey(sum - k)) {
                resultCount += result.get(sum - k);
            }
            int defaultCount = result.getOrDefault(sum, 0);
            result.put(sum, defaultCount + 1);
        }
        return resultCount;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}