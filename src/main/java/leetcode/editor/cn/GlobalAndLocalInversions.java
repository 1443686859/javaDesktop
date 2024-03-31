//给你一个长度为 n 的整数数组 nums ，表示由范围 [0, n - 1] 内所有整数组成的一个排列。 
//
// 全局倒置 的数目等于满足下述条件不同下标对 (i, j) 的数目： 
//
// 
// 0 <= i < j < n 
// nums[i] > nums[j] 
// 
//
// 局部倒置 的数目等于满足下述条件的下标 i 的数目： 
//
// 
// 0 <= i < n - 1 
// nums[i] > nums[i + 1] 
// 
//
// 当数组 nums 中 全局倒置 的数量等于 局部倒置 的数量时，返回 true ；否则，返回 false 。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,0,2]
//输出：true
//解释：有 1 个全局倒置，和 1 个局部倒置。
// 
//
// 示例 2： 
//
// 
//输入：nums = [1,2,0]
//输出：false
//解释：有 2 个全局倒置，和 1 个局部倒置。
// 
//
// 
//
// 提示： 
//
// 
// n == nums.length 
// 1 <= n <= 10⁵ 
// 0 <= nums[i] < n 
// nums 中的所有整数 互不相同 
// nums 是范围 [0, n - 1] 内所有数字组成的一个排列 
// 
//
// Related Topics 数组 数学 👍 176 👎 0

package leetcode.editor.cn; //如果你的算法题是中文的，后缀就是cn，如果是英文的就是en

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author  YourName
 * @date 2022-11-16 20:13:07
 */
public class GlobalAndLocalInversions{
    public static void main(String[] args) {
        Solution solution = new GlobalAndLocalInversions().new Solution();
        System.out.println(solution.isIdealPermutation(new int[]{2,0,1}));
   }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isIdealPermutation(int[] nums) {
        int n = nums.length;
        int[] arr = new int[n + 1];
        int count = 0;
        int count1 = 0;
        for (int i = 0; i < nums.length; i++) {
            int index = nums[i] + 1;
            update(index, 1, arr);
            int current = sum(index, arr);
            count += sum(n, arr) - current;
            if (i >= 1 && nums[i - 1] > nums[i]) {
                count1++;
            }
        }
        return count == count1;
    }
    public int lowbit(int n) {
        return n & (-n);
    }
    int sum(int index, int[] arr) {
        int result = 0;
        while (index > 0) {
            result += arr[index];
            index -= lowbit(index);
        }
        return result;
    }
    public void update(int index, int current, int[] arr) {
        while (index < arr.length) {
            arr[index] += current;
            index += lowbit(index);
        }
    }

}
//leetcode submit region end(Prohibit modification and deletion)

}