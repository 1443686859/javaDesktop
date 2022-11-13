//给你一个长度为 n 的整数数组 nums ，其中 nums 的所有整数都在范围 [1, n] 内，且每个整数出现 一次 或 两次 。请你找出所有出现 两次 
//的整数，并以数组形式返回。 
//
// 你必须设计并实现一个时间复杂度为 O(n) 且仅使用常量额外空间的算法解决此问题。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [4,3,2,7,8,2,3,1]
//输出：[2,3]
// 
//
// 示例 2： 
//
// 
//输入：nums = [1,1,2]
//输出：[1]
// 
//
// 示例 3： 
//
// 
//输入：nums = [1]
//输出：[]
// 
//
// 
//
// 提示： 
//
// 
// n == nums.length 
// 1 <= n <= 10⁵ 
// 1 <= nums[i] <= n 
// nums 中的每个元素出现 一次 或 两次 
// 
// Related Topics 数组 哈希表 👍 550 👎 0

package leetcode.editor.cn; //如果你的算法题是中文的，后缀就是cn，如果是英文的就是en

import java.util.ArrayList;
import java.util.List;

/**
 * @author  YourName
 * @date 2022-05-08 13:01:37
 */
public class FindAllDuplicatesInAnArray{
    public static void main(String[] args) {
        Solution solution = new FindAllDuplicatesInAnArray().new Solution();
   }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        int n = nums.length;
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            // 作为下标标识是否有处理过，在之后如果遇到处理过后的数表示出现过两次
            int current = Math.abs(nums[i]);
            // 由于 数组中的值范围是 1 到n
            // 用小于零来表示处理过
            if (nums[current - 1] > 0) {
                // 进行处理
                nums[current - 1] *= -1;
            } else {
                result.add(current);
            }

        }
        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}