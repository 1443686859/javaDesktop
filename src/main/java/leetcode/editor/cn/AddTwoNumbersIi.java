//给你两个 非空 链表来代表两个非负整数。数字最高位位于链表开始位置。它们的每个节点只存储一位数字。将这两数相加会返回一个新的链表。 
//
// 你可以假设除了数字 0 之外，这两个数字都不会以零开头。 
//
// 
//
// 示例1： 
//
// 
//
// 
//输入：l1 = [7,2,4,3], l2 = [5,6,4]
//输出：[7,8,0,7]
// 
//
// 示例2： 
//
// 
//输入：l1 = [2,4,3], l2 = [5,6,4]
//输出：[8,0,7]
// 
//
// 示例3： 
//
// 
//输入：l1 = [0], l2 = [0]
//输出：[0]
// 
//
// 
//
// 提示： 
//
// 
// 链表的长度范围为 [1, 100] 
// 0 <= node.val <= 9 
// 输入数据保证链表代表的数字无前导 0 
// 
//
// 
//
// 进阶：如果输入链表不能翻转该如何解决？ 
//
// Related Topics 栈 链表 数学 👍 657 👎 0

package leetcode.editor.cn; //如果你的算法题是中文的，后缀就是cn，如果是英文的就是en

import java.util.*;

/**
 * @author  YourName
 * @date 2023-07-03 20:46:40
 */
public class AddTwoNumbersIi{
    public static void main(String[] args) {
        Solution solution = new AddTwoNumbersIi().new Solution();
        ListNode listNode = new ListNode(2);
        listNode.next = new ListNode(4, new ListNode(3));
        ListNode listNode1 = new ListNode(5);
        listNode1.next = new ListNode(6, new ListNode(4));
        System.out.println(solution.addTwoNumbers(listNode, listNode1));
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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = null;
        ArrayDeque<ListNode> pre = new ArrayDeque<>();
        while (l1 != null) {
            pre.push(l1);
            l1 = l1.next;
        }
        ArrayDeque<ListNode> after = new ArrayDeque<>();
        while (l2 != null) {
            after.push(l2);
            l2 = l2.next;
        }
        int inc = 0;
        while (!pre.isEmpty() && !after.isEmpty()) {
            ListNode listNode1 = pre.poll();
            ListNode listNode2 = after.poll();
            int temp = (listNode2.val + listNode1.val + inc);
            inc = temp / 10;
            listNode1.val = temp % 10;
            listNode1.next = result;
            result = listNode1;
        }
        while (!pre.isEmpty()) {
            ListNode listNode1 = pre.poll();
            int temp = (listNode1.val + inc);
            listNode1.val =  temp % 10;
            inc = temp / 10;
            listNode1.next = result;
            result = listNode1;
        }
        while (!after.isEmpty()) {
            ListNode listNode2 = after.poll();
            int temp = (listNode2.val + inc);
            listNode2.val =  temp % 10;
            inc = temp / 10;
            listNode2.next = result;
            result = listNode2;
        }
        if (inc != 0) {
            ListNode listNode = new ListNode(inc);
            listNode.next = result;
            result = listNode;
        }
        return result;
    }



}
//leetcode submit region end(Prohibit modification and deletion)

}