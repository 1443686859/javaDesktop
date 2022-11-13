package leetcode.editor.cn;
//如果字符串中不含有任何 'aaa'，'bbb' 或 'ccc' 这样的字符串作为子串，那么该字符串就是一个「快乐字符串」。 
//
// 给你三个整数 a，b ，c，请你返回 任意一个 满足下列全部条件的字符串 s： 
//
// 
// s 是一个尽可能长的快乐字符串。 
// s 中 最多 有a 个字母 'a'、b 个字母 'b'、c 个字母 'c' 。 
// s 中只含有 'a'、'b' 、'c' 三种字母。 
// 
//
// 如果不存在这样的字符串 s ，请返回一个空字符串 ""。 
//
// 
//
// 示例 1： 
//
// 输入：a = 1, b = 1, c = 7
//输出："ccaccbcc"
//解释："ccbccacc" 也是一种正确答案。
// 
//
// 示例 2： 
//
// 输入：a = 2, b = 2, c = 1
//输出："aabbc"
// 
//
// 示例 3： 
//
// 输入：a = 7, b = 1, c = 0
//输出："aabaa"
//解释：这是该测试用例的唯一正确答案。 
//
// 
//
// 提示： 
//
// 
// 0 <= a, b, c <= 100 
// a + b + c > 0 
// 
// Related Topics 贪心 字符串 堆（优先队列） 👍 144 👎 0

public class P1405LongestHappyString{
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.longestDiverseString(0,8,11));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    static class Solution {
    public String longestDiverseString(int a, int b, int c) {
        StringBuilder result = new StringBuilder();

        int[] count = new int[]{a, b, c};
        int i = 0;
        int sum = a + b + c;
        while (i < sum) {
            int max = 0;
            int pre = -1;
            int currentIndex = pre;
            int n = result.length();
            if (n >= 2) {
                if (result.charAt(n - 1) == result.charAt(n - 2)) {
                    pre = result.charAt(n - 1) - 'a';
                }
            }
            for (int index = 0; index < count.length; index ++) {
                if (pre != index && count[index] >= max) {
                    currentIndex = index;
                    max = count[index];
                }
            }
            if (max == 0) {
                break;
            }
            pre = currentIndex;
            if (count[pre] != 0) {
                count[pre] --;
                result.append((char)('a' + pre));
            }
            i ++;
        }
        return result.toString();
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}