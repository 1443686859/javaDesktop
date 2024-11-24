//给定一个放有字母和数字的数组，找到最长的子数组，且包含的字母和数字的个数相同。 
//
// 返回该子数组，若存在多个最长子数组，返回左端点下标值最小的子数组。若不存在这样的数组，返回一个空数组。 
//
// 示例 1: 
//
// 
//输入: ["A","1","B","C","D","2","3","4","E","5","F","G","6","7","H","I","J","K",
//"L","M"]
//
//输出: ["A","1","B","C","D","2","3","4","E","5","F","G","6","7"]
// 
//
// 示例 2: 
//
// 
//输入: ["A","A"]
//
//输出: []
// 
//
// 提示： 
//
// 
// array.length <= 100000 
// 
//
// Related Topics 数组 哈希表 前缀和 👍 104 👎 0

package leetcode.editor.cn; //如果你的算法题是中文的，后缀就是cn，如果是英文的就是en

import java.util.HashMap;
import java.util.Map;

/**
 * @author  YourName
 * @date 2023-03-11 12:15:34
 */
public class FindLongestSubarrayLcci{
    public static void main(String[] args) {
        Solution solution = new FindLongestSubarrayLcci().new Solution();
   }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String[] findLongestSubarray(String[] array) {
        int n = array.length;
        int count = 0;
        Map<Integer, Integer> countMap = new HashMap<>();
        countMap.put(0, - 1);
        int maxIndex = 0;
        int max = 0;
        for (int i = 0; i < n; i++) {
            if (Character.isDigit(array[i].charAt(0))) {
                count++;
            } else {
                count--;
            }
            if (!countMap.containsKey(count)) {
                countMap.put(count, i);
            }
            int currentResult = i - countMap.get(count);
            if (currentResult > max) {
                max = currentResult;
                maxIndex = countMap.get(count) + 1;
            }
        }
        if (max == 0) {
            return new String[0];
        }
        String[] result = new String[max];
        System.arraycopy(array, maxIndex, result, 0, max);
        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}