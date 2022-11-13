//给你一个长度为 n 的整数数组 rolls 和一个整数 k 。你扔一个 k 面的骰子 n 次，骰子的每个面分别是 1 到 k ，其中第 i 次扔得到的数字是
// rolls[i] 。 
//
// 请你返回 无法 从 rolls 中得到的 最短 骰子子序列的长度。 
//
// 扔一个 k 面的骰子 len 次得到的是一个长度为 len 的 骰子子序列 。 
//
// 注意 ，子序列只需要保持在原数组中的顺序，不需要连续。 
//
// 
//
// 示例 1： 
//
// 
//输入：rolls = [4,2,1,2,3,3,2,4,1], k = 4
//输出：3
//解释：所有长度为 1 的骰子子序列 [1] ，[2] ，[3] ，[4] 都可以从原数组中得到。
//所有长度为 2 的骰子子序列 [1, 1] ，[1, 2] ，... ，[4, 4] 都可以从原数组中得到。
//子序列 [1, 4, 2] 无法从原数组中得到，所以我们返回 3 。
//还有别的子序列也无法从原数组中得到。 
//
// 示例 2： 
//
// 
//输入：rolls = [1,1,2,2], k = 2
//输出：2
//解释：所有长度为 1 的子序列 [1] ，[2] 都可以从原数组中得到。
//子序列 [2, 1] 无法从原数组中得到，所以我们返回 2 。
//还有别的子序列也无法从原数组中得到，但 [2, 1] 是最短的子序列。
// 
//
// 示例 3： 
//
// 
//输入：rolls = [1,1,3,2,2,2,3,3], k = 4
//输出：1
//解释：子序列 [4] 无法从原数组中得到，所以我们返回 1 。
//还有别的子序列也无法从原数组中得到，但 [4] 是最短的子序列。
// 
//
// 
//
// 提示： 
//
// 
// n == rolls.length 
// 1 <= n <= 10⁵ 
// 1 <= rolls[i] <= k <= 10⁵ 
// 
//
// 👍 18 👎 0

package leetcode.editor.cn; //如果你的算法题是中文的，后缀就是cn，如果是英文的就是en

import java.util.HashSet;
import java.util.Set;

/**
 * @author  YourName
 * @date 2022-07-25 22:38:11
 */
public class ShortestImpossibleSequenceOfRolls{
    public static void main(String[] args) {
        Solution solution = new ShortestImpossibleSequenceOfRolls().new Solution();
   }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int shortestSequence(int[] rolls, int k) {
        int res = 0;
        Set<Integer> set = new HashSet<>();
        for (int i : rolls) {
          set.add(i);
          if (set.size() == k) {
              res++;
              set.clear();
          }
        }
       return res + 1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}