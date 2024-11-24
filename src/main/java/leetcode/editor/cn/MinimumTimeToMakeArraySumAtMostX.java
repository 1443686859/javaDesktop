//给你两个长度相等下标从 0 开始的整数数组 nums1 和 nums2 。每一秒，对于所有下标 0 <= i < nums1.length ，nums1[
//i] 的值都增加 nums2[i] 。操作 完成后 ，你可以进行如下操作： 
//
// 
// 选择任一满足 0 <= i < nums1.length 的下标 i ，并使 nums1[i] = 0 。 
// 
//
// 同时给你一个整数 x 。 
//
// 请你返回使 nums1 中所有元素之和 小于等于 x 所需要的 最少 时间，如果无法实现，那么返回 -1 。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums1 = [1,2,3], nums2 = [1,2,3], x = 4
//输出：3
//解释：
//第 1 秒，我们对 i = 0 进行操作，得到 nums1 = [0,2+2,3+3] = [0,4,6] 。
//第 2 秒，我们对 i = 1 进行操作，得到 nums1 = [0+1,0,6+3] = [1,0,9] 。
//第 3 秒，我们对 i = 2 进行操作，得到 nums1 = [1+1,0+2,0] = [2,2,0] 。
//现在 nums1 的和为 4 。不存在更少次数的操作，所以我们返回 3 。
// 
//
// 示例 2： 
//
// 
//输入：nums1 = [1,2,3], nums2 = [3,3,3], x = 4
//输出：-1
//解释：不管如何操作，nums1 的和总是会超过 x 。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums1.length <= 10³ 
// 1 <= nums1[i] <= 10³ 
// 0 <= nums2[i] <= 10³ 
// nums1.length == nums2.length 
// 0 <= x <= 10⁶ 
// 
//
// Related Topics 数组 动态规划 排序 👍 100 👎 0

package leetcode.editor.cn; //如果你的算法题是中文的，后缀就是cn，如果是英文的就是en

import java.util.Arrays;
import java.util.List;

/**
 * @author  YourName
 * @date 2024-01-19 22:39:55
 */
public class MinimumTimeToMakeArraySumAtMostX{
    public static void main(String[] args) {
        Solution solution = new MinimumTimeToMakeArraySumAtMostX().new Solution();
        System.out.println(solution.minimumTime(Arrays.asList(1,2,3), Arrays.asList(1,2,3),  4));
   }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int minimumTime(List<Integer> nums1, List<Integer> nums2, int x) {
        int n = nums1.size();
        int[] result = new int[n + 1];
        int[][] array = new int[n][2];
        int s1 = 0;
        int s2 = 0;
        for (int i = 0; i < n; i++) {
            array[i][0] = nums1.get(i);
            array[i][1] = nums2.get(i);
            s1 += array[i][0];
            s2 += array[i][1];
        }
        Arrays.sort(array, (a, b) -> a[1] - b[1]);
        for (int i = 0; i < n; i++) {
            int a = array[i][0];
            int b = array[i][1];
            for (int j = i + 1; j > 0; j--) {
                result[j] = Math.max(result[j], result[j - 1] + a + b * j);
            }
        }
        for (int i = 0; i <= n; i++) {
            if (s1 + s2 * i - result[i] <= x) {
                return i;
            }
        }
        return -1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}