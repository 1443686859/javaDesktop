/**
给你两个下标从 0 开始的整数数组 nums 和 divisors 。 

 divisors[i] 的 可整除性得分 等于满足 nums[j] 能被 divisors[i] 整除的下标 j 的数量。 

 返回 可整除性得分 最大的整数 divisors[i] 。如果有多个整数具有最大得分，则返回数值最小的一个。 

 

 示例 1： 

 
输入：nums = [4,7,9,3,9], divisors = [5,2,3]
输出：3
解释：divisors 中每个元素的可整除性得分为：
divisors[0] 的可整除性得分为 0 ，因为 nums 中没有任何数字能被 5 整除。
divisors[1] 的可整除性得分为 1 ，因为 nums[0] 能被 2 整除。 
divisors[2] 的可整除性得分为 3 ，因为 nums[2]、nums[3] 和 nums[4] 都能被 3 整除。 
因此，返回 divisors[2] ，它的可整除性得分最大。
 

 示例 2： 

 
输入：nums = [20,14,21,10], divisors = [5,7,5]
输出：5
解释：divisors 中每个元素的可整除性得分为：
divisors[0] 的可整除性得分为 2 ，因为 nums[0] 和 nums[3] 都能被 5 整除。
divisors[1] 的可整除性得分为 2 ，因为 nums[1] 和 nums[2] 都能被 7 整除。
divisors[2] 的可整除性得分为 2 ，因为 nums[0] 和 nums[3] 都能被5整除。 
由于 divisors[0]、divisors[1] 和 divisors[2] 的可整除性得分都是最大的，因此，我们返回数值最小的一个，即 divisors[
2] 。
 

 示例 3： 

 
输入：nums = [12], divisors = [10,16]
输出：10
解释：divisors 中每个元素的可整除性得分为：
divisors[0] 的可整除性得分为 0 ，因为 nums 中没有任何数字能被 10 整除。
divisors[1] 的可整除性得分为 0 ，因为 nums 中没有任何数字能被 16 整除。 
由于 divisors[0] 和 divisors[1] 的可整除性得分都是最大的，因此，我们返回数值最小的一个，即 divisors[0] 。
 

 

 提示： 

 
 1 <= nums.length, divisors.length <= 1000 
 1 <= nums[i], divisors[i] <= 10⁹ 
 

 👍 18 👎 0

*/
package leetcode.editor.cn; //如果你的算法题是中文的，后缀就是cn，如果是英文的就是en

import java.util.ArrayList;
import java.util.List;

/**
 * @author  YourName
 * @date 2024-05-18 14:43:44
 */
public class FindTheMaximumDivisibilityScore{
    public static void main(String[] args) {
        Solution solution = new FindTheMaximumDivisibilityScore().new Solution();
//        System.out.println(solution.isArraySpecial(new int[]{3,6,2,1}, new int[][]{{0,1}}));
        System.out.println(solution.sumDigitDifferences(new int[]{
                609641,283095,218250,183890,971938,641685,571957,662580,106414,703951,392155,950965,222318,922556,366286,643770,640646,967586,126846,757183,702010,742007,169674,942499,534413,303046,324267,797902,800053,974994,803378,725812,656336,617623,149468,543376,200046,938118,154359,965627,442074,328978,520777,250355,142633,133916,474606,808340,502083,370561,590640,955425,690111,900772,363538,115664,174895,787294,345097,959634,381094,422401,591450,935006,419476,135613,476324,782958,635696,286706,270645,611199
        }));
   }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maxDivScore(int[] nums, int[] divisors) {
        int result = 0;
        int ans = Integer.MAX_VALUE;
        for (int j : divisors) {
            int count = 0;
            for (int i : nums) {
                if (i % j == 0) {
                    count++;
                }
            }
            if (count > result) {
                result = count;
                ans = j;
            } else if (count == result) {
                ans = Math.min(ans, j);
            }
        }

        return ans;
    }
    public boolean isArraySpecial(int[] nums) {
        int n = nums.length;
        for (int i = 1; i < n; i++) {
            if (((nums[i] & 1) == (nums[i - 1]& 1))) {
                return false;
            }
        }
        return true;
    }
    public boolean[] isArraySpecial(int[] nums, int[][] queries) {
        int n = queries.length;
        boolean[] ans = new boolean[n];
        List<int[]> list = new ArrayList<>();
        for (int i = 1; i < nums.length; i++) {
            if (((nums[i] & 1) == (nums[i - 1]& 1))) {
               list.add(new int[]{i - 1, i});
            }
        }
        for (int i = 0; i < n; i++) {
            int[] query = queries[i];
            int left = 0;
            int right = list.size() - 1;
            if (query[0] == query[1]) {
                ans[i] = true;
                continue;
            } else if (list.size() == nums.length - 1){
                ans[i] = false;
                continue;
            }
            while (left <= right) {
                int mid = (left + right) / 2;
                if ((list.get(mid)[1]<= query[1] && list.get(mid)[0] >= query[0]) || (query[1] <= list.get(mid)[0])) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
            int index = right + 1;
            ans[i] = index >= 0 && index < list.size() && ((list.get(index)[1]<= query[1] && list.get(index)[0] >= query[0])) ? false : true;
        }
        return ans;

    }
    public long sumDigitDifferences(int[] nums) {
        int base = 1;
        long result = 0;
        long[][] count = new long[10][10];
        for (int i = 0; i < 10; i++) {
            for (int j : nums) {
                count[i][j / base % 10]++;
            }
            base *= 10;
        }
        for (int i = 0; i < 10; i++) {
            long c = 0;
            long start = nums.length;
            long sum = 0;
            for (int j = 0; j < 10; j++) {
                c += count[i][j] * (start - count[i][j]);
                start -= count[i][j];
                sum += count[i][j];
            }
            result += c;

        }
        return result;
    }

}
//leetcode submit region end(Prohibit modification and deletion)

}