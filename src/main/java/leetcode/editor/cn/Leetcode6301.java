package leetcode.editor.cn;

public class Leetcode6301 {
    public static void main(String[] args) {
        Leetcode6301 leetcode6301 = new Leetcode6301();
        System.out.println(leetcode6301.isReachable(671088640 ,939524096));
    }
    public boolean isReachable(int targetX, int targetY) {
        return check(targetX) && check(targetY);
    }
    public boolean check(int targetX) {
        long i = 1;
        while (i < targetX) {
            i *= 2;
        }
        long target = i - targetX;
        if (target == 0) {
            return true;
        }
        i = 1;
        while (i < target) {
            i *= 2;
        }
        return i == target;
    }
}
