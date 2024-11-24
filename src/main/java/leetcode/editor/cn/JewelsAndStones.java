//给你一个字符串 jewels 代表石头中宝石的类型，另有一个字符串 stones 代表你拥有的石头。 stones 中每个字符代表了一种你拥有的石头的类型，
//你想知道你拥有的石头中有多少是宝石。 
//
// 字母区分大小写，因此 "a" 和 "A" 是不同类型的石头。 
//
// 
//
// 示例 1： 
//
// 
//输入：jewels = "aA", stones = "aAAbbbb"
//输出：3
// 
//
// 示例 2： 
//
// 
//输入：jewels = "z", stones = "ZZ"
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// 1 <= jewels.length, stones.length <= 50 
// jewels 和 stones 仅由英文字母组成 
// jewels 中的所有字符都是 唯一的 
// 
//
// Related Topics 哈希表 字符串 👍 780 👎 0

package leetcode.editor.cn; //如果你的算法题是中文的，后缀就是cn，如果是英文的就是en
 /**
 * @author  YourName
 * @date 2023-07-24 20:25:31
 */
public class JewelsAndStones{
    public static void main(String[] args) {
        Solution solution = new JewelsAndStones().new Solution();
   }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int numJewelsInStones(String jewels, String stones) {
        boolean[] array = new boolean[52];
        for (Character c : jewels.toCharArray()) {
            if (Character.isUpperCase(c)) {
                array[c - 'A' + 26] = true;
            } else {
                array[c - 'a'] = true;
            }
        }
        int count = 0;
        for (Character c : stones.toCharArray()) {
            if (Character.isUpperCase(c)) {
                count += array[c - 'A' + 26] ? 1 : 0;
            } else {
                count += array[c - 'a'] ? 1 : 0;
            }
        }
        return count;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}