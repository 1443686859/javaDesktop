//序列化是将数据结构或对象转换为一系列位的过程，以便它可以存储在文件或内存缓冲区中，或通过网络连接链路传输，以便稍后在同一个或另一个计算机环境中重建。 
//
// 设计一个算法来序列化和反序列化 二叉搜索树 。 对序列化/反序列化算法的工作方式没有限制。 您只需确保二叉搜索树可以序列化为字符串，并且可以将该字符串反序
//列化为最初的二叉搜索树。 
//
// 编码的字符串应尽可能紧凑。 
//
// 
//
// 示例 1： 
//
// 
//输入：root = [2,1,3]
//输出：[2,1,3]
// 
//
// 示例 2： 
//
// 
//输入：root = []
//输出：[]
// 
//
// 
//
// 提示： 
//
// 
// 树中节点数范围是 [0, 10⁴] 
// 0 <= Node.val <= 10⁴ 
// 题目数据 保证 输入的树是一棵二叉搜索树。 
// 
// Related Topics 树 深度优先搜索 广度优先搜索 设计 二叉搜索树 字符串 二叉树 👍 332 👎 0

package leetcode.editor.cn; //如果你的算法题是中文的，后缀就是cn，如果是英文的就是en



import java.util.*;
import java.util.stream.Collectors;

/*
  @author  YourName
  @date 2022-05-11 19:37:07
  */
public class SerializeAndDeserializeBst{
    public static void main(String[] args) {
//        Solution solution = new SerializeAndDeserializeBst().new Solution();
   }
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
//leetcode submit region begin(Prohibit modification and deletion)

//  Definition for a binary tree node.

public class Solution {
    List<Integer> list;
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        list = new ArrayList<>();
        postOrder(root);
        List<String> collect = list.stream().map(it -> it.toString()).collect(Collectors.toList());
        return String.join(",", collect);
    }
    public void postOrder(TreeNode root) {
        if (root == null) {
            return ;
        }
        postOrder(root.left);
        postOrder(root.right);
        list.add(root.val);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.isEmpty()) {
            return null;
        }
        String[] arr = data.split(",");
        Deque<Integer> stack = new ArrayDeque<Integer>();
        int length = arr.length;
        for (int i = 0; i < length; i++) {
            stack.push(Integer.parseInt(arr[i]));
        }
        return construct(Integer.MIN_VALUE, Integer.MAX_VALUE, stack);
    }
    TreeNode construct(int lower, int upper, Deque<Integer> stack) {
        if (stack.isEmpty() || upper < stack.peek() || lower > stack.peek()) {
            return null;
        }
        int current = stack.pop(); // 中间值
        TreeNode root = new TreeNode(current);
        root.right = construct(root.val, upper, stack);
        root.left = construct(lower, root.val, stack);
        return root;
    }
}

//leetcode submit region end(Prohibit modification and deletion)

}