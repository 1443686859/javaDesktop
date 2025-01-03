//给你一个在 XY 平面上的 width x height 的网格图，左下角 的格子为 (0, 0) ，右上角 的格子为 (width - 1, 
//height - 1) 。网格图中相邻格子为四个基本方向之一（"North"，"East"，"South" 和 "West"）。一个机器人 初始 在格子 (0, 0) ，方
//向为 "East" 。 
//
// 机器人可以根据指令移动指定的 步数 。每一步，它可以执行以下操作。 
//
// 
// 沿着当前方向尝试 往前一步 。 
// 如果机器人下一步将到达的格子 超出了边界 ，机器人会 逆时针 转 90 度，然后再尝试往前一步。 
// 
//
// 如果机器人完成了指令要求的移动步数，它将停止移动并等待下一个指令。 
//
// 请你实现 Robot 类： 
//
// 
// Robot(int width, int height) 初始化一个 width x height 的网格图，机器人初始在 (0, 0) ，方向朝 
//"East" 。 
// void move(int num) 给机器人下达前进 num 步的指令。 
// int[] getPos() 返回机器人当前所处的格子位置，用一个长度为 2 的数组 [x, y] 表示。 
// String getDir() 返回当前机器人的朝向，为 "North" ，"East" ，"South" 或者 "West" 。 
// 
//
// 
//
// 示例 1： 
//
// 
//
// 输入：
//["Robot", "move", "move", "getPos", "getDir", "move", "move", "move", 
//"getPos", "getDir"]
//[[6, 3], [2], [2], [], [], [2], [1], [4], [], []]
//输出：
//[null, null, null, [4, 0], "East", null, null, null, [1, 2], "West"]
//
//解释：
//Robot robot = new Robot(6, 3); // 初始化网格图，机器人在 (0, 0) ，朝东。
//robot.move(2);  // 机器人朝东移动 2 步，到达 (2, 0) ，并朝东。
//robot.move(2);  // 机器人朝东移动 2 步，到达 (4, 0) ，并朝东。
//robot.getPos(); // 返回 [4, 0]
//robot.getDir(); // 返回 "East"
//robot.move(2);  // 朝东移动 1 步到达 (5, 0) ，并朝东。
//                // 下一步继续往东移动将出界，所以逆时针转变方向朝北。
//                // 然后，往北移动 1 步到达 (5, 1) ，并朝北。
//robot.move(1);  // 朝北移动 1 步到达 (5, 2) ，并朝 北 （不是朝西）。
//robot.move(4);  // 下一步继续往北移动将出界，所以逆时针转变方向朝西。
//                // 然后，移动 4 步到 (1, 2) ，并朝西。
//robot.getPos(); // 返回 [1, 2]
//robot.getDir(); // 返回 "West"
//
// 
//
// 
//
// 提示： 
//
// 
// 2 <= width, height <= 100 
// 1 <= num <= 10⁵ 
// move ，getPos 和 getDir 总共 调用次数不超过 10⁴ 次。 
// 
//
// Related Topics 设计 模拟 👍 20 👎 0

package leetcode.editor.cn; //如果你的算法题是中文的，后缀就是cn，如果是英文的就是en
 /**
 * @author  YourName
 * @date 2023-01-19 22:16:22
 */
public class WalkingRobotSimulationIi{
    public static void main(String[] args) {
        Robot robot = new Robot(97,98);
        robot.step(66392);
        robot.step(83376);
        robot.step(71796);
        robot.step(57514);
        robot.step(36284);
        robot.step(69866);
        robot.step(31652);
        robot.step(32038);
        System.out.println();
   }
//leetcode submit region begin(Prohibit modification and deletion)
static class Robot {
        int width;
        int height;
        int x;
        int y;
        int dir;
        String[] direction = new String[]{ "East" ,"North" ,"South" , "West" };
        int[] change = new int[]{1,3,0,2};
    public Robot(int width, int height) {
        x = y = 0;
        this.width = width;
        this.height = height;
        dir = 0;
    }
    
    public void step(int num) {
        boolean isZero = num == 0 ? false : true;
        num %= 2*(width + height - 2);
        if (isZero && num == 0 && x == 0 && y == 0) {
            dir = 2;
        }
        while (num != 0) {
            if (dir == 0) {
                if (x + num <= width - 1) {
                    x += num;
                    num = 0;
                } else {
                    num -= width - 1 -x;
                    x = width - 1;
                    dir = change[dir];
                }
            }
            if (dir == 1) {
                if (y + num <= height - 1) {
                    y += num;
                    num = 0;
                } else {
                    num -= height - 1 -y;
                    y = height - 1;
                    dir = change[dir];
                }
            }
            if (dir == 2) {
                if (y - num >= 0) {
                    y -= num;
                    num = 0;
                } else {
                    num -= y;
                    y = 0;
                    dir = change[dir];
                }
            }
            if (dir == 3) {
                if (x - num >= 0) {
                    x -= num;
                    num = 0;
                } else {
                    num -= x;
                    x = 0;
                    dir = change[dir];
                }
            }
        }
    }
    
    public int[] getPos() {
        return new int[]{x, y};
    }
    
    public String getDir() {
        return direction[dir];
    }
}

/**
 * Your Robot object will be instantiated and called as such:
 * Robot obj = new Robot(width, height);
 * obj.step(num);
 * int[] param_2 = obj.getPos();
 * String param_3 = obj.getDir();
 */
//leetcode submit region end(Prohibit modification and deletion)

}