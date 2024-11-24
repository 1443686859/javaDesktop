//给你一个字符串 s 和一个整数 repeatLimit ，用 s 中的字符构造一个新字符串 repeatLimitedString ，使任何字母 连续 出现
//的次数都不超过 repeatLimit 次。你不必使用 s 中的全部字符。 
//
// 返回 字典序最大的 repeatLimitedString 。 
//
// 如果在字符串 a 和 b 不同的第一个位置，字符串 a 中的字母在字母表中出现时间比字符串 b 对应的字母晚，则认为字符串 a 比字符串 b 字典序更大 
//。如果字符串中前 min(a.length, b.length) 个字符都相同，那么较长的字符串字典序更大。 
//
// 
//
// 示例 1： 
//
// 输入：s = "cczazcc", repeatLimit = 3
//输出："zzcccac"
//解释：使用 s 中的所有字符来构造 repeatLimitedString "zzcccac"。
//字母 'a' 连续出现至多 1 次。
//字母 'c' 连续出现至多 3 次。
//字母 'z' 连续出现至多 2 次。
//因此，没有字母连续出现超过 repeatLimit 次，字符串是一个有效的 repeatLimitedString 。
//该字符串是字典序最大的 repeatLimitedString ，所以返回 "zzcccac" 。
//注意，尽管 "zzcccca" 字典序更大，但字母 'c' 连续出现超过 3 次，所以它不是一个有效的 repeatLimitedString 。
// 
//
// 示例 2： 
//
// 输入：s = "aababab", repeatLimit = 2
//输出："bbabaa"
//解释：
//使用 s 中的一些字符来构造 repeatLimitedString "bbabaa"。 
//字母 'a' 连续出现至多 2 次。 
//字母 'b' 连续出现至多 2 次。 
//因此，没有字母连续出现超过 repeatLimit 次，字符串是一个有效的 repeatLimitedString 。 
//该字符串是字典序最大的 repeatLimitedString ，所以返回 "bbabaa" 。 
//注意，尽管 "bbabaaa" 字典序更大，但字母 'a' 连续出现超过 2 次，所以它不是一个有效的 repeatLimitedString 。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= repeatLimit <= s.length <= 10⁵ 
// s 由小写英文字母组成 
// 
//
// Related Topics 贪心 字符串 计数 堆（优先队列） 👍 76 👎 0

package leetcode.editor.cn; //如果你的算法题是中文的，后缀就是cn，如果是英文的就是en

import java.util.PriorityQueue;

/**
 * @author  YourName
 * @date 2024-01-13 23:12:40
 */
public class ConstructStringWithRepeatLimit{
    public static void main(String[] args) {
        Solution solution = new ConstructStringWithRepeatLimit().new Solution();
        System.out.println(solution.repeatLimitedString("cczazcc", 3));
   }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String repeatLimitedString(String s, int repeatLimit) {
        int[] count = new int[26];
        for (char c : s.toCharArray()) {
            count[c - 'a']++;
        }
        int max = 25;
        for (; max >= 0; max--) {
            if (count[max]!= 0) {
                break;
            }
        }
        StringBuilder result = new StringBuilder();
        int second = max - 1;
        while (second >= 0 && count[second] == 0) {
            second--;
        }
        while (max >= 0) {
            int cost = Math.min(count[max], repeatLimit);
            result.append(String.valueOf((char)(max + 'a')).repeat(cost));
            count[max] -= cost;
            if (second < 0) {
                break;
            }
            if (count[max] == 0) {
                max = second;
                second --;
            } else {
                result.append(String.valueOf((char)(second + 'a')));
                count[second]--;
            }
            while (second >= 0 && count[second] == 0) {
                second--;
            }
        }


        return result.toString();
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}