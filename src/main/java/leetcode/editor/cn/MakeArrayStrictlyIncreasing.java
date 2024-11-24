//给你两个整数数组 arr1 和 arr2，返回使 arr1 严格递增所需要的最小「操作」数（可能为 0）。 
//
// 每一步「操作」中，你可以分别从 arr1 和 arr2 中各选出一个索引，分别为 i 和 j，0 <= i < arr1.length 和 0 <= j 
//< arr2.length，然后进行赋值运算 arr1[i] = arr2[j]。 
//
// 如果无法让 arr1 严格递增，请返回 -1。 
//
// 
//
// 示例 1： 
//
// 输入：arr1 = [1,5,3,6,7], arr2 = [1,3,2,4]
//输出：1
//解释：用 2 来替换 5，之后 arr1 = [1, 2, 3, 6, 7]。
// 
//
// 示例 2： 
//
// 输入：arr1 = [1,5,3,6,7], arr2 = [4,3,1]
//输出：2
//解释：用 3 来替换 5，然后用 4 来替换 3，得到 arr1 = [1, 3, 4, 6, 7]。
// 
//
// 示例 3： 
//
// 输入：arr1 = [1,5,3,6,7], arr2 = [1,6,3,3]
//输出：-1
//解释：无法使 arr1 严格递增。 
//
// 
//
// 提示： 
//
// 
// 1 <= arr1.length, arr2.length <= 2000 
// 0 <= arr1[i], arr2[i] <= 10^9 
// 
//
// 
//
// Related Topics 数组 二分查找 动态规划 排序 👍 167 👎 0

package leetcode.editor.cn; //如果你的算法题是中文的，后缀就是cn，如果是英文的就是en

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author  YourName
 * @date 2023-04-20 21:56:00
 */
public class MakeArrayStrictlyIncreasing{
    public static void main(String[] args) {
        Solution solution = new MakeArrayStrictlyIncreasing().new Solution();
        System.out.println(solution.makeArrayIncreasing(new int[]{1,5,3,6,7}, new int[]{1,3,2,4}));
   }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
        int[] a, b;
        Map<Integer, Integer>[] memo;
    public int makeArrayIncreasing(int[] a, int[] b) {
        this.a = a;
        this.b = b;
        Arrays.sort(b); // 为能二分查找，对 b 排序
        int n = a.length;
        memo = new HashMap[n];
        Arrays.setAll(memo, e -> new HashMap<>());
        int ans = dfs(n - 1, Integer.MAX_VALUE); // 假设 a[n-1] 右侧有个无穷大的数
        return ans < Integer.MAX_VALUE / 2 ? ans : -1;
    }
    public int dfs(int i, int pre) {
        if (i < 0) {
            return 0;
        }
        if (memo[i].containsKey(pre)) {
            return memo[i].get(pre);
        }
        int res = a[i] < pre ? dfs(i - 1, a[i]) : Integer.MAX_VALUE/ 2;
        int k = lowerBound(b, pre);
        if (k >= 0) {
            res = Math.min(res, dfs(i - 1, b[k]) + 1);
        }
        memo[i].put(pre, res);
        return res;

    }
    public int lowerBound(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) >>> 1;
            if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left - 1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}