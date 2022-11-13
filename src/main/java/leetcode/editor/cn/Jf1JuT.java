//现有一种使用英语字母的外星文语言，这门语言的字母顺序与英语顺序不同。 
//
// 给定一个字符串列表 words ，作为这门语言的词典，words 中的字符串已经 按这门新语言的字母顺序进行了排序 。 
//
// 请你根据该词典还原出此语言中已知的字母顺序，并 按字母递增顺序 排列。若不存在合法字母顺序，返回 "" 。若存在多种可能的合法字母顺序，返回其中 任意一种
// 顺序即可。 
//
// 字符串 s 字典顺序小于 字符串 t 有两种情况： 
//
// 
// 在第一个不同字母处，如果 s 中的字母在这门外星语言的字母顺序中位于 t 中字母之前，那么 s 的字典顺序小于 t 。 
// 如果前面 min(s.length, t.length) 字母都相同，那么 s.length < t.length 时，s 的字典顺序也小于 t 。 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：words = ["wrt","wrf","er","ett","rftt"]
//输出："wertf"
// 
//
// 示例 2： 
//
// 
//输入：words = ["z","x"]
//输出："zx"
// 
//
// 示例 3： 
//
// 
//输入：words = ["z","x","z"]
//输出：""
//解释：不存在合法字母顺序，因此返回 "" 。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= words.length <= 100 
// 1 <= words[i].length <= 100 
// words[i] 仅由小写英文字母组成 
// 
//
// 
//
// 注意：本题与主站 269 题相同： https://leetcode-cn.com/problems/alien-dictionary/ 
// Related Topics 深度优先搜索 广度优先搜索 图 拓扑排序 数组 字符串 👍 98 👎 0

package leetcode.editor.cn; //如果你的算法题是中文的，后缀就是cn，如果是英文的就是en

import java.util.*;

/**
 * @author  YourName
 * @date 2022-05-31 21:10:49
 */
public class Jf1JuT{
    public static void main(String[] args) {
        Solution solution = new Jf1JuT().new Solution();
        System.out.println(solution.alienOrder(new String[]{"wrt","wrf","er","ett","rftt"}));
   }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    Map<Character, List<Character>> map;
    Map<Character, Integer> countMap;

    public String alienOrder(String[] words) {
        map = new HashMap<>();
        countMap = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            for (int j = 0; j < words[i].length(); j++) {
                map.putIfAbsent(words[i].charAt(j), new ArrayList<>());
            }
        }
        for (int i = 1; i < words.length; i++) {
            String pre = words[i - 1];
            String current = words[i];
            if (!check(pre, current)) {
                return "";
            }
        }
        boolean[] visited = new boolean[26];
        StringBuilder result = new StringBuilder();
        Deque<Character> deque = new ArrayDeque<>();
        for (Character key : map.keySet()) {
            if (!countMap.containsKey(key)) {
                deque.offer(key);
            }
        }
        while (!deque.isEmpty()) {
            char currentChar = deque.pop();
            if (visited[currentChar - 'a']) {
                return "";
            }
            result.append(currentChar);
            visited[currentChar - 'a'] = true;
            List<Character> currentResult = map.getOrDefault(currentChar, new ArrayList<>());
            for (Character character : currentResult) {
                countMap.put(character, countMap.get(character) - 1);
                if (countMap.get(character) == 0) {
                    deque.offer(character);
                }
            }
        }
        return result.length() == map.size() ? result.toString() : "";
    }
    public boolean check(String pre, String current) {
        int minLength = Math.min(pre.length(), current.length());
        boolean result = false;
        int i;
        for (i = 0; i < minLength; i++) {
            char preChar = pre.charAt(i);
            char currentChar = current.charAt(i);
            if (currentChar != preChar) {
                List<Character> preCharList = map.get(preChar);
                preCharList.add(currentChar);
                map.put(preChar, preCharList);
                countMap.put(currentChar, countMap.getOrDefault(currentChar, 0) + 1);
                result = true;
                break;
            }
        }
        if (i == minLength && pre.length() > current.length()) {
            result = false;
        }
        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}