//在柠檬水摊上，每一杯柠檬水的售价为 5 美元。顾客排队购买你的产品，（按账单 bills 支付的顺序）一次购买一杯。 
//
// 每位顾客只买一杯柠檬水，然后向你付 5 美元、10 美元或 20 美元。你必须给每个顾客正确找零，也就是说净交易是每位顾客向你支付 5 美元。 
//
// 注意，一开始你手头没有任何零钱。 
//
// 给你一个整数数组 bills ，其中 bills[i] 是第 i 位顾客付的账。如果你能给每位顾客正确找零，返回 true ，否则返回 false 。 
//
// 
//
// 示例 1： 
//
// 
//输入：bills = [5,5,5,10,20]
//输出：true
//解释：
//前 3 位顾客那里，我们按顺序收取 3 张 5 美元的钞票。
//第 4 位顾客那里，我们收取一张 10 美元的钞票，并返还 5 美元。
//第 5 位顾客那里，我们找还一张 10 美元的钞票和一张 5 美元的钞票。
//由于所有客户都得到了正确的找零，所以我们输出 true。
// 
//
// 示例 2： 
//
// 
//输入：bills = [5,5,10,10,20]
//输出：false
//解释：
//前 2 位顾客那里，我们按顺序收取 2 张 5 美元的钞票。
//对于接下来的 2 位顾客，我们收取一张 10 美元的钞票，然后返还 5 美元。
//对于最后一位顾客，我们无法退回 15 美元，因为我们现在只有两张 10 美元的钞票。
//由于不是每位顾客都得到了正确的找零，所以答案是 false。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= bills.length <= 10⁵ 
// bills[i] 不是 5 就是 10 或是 20 
// 
//
// Related Topics 贪心 数组 👍 510 👎 0

package leetcode.editor.cn; //如果你的算法题是中文的，后缀就是cn，如果是英文的就是en


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.TreeMap;

/**
 * @author  YourName
 * @date 2023-07-22 20:10:54
 */
public class LemonadeChange{
    public static void main(String[] args) {
        Solution solution = new LemonadeChange().new Solution();
        System.out.println(solution.splitWordsBySeparator(Arrays.asList("one.two.three","four.five","six"), '.'));
   }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean lemonadeChange(int[] bills) {
        int[] result = new int[2];
        for (int i : bills) {
            if (i == 5) {
                result[0] ++;
            } else if (i == 10) {
                result[0]--;
                if (result[0] < 0) {
                    return false;
                }
                result[1]++;
            } else if (i == 20) {
                if (result[0] >= 1 && result[1] >= 1) {
                    result[0]--;
                    result[1]--;
                } else if (result[0] >= 3) {
                    result[0] -= 3;
                } else {
                    return false;
                }
            }
        }

        return true;
    }
    public List<String> splitWordsBySeparator(List<String> words, char separator) {
        List<String> result = new ArrayList<>();
        for (String word : words) {
            StringBuilder current = new StringBuilder();
            for (Character c : word.toCharArray()) {
                if (c == separator) {
                    if (current.length() != 0) {
                        result.add(current.toString());
                    }
                    current = new StringBuilder();
                    continue;
                }
                current.append(c);
            }
            if (current.length() != 0) {
                result.add(current.toString());
            }
        }
        return  result;
    }

    public String sortVowels(String s) {
        List<Character> list = Arrays.asList('a', 'e','i','o','u', 'A','E','I','O', 'U');
        TreeMap<Character, Integer> result = new TreeMap<>();
        char[] ans = new char[s.length()];
        for (int i = 0; i < s.length(); i++) {
            if (list.contains(s.charAt(i))) {
                result.put(s.charAt(i), result.getOrDefault(s.charAt(i), 0) + 1);
            }
        }
        for (int i = 0; i < ans.length; i++) {
            if (!list.contains(s.charAt(i))) {
                ans[i] = s.charAt(i);
            } else {
                ans[i] = result.firstKey();
                result.put(ans[i], result.get(ans[i]) - 1);
                if (result.get(ans[i]) == 0) {
                    result.remove(ans[i]);
                }
            }
        }
        return new String(ans);
    }

    long[] count;

    boolean[] used;

    int mod = (int)1e9+7;

    public int numberOfWays(int n, int x) {
        count = new long[n + 1];
        used = new boolean[n + 1];
        for (int i = 1; i <= n; i++) {
            count[i] = i;
            for (int j = 1; j < x; j++) {
                count[i] = count[i] * i;
            }
        }
        return dfs(n, 1);
    }
    public int dfs(int rest, int startIndex) {
        if (rest == 0) {
            return 1;
        }
        if (rest < 0) {
            return 0;
        }
        int current = 0;
        for (int i = startIndex; i < count.length && count[i] <= rest; i++) {
            if (!used[i]) {
                used[i] = true;
                current = (current % mod + dfs((int)(rest - count[i]), i + 1) % mod) % mod;
                used[i] = false;
            }
        }
        return current;
    }

    public int maxIncreasingGroups(List<Integer> usageLimits) {
        return 0;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}