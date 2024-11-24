//给你两个字符串数组 wordsContainer 和 wordsQuery 。 
//
// 对于每个 wordsQuery[i] ，你需要从 wordsContainer 中找到一个与 wordsQuery[i] 有 最长公共后缀 的字符串。如果
// wordsContainer 中有两个或者更多字符串有最长公共后缀，那么答案为长度 最短 的。如果有超过两个字符串有 相同 最短长度，那么答案为它们在 
//wordsContainer 中出现 更早 的一个。 
//
// 请你返回一个整数数组 ans ，其中 ans[i]是 wordsContainer中与 wordsQuery[i] 有 最长公共后缀 字符串的下标。 
//
// 
//
// 示例 1： 
//
// 
// 输入：wordsContainer = ["abcd","bcd","xbcd"], wordsQuery = ["cd","bcd","xyz"] 
// 
//
// 输出：[1,1,1] 
//
// 解释： 
//
// 我们分别来看每一个 wordsQuery[i] ： 
//
// 
// 对于 wordsQuery[0] = "cd" ，wordsContainer 中有最长公共后缀 "cd" 的字符串下标分别为 0 ，1 和 2 。这些字
//符串中，答案是下标为 1 的字符串，因为它的长度为 3 ，是最短的字符串。 
// 对于 wordsQuery[1] = "bcd" ，wordsContainer 中有最长公共后缀 "bcd" 的字符串下标分别为 0 ，1 和 2 。这
//些字符串中，答案是下标为 1 的字符串，因为它的长度为 3 ，是最短的字符串。 
// 对于 wordsQuery[2] = "xyz" ，wordsContainer 中没有字符串跟它有公共后缀，所以最长公共后缀为 "" ，下标为 0 ，1
// 和 2 的字符串都得到这一公共后缀。这些字符串中， 答案是下标为 1 的字符串，因为它的长度为 3 ，是最短的字符串。 
// 
//
// 示例 2： 
//
// 
// 输入：wordsContainer = ["abcdefgh","poiuygh","ghghgh"], wordsQuery = ["gh",
//"acbfgh","acbfegh"] 
// 
//
// 输出：[2,0,2] 
//
// 解释： 
//
// 我们分别来看每一个 wordsQuery[i] ： 
//
// 
// 对于 wordsQuery[0] = "gh" ，wordsContainer 中有最长公共后缀 "gh" 的字符串下标分别为 0 ，1 和 2 。这些字
//符串中，答案是下标为 2 的字符串，因为它的长度为 6 ，是最短的字符串。 
// 对于 wordsQuery[1] = "acbfgh" ，只有下标为 0 的字符串有最长公共后缀 "fgh" 。所以尽管下标为 2 的字符串是最短的字符串
//，但答案是 0 。 
// 对于 wordsQuery[2] = "acbfegh" ，wordsContainer 中有最长公共后缀 "gh" 的字符串下标分别为 0 ，1 和 2
// 。这些字符串中，答案是下标为 2 的字符串，因为它的长度为 6 ，是最短的字符串。 
// 
//
// 
//
// 提示： 
//
// 
// 1 <= wordsContainer.length, wordsQuery.length <= 10⁴ 
// 1 <= wordsContainer[i].length <= 5 * 10³ 
// 1 <= wordsQuery[i].length <= 5 * 10³ 
// wordsContainer[i] 只包含小写英文字母。 
// wordsQuery[i] 只包含小写英文字母。 
// wordsContainer[i].length 的和至多为 5 * 10⁵ 。 
// wordsQuery[i].length 的和至多为 5 * 10⁵ 。 
// 
//
// 👍 3 👎 0

package leetcode.editor.cn; //如果你的算法题是中文的，后缀就是cn，如果是英文的就是en
 /**
 * @author  YourName
 * @date 2024-03-25 20:59:24
 */
public class LongestCommonSuffixQueries{
    public static void main(String[] args) {
        Solution solution = new LongestCommonSuffixQueries().new Solution();
        System.out.println(solution.stringIndices(new String[]{"abcd","bcd","xbcd"}, new String[]{"cd","bcd","xyz"}));
   }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
        class TrieNode {
            TrieNode[] child;
            int index;
            TrieNode() {
                child = new TrieNode[26];
                index = Integer.MAX_VALUE;
            }
        }
        TrieNode root;
    public int[] stringIndices(String[] wordsContainer, String[] wordsQuery) {
        int n = wordsQuery.length;
        int[] ans = new int[n];
        root = new TrieNode();
        for (int i = 0; i < wordsContainer.length; i++) {
            insert(wordsContainer, i);
            if (root.index == Integer.MAX_VALUE) {
                root.index = i;
            } else if (wordsContainer[root.index].length() > wordsContainer[i].length()) {
                root.index = i;
            }
        }
        for (int i = 0; i < n; i++) {
            ans[i] = search(wordsQuery[i]);
        }
        return ans;
    }
    public void insert(String[] words, int index) {
            String word = words[index];
            int start = word.length() - 1;
            TrieNode temp = root;
            while (start >= 0) {
                int cIndex = word.charAt(start) - 'a';
                if (temp.child[cIndex] == null) {
                    temp.child[cIndex] = new TrieNode();
                }
                temp = temp.child[cIndex];
                if (temp.index != Integer.MAX_VALUE) {
                    if (word.length() < words[temp.index].length()) {
                        temp.index = index;
                    }
                } else {
                    temp.index = index;
                }
                start--;
            }
    }
    public int search(String current) {
        TrieNode temp = root;
        int index = current.length() - 1;
        while (index >= 0 && temp.child[current.charAt(index) - 'a'] != null) {
            temp = temp.child[current.charAt(index) - 'a'];
            index--;
        }
        return temp.index;

    }
}
//leetcode submit region end(Prohibit modification and deletion)

}