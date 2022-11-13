//给定一个数组，包含从 1 到 N 所有的整数，但其中缺了两个数字。你能在 O(N) 时间内只用 O(1) 的空间找到它们吗？ 
//
// 以任意顺序返回这两个数字均可。 
//
// 示例 1: 
//
// 输入: [1]
//输出: [2,3] 
//
// 示例 2: 
//
// 输入: [2,3]
//输出: [1,4] 
//
// 提示： 
//
// 
// nums.length <= 30000 
// 
//
// Related Topics 位运算 数组 哈希表 👍 187 👎 0

package leetcode.editor.cn; //如果你的算法题是中文的，后缀就是cn，如果是英文的就是en

import java.util.ArrayList;
import java.util.List;

/**
 * @author  YourName
 * @date 2022-09-26 21:10:56
 */
public class MissingTwoLcci{
    public static void main(String[] args) {
        Solution solution = new MissingTwoLcci().new Solution();
   }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] missingTwo(int[] nums) {
        int n = nums.length;
        int[] current =new int[n + 2];
        for (int i = 0; i < nums.length; i++) {
            current[i] = nums[i];
        }
        current[n] = -1;
        current[n + 1] = -1;
        for (int i = 0; i < current.length; i++) {
            int j = i;
            while (current[j] != -1 && current[j] != j + 1) {
                int temp = current[current[j] - 1];
                current[current[j] - 1] = current[j];
                current[j] = temp;
                j = current[j] -1;
            }
        }
        int[] result = new int[2];
        for (int i = 0; i < current.length; i++) {
           if (current[i] == -1) {
               if (result[0] == -1) {
                   result[0] = i;
               } else {
                   result[1] = i;
               }
           }
        }
        return result;
    }
    public int[] missingTwo2(int[] nums) {
        int n = nums.length;
        n += 2;
        int sum = (n + 1) * n /2;
        for (int i : nums) {
            sum -= i;
        }
        int twoSum = sum;
        int t = sum /2;
        sum = t * (t + 1) / 2;
        for (int i : nums) {
            if (i <= t) {
                sum -= i;
            }
        }
        return new int[]{sum, twoSum - sum};
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}