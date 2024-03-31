//给你一个整数数组 citations ，其中 citations[i] 表示研究者的第 i 篇论文被引用的次数。计算并返回该研究者的 h 指数。 
//
// 根据维基百科上 h 指数的定义：h 代表“高引用次数” ，一名科研人员的 h 指数 是指他（她）至少发表了 h 篇论文，并且每篇论文 至少 被引用 h 次
//。如果 h 有多种可能的值，h 指数 是其中最大的那个。 
//
// 
//
// 示例 1： 
//
// 
//输入：citations = [3,0,6,1,5]
//输出：3 
//解释：给定数组表示研究者总共有 5 篇论文，每篇论文相应的被引用了 3, 0, 6, 1, 5 次。
//     由于研究者有 3 篇论文每篇 至少 被引用了 3 次，其余两篇论文每篇被引用 不多于 3 次，所以她的 h 指数是 3。 
//
// 示例 2： 
//
// 
//输入：citations = [1,3,1]
//输出：1
// 
//
// 
//
// 提示： 
//
// 
// n == citations.length 
// 1 <= n <= 5000 
// 0 <= citations[i] <= 1000 
// 
//
// Related Topics 数组 计数排序 排序 👍 380 👎 0

package leetcode.editor.cn; //如果你的算法题是中文的，后缀就是cn，如果是英文的就是en

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * @author  YourName
 * @date 2023-10-29 09:44:16
 */
public class HIndex{
    public static void main(String[] args) {
        Solution solution = new HIndex().new Solution();
//        System.out.println(solution.minSum(new int[]{0,16,28,12,10,15,25,24,6,0,0}, new int[]{20,15,19,5,6,29,25,8,12}));
//        System.out.println(solution.minIncrementOperations(new int[]{7,7,2,7}, 9));
    }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int hIndex(int[] citations) {
        Arrays.sort(citations);
        int result = 0;
        int index = citations.length - 1;
        while (index >= 0 && citations[index] >= (result + 1)) {
            index--;
            result++;
        }
        return result;
    }
    public int findKOr(int[] nums, int k) {
        int[] count = new int[32];
        for (int i : nums) {
            for (int j = 0; j < 32; j++) {
                if ((i & (1<<j)) != 0) {
                    count[j]++;
                }
            }
        }
        int result = 0;
        for (int i = 0;i < 32; i++) {
            if (count[i] >= k) {
                result += (1 << i);
            }
        }
        return result;
    }
    public long minSum(int[] nums1, int[] nums2) {
        int zeroCount1 = 0;
        long sum1 = 0;
        for (int i : nums1) {
            sum1 += i;
            if (i == 0) {
                zeroCount1++;
            }
        }
        int zeroCount2 = 0;
        long sum2 = 0;
        for (int i : nums2) {
            sum2 += i;
            if (i == 0) {
                zeroCount2++;
            }
        }
        if (zeroCount2 == 0 && zeroCount1 == 0) {
            return sum2 == sum1 ? sum2 : -1;
        } else if (zeroCount2 == 0 && sum2 < (sum1 + zeroCount1) || zeroCount1 == 0 && sum1 < (sum2 + zeroCount2)) {
            return - 1;
        }
        return Math.max(sum1 + zeroCount1, sum2 + zeroCount2);

    }
}
//leetcode submit region end(Prohibit modification and deletion)

}