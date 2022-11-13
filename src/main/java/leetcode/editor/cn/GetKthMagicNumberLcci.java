//有些数的素因子只有 3，5，7，请设计一个算法找出第 k 个数。注意，不是必须有这些素因子，而是必须不包含其他的素因子。例如，前几个数按顺序应该是 1，3，
//5，7，9，15，21。 
//
// 示例 1: 
//
// 输入: k = 5
//
//输出: 9
// 
//
// Related Topics 哈希表 数学 动态规划 堆（优先队列） 👍 187 👎 0

package leetcode.editor.cn; //如果你的算法题是中文的，后缀就是cn，如果是英文的就是en

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * @author  YourName
 * @date 2022-09-28 19:04:44
 */
public class GetKthMagicNumberLcci{
    public static void main(String[] args) {
        Solution solution = new GetKthMagicNumberLcci().new Solution();
        System.out.println(solution.getKthMagicNumber1(643));
   }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int getKthMagicNumber(int k) {
        if (k == 1) {
            return 1;
        }
        PriorityQueue<Long> queue = new PriorityQueue<>();
        queue.add(1l);
        Set<Long> set = new HashSet<>();
        for (int i = 1; i < k; i++) {
            long current = queue.poll();
            if (set.add(current * 3)) {
                queue.offer(current * 3);
            }
            if (set.add(current * 5)) {
                queue.offer(current * 5);
            }
            if (set.add(current * 7)) {
                queue.offer(current * 7);
            }
        }
        return queue.poll().intValue();
    }
    public int getKthMagicNumber1(int k) {
        int[] dp = new int[k];
        int p3 = 0;
        int p5 = 0;
        int p7 = 0;
        dp[0] = 1;
        for (int i = 1; i < k; i++) {
            int result3 = dp[p3] * 3;
            int result5 = dp[p5] * 5;
            int result7 = dp[p7] * 7;
            dp[i] = Math.min(result7, Math.min(result5, result3));
            if (result3 == dp[i]) {
                p3++;
            }
            if (result5 == dp[i]) {
                p5++;
            }
            if (result7 == dp[i]) {
                p7++;
            }
        }
        return dp[k - 1];
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}