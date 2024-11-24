//给你一个有 n 个结点的二叉树的根结点 root ，其中树中每个结点 node 都对应有 node.val 枚硬币。整棵树上一共有 n 枚硬币。 
//
// 在一次移动中，我们可以选择两个相邻的结点，然后将一枚硬币从其中一个结点移动到另一个结点。移动可以是从父结点到子结点，或者从子结点移动到父结点。 
//
// 返回使每个结点上 只有 一枚硬币所需的 最少 移动次数。 
//
// 
//
// 示例 1： 
// 
// 
//输入：root = [3,0,0]
//输出：2
//解释：一枚硬币从根结点移动到左子结点，一枚硬币从根结点移动到右子结点。
// 
//
// 示例 2： 
// 
// 
//输入：root = [0,3,0]
//输出：3
//解释：将两枚硬币从根结点的左子结点移动到根结点（两次移动）。然后，将一枚硬币从根结点移动到右子结点。
// 
//
// 
//
// 提示： 
//
// 
// 树中节点的数目为 n 
// 1 <= n <= 100 
// 0 <= Node.val <= n 
// 所有 Node.val 的值之和是 n 
// 
//
// Related Topics 树 深度优先搜索 二叉树 👍 464 👎 0

package leetcode.editor.cn; //如果你的算法题是中文的，后缀就是cn，如果是英文的就是en

import javax.swing.*;
import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author  YourName
 * @date 2023-07-14 22:02:51
 */
public class DistributeCoinsInBinaryTree{
    public static void main(String[] args) {
        Solution solution = new DistributeCoinsInBinaryTree().new Solution();
   }
    public class TreeNode {
     int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }
//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    class Temp {
        int level;
        TreeNode tree;

        Temp(int l, TreeNode t) {
            level = l;
            tree = t;
        }
    }
    public int distributeCoins(TreeNode root) {
        Deque<Temp> deque = new ArrayDeque<>();
        int level = 1;
        deque.add(new Temp(level, root));
        int result = 0;
        Deque<TreeNode> current = new ArrayDeque<>();
        current.add(root);
        while (!deque.isEmpty()) {
            Deque<TreeNode> next = new ArrayDeque<>();
            while (deque.getFirst().tree.val == 1) {
                deque.pop();
            }
            for (TreeNode now : current) {
                if (now.left != null) {
                    next.add(now.left);
                    if (now.left.val > 1) {
                        while (deque.getFirst().tree.val == 0 && now.left.val > 1) {
                            deque.getFirst().tree.val++;
                            deque.pop();
                            now.left.val--;
                        }
                    } else if (now.left.val == 0) {
                        deque.addLast(new Temp(level, now.left));
                    }

                }
                if (now.right != null) {
                    next.add(now.right);
                    if (now.right.val > 1) {
                        while (deque.getFirst().tree.val == 0 && now.right.val > 1) {
                            deque.getFirst().tree.val++;
                            deque.pop();
                            now.right.val--;
                        }
                    } else if (now.right.val == 0) {
                        deque.addLast(new Temp(level, now.right));
                    }
                }
            }
            current = next;
            level++;
        }
        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}