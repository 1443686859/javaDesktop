//给定整数 n 和 k，返回 [1, n] 中字典序第 k 小的数字。 
//
// 
//
// 示例 1: 
//
// 
//输入: n = 13, k = 2
//输出: 10
//解释: 字典序的排列是 [1, 10, 11, 12, 13, 2, 3, 4, 5, 6, 7, 8, 9]，所以第二小的数字是 10。
// 
//
// 示例 2: 
//
// 
//输入: n = 1, k = 1
//输出: 1
// 
//
// 
//
// 提示: 
//
// 
// 1 <= k <= n <= 10⁹ 
// 
// Related Topics 字典树 👍 459 👎 0

package leetcode.editor.cn; //如果你的算法题是中文的，后缀就是cn，如果是英文的就是en
 /**
 * @author  YourName
 * @date 2022-03-24 21:14:15
 */
public class KThSmallestInLexicographicalOrder{
    public static void main(String[] args) {
        Solution solution = new KThSmallestInLexicographicalOrder().new Solution();
        System.out.println(solution.findKthNumber(100, 90));
   }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int findKthNumber(int n, int k) {
        int start = 1;
        int count = 1;
        while (count < k) {
            int currentCount = getChildCount(start, n);
            if (count + currentCount <= k) {
                // 跳过当前
                count += currentCount;
                start++;
            } else {
                // 锁定当前
                start *= 10;
                count++;
            }
        }
        return start;
    }
    // 子树数量 + 根数量
    public int getChildCount(int start, int n) {
        int result = 0;
        long current = start;
        long last = start;
        while (current <= n) {
            result += Math.min(n, last) - current + 1;
            current = current * 10;
            last = last * 10 + 9;
        }
        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}