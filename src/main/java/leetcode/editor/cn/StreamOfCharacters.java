//设计一个算法：接收一个字符流，并检查这些字符的后缀是否是字符串数组 words 中的一个字符串。 
//
// 例如，words = ["abc", "xyz"] 且字符流中逐个依次加入 4 个字符 'a'、'x'、'y' 和 'z' ，你所设计的算法应当可以检测到
// "axyz" 的后缀 "xyz" 与 words 中的字符串 "xyz" 匹配。 
//
// 按下述要求实现 StreamChecker 类： 
//
// 
// StreamChecker(String[] words) ：构造函数，用字符串数组 words 初始化数据结构。 
// boolean query(char letter)：从字符流中接收一个新字符，如果字符流中的任一非空后缀能匹配 words 中的某一字符串，返回 
//true ；否则，返回 false。 
// 
//
// 
//
// 示例： 
//
// 
//输入：
//["StreamChecker", "query", "query", "query", "query", "query", "query", 
//"query", "query", "query", "query", "query", "query"]
//[[["cd", "f", "kl"]], ["a"], ["b"], ["c"], ["d"], ["e"], ["f"], ["g"], ["h"], 
//["i"], ["j"], ["k"], ["l"]]
//输出：
//[null, false, false, false, true, false, true, false, false, false, false, 
//false, true]
//
//解释：
//StreamChecker streamChecker = new StreamChecker(["cd", "f", "kl"]);
//streamChecker.query("a"); // 返回 False
//streamChecker.query("b"); // 返回 False
//streamChecker.query("c"); // 返回n False
//streamChecker.query("d"); // 返回 True ，因为 'cd' 在 words 中
//streamChecker.query("e"); // 返回 False
//streamChecker.query("f"); // 返回 True ，因为 'f' 在 words 中
//streamChecker.query("g"); // 返回 False
//streamChecker.query("h"); // 返回 False
//streamChecker.query("i"); // 返回 False
//streamChecker.query("j"); // 返回 False
//streamChecker.query("k"); // 返回 False
//streamChecker.query("l"); // 返回 True ，因为 'kl' 在 words 中
// 
//
// 
//
// 提示： 
//
// 
// 1 <= words.length <= 2000 
// 1 <= words[i].length <= 200 
// words[i] 由小写英文字母组成 
// letter 是一个小写英文字母 
// 最多调用查询 4 * 10⁴ 次 
// 
//
// Related Topics 设计 字典树 数组 字符串 数据流 👍 156 👎 0

package leetcode.editor.cn; //如果你的算法题是中文的，后缀就是cn，如果是英文的就是en
 /**
 * @author  YourName
 * @date 2023-03-24 23:46:25
 */
public class StreamOfCharacters{
    public static void main(String[] args) {
//        Solution solution = new StreamOfCharacters().new Solution();
   }
//leetcode submit region begin(Prohibit modification and deletion)
class StreamChecker {
    class TreeNode {
        TreeNode[] child;
        boolean isEnd;
        TreeNode() {
            child = new TreeNode[26];
            isEnd = false;
        }
     }
     TreeNode root = new TreeNode();
    StringBuilder result = new StringBuilder();
    public StreamChecker(String[] words) {
        for (int i = 0; i < words.length; i++) {
            add(words[i]);
        }
    }
    
    public boolean query(char letter) {
        result.append(letter);
        int n = result.length() - 1;
        TreeNode start = root;
        while (n >= 0 && start != null) {
            if (start.isEnd) {
                break;
            }
            start = start.child[result.charAt(n) - 'a'];
            n --;
        }
       return start != null && start.isEnd;
    }
    public void add(String word) {
        int n = word.length();
        TreeNode start = root;
        for (int i = n - 1; i >= 0; i--) {
            int index = word.charAt(i) - 'a';
            if (start.child[index] == null) {
                start.child[index] = new TreeNode();
            }
            start = start.child[index];
        }
        start.isEnd = true;
    }
}

/**
 * Your StreamChecker object will be instantiated and called as such:
 * StreamChecker obj = new StreamChecker(words);
 * boolean param_1 = obj.query(letter);
 */
//leetcode submit region end(Prohibit modification and deletion)

}