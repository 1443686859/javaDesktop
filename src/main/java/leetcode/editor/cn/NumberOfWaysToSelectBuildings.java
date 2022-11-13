//给你一个下标从 0 开始的二进制字符串 s ，它表示一条街沿途的建筑类型，其中： 
//
// 
// s[i] = '0' 表示第 i 栋建筑是一栋办公楼， 
// s[i] = '1' 表示第 i 栋建筑是一间餐厅。 
// 
//
// 作为市政厅的官员，你需要随机 选择 3 栋建筑。然而，为了确保多样性，选出来的 3 栋建筑 相邻 的两栋不能是同一类型。 
//
// 
// 比方说，给你 s = "001101" ，我们不能选择第 1 ，3 和 5 栋建筑，因为得到的子序列是 "011" ，有相邻两栋建筑是同一类型，所以 不合
// 题意。 
// 
//
// 请你返回可以选择 3 栋建筑的 有效方案数 。 
//
// 
//
// 示例 1： 
//
// 输入：s = "001101"
//输出：6
//解释：
//以下下标集合是合法的：
//- [0,2,4] ，从 "001101" 得到 "010"
//- [0,3,4] ，从 "001101" 得到 "010"
//- [1,2,4] ，从 "001101" 得到 "010"
//- [1,3,4] ，从 "001101" 得到 "010"
//- [2,4,5] ，从 "001101" 得到 "101"
//- [3,4,5] ，从 "001101" 得到 "101"
//没有别的合法选择，所以总共有 6 种方法。
// 
//
// 示例 2： 
//
// 输入：s = "11100"
//输出：0
//解释：没有任何符合题意的选择。
// 
//
// 
//
// 提示： 
//
// 
// 3 <= s.length <= 10⁵ 
// s[i] 要么是 '0' ，要么是 '1' 。 
// 
// 👍 3 👎 0

package leetcode.editor.cn; //如果你的算法题是中文的，后缀就是cn，如果是英文的就是en
 /**
 * @author  YourName
 * @date 2022-04-03 09:25:59
 */
public class NumberOfWaysToSelectBuildings{
    public static void main(String[] args) {
        Solution solution = new NumberOfWaysToSelectBuildings().new Solution();
   }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public long numberOfWays(String s) {
        int n = s.length();
        int[] leftZeroCountArray = new int[n];
        int[] rightZeroCountArray = new int[n];
        int[] leftOneCountArray = new int[n];
        int[] rightOneCountArray = new int[n];
        int leftZeroCount = 0;
        int rightZeroCount = 0;
        int leftOneCount = 0;
        int rightOneCount = 0;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '0') {
                leftZeroCount++;
                leftOneCountArray[i] =  leftOneCount;
            }
            if (s.charAt(i) == '1') {
                leftOneCount++;
                leftZeroCountArray[i] = leftZeroCount;
            }
        }
        for (int i = n - 1; i >= 0; i--) {
            if (s.charAt(i) == '0') {
                rightZeroCount++;
                rightOneCountArray[i] =  rightOneCount;
            }
            if (s.charAt(i) == '1') {
                rightOneCount++;
                rightZeroCountArray[i] = rightZeroCount;
            }
        }
        int result = 0;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '0') {
                result += leftOneCountArray[i] * rightOneCountArray[i];
            }
            if (s.charAt(i) == '1') {
                result += rightZeroCountArray[i] * leftZeroCountArray[i];
            }
        }
        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}