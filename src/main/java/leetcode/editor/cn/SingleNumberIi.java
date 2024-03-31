//给你一个整数数组 nums ，除某个元素仅出现 一次 外，其余每个元素都恰出现 三次 。请你找出并返回那个只出现了一次的元素。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [2,2,3,2]
//输出：3
// 
//
// 示例 2： 
//
// 
//输入：nums = [0,1,0,1,0,1,99]
//输出：99
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 3 * 10⁴ 
// -2³¹ <= nums[i] <= 2³¹ - 1 
// nums 中，除某个元素仅出现 一次 外，其余每个元素都恰出现 三次 
// 
//
// 
//
// 进阶：你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？ 
// Related Topics 位运算 数组 👍 859 👎 0

package leetcode.editor.cn; //如果你的算法题是中文的，后缀就是cn，如果是英文的就是en
 /**
 * @author  YourName
 * @date 2022-05-03 13:47:28
 */
public class SingleNumberIi{
    public static void main(String[] args) {
        Solution solution = new SingleNumberIi().new Solution();
        System.out.println(solution.constructProductMatrix(new int[][]{
                {1,2},{3,4}
        }));
   }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int singleNumber(int[] nums) {
        int[] count = new int[32];
        for (int i : nums) {
            add(count, i);
        }
        int result = 0;
        for (int i = 0; i < 32; i++) {
            if (count[i] % 3 == 1) {
                result += 1 << i;
            }
        }
        return result;
    }
    public void add(int[] count, int current) {
        int index = 0;
        while (current != 0) {
            count[index] += current & 1;
            index++;
            current /= 2;
        }
    }
    public int[][] constructProductMatrix(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        long[] pre = new long[grid.length * grid[0].length];
        long[] after = new long[grid.length * grid[0].length];
        long temp = 1l;
        int mod = 12345;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                temp = (temp * grid[i][j]) % mod;
                pre[i* m + j] = temp;
            }
        }
        temp = 1l;
        for (int i = n - 1; i >=0; i--) {
            for (int j = m - 1; j >= 0; j--) {
                temp = (temp * grid[i][j]) % mod;
                after[i * m + j] = temp;
            }
        }

        int[][] result = new int[grid.length][grid[0].length];
        for (int i = 0; i < n * m; i++) {
            if (i == 0) {
                result[0][0] = (int)after[i + 1];
            } else if (i == n  * m - 1) {
                result[n - 1][m - 1] = (int)pre[i - 1];
            } else {
                result[i / m][i % m] = (int)((pre[i - 1] * after[i + 1]) % mod);
            }
        }
        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}