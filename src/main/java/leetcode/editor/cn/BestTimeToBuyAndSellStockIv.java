//给你一个整数数组 prices 和一个整数 k ，其中 prices[i] 是某支给定的股票在第 i 天的价格。 
//
// 设计一个算法来计算你所能获取的最大利润。你最多可以完成 k 笔交易。也就是说，你最多可以买 k 次，卖 k 次。 
//
// 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。 
//
// 
//
// 示例 1： 
//
// 
//输入：k = 2, prices = [2,4,1]
//输出：2
//解释：在第 1 天 (股票价格 = 2) 的时候买入，在第 2 天 (股票价格 = 4) 的时候卖出，这笔交易所能获得利润 = 4-2 = 2 。 
//
// 示例 2： 
//
// 
//输入：k = 2, prices = [3,2,6,5,0,3]
//输出：7
//解释：在第 2 天 (股票价格 = 2) 的时候买入，在第 3 天 (股票价格 = 6) 的时候卖出, 这笔交易所能获得利润 = 6-2 = 4 。
//     随后，在第 5 天 (股票价格 = 0) 的时候买入，在第 6 天 (股票价格 = 3) 的时候卖出, 这笔交易所能获得利润 = 3-0 = 3 
//。 
//
// 
//
// 提示： 
//
// 
// 1 <= k <= 100 
// 1 <= prices.length <= 1000 
// 0 <= prices[i] <= 1000 
// 
//
// Related Topics 数组 动态规划 👍 1048 👎 0

package leetcode.editor.cn; //如果你的算法题是中文的，后缀就是cn，如果是英文的就是en

import java.util.Arrays;

/**
 * @author  YourName
 * @date 2023-10-04 10:27:38
 */
public class BestTimeToBuyAndSellStockIv{
    public static void main(String[] args) {
        Solution solution = new BestTimeToBuyAndSellStockIv().new Solution();
        System.out.println(solution.maxProfit(2, new int[]{2,1,4,5,2,9,7}));
   }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maxProfit(int k, int[] prices) {
        int n = prices.length;
        int[][] result = new int[k + 1][2];
        int MIN = -(int)(1e6);

        for (int i = 1; i <= k; i++) {
            Arrays.fill(result[i], MIN);
        }
        result[0][1] = - prices[0];
        for (int i = 1; i < n; i++) {
            result[0][1] = Math.max(-prices[i], result[0][1]);
            for (int j = 1; j <= k; j++) {
                result[j][0] = Math.max(result[j][0], result[j - 1][1] + prices[i]);
                result[j][1] = Math.max(result[j][1],result[j][0] - prices[i]);
            }
        }
        int ans = 0;
        for (int i = 1; i <= k; i++) {
            ans = Math.max(ans, result[i][0]);
        }
        return ans;

    }
}
//leetcode submit region end(Prohibit modification and deletion)

}