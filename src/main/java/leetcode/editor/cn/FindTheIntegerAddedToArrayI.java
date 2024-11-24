/**
给你两个长度相等的数组 nums1 和 nums2。 

 数组 nums1 中的每个元素都与变量 x 所表示的整数相加。如果 x 为负数，则表现为元素值的减少。 

 在与 x 相加后，nums1 和 nums2 相等 。当两个数组中包含相同的整数，并且这些整数出现的频次相同时，两个数组 相等 。 

 返回整数 x 。 

 

 示例 1: 

 
 输入：nums1 = [2,6,4], nums2 = [9,7,5] 
 

 输出：3 

 解释： 

 与 3 相加后，nums1 和 nums2 相等。 

 示例 2: 

 
 输入：nums1 = [10], nums2 = [5] 
 

 输出：-5 

 解释： 

 与 -5 相加后，nums1 和 nums2 相等。 

 示例 3: 

 
 输入：nums1 = [1,1,1,1], nums2 = [1,1,1,1] 
 

 输出：0 

 解释： 

 与 0 相加后，nums1 和 nums2 相等。 

 

 提示： 

 
 1 <= nums1.length == nums2.length <= 100 
 0 <= nums1[i], nums2[i] <= 1000 
 测试用例以这样的方式生成：存在一个整数 x，使得 nums1 中的每个元素都与 x 相加后，nums1 与 nums2 相等。 
 

 👍 28 👎 0

*/
package leetcode.editor.cn; //如果你的算法题是中文的，后缀就是cn，如果是英文的就是en

import java.util.Arrays;

/**
 * @author  YourName
 * @date 2024-08-08 21:22:18
 */
public class FindTheIntegerAddedToArrayI{
    public static void main(String[] args) {
        Solution solution = new FindTheIntegerAddedToArrayI().new Solution();
   }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int addedInteger(int[] nums1, int[] nums2) {
        int min1 = Integer.MAX_VALUE;
        int min2 = Integer.MAX_VALUE;
        for (int i = 0; i < nums1.length; i++) {
            min1 = Math.min(min1, nums1[i]);
            min2 = Math.min(min2, nums2[i]);
        }
        return min2 - min1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}