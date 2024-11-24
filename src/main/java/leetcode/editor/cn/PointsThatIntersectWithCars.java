/**
给你一个下标从 0 开始的二维整数数组 nums 表示汽车停放在数轴上的坐标。对于任意下标 i，nums[i] = [starti, endi] ，其中 
starti 是第 i 辆车的起点，endi 是第 i 辆车的终点。 

 返回数轴上被车 任意部分 覆盖的整数点的数目。 

 

 示例 1： 

 
输入：nums = [[3,6],[1,5],[4,7]]
输出：7
解释：从 1 到 7 的所有点都至少与一辆车相交，因此答案为 7 。
 

 示例 2： 

 
输入：nums = [[1,3],[5,8]]
输出：7
解释：1、2、3、5、6、7、8 共计 7 个点满足至少与一辆车相交，因此答案为 7 。
 

 

 提示： 

 
 1 <= nums.length <= 100 
 nums[i].length == 2 
 1 <= starti <= endi <= 100 
 

 👍 42 👎 0

*/
package leetcode.editor.cn; //如果你的算法题是中文的，后缀就是cn，如果是英文的就是en

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author  YourName
 * @date 2024-09-15 23:00:15
 */
public class PointsThatIntersectWithCars{
    public static void main(String[] args) {
        Solution solution = new PointsThatIntersectWithCars().new Solution();
        System.out.println(solution.numberOfPoints(Arrays.asList(Arrays.asList(3,6), Arrays.asList(1,5), Arrays.asList(4,7))));
   }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int numberOfPoints(List<List<Integer>> nums) {
        int[] count = new int[102];
        for (List<Integer> n : nums) {
            count[n.get(0)]++;
            count[n.get(1) + 1]--;
        }
        int result = 0;
        int sum = 0;
        for (int i = 0; i <= 101; i++) {
            sum += count[i];
            if (sum > 0) {
                result++;
            }
        }
        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}