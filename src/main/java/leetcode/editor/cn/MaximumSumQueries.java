//给你两个长度为 n 、下标从 0 开始的整数数组 nums1 和 nums2 ，另给你一个下标从 1 开始的二维数组 queries ，其中 
//queries[i] = [xi, yi] 。 
//
// 对于第 i 个查询，在所有满足 nums1[j] >= xi 且 nums2[j] >= yi 的下标 j (0 <= j < n) 中，找出 nums1
//[j] + nums2[j] 的 最大值 ，如果不存在满足条件的 j 则返回 -1 。 
//
// 返回数组 answer ，其中 answer[i] 是第 i 个查询的答案。 
//
// 
//
// 示例 1： 
//
// 输入：nums1 = [4,3,1,2], nums2 = [2,4,9,5], queries = [[4,1],[1,3],[2,5]]
//输出：[6,10,7]
//解释：
//对于第 1 个查询：xi = 4 且 yi = 1 ，可以选择下标 j = 0 ，此时 nums1[j] >= 4 且 nums2[j] >= 1 。
//nums1[j] + nums2[j] 等于 6 ，可以证明 6 是可以获得的最大值。
//对于第 2 个查询：xi = 1 且 yi = 3 ，可以选择下标 j = 2 ，此时 nums1[j] >= 1 且 nums2[j] >= 3 。
//nums1[j] + nums2[j] 等于 10 ，可以证明 10 是可以获得的最大值。
//对于第 3 个查询：xi = 2 且 yi = 5 ，可以选择下标 j = 3 ，此时 nums1[j] >= 2 且 nums2[j] >= 5 。
//nums1[j] + nums2[j] 等于 7 ，可以证明 7 是可以获得的最大值。
//因此，我们返回 [6,10,7] 。
// 
//
// 示例 2： 
//
// 输入：nums1 = [3,2,5], nums2 = [2,3,4], queries = [[4,4],[3,2],[1,1]]
//输出：[9,9,9]
//解释：对于这个示例，我们可以选择下标 j = 2 ，该下标可以满足每个查询的限制。
// 
//
// 示例 3： 
//
// 输入：nums1 = [2,1], nums2 = [2,3], queries = [[3,3]]
//输出：[-1]
//解释：示例中的查询 xi = 3 且 yi = 3 。对于每个下标 j ，都只满足 nums1[j] < xi 或者 nums2[j] < yi 。因此，不
//存在答案。 
// 
//
// 
//
// 提示： 
//
// 
// nums1.length == nums2.length 
// n == nums1.length 
// 1 <= n <= 10⁵ 
// 1 <= nums1[i], nums2[i] <= 10⁹ 
// 1 <= queries.length <= 10⁵ 
// queries[i].length == 2 
// xi == queries[i][1] 
// yi == queries[i][2] 
// 1 <= xi, yi <= 10⁹ 
// 
//
// 👍 13 👎 0

package leetcode.editor.cn; //如果你的算法题是中文的，后缀就是cn，如果是英文的就是en



import java.util.Arrays;

/**
 * @author  YourName
 * @date 2023-06-15 23:51:53
 */
public class MaximumSumQueries{
    public static void main(String[] args) {
        Solution solution = new MaximumSumQueries().new Solution();
   }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] maximumSumQueries(int[] nums1, int[] nums2, int[][] queries) {
        int n = nums1.length;
        int[] count = new int[n];
        int[][] query = new int[queries.length][3];
        int[][] numsO = new int[n][2];
        int[][] numsT = new int[n][2];
        for (int i = 0; i < n; i++) {
            numsO[i][0] = nums1[i];
            numsT[i][0] = nums2[i];
            numsO[i][1] = i;
            numsT[i][1] = i;
        }
        for (int i = 0; i < queries.length; i++) {
            query[i][0] = queries[i][0];
            query[i][1] = queries[i][1];
            query[i][2] = i;
        }
        Arrays.sort(numsO, (pre, after) -> {
            return pre[0] - after[0];
        });
        Arrays.sort(numsT, (pre, after) ->{
            return pre[0] - after[0];
        });
        int maxRight = n - 1;
        Arrays.sort(query, (pre, after) -> {
            if (pre[0] != after[0]) {
                return pre[0] - after[0];
            } else {
                return pre[1] - after[1];
            }
        });
        int[] result = new int[queries.length];
//        for (int i = result.length - 1; i >= 0; i++) {
//            int
//        }
        return new int[0];
    }
    public int getIndex(int[][] current, int target) {
        int left = 0;
        int right = current.length;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (current[mid][0] >= target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return right + 1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}