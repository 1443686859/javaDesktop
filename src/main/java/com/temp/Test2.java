package com.temp;

import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * 【题目】
 * 有一堆石头，每块石头的重量都是正整数。
 *
 * 每一回合，从中选出两块 最重的 石头，然后将它们一起粉碎。假设石头的重量分别为 x 和 y，且 x <= y。那么粉碎的可能结果如下：
 *  - 如果 x == y，那么两块石头都会被完全粉碎；
 *   - 如果 x != y，那么重量为 x 的石头将会完全粉碎，而重量为 y 的石头新重量为 y-x。
 *
 * 最后，最多只会剩下一块石头。返回此石头的重量。如果没有石头剩下，就返回 0。
 *
 *
 * 【示例】
 * 输入：[2,7,4,1,8,1]
 * 输出：1
 * 解释：
 * 先选出 7 和 8，得到 1，所以数组转换为 [2,4,1,1,1]，
 * 再选出 2 和 4，得到 2，所以数组转换为 [2,1,1,1]，
 * 接着是 2 和 1，得到 1，所以数组转换为 [1,1,1]，
 * 最后选出 1 和 1，得到 0，最终数组转换为 [1]，这就是最后剩下那块石头的重量。
 */
public class Test2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String result = sc.nextLine();
        int[] array;
        if (result.length() != 0) {
            String[] strings = result.split(",");
            array = new int[strings.length];
            for (int i = 0; i < array.length; i++) {
                array[i] = Integer.valueOf(strings[i].trim());
            }
        } else {
            array = new int[0];
        }
        System.out.println(getMin(array));
    }
    public static int getMin(int[] current) {
        // 优先队列
        PriorityQueue<Integer> queue = new PriorityQueue<>((a, b) -> {
            return b - a;
        });
        for (int i : current) {
            queue.add(i);
        }
        while (!queue.isEmpty()) {
            int max = queue.poll();
            if (!queue.isEmpty()) {
                int min = queue.poll();
                if (max != min) {
                    queue.add(max - min);
                }
            } else {
                return max;
            }
        }
        return 0;
    }
}
