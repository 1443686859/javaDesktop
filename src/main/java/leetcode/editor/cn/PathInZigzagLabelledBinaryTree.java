package leetcode.editor.cn;

//在一棵无限的二叉树上，每个节点都有两个子节点，树中的节点 逐行 依次按 “之” 字形进行标记。 
//
// 如下图所示，在奇数行（即，第一行、第三行、第五行……）中，按从左到右的顺序进行标记； 
//
// 而偶数行（即，第二行、第四行、第六行……）中，按从右到左的顺序进行标记。 
//
// 
//
// 给你树上某一个节点的标号 label，请你返回从根节点到该标号为 label 节点的路径，该路径是由途经的节点标号所组成的。 
//
// 
//
// 示例 1： 
//
// 输入：label = 14
//输出：[1,3,4,14]
// 
//
// 示例 2： 
//
// 输入：label = 26
//输出：[1,2,6,10,26]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= label <= 10^6 
// 
// Related Topics 树 数学 二叉树 
// 👍 142 👎 0

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PathInZigzagLabelledBinaryTree{
    public static void main(String[] args) {
        Solution solution = new PathInZigzagLabelledBinaryTree().new Solution();
        System.out.println(solution.pathInZigZagTree(14));
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<Integer> pathInZigZagTree(int label) {
        int row = 0;
        int start = 1;
        while (start <= label) {
            row++;
            start *= 2;
        }
        List<Integer> resultList = new ArrayList<>();
        if (row % 2 == 0) {
            label = getReturnValue(label, row);
        }
        while (row > 0) {
            // 只有偶数层需要计算翻转节点
            if (row % 2== 0) {
                resultList.add(getReturnValue(label, row));
            } else {
                resultList.add(label);
            }
            label /= 2;
            row--;
        }
        Collections.reverse(resultList);
        return resultList;
    }

    public int getReturnValue(int label, int row) {
        // 计算翻转节点 翻转节点和源节点之和为 2的row-1次方 + 2的row次方 -1
        return (1<<row-1) + (1<<row) -1 - label;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}