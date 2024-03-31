//给你两个字符串 start 和 target ，长度均为 n 。每个字符串 仅 由字符 'L'、'R' 和 '_' 组成，其中： 
//
// 
// 字符 'L' 和 'R' 表示片段，其中片段 'L' 只有在其左侧直接存在一个 空位 时才能向 左 移动，而片段 'R' 只有在其右侧直接存在一个 空位 
//时才能向 右 移动。 
// 字符 '_' 表示可以被 任意 'L' 或 'R' 片段占据的空位。 
// 
//
// 如果在移动字符串 start 中的片段任意次之后可以得到字符串 target ，返回 true ；否则，返回 false 。 
//
// 
//
// 示例 1： 
//
// 
//输入：start = "_L__R__R_", target = "L______RR"
//输出：true
//解释：可以从字符串 start 获得 target ，需要进行下面的移动：
//- 将第一个片段向左移动一步，字符串现在变为 "L___R__R_" 。
//- 将最后一个片段向右移动一步，字符串现在变为 "L___R___R" 。
//- 将第二个片段向右移动三步，字符串现在变为 "L______RR" 。
//可以从字符串 start 得到 target ，所以返回 true 。
// 
//
// 示例 2： 
//
// 
//输入：start = "R_L_", target = "__LR"
//输出：false
//解释：字符串 start 中的 'R' 片段可以向右移动一步得到 "_RL_" 。
//但是，在这一步之后，不存在可以移动的片段，所以无法从字符串 start 得到 target 。
// 
//
// 示例 3： 
//
// 
//输入：start = "_R", target = "R_"
//输出：false
//解释：字符串 start 中的片段只能向右移动，所以无法从字符串 start 得到 target 。 
//
// 
//
// 提示： 
//
// 
// n == start.length == target.length 
// 1 <= n <= 10⁵ 
// start 和 target 由字符 'L'、'R' 和 '_' 组成 
// 
//
// Related Topics 双指针 字符串 👍 111 👎 0

package leetcode.editor.cn; //如果你的算法题是中文的，后缀就是cn，如果是英文的就是en
 /**
 * @author  YourName
 * @date 2023-08-21 20:51:23
 */
public class MovePiecesToObtainAString{
    public static void main(String[] args) {
        Solution solution = new MovePiecesToObtainAString().new Solution();
        System.out.println(solution.canChange("_L__R__R_L",
                "L______RR_"));
   }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean canChange(String start, String target) {
       int i = 0;
       int j = 0;
       while (i < start.length() || j < target.length()) {
           while (i < start.length() && start.charAt(i) == '_') {
               i++;
           }
           while (j < target.length() && target.charAt(j) == '_') {
               j++;
           }
           if (j == target.length() || i == start.length()) {
               break;
           }
           if (start.charAt(i) != target.charAt(j)) {
               return false;
           }
           if (start.charAt(i) == 'L' && i < j  || start.charAt(i) == 'R' && i > j) {
               return false;
           }
           i++;
           j++;
       }
       return i == start.length() && j == target.length();
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}