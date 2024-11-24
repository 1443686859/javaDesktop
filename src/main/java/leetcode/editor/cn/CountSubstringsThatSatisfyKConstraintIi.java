/**
给你一个 二进制 字符串 s 和一个整数 k。 

 另给你一个二维整数数组 queries ，其中 queries[i] = [li, ri] 。 

 如果一个 二进制字符串 满足以下任一条件，则认为该字符串满足 k 约束： 

 
 字符串中 0 的数量最多为 k。 
 字符串中 1 的数量最多为 k。 
 

 返回一个整数数组 answer ，其中 answer[i] 表示 s[li..ri] 中满足 k 约束 的 子字符串 的数量。 

 

 示例 1： 

 
 输入：s = "0001111", k = 2, queries = [[0,6]] 
 

 输出：[26] 

 解释： 

 对于查询 [0, 6]， s[0..6] = "0001111" 的所有子字符串中，除 s[0..5] = "000111" 和 s[0..6] = "000
1111" 外，其余子字符串都满足 k 约束。 

 示例 2： 

 
 输入：s = "010101", k = 1, queries = [[0,5],[1,4],[2,3]] 
 

 输出：[15,9,3] 

 解释： 

 s 的所有子字符串中，长度大于 3 的子字符串都不满足 k 约束。 

 

 提示： 

 
 1 <= s.length <= 10⁵ 
 s[i] 是 '0' 或 '1' 
 1 <= k <= s.length 
 1 <= queries.length <= 10⁵ 
 queries[i] == [li, ri] 
 0 <= li <= ri < s.length 
 所有查询互不相同 
 

 👍 49 👎 0

*/
package leetcode.editor.cn; //如果你的算法题是中文的，后缀就是cn，如果是英文的就是en
 /**
 * @author  YourName
 * @date 2024-11-13 19:57:42
 */
public class CountSubstringsThatSatisfyKConstraintIi{
    public static void main(String[] args) {
        Solution solution = new CountSubstringsThatSatisfyKConstraintIi().new Solution();
        System.out.println(solution.countKConstraintSubstrings("0001111", 2, new int[][]{
                {0, 6}
        }));
   }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public long[] countKConstraintSubstrings(String s, int k, int[][] queries) {
        char[] chars = s.toCharArray();
        int[] count = new int[2];
        long[] sum = new long[chars.length + 1];
        int l = 0;
        int[] left = new int[s.length()];
        for (int i = 0; i < s.length(); i++) {
            count[chars[i] & 1] ++;
            while (count[0] > k && count[1] > k) {
                count[chars[l++] & 1]--;
            }
            sum[i + 1] = sum[i] + i - l + 1;
            left[i] = l;
        }
        long[] result = new long[queries.length];
        int index = 0;
        for (int[] query : queries) {
            l = query[0];
            int r = query[1];
            int lL = l;
            int lR = r;
            while (lL <= lR) {
                int mid = (lL + lR) / 2;
                if (left[mid] > l) {
                    lR = mid - 1;
                } else {
                    lL = mid + 1;
                }
            }
            result[index++] = sum[r + 1] - sum[lL] + (long)(lL - l + 1) * (lL - l) / 2;
        }
        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}