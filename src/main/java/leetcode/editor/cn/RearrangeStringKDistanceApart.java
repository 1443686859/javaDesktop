//给你一个非空的字符串 s 和一个整数 k ，你要将这个字符串 s 中的字母进行重新排列，使得重排后的字符串中相同字母的位置间隔距离 至少 为 k 。如果无法
//做到，请返回一个空字符串 ""。 
//
// 
//
// 示例 1： 
//
// 
//输入: s = "aabbcc", k = 3
//输出: "abcabc" 
//解释: 相同的字母在新的字符串中间隔至少 3 个单位距离。
// 
//
// 示例 2: 
//
// 
//输入: s = "aaabc", k = 3
//输出: "" 
//解释: 没有办法找到可能的重排结果。
// 
//
// 示例 3: 
//
// 
//输入: s = "aaadbbcc", k = 2
//输出: "abacabcd"
//解释: 相同的字母在新的字符串中间隔至少 2 个单位距离。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 3 * 10⁵ 
// s 仅由小写英文字母组成 
// 0 <= k <= s.length 
// 
//
// Related Topics 贪心 哈希表 字符串 计数 排序 堆（优先队列） 👍 102 👎 0

package leetcode.editor.cn; //如果你的算法题是中文的，后缀就是cn，如果是英文的就是en

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * @author  YourName
 * @date 2023-02-09 20:01:12
 */
public class RearrangeStringKDistanceApart{
    public static void main(String[] args) {
        Solution solution = new RearrangeStringKDistanceApart().new Solution();
   }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String rearrangeString(String s, int k) {
        int[] count = new int[26];
        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a']++;
        }
        PriorityQueue<Integer> queue = new PriorityQueue<>((a, b) -> {
            return count[b] - count[a];
        });
        for (int i = 0; i < 26; i ++) {
            if (count[i] != 0) {
                queue.offer(i);
            }
        }
        StringBuilder result = new StringBuilder();
        int index = 0;
        int[] in = new int[k];
        Arrays.fill(in, -1);
        for (int i = 0; i < s.length(); i++) {
            int current = queue.poll();
            if (index == k - 1) {
                if (in[index] != -1 && count[in[index]] != 0) {
                    queue.offer(in[index]);
                }
            }
            in[index] = current;
            index = (index + 1) % k;
            result.append((char)('a' + current));
        }
        return result.toString();
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}