package leetcode.editor.cn;
//给你 root1 和 root2 这两棵二叉搜索树。 
//
// 请你返回一个列表，其中包含 两棵树 中的所有整数并按 升序 排序。. 
//
// 
//
// 示例 1： 
//
// 
//
// 输入：root1 = [2,1,4], root2 = [1,0,3]
//输出：[0,1,1,2,3,4]
// 
//
// 示例 2： 
//
// 输入：root1 = [0,-10,10], root2 = [5,1,7,0,2]
//输出：[-10,0,0,1,2,5,7,10]
// 
//
// 示例 3： 
//
// 输入：root1 = [], root2 = [5,1,7,0,2]
//输出：[0,1,2,5,7]
// 
//
// 示例 4： 
//
// 输入：root1 = [0,-10,10], root2 = []
//输出：[-10,0,10]
// 
//
// 示例 5： 
//
// 
//
// 输入：root1 = [1,null,8], root2 = [8,1]
//输出：[1,1,8,8]
// 
//
// 
//
// 提示： 
//
// 
// 每棵树最多有 5000 个节点。 
// 每个节点的值在 [-10^5, 10^5] 之间。 
// 
// Related Topics 树 深度优先搜索 二叉搜索树 二叉树 排序 👍 73 👎 0

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class P1305AllElementsInTwoBinarySearchTrees{
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
class Solution {
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        List<Integer> currentList1 = getList(root1);
        List<Integer> currentList2 = getList(root2);
        int size1 = currentList1.size();
        int size2 = currentList2.size();
        int i = 0;
        int j = 0;
        List<Integer> resultList = new ArrayList<>();
        while (i < size1 && j < size2) {
            if (currentList1.get(i) <= currentList2.get(j)) {
                resultList.add(currentList1.get(i));
                i++;
            } else {
                resultList.add(currentList2.get(j));
                j++;
            }
        }
           while (i < size1) {
               resultList.add(currentList1.get(i++));
           }
        while (j < size2) {
            resultList.add(currentList2.get(j++));
        }
        return resultList;
    }
    public List<Integer> getList(TreeNode root) {
        Deque<TreeNode> currentStack = new ArrayDeque<>();
        List<Integer> resultList = new ArrayList<>();
        TreeNode currentNode = root;
        while (currentNode != null || !currentStack.isEmpty()) {
            while (currentNode != null) {
                currentStack.push(currentNode);
                currentNode = currentNode.left;
            }
            if (!currentStack.isEmpty()) {
                currentNode = currentStack.pop();
                resultList.add(currentNode.val);
                currentNode = currentNode.right;
            }
        }
        return resultList;
    }
    public List<Integer> getList(List<Integer> resultList, TreeNode root) {
        if (root == null) {
            return resultList;
        }
        getList(resultList, root.left);
        resultList.add(root.val);
        getList(resultList, root.right);
        return resultList;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}