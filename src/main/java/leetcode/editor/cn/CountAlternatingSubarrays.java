/**
给你一个二进制数组 nums 。 

 如果一个子数组中 不存在 两个 相邻 元素的值 相同 的情况，我们称这样的子数组为 交替子数组 。 

 返回数组 nums 中交替子数组的数量。 

 

 示例 1： 

 
 输入： nums = [0,1,1,1] 
 

 输出： 5 

 解释： 


 以下子数组是交替子数组：[0] 、[1] 、[1] 、[1] 以及 [0,1] 。 

 示例 2： 

 
 输入： nums = [1,0,1,0] 
 

 输出： 10 

 解释： 


 数组的每个子数组都是交替子数组。可以统计在内的子数组共有 10 个。 

 

 提示： 

 
 1 <= nums.length <= 10⁵ 
 nums[i] 不是 0 就是 1 。 
 

 👍 21 👎 0

*/
package leetcode.editor.cn; //如果你的算法题是中文的，后缀就是cn，如果是英文的就是en

import java.util.ArrayList;
import java.util.List;

/**
 * @author  YourName
 * @date 2024-07-06 13:17:43
 */
public class CountAlternatingSubarrays{
    public static void main(String[] args) {
        Solution solution = new CountAlternatingSubarrays().new Solution();
        System.out.println(solution.countAlternatingSubarrays(new int[]{1,0,1,0,1,0,1,0,1,0,0,1,0,1,0,1}));
   }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public long countAlternatingSubarrays(int[] nums) {
        long sum = 0;
        int n = nums.length;
        long count = 0;
        for (int i = 0; i < n; i++) {
            if (i > 0 && nums[i - 1] == nums[i]) {
                sum += count * (count + 1) / 2;
                count = 1;
            } else {
                count++;
            }
        }
        if (count != 0) {
            sum += count * (count + 1) / 2;
        }
        return sum;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}