/**
Alice 和 Bob 正在玩一个游戏。最初，Alice 有一个字符串 word = "a"。 

 给定一个正整数 k。 

 现在 Bob 会要求 Alice 执行以下操作 无限次 : 

 
 将 word 中的每个字符 更改 为英文字母表中的 下一个 字符来生成一个新字符串，并将其 追加 到原始的 word。 
 

 例如，对 "c" 进行操作生成 "cd"，对 "zb" 进行操作生成 "zbac"。 

 在执行足够多的操作后， word 中 至少 存在 k 个字符，此时返回 word 中第 k 个字符的值。 

 注意，在操作中字符 'z' 可以变成 'a'。 

 

 示例 1: 

 
 输入：k = 5 
 

 输出："b" 

 解释： 

 最初，word = "a"。需要进行三次操作: 

 
 生成的字符串是 "b"，word 变为 "ab"。 
 生成的字符串是 "bc"，word 变为 "abbc"。 
 生成的字符串是 "bccd"，word 变为 "abbcbccd"。 
 

 示例 2: 

 
 输入：k = 10 
 

 输出："c" 

 

 提示： 

 
 1 <= k <= 500 
 

 👍 0 👎 0

*/
package leetcode.editor.cn; //如果你的算法题是中文的，后缀就是cn，如果是英文的就是en
 /**
 * @author  YourName
 * @date 2024-09-30 21:37:32
 */
public class FindTheKThCharacterInStringGameI{
    public static void main(String[] args) {
        Solution solution = new FindTheKThCharacterInStringGameI().new Solution();
   }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public char kthCharacter(int k) {
        int count = 0;
        while (k != 0) {
            int index = 31 - Integer.numberOfLeadingZeros(k);
            if ((k & (k - 1)) == 0) {
                count +=  index;
                break;
            }
            k -= (1 << index);
            count++;
        }
        return (char)('a' + count % 26);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}