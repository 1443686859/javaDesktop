/**
给你一个 二进制 字符串 s 和一个整数 k。 

 如果一个 二进制字符串 满足以下任一条件，则认为该字符串满足 k 约束： 

 
 字符串中 0 的数量最多为 k。 
 字符串中 1 的数量最多为 k。 
 

 返回一个整数，表示 s 的所有满足 k 约束 的子字符串的数量。 

 

 示例 1： 

 
 输入：s = "10101", k = 1 
 

 输出：12 

 解释： 

 s 的所有子字符串中，除了 "1010"、"10101" 和 "0101" 外，其余子字符串都满足 k 约束。 

 示例 2： 

 
 输入：s = "1010101", k = 2 
 

 输出：25 

 解释： 

 s 的所有子字符串中，除了长度大于 5 的子字符串外，其余子字符串都满足 k 约束。 

 示例 3： 

 
 输入：s = "11111", k = 1 
 

 输出：15 

 解释： 

 s 的所有子字符串都满足 k 约束。 

 

 提示： 

 
 1 <= s.length <= 50 
 1 <= k <= s.length 
 s[i] 是 '0' 或 '1'。 
 

 👍 36 👎 0

*/
package leetcode.editor.cn; //如果你的算法题是中文的，后缀就是cn，如果是英文的就是en
 /**
 * @author  YourName
 * @date 2024-11-12 21:25:31
 */
public class CountSubstringsThatSatisfyKConstraintI{
    public static void main(String[] args) {
        Solution solution = new CountSubstringsThatSatisfyKConstraintI().new Solution();
        System.out.println(solution.countKConstraintSubstrings("10101", 1));
   }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int countKConstraintSubstrings(String s, int k) {
        int[] count0 = new int[s.length() + 1];
        count0[0] = -1;
        int[] count1 = new int[s.length() + 1];
        count1[0] = -1;
        int c0 = 0;
        int c1 = 0;
        int result = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '0') {
                c0++;
                count0[c0] = i;
            } else {
                c1++;
                count1[c1] = i;
            }
            int min = Math.min(count0[Math.max(c0 - k, 0)], count1[Math.max(c1 - k, 0)]);
            result += i - min;
        }
        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}