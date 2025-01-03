//有 n 个盒子。给你一个长度为 n 的二进制字符串 boxes ，其中 boxes[i] 的值为 '0' 表示第 i 个盒子是 空 的，而 boxes[i]
// 的值为 '1' 表示盒子里有 一个 小球。 
//
// 在一步操作中，你可以将 一个 小球从某个盒子移动到一个与之相邻的盒子中。第 i 个盒子和第 j 个盒子相邻需满足 abs(i - j) == 1 。注意，
//操作执行后，某些盒子中可能会存在不止一个小球。 
//
// 返回一个长度为 n 的数组 answer ，其中 answer[i] 是将所有小球移动到第 i 个盒子所需的 最小 操作数。 
//
// 每个 answer[i] 都需要根据盒子的 初始状态 进行计算。 
//
// 
//
// 示例 1： 
//
// 输入：boxes = "110"
//输出：[1,1,3]
//解释：每个盒子对应的最小操作数如下：
//1) 第 1 个盒子：将一个小球从第 2 个盒子移动到第 1 个盒子，需要 1 步操作。
//2) 第 2 个盒子：将一个小球从第 1 个盒子移动到第 2 个盒子，需要 1 步操作。
//3) 第 3 个盒子：将一个小球从第 1 个盒子移动到第 3 个盒子，需要 2 步操作。将一个小球从第 2 个盒子移动到第 3 个盒子，需要 1 步操作。共
//计 3 步操作。
// 
//
// 示例 2： 
//
// 输入：boxes = "001011"
//输出：[11,8,5,4,3,4] 
//
// 
//
// 提示： 
//
// 
// n == boxes.length 
// 1 <= n <= 2000 
// boxes[i] 为 '0' 或 '1' 
// 
//
// Related Topics 数组 字符串 👍 92 👎 0

package leetcode.editor.cn; //如果你的算法题是中文的，后缀就是cn，如果是英文的就是en
 /**
 * @author  YourName
 * @date 2022-12-02 21:05:26
 */
public class MinimumNumberOfOperationsToMoveAllBallsToEachBox{
    public static void main(String[] args) {
        Solution solution = new MinimumNumberOfOperationsToMoveAllBallsToEachBox().new Solution();
   }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] minOperations(String boxes) {
        int count = 0;
        int total = 0;
        int n = boxes.length();
        int[] result = new int[n];
        for (int i = 0; i < n; i++) {
            if (boxes.charAt(i) == '1') {
                total += i;
                count ++;
            }
            result[i] += i * count - total;
        }
        count = 0;
        total = 0;
        for (int i = n - 1; i >= 0; i--) {
            if (boxes.charAt(i) == '1') {
                total += i;
                count ++;
            }
            result[i] += total - i * count;
        }
        return result;
    }
    public int[] minOperations1(String boxes) {
        // left 在result[0]中不参与计算 最初表示result[1] 左侧的'1'的数量
        int left = boxes.charAt(0) == '1' ? 1 : 0;
        // 统计 右边的'1'的个数
        int right = 0;
        int n = boxes.length();
        int[] result = new int[n];
        for (int i = 1; i < n; i++) {
            if (boxes.charAt(i) == '1') {
                right++;
                result[0] += i;
            }
        }
        for (int i = 1; i < n; i++) {
            result[i] = result[i - 1] + left - right;
            if (boxes.charAt(i) == '1') {
                left++;
                right--;
            }
        }
        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}