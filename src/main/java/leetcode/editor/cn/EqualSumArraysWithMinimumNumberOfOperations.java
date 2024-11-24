//给你两个长度可能不等的整数数组 nums1 和 nums2 。两个数组中的所有值都在 1 到 6 之间（包含 1 和 6）。 
//
// 每次操作中，你可以选择 任意 数组中的任意一个整数，将它变成 1 到 6 之间 任意 的值（包含 1 和 6）。 
//
// 请你返回使 nums1 中所有数的和与 nums2 中所有数的和相等的最少操作次数。如果无法使两个数组的和相等，请返回 -1 。 
//
// 
//
// 示例 1： 
//
// 输入：nums1 = [1,2,3,4,5,6], nums2 = [1,1,2,2,2,2]
//输出：3
//解释：你可以通过 3 次操作使 nums1 中所有数的和与 nums2 中所有数的和相等。以下数组下标都从 0 开始。
//- 将 nums2[0] 变为 6 。 nums1 = [1,2,3,4,5,6], nums2 = [6,1,2,2,2,2] 。
//- 将 nums1[5] 变为 1 。 nums1 = [1,2,3,4,5,1], nums2 = [6,1,2,2,2,2] 。
//- 将 nums1[2] 变为 2 。 nums1 = [1,2,2,4,5,1], nums2 = [6,1,2,2,2,2] 。
// 
//
// 示例 2： 
//
// 输入：nums1 = [1,1,1,1,1,1,1], nums2 = [6]
//输出：-1
//解释：没有办法减少 nums1 的和或者增加 nums2 的和使二者相等。
// 
//
// 示例 3： 
//
// 输入：nums1 = [6,6], nums2 = [1]
//输出：3
//解释：你可以通过 3 次操作使 nums1 中所有数的和与 nums2 中所有数的和相等。以下数组下标都从 0 开始。
//- 将 nums1[0] 变为 2 。 nums1 = [2,6], nums2 = [1] 。
//- 将 nums1[1] 变为 2 。 nums1 = [2,2], nums2 = [1] 。
//- 将 nums2[0] 变为 4 。 nums1 = [2,2], nums2 = [4] 。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums1.length, nums2.length <= 10⁵ 
// 1 <= nums1[i], nums2[i] <= 6 
// 
//
// Related Topics 贪心 数组 哈希表 计数 👍 131 👎 0

package leetcode.editor.cn; //如果你的算法题是中文的，后缀就是cn，如果是英文的就是en
 /**
 * @author  YourName
 * @date 2022-12-07 19:22:22
 */
public class EqualSumArraysWithMinimumNumberOfOperations{
    public static void main(String[] args) {
        Solution solution = new EqualSumArraysWithMinimumNumberOfOperations().new Solution();
        System.out.println(solution.minOperations(new int[]{3,3,2,4,2,6,2}, new int[]{6,2,6,6,1,1,4,6,4,6,2,5,4,2,1}));
    }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int minOperations(int[] nums1, int[] nums2) {
        int[] count1 = new int[7];
        int[] count2 = new int[7];
        int sum1 = 0;
        int sum2 = 0;
        for (int i : nums1) {
            count1[i] ++;
            sum1 += i;
        }
        for (int i : nums2) {
            count2[i] ++;
            sum2 += i;
        }
        if (sum2 == sum1) {
            return 0;
        }
        int start = 1;
        int end = 6;
        int res = Math.abs(sum1 - sum2);
        int[] min = sum1 >= sum2 ? count2 : count1;
        int[] max = sum1 >= sum2 ? count1 : count2;
        int result = 0;
        while (res > 0 && end > 1 && start < min.length - 1) {
            if (max[end] != 0 && min[start] != 0) {
                if (end - 1 >= 6 - start) {
                    int currentCost;
                    if (res - (end - 1) * max[end] >= 0) {
                        currentCost = max[end];
                    } else {
                        currentCost = res / (end - 1) + ((res % (end - 1)) != 0 ? 1 : 0);
                    }
                    result += currentCost;
                    res = Math.max(0, res - (end - 1) * currentCost);
                    end--;
                } else {
                    int currentCost;
                    if (res - (6 - start) * min[start] >= 0) {
                        currentCost = min[start];
                    } else {
                        currentCost = res / (6 - start) + ((res % (6 - start)) != 0 ? 1 : 0);
                    }
                    result += currentCost;
                    res = Math.max(0, res - (6 - start) * currentCost);
                    start++;
                }
            }
            if (end > 1 && max[end] <= 0) {
                end--;
            }
            if (start < min.length && min[start] == 0) {
                start++;
            }
        }
        if (res != 0) {
            while (start < min.length - 1) {
                if (min[start] != 0) {
                    int currentCost;
                    if (res - (6 - start) * min[start] >= 0) {
                        currentCost = min[start];
                    } else {
                        currentCost = res / (6 - start) + ((res % (6 - start)) != 0 ? 1 : 0);
                    }
                    result += currentCost;
                    res = Math.max(0, res - (6 - start) * currentCost);
                }
                start++;
            }
            while (end > 1) {
                if (max[end] != 0) {
                    int currentCost;
                    if (res - (end - 1) * max[end] >= 0) {
                        currentCost = max[end];
                    } else {
                        currentCost = res / (end - 1) + ((res % (end - 1)) != 0 ? 1 : 0);
                    }
                    result += currentCost;
                    res = Math.max(0, res - (end - 1) * currentCost);
                }
                end--;
            }
        }
        return res != 0 ? - 1 : result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}