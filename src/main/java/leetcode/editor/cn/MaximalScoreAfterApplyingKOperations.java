//给你一个下标从 0 开始的整数数组 nums 和一个整数 k 。你的 起始分数 为 0 。 
//
// 在一步 操作 中： 
//
// 
// 选出一个满足 0 <= i < nums.length 的下标 i ， 
// 将你的 分数 增加 nums[i] ，并且 
// 将 nums[i] 替换为 ceil(nums[i] / 3) 。 
// 
//
// 返回在 恰好 执行 k 次操作后，你可能获得的最大分数。 
//
// 向上取整函数 ceil(val) 的结果是大于或等于 val 的最小整数。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [10,10,10,10,10], k = 5
//输出：50
//解释：对数组中每个元素执行一次操作。最后分数是 10 + 10 + 10 + 10 + 10 = 50 。
// 
//
// 示例 2： 
//
// 
//输入：nums = [1,10,3,3,3], k = 3
//输出：17
//解释：可以执行下述操作：
//第 1 步操作：选中 i = 1 ，nums 变为 [1,4,3,3,3] 。分数增加 10 。
//第 2 步操作：选中 i = 1 ，nums 变为 [1,2,3,3,3] 。分数增加 4 。
//第 3 步操作：选中 i = 2 ，nums 变为 [1,1,1,3,3] 。分数增加 3 。
//最后分数是 10 + 4 + 3 = 17 。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length, k <= 10⁵ 
// 1 <= nums[i] <= 10⁹ 
// 
//
// Related Topics 贪心 数组 堆（优先队列） 👍 69 👎 0

package leetcode.editor.cn; //如果你的算法题是中文的，后缀就是cn，如果是英文的就是en

import java.util.Arrays;

/**
 * @author  YourName
 * @date 2023-10-18 21:23:45
 */
public class MaximalScoreAfterApplyingKOperations{
    public static void main(String[] args) {
        Solution solution = new MaximalScoreAfterApplyingKOperations().new Solution();
        System.out.println(solution.maxKelements(new int[]{238838724,196963851,539418658,120132686,273213807,57187185,68854249,619718192}, 7));
   }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public long maxKelements(int[] nums, int k) {
        Arrays.sort(nums);
        int[] que = new int[k];
        int index = nums.length - 1;
        int right = 0;
        int left = 0;
        long sum = 0;
        int temp = 0;
        while (k-- > 0) {
            if (index >= 0 && (nums[index] >= que[left])) {
                temp = nums[index--];
            } else {
                temp = que[left++];
            }
            if (temp == 1) {
                return sum + k + 1;
            }
            sum += temp;
            que[right++] = (temp + 2) /3;

        }
        return sum;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}