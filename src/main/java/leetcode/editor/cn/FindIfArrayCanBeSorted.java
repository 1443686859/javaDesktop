/**
给你一个下标从 0 开始且全是 正 整数的数组 nums 。 

 一次 操作 中，如果两个 相邻 元素在二进制下数位为 1 的数目 相同 ，那么你可以将这两个元素交换。你可以执行这个操作 任意次 （也可以 0 次）。 

 如果你可以使数组变有序，请你返回 true ，否则返回 false 。 

 

 示例 1： 

 
输入：nums = [8,4,2,30,15]
输出：true
解释：我们先观察每个元素的二进制表示。 2 ，4 和 8 分别都只有一个数位为 1 ，分别为 "10" ，"100" 和 "1000" 。15 和 30 分别有
 4 个数位为 1 ："1111" 和 "11110" 。
我们可以通过 4 个操作使数组有序：
- 交换 nums[0] 和 nums[1] 。8 和 4 分别只有 1 个数位为 1 。数组变为 [4,8,2,30,15] 。
- 交换 nums[1] 和 nums[2] 。8 和 2 分别只有 1 个数位为 1 。数组变为 [4,2,8,30,15] 。
- 交换 nums[0] 和 nums[1] 。4 和 2 分别只有 1 个数位为 1 。数组变为 [2,4,8,30,15] 。
- 交换 nums[3] 和 nums[4] 。30 和 15 分别有 4 个数位为 1 ，数组变为 [2,4,8,15,30] 。
数组变成有序的，所以我们返回 true 。
注意我们还可以通过其他的操作序列使数组变得有序。
 

 示例 2： 

 
输入：nums = [1,2,3,4,5]
输出：true
解释：数组已经是有序的，所以我们返回 true 。
 

 示例 3： 

 
输入：nums = [3,16,8,4,2]
输出：false
解释：无法通过操作使数组变为有序。
 

 

 提示： 

 
 1 <= nums.length <= 100 
 1 <= nums[i] <= 2⁸ 
 

 👍 24 👎 0

*/
package leetcode.editor.cn; //如果你的算法题是中文的，后缀就是cn，如果是英文的就是en
 /**
 * @author  YourName
 * @date 2024-07-13 20:27:05
 */
public class FindIfArrayCanBeSorted{
    public static void main(String[] args) {
        Solution solution = new FindIfArrayCanBeSorted().new Solution();
   }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean canSortArray(int[] nums) {
        int preMax = 0;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (i == 0 || count(nums[i - 1]) != count(nums[i])) {
                if (preMax > min) {
                    return false;
                }
                preMax = max;
                min = Integer.MAX_VALUE;
                max = Integer.MIN_VALUE;
            }
            max = Math.max(max, nums[i]);
            min = Math.min(min, nums[i]);
        }
        if (preMax > min) {
            return false;
        }
        return true;
    }
    public int count(int x) {
        int count = 0;
        while (x != 0) {
            count += x & 1 ;
            x >>= 1;
        }
        return count;
    }

}
//leetcode submit region end(Prohibit modification and deletion)

}