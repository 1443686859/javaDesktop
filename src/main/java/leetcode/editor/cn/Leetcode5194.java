package leetcode.editor.cn;

public class Leetcode5194 {
    public int minMoves(int target, int maxDoubles) {
        int count = 0;
        while (target != 1) {
            if (maxDoubles == 0) {
                count += target - 1;
                break;
            }
            if (target % 2 == 1) {
                target--;
            } else {
                target = target / 2;
                maxDoubles--;
            }
            count ++;
        }
        return count;
    }
}
