/**
给你一个正整数 n。 

 如果一个二进制字符串 x 的所有长度为 2 的子字符串中包含 至少 一个 "1"，则称 x 是一个 有效 字符串。 

 返回所有长度为 n 的 有效 字符串，可以以任意顺序排列。 

 

 示例 1： 

 
 输入： n = 3 
 

 输出： ["010","011","101","110","111"] 

 解释： 

 长度为 3 的有效字符串有："010"、"011"、"101"、"110" 和 "111"。 

 示例 2： 

 
 输入： n = 1 
 

 输出： ["0","1"] 

 解释： 

 长度为 1 的有效字符串有："0" 和 "1"。 

 

 提示： 

 
 1 <= n <= 18 
 

 👍 33 👎 0

*/
package leetcode.editor.cn; //如果你的算法题是中文的，后缀就是cn，如果是英文的就是en

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author  YourName
 * @date 2024-10-29 21:49:22
 */
public class GenerateBinaryStringsWithoutAdjacentZeros{
    public static void main(String[] args) {
        Solution solution = new GenerateBinaryStringsWithoutAdjacentZeros().new Solution();
        System.out.println(solution.validStrings(11));
   }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    int max;
    List<String> result;
    public List<String> validStrings(int n) {
        max = n;
        result = new ArrayList<>();
        char[] path = new char[n];
        Arrays.fill(path, '0');
        dfs(n, n + 1, path);
        return result;
    }
    public void dfs(int count, int pre, char[] path) {
        if (count == 0) {
            result.add(new String(path));
            return;
        }
        if (pre - count != 2) {
            dfs(count - 1, pre,path);
        }
        path[max - count] = '1';
        dfs(count - 1, count, path);
        path[max - count] = '0';
    }

}
//leetcode submit region end(Prohibit modification and deletion)

}