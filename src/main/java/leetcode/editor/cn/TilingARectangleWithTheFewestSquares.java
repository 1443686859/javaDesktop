//你是一位施工队的工长，根据设计师的要求准备为一套设计风格独特的房子进行室内装修。 
//
// 房子的客厅大小为 n x m，为保持极简的风格，需要使用尽可能少的 正方形 瓷砖来铺盖地面。 
//
// 假设正方形瓷砖的规格不限，边长都是整数。 
//
// 请你帮设计师计算一下，最少需要用到多少块方形瓷砖？ 
//
// 
//
// 示例 1： 
//
// 
//
// 输入：n = 2, m = 3
//输出：3
//解释：3 块地砖就可以铺满卧室。
//     2 块 1x1 地砖
//     1 块 2x2 地砖 
//
// 示例 2： 
//
// 
//
// 输入：n = 5, m = 8
//输出：5
// 
//
// 示例 3： 
//
// 
//
// 输入：n = 11, m = 13
//输出：6
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 13 
// 1 <= m <= 13 
// 
//
// Related Topics 动态规划 回溯 👍 184 👎 0

package leetcode.editor.cn; //如果你的算法题是中文的，后缀就是cn，如果是英文的就是en
 /**
 * @author  YourName
 * @date 2023-06-08 21:52:20
 */
public class TilingARectangleWithTheFewestSquares{
    public static void main(String[] args) {
        Solution solution = new TilingARectangleWithTheFewestSquares().new Solution();
   }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
        int result;
    public int tilingRectangle(int n, int m) {
        boolean[][] visited = new boolean[n][m];
        result = Math.max(n, m);
        dfs(0, 0, visited, 0);
        return result;
    }

    public void dfs(int x,int y, boolean[][] used, int count) {
        int n = used.length;
        int m = used[0].length;
        if (count >= result) {
            return;
        }
        if (x >= n) {
            result = Math.min(result, count);
            return;
        }
        if (y >= m) {
            dfs(x + 1, 0, used, count);
            return;
        }
        if (used[x][y]) {
            dfs(x, y + 1, used, count);
            return;
        }
        for (int k = Math.min(n - x, m - y); k >= 1 && check(used, x, y, k); k --) {
            fill(used, x, y, k,true);
            dfs(x, y + k, used, count + 1);
            fill(used, x, y, k, false);
        }
    }
    public boolean check(boolean[][] used, int x, int y, int k) {
        for (int i = 0; i < k; i++) {
            for (int j = 0; j < k; j++) {
                if (used[x + i][y + j]) {
                    return false;
                }
            }
        }
        return true;
    }
    public void fill(boolean[][] used, int x, int y, int k, boolean result) {
        for (int i = 0; i < k; i++) {
            for (int j = 0; j < k; j++) {
                used[x + i][y + j] = result;
            }
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}