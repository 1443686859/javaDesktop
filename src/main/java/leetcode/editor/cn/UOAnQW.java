/**
「力扣挑战赛」心算项目的挑战比赛中，要求选手从 `N` 张卡牌中选出 `cnt` 张卡牌，若这 `cnt` 张卡牌数字总和为偶数，则选手成绩「有效」且得分为 `
cnt` 张卡牌数字总和。
给定数组 `cards` 和 `cnt`，其中 `cards[i]` 表示第 `i` 张卡牌上的数字。 请帮参赛选手计算最大的有效得分。若不存在获取有效得分的卡
牌方案，则返回 0。

**示例 1：**

> 输入：`cards = [1,2,8,9], cnt = 3`
>
> 输出：`18`
>
> 解释：选择数字为 1、8、9 的这三张卡牌，此时可获得最大的有效得分 1+8+9=18。

**示例 2：**

> 输入：`cards = [3,3,1], cnt = 1`
>
> 输出：`0`
>
> 解释：不存在获取有效得分的卡牌方案。

**提示：**
- `1 <= cnt <= cards.length <= 10^5`
- `1 <= cards[i] <= 1000`

 👍 107 👎 0

*/
package leetcode.editor.cn; //如果你的算法题是中文的，后缀就是cn，如果是英文的就是en

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author  YourName
 * @date 2024-08-01 20:33:35
 */
public class UOAnQW{
    public static void main(String[] args) {
        Solution solution = new UOAnQW().new Solution();
        System.out.println(solution.maxmiumScore(new int[]{10,3}, 1));
   }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maxmiumScore(int[] cards, int cnt) {
        Arrays.sort(cards);
        int s = 0;
        int n = cards.length;
        for (int i = n - cnt; i < n; i++) {
            s += cards[i];
        }
        if (s % 2 == 0) {
            return s;
        }
        int x = cards[n - cnt];
        int ans = replace(cards, cnt, s, x);
        for (int i = n - cnt + 1; i < n; i++) {
            if (cards[i] % 2 != x % 2) {
                ans = Math.max(ans, replace(cards, cnt, s, cards[i]));
                break;
            }
        }
        return ans;

    }
    public int replace(int[] cards, int cnt, int s, int x) {
        for (int i = cards.length - cnt - 1; i >= 0; i--) {
            if (cards[i] % 2 != x % 2) {
                return s - x + cards[i];
            }
        }
        return 0;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}