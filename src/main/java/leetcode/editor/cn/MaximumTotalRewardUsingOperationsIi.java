/**
给你一个整数数组 rewardValues，长度为 n，代表奖励的值。 

 最初，你的总奖励 x 为 0，所有下标都是 未标记 的。你可以执行以下操作 任意次 ： 

 
 从区间 [0, n - 1] 中选择一个 未标记 的下标 i。 
 如果 rewardValues[i] 大于 你当前的总奖励 x，则将 rewardValues[i] 加到 x 上（即 x = x + 
rewardValues[i]），并 标记 下标 i。 
 

 以整数形式返回执行最优操作能够获得的 最大 总奖励。 

 

 示例 1： 

 
 输入：rewardValues = [1,1,3,3] 
 

 输出：4 

 解释： 

 依次标记下标 0 和 2，总奖励为 4，这是可获得的最大值。 

 示例 2： 

 
 输入：rewardValues = [1,6,4,3,2] 
 

 输出：11 

 解释： 

 依次标记下标 0、2 和 1。总奖励为 11，这是可获得的最大值。 

 

 提示： 

 
 1 <= rewardValues.length <= 5 * 10⁴ 
 1 <= rewardValues[i] <= 5 * 10⁴ 
 

 👍 28 👎 0

*/
package leetcode.editor.cn; //如果你的算法题是中文的，后缀就是cn，如果是英文的就是en
 /**
 * @author  YourName
 * @date 2024-10-26 23:41:45
 */
public class MaximumTotalRewardUsingOperationsIi{
    public static void main(String[] args) {
        Solution solution = new MaximumTotalRewardUsingOperationsIi().new Solution();
   }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maxTotalReward(int[] rewardValues) {
        return 0;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}