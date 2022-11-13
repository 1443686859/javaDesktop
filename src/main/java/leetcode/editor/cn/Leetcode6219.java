package leetcode.editor.cn;

public class Leetcode6219 {
    public boolean sumOfNumberAndReverse(int num) {
        for (int i = 0; i <= num; i++) {
            if (i + get(i) == num) {
                return true;
            }
        }
        return false;
    }
    public int get(int i) {
        int tempResult = 0;
        while (i != 0) {
            int current = i % 10;
            tempResult = tempResult
                    * 10 + current;
            i /= 10;
        }
        return tempResult;
    }
}
