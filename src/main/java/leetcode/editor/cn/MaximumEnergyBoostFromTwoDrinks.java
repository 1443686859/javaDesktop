/**
来自未来的体育科学家给你两个整数数组 energyDrinkA 和 energyDrinkB，数组长度都等于 n。这两个数组分别代表 A、B 两种不同能量饮料每
小时所能提供的强化能量。 

 你需要每小时饮用一种能量饮料来 最大化 你的总强化能量。然而，如果从一种能量饮料切换到另一种，你需要等待一小时来梳理身体的能量体系（在那个小时里你将不会获得任
何强化能量）。 

 返回在接下来的 n 小时内你能获得的 最大 总强化能量。 

 注意 你可以选择从饮用任意一种能量饮料开始。 

 

 示例 1： 

 
 输入：energyDrinkA = [1,3,1], energyDrinkB = [3,1,1] 
 

 输出：5 

 解释： 

 要想获得 5 点强化能量，需要选择只饮用能量饮料 A（或者只饮用 B）。 

 示例 2： 

 
 输入：energyDrinkA = [4,1,1], energyDrinkB = [1,1,3] 
 

 输出：7 

 解释： 

 
 第一个小时饮用能量饮料 A。 
 切换到能量饮料 B ，在第二个小时无法获得强化能量。 
 第三个小时饮用能量饮料 B ，并获得强化能量。 
 

 

 提示： 

 
 n == energyDrinkA.length == energyDrinkB.length 
 3 <= n <= 10⁵ 
 1 <= energyDrinkA[i], energyDrinkB[i] <= 10⁵ 
 

 👍 35 👎 0

*/
package leetcode.editor.cn; //如果你的算法题是中文的，后缀就是cn，如果是英文的就是en
 /**
 * @author  YourName
 * @date 2024-11-01 23:32:27
 */
public class MaximumEnergyBoostFromTwoDrinks{
    public static void main(String[] args) {
        Solution solution = new MaximumEnergyBoostFromTwoDrinks().new Solution();
   }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public long maxEnergyBoost(int[] energyDrinkA, int[] energyDrinkB) {
        long[][] dp = new long[2][2];
        int index = 0;
        for (int i = 0; i < energyDrinkA.length; i++) {
            index = i & 1;
            long[] result = new long[2];
            result[0] = Math.max(dp[index ^ 1][0], dp[index][1]) + energyDrinkA[i];
            result[1] = Math.max(dp[index ^ 1][1], dp[index][0]) + energyDrinkB[i];
            dp[index] = result;
        }
        return Math.max(dp[index][0], dp[index][1]);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}