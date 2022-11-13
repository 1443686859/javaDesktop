package leetcode.editor.cn;

public class Leetcode6013 {
       public class ListNode {
       int val;
       ListNode next;
       ListNode() {}
       ListNode(int val) { this.val = val; }
       ListNode(int val, ListNode next) { this.val = val; this.next = next; }
   }
    public ListNode mergeNodes(ListNode head) {
           ListNode temp = head;
           ListNode totalResult = new ListNode();
           ListNode totalTemp = totalResult;
        while (temp != null) {
            ListNode current = temp.next;
            int val = 0;
            ListNode result = new ListNode();
            while (current != null && current.val != 0) {
                val += current.val;
                current = current.next;
            }
            temp = current;
            result.val = val;
            if (val != 0) {
                totalResult.next = result;
                totalResult = result;
            }

        }
        return totalTemp.next;
    }
}
