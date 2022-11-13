//给定两个大小相等的数组 nums1 和 nums2，nums1 相对于 nums2 的优势可以用满足 nums1[i] > nums2[i] 的索引 i 的
//数目来描述。 
//
// 返回 nums1 的任意排列，使其相对于 nums2 的优势最大化。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums1 = [2,7,11,15], nums2 = [1,10,4,11]
//输出：[2,11,7,15]
// 
//
// 示例 2： 
//
// 
//输入：nums1 = [12,24,8,32], nums2 = [13,25,32,11]
//输出：[24,32,8,12]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums1.length <= 10⁵ 
// nums2.length == nums1.length 
// 0 <= nums1[i], nums2[i] <= 10⁹ 
// 
//
// Related Topics 贪心 数组 双指针 排序 👍 315 👎 0

package leetcode.editor.cn; //如果你的算法题是中文的，后缀就是cn，如果是英文的就是en

import java.util.Arrays;

/**
 * @author  YourName
 * @date 2022-10-08 21:06:07
 */
public class AdvantageShuffle{
    public static void main(String[] args) {
        Solution solution = new AdvantageShuffle().new Solution();
   }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] advantageCount(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        int n = nums1.length;
        boolean[] used = new boolean[n];
        int[] result = new int[n];
        int min = 0;
        for (int i = 0; i < n; i++) {
            int left = min;
            int right = n - 1;
            while (left <= right) {
                int mid = (left + right) >> 1;
                if (nums1[mid] > nums2[i]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
            int target = right + 1;
            while (target < n && used[target] == true) {
                target++;
            }
            if (target == n) {
                target = min;
                while (target < n && used[target] == true) {
                    target++;
                    min++;
                }
            }
            used[target] = true;
            result[i] = nums1[target];
        }
        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}