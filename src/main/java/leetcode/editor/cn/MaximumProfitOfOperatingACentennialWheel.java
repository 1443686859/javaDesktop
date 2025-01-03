//你正在经营一座摩天轮，该摩天轮共有 4 个座舱 ，每个座舱 最多可以容纳 4 位游客 。你可以 逆时针 轮转座舱，但每次轮转都需要支付一定的运行成本 
//runningCost 。摩天轮每次轮转都恰好转动 1 / 4 周。 
//
// 给你一个长度为 n 的数组 customers ， customers[i] 是在第 i 次轮转（下标从 0 开始）之前到达的新游客的数量。这也意味着你必
//须在新游客到来前轮转 i 次。每位游客在登上离地面最近的座舱前都会支付登舱成本 boardingCost ，一旦该座舱再次抵达地面，他们就会离开座舱结束游玩。 
//
//
// 你可以随时停下摩天轮，即便是 在服务所有游客之前 。如果你决定停止运营摩天轮，为了保证所有游客安全着陆，将免费进行所有后续轮转 。注意，如果有超过 4 位
//游客在等摩天轮，那么只有 4 位游客可以登上摩天轮，其余的需要等待 下一次轮转 。 
//
// 返回最大化利润所需执行的 最小轮转次数 。 如果不存在利润为正的方案，则返回 -1 。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：customers = [8,3], boardingCost = 5, runningCost = 6
//输出：3
//解释：座舱上标注的数字是该座舱的当前游客数。
//1. 8 位游客抵达，4 位登舱，4 位等待下一舱，摩天轮轮转。当前利润为 4 * $5 - 1 * $6 = $14 。
//2. 3 位游客抵达，4 位在等待的游客登舱，其他 3 位等待，摩天轮轮转。当前利润为 8 * $5 - 2 * $6 = $28 。
//3. 最后 3 位游客登舱，摩天轮轮转。当前利润为 11 * $5 - 3 * $6 = $37 。
//轮转 3 次得到最大利润，最大利润为 $37 。 
//
// 示例 2： 
//
// 
//输入：customers = [10,9,6], boardingCost = 6, runningCost = 4
//输出：7
//解释：
//1. 10 位游客抵达，4 位登舱，6 位等待下一舱，摩天轮轮转。当前利润为 4 * $6 - 1 * $4 = $20 。
//2. 9 位游客抵达，4 位登舱，11 位等待（2 位是先前就在等待的，9 位新加入等待的），摩天轮轮转。当前利润为 8 * $6 - 2 * $4 = $
//40 。
//3. 最后 6 位游客抵达，4 位登舱，13 位等待，摩天轮轮转。当前利润为 12 * $6 - 3 * $4 = $60 。
//4. 4 位登舱，9 位等待，摩天轮轮转。当前利润为 * $6 - 4 * $4 = $80 。
//5. 4 位登舱，5 位等待，摩天轮轮转。当前利润为 20 * $6 - 5 * $4 = $100 。
//6. 4 位登舱，1 位等待，摩天轮轮转。当前利润为 24 * $6 - 6 * $4 = $120 。
//7. 1 位登舱，摩天轮轮转。当前利润为 25 * $6 - 7 * $4 = $122 。
//轮转 7 次得到最大利润，最大利润为$122 。
// 
//
// 示例 3： 
//
// 
//输入：customers = [3,4,0,5,1], boardingCost = 1, runningCost = 92
//输出：-1
//解释：
//1. 3 位游客抵达，3 位登舱，0 位等待，摩天轮轮转。当前利润为 3 * $1 - 1 * $92 = -$89 。
//2. 4 位游客抵达，4 位登舱，0 位等待，摩天轮轮转。当前利润为 is 7 * $1 - 2 * $92 = -$177 。
//3. 0 位游客抵达，0 位登舱，0 位等待，摩天轮轮转。当前利润为 7 * $1 - 3 * $92 = -$269 。
//4. 5 位游客抵达，4 位登舱，1 位等待，摩天轮轮转。当前利润为 12 * $1 - 4 * $92 = -$356 。
//5. 1 位游客抵达，2 位登舱，0 位等待，摩天轮轮转。当前利润为 13 * $1 - 5 * $92 = -$447 。
//利润永不为正，所以返回 -1 。
// 
//
// 
//
// 提示： 
//
// 
// n == customers.length 
// 1 <= n <= 10⁵ 
// 0 <= customers[i] <= 50 
// 1 <= boardingCost, runningCost <= 100 
// 
//
// Related Topics 数组 模拟 👍 13 👎 0

package leetcode.editor.cn; //如果你的算法题是中文的，后缀就是cn，如果是英文的就是en
 /**
 * @author  YourName
 * @date 2023-03-05 00:25:43
 */
public class MaximumProfitOfOperatingACentennialWheel{
    public static void main(String[] args) {
        Solution solution = new MaximumProfitOfOperatingACentennialWheel().new Solution();
        System.out.println(solution.minOperationsMaxProfit(new int[]{19,42,25,18,34,24,22,11,38,33,50,33,50,26,10,4,46,5,3,50,38,20,13,1,28,6,37,11,1,9,39,13,4,14,3,39,39,0,16,11,12,16,2,28,46,33,49,43,9,23,43,40}, 35,96));
   }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int minOperationsMaxProfit(int[] customers, int boardingCost, int runningCost) {
        if (4 * boardingCost < runningCost) {
            return -1;
        }
        int sum = 0;
        int sumP = 0;
        int temp = 0;
        int index = -1;
        int max = 0;
        for (int i = 0; i < customers.length; i++) {
            sum += customers[i];
            int min = Math.min(4, sum);
            sum -= min;
            sumP += min* boardingCost - runningCost;
            temp++;
            if (max < sumP) {
                max = sumP;
                index = temp;
            }
        }
        while (sum > 0) {
            int min = Math.min(4, sum);
            sum -= min;
            sumP += min* boardingCost - runningCost;
            temp++;
            if (max < sumP) {
                max = sumP;
                index = temp;
            }
        }
        return index;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}