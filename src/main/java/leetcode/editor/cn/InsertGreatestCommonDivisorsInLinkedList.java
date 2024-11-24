//给你一个链表的头 head ，每个结点包含一个整数值。 
//
// 在相邻结点之间，请你插入一个新的结点，结点值为这两个相邻结点值的 最大公约数 。 
//
// 请你返回插入之后的链表。 
//
// 两个数的 最大公约数 是可以被两个数字整除的最大正整数。 
//
// 
//
// 示例 1： 
//
// 
//
// 输入：head = [18,6,10,3]
//输出：[18,6,6,2,10,1,3]
//解释：第一幅图是一开始的链表，第二幅图是插入新结点后的图（蓝色结点为新插入结点）。
//- 18 和 6 的最大公约数为 6 ，插入第一和第二个结点之间。
//- 6 和 10 的最大公约数为 2 ，插入第二和第三个结点之间。
//- 10 和 3 的最大公约数为 1 ，插入第三和第四个结点之间。
//所有相邻结点之间都插入完毕，返回链表。
// 
//
// 示例 2： 
//
// 
//
// 输入：head = [7]
//输出：[7]
//解释：第一幅图是一开始的链表，第二幅图是插入新结点后的图（蓝色结点为新插入结点）。
//没有相邻结点，所以返回初始链表。
// 
//
// 
//
// 提示： 
//
// 
// 链表中结点数目在 [1, 5000] 之间。 
// 1 <= Node.val <= 1000 
// 
//
// Related Topics 链表 数学 数论 👍 16 👎 0

package leetcode.editor.cn; //如果你的算法题是中文的，后缀就是cn，如果是英文的就是en

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.Set;

/**
 * @author  YourName
 * @date 2024-01-06 04:06:12
 */
public class InsertGreatestCommonDivisorsInLinkedList{
    public static void main(String[] args) {
        Solution solution = new InsertGreatestCommonDivisorsInLinkedList().new Solution();
        System.out.println(solution.minimumOperationsToMakeEqual(26,1 ));
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
    public ListNode insertGreatestCommonDivisors(ListNode head) {
        ListNode pre = head;
        ListNode after = pre.next;
        while (after != null) {
            int val = gcd(pre.val, after.val);
            pre.next = new ListNode(val);
            pre.next.next = after;
            pre = after;
            after = after.next;
        }
        return head;
    }

    public int gcd(int pre, int after) {
        if (after == 0) {
            return pre;
        }
        return gcd(after, pre % after);
    }

    public int missingInteger(int[] nums) {
        int[] count = new int[51];
        int max = 1;
        int maxSum = nums[0];
        int n = nums.length;
        int temp = 1;
        count[nums[0]]++;
        boolean isBreak = false;
        for (int i = 1; i < n; i++) {
            if (nums[i] == nums[i - 1] + 1 && !isBreak) {
                temp++;
                if (temp >= max) {
                    max = temp;
                    maxSum = Math.max(maxSum, (max * (2 * nums[i] - max + 1) / 2));
                }
            } else {
                isBreak = true;
                temp = 1;
            }
            count[nums[i]]++;
        }
        for (; maxSum <= 50; maxSum++) {
            if (count[maxSum] == 0) {
                break;
            }
        }
        return maxSum;
    }
    public int minOperations(int[] nums, int k) {
        int[] count = new int[32];
        for (int i = 0; i < nums.length; i++) {
            int current = nums[i];
            for (int j = 0; j < 32; j++) {
                if ((current & (1 << j)) != 0) {
                    count[31 - j]++;
                }
            }
        }
        int[] target = new int[32];
        for (int i = 0; i < 32; i++) {
            if ((k & (1 << i)) != 0) {
                target[31 - i]++;
            }
        }
        int result = 0;
        for (int i = 0; i < 32; i++) {
            if ((count[i] & 1) != (target[i] & 1)) {
                result++;
            }
        }
        return result;
    }
    public int minimumOperationsToMakeEqual(int x, int y) {
        Set<Integer> used = new HashSet<>();
        Deque<Integer> deque = new ArrayDeque<>();
        deque.add(x);
        int count = 0;
        while (!deque.isEmpty()) {
            int size = deque.size();
            for (int i = 0; i < size; i++) {
                int current = deque.pollFirst();
                used.add(current);
                if (current == y) {
                   return count;
                }
                if (current % 11 == 0 && !used.contains(current / 11)) {
                    deque.addLast(current / 11);
                }
                if (current % 5 == 0 && !used.contains(current / 5)) {
                    deque.addLast(current / 5);
                }
                if (!used.contains(current + 1)) {
                    deque.addLast(current + 1);
                }
                if (!used.contains(current - 1)) {
                    deque.addLast(current - 1);
                }
            }
            count++;
        }
        return -1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}