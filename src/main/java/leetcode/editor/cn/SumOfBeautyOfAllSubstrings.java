//一个字符串的 美丽值 定义为：出现频率最高字符与出现频率最低字符的出现次数之差。 
//
// 
// 比方说，"abaacc" 的美丽值为 3 - 1 = 2 。 
// 
//
// 给你一个字符串 s ，请你返回它所有子字符串的 美丽值 之和。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "aabcb"
//输出：5
//解释：美丽值不为零的字符串包括 ["aab","aabc","aabcb","abcb","bcb"] ，每一个字符串的美丽值都为 1 。 
//
// 示例 2： 
//
// 
//输入：s = "aabcbaa"
//输出：17
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 500 
// s 只包含小写英文字母。 
// 
//
// Related Topics 哈希表 字符串 计数 👍 72 👎 0

package leetcode.editor.cn; //如果你的算法题是中文的，后缀就是cn，如果是英文的就是en

import java.util.Arrays;

/**
 * @author  YourName
 * @date 2022-12-12 20:22:44
 */
public class SumOfBeautyOfAllSubstrings{
    public static void main(String[] args) {
        Solution solution = new SumOfBeautyOfAllSubstrings().new Solution();
        System.out.println(solution.beautySum("aabcb"));
   }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int beautySum(String s) {
        int n = s.length();
        int result = 0;
        for (int i = 0; i < n; i++) {
            int[] count = new int[26];
            int max = 0;
            for (int j = i; j < n; j ++) {
                count[s.charAt(j) - 'a']++;
                max = Math.max(max, count[s.charAt(j) - 'a']);
                int min = n;
                for (int z = 0; z < 26; z++) {
                    if (count[z] > 0) {
                        min = Math.min(min, count[z]);
                    }
                }
                if (min != 0) {
                    result += max - min;
                }
            }
        }
        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}