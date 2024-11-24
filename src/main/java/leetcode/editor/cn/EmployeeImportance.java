/**
你有一个保存员工信息的数据结构，它包含了员工唯一的 id ，重要度和直系下属的 id 。 

 给定一个员工数组 employees，其中： 

 
 employees[i].id 是第 i 个员工的 ID。 
 employees[i].importance 是第 i 个员工的重要度。 
 employees[i].subordinates 是第 i 名员工的直接下属的 ID 列表。 
 

 给定一个整数 id 表示一个员工的 ID，返回这个员工和他所有下属的重要度的 总和。 

 

 示例 1： 

 

 
输入：employees = [[1,5,[2,3]],[2,3,[]],[3,3,[]]], id = 1
输出：11
解释：
员工 1 自身的重要度是 5 ，他有两个直系下属 2 和 3 ，而且 2 和 3 的重要度均为 3 。因此员工 1 的总重要度是 5 + 3 + 3 = 11 
。
 

 

 示例 2： 

 

 
输入：employees = [[1,2,[5]],[5,-3,[]]], id = 5
输出：-3
解释：员工 5 的重要度为 -3 并且没有直接下属。
因此，员工 5 的总重要度为 -3。
 

 

 提示： 

 
 1 <= employees.length <= 2000 
 1 <= employees[i].id <= 2000 
 所有的 employees[i].id 互不相同。 
 -100 <= employees[i].importance <= 100 
 一名员工最多有一名直接领导，并可能有多名下属。 
 employees[i].subordinates 中的 ID 都有效。 
 

 👍 323 👎 0

*/
package leetcode.editor.cn; //如果你的算法题是中文的，后缀就是cn，如果是英文的就是en

import java.util.*;

/**
 * @author  YourName
 * @date 2024-08-26 20:15:43
 */
public class EmployeeImportance{
    public static void main(String[] args) {
        Solution solution = new EmployeeImportance().new Solution();
   }
     class Employee {
         public int id;
         public int importance;
         public List<Integer> subordinates;
     };

   //leetcode submit region begin(Prohibit modification and deletion)
/*
// Definition for Employee.
class Employee {
    public int id;
    public int importance;
    public List<Integer> subordinates;
};
*/

class Solution {
    public int getImportance(List<Employee> employees, int id) {
        Map<Integer, Integer> indexMap = new HashMap<>();
        int index = 0;
        for (Employee e : employees) {
            indexMap.put(e.id, index);
            index++;
        }
//        Deque<Integer> deque = new ArrayDeque<>();
//        deque.add(id);
//        int result = 0;
//        while (!deque.isEmpty()) {
//            int size = deque.size();
//            for (int i = 0; i < size; i++) {
//                Employee current = employees.get(indexMap.get(deque.pollFirst()));
//                result += current.importance;
//                for (int j : current.subordinates) {
//                    deque.addLast(j);
//                }
//            }
//        }
        return dfs(employees, id, indexMap);
    }
    public int dfs(List<Employee> employees, int id, Map<Integer, Integer> indexMap) {
        int index = indexMap.get(id);
        Employee current = employees.get(index);
        int result = current.importance;
        for (int i : current.subordinates) {
            result += dfs(employees, i, indexMap);
        }
        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}