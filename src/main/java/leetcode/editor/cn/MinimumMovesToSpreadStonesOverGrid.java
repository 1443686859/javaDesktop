/**
给你一个大小为 3 * 3 ，下标从 0 开始的二维整数矩阵 grid ，分别表示每一个格子里石头的数目。网格图中总共恰好有 9 个石头，一个格子里可能会有 多
个 石头。 

 每一次操作中，你可以将一个石头从它当前所在格子移动到一个至少有一条公共边的相邻格子。 

 请你返回每个格子恰好有一个石头的 最少移动次数 。 

 

 示例 1： 

 

 
输入：grid = [[1,1,0],[1,1,1],[1,2,1]]
输出：3
解释：让每个格子都有一个石头的一个操作序列为：
1 - 将一个石头从格子 (2,1) 移动到 (2,2) 。
2 - 将一个石头从格子 (2,2) 移动到 (1,2) 。
3 - 将一个石头从格子 (1,2) 移动到 (0,2) 。
总共需要 3 次操作让每个格子都有一个石头。
让每个格子都有一个石头的最少操作次数为 3 。
 

 示例 2： 

 

 
输入：grid = [[1,3,0],[1,0,0],[1,0,3]]
输出：4
解释：让每个格子都有一个石头的一个操作序列为：
1 - 将一个石头从格子 (0,1) 移动到 (0,2) 。
2 - 将一个石头从格子 (0,1) 移动到 (1,1) 。
3 - 将一个石头从格子 (2,2) 移动到 (1,2) 。
4 - 将一个石头从格子 (2,2) 移动到 (2,1) 。
总共需要 4 次操作让每个格子都有一个石头。
让每个格子都有一个石头的最少操作次数为 4 。
 

 

 提示： 

 
 grid.length == grid[i].length == 3 
 0 <= grid[i][j] <= 9 
 grid 中元素之和为 9 。 
 

 👍 50 👎 0

*/
package leetcode.editor.cn; //如果你的算法题是中文的，后缀就是cn，如果是英文的就是en

import java.util.*;

/**
 * @author  YourName
 * @date 2024-07-20 15:35:22
 */
public class MinimumMovesToSpreadStonesOverGrid{
    public static void main(String[] args) {
        Solution solution = new MinimumMovesToSpreadStonesOverGrid().new Solution();
        System.out.println(solution.minimumMoves(new int[][]{
                {3,2,0},{0,1,0},{0,3,0}
        }));
        System.out.println(solution.minimumLength("abaacbcbb"));
   }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
        int result;
    public int minimumMoves(int[][] grid) {
        result = Integer.MAX_VALUE;
        List<int[]> zeroList = new ArrayList<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid.length; j++) {
                if (grid[i][j] == 0) {
                    zeroList.add(new int[]{i, j});
                }
            }
        }
        dfs(zeroList, 0, 0, grid);
        return result;
    }
    public void dfs(List<int[]> zeroList, int index, int count, int[][] grid) {
        if (count > result) {
            return;
        }
        if (index == zeroList.size()) {
            result = Math.min(result , count);
            return;
        }
        int[] temp = zeroList.get(index);
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid.length; j++) {
                if (grid[i][j] > 1) {
                    int current = Math.abs(temp[1] - j) + Math.abs(temp[0] - i);
                    grid[i][j] --;
                    dfs(zeroList, index + 1 , count + current, grid);
                    grid[i][j]++;
                }
            }
        }
    }
    public int minimumLength(String s) {
        int[] count = new int[26];
        int n = s.length();
        int result = 0;
        for (int i = 0; i < n; i++) {
            int index = s.charAt(i) - 'a';
            count[index]++;
        }
        for (int a : count) {
            if (a >= 3) {
                result += (a % 2 == 0) ? 2 : 1;
            } else {
                result += a;
            }
        }
        return result;
    }

}
//leetcode submit region end(Prohibit modification and deletion)

}