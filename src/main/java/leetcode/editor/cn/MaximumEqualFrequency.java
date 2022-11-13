//给你一个正整数数组 nums，请你帮忙从该数组中找出能满足下面要求的 最长 前缀，并返回该前缀的长度： 
//
// 
// 从前缀中 恰好删除一个 元素后，剩下每个数字的出现次数都相同。 
// 
//
// 如果删除这个元素后没有剩余元素存在，仍可认为每个数字都具有相同的出现次数（也就是 0 次）。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [2,2,1,1,5,3,3,5]
//输出：7
//解释：对于长度为 7 的子数组 [2,2,1,1,5,3,3]，如果我们从中删去 nums[4] = 5，就可以得到 [2,2,1,1,3,3]，里面每个数
//字都出现了两次。
// 
//
// 示例 2： 
//
// 
//输入：nums = [1,1,1,2,2,2,3,3,3,4,4,4,5]
//输出：13
// 
//
// 
//
// 提示： 
//
// 
// 2 <= nums.length <= 10⁵ 
// 1 <= nums[i] <= 10⁵ 
// 
//
// Related Topics 数组 哈希表 👍 157 👎 0

package leetcode.editor.cn; //如果你的算法题是中文的，后缀就是cn，如果是英文的就是en

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author  YourName
 * @date 2022-08-18 20:25:28
 */
public class MaximumEqualFrequency{
    public static void main(String[] args) {
        Solution solution = new MaximumEqualFrequency().new Solution();
        System.out.println(solution.maxEqualFreq(new int[]{1,1,1,2,2,2,3,3,3}));
   }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maxEqualFreq(int[] nums) {
        Map<Integer, Integer> countMap = new HashMap<>();
        Map<Integer, Integer> countCountMap = new HashMap<>();
        int result = 0;
        for (int i : nums) {
            int currentVal = countMap.getOrDefault(i, 0);
            int current = currentVal + 1;
            if (countCountMap.containsKey(currentVal)) {
                countCountMap.put(currentVal, countCountMap.get(currentVal) - 1);
                if (countCountMap.get(currentVal) == 0) {
                    countCountMap.remove(currentVal);
                }
            }
            countCountMap.put(current, countCountMap.getOrDefault(current, 0) + 1);
            countMap.put(i, countMap.getOrDefault(i, 0) + 1);
            boolean isUsed = false;
            if (countCountMap.size() == 2) {
                Integer[] keys = new Integer[2];
                countCountMap.keySet().toArray(keys);
                if (countCountMap.containsKey(1) && countCountMap.get(1) == 1) {
                  isUsed = true;
                } else if (Math.abs(keys[0] - keys[1]) == 1 ) {
                    int max = Math.max(keys[0], keys[1]);
                    if (countCountMap.get(max) == 1) {
                        isUsed = true;
                    }
                }
            } else if (countCountMap.size() == 1) {
                if (countCountMap.containsKey(1) && countCountMap.get(1) == 2 || countCountMap.containsKey(2) && countCountMap.get(2) == 1 || countMap.size() == 1) {
                    isUsed = true;
                }
            }
            if (isUsed) {
                int currentResult = 0;
                for (Map.Entry<Integer, Integer> entry : countCountMap.entrySet()) {
                    currentResult += entry.getKey() * entry.getValue();
                }
                result = Math.max(result, currentResult);
            }
        }
        if (nums.length == countMap.size()) {
            return nums.length;
        }
        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}