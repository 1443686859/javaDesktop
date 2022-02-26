package leetcode.editor.cn;
//在大小为 n x n 的网格 grid 上，每个单元格都有一盏灯，最初灯都处于 关闭 状态。 
//
// 给你一个由灯的位置组成的二维数组 lamps ，其中 lamps[i] = [rowi, coli] 表示 打开 位于 grid[rowi][coli] 
//的灯。即便同一盏灯可能在 lamps 中多次列出，不会影响这盏灯处于 打开 状态。 
//
// 当一盏灯处于打开状态，它将会照亮 自身所在单元格 以及同一 行 、同一 列 和两条 对角线 上的 所有其他单元格 。 
//
// 另给你一个二维数组 queries ，其中 queries[j] = [rowj, colj] 。对于第 j 个查询，如果单元格 [rowj, colj]
// 是被照亮的，则查询结果为 1 ，否则为 0 。在第 j 次查询之后 [按照查询的顺序] ，关闭 位于单元格 grid[rowj][colj] 上及相邻 8 个
//方向上（与单元格 grid[rowi][coli] 共享角或边）的任何灯。 
//
// 返回一个整数数组 ans 作为答案， ans[j] 应等于第 j 次查询 queries[j] 的结果，1 表示照亮，0 表示未照亮。 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 5, lamps = [[0,0],[4,4]], queries = [[1,1],[1,0]]
//输出：[1,0]
//解释：最初所有灯都是关闭的。在执行查询之前，打开位于 [0, 0] 和 [4, 4] 的灯。第 0 次查询检查 grid[1][1] 是否被照亮（蓝色方框）
//。该单元格被照亮，所以 ans[0] = 1 。然后，关闭红色方框中的所有灯。
//
//第 1 次查询检查 grid[1][0] 是否被照亮（蓝色方框）。该单元格没有被照亮，所以 ans[1] = 0 。然后，关闭红色矩形中的所有灯。
//
// 
//
// 示例 2： 
//
// 
//输入：n = 5, lamps = [[0,0],[4,4]], queries = [[1,1],[1,1]]
//输出：[1,1]
// 
//
// 示例 3： 
//
// 
//输入：n = 5, lamps = [[0,0],[0,4]], queries = [[0,4],[0,1],[1,4]]
//输出：[1,1,0]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 10⁹ 
// 0 <= lamps.length <= 20000 
// 0 <= queries.length <= 20000 
// lamps[i].length == 2 
// 0 <= rowi, coli < n 
// queries[j].length == 2 
// 0 <= rowj, colj < n 
// 
// Related Topics 数组 哈希表 👍 113 👎 0

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class P1001GridIllumination{
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] gridIllumination(int n, int[][] lamps, int[][] queries) {
        Map<Integer, Integer> rMap = new HashMap<>();
        Map<Integer, Integer> cMap = new HashMap<>();
        Map<Integer, Integer> diagonal = new HashMap<>();
        Map<Integer, Integer> antiDiagonal = new HashMap<>();
        Set<Long> hashSet = new HashSet<>();
        for (int[] lamp : lamps) {
            if (hashSet.contains(hash(lamp[0], lamp[1]))) {
                continue;
            }
            hashSet.add(hash(lamp[0], lamp[1]));
            rMap.put(lamp[0], rMap.getOrDefault(lamp[0], 0) + 1);
            cMap.put(lamp[1], cMap.getOrDefault(lamp[1], 0) + 1);
            diagonal.put(lamp[1] - lamp[0], diagonal.getOrDefault(lamp[1] - lamp[0], 0) + 1);
            antiDiagonal.put(lamp[1] + lamp[0], antiDiagonal.getOrDefault(lamp[1] + lamp[0], 0) + 1);
        }
        int[] ans = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int r = queries[i][0];
            int c = queries[i][1];
            if (rMap.getOrDefault(r, 0) > 0) {
                ans[i] = 1;
            }  else if (cMap.getOrDefault(c, 0) > 0) {
                ans[i] = 1;
            } else if (diagonal.getOrDefault(c - r, 0) > 0) {
                ans[i] = 1;
            } else if (antiDiagonal.getOrDefault(c + r, 0) > 0) {
                ans[i] = 1;
            }
            for (int x = r - 1; x <= r + 1; x++) {
                for (int y = c - 1; y <= c + 1; y++) {
                    if (x < 0 || x >= n || y < 0 || y >= n) {
                        continue;
                    }
                    if (hashSet.contains(hash(x, y))) {
                        rMap.put(x, rMap.get(x) - 1);
                        cMap.put(y, cMap.get(y) - 1);
                        diagonal.put(y - x, diagonal.get(y - x) - 1);
                        antiDiagonal.put(y + x, diagonal.get(y + x) - 1);
                        hashSet.remove(hash(x, y));
                    }
                }
            }
        }
        return ans;
    }
    public long hash(int i, int j) {
        return (long)i + ((long)j << 32);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}