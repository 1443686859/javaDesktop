//给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。 
//
// 请你将两个数相加，并以相同形式返回一个表示和的链表。 
//
// 你可以假设除了数字 0 之外，这两个数都不会以 0 开头。 
//
// 
//
// 示例 1： 
// 
// 
//输入：l1 = [2,4,3], l2 = [5,6,4]
//输出：[7,0,8]
//解释：342 + 465 = 807.
// 
//
// 示例 2： 
//
// 
//输入：l1 = [0], l2 = [0]
//输出：[0]
// 
//
// 示例 3： 
//
// 
//输入：l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
//输出：[8,9,9,9,0,0,0,1]
// 
//
// 
//
// 提示： 
//
// 
// 每个链表中的节点数在范围 [1, 100] 内 
// 0 <= Node.val <= 9 
// 题目数据保证列表表示的数字不含前导零 
// 
//
// Related Topics 递归 链表 数学 👍 9696 👎 0

package leetcode.editor.cn; //如果你的算法题是中文的，后缀就是cn，如果是英文的就是en
 /**
 * @author  YourName
 * @date 2023-07-02 00:07:00
 */
public class AddTwoNumbers{
    public static void main(String[] args) {
        Solution solution = new AddTwoNumbers().new Solution();
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
        int inc = 0;
        ListNode pre = new ListNode();
        ListNode ans = new ListNode();
        ListNode result = new ListNode();
        ans.next = result;
        while (l1 != null && l2 != null) {
            result.val = l1.val + l2.val + inc;
            inc = result.val / 10;
            result.val = result.val % 10;
            l1 = l1.next;
            l2 = l2.next;
            result.next = new ListNode();
            pre = result;
            result = result.next;
        }
        while (l1 != null) {
            result.val = l1.val + inc;
            inc = result.val / 10;
            result.val = result.val % 10;
            result.next = new ListNode();
            pre = result;
            result = result.next;
            l1 = l1.next;
        }
        while (l2 != null) {
            result.val = l2.val + inc;
            inc = result.val / 10;
            result.val = result.val % 10;
            result.next = new ListNode();
            pre = result;
            result = result.next;
            l2 = l2.next;
        }
        if (inc != 0) {
            result.val = inc;
            result.next = new ListNode();
            pre = result;
            result = result.next;
        }
        if (result.val == 0) {
            pre.next = null;
        }

        return ans.next;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}