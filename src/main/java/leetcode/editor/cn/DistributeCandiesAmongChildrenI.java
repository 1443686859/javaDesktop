/**
给你两个正整数 n 和 limit 。 

 请你将 n 颗糖果分给 3 位小朋友，确保没有任何小朋友得到超过 limit 颗糖果，请你返回满足此条件下的 总方案数 。 

 

 示例 1： 

 
输入：n = 5, limit = 2
输出：3
解释：总共有 3 种方法分配 5 颗糖果，且每位小朋友的糖果数不超过 2 ：(1, 2, 2) ，(2, 1, 2) 和 (2, 2, 1) 。
 

 示例 2： 

 
输入：n = 3, limit = 3
输出：10
解释：总共有 10 种方法分配 3 颗糖果，且每位小朋友的糖果数不超过 3 ：(0, 0, 3) ，(0, 1, 2) ，(0, 2, 1) ，(0, 3, 0
) ，(1, 0, 2) ，(1, 1, 1) ，(1, 2, 0) ，(2, 0, 1) ，(2, 1, 0) 和 (3, 0, 0) 。
 

 

 提示： 

 
 1 <= n <= 50 
 1 <= limit <= 50 
 

 👍 37 👎 0

*/
package leetcode.editor.cn; //如果你的算法题是中文的，后缀就是cn，如果是英文的就是en

import java.util.Arrays;

/**
 * @author  YourName
 * @date 2024-06-01 13:24:43
 */
public class DistributeCandiesAmongChildrenI{
    public static void main(String[] args) {
        Solution solution = new DistributeCandiesAmongChildrenI().new Solution();
        System.out.println(solution.distributeCandies(3,3));
   }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
        int[][] memo;

    public int distributeCandies(int n, int limit) {
        memo = new int[3][n + 1];
        for (int i = 0; i < 3; i++) {
            Arrays.fill(memo[i], -1);
        }
        return dfs(n, 0, limit);
    }
    public int dfs(int rest, int current, int limit) {
        if (current == 3) {
           return rest == 0 ? 1 : 0;
        }
        if (memo[current][rest] != -1) {
            return memo[current][rest];
        }
        int result = 0;
        for (int i = 0; i <= limit; i++) {
            if (rest >= i) {
                result += dfs(rest - i, current + 1, limit);
            }
        }
        memo[current][rest] = result;
        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}