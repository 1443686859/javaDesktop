/**
Alice 有 n 枚糖，其中第 i 枚糖的类型为 candyType[i] 。Alice 注意到她的体重正在增长，所以前去拜访了一位医生。 

 医生建议 Alice 要少摄入糖分，只吃掉她所有糖的 n / 2 即可（n 是一个偶数）。Alice 非常喜欢这些糖，她想要在遵循医生建议的情况下，尽可能吃到
最多不同种类的糖。 

 给你一个长度为 n 的整数数组 candyType ，返回： Alice 在仅吃掉 n / 2 枚糖的情况下，可以吃到糖的 最多 种类数。 

 

 示例 1： 

 
输入：candyType = [1,1,2,2,3,3]
输出：3
解释：Alice 只能吃 6 / 2 = 3 枚糖，由于只有 3 种糖，她可以每种吃一枚。
 

 示例 2： 

 
输入：candyType = [1,1,2,3]
输出：2
解释：Alice 只能吃 4 / 2 = 2 枚糖，不管她选择吃的种类是 [1,2]、[1,3] 还是 [2,3]，她只能吃到两种不同类的糖。
 

 示例 3： 

 
输入：candyType = [6,6,6,6]
输出：1
解释：Alice 只能吃 4 / 2 = 2 枚糖，尽管她能吃 2 枚，但只能吃到 1 种糖。
 

 

 提示： 

 
 n == candyType.length 
 2 <= n <= 10⁴ 
 n 是一个偶数 
 -10⁵ <= candyType[i] <= 10⁵ 
 

 👍 261 👎 0

*/
package leetcode.editor.cn; //如果你的算法题是中文的，后缀就是cn，如果是英文的就是en

import java.util.*;

/**
 * @author  YourName
 * @date 2024-06-02 00:12:33
 */
public class DistributeCandies{
    public static void main(String[] args) {
        Solution solution = new DistributeCandies().new Solution();
   }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int distributeCandies(int[] candyType) {
        boolean[] used= new boolean[2 * (1_000_00) + 2];
        int result = 0;
        for (int i : candyType) {
            if (!used[i + 100000]) {
                result++;
            }
            used[i + 100000] = true;
        }
        return Math.min(result, candyType.length / 2);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}