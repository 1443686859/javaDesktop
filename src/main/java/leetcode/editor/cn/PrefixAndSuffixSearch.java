//设计一个包含一些单词的特殊词典，并能够通过前缀和后缀来检索单词。 
//
// 实现 WordFilter 类： 
//
// 
// WordFilter(string[] words) 使用词典中的单词 words 初始化对象。 
// f(string pref, string suff) 返回词典中具有前缀 prefix 和后缀 suff 的单词的下标。如果存在不止一个满足要求的下标，
//返回其中 最大的下标 。如果不存在这样的单词，返回 -1 。 
// 
//
// 
//
// 示例： 
//
// 
//输入
//["WordFilter", "f"]
//[[["apple"]], ["a", "e"]]
//输出
//[null, 0]
//解释
//WordFilter wordFilter = new WordFilter(["apple"]);
//wordFilter.f("a", "e"); // 返回 0 ，因为下标为 0 的单词：前缀 prefix = "a" 且 后缀 suff = "e" 。
//
// 
// 
//
// 提示： 
//
// 
// 1 <= words.length <= 10⁴ 
// 1 <= words[i].length <= 7 
// 1 <= pref.length, suff.length <= 7 
// words[i]、pref 和 suff 仅由小写英文字母组成 
// 最多对函数 f 执行 10⁴ 次调用 
// 
// Related Topics 设计 字典树 字符串 👍 151 👎 0

package leetcode.editor.cn; //如果你的算法题是中文的，后缀就是cn，如果是英文的就是en

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author  YourName
 * @date 2022-07-14 21:15:49
 */
public class PrefixAndSuffixSearch{
    public static void main(String[] args) {
//        Solution solution = new PrefixAndSuffixSearch().new Solution();
   }
//leetcode submit region begin(Prohibit modification and deletion)
class WordFilter {
        Trie root;
        Trie suf;
    public WordFilter(String[] words) {
        root = new Trie();
        suf = new Trie();
        for (int i = 0; i < words.length; i++) {
            add(root, words[i], i);
            add(suf, new StringBuilder(words[i]).reverse().toString(), i);
        }
    }
    
    public int f(String pref, String suff) {
        List<Integer> prefList = search(root, pref);
        List<Integer> suffList = search(suf, new StringBuilder(suff).reverse().toString());
        if (prefList.size() == 0 || suffList.size() == 0) {
            return - 1;
        }
        for (int i = prefList.size() - 1, j = suffList.size() - 1; i >= 0 && j >= 0;) {
            if (prefList.get(i) > suffList.get(j)) {
                i --;
            } else if (prefList.get(i) < suffList.get(j)) {
                j--;
            } else {
                return prefList.get(i);
            }
        }
        return - 1;
    }
    public List<Integer> search(Trie current, String currentString) {
        int index = 0;
        Trie temp = current;
        while (index < currentString.length() ) {
            if (temp.child[currentString.charAt(index) - 'a'] == null) {
                return Collections.EMPTY_LIST;
            }
            temp = temp.child[currentString.charAt(index) - 'a'];
            index++;
        }
        return temp.index;

    }
    public void add(Trie trie, String current, int currentIndex) {
        Trie temp = trie;
        int index = 0;
        while (index < current.length()) {
            if (temp.child[current.charAt(index) - 'a'] == null) {
                temp.child[current.charAt(index) - 'a'] = new Trie();
            }
            temp.index.add(currentIndex);
            temp = temp.child[current.charAt(index) - 'a'];
            index++;
        }
        temp.index.add(currentIndex);
    }
    class Trie {
        List<Integer> index = new ArrayList<>();
        Trie[] child = new Trie[26];
    }
}

/**
 * Your WordFilter object will be instantiated and called as such:
 * WordFilter obj = new WordFilter(words);
 * int param_1 = obj.f(pref,suff);
 */
//leetcode submit region end(Prohibit modification and deletion)

}