//给你一个整数 n 表示一棵 满二叉树 里面节点的数目，节点编号从 1 到 n 。根节点编号为 1 ，树中每个非叶子节点 i 都有两个孩子，分别是左孩子 2 
//* i 和右孩子 2 * i + 1 。 
//
// 树中每个节点都有一个值，用下标从 0 开始、长度为 n 的整数数组 cost 表示，其中 cost[i] 是第 i + 1 个节点的值。每次操作，你可以将
//树中 任意 节点的值 增加 1 。你可以执行操作 任意 次。 
//
// 你的目标是让根到每一个 叶子结点 的路径值相等。请你返回 最少 需要执行增加操作多少次。 
//
// 注意： 
//
// 
// 满二叉树 指的是一棵树，它满足树中除了叶子节点外每个节点都恰好有 2 个子节点，且所有叶子节点距离根节点距离相同。 
// 路径值 指的是路径上所有节点的值之和。 
// 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：n = 7, cost = [1,5,2,2,3,3,1]
//输出：6
//解释：我们执行以下的增加操作：
//- 将节点 4 的值增加一次。
//- 将节点 3 的值增加三次。
//- 将节点 7 的值增加两次。
//从根到叶子的每一条路径值都为 9 。
//总共增加次数为 1 + 3 + 2 = 6 。
//这是最小的答案。
// 
//
// 示例 2： 
//
// 
//
// 
//输入：n = 3, cost = [5,3,3]
//输出：0
//解释：两条路径已经有相等的路径值，所以不需要执行任何增加操作。
// 
//
// 
//
// 提示： 
//
// 
// 3 <= n <= 10⁵ 
// n + 1 是 2 的幂 
// cost.length == n 
// 1 <= cost[i] <= 10⁴ 
// 
//
// Related Topics 贪心 树 数组 动态规划 二叉树 👍 62 👎 0

package leetcode.editor.cn; //如果你的算法题是中文的，后缀就是cn，如果是英文的就是en
 /**
 * @author  YourName
 * @date 2024-02-28 21:37:53
 */
public class MakeCostsOfPathsEqualInABinaryTree{
    public static void main(String[] args) {
        Solution solution = new MakeCostsOfPathsEqualInABinaryTree().new Solution();
   }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int minIncrements(int n, int[] cost) {
        int index = n / 2;
        int count = 0;
        int[] sum = new int[n];
        for (int i = index; i < n; i++) {
            sum[i] = cost[i];
        }
        while (index != 0) {
            int preIndex = index / 2;
            for (int i = preIndex; i < index; i++) {
                int left = i * 2 + 1;
                int right = i * 2 + 2;
                sum[i] = cost[i] + Math.max(sum[left], sum[right]);
                count += 2 * Math.max(sum[left], sum[right]) - sum[left] - sum[right];
            }
            index = preIndex;
        }
        return count;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}