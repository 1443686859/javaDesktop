//给定一个整数数组 asteroids，表示在同一行的行星。 
//
// 对于数组中的每一个元素，其绝对值表示行星的大小，正负表示行星的移动方向（正表示向右移动，负表示向左移动）。每一颗行星以相同的速度移动。 
//
// 找出碰撞后剩下的所有行星。碰撞规则：两个行星相互碰撞，较小的行星会爆炸。如果两颗行星大小相同，则两颗行星都会爆炸。两颗移动方向相同的行星，永远不会发生碰撞
//。 
//
// 
//
// 示例 1： 
//
// 
//输入：asteroids = [5,10,-5]
//输出：[5,10]
//解释：10 和 -5 碰撞后只剩下 10 。 5 和 10 永远不会发生碰撞。 
//
// 示例 2： 
//
// 
//输入：asteroids = [8,-8]
//输出：[]
//解释：8 和 -8 碰撞后，两者都发生爆炸。 
//
// 示例 3： 
//
// 
//输入：asteroids = [10,2,-5]
//输出：[10]
//解释：2 和 -5 发生碰撞后剩下 -5 。10 和 -5 发生碰撞后剩下 10 。 
//
// 
//
// 提示： 
//
// 
// 2 <= asteroids.length <= 10⁴ 
// -1000 <= asteroids[i] <= 1000 
// asteroids[i] != 0 
// 
// Related Topics 栈 数组 👍 238 👎 0

package leetcode.editor.cn; //如果你的算法题是中文的，后缀就是cn，如果是英文的就是en

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @author  YourName
 * @date 2022-05-24 23:07:14
 */
public class AsteroidCollision{
    public static void main(String[] args) {
        Solution solution = new AsteroidCollision().new Solution();
        System.out.println(solution.asteroidCollision(new int[]{1,-2,-2,-2}));
   }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
//    public int[] asteroidCollision(int[] asteroids) {
//        Deque<Integer> stack = new ArrayDeque<>();
//        for (int i : asteroids) {
//            if (stack.isEmpty()) {
//                stack.push(i);
//            } else {
//                boolean isPushed = true;
//                while (i < 0 && !stack.isEmpty() && stack.peek() > 0) {
//                    if (Math.abs(i) < Math.abs(stack.peek())) {
//                        isPushed = false;
//                        break;
//                    } else if (Math.abs(i) == Math.abs(stack.peek())) {
//                        isPushed = false;
//                        stack.pop();
//                        break;
//                    } else {
//                        stack.pop();
//                    }
//                }
//                if (isPushed)
//                stack.push(i);
//            }
//        }
//        int[] result = new int[stack.size()];
//        int index = stack.size() - 1;
//        while (!stack.isEmpty()) {
//            result[index --] = stack.pop();
//        }
//        return result;
//    }
public int[] asteroidCollision(int[] asteroids) {
    List<Integer> currentList = new ArrayList<>();
    for (int i : asteroids) {
        if (i < 0) {
            while (currentList.size() != 0 && i * currentList.get(currentList.size() - 1) < 0 &&  currentList.get(currentList.size() - 1) + i < 0) {
                currentList.remove(currentList.size() - 1);
            }
            if (currentList.size() != 0 && i + currentList.get(currentList.size() - 1) == 0) {
                currentList.remove(currentList.size() - 1);
                continue;
            }
            if (currentList.size() == 0 || currentList.get(currentList.size() - 1) * i > 0) {
                currentList.add(i);
            }

        } else {
            currentList.add(i);
        }
    }
    int[] result = new int[currentList.size()];
    int index = 0 ;
    for (int i : currentList) {
        result[index ++] = i;
    }
    return result;
}
}
//leetcode submit region end(Prohibit modification and deletion)

}