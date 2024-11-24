//电子游戏“辐射4”中，任务 “通向自由” 要求玩家到达名为 “Freedom Trail Ring” 的金属表盘，并使用表盘拼写特定关键词才能开门。 
//
// 给定一个字符串 ring ，表示刻在外环上的编码；给定另一个字符串 key ，表示需要拼写的关键词。您需要算出能够拼写关键词中所有字符的最少步数。 
//
// 最初，ring 的第一个字符与 12:00 方向对齐。您需要顺时针或逆时针旋转 ring 以使 key 的一个字符在 12:00 方向对齐，然后按下中心按
//钮，以此逐个拼写完 key 中的所有字符。 
//
// 旋转 ring 拼出 key 字符 key[i] 的阶段中： 
//
// 
// 您可以将 ring 顺时针或逆时针旋转 一个位置 ，计为1步。旋转的最终目的是将字符串 ring 的一个字符与 12:00 方向对齐，并且这个字符必须等于
//字符 key[i] 。 
// 如果字符 key[i] 已经对齐到12:00方向，您需要按下中心按钮进行拼写，这也将算作 1 步。按完之后，您可以开始拼写 key 的下一个字符（下一阶段
//）, 直至完成所有拼写。 
// 
//
// 
//
// 示例 1： 
//
// 
//
//
// 
//
//
// 
//输入: ring = "godding", key = "gd"
//输出: 4
//解释:
// 对于 key 的第一个字符 'g'，已经在正确的位置, 我们只需要1步来拼写这个字符。 
// 对于 key 的第二个字符 'd'，我们需要逆时针旋转 ring "godding" 2步使它变成 "ddinggo"。
// 当然, 我们还需要1步进行拼写。
// 因此最终的输出是 4。
// 
//
// 示例 2: 
//
// 
//输入: ring = "godding", key = "godding"
//输出: 13
// 
//
// 
//
// 提示： 
//
// 
// 1 <= ring.length, key.length <= 100 
// ring 和 key 只包含小写英文字母 
// 保证 字符串 key 一定可以由字符串 ring 旋转拼出 
// 
//
// Related Topics 深度优先搜索 广度优先搜索 字符串 动态规划 👍 312 👎 0

package leetcode.editor.cn; //如果你的算法题是中文的，后缀就是cn，如果是英文的就是en

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author  YourName
 * @date 2024-01-29 22:35:06
 */
public class FreedomTrail{
    public static void main(String[] args) {
        Solution solution = new FreedomTrail().new Solution();
        System.out.println(solution.findRotateSteps("godding"
                ,"gd"));
   }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    int[][] result;
    int m;
        public int findRotateSteps(String ring, String key) {
        List<Integer>[] c = new List[26];
            Arrays.setAll(c, e -> new ArrayList<>());
            int n = key.length();
            m = ring.length();
            result = new int[n][m];
            for (int[] a : result) {
                Arrays.fill(a, - 1);
            }
            for (int i = 0; i < m; i++) {
                int index = ring.charAt(i) - 'a';
                c[index].add(i);
            }
            return dfs(0, c, key, 0);
    }
    public int dfs(int index, List<Integer>[] c, String key, int preIndex) {
            if (index == key.length()) {
                return 0;
            }
            if (result[index][preIndex] != -1) {
                return result[index][preIndex];
            }
            int currentIndex = key.charAt(index) - 'a';
            int min = Integer.MAX_VALUE;
            for (Integer integer : c[currentIndex]) {
                int left = preIndex - integer < 0 ? (m + preIndex - integer) : (preIndex - integer);
                int right = integer - preIndex < 0 ? (m + integer - preIndex) : (integer - preIndex);
                min = Math.min(min, Math.min(left, right) + 1 + dfs(index + 1, c ,key, integer));
            }
            result[index][preIndex] = min;
            return min;
    }

}
//leetcode submit region end(Prohibit modification and deletion)

}