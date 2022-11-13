//在一个由 'L' , 'R' 和 'X' 三个字符组成的字符串（例如"RXXLRXRXL"）中进行移动操作。一次移动操作指用一个"LX"替换一个"XL"，或
//者用一个"XR"替换一个"RX"。现给定起始字符串start和结束字符串end，请编写代码，当且仅当存在一系列移动操作使得start可以转换成end时， 返回
//True。 
//
// 
//
// 示例 : 
//
// 输入: start = "RXXLRXRXL", end = "XRLXXRRLX"
//输出: True
//解释:
//我们可以通过以下几步将start转换成end:
//RXXLRXRXL ->
//XRXLRXRXL ->
//XRLXRXRXL ->
//XRLXXRRXL ->
//XRLXXRRLX
// 
//
// 
//
// 提示： 
//
// 
// 1 <= len(start) = len(end) <= 10000。 
// start和end中的字符串仅限于'L', 'R'和'X'。 
// 
//
// Related Topics 双指针 字符串 👍 220 👎 0

package leetcode.editor.cn; //如果你的算法题是中文的，后缀就是cn，如果是英文的就是en
 /**
 * @author  YourName
 * @date 2022-10-02 18:38:36
 */
public class SwapAdjacentInLrString{
    public static void main(String[] args) {
        Solution solution = new SwapAdjacentInLrString().new Solution();
   }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean canTransform(String start, String end) {
        int i = 0;
        int j = 0;
        while (i < start.length() && j < end.length()) {
            while (i < start.length() && start.charAt(i) == 'X') {
                i++;
            }
            while (j < end.length() && end.charAt(j) == 'X') {
                j++;
            }
            if (i < start.length() && j < start.length()) {
                if (start.charAt(i) != end.charAt(j)) {
                    return false;
                }
                char c = start.charAt(i);
                if ((c == 'L' &&  i < j) || (c == 'R' && i > j)) {
                    return false;
                }
                i++;
                j++;
            }
        }
        while (i < start.length()) {
            if (start.charAt(i) != 'X') {
                return false;
            }
            i++;
        }
        while (j < end.length()) {
            if (end.charAt(j) != 'X') {
                return false;
            }
            j++;
        }
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}