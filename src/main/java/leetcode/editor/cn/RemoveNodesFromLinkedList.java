//给你一个链表的头节点 head 。 
//
// 移除每个右侧有一个更大数值的节点。 
//
// 返回修改后链表的头节点 head 。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：head = [5,2,13,3,8]
//输出：[13,8]
//解释：需要移除的节点是 5 ，2 和 3 。
//- 节点 13 在节点 5 右侧。
//- 节点 13 在节点 2 右侧。
//- 节点 8 在节点 3 右侧。
// 
//
// 示例 2： 
//
// 
//输入：head = [1,1,1,1]
//输出：[1,1,1,1]
//解释：每个节点的值都是 1 ，所以没有需要移除的节点。
// 
//
// 
//
// 提示： 
//
// 
// 给定列表中的节点数目在范围 [1, 10⁵] 内 
// 1 <= Node.val <= 10⁵ 
// 
//
// Related Topics 栈 递归 链表 单调栈 👍 38 👎 0

package leetcode.editor.cn; //如果你的算法题是中文的，后缀就是cn，如果是英文的就是en

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author  YourName
 * @date 2024-01-03 00:12:34
 */
public class RemoveNodesFromLinkedList{
    public static void main(String[] args) {
        Solution solution = new RemoveNodesFromLinkedList().new Solution();
   }
//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode removeNodes1(ListNode head) {
        Deque<ListNode> current = new ArrayDeque<>();
        ListNode temp = head;
        while (temp != null) {
            while (!current.isEmpty() && current.peekLast().val < temp.val) {
                current.removeLast();
            }
            current.addLast(temp);
            temp = temp.next;
        }
        ListNode result = new ListNode();
        temp = result;
        while (!current.isEmpty()) {
            temp.next = current.removeFirst();
            temp = temp.next;
        }
        return result.next;
    }
    public ListNode removeNodes(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode next = head.next;
        ListNode resultNext = removeNodes(next);
        if (next != null && resultNext.val > head.val) {
            head = resultNext;
        } else {
            head.next = resultNext;
        }
        return head;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}