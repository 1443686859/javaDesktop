/**
给你一个由字符 'a'、'b'、'c' 组成的字符串 s 和一个非负整数 k 。每分钟，你可以选择取走 s 最左侧 还是 最右侧 的那个字符。 

 你必须取走每种字符 至少 k 个，返回需要的 最少 分钟数；如果无法取到，则返回 -1 。 

 

 示例 1： 

 
输入：s = "aabaaaacaabc", k = 2
输出：8
解释：
从 s 的左侧取三个字符，现在共取到两个字符 'a' 、一个字符 'b' 。
从 s 的右侧取五个字符，现在共取到四个字符 'a' 、两个字符 'b' 和两个字符 'c' 。
共需要 3 + 5 = 8 分钟。
可以证明需要的最少分钟数是 8 。
 

 示例 2： 

 
输入：s = "a", k = 1
输出：-1
解释：无法取到一个字符 'b' 或者 'c'，所以返回 -1 。
 

 

 提示： 

 
 1 <= s.length <= 10⁵ 
 s 仅由字母 'a'、'b'、'c' 组成 
 0 <= k <= s.length 
 

 👍 92 👎 0

*/
package leetcode.editor.cn; //如果你的算法题是中文的，后缀就是cn，如果是英文的就是en

import java.util.Arrays;

/**
 * @author  YourName
 * @date 2024-09-27 22:03:51
 */
public class TakeKOfEachCharacterFromLeftAndRight{
    public static void main(String[] args) {
        Solution solution = new TakeKOfEachCharacterFromLeftAndRight().new Solution();
   }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int takeCharacters(String s, int k) {
        int[] sum = new int[3];
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            sum[chars[i] - 'a']++;
        }
        for (int i : sum) {
            if (i < k) {
                return -1;
            }
        }
        int left = 0;
        int max = 0;
        for (int i = 0; i < chars.length; i++) {
            int index = chars[i] - 'a';
            sum[index]--;
            while (sum[index] < k) {
                sum[chars[left] - 'a']++;
                left++;
            }
            max = Math.max(max, i - left + 1);
        }
        return s.length() - max;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}