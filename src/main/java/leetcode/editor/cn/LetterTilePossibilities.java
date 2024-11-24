//你有一套活字字模 tiles，其中每个字模上都刻有一个字母 tiles[i]。返回你可以印出的非空字母序列的数目。 
//
// 注意：本题中，每个活字字模只能使用一次。 
//
// 
//
// 示例 1： 
//
// 
//输入："AAB"
//输出：8
//解释：可能的序列为 "A", "B", "AA", "AB", "BA", "AAB", "ABA", "BAA"。
// 
//
// 示例 2： 
//
// 
//输入："AAABBC"
//输出：188
// 
//
// 示例 3： 
//
// 
//输入："V"
//输出：1 
//
// 
//
// 提示： 
//
// 
// 1 <= tiles.length <= 7 
// tiles 由大写英文字母组成 
// 
//
// Related Topics 哈希表 字符串 回溯 计数 👍 231 👎 0

package leetcode.editor.cn; //如果你的算法题是中文的，后缀就是cn，如果是英文的就是en

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author  YourName
 * @date 2023-05-19 19:50:18
 */
public class LetterTilePossibilities{
    public static void main(String[] args) {
        Solution solution = new LetterTilePossibilities().new Solution();
        System.out.println(solution.numTilePossibilities("AAB"));
   }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int numTilePossibilities(String tiles) {
        Map<Character, Integer> map = new HashMap<>();
        for (Character c : tiles.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        int ans = dfs(0, map, tiles) - 1;
        return ans;
    }
    public int dfs(int index, Map<Character, Integer> count, String titles) {
        if (index == titles.length()) {
            return 1;
        }
        int result = 1;
        for (Map.Entry<Character, Integer> entry : count.entrySet()) {
            if (entry.getValue() > 0) {
                count.put(entry.getKey(), entry.getValue() - 1);
                result += dfs(index + 1, count, titles);
                count.put(entry.getKey(), entry.getValue() + 1);
            }
        }
        return result;
    }
    public void dfs(int index, int mask, int[] nums) {

    }
}
//leetcode submit region end(Prohibit modification and deletion)

}