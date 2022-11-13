//给你一个链表的头节点 head ，旋转链表，将链表每个节点向右移动 k 个位置。 
//
// 
//
// 示例 1： 
//
// 
//输入：head = [1,2,3,4,5], k = 2
//输出：[4,5,1,2,3]
// 
//
// 示例 2： 
//
// 
//输入：head = [0,1,2], k = 4
//输出：[2,0,1]
// 
//
// 
//
// 提示： 
//
// 
// 链表中节点的数目在范围 [0, 500] 内 
// -100 <= Node.val <= 100 
// 0 <= k <= 2 * 10⁹ 
// 
// Related Topics 链表 双指针 👍 652 👎 0


package leetcode.editor.cn;
//Java：旋转链表
public class T61_RotateList{
    public static void main(String[] args) {
        Solution solution = new T61_RotateList().new Solution();
        // TO TEST
    }
      class ListNode {
      int val;
     ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
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
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null) {
            return head;
        }
        int length = 1;
        ListNode temp = head;
        while (temp.next != null) {
            length++;
            temp = temp.next;
        }
        temp.next = head;
        int cycle = length - k % length;
        while (cycle > 1) {
            cycle--;
            head = head.next;
        }
        ListNode next = head.next;
        head.next = null;
        return next;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}