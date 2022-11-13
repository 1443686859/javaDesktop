//给定一个按 非递减顺序 排列的数字数组
// digits 。你可以用任意次数 digits[i] 来写的数字。例如，如果
// digits = ['1','3','5']，我们可以写数字，如
// '13', '551', 和 '1351315'。 
//
// 返回 可以生成的小于或等于给定整数 n 的正整数的个数 。 
//
// 
//
// 示例 1： 
//
// 
//输入：digits = ["1","3","5","7"], n = 100
//输出：20
//解释：
//可写出的 20 个数字是：
//1, 3, 5, 7, 11, 13, 15, 17, 31, 33, 35, 37, 51, 53, 55, 57, 71, 73, 75, 77.
// 
//
// 示例 2： 
//
// 
//输入：digits = ["1","4","9"], n = 1000000000
//输出：29523
//解释：
//我们可以写 3 个一位数字，9 个两位数字，27 个三位数字，
//81 个四位数字，243 个五位数字，729 个六位数字，
//2187 个七位数字，6561 个八位数字和 19683 个九位数字。
//总共，可以使用D中的数字写出 29523 个整数。 
//
// 示例 3: 
//
// 
//输入：digits = ["7"], n = 8
//输出：1
// 
//
// 
//
// 提示： 
// 
//
// 
// 1 <= digits.length <= 9 
// digits[i].length == 1 
// digits[i] 是从 '1' 到 '9' 的数 
// digits 中的所有值都 不同 
// digits 按 非递减顺序 排列 
// 1 <= n <= 10⁹ 
// 
//
// Related Topics 数组 数学 字符串 二分查找 动态规划 👍 207 👎 0

package leetcode.editor.cn; //如果你的算法题是中文的，后缀就是cn，如果是英文的就是en

import java.util.ArrayList;
import java.util.List;

/**
 * @author  YourName
 * @date 2022-10-18 21:38:08
 */
public class NumbersAtMostNGivenDigitSet{
    public static void main(String[] args) {
        Solution solution = new NumbersAtMostNGivenDigitSet().new Solution();
        System.out.println(solution.atMostNGivenDigitSet(new String[]{"1", "7"},231));
   }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int atMostNGivenDigitSet(String[] digits, int n) {
        List<Integer> resultList =  new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        int temp = n ;
        while (temp != 0) {
            resultList.add(temp % 10);
            temp /= 10;
        }
        list.add(1);
        int result = 0;
        for (int i = 1; i <= resultList.size() - 1; i++) {
            int current = get(digits.length, i);
            list.add(current);
            result += current;
        }
        int endIndex = list.size() - 1;
        int index = resultList.size() - 1;
        for (; index >= 0; index--) {
            int current = resultList.get(index);
            int currentResult = getLeft(digits, current);
            if (currentResult >= 0) {
                if (Integer.parseInt(digits[currentResult]) != current) {
                    result += (currentResult + 1) * list.get(endIndex);
                    break;
                } else {
                    result += (currentResult) * list.get(endIndex);
                    endIndex--;
                }
            } else {
                break;
            }
        }
        if (index == -1) {
            result ++;
        }
        return result;
    }

    private int getLeft(String[] digits, int current) {
        int left = 0;
        int right = digits.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (Integer.parseInt(digits[mid]) <= current) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left - 1;
    }

    public int get(int base, int count) {
        int result = 1;
        while (count != 0) {
            if ((count & 1) != 0) {
                result *= base;
            }
            count >>= 1;
            base *= base;
        }
        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}