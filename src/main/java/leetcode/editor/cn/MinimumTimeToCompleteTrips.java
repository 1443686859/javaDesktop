/**
给你一个数组 time ，其中 time[i] 表示第 i 辆公交车完成 一趟旅途 所需要花费的时间。 

 每辆公交车可以 连续 完成多趟旅途，也就是说，一辆公交车当前旅途完成后，可以 立马开始 下一趟旅途。每辆公交车 独立 运行，也就是说可以同时有多辆公交车在运行
且互不影响。 

 给你一个整数 totalTrips ，表示所有公交车 总共 需要完成的旅途数目。请你返回完成 至少 totalTrips 趟旅途需要花费的 最少 时间。 

 

 示例 1： 

 输入：time = [1,2,3], totalTrips = 5
输出：3
解释：
- 时刻 t = 1 ，每辆公交车完成的旅途数分别为 [1,0,0] 。
  已完成的总旅途数为 1 + 0 + 0 = 1 。
- 时刻 t = 2 ，每辆公交车完成的旅途数分别为 [2,1,0] 。
  已完成的总旅途数为 2 + 1 + 0 = 3 。
- 时刻 t = 3 ，每辆公交车完成的旅途数分别为 [3,1,1] 。
  已完成的总旅途数为 3 + 1 + 1 = 5 。
所以总共完成至少 5 趟旅途的最少时间为 3 。
 

 示例 2： 

 输入：time = [2], totalTrips = 1
输出：2
解释：
只有一辆公交车，它将在时刻 t = 2 完成第一趟旅途。
所以完成 1 趟旅途的最少时间为 2 。
 

 

 提示： 

 
 1 <= time.length <= 10⁵ 
 1 <= time[i], totalTrips <= 10⁷ 
 

 👍 102 👎 0

*/
package leetcode.editor.cn; //如果你的算法题是中文的，后缀就是cn，如果是英文的就是en
 /**
 * @author  YourName
 * @date 2024-10-05 11:06:28
 */
public class MinimumTimeToCompleteTrips{
    public static void main(String[] args) {
        Solution solution = new MinimumTimeToCompleteTrips().new Solution();
   }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public long minimumTime(int[] time, int totalTrips) {
        long right = Long.MAX_VALUE;
        int min = Integer.MAX_VALUE;
        long sum = 0;
        for (int i : time) {
            right = Math.min(right, (long) i * totalTrips);
            min = Math.min(min, i);
            sum += i;
        }
        long left = Math.max(min, totalTrips / sum);
        while (left <= right)  {
            long mid = left + (right - left) / 2;
            if (check(mid, time, totalTrips)) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return right + 1;
    }
    public boolean check(long target, int[] time, int totalTrips) {
        long count = 0;
        for (int i : time) {
            count += target / i;
            if (count >= totalTrips) {
                return true;
            }
        }
       return false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}