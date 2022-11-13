package leetcode.editor.cn;

import java.util.Arrays;

public class Leetcode6010 {
    public static void main(String[] args) {
        Leetcode6010 leetcode6010 = new Leetcode6010();
        System.out.println(leetcode6010.minimumTime(new int[]{10000}, 10000000));
    }
    public long minimumTime(int[] time, int totalTrips) {
        long max = 0;
        for (int i = 0; i < time.length; i++) {
            max = Math.max(max, (long)(totalTrips) * time[i]);
        }
        long l = 1;
        long r = max;
        while (l <= r) {
            long mid = (l + r) / 2;
            if (check(time, mid, totalTrips)) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return r + 1;

    }
    public boolean check(int[] time, long currentTime, int totalTrips) {
        int currentResult = 0;
        for (int i = 0; i < time.length; i ++) {
            currentResult += currentTime / time[i];
            if (currentResult >= totalTrips) {
                return true;
            }
        }
        return false;
    }
}
