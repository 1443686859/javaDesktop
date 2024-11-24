//给你一个链表，两两交换其中相邻的节点，并返回交换后链表的头节点。你必须在不修改节点内部的值的情况下完成本题（即，只能进行节点交换）。 
//
// 
//
// 示例 1： 
// 
// 
//输入：head = [1,2,3,4]
//输出：[2,1,4,3]
// 
//
// 示例 2： 
//
// 
//输入：head = []
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：head = [1]
//输出：[1]
// 
//
// 
//
// 提示： 
//
// 
// 链表中节点的数目在范围 [0, 100] 内 
// 0 <= Node.val <= 100 
// 
//
// Related Topics 递归 链表 👍 1922 👎 0

package leetcode.editor.cn; //如果你的算法题是中文的，后缀就是cn，如果是英文的就是en

import java.util.List;

/**
 * @author  YourName
 * @date 2023-08-06 10:05:01
 */
public class SwapNodesInPairs{
    public static void main(String[] args) {
        Solution solution = new SwapNodesInPairs().new Solution();
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
    public ListNode swapPairs(ListNode head) {
        ListNode pre = new ListNode();
        ListNode result = pre;
        pre.next = head;
        ListNode mid = head;
        ListNode after = null;
        if (mid == null) {
            return null;
        }
        after = mid.next;
        while (after != null) {
            pre.next = after;
            mid.next = after.next;
            after.next = mid;
            pre = pre.next.next;
            if (pre == null) {
                break;
            }
            mid = pre.next;
            if (mid == null) {
                break;
            }
            after = mid.next;
        }
        return result.next;
    }
    public String finalString(String s) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != 'i') {
                result.append(s.charAt(i) + "");
            } else {
                result = result.reverse();
            }
        }
        return result.toString();
    }
    public boolean canSplitArray(List<Integer> nums, int m) {
        int n = nums.size();
        int index = 0;
        int[] sum = new int[n + 1];
        for (int i : nums) {
            sum[index + 1] = sum[index] + i;
        }
        boolean result = true;
        while (result) {

            result = false;
        }
        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}