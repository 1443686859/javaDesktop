//给你一个正整数数组 price ，其中 price[i] 表示第 i 类糖果的价格，另给你一个正整数 k 。 
//
// 商店组合 k 类 不同 糖果打包成礼盒出售。礼盒的 甜蜜度 是礼盒中任意两种糖果 价格 绝对差的最小值。 
//
// 返回礼盒的 最大 甜蜜度。 
//
// 
//
// 示例 1： 
//
// 
//输入：price = [13,5,1,8,21,2], k = 3
//输出：8
//解释：选出价格分别为 [13,5,21] 的三类糖果。
//礼盒的甜蜜度为 min(|13 - 5|, |13 - 21|, |5 - 21|) = min(8, 8, 16) = 8 。
//可以证明能够取得的最大甜蜜度就是 8 。
// 
//
// 示例 2： 
//
// 
//输入：price = [1,3,1], k = 2
//输出：2
//解释：选出价格分别为 [1,3] 的两类糖果。 
//礼盒的甜蜜度为 min(|1 - 3|) = min(2) = 2 。
//可以证明能够取得的最大甜蜜度就是 2 。
// 
//
// 示例 3： 
//
// 
//输入：price = [7,7,7,7], k = 2
//输出：0
//解释：从现有的糖果中任选两类糖果，甜蜜度都会是 0 。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= price.length <= 10⁵ 
// 1 <= price[i] <= 10⁹ 
// 2 <= k <= price.length 
// 
//
// Related Topics 数组 二分查找 排序 👍 119 👎 0

package leetcode.editor.cn; //如果你的算法题是中文的，后缀就是cn，如果是英文的就是en

import java.util.Arrays;

/**
 * @author  YourName
 * @date 2023-06-01 21:39:50
 */
public class MaximumTastinessOfCandyBasket{
    public static void main(String[] args) {
        Solution solution = new MaximumTastinessOfCandyBasket().new Solution();
   }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maximumTastiness(int[] price, int k) {
        Arrays.sort(price);
        int max = price[price.length - 1] - price[0] / (k - 1) + 1;
        int min = 0;
        while (min <= max) {
            int mid = (max + min) / 2;
            if (check(price, mid, k)) {
                min = mid + 1;
            } else {
                max = mid - 1;
            }
        }
        return min - 1;
    }
    public boolean check(int[] arr, int mid, int k) {
        int start = arr[0];
        int count = 1;
        for (int i = 1; i < arr.length; i++) {
            if (start + mid <= arr[i]) {
                start = arr[i];
                count++;
            }
            if (count == k) {
                return true;
            }
        }
        return false;
    }

}
//leetcode submit region end(Prohibit modification and deletion)

}