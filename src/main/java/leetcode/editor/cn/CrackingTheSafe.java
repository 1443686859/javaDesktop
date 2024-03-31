//有一个需要密码才能打开的保险箱。密码是 n 位数, 密码的每一位是 k 位序列 0, 1, ..., k-1 中的一个 。 
//
// 你可以随意输入密码，保险箱会自动记住最后 n 位输入，如果匹配，则能够打开保险箱。 
//
// 举个例子，假设密码是 "345"，你可以输入 "012345" 来打开它，只是你输入了 6 个字符. 
//
// 请返回一个能打开保险箱的最短字符串。 
//
// 
//
// 示例1: 
//
// 输入: n = 1, k = 2
//输出: "01"
//说明: "10"也可以打开保险箱。
// 
//
// 
//
// 示例2: 
//
// 输入: n = 2, k = 2
//输出: "00110"
//说明: "01100", "10011", "11001" 也能打开保险箱。
// 
//
// 
//
// 提示： 
//
// 
// n 的范围是 [1, 4]。 
// k 的范围是 [1, 10]。 
// k^n 最大可能为 4096。 
// 
//
// 
//
// Related Topics 深度优先搜索 图 欧拉回路 👍 199 👎 0

package leetcode.editor.cn; //如果你的算法题是中文的，后缀就是cn，如果是英文的就是en

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author  YourName
 * @date 2023-01-10 18:54:25
 */
public class CrackingTheSafe{
    public static void main(String[] args) {
        Solution solution = new CrackingTheSafe().new Solution();
   }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
        Set<Integer> v;
        int k;
        int n;
        int mod;
        StringBuilder result;
    public String crackSafe(int N, int K) {
        n = N;
        k = K;
        v = new HashSet<>();
        result = new StringBuilder();
        mod = (int)Math.pow(k, n - 1);
        dfs(0);
        for (int i = 1; i < n; i++) {
            result.append("0");
        }
        return result.toString();
    }
    public void dfs(int u) {
        for (int i = 0; i < k; i++) {
            int current = u * k + i;
            if (v.contains(current)) continue;
            v.add(current);
            dfs(current % mod);
            result.append(i);
        }
    }
}
    class Solution2 {
        int k;
        int n;
        int mod;
        StringBuilder result;
        public String crackSafe(int N, int K) {
            n = N;
            k = K;
            result = new StringBuilder();
            mod = (int)Math.pow(k, n - 1);
            int[] count = new int[mod];
            Arrays.fill(count, k);
            for (int i = 1; i < n; i++) {
                result.append("0");
            }
            int max = (int) Math.pow(k, n);
            for (int i = 0, start = 0; i < max; i++) {
                int next = -- count[start];
                result.append(next);
                start = (start * k + next) % mod;
            }
            return result.toString();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}