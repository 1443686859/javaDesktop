////给定一个 n 叉树的根节点 root ，返回 其节点值的 前序遍历 。 
////
//// n 叉树 在输入中按层序遍历进行序列化表示，每组子节点由空值 null 分隔（请参见示例）。 
////
//// 
////示例 1： 
////
//// 
////
//// 
////输入：root = [1,null,3,2,4,null,5,6]
////输出：[1,3,5,6,2,4]
//// 
////
//// 示例 2： 
////
//// 
////
//// 
////输入：root = [1,null,2,3,4,5,null,null,6,7,null,8,null,9,10,null,null,11,null,1
//2,
////null,13,null,null,14]
////输出：[1,2,3,6,7,11,14,4,8,12,5,9,13,10]
//// 
////
//// 
////
//// 提示： 
////
//// 
//// 节点总数在范围 [0, 10⁴]内 
//// 0 <= Node.val <= 10⁴ 
//// n 叉树的高度小于或等于 1000 
//// 
////
//// 
////
//// 进阶：递归法很简单，你可以使用迭代法完成此题吗? 
//// Related Topics 栈 树 深度优先搜索 👍 226 👎 0
//

package leetcode.editor.cn; //如果你的算法题是中文的，后缀就是cn，如果是英文的就是en

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @author  YourName
 * @date 2022-03-10 09:25:21
 */
public class NAryTreePreorderTraversal{
    public static void main(String[] args) {
        Solution solution = new NAryTreePreorderTraversal().new Solution();
   }
    class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    };
//leetcode submit region begin(Prohibit modification and deletion)
// Definition for a Node.


class Solution {
    public List<Integer> preorder(Node root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Deque<Node> stack = new ArrayDeque<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            Node current = stack.pop();
            res.add(current.val);
            for (int i = current.children.size() - 1; i >= 0; i--) {
                stack.push(current.children.get(i));
            }
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}