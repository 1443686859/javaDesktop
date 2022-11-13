//基因序列可以表示为一条由 8 个字符组成的字符串，其中每个字符都是 'A'、'C'、'G' 和 'T' 之一。 
//
// 假设我们需要调查从基因序列 start 变为 end 所发生的基因变化。一次基因变化就意味着这个基因序列中的一个字符发生了变化。 
//
// 
// 例如，"AACCGGTT" --> "AACCGGTA" 就是一次基因变化。 
// 
//
// 另有一个基因库 bank 记录了所有有效的基因变化，只有基因库中的基因才是有效的基因序列。 
//
// 给你两个基因序列 start 和 end ，以及一个基因库 bank ，请你找出并返回能够使 start 变化为 end 所需的最少变化次数。如果无法完成
//此基因变化，返回 -1 。 
//
// 注意：起始基因序列 start 默认是有效的，但是它并不一定会出现在基因库中。 
//
// 
//
// 示例 1： 
//
// 
//输入：start = "AACCGGTT", end = "AACCGGTA", bank = ["AACCGGTA"]
//输出：1
// 
//
// 示例 2： 
//
// 
//输入：start = "AACCGGTT", end = "AAACGGTA", bank = ["AACCGGTA","AACCGCTA",
//"AAACGGTA"]
//输出：2
// 
//
// 示例 3： 
//
// 
//输入：start = "AAAAACCC", end = "AACCCCCC", bank = ["AAAACCCC","AAACCCCC",
//"AACCCCCC"]
//输出：3
// 
//
// 
//
// 提示： 
//
// 
// start.length == 8 
// end.length == 8 
// 0 <= bank.length <= 10 
// bank[i].length == 8 
// start、end 和 bank[i] 仅由字符 ['A', 'C', 'G', 'T'] 组成 
// 
// Related Topics 广度优先搜索 哈希表 字符串 👍 181 👎 0

package leetcode.editor.cn; //如果你的算法题是中文的，后缀就是cn，如果是英文的就是en

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;

/**
 * @author  YourName
 * @date 2022-05-07 19:29:01
 */
public class MinimumGeneticMutation{
    public static void main(String[] args) {
        Solution solution = new MinimumGeneticMutation().new Solution();
        System.out.println(solution.minMutation("AACCGGTT",
                "AACCGGTA",
                        new String[]{"AACCGGTA"}));
   }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int minMutation(String start, String end, String[] bank) {
        int result = 0;
        char[] target = new char[]{'A','C','G', 'T' };
        Map<String, Boolean> visited = new HashMap<>();
        if (start.equals(end)) {
            return 0;
        }
        for (String s : bank) {
            visited.put(s, false);
        }
        if (!visited.containsKey(end)) {
            return -1;
        }
        Queue<String> queue = new ArrayDeque<>();
        queue.offer(start);
        while (!queue.isEmpty()) {
            result++;
            int size = queue.size();
            boolean getOut = false;
            for (int i = 0; i < size; i++) {
                StringBuilder current = new StringBuilder(queue.poll());
                for (int j = 0; j < current.length(); j++) {
                    char currentChar = current.charAt(j);
                    for (int z = 0; z < target.length; z++) {
                        if (currentChar != target[z]) {
                            current.setCharAt(j, target[z]);
                            if (end.equals(current.toString())) {
                                getOut = true;
                                visited.put(end, true);
                                break;
                            } else if (visited.containsKey(current.toString()) && !visited.get(current.toString())) {
                                visited.put(current.toString(), true);
                                queue.offer(current.toString());
                            }
                        }
                    }
                    current.setCharAt(j, currentChar);
                    if (getOut) {
                        break;
                    }
                }
                if (getOut) {
                    break;
                }
            }
            if (getOut) {
                break;
            }
        }
        return  visited.get(end) ? result : -1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}