//给定一个已排序的链表的头 head ， 删除原始链表中所有重复数字的节点，只留下不同的数字 。返回 已排序的链表 。 
//
// 
//
// 示例 1： 
// 
// 
//输入：head = [1,2,3,3,4,4,5]
//输出：[1,2,5]
// 
//
// 示例 2： 
// 
// 
//输入：head = [1,1,1,2,3]
//输出：[2,3]
// 
//
// 
//
// 提示： 
//
// 
// 链表中节点数目在范围 [0, 300] 内 
// -100 <= Node.val <= 100 
// 题目数据保证链表已经按升序 排列 
// 
//
// Related Topics 链表 双指针 👍 1227 👎 0

package leetcode.editor.cn; //如果你的算法题是中文的，后缀就是cn，如果是英文的就是en
 /**
 * @author  YourName
 * @date 2024-01-15 00:32:23
 */
public class RemoveDuplicatesFromSortedListIi{
    public static void main(String[] args) {
        Solution solution = new RemoveDuplicatesFromSortedListIi().new Solution();
        ListNode result = new ListNode();
        ListNode temp = result;
        int[] array = new int[]{1,2,3,3,4,4,5};
        for (int i : array) {
            result.next = new ListNode(i);
            result = result.next;
        }
        System.out.println(solution.deleteDuplicates(temp.next));
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
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode pre = new ListNode();
        pre.val = -101;
        pre.next = head;
        ListNode result = new ListNode();
        result.val = - 101;
        ListNode temp = result;
        ListNode cur = head;
        while (cur != null) {
            while (cur.next != null && cur.next != null && cur.val == cur.next.val) {
                pre = cur;
                cur = cur.next;
            }
            if (pre.val != cur.val) {
                 temp.next = new ListNode(cur.val);
                 temp = temp.next;
            }
            pre = cur;
            cur = cur.next;
        }

        return result.next;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}