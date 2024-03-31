//一个厨师收集了他 n 道菜的满意程度 satisfaction ，这个厨师做出每道菜的时间都是 1 单位时间。 
//
// 一道菜的 「 like-time 系数 」定义为烹饪这道菜结束的时间（包含之前每道菜所花费的时间）乘以这道菜的满意程度，也就是 time[i]*
//satisfaction[i] 。 
//
// 返回厨师在准备了一定数量的菜肴后可以获得的最大 like-time 系数 总和。 
//
// 你可以按 任意 顺序安排做菜的顺序，你也可以选择放弃做某些菜来获得更大的总和。 
//
// 
//
// 示例 1： 
//
// 
//输入：satisfaction = [-1,-8,0,5,-9]
//输出：14
//解释：去掉第二道和最后一道菜，最大的 like-time 系数和为 (-1*1 + 0*2 + 5*3 = 14) 。每道菜都需要花费 1 单位时间完成。 
//
//
// 示例 2： 
//
// 
//输入：satisfaction = [4,3,2]
//输出：20
//解释：可以按照任意顺序做菜 (2*1 + 3*2 + 4*3 = 20)
// 
//
// 示例 3： 
//
// 
//输入：satisfaction = [-1,-4,-5]
//输出：0
//解释：大家都不喜欢这些菜，所以不做任何菜就可以获得最大的 like-time 系数。
// 
//
// 
//
// 提示： 
//
// 
// n == satisfaction.length 
// 1 <= n <= 500 
// -1000 <= satisfaction[i] <= 1000 
// 
//
// Related Topics 贪心 数组 动态规划 排序 👍 122 👎 0

package leetcode.editor.cn; //如果你的算法题是中文的，后缀就是cn，如果是英文的就是en

import java.util.Arrays;

/**
 * @author  YourName
 * @date 2023-10-22 09:07:12
 */
public class ReducingDishes{
    public static void main(String[] args) {
        Solution solution = new ReducingDishes().new Solution();
        System.out.println(solution.maxSatisfaction(new int[]{-1,-8,0,5,-9}));
   }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maxSatisfaction(int[] satisfaction) {
        Arrays.sort(satisfaction);
        int start = 1;
        int result = 0;
        int sum = 0;
        int index = -1;
        for (int i = 0; i < satisfaction.length; i++) {
            if (satisfaction[i] >= 0 && index == -1) {
                index = i;
            }
            if (satisfaction[i] >= 0) {
                result += (start ++) * satisfaction[i];
                sum += satisfaction[i];
            }
        }
        index --;
        while (index >= 0 && sum + satisfaction[index] > 0) {
            sum += satisfaction[index];
            result += sum;
            index--;
        }
        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}