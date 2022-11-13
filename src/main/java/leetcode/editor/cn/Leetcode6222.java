package leetcode.editor.cn;

public class Leetcode6222 {
    public static void main(String[] args) {
        Leetcode6222 leetcode6222 = new Leetcode6222();
        System.out.println(leetcode6222.makeIntegerBeautiful(8, 2));
    }
    public long makeIntegerBeautiful(long n, int target) {
        int[] number = new int[13];
        int[] sum = new int[13];
        int index = number.length - 1;
        long temp = n;
        while (index >= 0 && temp != 0) {
            number[index--] = (int)(temp % 10);
            temp /= 10;
        }
        if (index == -1) {
            index = 0;
        }
        sum[index] = number[index];
        int targetIndex = -1;
        for (int i = index + 1; i < number.length; i++) {
            sum[i] = sum[i - 1] + number[i];
            if (sum[i] + 1 > target && targetIndex == -1) {
                targetIndex = i;
            }
        }
        if (sum[sum.length - 1] == target) {
            return 0;
        }
        long result = 0;
        targetIndex--;
        if (targetIndex == -1) {
           result = 10;
        }
        for (int i = index; i < number.length; i++) {
            if (i == targetIndex) {
                result = result * 10 + number[i] + 1;
            } else if(i > targetIndex){
                result = result * 10;
            } else {
                result = result * 10 + number[i];
            }

        }
        return result - n;
    }
}
