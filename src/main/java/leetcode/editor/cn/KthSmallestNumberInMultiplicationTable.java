//几乎每一个人都用 乘法表。但是你能在乘法表中快速找到第k小的数字吗？ 
//
// 给定高度m 、宽度n 的一张 m * n的乘法表，以及正整数k，你需要返回表中第k 小的数字。 
//
// 例 1： 
//
// 
//输入: m = 3, n = 3, k = 5
//输出: 3
//解释: 
//乘法表:
//1	2	3
//2	4	6
//3	6	9
//
//第5小的数字是 3 (1, 2, 2, 3, 3).
// 
//
// 例 2： 
//
// 
//输入: m = 2, n = 3, k = 6
//输出: 6
//解释: 
//乘法表:
//1	2	3
//2	4	6
//
//第6小的数字是 6 (1, 2, 2, 3, 4, 6).
// 
//
// 注意： 
//
// 
// m 和 n 的范围在 [1, 30000] 之间。 
// k 的范围在 [1, m * n] 之间。 
// 
// Related Topics 二分查找 👍 282 👎 0

package leetcode.editor.cn; //如果你的算法题是中文的，后缀就是cn，如果是英文的就是en
 /**
 * @author  YourName
 * @date 2022-05-18 19:37:14
 */
public class KthSmallestNumberInMultiplicationTable{
    public static void main(String[] args) {
        Solution solution = new KthSmallestNumberInMultiplicationTable().new Solution();
        System.out.println(solution.findKthNumber(45,12,471));
   }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int findKthNumber(int m, int n, int k) {
        int left = 1;
        int right = m * n;
        int result = -1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (count(mid, n, m) >= k) {
                result = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return result;
    }
    public int count(int x, int n, int m) {
        int result = 0;
        for (int i = 1; i <= m; i++) {
            result += Math.min(x / i, n);
        }
        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}