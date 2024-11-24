/**
给你一个正整数数组 values，其中 values[i] 表示第 i 个观光景点的评分，并且两个景点 i 和 j 之间的 距离 为 j - i。 

 一对景点（i < j）组成的观光组合的得分为 values[i] + values[j] + i - j ，也就是景点的评分之和 减去 它们两者之间的距离。 


 返回一对观光景点能取得的最高分。 

 

 示例 1： 

 
输入：values = [8,1,5,2,6]
输出：11
解释：i = 0, j = 2, values[i] + values[j] + i - j = 8 + 5 + 0 - 2 = 11
 

 示例 2： 

 
输入：values = [1,2]
输出：2
 

 

 提示： 

 
 2 <= values.length <= 5 * 10⁴ 
 1 <= values[i] <= 1000 
 

 👍 443 👎 0

*/
package leetcode.editor.cn; //如果你的算法题是中文的，后缀就是cn，如果是英文的就是en
 /**
 * @author  YourName
 * @date 2024-09-23 20:32:05
 */
public class BestSightseeingPair{
    public static void main(String[] args) {
        Solution solution = new BestSightseeingPair().new Solution();
   }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maxScoreSightseeingPair(int[] values) {
        int max = Integer.MIN_VALUE;
        int result = 0;
        for (int i = 0; i < values.length; i++) {
            result = Math.max(result, max + values[i] - i);
            max = Math.max(max, values[i] + i);
        }
        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}