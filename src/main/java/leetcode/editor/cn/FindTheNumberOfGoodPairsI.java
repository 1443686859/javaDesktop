/**
给你两个整数数组 nums1 和 nums2，长度分别为 n 和 m。同时给你一个正整数 k。 

 如果 nums1[i] 可以被 nums2[j] * k 整除，则称数对 (i, j) 为 优质数对（0 <= i <= n - 1, 0 <= j <= 
m - 1）。 

 返回 优质数对 的总数。 

 

 示例 1： 

 
 输入：nums1 = [1,3,4], nums2 = [1,3,4], k = 1 
 

 输出：5 

 解释： 

 5个优质数对分别是 (0, 0), (1, 0), (1, 1), (2, 0), 和 (2, 2)。 

 示例 2： 

 
 输入：nums1 = [1,2,4,12], nums2 = [2,4], k = 3 
 

 输出：2 

 解释： 

 2个优质数对分别是 (3, 0) 和 (3, 1)。 

 

 提示： 

 
 1 <= n, m <= 50 
 1 <= nums1[i], nums2[j] <= 50 
 1 <= k <= 50 
 

 👍 16 👎 0

*/
package leetcode.editor.cn; //如果你的算法题是中文的，后缀就是cn，如果是英文的就是en

import java.util.HashMap;
import java.util.Map;

/**
 * @author  YourName
 * @date 2024-10-10 20:26:19
 */
public class FindTheNumberOfGoodPairsI{
    public static void main(String[] args) {
        Solution solution = new FindTheNumberOfGoodPairsI().new Solution();
        System.out.println(solution.numberOfPairs(new int[]{5,18}, new int[]{6,9}, 2));
   }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int numberOfPairs(int[] nums1, int[] nums2, int k) {
        Map<Integer, Long> map = new HashMap<>();
        int max = 0;
        int usedCount = 0;
        for (int i : nums1) {
            if (i % k == 0) {
                map.merge(i / k, 1L, Long::sum);
                max = Math.max(max, i / k);
                usedCount++;
            }
        }
        Map<Integer, Long> map2 = new HashMap<>();
        long result = 0;
        for (int i : nums2) {
            if (i == 1) {
                result += usedCount;
                continue;
            }
            if (map2.containsKey(i)) {
                result += map2.get(i);
                continue;
            }
            long temp = 0;
            for (int j = i; j <= max; j += i) {
                temp += map.getOrDefault(j, 0L);
            }
            result += temp;
            map2.put(i, temp);
        }
        return (int) result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}