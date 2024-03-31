package leetcode.editor.cn;

public class Leetcode6266 {
    public static void main(String[] args) {
        Leetcode6266 leetcode6266 = new Leetcode6266();
        System.out.println(leetcode6266.smallestValue(4));
    }
    public int smallestValue(int n) {
        int result = n;
        int currentResult = n;
        while (currentResult == result) {
            int tempResult = 0;
            for (int i = 2; i * i <= currentResult; i++) {
                while (currentResult % i == 0) {
                    tempResult += i;
                    currentResult /= i;
                }
            }
            if (currentResult != 1) {
                tempResult += currentResult;
            }
            if (currentResult == result || tempResult == result) {
                break;
            } else {
                currentResult = tempResult;
                result = tempResult;
            }
        }
        return result;
    }
}
