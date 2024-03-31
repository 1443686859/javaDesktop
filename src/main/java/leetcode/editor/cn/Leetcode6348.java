package leetcode.editor.cn;

import java.util.PriorityQueue;

public class Leetcode6348 {
    public static void main(String[] args) {
        Leetcode6348 leetcode6348 = new Leetcode6348();
        System.out.println(leetcode6348.pickGifts(new int[]{25,64,9,4,100}, 4));
    }
    public long pickGifts(int[] gifts, int k) {
        long sum = 0;
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>((b, a) -> a - b);
        for (int i : gifts) {
            sum += i;
            priorityQueue.add(i);
        }
        for (int i = 0; i < k; i++) {
            int current = priorityQueue.poll();
            int rest = (int)Math.sqrt(current);
            sum -= (current - rest);
            priorityQueue.add(rest);
        }
        return sum;
    }
}
