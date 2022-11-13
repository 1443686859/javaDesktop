//Alice 在给 Bob 用手机打字。数字到字母的 对应 如下图所示。 
//
// 
//
// 为了 打出 一个字母，Alice 需要 按 对应字母 i 次，i 是该字母在这个按键上所处的位置。 
//
// 
// 比方说，为了按出字母 's' ，Alice 需要按 '7' 四次。类似的， Alice 需要按 '5' 两次得到字母 'k' 。 
// 注意，数字 '0' 和 '1' 不映射到任何字母，所以 Alice 不 使用它们。 
// 
//
// 但是，由于传输的错误，Bob 没有收到 Alice 打字的字母信息，反而收到了 按键的字符串信息 。 
//
// 
// 比方说，Alice 发出的信息为 "bob" ，Bob 将收到字符串 "2266622" 。 
// 
//
// 给你一个字符串 pressedKeys ，表示 Bob 收到的字符串，请你返回 Alice 总共可能发出多少种文字信息 。 
//
// 由于答案可能很大，将它对 10⁹ + 7 取余 后返回。 
//
// 
//
// 示例 1： 
//
// 输入：pressedKeys = "22233"
//输出：8
//解释：
//Alice 可能发出的文字信息包括：
//"aaadd", "abdd", "badd", "cdd", "aaae", "abe", "bae" 和 "ce" 。
//由于总共有 8 种可能的信息，所以我们返回 8 。
// 
//
// 示例 2： 
//
// 输入：pressedKeys = "222222222222222222222222222222222222"
//输出：82876089
//解释：
//总共有 2082876103 种 Alice 可能发出的文字信息。
//由于我们需要将答案对 10⁹ + 7 取余，所以我们返回 2082876103 % (10⁹ + 7) = 82876089 。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= pressedKeys.length <= 10⁵ 
// pressedKeys 只包含数字 '2' 到 '9' 。 
// 
// 👍 21 👎 0

package leetcode.editor.cn; //如果你的算法题是中文的，后缀就是cn，如果是英文的就是en

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author  YourName
 * @date 2022-05-10 20:07:42
 */
public class CountNumberOfTexts{
    public static void main(String[] args) {
        Solution solution = new CountNumberOfTexts().new Solution();
        System.out.println(solution.countTexts("444444444444444444444444444444448888888888888888999999999999333333333333333366666666666666662222222222222222666666666666666633333333333333338888888888888888222222222222222244444444444444448888888888888222222222222222288888888888889999999999999999333333333444444664"));
   }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
        int mod = 1000000000 + 7;
    int[] base = new int[]{1,2,3};
    int[] newBase = new int[]{1,2,3,4};
    List<Integer> baseList = new ArrayList<>();

    List<Integer> newBaseList = new ArrayList<>();
    List<Character> list = Arrays.asList('7','9');
    public int countTexts(String pressedKeys) {
        int length = pressedKeys.length();
        int tempLength = 0;
        char preChar = ' ';
        long result = 1;
        baseList.add(1);
        newBaseList.add(1);
        for (int i = 0; i < length; i++) {
            char currentChar = pressedKeys.charAt(i);
            if (preChar != currentChar) {
                result = (result % mod *  get(tempLength, preChar)) % mod;
                tempLength = 0;
            }
            tempLength++;
            preChar = currentChar;
        }
        if (tempLength != 0) {
            result = (result * get(tempLength, preChar));
        }
        result %= mod;
        return (int)result;
    }
    public int get(int length, char currentChar) {
        int[] count;
        List<Integer> currentList;
        if (list.contains(currentChar)) {
            count = newBase;
            currentList = newBaseList;
        } else {
            count = base;
            currentList = baseList;
        }
        if (length < currentList.size()) {
            return currentList.get(length);
        }
        int start = currentList.size() - 1;
        for (int i = start + 1; i <= length; i++) {
            int result = 0;
            for (int j = 0; j < count.length; j++) {
                int index = i - count[j];
                if (index >= 0) {
                    result = (result % mod + currentList.get(index) % mod) % mod ;
                }
            }
            currentList.add(result);
        }
        return currentList.get(length);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}