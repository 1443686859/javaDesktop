/**
一个公司在全国有 n 个分部，它们之间有的有道路连接。一开始，所有分部通过这些道路两两之间互相可以到达。 

 公司意识到在分部之间旅行花费了太多时间，所以它们决定关闭一些分部（也可能不关闭任何分部），同时保证剩下的分部之间两两互相可以到达且最远距离不超过 
maxDistance 。 

 两个分部之间的 距离 是通过道路长度之和的 最小值 。 

 给你整数 n ，maxDistance 和下标从 0 开始的二维整数数组 roads ，其中 roads[i] = [ui, vi, wi] 表示一条从 
ui 到 vi 长度为 wi的 无向 道路。 

 请你返回关闭分部的可行方案数目，满足每个方案里剩余分部之间的最远距离不超过 maxDistance。 

 注意，关闭一个分部后，与之相连的所有道路不可通行。 

 注意，两个分部之间可能会有多条道路。 

 

 示例 1： 

 

 
输入：n = 3, maxDistance = 5, roads = [[0,1,2],[1,2,10],[0,2,10]]
输出：5
解释：可行的关闭分部方案有：
- 关闭分部集合 [2] ，剩余分部为 [0,1] ，它们之间的距离为 2 。
- 关闭分部集合 [0,1] ，剩余分部为 [2] 。
- 关闭分部集合 [1,2] ，剩余分部为 [0] 。
- 关闭分部集合 [0,2] ，剩余分部为 [1] 。
- 关闭分部集合 [0,1,2] ，关闭后没有剩余分部。
总共有 5 种可行的关闭方案。
 

 示例 2： 

 

 
输入：n = 3, maxDistance = 5, roads = [[0,1,20],[0,1,10],[1,2,2],[0,2,2]]
输出：7
解释：可行的关闭分部方案有：
- 关闭分部集合 [] ，剩余分部为 [0,1,2] ，它们之间的最远距离为 4 。
- 关闭分部集合 [0] ，剩余分部为 [1,2] ，它们之间的距离为 2 。
- 关闭分部集合 [1] ，剩余分部为 [0,2] ，它们之间的距离为 2 。
- 关闭分部集合 [0,1] ，剩余分部为 [2] 。
- 关闭分部集合 [1,2] ，剩余分部为 [0] 。
- 关闭分部集合 [0,2] ，剩余分部为 [1] 。
- 关闭分部集合 [0,1,2] ，关闭后没有剩余分部。
总共有 7 种可行的关闭方案。
 

 示例 3： 

 
输入：n = 1, maxDistance = 10, roads = []
输出：2
解释：可行的关闭分部方案有：
- 关闭分部集合 [] ，剩余分部为 [0] 。
- 关闭分部集合 [0] ，关闭后没有剩余分部。
总共有 2 种可行的关闭方案。
 

 

 提示： 

 
 1 <= n <= 10 
 1 <= maxDistance <= 10⁵ 
 0 <= roads.length <= 1000 
 roads[i].length == 3 
 0 <= ui, vi <= n - 1 
 ui != vi 
 1 <= wi <= 1000 
 一开始所有分部之间通过道路互相可以到达。 
 

 👍 30 👎 0

*/
package leetcode.editor.cn; //如果你的算法题是中文的，后缀就是cn，如果是英文的就是en

import java.util.Arrays;

/**
 * @author  YourName
 * @date 2024-07-17 22:13:31
 */
public class NumberOfPossibleSetsOfClosingBranches{
    public static void main(String[] args) {
        Solution solution = new NumberOfPossibleSetsOfClosingBranches().new Solution();
   }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int numberOfSets(int n, int maxDistance, int[][] roads) {
        int max = 1 << n;
        int count = 0;
        int[][] f = new int[n][n];
        for (int[] t : f) {
            Arrays.fill(t, Integer.MAX_VALUE / 2);
        }
        for (int[] road : roads) {
            f[road[0]][road[1]] = Math.min(road[2], f[road[0]][road[1]]);
            f[road[1]][road[0]] =  Math.min(road[2], f[road[1]][road[0]]);
        }
        int[][] d = new int[n][n];
        out:
        for (int mask = 0; mask < max; mask++) {
            for (int i = 0; i < n; i++) {
                if ((mask & (1 << i)) != 0) {
                    System.arraycopy(f[i], 0, d[i], 0, n);
                }
            }

            for (int i = 0; i < n; i++) {
                if (((1 << i) & mask) == 0) {
                    continue;
                }
                for (int j = 0; j < n; j++) {
                    if (((1 << j) & mask) == 0) {
                        continue;
                    }
                    for (int z = 0; z < n; z ++) {
                        if (((1 << z) & mask) == 0) {
                            continue;
                        }
                        d[j][z] = Math.min(d[j][z], d[j][i] + d[i][z]);
                    }
                }
            }
            for (int i = 0; i < n; i++) {
                if (((1 << i) & mask) == 0) {
                    continue;
                }
                for (int j = 0; j < n; j++) {
                    if (((1 << j) & mask) == 0 || i == j) {
                        continue;
                    }
                    if (d[i][j] > maxDistance) {
                        continue out;
                    }
                }
            }
                count++;

        }
        return count;
    }

}
//leetcode submit region end(Prohibit modification and deletion)

}