//我们从一块字母板上的位置 (0, 0) 出发，该坐标对应的字符为 board[0][0]。 
//
// 在本题里，字母板为board = ["abcde", "fghij", "klmno", "pqrst", "uvwxy", "z"]，如下所示。 
//
// 
//
// 我们可以按下面的指令规则行动： 
//
// 
// 如果方格存在，'U' 意味着将我们的位置上移一行； 
// 如果方格存在，'D' 意味着将我们的位置下移一行； 
// 如果方格存在，'L' 意味着将我们的位置左移一列； 
// 如果方格存在，'R' 意味着将我们的位置右移一列； 
// '!' 会把在我们当前位置 (r, c) 的字符 board[r][c] 添加到答案中。 
// 
//
// （注意，字母板上只存在有字母的位置。） 
//
// 返回指令序列，用最小的行动次数让答案和目标 target 相同。你可以返回任何达成目标的路径。 
//
// 
//
// 示例 1： 
//
// 
//输入：target = "leet"
//输出："DDR!UURRR!!DDD!"
// 
//
// 示例 2： 
//
// 
//输入：target = "code"
//输出："RR!DDRR!UUL!R!"
// 
//
// 
//
// 提示： 
//
// 
// 1 <= target.length <= 100 
// target 仅含有小写英文字母。 
// 
//
// Related Topics 哈希表 字符串 👍 50 👎 0

package leetcode.editor.cn; //如果你的算法题是中文的，后缀就是cn，如果是英文的就是en

import java.util.ArrayList;
import java.util.List;

/**
 * @author  YourName
 * @date 2023-02-12 00:38:51
 */
public class AlphabetBoardPath{
    public static void main(String[] args) {
        Solution solution = new AlphabetBoardPath().new Solution();
   }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String alphabetBoardPath(String target) {
        int[] pre = new int[2];
        String[] d = new String[]{"U", "R", "L", "D"};
        StringBuilder result = new StringBuilder();
        for (Character c : target.toCharArray()) {
            int length = c - 'a';;
            int row = length / 5;
            int col = length % 5;

            int cost = Math.max(4, row) - pre[0];
            if (row == 5 && pre[1] == col) {
                cost++;
            }
//            if (cost < 0) {
//                result.append(d[0].repeat(Math.abs(cost)));
//            } else if (cost > 0) {
//                result.append(d[3].repeat(Math.abs(cost)));
//            }
//            cost = col - pre[1];
//            if (cost < 0) {
//                result.append(d[2].repeat(Math.abs(cost)));
//            } else if (cost > 0) {
//                result.append(d[1].repeat(Math.abs(cost)));
//            }

            if (row == 5 && pre[0] < row) {
                result.append(d[3]);
            }

            pre[0] = row;
            pre[1] = col;
            result.append("!");
        }
        return result.toString();
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}