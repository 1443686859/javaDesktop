//给你一个下标从 0 开始的非负整数数组 nums 。对于 nums 中每一个整数，你必须找到对应元素的 第二大 整数。 
//
// 如果 nums[j] 满足以下条件，那么我们称它为 nums[i] 的 第二大 整数： 
//
// 
// j > i 
// nums[j] > nums[i] 
// 恰好存在 一个 k 满足 i < k < j 且 nums[k] > nums[i] 。 
// 
//
// 如果不存在 nums[j] ，那么第二大整数为 -1 。 
//
// 
// 比方说，数组 [1, 2, 4, 3] 中，1 的第二大整数是 4 ，2 的第二大整数是 3 ，3 和 4 的第二大整数是 -1 。 
// 
//
// 请你返回一个整数数组 answer ，其中 answer[i]是 nums[i] 的第二大整数。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [2,4,0,9,6]
//输出：[9,6,6,-1,-1]
//解释：
//下标为 0 处：2 的右边，4 是大于 2 的第一个整数，9 是第二个大于 2 的整数。
//下标为 1 处：4 的右边，9 是大于 4 的第一个整数，6 是第二个大于 4 的整数。
//下标为 2 处：0 的右边，9 是大于 0 的第一个整数，6 是第二个大于 0 的整数。
//下标为 3 处：右边不存在大于 9 的整数，所以第二大整数为 -1 。
//下标为 4 处：右边不存在大于 6 的整数，所以第二大整数为 -1 。
//所以我们返回 [9,6,6,-1,-1] 。
// 
//
// 示例 2： 
//
// 
//输入：nums = [3,3]
//输出：[-1,-1]
//解释：
//由于每个数右边都没有更大的数，所以我们返回 [-1,-1] 。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 10⁵ 
// 0 <= nums[i] <= 10⁹ 
// 
//
// Related Topics 栈 数组 二分查找 排序 单调栈 堆（优先队列） 👍 105 👎 0

package leetcode.editor.cn; //如果你的算法题是中文的，后缀就是cn，如果是英文的就是en

import java.util.*;

/**
 * @author  YourName
 * @date 2023-12-12 20:57:23
 */
public class NextGreaterElementIv{
    public static void main(String[] args) {
        Solution solution = new NextGreaterElementIv().new Solution();
   }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] secondGreaterElement(int[] nums) {
        List<Integer> pre = new ArrayList<>();
        List<Integer> current = new ArrayList<>();
        int n = nums.length;
        int[] ans = new int[n];
        Arrays.fill(ans, -1);
        for (int i = 0; i < nums.length; i++) {
            while (!pre.isEmpty() && nums[pre.get(pre.size() - 1)] < nums[i]) {
                ans[pre.get(pre.size() - 1)] = nums[i];
                pre.remove(pre.size() - 1);
            }
            int j = current.size();
            while (j > 0 && nums[current.get(j - 1)] < nums[i]) {
               j--;
            }
            List<Integer> temp = current.subList(j, current.size());
            pre.addAll(temp);
            temp.clear();
            current.add(i);
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}