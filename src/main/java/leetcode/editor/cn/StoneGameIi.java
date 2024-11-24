//爱丽丝和鲍勃继续他们的石子游戏。许多堆石子 排成一行，每堆都有正整数颗石子 piles[i]。游戏以谁手中的石子最多来决出胜负。 
//
// 爱丽丝和鲍勃轮流进行，爱丽丝先开始。最初，M = 1。 
//
// 在每个玩家的回合中，该玩家可以拿走剩下的 前 X 堆的所有石子，其中 1 <= X <= 2M。然后，令 M = max(M, X)。 
//
// 游戏一直持续到所有石子都被拿走。 
//
// 假设爱丽丝和鲍勃都发挥出最佳水平，返回爱丽丝可以得到的最大数量的石头。 
//
// 
//
// 示例 1： 
//
// 
//输入：piles = [2,7,9,4,4]
//输出：10
//解释：如果一开始Alice取了一堆，Bob取了两堆，然后Alice再取两堆。爱丽丝可以得到2 + 4 + 4 = 10堆。如果Alice一开始拿走了两堆，那
//么Bob可以拿走剩下的三堆。在这种情况下，Alice得到2 + 7 = 9堆。返回10，因为它更大。
// 
//
// 示例 2: 
//
// 
//输入：piles = [1,2,3,4,5,100]
//输出：104
// 
//
// 
//
// 提示： 
//
// 
// 1 <= piles.length <= 100 
// 
// 1 <= piles[i] <= 10⁴ 
// 
//
// Related Topics 数组 数学 动态规划 博弈 👍 256 👎 0

package leetcode.editor.cn; //如果你的算法题是中文的，后缀就是cn，如果是英文的就是en

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author  YourName
 * @date 2023-02-22 21:54:48
 */
public class StoneGameIi{
    public static void main(String[] args) {
        Solution solution = new StoneGameIi().new Solution();
   }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    int n;
    int[] sum;
    int[][] memory;
    public int stoneGameII(int[] piles) {
        n = piles.length;
        memory = new int[n][n + 1];
        sum = new int[piles.length + 1];
        for (int i = 0; i < piles.length; i++) {
            sum[i + 1] = sum[i] + piles[i];
            Arrays.fill(memory[i], - 1);
        }
        return getMax(0, 1);

    }
    public int getMax(int startIndex, int m) {
        if (2 * m >= n - startIndex) {
            return sum[n] - sum[startIndex];
        }
        if (memory[startIndex][m] != - 1) {
            return memory[startIndex][m];
        }
        int max = 0;
        for (int i = 1; i <= 2 * m; i++) {
            int nextIndex = startIndex + i;
            int nextOne = sum[n] - sum[startIndex];
            max = Math.max(max, nextOne - getMax(nextIndex,  Math.max(i, m)));
        }
        memory[startIndex][m] = max;
        return max;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}