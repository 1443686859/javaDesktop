package leetcode.editor.cn;

public class Leetcode5943 {
     public class ListNode {
     int val;
     ListNode next;
     ListNode() {}
     ListNode(int val) { this.val = val; }
     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 }
    public ListNode deleteMiddle(ListNode head) {
        int length = 0;
        ListNode temp = head;
        while (temp != null) {
            length++;
            temp = temp.next;
        }
        int result = length / 2;
        ListNode tempHead = head;
        ListNode pre = head;
        while (result > 0) {
            result --;
            pre = tempHead;
            tempHead = tempHead.next;
        }
        pre.next = tempHead.next;
        tempHead.next = null;
        return head;
    }
}
