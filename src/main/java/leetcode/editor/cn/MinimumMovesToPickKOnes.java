/**
给你一个下标从 0 开始的二进制数组 nums，其长度为 n ；另给你一个 正整数 k 以及一个 非负整数 maxChanges 。 

 Alice 在玩一个游戏，游戏的目标是让 Alice 使用 最少 数量的 行动 次数从 nums 中拾起 k 个 1 。游戏开始时，Alice 可以选择数组 
[0, n - 1] 范围内的任何索引 aliceIndex 站立。如果 nums[aliceIndex] == 1 ，Alice 会拾起一个 1 ，并且 
nums[aliceIndex] 变成0（这 不算 作一次行动）。之后，Alice 可以执行 任意数量 的 行动（包括零次），在每次行动中 Alice 必须 恰好 
执行以下动作之一： 

 
 选择任意一个下标 j != aliceIndex 且满足 nums[j] == 0 ，然后将 nums[j] 设置为 1 。这个动作最多可以执行 
maxChanges 次。 
 选择任意两个相邻的下标 x 和 y（|x - y| == 1）且满足 nums[x] == 1, nums[y] == 0 ，然后交换它们的值（将 nums[
y] = 1 和 nums[x] = 0）。如果 y == aliceIndex，在这次行动后 Alice 拾起一个 1 ，并且 nums[y] 变成 0 。 

 

 返回 Alice 拾起 恰好 k 个 1 所需的 最少 行动次数。 

 

 示例 1： 

 
 输入：nums = [1,1,0,0,0,1,1,0,0,1], k = 3, maxChanges = 1 
 

 输出：3 

 解释：如果游戏开始时 Alice 在 aliceIndex == 1 的位置上，按照以下步骤执行每个动作，他可以利用 3 次行动拾取 3 个 1 ： 

 
 游戏开始时 Alice 拾取了一个 1 ，nums[1] 变成了 0。此时 nums 变为 [1,1,1,0,0,1,1,0,0,1] 。 
 选择 j == 2 并执行第一种类型的动作。nums 变为 [1,0,1,0,0,1,1,0,0,1] 
 选择 x == 2 和 y == 1 ，并执行第二种类型的动作。nums 变为 [1,1,0,0,0,1,1,0,0,1] 。由于 y == 
aliceIndex，Alice 拾取了一个 1 ，nums 变为 [1,0,0,0,0,1,1,0,0,1] 。 
 选择 x == 0 和 y == 1 ，并执行第二种类型的动作。nums 变为 [0,1,0,0,0,1,1,0,0,1] 。由于 y == 
aliceIndex，Alice 拾取了一个 1 ，nums 变为 [0,0,0,0,0,1,1,0,0,1] 。 
 

 请注意，Alice 也可能执行其他的 3 次行动序列达成拾取 3 个 1 。 

 示例 2： 

 
 
 输入：nums = [0,0,0,0], k = 2, maxChanges = 3 
 

 输出：4 

 解释：如果游戏开始时 Alice 在 aliceIndex == 0 的位置上，按照以下步骤执行每个动作，他可以利用 4 次行动拾取 2 个 1 ： 

 
 选择 j == 1 并执行第一种类型的动作。nums 变为 [0,1,0,0] 。 
 选择 x == 1 和 y == 0 ，并执行第二种类型的动作。nums 变为 [1,0,0,0] 。由于 y == aliceIndex，Alice 拾起了
一个 1 ，nums 变为 [0,0,0,0] 。 
 再次选择 j == 1 并执行第一种类型的动作。nums 变为 [0,1,0,0] 。 
 再次选择 x == 1 和 y == 0 ，并执行第二种类型的动作。nums 变为 [1,0,0,0] 。由于y == aliceIndex，Alice 拾起
了一个 1 ，nums 变为 [0,0,0,0] 。 
 

 

 提示： 

 
 2 <= n <= 10⁵ 
 0 <= nums[i] <= 1 
 1 <= k <= 10⁵ 
 0 <= maxChanges <= 10⁵ 
 maxChanges + sum(nums) >= k 
 

 👍 34 👎 0

*/
package leetcode.editor.cn; //如果你的算法题是中文的，后缀就是cn，如果是英文的就是en

import java.util.ArrayList;
import java.util.List;

/**
 * @author  YourName
 * @date 2024-07-04 22:15:45
 */
public class MinimumMovesToPickKOnes{
    public static void main(String[] args) {
        Solution solution = new MinimumMovesToPickKOnes().new Solution();
        System.out.println(solution.minimumMoves(new int[]{1,1,1,1,1},5,0));
   }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public long minimumMoves(int[] nums, int k, int maxChanges) {
        int c = 0;
        List<Integer> pos = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                continue;
            }
            pos.add(i);
            c = Math.max(c, 1);
            if (i > 0 && nums[i - 1] == 1) {
                if (i > 1 && nums[i - 2] == 1) {
                    c = Math.max(c, 3);
                } else {
                    c = Math.max(c, 2);
                }
            }
        }
        c = Math.min(c, k);
        if (maxChanges >= k - c) {
            return 2 * (k - c) + Math.max(c - 1, 0);
        }
        int n = pos.size();
        long[] sum = new long[n + 1];
        for (int i = 0; i < n; i++) {
            sum[i + 1] = sum[i] + pos.get(i);
        }
        long ans = Long.MAX_VALUE;
        int rest = k - maxChanges;
        for (int i = rest; i <= n; i++) {
            int right = i;
            int left = i - rest;
            int index = (right + left) / 2;
            long sub1 = (long) (index - left) * pos.get(index) - (sum[index] - sum[left]) ;
            long sub2 = sum[right] - sum[index] - (long) (right - index) * pos.get(index);
            ans = Math.min(ans, sub1 + sub2);
        }
        return ans + 2L * maxChanges;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}