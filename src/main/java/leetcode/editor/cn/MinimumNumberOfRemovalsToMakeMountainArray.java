//我们定义 arr 是 山形数组 当且仅当它满足： 
//
// 
// arr.length >= 3 
// 存在某个下标 i （从 0 开始） 满足 0 < i < arr.length - 1 且： 
// 
// arr[0] < arr[1] < ... < arr[i - 1] < arr[i] 
// arr[i] > arr[i + 1] > ... > arr[arr.length - 1] 
// 
// 
//
// 给你整数数组 nums ，请你返回将 nums 变成 山形状数组 的 最少 删除次数。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,3,1]
//输出：0
//解释：数组本身就是山形数组，所以我们不需要删除任何元素。
// 
//
// 示例 2： 
//
// 
//输入：nums = [2,1,1,5,6,2,3,1]
//输出：3
//解释：一种方法是将下标为 0，1 和 5 的元素删除，剩余元素为 [1,5,6,3,1] ，是山形数组。
// 
//
// 
//
// 提示： 
//
// 
// 3 <= nums.length <= 1000 
// 1 <= nums[i] <= 10⁹ 
// 题目保证 nums 删除一些元素后一定能得到山形数组。 
// 
//
// Related Topics 贪心 数组 二分查找 动态规划 👍 111 👎 0

package leetcode.editor.cn; //如果你的算法题是中文的，后缀就是cn，如果是英文的就是en

import java.util.*;

/**
 * @author  YourName
 * @date 2023-12-22 22:06:58
 */
public class MinimumNumberOfRemovalsToMakeMountainArray{
    public static void main(String[] args) {
        Solution solution = new MinimumNumberOfRemovalsToMakeMountainArray().new Solution();
        System.out.println(solution.minimumMountainRemovals(new int[]{23,47,63,72,81,99,88,55,21,33,32}));
   }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int minimumMountainRemovals(int[] nums) {
        int n = nums.length;
        List<Integer> current = new ArrayList<>();
        int[] pre = new int[n];
        for (int i = 0; i < n; i++) {
            int index = getLower(current, nums[i]);
            if (index == current.size()) {
                current.add(nums[i]);
            } else {
                current.set(index, nums[i]);
            }
            pre[i] = index + 1;
        }
        int max = 0;
        current.clear();
        for (int i = n - 1; i >= 0; i --) {
            int index = getLower(current, nums[i]);
            if (index == current.size()) {
                current.add(nums[i]);
            } else {
                current.set(index, nums[i]);
            }
            int suffix = index + 1;
            if (pre[i] > 1 && suffix > 1) {
                max = Math.max(max, pre[i] + suffix - 1);
            }
        }
        return n - max;

    }
    public int getLower(List<Integer> list, int target) {
        int right = list.size() - 1;
        int left = 0;
        while (left <= right) {
            int mid = (left + right) >> 1;
            if (list.get(mid) >= target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return right + 1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}