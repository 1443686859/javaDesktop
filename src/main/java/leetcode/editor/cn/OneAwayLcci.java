//字符串有三种编辑操作:插入一个字符、删除一个字符或者替换一个字符。 给定两个字符串，编写一个函数判定它们是否只需要一次(或者零次)编辑。 
//
// 
//
// 示例 1: 
//
// 输入: 
//first = "pale"
//second = "ple"
//输出: True 
//
// 
//
// 示例 2: 
//
// 输入: 
//first = "pales"
//second = "pal"
//输出: False
// 
// Related Topics 双指针 字符串 👍 189 👎 0

package leetcode.editor.cn; //如果你的算法题是中文的，后缀就是cn，如果是英文的就是en
 /**
 * @author  YourName
 * @date 2022-05-13 19:41:07
 */
public class OneAwayLcci{
    public static void main(String[] args) {
        Solution solution = new OneAwayLcci().new Solution();
   }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean oneEditAway(String first, String second) {
        int abs = Math.abs(first.length() - second.length());
        if (abs >= 2) {
            return false;
        }
        char[] longer = first.length() >= second.length() ? first.toCharArray() : second.toCharArray();
        char[] shorter = first.length() < second.length() ? first.toCharArray() : second.toCharArray();
        int i = 0;
        int j = 0;
        int result = 0;
        while (i < longer.length && j < shorter.length) {
            if (longer[i] != shorter[j]) {
                result++;
                if (longer.length != shorter.length) {
                    i++;
                    continue;
                }
            }
            i++;
            j++;
        }
        if (result <= 1) {
            return true;
        }
        return false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}