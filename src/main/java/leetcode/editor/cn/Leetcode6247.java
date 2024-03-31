package leetcode.editor.cn;

import java.util.ArrayDeque;
import java.util.Deque;

public class Leetcode6247 {
    public ListNode removeNodes(ListNode head) {
        Deque<ListNode> deque = new ArrayDeque<>();
        ListNode temp = head;
        while (temp != null) {
            while (!deque.isEmpty() && deque.peek().val < temp.val) {
                deque.poll();
            }
            deque.push(temp);
            temp = temp.next;
        }
        ListNode result = null;
        while (!deque.isEmpty()) {
            ListNode newListNode = deque.poll();
            newListNode.next = result;
            result = newListNode;
        }
        return result;
    }
}


 class ListNode {
    int val;
    ListNode next;
   ListNode() {}
    ListNode(int val) { this.val = val; }
  ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 }
