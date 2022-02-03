package leetcode.editor.cn;
//给你一个字符串 s ，其中包含字母顺序打乱的用英文单词表示的若干数字（0-9）。按 升序 返回原始的数字。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "owoztneoer"
//输出："012"
// 
//
// 示例 2： 
//
// 
//输入：s = "fviefuro"
//输出："45"
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 10⁵ 
// s[i] 为 ["e","g","f","i","h","o","n","s","r","u","t","w","v","x","z"] 这些字符之一 
// s 保证是一个符合题目要求的字符串 
// 
// Related Topics 哈希表 数学 字符串 👍 152 👎 0

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class P423ReconstructOriginalDigitsFromEnglish{
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
//    public String originalDigits(String s) {
//        Map<Character, Integer> c = new HashMap<>();
//        for (int i = 0; i < s.length(); i++) {
//            char ch = s.charAt(i);
//            c.put(ch, c.getOrDefault(ch, 0) + 1);
//        }
//        int[] cnt = new int[10];
//        cnt[0] = c.getOrDefault('z', 0);
//        cnt[2] = c.getOrDefault('w', 0);
//        cnt[4] = c.getOrDefault('u', 0);
//        cnt[6] = c.getOrDefault('x', 0);
//        cnt[8] = c.getOrDefault('g', 0);
//        cnt[3] = c.getOrDefault('h', 0) - cnt[8];
//        cnt[5] = c.getOrDefault('f', 0) - cnt[4];
//        cnt[7] = c.getOrDefault('s', 0) - cnt[6];
//        cnt[1] = c.getOrDefault('o', 0) - cnt[2] - cnt[0] - cnt[4];
//        cnt[9] = c.getOrDefault('i',0)- cnt[5]- cnt[6]- cnt[8];
//        StringBuilder result = new StringBuilder();
//        for (int i = 0; i < 10; i++) {
//            for (int j = 0; j < cnt[i]; j++) {
//                result.append((char)(i + '0'));
//            }
//        }
//        return  result.toString();
//    }
public String originalDigits(String s) {
    int[] count = new int[26 + (int)'a'];
    for (char c : s.toCharArray()) {
        count[c]++;
    }
    int[] result = new int[10];
    List<Character> characters =  Arrays.asList('z', 'w', 'u', 'x', 'g');
    for (int i = 0, flag = 0; flag < characters.size(); i+=2) {
        result[i] = count[characters.get(flag)];
        flag++;
    }
    result[3] = count['h'] - result[8];
    result[5] = count['f'] - result[4];
    result[7] = count['s'] - result[6];
    result[9] = count['i'] - result[5] - result[6] - result[8];
    result[1] = count['n'] - result[7] - 2 * result[9];
    StringBuilder out = new StringBuilder();
    for (int i = 0; i < 10; i++) {
        for (int j = 0; j < result[i]; j++) {
            out.append(i);
        }
    }
    return out.toString();
}
}
//leetcode submit region end(Prohibit modification and deletion)

}