/**
给你两个 正整数 l 和 r。对于任何数字 x，x 的所有正因数（除了 x 本身）被称为 x 的 真因数。 

 如果一个数字恰好仅有两个 真因数，则称该数字为 特殊数字。例如： 

 
 数字 4 是 特殊数字，因为它的真因数为 1 和 2。 
 数字 6 不是 特殊数字，因为它的真因数为 1、2 和 3。 
 

 返回区间 [l, r] 内 不是 特殊数字 的数字数量。 

 

 示例 1： 

 
 输入： l = 5, r = 7 
 

 输出： 3 

 解释： 

 区间 [5, 7] 内不存在特殊数字。 

 示例 2： 

 
 输入： l = 4, r = 16 
 

 输出： 11 

 解释： 

 区间 [4, 16] 内的特殊数字为 4 和 9。 

 

 提示： 

 
 1 <= l <= r <= 10⁹ 
 

 👍 41 👎 0

*/
package leetcode.editor.cn; //如果你的算法题是中文的，后缀就是cn，如果是英文的就是en
 /**
 * @author  YourName
 * @date 2024-11-22 23:52:58
 */
public class FindTheCountOfNumbersWhichAreNotSpecial{
    public static void main(String[] args) {
        Solution solution = new FindTheCountOfNumbersWhichAreNotSpecial().new Solution();
        System.out.println(solution.nonSpecialCount (1,9));
   }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
        static int[] sum = new int[0];
        static {

        }
    public int nonSpecialCount(int l, int r) {
        int count = 0;
        for (int i = l; i <= r; i++) {
            int j = (int)Math.sqrt(i);
            if (i == 1) {
                continue;
            }
            if (j * j == i) {
                boolean used = false;
                for (int z = 2; z <= Math.sqrt(j); z++) {
                    if (j % z == 0) {
                        used = true;
                        break;
                    }
                }
                count += used ? 0 : 1;
            }
        }
        return r - l - count + 1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}