/**
给你一个字符串数组 ideas 表示在公司命名过程中使用的名字列表。公司命名流程如下： 

 
 从 ideas 中选择 2 个 不同 名字，称为 ideaA 和 ideaB 。 
 交换 ideaA 和 ideaB 的首字母。 
 如果得到的两个新名字 都 不在 ideas 中，那么 ideaA ideaB（串联 ideaA 和 ideaB ，中间用一个空格分隔）是一个有效的公司名字。 

 否则，不是一个有效的名字。 
 

 返回 不同 且有效的公司名字的数目。 

 

 示例 1： 

 输入：ideas = ["coffee","donuts","time","toffee"]
输出：6
解释：下面列出一些有效的选择方案：
- ("coffee", "donuts")：对应的公司名字是 "doffee conuts" 。
- ("donuts", "coffee")：对应的公司名字是 "conuts doffee" 。
- ("donuts", "time")：对应的公司名字是 "tonuts dime" 。
- ("donuts", "toffee")：对应的公司名字是 "tonuts doffee" 。
- ("time", "donuts")：对应的公司名字是 "dime tonuts" 。
- ("toffee", "donuts")：对应的公司名字是 "doffee tonuts" 。
因此，总共有 6 个不同的公司名字。

下面列出一些无效的选择方案：
- ("coffee", "time")：在原数组中存在交换后形成的名字 "toffee" 。
- ("time", "toffee")：在原数组中存在交换后形成的两个名字。
- ("coffee", "toffee")：在原数组中存在交换后形成的两个名字。
 

 示例 2： 

 输入：ideas = ["lack","back"]
输出：0
解释：不存在有效的选择方案。因此，返回 0 。
 

 

 提示： 

 
 2 <= ideas.length <= 5 * 10⁴ 
 1 <= ideas[i].length <= 10 
 ideas[i] 由小写英文字母组成 
 ideas 中的所有字符串 互不相同 
 

 👍 89 👎 0

*/
package leetcode.editor.cn; //如果你的算法题是中文的，后缀就是cn，如果是英文的就是en

import java.util.*;

/**
 * @author  YourName
 * @date 2024-09-25 19:46:47
 */
public class NamingACompany{
    public static void main(String[] args) {
        Solution solution = new NamingACompany().new Solution();
        System.out.println(solution.distinctNames(new String[]{
                "sfuzder","spklurny","kvdolme","kbbdklkpgk","za","mdbsmnjiu","pzydbfwiw","lvvyshmd","ow","ssipb","jucpsquexm","ffuzder","uftruik","ringlxh","jz","sjlxouiv","csdbtsvg","openygbaix","dcn","r","hwql","ok","y","sze","ttptd","atxp","ejfpsea","vjfpsea","lj","drmvufbt","zxambug","ozpxq","qzydbfwiw","lqxik","bjo","rrmvufbt","jvl","rzxaaa","nmfydhawa","shlwkf","rcl","hhn","yrmcsc","yieuzizaeh","nrmvufbt","rinsldgdpp","wqg","tyhkgqcu","rsdbtsvg","zvehtqiqxa","jtz","mjaguebiy","fztbpozhf","zzpxq","ue","foktqxiqe","ztf","dn","lxambug","kinsldgdpp","jhn","k","i","qxtava","roktqxiqe","hr","bwzw","mot","cadj","x","bcep","u","kzydbfwiw","ahku","ijo"
//                "coffee","donuts","time","toffee"
        }));
   }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public long distinctNames1(String[] ideas) {
        Set<String>[] array = new Set[26];
        Arrays.setAll(array, e -> new HashSet<>());
        for (String idea : ideas) {
            array[idea.charAt(0) - 'a'].add(idea.substring(1));
        }
        long result = 0;
        for (int i = 1; i < 26; i++) {
            for (int j = 0; j < i; j++)  {
                int m = 0;
                for (String s : array[i]) {
                    if (array[j].contains(s)) {
                        m++;
                    }
                }
                result += (long) (array[i].size() - m) * (array[j].size() - m);
            }
        }
        return result * 2;
    }
    public long distinctNames2(String[] ideas) {
        int[] count = new int[26];
        int[][] intersection = new int[26][26];
        Map<String, Integer> map = new HashMap<>();
        for (String idea : ideas) {
            int index = idea.charAt(0) - 'a';
            count[index]++;
            String suffix = idea.substring(1);
            int mask = map.getOrDefault(suffix, 0);
            map.put(suffix, mask | 1 << index);
            for (int i = 0; i < 26; i++) {
                if ((mask & (1 << i)) != 0) {
                    intersection[i][index]++;
                    intersection[index][i]++;
                }
            }
        }
        long result = 0;
        for (int i = 1; i < 26; i++) {
            for (int j = 0; j < i; j++) {
                result += (count[i] - intersection[i][j]) * (count[j] - intersection[j][i]);
            }
        }
        return result * 2;
    }
    public long distinctNames(String[] ideas) {
        int[] count = new int[26];
        int[][] intersection = new int[26][26];
        Map<String, Integer> map = new HashMap<>();
        for (String idea : ideas) {
            String suffix = idea.substring(1);
            int i = idea.charAt(0) - 'a';
            int mask = map.getOrDefault(suffix, 0);
            map.put(idea.substring(1), mask | 1<<i);
            count[i]++;
            for (int j = 0; j < 26; j++) {
                if ((mask & (1 << j)) != 0) {
                    intersection[i][j]++;
                    intersection[j][i]++;
                }
            }
        }
        long result = 0;
        for (int i = 0; i < 26; i++) {
            for (int j = 0; j < 26; j++) {
                if (i != j) {
                    result += (long) (count[i] - intersection[i][j]) * (count[j] - intersection[j][i]);
                }
            }
        }
        return result;
    }
    TrieNode root;
    class TrieNode {
        TrieNode[] children = new TrieNode[26];
        boolean isEnd;
    }
    public void insert(String word) {
        TrieNode node = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (node.children[c - 'a'] == null) {
                node.children[c - 'a'] = new TrieNode();
            }
            node = node.children[c - 'a'];
        }
        node.isEnd = true;
    }
    public boolean search(String word) {
        TrieNode node = root;
        for (int i = 0; i < word.length(); i++) {
            int index = word.charAt(i) - 'a';
            if (node.children[index] == null) {
                return false;
            }
            node = node.children[index];
        }
        return node.isEnd;
    }
//    public Long sum(String word) {
//
//    }
}
//leetcode submit region end(Prohibit modification and deletion)

}