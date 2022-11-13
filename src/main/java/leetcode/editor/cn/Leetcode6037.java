package leetcode.editor.cn;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Leetcode6037 {
    public static void main(String[] args) {
        Leetcode6037 leetcode6037 = new Leetcode6037();
        System.out.println(leetcode6037.largestInteger(65875));
    }
    public int largestInteger(int num) {
        int[] count = new int[10];
        Deque<Integer> list = new ArrayDeque<>();
        while (num != 0) {
            int current = num % 10;
            count[current]++;
            list.offerFirst(current);
            num /= 10;
        }
        int result = 0;
        int size = list.size();
        for (int i = 0; i < size; i++) {
            int temp = list.pop();
            int current = temp;
            for (int j = 9; j >= 0; j--) {
                if ((j & 1) == (temp & 1) && count[j] > 0) {
                    current = j;
                    break;
                }
            }
            count[current]--;
            result = result * 10 + current;
        }
        return result;
    }
}
