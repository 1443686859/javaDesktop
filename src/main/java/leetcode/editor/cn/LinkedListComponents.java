//给定链表头结点 head，该链表上的每个结点都有一个 唯一的整型值 。同时给定列表 nums，该列表是上述链表中整型值的一个子集。 
//
// 返回列表 nums 中组件的个数，这里对组件的定义为：链表中一段最长连续结点的值（该值必须在列表 nums 中）构成的集合。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入: head = [0,1,2,3], nums = [0,1,3]
//输出: 2
//解释: 链表中,0 和 1 是相连接的，且 nums 中不包含 2，所以 [0, 1] 是 nums 的一个组件，同理 [3] 也是一个组件，故返回 2。 
//
//
// 示例 2： 
//
// 
//
// 
//输入: head = [0,1,2,3,4], nums = [0,3,1,4]
//输出: 2
//解释: 链表中，0 和 1 是相连接的，3 和 4 是相连接的，所以 [0, 1] 和 [3, 4] 是两个组件，故返回 2。 
//
// 
//
// 提示： 
//
// 
// 链表中节点数为n 
// 1 <= n <= 10⁴ 
// 0 <= Node.val < n 
// Node.val 中所有值 不同 
// 1 <= nums.length <= n 
// 0 <= nums[i] < n 
// nums 中所有值 不同 
// 
//
// Related Topics 数组 哈希表 链表 👍 162 👎 0

package leetcode.editor.cn; //如果你的算法题是中文的，后缀就是cn，如果是英文的就是en

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * @author  YourName
 * @date 2022-10-12 19:05:11
 */
public class LinkedListComponents{
    public static void main(String[] args) {
        Solution solution = new LinkedListComponents().new Solution();
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
 public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
class Solution {
    public int numComponents(ListNode head, int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int i : nums) {
            set.add(i);
        }
        int result = 0;
        int count = 0;
        while (head != null) {
            if (set.contains(head.val)) {
                count++;
            } else {
                if (count != 0) {
                    result++;
                }
                count = 0;
            }
            head = head.next;
        }
        if (count != 0) {
            result++;
        }
        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}