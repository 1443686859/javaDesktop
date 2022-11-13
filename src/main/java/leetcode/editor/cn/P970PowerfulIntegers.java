package leetcode.editor.cn;
//给定三个整数 x 、 y 和 bound ，返回 值小于或等于 bound 的所有 强整数 组成的列表 。 
//
// 如果某一整数可以表示为 xⁱ + yʲ ，其中整数 i >= 0 且 j >= 0，那么我们认为该整数是一个 强整数 。 
//
// 你可以按 任何顺序 返回答案。在你的回答中，每个值 最多 出现一次。 
//
// 
//
// 示例 1： 
//
// 
//输入：x = 2, y = 3, bound = 10
//输出：[2,3,4,5,7,9,10]
//解释： 
//2 = 2⁰ + 3⁰
//3 = 2¹ + 3⁰
//4 = 2⁰ + 3¹
//5 = 2¹ + 3¹
//7 = 2² + 3¹
//9 = 2³ + 3⁰
//10 = 2⁰ + 3² 
//
// 示例 2： 
//
// 
//输入：x = 3, y = 5, bound = 15
//输出：[2,4,6,8,10,14]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= x, y <= 100 
// 0 <= bound <= 10⁶ 
// 
// Related Topics 哈希表 数学 👍 55 👎 0

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class P970PowerfulIntegers{
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    int base1;
    int base2;
    Set<Integer> resultSet = new HashSet<>();
    public List<Integer> powerfulIntegers(int x, int y, int bound) {
        base1 = x;
        base2 = y;
        if (bound >= 2) {
            resultSet.add(2);
        }
        if (bound >= x + 1) {
            resultSet.add(x + 1);
        }
        if (bound >= y + 1) {
            resultSet.add(y + 1);
        }
        cycle(x, y, bound);
        return resultSet.stream().collect(Collectors.toList());
    }
    public void cycle(int x, int y, int bound) {
        if (x + y <= bound) {
            resultSet.add(x + y);
        } else {
            return;
        }
        if (x * base1 < bound) {
            cycle(x * base1, y, bound);
        }
        if (y * base2 < bound) {
            cycle(x, y * base2, bound);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}