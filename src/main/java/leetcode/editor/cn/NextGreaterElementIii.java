//给你一个正整数 n ，请你找出符合条件的最小整数，其由重新排列 n 中存在的每位数字组成，并且其值大于 n 。如果不存在这样的正整数，则返回 -1 。 
//
// 注意 ，返回的整数应当是一个 32 位整数 ，如果存在满足题意的答案，但不是 32 位整数 ，同样返回 -1 。 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 12
//输出：21
// 
//
// 示例 2： 
//
// 
//输入：n = 21
//输出：-1
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 2³¹ - 1 
// 
// Related Topics 数学 双指针 字符串 👍 232 👎 0

package leetcode.editor.cn; //如果你的算法题是中文的，后缀就是cn，如果是英文的就是en

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @author  YourName
 * @date 2022-07-03 08:58:05
 */
public class NextGreaterElementIii{
    public static void main(String[] args) {
        Solution solution = new NextGreaterElementIii().new Solution();
        System.out.println(solution.nextGreaterElement(12));
   }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int nextGreaterElement(int n) {
        int x = n;
        int cnt = 1;
        for (; x >= 10 && x / 10 % 10 >= x % 10; x /= 10) {
            ++cnt;
        }

        x /= 10;
        if (x == 0) {
            // n小于 10
            return -1;
        }
        int targetDigit = x % 10;
        int x2 = n;
        int cnt2 = 0;
        for (; x2 %10 <= targetDigit; x2 /= 10) {
            ++cnt2;
        }
        x += x2 % 10 - targetDigit;
        for (int i = 0; i < cnt; i++, n /= 10) {
            int d = i != cnt2 ? n % 10 : targetDigit;
            if (x > Integer.MAX_VALUE / 10 || x == Integer.MAX_VALUE / 10 && d > 7) {
                return - 1;
            }
            x = x * 10 + d;
        }
        return x;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}