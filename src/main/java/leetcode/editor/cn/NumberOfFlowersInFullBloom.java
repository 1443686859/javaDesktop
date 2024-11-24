//给你一个下标从 0 开始的二维整数数组 flowers ，其中 flowers[i] = [starti, endi] 表示第 i 朵花的 花期 从 
//starti 到 endi （都 包含）。同时给你一个下标从 0 开始大小为 n 的整数数组 people ，people[i] 是第 i 个人来看花的时间。 
//
// 请你返回一个大小为 n 的整数数组 answer ，其中 answer[i]是第 i 个人到达时在花期内花的 数目 。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：flowers = [[1,6],[3,7],[9,12],[4,13]], people = [2,3,7,11]
//输出：[1,2,2,2]
//解释：上图展示了每朵花的花期时间，和每个人的到达时间。
//对每个人，我们返回他们到达时在花期内花的数目。
// 
//
// 示例 2： 
//
// 
//
// 
//输入：flowers = [[1,10],[3,3]], people = [3,3,2]
//输出：[2,2,1]
//解释：上图展示了每朵花的花期时间，和每个人的到达时间。
//对每个人，我们返回他们到达时在花期内花的数目。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= flowers.length <= 5 * 10⁴ 
// flowers[i].length == 2 
// 1 <= starti <= endi <= 10⁹ 
// 1 <= people.length <= 5 * 10⁴ 
// 1 <= people[i] <= 10⁹ 
// 
//
// Related Topics 数组 哈希表 二分查找 有序集合 前缀和 排序 👍 52 👎 0

package leetcode.editor.cn; //如果你的算法题是中文的，后缀就是cn，如果是英文的就是en

import java.util.Arrays;

/**
 * @author  YourName
 * @date 2023-09-28 00:01:04
 */
public class NumberOfFlowersInFullBloom{
    public static void main(String[] args) {
        Solution solution = new NumberOfFlowersInFullBloom().new Solution();
        System.out.println(solution.fullBloomFlowers(new int[][]{
                {21,34},{17,37},{23,43},{17,46},{37,41},{44,45},{32,45}
        }, new int[]{31,41,10,12}));
   }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] fullBloomFlowers(int[][] flowers, int[] people) {
        return new int[0];
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}