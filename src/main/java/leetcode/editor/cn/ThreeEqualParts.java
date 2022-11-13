//给定一个由 0 和 1 组成的数组
// arr ，将数组分成 3 个非空的部分 ，使得所有这些部分表示相同的二进制值。 
//
// 如果可以做到，请返回任何 [i, j]，其中 i+1 < j，这样一来： 
//
// 
// arr[0], arr[1], ..., arr[i] 为第一部分； 
// arr[i + 1], arr[i + 2], ..., arr[j - 1] 为第二部分； 
// arr[j], arr[j + 1], ..., arr[arr.length - 1] 为第三部分。 
// 这三个部分所表示的二进制值相等。 
// 
//
// 如果无法做到，就返回 [-1, -1]。 
//
// 注意，在考虑每个部分所表示的二进制时，应当将其看作一个整体。例如，[1,1,0] 表示十进制中的 6，而不会是 3。此外，前导零也是被允许的，所以 [0,
//1,1] 和 [1,1] 表示相同的值。 
//
// 
//
// 示例 1： 
//
// 
//输入：arr = [1,0,1,0,1]
//输出：[0,3]
// 
//
// 示例 2： 
//
// 
//输入：arr = [1,1,0,1,1]
//输出：[-1,-1] 
//
// 示例 3: 
//
// 
//输入：arr = [1,1,0,0,1]
//输出：[0,2]
// 
//
// 
//
// 提示： 
// 
//
// 
// 3 <= arr.length <= 3 * 10⁴ 
// arr[i] 是 0 或 1 
// 
//
// Related Topics 数组 数学 👍 108 👎 0

package leetcode.editor.cn; //如果你的算法题是中文的，后缀就是cn，如果是英文的就是en
 /**
 * @author  YourName
 * @date 2022-10-06 10:05:43
 */
public class ThreeEqualParts{
    public static void main(String[] args) {
        Solution solution = new ThreeEqualParts().new Solution();
   }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] threeEqualParts(int[] arr) {
        int[] result = new int[]{-1, -1};
        int count = 0;
        for (int i : arr) {
            if (i == 1) {
                count++;
            }
        }
        if (count % 3 != 0) {
            return result;
        }
        if (count == 0) {
            return new int[]{0, arr.length - 1};
        }
        int target = count / 3;
        int first = 0;
        int second = 0;
        int third = 0;
        int cur = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 1) {
                if (cur == 0) {
                    first = i;
                } else if (cur == target) {
                    second = i;
                } else if (cur == 2 * target) {
                    third = i;
                }
                cur++;
            }
        }
        int len = arr.length - third;
        if (first + len <= second && second + len <= third) {
            int i = 0;
            while (i < len) {
                if (arr[third + i] != arr[second + i] || arr[first + i] != arr[second + i]) {
                    return result;
                }
                i++;
            }
            return new int[]{first + len - 1, second + len};
        }
        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}