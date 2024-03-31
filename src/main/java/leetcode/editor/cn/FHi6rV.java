//在 `n*m` 大小的棋盘中，有黑白两种棋子，黑棋记作字母 `"X"`, 白棋记作字母 `"O"`，空余位置记作 `"."`。当落下的棋子与其他相同颜色的棋
//子在行、列或对角线完全包围（中间不存在空白位置）另一种颜色的棋子，则可以翻转这些棋子的颜色。
//
//![1.gif](https://pic.leetcode-cn.com/1630396029-eTgzpN-6da662e67368466a96d203
//f67bb6e793.gif){:height=170px}![2.gif](https://pic.leetcode-cn.com/1630396240-
//nMvdcc-8e4261afe9f60e05a4f740694b439b6b.gif){:height=170px}![3.gif](https://pic.
//leetcode-cn.com/1630396291-kEtzLL-6fcb682daeecb5c3f56eb88b23c81d33.gif){:height=170
//px}
//
//「力扣挑战赛」黑白翻转棋项目中，将提供给选手一个未形成可翻转棋子的棋盘残局，其状态记作 `chessboard`。若下一步可放置一枚黑棋，请问选手最多能翻转
//多少枚白棋。
//
//**注意：**
//- 若翻转白棋成黑棋后，棋盘上仍存在可以翻转的白棋，将可以 **继续** 翻转白棋
//- 输入数据保证初始棋盘状态无可以翻转的棋子且存在空余位置
//
//**示例 1：**
//
//> 输入：`chessboard = ["....X.","....X.","XOOO..","......","......"]`
//>
//> 输出：`3`
//>
//> 解释：
//> 可以选择下在 `[2,4]` 处，能够翻转白方三枚棋子。
//
//**示例 2：**
//
//> 输入：`chessboard = [".X.",".O.","XO."]`
//>
//> 输出：`2`
//>
//> 解释：
//> 可以选择下在 `[2,2]` 处，能够翻转白方两枚棋子。
//> ![2126c1d21b1b9a9924c639d449cc6e65.gif](https://pic.leetcode-cn.com/16266832
//55-OBtBud-2126c1d21b1b9a9924c639d449cc6e65.gif)
//
//**示例 3：**
//
//> 输入：`chessboard = [".......",".......",".......","X......",".O.....","..O....
//","....OOX"]`
//>
//> 输出：`4`
//>
//> 解释：
//> 可以选择下在 `[6,3]` 处，能够翻转白方四枚棋子。
//> ![803f2f04098b6174397d6c696f54d709.gif](https://pic.leetcode-cn.com/16303937
//70-Puyked-803f2f04098b6174397d6c696f54d709.gif)
//
//**提示：**
//- `1 <= chessboard.length, chessboard[i].length <= 8`
//- `chessboard[i]` 仅包含 `"."、"O"` 和 `"X"`
//
// Related Topics 广度优先搜索 数组 矩阵 👍 65 👎 0

package leetcode.editor.cn; //如果你的算法题是中文的，后缀就是cn，如果是英文的就是en

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @author  YourName
 * @date 2023-06-21 23:14:57
 */
public class FHi6rV {
    public static void main(String[] args) {
        Solution solution = new FHi6rV().new Solution();
        System.out.println(solution.flipChess(new String[]{
                ".......", "X......", ".O.....", "..O...X", "...OOOX", "....O..", "...OOOX"
        }));
    }
//leetcode submit region begin(Prohibit modification and deletion)

    class Solution {
        private int m;
        private int n;
        private String[] chessboard;

        public int flipChess(String[] chessboard) {
            m = chessboard.length;
            n = chessboard[0].length();
            this.chessboard = chessboard;
            int ans = 0;
            for (int i = 0; i < m; ++i) {
                for (int j = 0; j < n; ++j) {
                    if (chessboard[i].charAt(j) == '.') {
                        ans = Math.max(ans, bfs(i, j));
                    }
                }
            }
            return ans;
        }

        private int bfs(int i, int j) {
            Deque<int[]> q = new ArrayDeque<>();
            q.offer(new int[]{i, j});
            char[][] g = new char[m][0];
            for (int k = 0; k < m; ++k) {
                g[k] = chessboard[k].toCharArray();
            }
            g[i][j] = 'X';
            int cnt = 0;
            while (!q.isEmpty()) {
                int[] p = q.poll();
                i = p[0];
                j = p[1];
                for (int a = -1; a <= 1; ++a) {
                    for (int b = -1; b <= 1; ++b) {
                        if (a == 0 && b == 0) {
                            continue;
                        }
                        int x = i + a, y = j + b;
                        while (x >= 0 && x < m && y >= 0 && y < n && g[x][y] == 'O') {
                            x += a;
                            y += b;
                        }
                        if (x >= 0 && x < m && y >= 0 && y < n && g[x][y] == 'X') {
                            x -= a;
                            y -= b;
                            cnt += Math.max(Math.abs(x - i), Math.abs(y - j));
                            while (x != i || y != j) {
                                g[x][y] = 'X';
                                q.offer(new int[]{x, y});
                                x -= a;
                                y -= b;
                            }
                        }
                    }
                }
            }
            return cnt;
        }
    }

//leetcode submit region end(Prohibit modification and deletion)
}

