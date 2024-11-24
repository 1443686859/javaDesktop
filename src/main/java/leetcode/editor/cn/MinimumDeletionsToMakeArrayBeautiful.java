//给你一个下标从 0 开始的整数数组 nums ，如果满足下述条件，则认为数组 nums 是一个 美丽数组 ： 
//
// 
// nums.length 为偶数 
// 对所有满足 i % 2 == 0 的下标 i ，nums[i] != nums[i + 1] 均成立 
// 
//
// 注意，空数组同样认为是美丽数组。 
//
// 你可以从 nums 中删除任意数量的元素。当你删除一个元素时，被删除元素右侧的所有元素将会向左移动一个单位以填补空缺，而左侧的元素将会保持 不变 。 
//
// 返回使 nums 变为美丽数组所需删除的 最少 元素数目。 
//
// 
//
// 示例 1： 
//
// 输入：nums = [1,1,2,3,5]
//输出：1
//解释：可以删除 nums[0] 或 nums[1] ，这样得到的 nums = [1,2,3,5] 是一个美丽数组。可以证明，要想使 nums 变为美丽数组
//，至少需要删除 1 个元素。 
//
// 示例 2： 
//
// 输入：nums = [1,1,2,2,3,3]
//输出：2
//解释：可以删除 nums[0] 和 nums[5] ，这样得到的 nums = [1,2,2,3] 是一个美丽数组。可以证明，要想使 nums 变为美丽数组
//，至少需要删除 2 个元素。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 10⁵ 
// 0 <= nums[i] <= 10⁵ 
// 
//
// Related Topics 栈 贪心 数组 👍 36 👎 0

package leetcode.editor.cn; //如果你的算法题是中文的，后缀就是cn，如果是英文的就是en

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author  YourName
 * @date 2023-11-21 00:51:34
 */
public class MinimumDeletionsToMakeArrayBeautiful{
    public static void main(String[] args) {
        Solution solution = new MinimumDeletionsToMakeArrayBeautiful().new Solution();
        System.out.println(solution.minDeletion(new int[] {1,1,2,2,3,3}));
   }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int minDeletion(int[] nums) {
        int count = 0;
        int index = 0;
        int n = nums.length;
        while (index < n) {
            int currentIndex = index - count;
            int nextIndex = index + 1;
            if ((currentIndex & 1) == 0 && nextIndex < n && nums[index] == nums[nextIndex]) {
                count++;
            }
            index++;
        }
        return count + ((n - count) & 1);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}