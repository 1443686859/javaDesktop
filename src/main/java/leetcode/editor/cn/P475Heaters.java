package leetcode.editor.cn;
//冬季已经来临。 你的任务是设计一个有固定加热半径的供暖器向所有房屋供暖。 
//
// 在加热器的加热半径范围内的每个房屋都可以获得供暖。 
//
// 现在，给出位于一条水平线上的房屋 houses 和供暖器 heaters 的位置，请你找出并返回可以覆盖所有房屋的最小加热半径。 
//
// 说明：所有供暖器都遵循你的半径标准，加热的半径也一样。 
//
// 
//
// 示例 1: 
//
// 
//输入: houses = [1,2,3], heaters = [2]
//输出: 1
//解释: 仅在位置2上有一个供暖器。如果我们将加热半径设为1，那么所有房屋就都能得到供暖。
// 
//
// 示例 2: 
//
// 
//输入: houses = [1,2,3,4], heaters = [1,4]
//输出: 1
//解释: 在位置1, 4上有两个供暖器。我们需要将加热半径设为1，这样所有房屋就都能得到供暖。
// 
//
// 示例 3： 
//
// 
//输入：houses = [1,5], heaters = [2]
//输出：3
// 
//
// 
//
// 提示： 
//
// 
// 1 <= houses.length, heaters.length <= 3 * 10⁴ 
// 1 <= houses[i], heaters[i] <= 10⁹ 
// 
// Related Topics 数组 双指针 二分查找 排序 👍 334 👎 0



import java.util.Arrays;

public class P475Heaters{
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.findRadius(new int[]{1,2,3,4}, new int[]{1,4}));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    static class Solution {
    public int findRadius(int[] houses, int[] heaters) {
        int ans = 0;
        Arrays.sort(heaters);
        for (int house : houses) {
            int i = leftSearch(heaters, house);
            int j = i + 1;
            int leftDistance = i < 0 ? Integer.MAX_VALUE : house - heaters[i];
            int rightDistance = j >= heaters.length ? Integer.MAX_VALUE : heaters[j] - house;
            int curDistance = Math.min(leftDistance, rightDistance);
            ans = Math.max(ans, curDistance);
        }
        return ans;
    }
    public int leftSearch(int[] nums, int target) {
        int left =0;
        int right = nums.length - 1;
        if (nums[left] > target) {
            return -1;
        }
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] > target) {
                right = mid - 1;
            } else if (nums[mid] < target){
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }

}
//leetcode submit region end(Prohibit modification and deletion)

}