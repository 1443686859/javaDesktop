/**
给你两个 正 整数 n 和 k 。 

 如果一个整数 x 满足以下条件，那么它被称为 k 回文 整数 。 

 
 x 是一个 回文整数 。 
 x 能被 k 整除。 
 

 如果一个整数的数位重新排列后能得到一个 k 回文整数 ，那么我们称这个整数为 好 整数。比方说，k = 2 ，那么 2020 可以重新排列得到 2002 ，2
002 是一个 k 回文串，所以 2020 是一个好整数。而 1010 无法重新排列数位得到一个 k 回文整数。 

 请你返回 n 个数位的整数中，有多少个 好 整数。 

 注意 ，任何整数在重新排列数位之前或者之后 都不能 有前导 0 。比方说 1010 不能重排列得到 101 。 

 

 示例 1： 

 
 输入：n = 3, k = 5 
 

 输出：27 

 解释： 

 部分好整数如下： 

 
 551 ，因为它可以重排列得到 515 。 
 525 ，因为它已经是一个 k 回文整数。 
 

 示例 2： 

 
 输入：n = 1, k = 4 
 

 输出：2 

 解释： 

 两个好整数分别是 4 和 8 。 

 示例 3： 

 
 输入：n = 5, k = 6 
 

 输出：2468 

 

 提示： 

 
 1 <= n <= 10 
 1 <= k <= 9 
 

 👍 2 👎 0

*/
package leetcode.editor.cn; //如果你的算法题是中文的，后缀就是cn，如果是英文的就是en

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author  YourName
 * @date 2024-09-02 19:09:11
 */
public class FindTheCountOfGoodIntegers{
    public static void main(String[] args) {
        Solution solution = new FindTheCountOfGoodIntegers().new Solution();
        System.out.println(solution.countGoodIntegers(5,6));
   }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
        int n;
        int k;
        int result;
        Set<String> set;
    int[] factorial;
    public long countGoodIntegers(int n, int k) {
        this.n = n;
        result = 0;
        this.k = k;
        factorial = new int[n + 1];
        factorial[0] = 1;
        for (int i = 1; i <= n; i++) {
            factorial[i] = factorial[i - 1] * i;
        }
        set = new HashSet<>();
        dfs(new int[10], n - 1, 0);
//        System.out.println(countGoodIntegers1(5,6));
        return result;
    }
    public void dfs(int[] count, int index, long mod) {
        if (index < n / 2) {
            String key = Arrays.stream(count).mapToObj(Integer::toString).collect(Collectors.joining(","));
            if (mod % k == 0 && !set.contains(key)) {
                set.add(key);
                int cnt0 = count[0];
                long base = (n - cnt0) * factorial[n - 1];
                for (int i = 0; i < 10; i++) {
                    base /= factorial[count[i]];
                }
                result += base;
                return;
            }
            return ;
        }
        int start = index == n - 1 ? 1 : 0;
        int c = index == n / 2  && (n & 1) == 1 ? 1 : 2;
        for (int i = start ; i <= 9; i++) {
            count[i] += c;
            long currentMod = (long) (mod + i * Math.pow(10, index) + (c != 1 ? (i * Math.pow(10, n - 1 - index)) :0));
            dfs(count, index - 1, currentMod);
            count[i] -= c;
        }
    }
    public long pow(int n) {
        long result = 1L;
        while (n > 0) {
            result *= n;
            n--;
        }
        return result;
    }

        public long countGoodIntegers1(int n, int k) {
            int[] factorial = new int[n + 1];
            factorial[0] = 1;
            int count = 0;
            for (int i = 1; i <= n; i++) {
                factorial[i] = factorial[i - 1] * i;
            }

            long ans = 0;
            Set<String> vis = new HashSet<>();
            int base = (int) Math.pow(10, (n - 1) / 2);
            for (int i = base; i < base * 10; i++) { // 枚举回文数左半边
                String s = Integer.toString(i);
                s += new StringBuilder(s).reverse().substring(n % 2);
                if (Long.parseLong(s) % k > 0) { // 回文数不能被 k 整除
                    continue;
                }

                char[] sortedS = s.toCharArray();
                Arrays.sort(sortedS);
                if (!vis.add(new String(sortedS))) { // 不能重复统计
                    continue;
                }
                count++;
                int[] cnt = new int[10];
                for (char c : sortedS) {
                    cnt[c - '0']++;
                }
                int res = (n - cnt[0]) * factorial[n - 1];
                for (int c : cnt) {
                    res /= factorial[c];
                }
                ans += res;
            }
            return ans;
        }

}
//leetcode submit region end(Prohibit modification and deletion)

}