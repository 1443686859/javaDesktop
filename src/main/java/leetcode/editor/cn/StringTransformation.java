//给你两个长度都为 n 的字符串 s 和 t 。你可以对字符串 s 执行以下操作： 
//
// 
// 将 s 长度为 l （0 < l < n）的 后缀字符串 删除，并将它添加在 s 的开头。 比方说，s = 'abcd' ，那么一次操作中，你可以删除后缀
// 'cd' ，并将它添加到 s 的开头，得到 s = 'cdab' 。 
// 
//
// 给你一个整数 k ，请你返回 恰好 k 次操作将 s 变为 t 的方案数。 
//
// 由于答案可能很大，返回答案对 10⁹ + 7 取余 后的结果。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "abcd", t = "cdab", k = 2
//输出：2
//解释：
//第一种方案：
//第一次操作，选择 index = 3 开始的后缀，得到 s = "dabc" 。
//第二次操作，选择 index = 3 开始的后缀，得到 s = "cdab" 。
//
//第二种方案：
//第一次操作，选择 index = 1 开始的后缀，得到 s = "bcda" 。
//第二次操作，选择 index = 1 开始的后缀，得到 s = "cdab" 。
// 
//
// 示例 2： 
//
// 
//输入：s = "ababab", t = "ababab", k = 1
//输出：2
//解释：
//第一种方案：
//选择 index = 2 开始的后缀，得到 s = "ababab" 。
//
//第二种方案：
//选择 index = 4 开始的后缀，得到 s = "ababab" 。
// 
//
// 
//
// 提示： 
//
// 
// 2 <= s.length <= 5 * 10⁵ 
// 1 <= k <= 10¹⁵ 
// s.length == t.length 
// s 和 t 都只包含小写英文字母。 
// 
//
// Related Topics 数学 字符串 动态规划 字符串匹配 👍 24 👎 0

package leetcode.editor.cn; //如果你的算法题是中文的，后缀就是cn，如果是英文的就是en


import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;

/**
 * @author  YourName
 * @date 2023-09-23 20:57:05
 */
public class StringTransformation{
    public static void main(String[] args) {
        Solution solution = new StringTransformation().new Solution();
        System.out.println(solution.maximumSumOfHeights(Arrays.asList(528947205,446572672,245562434,29067688,230940022,237916991,546243960,898360263,110809423,616740838,141189952,272319413,173945434,944209607,709147298,291516002,697109513,945372506,321357175,271013697,140905315,154122459,745184252,379717676,468969774,302949377,261867781,933328834,791272529,583341139,83259489,304055888,873655860,808520318,194518325,703266873,281331446,927210596,422874036,902047413,774474564,809609201,493545785,415250991,884864225,392444408,610159103,903379193,816412790,591760883,361140449,759810143,588717612,694204370,42665571,517507625,702706955,952884579)));
   }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int numberOfWays(String s, String t, long k) {
        int n = s.length();
        int c = kmpSearch(s + s.substring(0, n - 1), t);
        long[][] m = {
                {c - 1, c},
                {n - c, n - 1- c}
        };
        m = fastPow(m, k);
        return s.equals(t) ? (int) m[0][0] : (int)m[0][1];
    }
    public int[] kmp(String pattern) {
        int n = pattern.length();
        int[] result = new int[pattern.length()];
        int c = 0;
        for (int i = 1; i < n; i++) {
            char current = pattern.charAt(i);
            while (c > 0 && pattern.charAt(c) != current) {
                c = result[c - 1];
            }
            if (pattern.charAt(c) == current) {
                c++;
            }
            result[i] = c;
        }
        return result;
    }
    public int kmpSearch(String text, String pattern) {
        int[] match = kmp(pattern);
        int lenP = pattern.length();
        int result = 0;
        int c = 0;
        for (int i = 0; i < text.length(); i++) {
            char current = text.charAt(i);
            while (c > 0 && pattern.charAt(c) != current) {
                c = match[c - 1];
            }
            if (pattern.charAt(c) == current) {
                c++;
            }
            if (c == lenP) {
                result++;
                c = match[c - 1];
            }
        }
        return result;
    }
    private static final long MOD = (long) 1e9 + 7;

    private long[][] multiply(long[][] a, long[][] b) {
        long[][] result = new long[a.length][b[0].length];
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[0].length; j++) {
                for (int z = 0; z < b.length; z++) {
                    result[i][j] = (result[i][j] + (a[i][z] * b[z][j]) % MOD) % MOD;
                }
            }
        }
        return result;
    }


    private long[][] fastPow(long[][] a, long n) {
        long[][] result = {{1,0}, {0, 1}};
        while (n > 0) {
            if ((n & 1) == 1) {
                result = multiply(result, a);
            }
            a = multiply(a, a);
            n >>= 1;
        }
        return result;
    }
    public long maximumSumOfHeights(List<Integer> maxHeights) {
        int n = maxHeights.size();
       long result = 0;
       long[] pre = new long[n + 1];
        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            while (!deque.isEmpty() && maxHeights.get(i) <= maxHeights.get(deque.peek())) {
              deque.poll();
            }
            int index = (deque.isEmpty()) ? -1 : deque.peek();
            pre[i + 1] = 1l* (i - index) * maxHeights.get(i) + (deque.isEmpty() ? 0 : pre[index + 1]);
            deque.push(i);
        }
        long[] after = new long[n + 1];
        deque.clear();
        for (int i = n - 1; i >= 0; i--) {
            while (!deque.isEmpty() && maxHeights.get(i) <= maxHeights.get(deque.peek())) {
                deque.poll();
            }
            int index = (deque.isEmpty()) ? n : deque.peek();
            after[i] = 1l* (index - i) * maxHeights.get(i) + (deque.isEmpty() ? 0 : after[index]);
            deque.push(i);
        }

        for (int i = 0; i < n; i++) {
            if (pre[i + 1] + after[i] - maxHeights.get(i) < 0) {
                System.out.println("SSS");
            }
            result = Math.max(result, pre[i + 1] + after[i] - maxHeights.get(i));
        }
        return result;
    }

}
//leetcode submit region end(Prohibit modification and deletion)

}