//给定一个长度为偶数的整数数组 arr，只有对 arr 进行重组后可以满足 “对于每个 0 <= i < len(arr) / 2，都有 arr[2 * i 
//+ 1] = 2 * arr[2 * i]” 时，返回 true；否则，返回 false。 
//
// 
//
// 示例 1： 
//
// 
//输入：arr = [3,1,3,6]
//输出：false
// 
//
// 示例 2： 
//
// 
//输入：arr = [2,1,2,6]
//输出：false
// 
//
// 示例 3： 
//
// 
//输入：arr = [4,-2,2,-4]
//输出：true
//解释：可以用 [-2,-4] 和 [2,4] 这两组组成 [-2,-4,2,4] 或是 [2,4,-2,-4]
// 
//
// 
//
// 提示： 
//
// 
// 0 <= arr.length <= 3 * 10⁴ 
// arr.length 是偶数 
// -10⁵ <= arr[i] <= 10⁵ 
// 
// Related Topics 贪心 数组 哈希表 排序 👍 138 👎 0

package leetcode.editor.cn; //如果你的算法题是中文的，后缀就是cn，如果是英文的就是en

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author  YourName
 * @date 2022-04-01 18:56:05
 */
public class ArrayOfDoubledPairs{
    public static void main(String[] args) {
        Solution solution = new ArrayOfDoubledPairs().new Solution();
   }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean canReorderDoubled(int[] arr) {
        Arrays.sort(arr);
        Map<Integer, Integer> countMap = new HashMap<>();
        for (int i : arr) {
            if (i <= 0) {
                if (countMap.containsKey(i << 1)) {
                    countMap.put(i << 1, countMap.get(i << 1) - 1);
                    if (countMap.get(i << 1) == 0) {
                        countMap.remove(i << 1);
                    }
                } else {
                    countMap.put(i, countMap.getOrDefault(i, 0) + 1);
                }
            } else {
                if ((i & 1) == 0 && countMap.containsKey(i >> 1)) {
                    countMap.put(i >> 1, countMap.get(i >> 1) - 1);
                    if (countMap.get(i >> 1) == 0) {
                        countMap.remove(i >> 1);
                    }
                } else {
                    countMap.put(i, countMap.getOrDefault(i, 0) + 1);
                }
            }
        }
        return countMap.isEmpty();
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}