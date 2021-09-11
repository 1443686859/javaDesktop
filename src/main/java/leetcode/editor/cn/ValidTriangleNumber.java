package leetcode.editor.cn;

//给定一个包含非负整数的数组，你的任务是统计其中可以组成三角形三条边的三元组个数。 
//
// 示例 1: 
//
// 
//输入: [2,2,3,4]
//输出: 3
//解释:
//有效的组合是: 
//2,3,4 (使用第一个 2)
//2,3,4 (使用第二个 2)
//2,2,3
// 
//
// 注意: 
//
// 
// 数组长度不超过1000。 
// 数组里整数的范围为 [0, 1000]。 
// 
// Related Topics 贪心 数组 双指针 二分查找 排序 
// 👍 267 👎 0

import java.util.Arrays;

public class ValidTriangleNumber{
    public static void main(String[] args) {
        Solution solution = new ValidTriangleNumber().new Solution();
        solution.triangleNumber(new int[]{2,2,3,4,7});
    }

//leetcode submit region begin(Prohibit modification and deletion)
/*class Solution {
    public int triangleNumber(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        int ans = 0;
        for (int i = 0; i < n; i++) {
            int k = i;
            for (int j = i + 1; j < n; j++) {
                while(k + 1 < n && nums[k + 1] < nums[i] + nums[j]) {
                    k++;
                }
                ans += Math.max(k - j, 0);
            }
        }
        return ans;
    }
}*/
class Solution {
    public int triangleNumber(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int right = n -1;
                int left = j + 1;
                int maxJ = j;
                while (left <= right) {
                    // 循环结束条件 left = right + 1
                    int mid = left + (right - left) / 2;
                    if (nums[mid] < nums[i] + nums[j]) {
                        // 还未到达最大k
                        maxJ = mid;
                        left = mid + 1;
                        // 若在此后结束循环则有 mid = left -1; mid = right;
                    } else {
                        // 若在此后结束循环则有 mid = right + 1; mid = left;
                        right = mid -1;
                    }
                }
                ans += maxJ - j;
            }
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}