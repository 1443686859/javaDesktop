//我们把无限数量 ∞ 的栈排成一行，按从左到右的次序从 0 开始编号。每个栈的的最大容量 capacity 都相同。 
//
// 实现一个叫「餐盘」的类 DinnerPlates： 
//
// 
// DinnerPlates(int capacity) - 给出栈的最大容量 capacity。 
// void push(int val) - 将给出的正整数 val 推入 从左往右第一个 没有满的栈。 
// int pop() - 返回 从右往左第一个 非空栈顶部的值，并将其从栈中删除；如果所有的栈都是空的，请返回 -1。 
// int popAtStack(int index) - 返回编号 index 的栈顶部的值，并将其从栈中删除；如果编号 index 的栈是空的，请返回 -
//1。 
// 
//
// 
//
// 示例： 
//
// 输入： 
//["DinnerPlates","push","push","push","push","push","popAtStack","push","push",
//"popAtStack","popAtStack","pop","pop","pop","pop","pop"]
//[[2],[1],[2],[3],[4],[5],[0],[20],[21],[0],[2],[],[],[],[],[]]
//输出：
//[null,null,null,null,null,null,2,null,null,20,21,5,4,3,1,-1]
//
//解释：
//DinnerPlates D = DinnerPlates(2);  // 初始化，栈最大容量 capacity = 2
//D.push(1);
//D.push(2);
//D.push(3);
//D.push(4);
//D.push(5);         // 栈的现状为：    2  4
//                                    1  3  5
//                                    ﹈ ﹈ ﹈
//D.popAtStack(0);   // 返回 2。栈的现状为：      4
//                                          1  3  5
//                                          ﹈ ﹈ ﹈
//D.push(20);        // 栈的现状为：  20  4
//                                   1  3  5
//                                   ﹈ ﹈ ﹈
//D.push(21);        // 栈的现状为：  20  4 21
//                                   1  3  5
//                                   ﹈ ﹈ ﹈
//D.popAtStack(0);   // 返回 20。栈的现状为：       4 21
//                                            1  3  5
//                                            ﹈ ﹈ ﹈
//D.popAtStack(2);   // 返回 21。栈的现状为：       4
//                                            1  3  5
//                                            ﹈ ﹈ ﹈ 
//D.pop()            // 返回 5。栈的现状为：        4
//                                            1  3 
//                                            ﹈ ﹈  
//D.pop()            // 返回 4。栈的现状为：    1  3 
//                                           ﹈ ﹈   
//D.pop()            // 返回 3。栈的现状为：    1 
//                                           ﹈   
//D.pop()            // 返回 1。现在没有栈。
//D.pop()            // 返回 -1。仍然没有栈。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= capacity <= 20000 
// 1 <= val <= 20000 
// 0 <= index <= 100000 
// 最多会对 push，pop，和 popAtStack 进行 200000 次调用。 
// 
//
// Related Topics 栈 设计 哈希表 堆（优先队列） 👍 91 👎 0

package leetcode.editor.cn; //如果你的算法题是中文的，后缀就是cn，如果是英文的就是en

import java.util.*;

/**
 * @author  YourName
 * @date 2023-04-28 23:06:31
 */
public class DinnerPlateStacks{
    public static void main(String[] args) {
//        DinnerPlates D = new DinnerPlates(2); // 初始化，栈最大容量 capacity = 2//
//        D.push(1); D.push(2); D.push(3); D.push(4); D.push(5);
//        // 栈的现状为： 2 4 1 3 5 ﹈ ﹈ ﹈
//        D.popAtStack(0); // 返回 2。栈的现状为： 4 1 3 5 ﹈ ﹈ ﹈
//        D.push(20); // 栈的现状为： 20 4 1 3 5 ﹈ ﹈ ﹈
//        D.push(21); // 栈的现状为： 20 4 21 1 3 5 ﹈ ﹈ ﹈
//        D.popAtStack(0); // 返回 20。栈的现状为： 4 21 1 3 5 ﹈ ﹈ ﹈
//        D.popAtStack(2); // 返回 21。栈的现状为： 4 1 3 5 ﹈ ﹈ ﹈
//        D.pop(); // 返回 5。栈的现状为： 4 1 3 ﹈ ﹈
//        D.pop(); // 返回 4。栈的现状为： 1 3 ﹈
//        D.pop(); // 返回 3。栈的现状为： 1 ﹈
//        D.pop(); // 返回 1。现在没有栈。
//        D.pop(); // 返回 -1。仍然没有栈。
   }
//leetcode submit region begin(Prohibit modification and deletion)
 class DinnerPlates {
    int capacity;
    List<Deque<Integer>> stack = new ArrayList<>();

    PriorityQueue<Integer> indexList = new PriorityQueue<>();
    public DinnerPlates(int capacity) {
        this.capacity = capacity;
    }
    
    public void push(int val) {
        if (!indexList.isEmpty() && indexList.peek() >= stack.size()) {
            indexList.clear();
        }
        if (!indexList.isEmpty()) {
            int targetIndex = indexList.peek();
            stack.get(targetIndex).push(val);
            if (stack.get(targetIndex).size() == capacity) {
                indexList.poll();
            }
        } else {
            Deque<Integer> current = new ArrayDeque<>();
            current.push(val);
            stack.add(current);
            if (current.size() < capacity) {
                indexList.add(stack.size() - 1);
            }
        }
    }
    
    public int pop() {
        return popAtStack(stack.size() - 1);
    }
    
    public int popAtStack(int index) {
        if (index >= stack.size() || index < 0) {
            return - 1;
        }
        Deque<Integer> current = stack.get(index);
        if (current.isEmpty()) {
            return -1;
        }
        if (current.size() == capacity) {
            // 栈满第一次进站， 维护堆中数据唯一
            indexList.add(index);
        }
        // 先执行删除元素操作, 方便移除末尾元素
        int val = current.pop();
        while (!stack.isEmpty() && stack.get(stack.size() - 1).isEmpty()) {
            stack.remove(stack.size() - 1);
        }
        return val;
    }
}

/**
 * Your DinnerPlates object will be instantiated and called as such:
 * DinnerPlates obj = new DinnerPlates(capacity);
 * obj.push(val);
 * int param_2 = obj.pop();
 * int param_3 = obj.popAtStack(index);
 */
//leetcode submit region end(Prohibit modification and deletion)

}