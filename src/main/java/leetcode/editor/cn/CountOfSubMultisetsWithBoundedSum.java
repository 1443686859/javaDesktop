//给你一个下标从 0 开始的非负整数数组 nums 和两个整数 l 和 r 。 
//
// 请你返回 nums 中子多重集合的和在闭区间 [l, r] 之间的 子多重集合的数目 。 
//
// 由于答案可能很大，请你将答案对 109 + 7 取余后返回。 
//
// 子多重集合 指的是从数组中选出一些元素构成的 无序 集合，每个元素 x 出现的次数可以是 0, 1, ..., occ[x] 次，其中 occ[x] 是元
//素 x 在数组中的出现次数。 
//
// 注意： 
//
// 
// 如果两个子多重集合中的元素排序后一模一样，那么它们两个是相同的 子多重集合 。 
// 空 集合的和是 0 。 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,2,2,3], l = 6, r = 6
//输出：1
//解释：唯一和为 6 的子集合是 {1, 2, 3} 。
// 
//
// 示例 2： 
//
// 
//输入：nums = [2,1,4,2,7], l = 1, r = 5
//输出：7
//解释：和在闭区间 [1, 5] 之间的子多重集合为 {1} ，{2} ，{4} ，{2, 2} ，{1, 2} ，{1, 4} 和 {1, 2, 2} 。
// 
//
// 示例 3： 
//
// 
//输入：nums = [1,2,1,3,5,2], l = 3, r = 5
//输出：9
//解释：和在闭区间 [3, 5] 之间的子多重集合为 {3} ，{5} ，{1, 2} ，{1, 3} ，{2, 2} ，{2, 3} ，{1, 1, 2} 
//，{1, 1, 3} 和 {1, 2, 2} 。 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 2 * 10⁴ 
// 0 <= nums[i] <= 2 * 10⁴ 
// nums 的和不超过 2 * 10⁴ 。 
// 0 <= l <= r <= 2 * 10⁴ 
// 
//
// 👍 6 👎 0

package leetcode.editor.cn; //如果你的算法题是中文的，后缀就是cn，如果是英文的就是en

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author  YourName
 * @date 2023-10-16 22:11:02
 */
public class CountOfSubMultisetsWithBoundedSum{
    public static void main(String[] args) {
        Solution solution = new CountOfSubMultisetsWithBoundedSum().new Solution();
        System.out.println(solution.countSubMultisets(Arrays.asList(2,2,2,3), 5, 9));
   }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int countSubMultisets(List<Integer> nums, int l, int r) {
        Map<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        for (int i : nums) {
            sum += i;
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        if (l > sum) {
            return 0;
        }
        int mod = 1_000_000_007;
        int[] f = new int[r + 1];
        f[0] = map.getOrDefault(0, 0) + 1;
        map.remove(0);
        sum = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int key = entry.getKey();
            int count = entry.getValue();
            sum = Math.min(sum + count * key, r);
            for (int i = sum; i >= key * (count + 1); i--) {
                f[i] = (f[i] - f[i - key * (count + 1)] + mod) % mod;
            }
            for (int i = key; i <= sum; i++) {
                f[i] = (f[i] + f[i - key]) % mod;
            }
        }
        int ans = 0;
        for (int i = l; i <= r; i++) {
            ans = (ans + f[i]) % mod;
        }
        return ans;

    }
}
//leetcode submit region end(Prohibit modification and deletion)

}