//有个内含单词的超大文本文件，给定任意两个不同的单词，找出在这个文件中这两个单词的最短距离(相隔单词数)。如果寻找过程在这个文件中会重复多次，而每次寻找的单词
//不同，你能对此优化吗? 
//
// 示例： 
//
// 
//输入：words = ["I","am","a","student","from","a","university","in","a","city"], 
//word1 = "a", word2 = "student"
//输出：1 
//
// 提示： 
//
// 
// words.length <= 100000 
// 
// Related Topics 数组 字符串 👍 78 👎 0

package leetcode.editor.cn; //如果你的算法题是中文的，后缀就是cn，如果是英文的就是en
 /**
 * @author  YourName
 * @date 2022-05-27 20:52:05
 */
public class FindClosestLcci{
    public static void main(String[] args) {
        Solution solution = new FindClosestLcci().new Solution();
   }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int findClosest(String[] words, String word1, String word2) {
        int oneIndex = -1;
        int twoIndex = -1;
        int result = Integer.MAX_VALUE;
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            if (word.equals(word1)) {
                oneIndex = i;
                if (twoIndex != -1)
                result = Math.min(oneIndex - twoIndex, result);
            } else if (word.equals(word2) ) {
                twoIndex = i;
                if (oneIndex != -1)
                result = Math.min(twoIndex - oneIndex, result);
            }
        }
        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}