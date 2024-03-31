package leetcode.editor.cn;

public class Leetcode6307 {
    public int passThePillow(int n, int time) {
        int start = 1;
        boolean change = false;
        while (time != 0) {
            if (!change) {
                start++;
            } else {
                start--;
            }

            if (start == n) {
                change = true;
            } else if (start == 1) {
                change = false;
            }
           time--;

        }
        return start;
    }
}
