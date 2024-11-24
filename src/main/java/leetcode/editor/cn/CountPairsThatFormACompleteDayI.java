/**
给你一个整数数组 hours，表示以 小时 为单位的时间，返回一个整数，表示满足 i < j 且 hours[i] + hours[j] 构成 整天 的下标对 
i, j 的数目。 

 整天 定义为时间持续时间是 24 小时的 整数倍 。 

 例如，1 天是 24 小时，2 天是 48 小时，3 天是 72 小时，以此类推。 

 

 示例 1： 

 
 输入： hours = [12,12,30,24,24] 
 

 输出： 2 

 解释： 

 构成整天的下标对分别是 (0, 1) 和 (3, 4)。 

 示例 2： 

 
 输入： hours = [72,48,24,3] 
 

 输出： 3 

 解释： 

 构成整天的下标对分别是 (0, 1)、(0, 2) 和 (1, 2)。 

 

 提示： 

 
 1 <= hours.length <= 100 
 1 <= hours[i] <= 10⁹ 
 

 👍 24 👎 0

*/
package leetcode.editor.cn; //如果你的算法题是中文的，后缀就是cn，如果是英文的就是en
 /**
 * @author  YourName
 * @date 2024-10-22 22:00:41
 */
public class CountPairsThatFormACompleteDayI{
    public static void main(String[] args) {
        Solution solution = new CountPairsThatFormACompleteDayI().new Solution();
   }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int countCompleteDayPairs(int[] hours) {
        int[] count = new int[24];
        int result = 0;
        for (int i : hours) {
            int temp = i % 24;
            result += count[(24 - temp) % 24];
            count[temp]++;
        }
        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}