//设计一个使用单词列表进行初始化的数据结构，单词列表中的单词 互不相同 。 如果给出一个单词，请判定能否只将这个单词中一个字母换成另一个字母，使得所形成的新单
//词存在于你构建的字典中。 
//
// 实现 MagicDictionary 类： 
//
// 
// MagicDictionary() 初始化对象 
// void buildDict(String[] dictionary) 使用字符串数组 dictionary 设定该数据结构，dictionary 中的字
//符串互不相同 
// bool search(String searchWord) 给定一个字符串 searchWord ，判定能否只将字符串中 一个 字母换成另一个字母，使得
//所形成的新字符串能够与字典中的任一字符串匹配。如果可以，返回 true ；否则，返回 false 。 
// 
//
// 
//
// 
// 
// 
// 示例： 
//
// 
//输入
//["MagicDictionary", "buildDict", "search", "search", "search", "search"]
//[[], [["hello", "leetcode"]], ["hello"], ["hhllo"], ["hell"], ["leetcoded"]]
//输出
//[null, null, false, true, false, false]
//
//解释
//MagicDictionary magicDictionary = new MagicDictionary();
//magicDictionary.buildDict(["hello", "leetcode"]);
//magicDictionary.search("hello"); // 返回 False
//magicDictionary.search("hhllo"); // 将第二个 'h' 替换为 'e' 可以匹配 "hello" ，所以返回 True
//magicDictionary.search("hell"); // 返回 False
//magicDictionary.search("leetcoded"); // 返回 False
// 
//
// 
//
// 提示： 
//
// 
// 1 <= dictionary.length <= 100 
// 1 <= dictionary[i].length <= 100 
// dictionary[i] 仅由小写英文字母组成 
// dictionary 中的所有字符串 互不相同 
// 1 <= searchWord.length <= 100 
// searchWord 仅由小写英文字母组成 
// buildDict 仅在 search 之前调用一次 
// 最多调用 100 次 search 
// 
// 
// 
// 
// Related Topics 设计 字典树 哈希表 字符串 👍 173 👎 0

package leetcode.editor.cn; //如果你的算法题是中文的，后缀就是cn，如果是英文的就是en
 /**
 * @author  YourName
 * @date 2022-07-11 20:45:25
 */
public class ImplementMagicDictionary{
//    public static void main(String[] args) {
//        MagicDictionary magicDictionary = new MagicDictionary();
//        magicDictionary.buildDict(new String[]{"hello","hallo","leetcode"});
//        System.out.println(magicDictionary.search("hell"));
//
//   }
//leetcode submit region begin(Prohibit modification and deletion)
class MagicDictionary {
        class Trie {
            boolean isEnd;
            Trie[] child = new Trie[26];
        }
        Trie root ;
    public MagicDictionary() {
        root = new Trie();
    }
    
    public void buildDict(String[] dictionary) {
        for (String current : dictionary) {
            Trie temp = root;
            for (int i = 0; i < current.length(); i++) {
                char currentChar = current.charAt(i);
                if (temp.child[currentChar - 'a'] == null) {
                    temp.child[currentChar - 'a'] = new Trie();
                }
                temp = temp.child[currentChar - 'a'];
            }
            temp.isEnd = true;
        }
    }
    
    public boolean search(String searchWord) {
        return dfs(root, false, 0, searchWord.toCharArray());
    }
    private boolean dfs(Trie pre, boolean isModified, int index, char[] array) {
        if (index == array.length) {
            return isModified && pre.isEnd;
        }
        int i = array[index] - 'a';
            if (pre.child[i] != null && dfs(pre.child[i], isModified, index + 1, array)) {
                 return true;
            }
        if (!isModified) {
            for (int a = 0; a < 26; a++) {
                if (i != a && pre.child[a] != null && dfs(pre.child[a], true, index + 1, array)) {
                    return true;
                }
            }
        }

        return false;
    }


}

/**
 * Your MagicDictionary object will be instantiated and called as such:
 * MagicDictionary obj = new MagicDictionary();
 * obj.buildDict(dictionary);
 * boolean param_2 = obj.search(searchWord);
 */
//leetcode submit region end(Prohibit modification and deletion)

}