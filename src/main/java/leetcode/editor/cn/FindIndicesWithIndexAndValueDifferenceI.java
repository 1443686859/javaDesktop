/**
给你一个下标从 0 开始、长度为 n 的整数数组 nums ，以及整数 indexDifference 和整数 valueDifference 。 

 你的任务是从范围 [0, n - 1] 内找出 2 个满足下述所有条件的下标 i 和 j ： 

 
 abs(i - j) >= indexDifference 且 
 abs(nums[i] - nums[j]) >= valueDifference 
 

 返回整数数组 answer。如果存在满足题目要求的两个下标，则 answer = [i, j] ；否则，answer = [-1, -1] 。如果存在多组可供
选择的下标对，只需要返回其中任意一组即可。 

 注意：i 和 j 可能 相等 。 

 

 示例 1： 

 
输入：nums = [5,1,4,1], indexDifference = 2, valueDifference = 4
输出：[0,3]
解释：在示例中，可以选择 i = 0 和 j = 3 。
abs(0 - 3) >= 2 且 abs(nums[0] - nums[3]) >= 4 。
因此，[0,3] 是一个符合题目要求的答案。
[3,0] 也是符合题目要求的答案。
 

 示例 2： 

 
输入：nums = [2,1], indexDifference = 0, valueDifference = 0
输出：[0,0]
解释：
在示例中，可以选择 i = 0 和 j = 0 。 
abs(0 - 0) >= 0 且 abs(nums[0] - nums[0]) >= 0 。 
因此，[0,0] 是一个符合题目要求的答案。 
[0,1]、[1,0] 和 [1,1] 也是符合题目要求的答案。 
 

 示例 3： 

 
输入：nums = [1,2,3], indexDifference = 2, valueDifference = 4
输出：[-1,-1]
解释：在示例中，可以证明无法找出 2 个满足所有条件的下标。
因此，返回 [-1,-1] 。 

 

 提示： 

 
 1 <= n == nums.length <= 100 
 0 <= nums[i] <= 50 
 0 <= indexDifference <= 100 
 0 <= valueDifference <= 50 
 

 👍 19 👎 0

*/
package leetcode.editor.cn; //如果你的算法题是中文的，后缀就是cn，如果是英文的就是en

import java.util.*;

/**
 * @author  YourName
 * @date 2024-05-25 13:34:09
 */
public class FindIndicesWithIndexAndValueDifferenceI{
    public static void main(String[] args) {
        Solution solution = new FindIndicesWithIndexAndValueDifferenceI().new Solution();
//        System.out.println(solution.findIndices(new int[]{5,1,4,1},2 ,4));
//        System.out.println(solution.occurrencesOfElement(new int[]{1,3,1,7}, new int[]{1,3,2,4}, 1));
        System.out.println(solution.queryResults(4, new int[][]{{1,4},{2,5},{1,3},{3,4}}));
        }


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] findIndices(int[] nums, int indexDifference, int valueDifference) {
        int maxIndex = -1;
        int minIndex = -1;
        for (int i = 0; i < nums.length; i++) {
            if (i - indexDifference >= 0) {
                if (maxIndex == -1 || nums[maxIndex] < nums[i - indexDifference]) {
                    maxIndex = i - indexDifference;
                }
                if (minIndex == -1 || nums[minIndex] > nums[i - indexDifference]) {
                    minIndex = i - indexDifference;
                }
                if (minIndex != -1 && nums[i] - nums[minIndex] >= valueDifference) {
                    return new int[]{minIndex, i};
                }
                if (maxIndex != -1 && nums[maxIndex] - nums[i] >= valueDifference) {
                    return new int[]{maxIndex, i};
                }
            }
        }
        return new int[]{-1, -1};
    }
    public int duplicateNumbersXOR(int[] nums) {
        Arrays.sort(nums);
        int result = 0;
        for (int i = 1; i < nums.length; i++) {
            if ((nums[i] ^ nums[i  - 1]) == 0) {
                result ^= nums[i];
            }
        }
        return result;
    }
    public int[] occurrencesOfElement(int[] nums, int[] queries, int x) {
        List<Integer> list = new ArrayList<>();
        int[] ans = new int[queries.length];
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == x) {
                list.add(i);
            }
        }
        int index = 0;
        for (int i : queries) {
            if (i > list.size()) {
                ans[index] = -1;
            } else {
                ans[index] = list.get(i - 1);
            }
            index++;
        }
        return ans;
    }
    public int[] queryResults(int limit, int[][] queries) {
        Map<Integer, Integer> used = new HashMap<>();
        Map<Integer, Integer> color = new HashMap<>();
        int[] ans = new int[queries.length];
        int index = 0;
        for (int[] query : queries) {
            int target = query[0];
            int currentColor = query[1];
            int oldColor = used.getOrDefault(target, 0);
            if (oldColor != currentColor) {
                used.put(target, currentColor);
                if (color.containsKey(oldColor)) {
                    color.put(oldColor, color.get(oldColor) - 1);
                    if (color.get(oldColor) == 0) {
                        color.remove(oldColor);
                    }
                }
                color.merge(currentColor, 1, Integer::sum);
            }
            ans[index] = color.size();
            index++;
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}