//数对 (a,b) 由整数 a 和 b 组成，其数对距离定义为 a 和 b 的绝对差值。 
//
// 给你一个整数数组 nums 和一个整数 k ，数对由 nums[i] 和 nums[j] 组成且满足 0 <= i < j < nums.length 。
//返回 所有数对距离中 第 k 小的数对距离。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,3,1], k = 1
//输出：0
//解释：数对和对应的距离如下：
//(1,3) -> 2
//(1,1) -> 0
//(3,1) -> 2
//距离第 1 小的数对是 (1,1) ，距离为 0 。
// 
//
// 示例 2： 
//
// 
//输入：nums = [1,1,1], k = 2
//输出：0
// 
//
// 示例 3： 
//
// 
//输入：nums = [1,6,1], k = 3
//输出：5
// 
//
// 
//
// 提示： 
//
// 
// n == nums.length 
// 2 <= n <= 10⁴ 
// 0 <= nums[i] <= 10⁶ 
// 1 <= k <= n * (n - 1) / 2 
// 
// Related Topics 数组 双指针 二分查找 排序 👍 351 👎 0

package leetcode.editor.cn; //如果你的算法题是中文的，后缀就是cn，如果是英文的就是en

import java.util.Arrays;

/**
 * @author  YourName
 * @date 2022-06-15 21:36:59
 */
public class FindKThSmallestPairDistance{
    public static void main(String[] args) {
        Solution solution = new FindKThSmallestPairDistance().new Solution();
        System.out.println(solution.smallestDistancePair(new int[]{62,100,4}, 2));
    }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int smallestDistancePair(int[] nums, int k) {
        Arrays.sort(nums);
        int max = nums[nums.length - 1] - nums[0];
        int min = 0;
        while (min <= max) {
            int mid = (max + min) / 2;
            int count = 0;
            for (int i = 0; i < nums.length; i++) {
                int right = i;
                int left = 0;
                int target = nums[i] - mid;
                int currentResult = 0;
                while (left <= right) {
                    int currentMid = (right + left) / 2;
                    if (nums[currentMid] >= target) {
                        right = currentMid - 1;
                        currentResult = currentMid;
                    } else {
                        left = currentMid + 1;
                    }
                }
                count += i - currentResult;
            }
            if (count >= k) {
                max = mid - 1;
            } else {
                min = mid + 1;
            }
        }
        return min;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}