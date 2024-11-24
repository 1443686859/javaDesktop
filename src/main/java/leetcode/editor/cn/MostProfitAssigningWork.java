/**
你有 n 个工作和 m 个工人。给定三个数组： difficulty, profit 和 worker ，其中: 

 
 difficulty[i] 表示第 i 个工作的难度，profit[i] 表示第 i 个工作的收益。 
 worker[i] 是第 i 个工人的能力，即该工人只能完成难度小于等于 worker[i] 的工作。 
 

 每个工人 最多 只能安排 一个 工作，但是一个工作可以 完成多次 。 

 
 举个例子，如果 3 个工人都尝试完成一份报酬为 $1 的同样工作，那么总收益为 $3 。如果一个工人不能完成任何工作，他的收益为 $0 。 
 

 返回 在把工人分配到工作岗位后，我们所能获得的最大利润 。 

 

 示例 1： 

 
输入: difficulty = [2,4,6,8,10], profit = [10,20,30,40,50], worker = [4,5,6,7]
输出: 100 
解释: 工人被分配的工作难度是 [4,4,6,6] ，分别获得 [20,20,30,30] 的收益。 

 示例 2: 

 
输入: difficulty = [85,47,57], profit = [24,66,99], worker = [40,25,25]
输出: 0 

 

 提示: 

 
 n == difficulty.length 
 n == profit.length 
 m == worker.length 
 1 <= n, m <= 10⁴ 
 1 <= difficulty[i], profit[i], worker[i] <= 10⁵ 
 

 👍 150 👎 0

*/
package leetcode.editor.cn; //如果你的算法题是中文的，后缀就是cn，如果是英文的就是en

import java.util.Arrays;

/**
 * @author  YourName
 * @date 2024-05-17 21:01:26
 */
public class MostProfitAssigningWork{
    public static void main(String[] args) {
        Solution solution = new MostProfitAssigningWork().new Solution();
        System.out.println(solution.maxProfitAssignment(new int[]{85,47,57}, new int[]{24,66,99}, new int[]{40,25,25}));
   }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        int n = difficulty.length;
        int[][] base = new int[n][3];
        for (int i = 0; i < n; i++) {
            base[i][0] = difficulty[i];
            base[i][1] = profit[i];
        }
        Arrays.sort(base, (a,b) -> {
            if (a[0] != b[0]) {
                return a[0] - b[0];
            } else {
                return a[1] - b[1];
            }
        });
        int result = 0;
        base[0][2] = base[0][1];
        for (int i = 1; i < n; i++) {
            base[i][2] = Math.max(base[i - 1][2], base[i][1]);
        }
        for (int i : worker) {
            int left = 0;
            int right = n - 1;
            while (left <= right) {
                int mid = (left + right) / 2;
                if (base[mid][0] <= i) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
            result += right >= 0 ? base[right][2] : 0;
        }
        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}