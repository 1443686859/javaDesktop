//定义 str = [s, n] 表示 str 由 n 个字符串 s 连接构成。 
//
// 
// 例如，str == ["abc", 3] =="abcabcabc" 。 
// 
//
// 如果可以从 s2 中删除某些字符使其变为 s1，则称字符串 s1 可以从字符串 s2 获得。 
//
// 
// 例如，根据定义，s1 = "abc" 可以从 s2 = "abdbec" 获得，仅需要删除加粗且用斜体标识的字符。 
// 
//
// 现在给你两个字符串 s1 和 s2 和两个整数 n1 和 n2 。由此构造得到两个字符串，其中 str1 = [s1, n1]、str2 = [s2, 
//n2] 。 
//
// 请你找出一个最大整数 m ，以满足 str = [str2, m] 可以从 str1 获得。 
//
// 
//
// 示例 1： 
//
// 
//输入：s1 = "acb", n1 = 4, s2 = "ab", n2 = 2
//输出：2
// 
//
// 示例 2： 
//
// 
//输入：s1 = "acb", n1 = 1, s2 = "acb", n2 = 1
//输出：1
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s1.length, s2.length <= 100 
// s1 和 s2 由小写英文字母组成 
// 1 <= n1, n2 <= 10⁶ 
// 
//
// Related Topics 字符串 动态规划 👍 254 👎 0

package leetcode.editor.cn; //如果你的算法题是中文的，后缀就是cn，如果是英文的就是en

import java.util.HashMap;
import java.util.Map;

/**
 * @author  YourName
 * @date 2024-01-02 20:57:08
 */
public class CountTheRepetitions{
    public static void main(String[] args) {
        Solution solution = new CountTheRepetitions().new Solution();
   }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int getMaxRepetitions(String s1, int n1, String s2, int n2) {
        if (n1 == 0) {
            return 0;
        }
        int s1Count = 0;
        int s2Count = 0;
        int index = 0;
        Map<Integer, int[]> recall = new HashMap<Integer, int[]>();
        int[] preLoop = new int[2];
        int[] currentLoop = new int[2];
        while (true) {
            s1Count++;
            for (int i = 0; i < s1.length(); i++) {
                int ch = s1.charAt(i);
                if (ch == s2.charAt(index)) {
                    index++;
                    if (index == s2.length()) {
                        s2Count++;
                        index = 0;
                    }
                }
            }
            if (s1Count == n1) {
                return s2Count / n2;
            }
            if (recall.containsKey(index)) {
                int[] value = recall.get(index);
                int s1CountPre = value[0];
                int s2CountPre = value[1];
                preLoop = new int[]{s1CountPre, s2CountPre};
                currentLoop = new int[]{s1Count - s1CountPre, s2Count - s2CountPre};
                break;
            } else {
                recall.put(index, new int[]{s1Count, s2Count});
            }
        }
        int ans = preLoop[1] + (n1 - preLoop[0]) / currentLoop[0] * currentLoop[1];
        int rest = (n1 - preLoop[0]) % currentLoop[0];
        for (int i = 0; i < rest; i++) {
            for (int j = 0; j < s1.length(); j++) {
                char ch = s1.charAt(j);
                if (ch == s2.charAt(index)) {
                    index++;
                    if (index == s2.length()) {
                        index = 0;
                        ans++;
                    }
                }

            }
        }
        return ans / n2;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}