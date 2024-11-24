/**
给你一个整数数组 nums。 

 返回两个（不一定不同的）质数在 nums 中 下标 的 最大距离。 

 

 示例 1： 

 
 输入： nums = [4,2,9,5,3] 
 

 输出： 3 

 解释： nums[1]、nums[3] 和 nums[4] 是质数。因此答案是 |4 - 1| = 3。 

 示例 2： 

 
 输入： nums = [4,8,2,8] 
 

 输出： 0 

 解释： nums[2] 是质数。因为只有一个质数，所以答案是 |2 - 2| = 0。 

 

 提示： 

 
 1 <= nums.length <= 3 * 10⁵ 
 1 <= nums[i] <= 100 
 输入保证 nums 中至少有一个质数。 
 

 👍 26 👎 0

*/
package leetcode.editor.cn; //如果你的算法题是中文的，后缀就是cn，如果是英文的就是en
 /**
 * @author  YourName
 * @date 2024-07-02 21:06:58
 */
public class MaximumPrimeDifference{
    public static void main(String[] args) {
        Solution solution = new MaximumPrimeDifference().new Solution();
        System.out.println(solution.maximumPrimeDifference(new int[]{1,7}));
   }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maximumPrimeDifference(int[] nums) {
        int max = -1;
        for (int i : nums) {
            max = Math.max(max, i);
        }
        boolean[] used = new boolean[max + 1];
        int[] prime = new int[max + 1];
        used[1] = true;
        int index = 0;
        for (int i = 2; i <= max; i++) {
            if (!used[i]) {
                prime[index++] = i;
            }
            int j = 0;
            while (j < index && prime[j] * i <= max) {
                used[prime[j] * i] = true;
                if (i % prime[j] == 0) {
                    break;
                }
                j++;
            }
        }
        int maxIndex = -1;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (!used[nums[i]]) {
                min = Math.min(min, i);
                maxIndex = Math.max(maxIndex, i);
            }
        }
        return maxIndex - min;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}