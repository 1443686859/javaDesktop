//机器人在一个无限大小的 XY 网格平面上行走，从点 (0, 0) 处开始出发，面向北方。该机器人可以接收以下三种类型的命令 commands ：
//
// 
// -2 ：向左转 90 度 
// -1 ：向右转 90 度 
// 1 <= x <= 9 ：向前移动 x 个单位长度 
// 
//
// 在网格上有一些格子被视为障碍物 obstacles 。第 i 个障碍物位于网格点 obstacles[i] = (xi, yi) 。 
//
// 机器人无法走到障碍物上，它将会停留在障碍物的前一个网格方块上，但仍然可以继续尝试进行该路线的其余部分。 
//
// 返回从原点到机器人所有经过的路径点（坐标为整数）的最大欧式距离的平方。（即，如果距离为 5 ，则返回 25 ） 
//
// 
// 
// 
// 
// 
// 
// 
// 
// 
// 
// 
//
// 
// 注意： 
// 
//
// 
// 北表示 +Y 方向。 
// 东表示 +X 方向。 
// 南表示 -Y 方向。 
// 西表示 -X 方向。 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：commands = [4,-1,3], obstacles = []
//输出：25
//解释：
//机器人开始位于 (0, 0)：
//1. 向北移动 4 个单位，到达 (0, 4)
//2. 右转
//3. 向东移动 3 个单位，到达 (3, 4)
//距离原点最远的是 (3, 4) ，距离为 3² + 4² = 25 
//
// 示例 2： 
//
// 
//输入：commands = [4,-1,4,-2,4], obstacles = [[2,4]]
//输出：65
//解释：机器人开始位于 (0, 0)：
//1. 向北移动 4 个单位，到达 (0, 4)
//2. 右转
//3. 向东移动 1 个单位，然后被位于 (2, 4) 的障碍物阻挡，机器人停在 (1, 4)
//4. 左转
//5. 向北走 4 个单位，到达 (1, 8)
//距离原点最远的是 (1, 8) ，距离为 1² + 8² = 65 
//
// 
//
// 提示： 
//
// 
// 1 <= commands.length <= 10⁴ 
// commands[i] is one of the values in the list [-2,-1,1,2,3,4,5,6,7,8,9]. 
// 0 <= obstacles.length <= 10⁴ 
// -3 * 10⁴ <= xi, yi <= 3 * 10⁴ 
// 答案保证小于 2³¹ 
// 
//
// Related Topics 数组 模拟 👍 220 👎 0

package leetcode.editor.cn; //如果你的算法题是中文的，后缀就是cn，如果是英文的就是en

import java.util.Arrays;

/**
 * @author  YourName
 * @date 2023-07-19 20:34:59
 */
public class WalkingRobotSimulation{
    public static void main(String[] args) {
        Solution solution = new WalkingRobotSimulation().new Solution();
        System.out.println(solution.robotSim(new int[]{4,-1,4,-2,4}, new int[][]{{2,4}}));
   }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
        int[][] directions = new int[][]{
                {0,1},{-1, 0}, {0, -1},{1, 0}
        };
    public int robotSim(int[] commands, int[][] obstacles) {
        Arrays.sort(obstacles, (a, b) -> {
            if (a[0] != b[0]) {
                return a[0] -b[0];
            } else {
                return a[1] - b[1];
            }
        });
        int result = 0;
        int count2 = 0;
        int count1 = 0;
        int direction = 0;
        int[] start = new int[2];
        for (int i = 0; i < commands.length; i++) {
            if (commands[i] <= 0) {
                if (commands[i] == - 1) {
                    count1 ++;
                }
                if (commands[i] == -2) {
                    count2 ++;
                }
                direction = getDirection(count2, count1);
            } else {
                for (int j = 0; j < commands[i]; j++) {
                    if (search(obstacles, new int[]{start[0] + directions[direction][0], start[1] + directions[direction][1]}) == -1) {
                        start[0] += directions[direction][0];
                        start[1] += directions[direction][1];
                        result = Math.max(result, start[0] * start[0] + start[1] * start[1]);
                    } else {
                        break;
                    }
                }
            }
        }
        return result;
    }
    public int search(int[][] array, int[] target) {
            if (array.length == 0) {
                return -1;
            }
            int left = 0;
            int right = array.length - 1;
            while (left <= right) {
                int mid = (left + right) / 2;
                if (array[mid][0] == target[0] && array[mid][1] == target[1]) {
                    return mid;
                } else if (array[mid][0] > target[0] || array[mid][0] == target[0] && array[mid][1] > target[1]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
            return -1;
    }
    public int getDirection(int count2, int count1) {
        count2 %= 4;
        count1 %= 4;
        if (count2 == count1) {
            return 0;
        }
        if (count2 > count1) {
            return count2 - count1;
        }
        return 4 - (count1 - count2);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}