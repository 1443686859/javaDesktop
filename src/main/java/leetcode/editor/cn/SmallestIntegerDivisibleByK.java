//给定正整数 k ，你需要找出可以被 k 整除的、仅包含数字 1 的最 小 正整数 n 的长度。 
//
// 返回 n 的长度。如果不存在这样的 n ，就返回-1。 
//
// 注意： n 不符合 64 位带符号整数。 
//
// 
//
// 示例 1： 
//
// 
//输入：k = 1
//输出：1
//解释：最小的答案是 n = 1，其长度为 1。 
//
// 示例 2： 
//
// 
//输入：k = 2
//输出：-1
//解释：不存在可被 2 整除的正整数 n 。 
//
// 示例 3： 
//
// 
//输入：k = 3
//输出：3
//解释：最小的答案是 n = 111，其长度为 3。 
//
// 
//
// 提示： 
//
// 
// 1 <= k <= 10⁵ 
// 
//
// Related Topics 哈希表 数学 👍 147 👎 0

package leetcode.editor.cn; //如果你的算法题是中文的，后缀就是cn，如果是英文的就是en

import java.util.HashSet;
import java.util.Set;

/**
 * @author  YourName
 * @date 2023-05-10 22:13:33
 */
public class SmallestIntegerDivisibleByK{
    public static void main(String[] args) {
        Solution solution = new SmallestIntegerDivisibleByK().new Solution();
   }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int smallestRepunitDivByK(int k) {
        if ((k & 1) == 0 || (k % 5 ) == 0) {
            return -1;
        }
        int start = 1 % k;
        for (int i = 1; ; i++) {
            if (start == 0) {
                return i;
            }
            start = ((start * 10) % k + 1) % k;
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}