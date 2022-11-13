//给你一个下标从 0 开始长度为 n 的整数数组 buses ，其中 buses[i] 表示第 i 辆公交车的出发时间。同时给你一个下标从 0 开始长度为 
//m 的整数数组 passengers ，其中 passengers[j] 表示第 j 位乘客的到达时间。所有公交车出发的时间互不相同，所有乘客到达的时间也互不相同
//。 
//
// 给你一个整数 capacity ，表示每辆公交车 最多 能容纳的乘客数目。 
//
// 每位乘客都会搭乘下一辆有座位的公交车。如果你在 y 时刻到达，公交在 x 时刻出发，满足 y <= x 且公交没有满，那么你可以搭乘这一辆公交。最早 到达
//的乘客优先上车。 
//
// 返回你可以搭乘公交车的最晚到达公交站时间。你 不能 跟别的乘客同时刻到达。 
//
// 注意：数组 buses 和 passengers 不一定是有序的。 
//
// 
//
// 示例 1： 
//
// 输入：buses = [10,20], passengers = [2,17,18,19], capacity = 2
//输出：16
//解释：
//第 1 辆公交车载着第 1 位乘客。
//第 2 辆公交车载着你和第 2 位乘客。
//注意你不能跟其他乘客同一时间到达，所以你必须在第二位乘客之前到达。 
//
// 示例 2： 
//
// 输入：buses = [20,30,10], passengers = [19,13,26,4,25,11,21], capacity = 2
//输出：20
//解释：
//第 1 辆公交车载着第 4 位乘客。
//第 2 辆公交车载着第 6 位和第 2 位乘客。
//第 3 辆公交车载着第 1 位乘客和你。
// 
//
// 
//
// 提示： 
//
// 
// n == buses.length 
// m == passengers.length 
// 1 <= n, m, capacity <= 10⁵ 
// 2 <= buses[i], passengers[i] <= 10⁹ 
// buses 中的元素 互不相同 。 
// passengers 中的元素 互不相同 。 
// 
// 👍 9 👎 0

package leetcode.editor.cn; //如果你的算法题是中文的，后缀就是cn，如果是英文的就是en

import java.util.Arrays;

/**
 * @author  YourName
 * @date 2022-07-10 17:55:22
 */
public class TheLatestTimeToCatchABus{
    public static void main(String[] args) {
        Solution solution = new TheLatestTimeToCatchABus().new Solution();
//        [20,30,10]
//[19,13,26,4,25,11,21]
//        2
        System.out.println(solution.latestTimeCatchTheBus(new int[]{2241,1239,4280,5025,4354,1749,6310,7993,8163,9369,342,6387,9147,8985,3055,1406,42,8060,1583,5844,5553,119,8043,7836,4159,5512,9230,1220,1893,9411,8319,862,6689,7209,1305,8958,6658,8909,9351,9070,9586,7175,9251,7514,2850,6390,6355,1551,8513,843,8170,4831,6342,8849,2879,8937,2755,5890,7293,1737,4324,2034,7425,9785,1354,6476,3059,6526,8193,9537,2749,8541,5187,8219,369,8467,8140,8175,7287,2598,415,2306,1781,1555,3388,622,7574,4537,4833,1023,4841,7482,6518,4941,9758,7583,1341,5981,6687,6450}, new int[]{8218,5861,7144,1315,9370,846,7541,6688,6348,3526,1343,8043,6326,8697,1738,8306,7292,9506,8537,2827,15,3310,1848,1668,8487,9785,3059,7480,5403,8165,6474,2384,8913,1914,9555,6197,4912,502,646,5837,5940,1366,3012,5074,4254,5545,4841,6520,9138,2877,1252,2755,9039,9359,4832,7185,8889,2653,7576,1512,7863,9712,2102,1239,329,1750,4787,2280,5012,7486,6662,411,6368,8098,6481,1557,8161,8449,1553,9349,9232,4284,24560,72,7276,8045,906,8942,7405,7710,8176,8172,6388,1135,6638,4325,356,9216,8959,4507,6406}, 5));
   }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int latestTimeCatchTheBus(int[] buses, int[] passengers, int capacity) {
        Arrays.sort(buses);
        Arrays.sort(passengers);
        int startIndex = 0;
        boolean isAll = false;
        for (int i = 0; i < buses.length; i++) {
            isAll = false;
            if (startIndex >= passengers.length || passengers[startIndex] > buses[i]) {
                continue;
            }
            int nextIndex = 0;
            if (startIndex + capacity - 1 >= passengers.length) {
                nextIndex = passengers.length - 1;
            } else {
                isAll = true;
                nextIndex = startIndex + capacity - 1;
            }
            if (passengers[nextIndex] > buses[i]) {
                while (passengers[nextIndex] > buses[i]) {
                    nextIndex --;
                    isAll = false;
                }
            }
            startIndex = nextIndex + 1;
        }
        if (!isAll) {
            int max = 0;
            if (startIndex >= passengers.length) {
                max = buses[buses.length - 1];
                while (startIndex >= 1 && max == passengers[startIndex - 1]) {
                    max--;
                    startIndex--;
                }
            } else {
                max = Math.min(buses[buses.length - 1], passengers[startIndex]);
                while (startIndex >= 1 && max == passengers[startIndex - 1]) {
                    max -- ;
                    startIndex--;
                }
            }
            return max;
        } else {
            int max = passengers[startIndex - 1];
            while (startIndex >= 1 && max == passengers[startIndex - 1]) {
                max--;
                startIndex --;
            }
            return max;
        }

    }
}
//leetcode submit region end(Prohibit modification and deletion)

}