/**
在两条独立的水平线上按给定的顺序写下 nums1 和 nums2 中的整数。 

 现在，可以绘制一些连接两个数字 nums1[i] 和 nums2[j] 的直线，这些直线需要同时满足： 

 
 nums1[i] == nums2[j] 
 且绘制的直线不与任何其他连线（非水平线）相交。 
 

 请注意，连线即使在端点也不能相交：每个数字只能属于一条连线。 

 以这种方法绘制线条，并返回可以绘制的最大连线数。 

 

 示例 1： 
 
 
输入：nums1 = [1,4,2], nums2 = [1,2,4]
输出：2
解释：可以画出两条不交叉的线，如上图所示。 
但无法画出第三条不相交的直线，因为从 nums1[1]=4 到 nums2[2]=4 的直线将与从 nums1[2]=2 到 nums2[1]=2 的直线相交。

 

 
 示例 2： 
 

 
输入：nums1 = [2,5,1,2,5], nums2 = [10,5,2,1,5,2]
输出：3
 

 
 示例 3： 
 

 
输入：nums1 = [1,3,7,1,7,5], nums2 = [1,9,2,5,1]
输出：2 

 

 提示： 

 
 1 <= nums1.length, nums2.length <= 500 
 1 <= nums1[i], nums2[j] <= 2000 
 

 

 👍 573 👎 0

*/
package leetcode.editor.cn; //如果你的算法题是中文的，后缀就是cn，如果是英文的就是en

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author  YourName
 * @date 2024-08-11 13:54:51
 */
public class UncrossedLines{
    public static void main(String[] args) {
        Solution solution = new UncrossedLines().new Solution();
        System.out.println(solution.maxUncrossedLines(new int[]{2}, new int[]{2,3,2,2}));
   }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maxUncrossedLines1(int[] nums1, int[] nums2) {
        int n = nums1.length;
        List<Integer>[] count = new List[n];
        Arrays.setAll(count, e-> new ArrayList<>());
        int max = 0;
        for (int i = 0; i < n; i++) {
            List<Integer> list = count[i];
            for (int j = 0; j < nums2.length; j++) {
                max = Math.max(max, nums2[j]);
                if (nums1[i] == nums2[j]) {
                    list.add(j);
                }
            }
        }
        int[] pre = new int[nums2.length + 1];
        int result = 0;
        for (int i = 0; i < n; i++) {
            for (int j = count[i].size() - 1; j >= 0; j--) {
                int temp = count[i].get(j);
                int preMax=  max(pre, temp)  + 1;
                update(pre, temp + 1, preMax);
                result = Math.max(preMax, result);
            }
        }
        return result;
    }
    public void update(int[] pre, int index, int value) {
        int max = pre.length;
        while (index < max) {
            pre[index] = Math.max(pre[index], value);
            index += lowbit(index);
        }
    }
    public int lowbit(int x) {
        return x & - x;
    }
    public int max(int[] pre, int index) {
        int max = 0;
        while (index > 0) {
            max = Math.max(pre[index], max);
            index -= lowbit(index);
        }
        return max;
    }
    public int maxUncrossedLines2(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;
        int[][] result = new int[n + 1][m + 1];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                result[i + 1][j + 1] = nums1[i] == nums2[j] ? (result[i][j] + 1) : Math.max(result[i + 1][j], result[i][j + 1]);
            }
        }
        return result[n][m];
    }
    public int maxUncrossedLines(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;
        int[] result = new int[m + 1];
        for (int i = 0; i < n; i++) {
            int pre = 0;
            for (int j = 0; j < m;j ++) {
                int temp = result[j + 1];
                result[j + 1] = nums1[i] == nums2[j] ? (pre + 1) : Math.max(result[j], result[j + 1]);
                pre = temp;
            }
        }
        return result[m];
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}