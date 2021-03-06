//给定一个整数数组 nums，按要求返回一个新数组 counts。数组 counts 有该性质： counts[i] 的值是 nums[i] 右侧小于 num
//s[i] 的元素的数量。 
//
// 示例: 
//
// 输入: [5,2,6,1]
//输出: [2,1,1,0] 
//解释:
//5 的右侧有 2 个更小的元素 (2 和 1).
//2 的右侧仅有 1 个更小的元素 (1).
//6 的右侧有 1 个更小的元素 (1).
//1 的右侧有 0 个更小的元素.
// 
// Related Topics 排序 树状数组 线段树 二分查找 分治算法

package com.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class CountOfSmallerNumbersAfterSelf {
    public static void main(String[] args) {
        Solution solution = new CountOfSmallerNumbersAfterSelf().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
   public int lowBit(int i) {
       return i & (-i);
   }

        /**
         * arr为原数组
         * c 为 树状数组
         * @param arr
         * @param c
         * @param i
         * @param k
         */
   public void update(int[] arr, int[] c, int i, int k) {
       // 在i位置上加上k
       while (i <= arr.length - 1) {
            c[i] += k;
            i += lowBit(i);
       }
   }
   public int getSum(int[] c, int i) {
       // 求前i项和
       int res = 0;
       while(i > 0) {
           res += c[i];
           i -= lowBit(i);
       }
       return res;
   }

}
//leetcode submit region end(Prohibit modification and deletion)

}