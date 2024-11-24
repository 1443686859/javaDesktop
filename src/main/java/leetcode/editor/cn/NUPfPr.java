/**
给定一个非空的正整数数组 nums ，请判断能否将这些数字分成元素和相等的两部分。 

 

 示例 1： 

 
输入：nums = [1,5,11,5]
输出：true
解释：nums 可以分割成 [1, 5, 5] 和 [11] 。 

 示例 2： 

 
输入：nums = [1,2,3,5]
输出：false
解释：nums 不可以分为和相等的两部分
 

 

 
 

 提示： 

 
 1 <= nums.length <= 200 
 1 <= nums[i] <= 100 
 

 

 
 注意：本题与主站 416 题相同： https://leetcode-cn.com/problems/partition-equal-subset-sum/ 


 👍 96 👎 0

*/
package leetcode.editor.cn; //如果你的算法题是中文的，后缀就是cn，如果是英文的就是en

import java.util.HashMap;
import java.util.Map;

/**
 * @author  YourName
 * @date 2024-08-20 00:31:35
 */
public class NUPfPr{
    public static void main(String[] args) {
        Solution solution = new NUPfPr().new Solution();
        System.out.println(solution.canPartition(new int[]{100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,99,97}));
   }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {


    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int i : nums) {
            sum += i;
        }
        if ((sum & 1) != 0) {
            return false;
        }
        boolean[] result = new boolean[sum / 2 + 1];
        result[0] = true;
        for (int num : nums) {
            for (int j = result.length - 1 - num; j >= 0; j--) {
                if (result[j]) {
                    result[j + num] = true;
                    if (result[sum / 2]) {
                        return result[sum / 2];
                    }
                }
            }
        }
        return false;
    }

}
//leetcode submit region end(Prohibit modification and deletion)

}