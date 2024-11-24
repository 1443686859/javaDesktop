/**
给你一个字符串 s ，你需要将它分割成一个或者更多的 平衡 子字符串。比方说，s == "ababcc" 那么 ("abab", "c", "c") ，(
"ab", "abc", "c") 和 ("ababcc") 都是合法分割，但是 ("a", "bab", "cc") ，("aba", "bc", "c") 和 (
"ab", "abcc") 不是，不平衡的子字符串用粗体表示。 

 请你返回 s 最少 能分割成多少个平衡子字符串。 

 注意：一个 平衡 字符串指的是字符串中所有字符出现的次数都相同。 

 

 示例 1： 

 
 输入：s = "fabccddg" 
 

 输出：3 

 解释： 

 我们可以将 s 分割成 3 个子字符串：("fab, "ccdd", "g") 或者 ("fabc", "cd", "dg") 。 

 示例 2： 

 
 输入：s = "abababaccddb" 
 

 输出：2 

 解释： 

 我们可以将 s 分割成 2 个子字符串：("abab", "abaccddb") 。 

 

 提示： 

 
 1 <= s.length <= 1000 
 s 只包含小写英文字母。 
 

 👍 0 👎 0

*/
package leetcode.editor.cn; //如果你的算法题是中文的，后缀就是cn，如果是英文的就是en

import java.util.Arrays;

/**
 * @author  YourName
 * @date 2024-05-16 22:50:59
 */
public class MinimumSubstringPartitionOfEqualCharacterFrequency{
    public static void main(String[] args) {
        Solution solution = new MinimumSubstringPartitionOfEqualCharacterFrequency().new Solution();
        System.out.println(solution.minimumSubstringsInPartition("fabccddg"));
   }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
        int[] ans;
    public int minimumSubstringsInPartition(String s) {
        int n = s.length();
        int[] ans = new int[n + 1];
        Arrays.fill(ans, Integer.MAX_VALUE);
        ans[0] = 0;
        char[] c = s.toCharArray();
        for (int i = 0; i < n; i++) {
            int max = 0;
            int[] count = new int[26];
            int sum = 0;
            for (int j = i; j >= 0; j--) {
                sum += count[c[j] - 'a']++ == 0 ? 1 : 0;
                max = Math.max(max, count[c[j] - 'a']);
                if (sum * max == i -j + 1) {
                    ans[i + 1] =  Math.min(ans[j] + 1, ans[i + 1]);
                }
            }
        }
//        int max = 0;
//        int[] count = new int[26];
//        int sum = 0;
//        for (int j = index; j >= 0; j--) {
//            sum += count[c[j] - 'a']++ == 0 ? 1 : 0;
//            max = Math.max(max, count[c[j] - 'a']);
//            if (sum * max == index -j + 1) {
//                result = Math.min(result, 1 + dfs(c, j - 1));
//            }
//        }
//        ans[index] = result;
//        return result;
        return ans[n];
    }

}
//leetcode submit region end(Prohibit modification and deletion)

}