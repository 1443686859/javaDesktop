//给你一个字符串 s ，它仅包含字符 'a' 和 'b' 。 
//
// 你可以删除 s 中任意数目的字符，使得 s 平衡 。当不存在下标对 (i,j) 满足 i < j ，且 s[i] = 'b' 的同时 s[j]= 'a' 
//，此时认为 s 是 平衡 的。 
//
// 请你返回使 s 平衡 的 最少 删除次数。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "aababbab"
//输出：2
//解释：你可以选择以下任意一种方案：
//下标从 0 开始，删除第 2 和第 6 个字符（"aababbab" -> "aaabbb"），
//下标从 0 开始，删除第 3 和第 6 个字符（"aababbab" -> "aabbbb"）。
// 
//
// 示例 2： 
//
// 
//输入：s = "bbaaaaabb"
//输出：2
//解释：唯一的最优解是删除最前面两个字符。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 10⁵ 
// s[i] 要么是 'a' 要么是 'b' 。 
// 
//
// Related Topics 栈 字符串 动态规划 👍 148 👎 0

package leetcode.editor.cn; //如果你的算法题是中文的，后缀就是cn，如果是英文的就是en
 /**
 * @author  YourName
 * @date 2023-03-06 21:48:53
 */
public class MinimumDeletionsToMakeStringBalanced{
    public static void main(String[] args) {
        Solution solution = new MinimumDeletionsToMakeStringBalanced().new Solution();
   }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int minimumDeletions(String s) {
        int countB = 0;
        int n = s.length();
        for (int i = n - 1; i >= 0; i--) {
            countB += s.charAt(i) - 'b';
        }
        int ans = countB;
        for (int i = n - 1; i >= 0; i--) {
            countB -= 2 * (s.charAt(i) - 'a') - 1;
            ans = Math.min(ans, countB);
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}