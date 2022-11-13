package leetcode.editor.cn;

import java.util.PriorityQueue;

public class Leetcode6039 {
    public static void main(String[] args) {
        Leetcode6039 leetcode6039 = new Leetcode6039();
        System.out.println(leetcode6039.maximumProduct(new int[]{24,5,64,53,26,38},
        54));
    }
    public int maximumProduct(int[] nums, int k) {
        long result = 1l;
        int mod = 1000000007;
        PriorityQueue<Integer> current = new PriorityQueue<>();
        for (int i : nums) {
            current.offer(i);
        }
        for (int i = 0; i < k; i++) {
            int now = current.poll();
            current.offer(now + 1);
        }
        for (int i : current) {
            result = result * i;
            result %= mod;
        }
        return (int)result;
    }
}
