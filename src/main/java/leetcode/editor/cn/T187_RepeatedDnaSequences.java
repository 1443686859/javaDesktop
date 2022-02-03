//所有 DNA 都由一系列缩写为 'A'，'C'，'G' 和 'T' 的核苷酸组成，例如："ACGAATTCCG"。在研究 DNA 时，识别 DNA 中的重复
//序列有时会对研究非常有帮助。 
//
// 编写一个函数来找出所有目标子串，目标子串的长度为 10，且在 DNA 字符串 s 中出现次数超过一次。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"
//输出：["AAAAACCCCC","CCCCCAAAAA"]
// 
//
// 示例 2： 
//
// 
//输入：s = "AAAAAAAAAAAAA"
//输出：["AAAAAAAAAA"]
// 
//
// 
//
// 提示： 
//
// 
// 0 <= s.length <= 10⁵ 
// s[i] 为 'A'、'C'、'G' 或 'T' 
// 
// Related Topics 位运算 哈希表 字符串 滑动窗口 哈希函数 滚动哈希 👍 283 👎 0


package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//Java：重复的DNA序列
public class T187_RepeatedDnaSequences{
    public static void main(String[] args) {
        Solution solution = new T187_RepeatedDnaSequences().new Solution();
        // TO TEST
        System.out.println(solution.findRepeatedDnaSequences("AAAAAAAAAAA"));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
        private static final int LENGTH = 10;
        private  Map<Character, Integer> bin = new HashMap<Character, Integer>(){{
            put('A',0);
            put('C',1);
            put('G',2);
            put('T',3);
        }};
    public List<String> findRepeatedDnaSequences(String s) {
        int n = s.length();
        List<String> result = new ArrayList<>();
        if (n <= LENGTH) {
            return result;
        }
        int current = 0;
        Map<Integer, Integer> count = new HashMap<>();
        for (int i = 0; i < LENGTH - 1; i++) {
            current = (current << 2) | bin.get(s.charAt(i));
        }
        for (int i = 0; i <= n - LENGTH; i++) {
            current = ((current << 2) | bin.get(s.charAt(i + LENGTH - 1))) & ((1 << 20) - 1);
            count.put(current, count.getOrDefault(current, 0) + 1);
            if (count.get(current) == 2) {
                result.add(s.substring(i, i + LENGTH));
            }
        }
        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}