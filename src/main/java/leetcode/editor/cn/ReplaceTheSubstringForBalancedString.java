//有一个只含有 'Q', 'W', 'E', 'R' 四种字符，且长度为 n 的字符串。 
//
// 假如在该字符串中，这四个字符都恰好出现 n/4 次，那么它就是一个「平衡字符串」。 
//
// 
//
// 给你一个这样的字符串 s，请通过「替换一个子串」的方式，使原字符串 s 变成一个「平衡字符串」。 
//
// 你可以用和「待替换子串」长度相同的 任何 其他字符串来完成替换。 
//
// 请返回待替换子串的最小可能长度。 
//
// 如果原字符串自身就是一个平衡字符串，则返回 0。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "QWER"
//输出：0
//解释：s 已经是平衡的了。 
//
// 示例 2： 
//
// 
//输入：s = "QQWE"
//输出：1
//解释：我们需要把一个 'Q' 替换成 'R'，这样得到的 "RQWE" (或 "QRWE") 是平衡的。
// 
//
// 示例 3： 
//
// 
//输入：s = "QQQW"
//输出：2
//解释：我们可以把前面的 "QQ" 替换成 "ER"。 
// 
//
// 示例 4： 
//
// 
//输入：s = "QQQQ"
//输出：3
//解释：我们可以替换后 3 个 'Q'，使 s = "QWER"。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 10^5 
// s.length 是 4 的倍数 
// s 中只含有 'Q', 'W', 'E', 'R' 四种字符 
// 
//
// Related Topics 字符串 滑动窗口 👍 195 👎 0

package leetcode.editor.cn; //如果你的算法题是中文的，后缀就是cn，如果是英文的就是en

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author  YourName
 * @date 2023-02-13 19:48:51
 */
public class ReplaceTheSubstringForBalancedString{
    public static void main(String[] args) {
        Solution solution = new ReplaceTheSubstringForBalancedString().new Solution();
        System.out.println(solution.balancedString("QEQRWRRWWWRQQQWQQEQEQREWRQEQRQQRRQEW"));
   }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int balancedString(String s) {
        int[] counts = new int[26];     // 使用数组来存储四个字符的出现次数（使用数组便于代码书写）
        int len = s.length();   // 字符串长度
        int limit = len / 4;    // n / 4
        char ch;
        // 初始化不替换内容字符出现次数数组，即初始滑动窗口维护一个空串
        for(int i = 0; i < len; i++){
            ch = s.charAt(i);
            counts[ch - 'A']++;
        }
        // 初始化滑动窗口左右指针，维护的子串是[left,right]的内容
        // 初始化子串为空，因此left=0，right=-1表示一个空子串
        int left = 0;
        int right = -1;
        int minLength = len;    // 最小替换子串长度，初始为整个字符串长度
        // 滑动窗口
        while(left < len){
            if(check(counts, limit)){   // 校验通过
                // 记录当前合法子串的长度并更新最小长度
                // 左指针右移，那么原本左指针指向的字符就变成不替换的内容，不替换内容多了一个字符，对应count数组中的值加1
                minLength = Math.min(minLength, right - left + 1);
                counts[s.charAt(left++) - 'A']++;
            }else if(right < len - 1){
                // 当前子串不合法且右指针还没到头
                // 右指针右移，移动后的右指针指向的字符变成了子串的内容，不替换的内容少了一个字符，对应count数组中的值减1
                counts[s.charAt(++right) - 'A']--;
            }else{
                // 右指针到头，搜索结束
                break;
            }
        }
        return minLength;

    }

    /**
     * 校验函数，校验当前counts中四个字符的出现次数是否都小于等于limit；
     * 是返回true，否返回false
     */
    private boolean check(int[] counts, int limit){
        if(counts['Q' - 'A'] > limit || counts['W' - 'A'] > limit || counts['E' - 'A'] > limit || counts['R' - 'A'] > limit){
            return false;
        }
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}