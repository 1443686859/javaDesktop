//将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 
//
// 
//
// 示例 1： 
// 
// 
//输入：l1 = [1,2,4], l2 = [1,3,4]
//输出：[1,1,2,3,4,4]
// 
//
// 示例 2： 
//
// 
//输入：l1 = [], l2 = []
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：l1 = [], l2 = [0]
//输出：[0]
// 
//
// 
//
// 提示： 
//
// 
// 两个链表的节点数目范围是 [0, 50] 
// -100 <= Node.val <= 100 
// l1 和 l2 均按 非递减顺序 排列 
// 
//
// Related Topics 递归 链表 👍 3226 👎 0

package leetcode.editor.cn; //如果你的算法题是中文的，后缀就是cn，如果是英文的就是en

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author  YourName
 * @date 2023-08-05 18:35:19
 */
public class MergeTwoSortedLists{
    public static void main(String[] args) {
        Solution solution = new MergeTwoSortedLists().new Solution();
        System.out.println(solution.minimumSeconds(Arrays.asList(2,1,3,3,2)));
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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode head = new ListNode();
        ListNode result = head;
        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                head.next = list1;
                list1 = list1.next;
                head = head.next;
            } else {
                head.next = list2;
                list2 = list2.next;
                head = head.next;
            }
        }
        while (list1 != null) {
            head.next = list1;
            list1 = list1.next;
            head = head.next;
        }
        while (list2 != null) {
            head.next = list2;
            list2 = list2.next;
            head = head.next;
        }
        return result.next;
    }
    public int minimumSeconds(List<Integer> nums) {
        Map<Integer, int[]> map = new HashMap<>();
        int n = nums.size();
        int result = Integer.MAX_VALUE;
        for (int i = 0; i < 2 * n; i++) {
            int index = i >= n ? i % n : i;
            int current = nums.get(index);
            if (map.containsKey(current)) {
                int[] c = map.get(current);
                int currentResult = (i - c[0]) / 2;
                c[0] = i;
                c[1] = Math.max(c[1], currentResult);
                map.put(current, c);
            } else {
                map.put(current, new int[] {i, -1});
            }
        }
        for (Map.Entry<Integer, int[]> entry : map.entrySet()) {
            result = Math.min(result, entry.getValue()[1]);
        }
        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}