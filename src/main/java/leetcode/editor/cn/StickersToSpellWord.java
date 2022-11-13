//我们有 n 种不同的贴纸。每个贴纸上都有一个小写的英文单词。 
//
// 您想要拼写出给定的字符串 target ，方法是从收集的贴纸中切割单个字母并重新排列它们。如果你愿意，你可以多次使用每个贴纸，每个贴纸的数量是无限的。 
//
// 返回你需要拼出 target 的最小贴纸数量。如果任务不可能，则返回 -1 。 
//
// 注意：在所有的测试用例中，所有的单词都是从 1000 个最常见的美国英语单词中随机选择的，并且 target 被选择为两个随机单词的连接。 
//
// 
//
// 示例 1： 
//
// 
//输入： stickers = ["with","example","science"], target = "thehat"
//输出：3
//解释：
//我们可以使用 2 个 "with" 贴纸，和 1 个 "example" 贴纸。
//把贴纸上的字母剪下来并重新排列后，就可以形成目标 “thehat“ 了。
//此外，这是形成目标字符串所需的最小贴纸数量。
// 
//
// 示例 2: 
//
// 
//输入：stickers = ["notice","possible"], target = "basicbasic"
//输出：-1
//解释：我们不能通过剪切给定贴纸的字母来形成目标“basicbasic”。 
//
// 
//
// 提示: 
//
// 
// n == stickers.length 
// 1 <= n <= 50 
// 1 <= stickers[i].length <= 10 
// 1 <= target <= 15 
// stickers[i] 和 target 由小写英文单词组成 
// 
// Related Topics 位运算 动态规划 回溯 状态压缩 👍 183 👎 0

package leetcode.editor.cn; //如果你的算法题是中文的，后缀就是cn，如果是英文的就是en

import java.util.Arrays;

/**
 * @author  YourName
 * @date 2022-05-14 16:58:31
 */
public class StickersToSpellWord{
    public static void main(String[] args) {
        Solution solution = new StickersToSpellWord().new Solution();
   }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
        int N;
        int M;
        int INF = 50;
        int[] state;
        String[] stickers;
        String target;
    public int minStickers(String[] stickers, String target) {
        N = target.length();
        M = 1 << N;
        this.stickers = stickers;
        this.target = target;
        state = new int[M - 1];
        Arrays.fill(state, -1);
        int ans = dfs(0);
        return ans == INF ? - 1: ans;
    }
    public int dfs(int currentStatus) {
        if (currentStatus == M - 1) {
            // 递归结束， 最后一个状态(1<< N) - 1表示所有位置都有
            return 0;
        }
        if (state[currentStatus] != -1) {
            return state[currentStatus];
        }
        int defaultAns = INF;
        for (String s : stickers) {
            // 初始化临时状态
            int tempStatus = currentStatus;
            for (char c : s.toCharArray()) {
                for (int i = 0; i < N; i++) {
                    if (target.charAt(i) == c && ((tempStatus >> i) & 1) == 0 ) {
                        // 目标位置i的字符在当前的字符串s中包含，且当前状态下对应字符位置为填充表示还是空的
                        tempStatus |= (1 << i);
                        // 进行填充
                        break;
                        // 跳过当前c
                    }
                }
            }
            // tempStatus 表示选中当前字符串s之后的状态
            if (tempStatus != currentStatus) {
                // 表示当前选择是有效选择能向答案迈进， 如果当前字符串没有目标字符串的任何字符或者已经选完则不会向答案迈进
                defaultAns = Math.min(defaultAns, dfs(tempStatus) + 1);
                // 加上当前操作步骤
            }
        }
        return state[currentStatus] = defaultAns;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}