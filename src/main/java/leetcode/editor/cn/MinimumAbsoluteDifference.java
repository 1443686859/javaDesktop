//给你个整数数组 arr，其中每个元素都 不相同。 
//
// 请你找到所有具有最小绝对差的元素对，并且按升序的顺序返回。 
//
// 
//
// 示例 1： 
//
// 输入：arr = [4,2,1,3]
//输出：[[1,2],[2,3],[3,4]]
// 
//
// 示例 2： 
//
// 输入：arr = [1,3,6,10,15]
//输出：[[1,3]]
// 
//
// 示例 3： 
//
// 输入：arr = [3,8,-10,23,19,-4,-14,27]
//输出：[[-14,-10],[19,23],[23,27]]
// 
//
// 
//
// 提示： 
//
// 
// 2 <= arr.length <= 10^5 
// -10^6 <= arr[i] <= 10^6 
// 
// Related Topics 数组 排序 👍 106 👎 0

package leetcode.editor.cn; //如果你的算法题是中文的，后缀就是cn，如果是英文的就是en

import java.util.*;

/**
 * @author  YourName
 * @date 2022-07-04 19:56:10
 */
public class MinimumAbsoluteDifference{
    public static void main(String[] args) {
        Solution solution = new MinimumAbsoluteDifference().new Solution();
   }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        Arrays.sort(arr);
        int n = arr.length;
        Map<Integer, List<List<Integer>>> map = new HashMap<>();
        int min = Integer.MAX_VALUE;
        for (int i = 1; i < n; i++) {
            int current = arr[i] - arr[i - 1];
            if (current <= min) {
                List<Integer> result = new ArrayList<>();
                result.add(arr[i - 1]);
                result.add(arr[i]);
                List<List<Integer>> nowList = map.getOrDefault(current, new ArrayList<>());
                nowList.add(result);
                map.put(current, nowList);
                min = current;
            }
        }
        return map.get(min);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}