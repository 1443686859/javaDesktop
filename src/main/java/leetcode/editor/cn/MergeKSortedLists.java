//给你一个链表数组，每个链表都已经按升序排列。 
//
// 请你将所有链表合并到一个升序链表中，返回合并后的链表。 
//
// 
//
// 示例 1： 
//
// 输入：lists = [[1,4,5],[1,3,4],[2,6]]
//输出：[1,1,2,3,4,4,5,6]
//解释：链表数组如下：
//[
//  1->4->5,
//  1->3->4,
//  2->6
//]
//将它们合并到一个有序链表中得到。
//1->1->2->3->4->4->5->6
// 
//
// 示例 2： 
//
// 输入：lists = []
//输出：[]
// 
//
// 示例 3： 
//
// 输入：lists = [[]]
//输出：[]
// 
//
// 
//
// 提示： 
//
// 
// k == lists.length 
// 0 <= k <= 10^4 
// 0 <= lists[i].length <= 500 
// -10^4 <= lists[i][j] <= 10^4 
// lists[i] 按 升序 排列 
// lists[i].length 的总和不超过 10^4 
// 
//
// Related Topics 链表 分治 堆（优先队列） 归并排序 👍 2562 👎 0

package leetcode.editor.cn; //如果你的算法题是中文的，后缀就是cn，如果是英文的就是en

import java.util.*;

/**
 * @author  YourName
 * @date 2023-08-12 15:05:51
 */
public class MergeKSortedLists{
    public static void main(String[] args) {
        Solution solution = new MergeKSortedLists().new Solution();
        ListNode temp = new ListNode(1);
        temp.next = new ListNode(4);
        temp.next.next = new ListNode(5);
        ListNode current = new ListNode(1);
        current.next = new ListNode(3);
        current.next.next = new ListNode(4);
        System.out.println(solution.mergeKLists(new ListNode[]{temp, current}));
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
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) {
            return null;
        }
        return merge(lists, 0, lists.length - 1);
    }
    public ListNode merge(ListNode[] lists, int left, int right) {
        if (left == right) {
            return lists[left];
        }
        int mid = (left + right) / 2;
        ListNode leftResult = merge(lists, left , mid);
        ListNode rightResult = merge(lists, mid + 1, right);
        ListNode result = new ListNode();
        ListNode temp = result;
        while (leftResult != null && rightResult != null) {
            if (leftResult.val <= rightResult.val) {
                temp.next = leftResult;
                leftResult = leftResult.next;
            } else {
                temp.next = rightResult;
                rightResult = rightResult.next;
            }
            temp = temp.next;


        }
        if (leftResult != null) {
            temp.next = leftResult;
        }
        if (rightResult != null) {
            temp.next = rightResult;
        }
        return result.next;
    }

    public ListNode doubleIt(ListNode head) {
        ListNode result = new ListNode();
        result.next = head;
        ArrayDeque<ListNode> deque = new ArrayDeque<>();
        while (head != null) {
            deque.add(head);
            head = head.next;
        }
        int inc = 0;
        while (deque.size() != 0) {
            ListNode current = deque.pollLast();
            current.val = 2 * current.val + inc;
            inc = current.val / 10;
            current.val = current.val % 10;
        }
        if (inc != 0) {
            result.val = inc;
            return result;
        }
        return result.next;

    }
    public int minAbsoluteDifference(List<Integer> nums, int x) {
        TreeSet<Integer> set = new TreeSet<>();
        int result = Integer.MAX_VALUE;
        for (int i = x; i < nums.size(); i ++) {
            set.add(nums.get(i - x));
            Integer high = set.ceiling(nums.get(i));
            Integer low = set.floor(nums.get(i));
            if (high != null) {
                result = Math.min(result, Math.abs(nums.get(i) - high));
            }
            if (low != null) {
                result = Math.min(result, Math.abs(nums.get(i) - low));
            }
        }
        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}