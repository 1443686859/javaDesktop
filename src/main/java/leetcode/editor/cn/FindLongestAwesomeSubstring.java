/**
给你一个字符串 s 。请返回 s 中最长的 超赞子字符串 的长度。 

 「超赞子字符串」需满足满足下述两个条件： 

 
 该字符串是 s 的一个非空子字符串 
 进行任意次数的字符交换后，该字符串可以变成一个回文字符串 
 

 

 示例 1： 

 输入：s = "3242415"
输出：5
解释："24241" 是最长的超赞子字符串，交换其中的字符后，可以得到回文 "24142"
 

 示例 2： 

 输入：s = "12345678"
输出：1
 

 示例 3： 

 输入：s = "213123"
输出：6
解释："213123" 是最长的超赞子字符串，交换其中的字符后，可以得到回文 "231132"
 

 示例 4： 

 输入：s = "00"
输出：2
 

 

 提示： 

 
 1 <= s.length <= 10^5 
 s 仅由数字组成 
 

 👍 130 👎 0

*/
package leetcode.editor.cn; //如果你的算法题是中文的，后缀就是cn，如果是英文的就是en

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author  YourName
 * @date 2024-05-20 20:09:15
 */
public class FindLongestAwesomeSubstring{
    public static void main(String[] args) {
        Solution solution = new FindLongestAwesomeSubstring().new Solution();
        System.out.println(solution.longestAwesome("185801630663498"));
   }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int longestAwesome(String s) {
        int n = s.length();
        int[] arr = new int[1 << 10];
        Arrays.fill(arr, Integer.MAX_VALUE);
        arr[0] = -1;
        int base = 0;
        int max = 1;
        for (int i = 0; i < n;i++) {
            int index = s.charAt(i) - '0';
            base ^= (1 << index);
            for (int j = 0; j < 10; j++) {
                if (arr[base^ (1 << j)] != Integer.MAX_VALUE) {
                    max = Math.max(max, i - arr[base^ (1 << j)]);
                }
            }
            if (arr[base] == Integer.MAX_VALUE) {
                arr[base] = i;
            } else {
                max = Math.max(max, i - arr[base]);
            }

        }
        return max;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}