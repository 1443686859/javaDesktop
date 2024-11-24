//给你一个整数数组 nums，其中恰好有两个元素只出现一次，其余所有元素均出现两次。 找出只出现一次的那两个元素。你可以按 任意顺序 返回答案。 
//
// 你必须设计并实现线性时间复杂度的算法且仅使用常量额外空间来解决此问题。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,2,1,3,2,5]
//输出：[3,5]
//解释：[5, 3] 也是有效的答案。
// 
//
// 示例 2： 
//
// 
//输入：nums = [-1,0]
//输出：[-1,0]
// 
//
// 示例 3： 
//
// 
//输入：nums = [0,1]
//输出：[1,0]
// 
//
// 
//
// 提示： 
//
// 
// 2 <= nums.length <= 3 * 10⁴ 
// -2³¹ <= nums[i] <= 2³¹ - 1 
// 除两个只出现一次的整数外，nums 中的其他数字都出现两次 
// 
//
// Related Topics 位运算 数组 👍 754 👎 0

package leetcode.editor.cn; //如果你的算法题是中文的，后缀就是cn，如果是英文的就是en
 /**
 * @author  YourName
 * @date 2023-10-16 00:27:32
 */
public class SingleNumberIii{
    public static void main(String[] args) {
        Solution solution = new SingleNumberIii().new Solution();
   }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] singleNumber(int[] nums) {
        int sum = 0;
        for (int i : nums) {
            sum ^= i;
        }
        // 以最后一个1区分 成为两批数据
        sum = sum & (- sum);
        int a = 0;
        int b = 0;
        for (int i : nums) {
            if ((i & sum) == 0) {
                a ^= i;
            } else {
                b ^= i;
            }
        }
        return new int[]{a, b};
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}