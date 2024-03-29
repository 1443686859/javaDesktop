//给你一个下标从 0 开始的正整数数组 nums 和一个正整数 k 。 
//
// 如果满足下述条件，则数对 (num1, num2) 是 优质数对 ： 
//
// 
// num1 和 num2 都 在数组 nums 中存在。 
// num1 OR num2 和 num1 AND num2 的二进制表示中值为 1 的位数之和大于等于 k ，其中 OR 是按位 或 操作，而 AND 是按
//位 与 操作。 
// 
//
// 返回 不同 优质数对的数目。 
//
// 如果 a != c 或者 b != d ，则认为 (a, b) 和 (c, d) 是不同的两个数对。例如，(1, 2) 和 (2, 1) 不同。 
//
// 注意：如果 num1 在数组中至少出现 一次 ，则满足 num1 == num2 的数对 (num1, num2) 也可以是优质数对。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,2,3,1], k = 3
//输出：5
//解释：有如下几个优质数对：
//- (3, 3)：(3 AND 3) 和 (3 OR 3) 的二进制表示都等于 (11) 。值为 1 的位数和等于 2 + 2 = 4 ，大于等于 k = 
//3 。
//- (2, 3) 和 (3, 2)： (2 AND 3) 的二进制表示等于 (10) ，(2 OR 3) 的二进制表示等于 (11) 。值为 1 的位数和等
//于 1 + 2 = 3 。
//- (1, 3) 和 (3, 1)： (1 AND 3) 的二进制表示等于 (01) ，(1 OR 3) 的二进制表示等于 (11) 。值为 1 的位数和等
//于 1 + 2 = 3 。
//所以优质数对的数目是 5 。 
//
// 示例 2： 
//
// 
//输入：nums = [5,1,1], k = 10
//输出：0
//解释：该数组中不存在优质数对。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 10⁵ 
// 1 <= nums[i] <= 10⁹ 
// 1 <= k <= 60 
// 
//
// 👍 18 👎 0

package leetcode.editor.cn; //如果你的算法题是中文的，后缀就是cn，如果是英文的就是en

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author  YourName
 * @date 2022-07-25 20:47:34
 */
public class NumberOfExcellentPairs{
    public static void main(String[] args) {
        Solution solution = new NumberOfExcellentPairs().new Solution();
   }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public long countExcellentPairs(int[] nums, int k) {
        Set<Integer> set = new HashSet<>();
        int[] count = new int[32];
        for (int i = 0; i < nums.length; i++) {
            if (set.add(nums[i])) {
                count[getCount(nums[i])]++;
            }

        }
        long result = 0;
        long total = 0;
        for (int i = k; i < 32; i++) {
            total += count[i];
        }
        for (int i = 0; i < 32; i++) {
            result += 1l * count[i] * total;
            int index = k - i - 1;
            if (index >= 0 && index < 32) {
                total += count[index];
            }
        }
        return result;

    }
    public int getCount(int current) {
        int count = 0;
        while (current != 0) {
            if ((current & 1) != 0) {
                count++;
            }
            current >>= 1;
        }
        return count;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}