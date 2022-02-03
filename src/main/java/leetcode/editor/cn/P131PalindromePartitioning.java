package leetcode.editor.cn;
//给你一个字符串 s，请你将 s 分割成一些子串，使每个子串都是 回文串 。返回 s 所有可能的分割方案。 
//
// 回文串 是正着读和反着读都一样的字符串。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "aab"
//输出：[["a","a","b"],["aa","b"]]
// 
//
// 示例 2： 
//
// 
//输入：s = "a"
//输出：[["a"]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 16 
// s 仅由小写英文字母组成 
// 
// Related Topics 字符串 动态规划 回溯 👍 969 👎 0

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P131PalindromePartitioning{
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    List<List<String>> resultList = new ArrayList<>();
        boolean[][] booleans;
    public List<List<String>> partition(String s) {
        int n = s.length();
        booleans= new boolean[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(booleans[i], true);
        }
        for (int i = n -1; i >= 0 ; i--) {
            for (int j = i + 1; j < n; j++) {
                booleans[i][j] = (s.charAt(i) == s.charAt(j) && booleans[i + 1][j - 1]);
            }
        }
        dfs(s, 0, new ArrayList<>());
        return resultList;
    }
    public List<String> dfs(String s, int index, List<String> currentList) {
        if (index >= s.length()) {
            resultList.add(new ArrayList<>(currentList));
            return currentList;
        }
        int n = s.length();
        for (int i = index; i < n; i++) {
            if (booleans[index][i]) {
                currentList.add(s.substring(index, i + 1));
                dfs(s, i + 1, currentList);
                currentList.remove(currentList.size() - 1);
            }
        }
        return currentList;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}