//给定一个二进制数组 nums , 找到含有相同数量的 0 和 1 的最长连续子数组，并返回该子数组的长度。 
//
// 
//
// 示例 1: 
//
// 
//输入: nums = [0,1]
//输出: 2
//说明: [0, 1] 是具有相同数量 0 和 1 的最长连续子数组。 
//
// 示例 2: 
//
// 
//输入: nums = [0,1,0]
//输出: 2
//说明: [0, 1] (或 [1, 0]) 是具有相同数量0和1的最长连续子数组。 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 10⁵ 
// nums[i] 不是 0 就是 1 
// 
// Related Topics 数组 哈希表 前缀和 👍 554 👎 0

package leetcode.editor.cn; //如果你的算法题是中文的，后缀就是cn，如果是英文的就是en

import java.util.HashMap;
import java.util.Map;

/**
 * @author  YourName
 * @date 2022-05-08 13:49:51
 */
public class ContiguousArray{
    public static void main(String[] args) {
        Solution solution = new ContiguousArray().new Solution();
   }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int findMaxLength(int[] nums) {
        Map<Integer, Integer> countMap = new HashMap<>();
        int currentSum = 0;
        int result = 0;
        countMap.put(0, -1);
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                currentSum += -1;
            } else {
                currentSum += 1;
            }
            if (countMap.containsKey(currentSum)) {
                int preIndex = countMap.get(currentSum);
                result = Math.max(result, i - preIndex);
            } else {
                countMap.put(currentSum, i);
            }
        }
        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}