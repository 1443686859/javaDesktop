//定义一个函数 f(s)，统计 s 中（按字典序比较）最小字母的出现频次 ，其中 s 是一个非空字符串。 
//
// 例如，若 s = "dcce"，那么 f(s) = 2，因为字典序最小字母是 "c"，它出现了 2 次。 
//
// 现在，给你两个字符串数组待查表 queries 和词汇表 words 。对于每次查询 queries[i] ，需统计 words 中满足 f(
//queries[i]) < f(W) 的 词的数目 ，W 表示词汇表 words 中的每个词。 
//
// 请你返回一个整数数组 answer 作为答案，其中每个 answer[i] 是第 i 次查询的结果。 
//
// 
//
// 示例 1： 
//
// 
//输入：queries = ["cbd"], words = ["zaaaz"]
//输出：[1]
//解释：查询 f("cbd") = 1，而 f("zaaaz") = 3 所以 f("cbd") < f("zaaaz")。
// 
//
// 示例 2： 
//
// 
//输入：queries = ["bbb","cc"], words = ["a","aa","aaa","aaaa"]
//输出：[1,2]
//解释：第一个查询 f("bbb") < f("aaaa")，第二个查询 f("aaa") 和 f("aaaa") 都 > f("cc")。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= queries.length <= 2000 
// 1 <= words.length <= 2000 
// 1 <= queries[i].length, words[i].length <= 10 
// queries[i][j]、words[i][j] 都由小写英文字母组成 
// 
//
// Related Topics 数组 哈希表 字符串 二分查找 排序 👍 95 👎 0

package leetcode.editor.cn; //如果你的算法题是中文的，后缀就是cn，如果是英文的就是en
 /**
 * @author  YourName
 * @date 2023-06-10 21:28:09
 */
public class CompareStringsByFrequencyOfTheSmallestCharacter{
    public static void main(String[] args) {
        Solution solution = new CompareStringsByFrequencyOfTheSmallestCharacter().new Solution();
   }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] numSmallerByFrequency(String[] queries, String[] words) {
        int  n = queries.length;
        int[] count = new int[26];
        for (String word : words) {
            count[get(word) - 'a']++;
        }
        int[] result = new int[n];
        for (int i = 0; i < n; i++) {
            char target = get(queries[i]);
            for (int j = 25; j > target - 'a'; j--) {
                result[i] += count[j];
            }
        }
        return result;
    }
    public char get(String s) {
        char[] array = s.toCharArray();
        int[] count = new int[26];
        for (int i = 0; i < array.length; i++) {
            count[array[i] - 'a']++;
        }
        for (int i = 0; i < 26;i ++) {
            if (count[i] != 0) {
                return (char)('a' + i);
            }
        }
        return 'a';
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}