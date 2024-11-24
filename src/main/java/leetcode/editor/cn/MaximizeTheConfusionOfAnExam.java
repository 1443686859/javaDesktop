//一位老师正在出一场由 n 道判断题构成的考试，每道题的答案为 true （用 'T' 表示）或者 false （用 'F' 表示）。老师想增加学生对自己做出
//答案的不确定性，方法是 最大化 有 连续相同 结果的题数。（也就是连续出现 true 或者连续出现 false）。 
//
// 给你一个字符串 answerKey ，其中 answerKey[i] 是第 i 个问题的正确结果。除此以外，还给你一个整数 k ，表示你能进行以下操作的最
//多次数： 
//
// 
// 每次操作中，将问题的正确答案改为 'T' 或者 'F' （也就是将 answerKey[i] 改为 'T' 或者 'F' ）。 
// 
//
// 请你返回在不超过 k 次操作的情况下，最大 连续 'T' 或者 'F' 的数目。 
//
// 
//
// 示例 1： 
//
// 
//输入：answerKey = "TTFF", k = 2
//输出：4
//解释：我们可以将两个 'F' 都变为 'T' ，得到 answerKey = "TTTT" 。
//总共有四个连续的 'T' 。
// 
//
// 示例 2： 
//
// 
//输入：answerKey = "TFFT", k = 1
//输出：3
//解释：我们可以将最前面的 'T' 换成 'F' ，得到 answerKey = "FFFT" 。
//或者，我们可以将第二个 'T' 换成 'F' ，得到 answerKey = "TFFF" 。
//两种情况下，都有三个连续的 'F' 。
// 
//
// 示例 3： 
//
// 
//输入：answerKey = "TTFTTFTT", k = 1
//输出：5
//解释：我们可以将第一个 'F' 换成 'T' ，得到 answerKey = "TTTTTFTT" 。
//或者我们可以将第二个 'F' 换成 'T' ，得到 answerKey = "TTFTTTTT" 。
//两种情况下，都有五个连续的 'T' 。
// 
//
// 
//
// 提示： 
//
// 
// n == answerKey.length 
// 1 <= n <= 5 * 10⁴ 
// answerKey[i] 要么是 'T' ，要么是 'F' 
// 1 <= k <= n 
// 
// Related Topics 字符串 二分查找 前缀和 滑动窗口 👍 143 👎 0

package leetcode.editor.cn; //如果你的算法题是中文的，后缀就是cn，如果是英文的就是en

import java.util.HashMap;
import java.util.Map;

/**
 * @author  YourName
 * @date 2022-03-29 21:39:03
 */
public class MaximizeTheConfusionOfAnExam{
    public static void main(String[] args) {
        Solution solution = new MaximizeTheConfusionOfAnExam().new Solution();
   }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maxConsecutiveAnswers1(String answerKey, int k) {
        int n = answerKey.length();
        int fCount = 0;
        int tCount = 0;
        int[] f = new int[n + 1];
        int[] t = new int[n + 1];
        f[0] = -1;
        t[0] = - 1;

        int ans = 0;
        for (int i = 0; i < n; i++) {
            if (answerKey.charAt(i) == 'F') {
                fCount++;
                f[fCount] = i;
            } else {
                tCount++;
                t[tCount] = i;
            }
            ans = Math.max(ans, Math.max(i - t[Math.max(tCount - k, 0)], i - f[Math.max(fCount - k, 0)]));
        }
        return ans;
    }
    public int maxConsecutiveAnswers(String answerKey, int k) {
        char[] c = answerKey.toCharArray();
        int n = answerKey.length();
        int ans = 0;
        int[] count = new int[2];
        for (int left = 0, right = 0; right < n;) {
            count[c[right++] >> 1 & 1]++;
            while (count[0] > k && count[1] > k) {
                count[c[left++] >> 1 & 1]--;
            }
            ans = Math.max(ans, right - left);
        }
        return ans;
    }


}
//leetcode submit region end(Prohibit modification and deletion)

}