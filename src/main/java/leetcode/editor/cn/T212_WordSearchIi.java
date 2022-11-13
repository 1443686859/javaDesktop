//给定一个 m x n 二维字符网格 board 和一个单词（字符串）列表 words，找出所有同时在二维网格和字典中出现的单词。 
//
// 单词必须按照字母顺序，通过 相邻的单元格 内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母在一个单词中不允许被重复使
//用。 
//
// 
//
// 示例 1： 
//
// 
//输入：board = [["o","a","a","n"],["e","t","a","e"],["i","h","k","r"],["i","f",
//"l","v"]], words = ["oath","pea","eat","rain"]
//输出：["eat","oath"]
// 
//
// 示例 2： 
//
// 
//输入：board = [["a","b"],["c","d"]], words = ["abcb"]
//输出：[]
// 
//
// 
//
// 提示： 
//
// 
// m == board.length 
// n == board[i].length 
// 1 <= m, n <= 12 
// board[i][j] 是一个小写英文字母 
// 1 <= words.length <= 3 * 10⁴ 
// 1 <= words[i].length <= 10 
// words[i] 由小写英文字母组成 
// words 中的所有字符串互不相同 
// 
// Related Topics 字典树 数组 字符串 回溯 矩阵 👍 515 👎 0


package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

//Java：单词搜索 II
public class T212_WordSearchIi{
    public static void main(String[] args) {
        Solution solution = new T212_WordSearchIi().new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
        class TrieNode{
            String s;
            TrieNode[] tns = new TrieNode[26];
        }

        Set<String> set = new HashSet<>();
        List<String> ans = new ArrayList<>();
        char[][] array;
        int[][] dirs = new int[][]{{1,0},{-1,0},{0,1},{0,-1}};
        boolean[][] vist = new boolean[15][15];
        int n;
        int m;
        TrieNode root = new TrieNode();
        public void insert(String s) {
            TrieNode p = root;
            for (int i = 0; i < s.length(); i++) {
                int u = s.charAt(i) - 'a';
                if (p.tns[u] == null) {
                    p.tns[u] = new TrieNode();
                }
                p = p.tns[u];
            }
            p.s = s;
        }
    public List<String> findWords(char[][] board, String[] words) {
        array = board;
        n = board.length;
        m = board[0].length;
        for (String str : words) {
            insert(str);
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                int u = board[i][j] - 'a';
                if (root.tns[u] != null) {
                    vist[i][j] = true;
                    dfs(i, j, root.tns[u]);
                    vist[i][j] = false;
                }
            }
        }
        for (String s : set) {
            ans.add(s);
        }
        return ans;
    }
    public void dfs(int i, int j, TrieNode root) {
        if(root.s != null) {
            set.add(root.s);
        }

        for (int[] dir : dirs) {
            int x = i + dir[0];
            int y = j + dir[1];
            if (x < 0 || x >= n || y < 0 || y >= m) {
                continue;
            }
            if (vist[x][y]) {
                continue;
            }
            int u = array[x][y] - 'a';
            if (root.tns[u] != null) {
                vist[x][y] = true;
                dfs(x, y, root.tns[u]);
                vist[x][y] = false;
            }

        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}