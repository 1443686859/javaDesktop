//给你一个链表的头节点 head，请你编写代码，反复删去链表中由 总和 值为 0 的连续节点组成的序列，直到不存在这样的序列为止。 
//
// 删除完毕后，请你返回最终结果链表的头节点。 
//
// 
//
// 你可以返回任何满足题目要求的答案。 
//
// （注意，下面示例中的所有序列，都是对 ListNode 对象序列化的表示。） 
//
// 示例 1： 
//
// 输入：head = [1,2,-3,3,1]
//输出：[3,1]
//提示：答案 [1,2,1] 也是正确的。
// 
//
// 示例 2： 
//
// 输入：head = [1,2,3,-3,4]
//输出：[1,2,4]
// 
//
// 示例 3： 
//
// 输入：head = [1,2,3,-3,-2]
//输出：[1]
// 
//
// 
//
// 提示： 
//
// 
// 给你的链表中可能有 1 到 1000 个节点。 
// 对于链表中的每个节点，节点的值：-1000 <= node.val <= 1000. 
// 
//
// Related Topics 哈希表 链表 👍 218 👎 0

package leetcode.editor.cn; //如果你的算法题是中文的，后缀就是cn，如果是英文的就是en

import java.util.AbstractList;
import java.util.HashMap;
import java.util.Map;

/**
 * @author  YourName
 * @date 2023-06-11 10:05:49
 */
public class RemoveZeroSumConsecutiveNodesFromLinkedList{
    public static void main(String[] args) {
        Solution solution = new RemoveZeroSumConsecutiveNodesFromLinkedList().new Solution();
        ListNode head = new ListNode(1);
        head.next = new ListNode(0);
        System.out.println(solution.removeZeroSumSublists(solution.create(new int[] {1,3,2,-3,-2,5,5,-5,1})));
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
    public ListNode removeZeroSumSublists(ListNode head) {
        ListNode pre = new ListNode();
        pre.next = head;
        ListNode next = head;
        Map<Integer, ListNode> map = new HashMap<>();
        map.put(0, pre);
        int sum = 0;
        while (next != null) {
            sum += next.val;
            map.put(sum, next);
            next = next.next;
        }
        sum = 0;
        ListNode current = head;
        while (current != null) {
            sum += next.val;
            if (map.containsKey(sum)) {
                current.next = map.get(sum).next;
            }
            current = current.next;
        }
        return pre.next;
    }
    public ListNode create(int[] array) {
        ListNode start = new ListNode();
        ListNode current = start;
        for (int i = 0; i < array.length ; i++) {
            start.next = new ListNode(array[i]);
            start = start.next;
        }
        return current.next;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}