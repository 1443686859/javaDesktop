//一个 2D 网格中的 峰值 是指那些 严格大于 其相邻格子(上、下、左、右)的元素。 
//
// 给你一个 从 0 开始编号 的 m x n 矩阵 mat ，其中任意两个相邻格子的值都 不相同 。找出 任意一个 峰值 mat[i][j] 并 返回其位置
// [i,j] 。 
//
// 你可以假设整个矩阵周边环绕着一圈值为 -1 的格子。 
//
// 要求必须写出时间复杂度为 O(m log(n)) 或 O(n log(m)) 的算法 
//
// 
//
// 
//
// 示例 1: 
//
// 
//
// 
//输入: mat = [[1,4],[3,2]]
//输出: [0,1]
//解释: 3 和 4 都是峰值，所以[1,0]和[0,1]都是可接受的答案。
// 
//
// 示例 2: 
//
// 
//
// 
//输入: mat = [[10,20,15],[21,30,14],[7,16,32]]
//输出: [1,1]
//解释: 30 和 32 都是峰值，所以[1,1]和[2,2]都是可接受的答案。
// 
//
// 
//
// 提示： 
//
// 
// m == mat.length 
// n == mat[i].length 
// 1 <= m, n <= 500 
// 1 <= mat[i][j] <= 10⁵ 
// 任意两个相邻元素均不相等. 
// 
//
// Related Topics 数组 二分查找 矩阵 👍 143 👎 0

package leetcode.editor.cn; //如果你的算法题是中文的，后缀就是cn，如果是英文的就是en
 /**
 * @author  YourName
 * @date 2023-12-19 20:42:21
 */
public class FindAPeakElementIi{
    public static void main(String[] args) {
        Solution solution = new FindAPeakElementIi().new Solution();
   }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] findPeakGrid(int[][] mat) {
        int left = 0;
        int right = mat.length - 2;
        while (left <= right) {
            int mid = (left + right) >>> 1;
            int target = getMaxIndex(mat[mid]);
            if (mat[mid][target] > mat[mid + 1][target]) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return  new int[]{left, getMaxIndex(mat[left])};
    }
    public int getMaxIndex(int[] current) {
        int index = 0;
        for (int i = 0; i < current.length; i++) {
            if (current[i] > current[index]) {
                index = i;
            }
        }
        return index;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}