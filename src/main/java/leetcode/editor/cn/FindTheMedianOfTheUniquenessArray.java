/**
给你一个整数数组 nums 。数组 nums 的 唯一性数组 是一个按元素从小到大排序的数组，包含了 nums 的所有非空 子数组 中不同元素的个数。 

 换句话说，这是由所有 0 <= i <= j < nums.length 的 distinct(nums[i..j]) 组成的递增数组。 

 其中，distinct(nums[i..j]) 表示从下标 i 到下标 j 的子数组中不同元素的数量。 

 返回 nums 唯一性数组 的 中位数 。 

 注意，数组的 中位数 定义为有序数组的中间元素。如果有两个中间元素，则取值较小的那个。
 

 

 示例 1： 

 
 输入：nums = [1,2,3] 
 

 输出：1 

 解释： 

 nums 的唯一性数组为 [distinct(nums[0..0]), distinct(nums[1..1]), distinct(nums[2..2]),
 distinct(nums[0..1]), distinct(nums[1..2]), distinct(nums[0..2])]，即 [1, 1, 1, 2
, 2, 3] 。唯一性数组的中位数为 1 ，因此答案是 1 。 

 示例 2： 

 
 输入：nums = [3,4,3,4,5] 
 

 输出：2 

 解释： 

 nums 的唯一性数组为 [1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 3, 3, 3] 。唯一性数组的中位数为 2 ，因此答案是
 2 。 

 示例 3： 

 
 输入：nums = [4,3,5,4] 
 

 输出：2 

 解释： 

 nums 的唯一性数组为 [1, 1, 1, 1, 2, 2, 2, 3, 3, 3] 。唯一性数组的中位数为 2 ，因此答案是 2 。 

 

 提示： 

 
 1 <= nums.length <= 10⁵ 
 1 <= nums[i] <= 10⁵ 
 

 👍 35 👎 0

*/
package leetcode.editor.cn; //如果你的算法题是中文的，后缀就是cn，如果是英文的就是en

import java.util.HashMap;
import java.util.Map;

/**
 * @author  YourName
 * @date 2024-08-27 22:20:33
 */
public class FindTheMedianOfTheUniquenessArray{
    public static void main(String[] args) {
        Solution solution = new FindTheMedianOfTheUniquenessArray().new Solution();
        System.out.println(solution.medianOfUniquenessArray(new int[]{91,64,76,18,61,55,46,93,65,99}));
   }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int medianOfUniquenessArray(int[] nums) {
        int n = nums.length;
        long sum = (long) (n + 1) * n / 4 + ((long) (n + 1) * n/ 2 % 2);
        int left = 1;
        int right = n;
        int result = 0;
        while (left <= right) {
            int mid =  (left + right) / 2;
            if (check(nums, mid) >= sum) {
                result = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return result;
    }
    public long check(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        int left = 0;
        int right = 0;
        long count = 0;
        while (right < nums.length) {
            map.put(nums[right], map.getOrDefault(nums[right], 0) + 1);
            while (map.size() > target) {
                map.put(nums[left], map.get(nums[left]) - 1);
                if (map.get(nums[left]) == 0) {
                    map.remove(nums[left]);
                }
                left++;
            }
            count += right - left + 1;
            right++;
        }
        return count;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}