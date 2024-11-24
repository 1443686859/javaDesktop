//给你一个整数数组 nums 和一个整数 k ，请你返回 nums 中 好 子数组的数目。 
//
// 一个子数组 arr 如果有 至少 k 对下标 (i, j) 满足 i < j 且 arr[i] == arr[j] ，那么称它是一个 好 子数组。 
//
// 子数组 是原数组中一段连续 非空 的元素序列。 
//
// 
//
// 示例 1： 
//
// 输入：nums = [1,1,1,1,1], k = 10
//输出：1
//解释：唯一的好子数组是这个数组本身。
// 
//
// 示例 2： 
//
// 输入：nums = [3,1,4,3,2,2,4], k = 2
//输出：4
//解释：总共有 4 个不同的好子数组：
//- [3,1,4,3,2,2] 有 2 对。
//- [3,1,4,3,2,2,4] 有 3 对。
//- [1,4,3,2,2,4] 有 2 对。
//- [4,3,2,2,4] 有 2 对。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 10⁵ 
// 1 <= nums[i], k <= 10⁹ 
// 
//
// Related Topics 数组 哈希表 滑动窗口 👍 21 👎 0

package leetcode.editor.cn; //如果你的算法题是中文的，后缀就是cn，如果是英文的就是en

import java.util.HashMap;
import java.util.Map;

/**
 * @author  YourName
 * @date 2023-01-20 23:31:52
 */
public class CountTheNumberOfGoodSubarrays{
    public static void main(String[] args) {
        Solution solution = new CountTheNumberOfGoodSubarrays().new Solution();
        System.out.println(solution.countGood(new int[]{1,1,1,1,1}, 10));
    }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public long countGood(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int count = 0;
        int lastJ = -1;
        int n = nums.length;
        long result = 0;
        for (int i = 0; i < n; i++) {
            if (count >= k) {
                result += Math.max(0, n - lastJ);
            } else {
                int j = lastJ + 1;
                while (j < n && count < k) {
                    int current = map.getOrDefault(nums[j] , 0);
                    if (current != 0) {
                        count -= (current - 1) * current / 2;
                    }
                    map.put(nums[j], current + 1);
                    count += (current) * (current + 1) / 2;
                    lastJ = Math.max(lastJ, j);
                    j++;
                }
                
                result += Math.max(0, n - j);
            }
            int current = map.get(nums[i]);
            count -= (current - 1) * current / 2;
            current--;
            if (current == 0) {
                map.remove(nums[i]);
            } else {
                map.put(nums[i], current);
            }
            count += (current) * (current - 1) / 2;
        }
        return result;

    }
}
//leetcode submit region end(Prohibit modification and deletion)

}