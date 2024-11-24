/**
给你一个下标从 1 开始、长度为 n 的整数数组 nums 。 

 现定义函数 greaterCount ，使得 greaterCount(arr, val) 返回数组 arr 中 严格大于 val 的元素数量。 

 你需要使用 n 次操作，将 nums 的所有元素分配到两个数组 arr1 和 arr2 中。在第一次操作中，将 nums[1] 追加到 arr1 。在第二次操
作中，将 nums[2] 追加到 arr2 。之后，在第 i 次操作中： 

 
 如果 greaterCount(arr1, nums[i]) > greaterCount(arr2, nums[i]) ，将 nums[i] 追加到 
arr1 。 
 如果 greaterCount(arr1, nums[i]) < greaterCount(arr2, nums[i]) ，将 nums[i] 追加到 
arr2 。 
 如果 greaterCount(arr1, nums[i]) == greaterCount(arr2, nums[i]) ，将 nums[i] 追加到元素数
量较少的数组中。 
 如果仍然相等，那么将 nums[i] 追加到 arr1 。 
 

 连接数组 arr1 和 arr2 形成数组 result 。例如，如果 arr1 == [1,2,3] 且 arr2 == [4,5,6] ，那么 
result = [1,2,3,4,5,6] 。 

 返回整数数组 result 。 

 

 示例 1： 

 
输入：nums = [2,1,3,3]
输出：[2,3,1,3]
解释：在前两次操作后，arr1 = [2] ，arr2 = [1] 。
在第 3 次操作中，两个数组中大于 3 的元素数量都是零，并且长度相等，因此，将 nums[3] 追加到 arr1 。
在第 4 次操作中，两个数组中大于 3 的元素数量都是零，但 arr2 的长度较小，因此，将 nums[4] 追加到 arr2 。
在 4 次操作后，arr1 = [2,3] ，arr2 = [1,3] 。
因此，连接形成的数组 result 是 [2,3,1,3] 。
 

 示例 2： 

 
输入：nums = [5,14,3,1,2]
输出：[5,3,1,2,14]
解释：在前两次操作后，arr1 = [5] ，arr2 = [14] 。
在第 3 次操作中，两个数组中大于 3 的元素数量都是一，并且长度相等，因此，将 nums[3] 追加到 arr1 。
在第 4 次操作中，arr1 中大于 1 的元素数量大于 arr2 中的数量（2 > 1），因此，将 nums[4] 追加到 arr1 。
在第 5 次操作中，arr1 中大于 2 的元素数量大于 arr2 中的数量（2 > 1），因此，将 nums[5] 追加到 arr1 。
在 5 次操作后，arr1 = [5,3,1,2] ，arr2 = [14] 。
因此，连接形成的数组 result 是 [5,3,1,2,14] 。
 

 示例 3： 

 
输入：nums = [3,3,3,3]
输出：[3,3,3,3]
解释：在 4 次操作后，arr1 = [3,3] ，arr2 = [3,3] 。
因此，连接形成的数组 result 是 [3,3,3,3] 。
 

 

 提示： 

 
 3 <= n <= 10⁵ 
 1 <= nums[i] <= 10⁹ 
 

 👍 37 👎 0

*/
package leetcode.editor.cn; //如果你的算法题是中文的，后缀就是cn，如果是英文的就是en

import java.util.*;

/**
 * @author  YourName
 * @date 2024-06-05 20:01:51
 */
public class DistributeElementsIntoTwoArraysIi{
    public static void main(String[] args) {
        Solution solution = new DistributeElementsIntoTwoArraysIi().new Solution();
        System.out.println(solution.resultArray(new int[]{2,38,2}));
   }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] resultArray(int[] nums) {
        int n = nums.length;
        int[] index = Arrays.copyOf(nums, n);
        Arrays.sort(index);
        int m = 0;
        Map<Integer, Integer> indexMap = new HashMap<>();
        indexMap.put(index[0], m + 1);
        for (int i = 1; i < n; i++) {
            if (index[m] != index[i]) {
                index[++m] = index[i];
                indexMap.put(index[i], m + 1);
            }
        }
        int[] arr1 = new int[m + 2];
        int[] arr2 = new int[m + 2];
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        list1.add(nums[0]);
        update(arr1, indexMap.get(nums[0]), 1);
        list2.add(nums[1]);
        update(arr2, indexMap.get(nums[1]), 1);
        for (int i = 2; i < n; i++) {
            int currentIndex = indexMap.get(nums[i]);
            int sum1 = list1.size() - sum(arr1, currentIndex);
            int sum2 = list2.size() - sum(arr2, currentIndex);
            if (sum1 > sum2) {
                list1.add(nums[i]);
                update(arr1, currentIndex,1);
            } else if (sum1 == sum2) {
                if (list1.size() <= list2.size()) {
                    list1.add(nums[i]);
                    update(arr1, currentIndex,1);
                } else {
                    list2.add(nums[i]);
                    update(arr2, currentIndex,1);
                }
            } else {
                list2.add(nums[i]);
                update(arr2, currentIndex,1);
            }
        }
        list1.addAll(list2);
        return list1.stream().mapToInt(Integer::valueOf).toArray();
    }
    public int sum(int[] arr, int index) {
        int result = 0;
        while (index > 0) {
            result += arr[index];
            index -= lowBit(index);
        }
        return result;
    }
    public int lowBit(int index) {
        return index & - index;
    }
    public void update(int[] arr, int index, int val) {
        while (index < arr.length) {
            arr[index] += val;
            index += lowBit(index);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}