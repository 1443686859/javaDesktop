/**
给你一个下标从 0 开始的字符串 num ，表示一个非负整数。 

 在一次操作中，您可以选择 num 的任意一位数字并将其删除。请注意，如果你删除 num 中的所有数字，则 num 变为 0。 

 返回最少需要多少次操作可以使 num 变成特殊数字。 

 如果整数 x 能被 25 整除，则该整数 x 被认为是特殊数字。 

 

 

 示例 1： 

 
输入：num = "2245047"
输出：2
解释：删除数字 num[5] 和 num[6] ，得到数字 "22450" ，可以被 25 整除。
可以证明要使数字变成特殊数字，最少需要删除 2 位数字。 

 示例 2： 

 
输入：num = "2908305"
输出：3
解释：删除 num[3]、num[4] 和 num[6] ，得到数字 "2900" ，可以被 25 整除。
可以证明要使数字变成特殊数字，最少需要删除 3 位数字。 

 示例 3： 

 
输入：num = "10"
输出：1
解释：删除 num[0] ，得到数字 "0" ，可以被 25 整除。
可以证明要使数字变成特殊数字，最少需要删除 1 位数字。
 

 

 提示 

 
 1 <= num.length <= 100 
 num 仅由数字 '0' 到 '9' 组成 
 num 不含任何前导零 
 

 👍 50 👎 0

*/
package leetcode.editor.cn; //如果你的算法题是中文的，后缀就是cn，如果是英文的就是en

import java.util.Arrays;

/**
 * @author  YourName
 * @date 2024-07-25 20:33:47
 */
public class MinimumOperationsToMakeASpecialNumber{
    public static void main(String[] args) {
        Solution solution = new MinimumOperationsToMakeASpecialNumber().new Solution();
        System.out.println(solution.minimumOperations("2245047"));
   }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int minimumOperations(String num) {
        int result = num.length();

        int[] count = new int[10];
        Arrays.fill(count, - 1);
        int i = result - 1;
        while (i >= 0) {

            int index = num.charAt(i) - '0';
            if (index == 2) {
                if (count[5] != -1) {
                    return  num.length() - i - 2;
                }
            } else if (index == 7) {
                if (count[5] != -1) {
                    return  num.length() - i - 2;
                }
            } else if (index == 0) {
                if (count[0] != -1) {
                    return  num.length() - i - 2;
                }
            } else if (index == 5) {
                if (count[0] != -1) {
                    return  num.length() - i - 2;
                }
            }
            count[index] = i;
            i --;
        }
        return count[0] != -1 ? num.length() - 1 : result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}