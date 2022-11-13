//给定一个 排序好 的数组 arr ，两个整数 k 和 x ，从数组中找到最靠近 x（两数之差最小）的 k 个数。返回的结果必须要是按升序排好的。 
//
// 整数 a 比整数 b 更接近 x 需要满足： 
//
// 
// |a - x| < |b - x| 或者 
// |a - x| == |b - x| 且 a < b 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：arr = [1,2,3,4,5], k = 4, x = 3
//输出：[1,2,3,4]
// 
//
// 示例 2： 
//
// 
//输入：arr = [1,2,3,4,5], k = 4, x = -1
//输出：[1,2,3,4]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= k <= arr.length 
// 1 <= arr.length <= 10⁴
// 
// arr 按 升序 排列 
// -10⁴ <= arr[i], x <= 10⁴ 
// 
//
// Related Topics 数组 双指针 二分查找 排序 堆（优先队列） 👍 419 👎 0

package leetcode.editor.cn; //如果你的算法题是中文的，后缀就是cn，如果是英文的就是en

import java.util.ArrayList;
import java.util.List;

/**
 * @author  YourName
 * @date 2022-08-25 20:55:58
 */
public class FindKClosestElements{
    public static void main(String[] args) {
        Solution solution = new FindKClosestElements().new Solution();
        System.out.println(solution.findClosestElements(new int[]{1,1,1,10,10,10}, 1, 9));
   }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int index = binarySearch(arr, x);
        int left = index - 1;
        List<Integer> result = new ArrayList<>();
        while (k > 0) {
            if (left < 0) {
                index++;
            } else if (index > arr.length) {
                left--;
            } else if (Math.abs(arr[index] - x) < Math.abs(arr[left] - x)) {
                index++;
            } else {
                left--;
            }
            k--;
        }
        left = Math.max(left + 1, 0);
        index = Math.min(index - 1, arr.length - 1);
        for (int i = left; i <= index; i++) {
            result.add(arr[i]);
        }
        return result;
    }
    public int binarySearch(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;
        while (left <= right) {
            int mid = (left + right) >> 1;
            if (arr[mid] < target) {
                left = mid + 1;
            } else {
               right = mid - 1;
            }
        }
        return right + 1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}