//给定一个表示数据的整数数组 data ，返回它是否为有效的 UTF-8 编码。 
//
// UTF-8 中的一个字符可能的长度为 1 到 4 字节，遵循以下的规则： 
//
// 
// 对于 1 字节 的字符，字节的第一位设为 0 ，后面 7 位为这个符号的 unicode 码。 
// 对于 n 字节 的字符 (n > 1)，第一个字节的前 n 位都设为1，第 n+1 位设为 0 ，后面字节的前两位一律设为 10 。剩下的没有提及的二进制
//位，全部为这个符号的 unicode 码。 
// 
//
// 这是 UTF-8 编码的工作方式： 
//
// 
//   Char. number range  |        UTF-8 octet sequence
//      (hexadecimal)    |              (binary)
//   --------------------+---------------------------------------------
//   0000 0000-0000 007F | 0xxxxxxx
//   0000 0080-0000 07FF | 110xxxxx 10xxxxxx
//   0000 0800-0000 FFFF | 1110xxxx 10xxxxxx 10xxxxxx
//   0001 0000-0010 FFFF | 11110xxx 10xxxxxx 10xxxxxx 10xxxxxx
// 
//
// 注意：输入是整数数组。只有每个整数的 最低 8 个有效位 用来存储数据。这意味着每个整数只表示 1 字节的数据。 
//
// 
//
// 示例 1： 
//
// 
//输入：data = [197,130,1]
//输出：true
//解释：数据表示字节序列:11000101 10000010 00000001。
//这是有效的 utf-8 编码，为一个 2 字节字符，跟着一个 1 字节字符。
// 
//
// 示例 2： 
//
// 
//输入：data = [235,140,4]
//输出：false
//解释：数据表示 8 位的序列: 11101011 10001100 00000100.
//前 3 位都是 1 ，第 4 位为 0 表示它是一个 3 字节字符。
//下一个字节是开头为 10 的延续字节，这是正确的。
//但第二个延续字节不以 10 开头，所以是不符合规则的。
// 
//
// 
//
// 提示: 
//
// 
// 1 <= data.length <= 2 * 10⁴ 
// 0 <= data[i] <= 255 
// 
// Related Topics 位运算 数组 👍 156 👎 0

package leetcode.editor.cn; //如果你的算法题是中文的，后缀就是cn，如果是英文的就是en
 /**
 * @author  YourName
 * @date 2022-03-13 21:20:02
 */
public class Utf8Validation{
    public static void main(String[] args) {
        Solution solution = new Utf8Validation().new Solution();
        System.out.println(solution.validUtf8(new int[]{250,145,145,145,145}));
   }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean validUtf8(int[] data) {
        int n = data.length;
        int start = 0;
        while (start < n) {
            int current = data[start];
            int maxIndex = 7;
            int count = 0;
            if ((current & (1 << maxIndex)) == 0) {
                start++;
                continue;
            }
            while ((current & (1 << maxIndex - count)) != 0) {
                count ++;
            }
            if (count == 1 || count > 4) {
                return false;
            }
            if (start + count - 1 >= n) {
                return false;
            }
            for (int i = start + 1; i <= start + count - 1; i++) {
                if ((data[i] & (1 << maxIndex)) == 0 || (data[i] & (1 << maxIndex - 1)) != 0) {
                    return false;
                }
            }
            start += count;

        }

        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}