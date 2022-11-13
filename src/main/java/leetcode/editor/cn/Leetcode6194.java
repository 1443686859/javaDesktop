package leetcode.editor.cn;

public class Leetcode6194 {
    public static void main(String[] args) {
        Leetcode6194 leetcode6194 = new Leetcode6194();
        System.out.println(leetcode6194.minimizeXor(1,12));
    }
    public int minimizeXor(int num1, int num2) {
        int[] num1A = new int[32];
        int[] num2A = new int[32];
        int temp1 = num1;
        int temp2 = num2;
        int count1 = 0;
        int count2 = 0;
        int index1 = 0;
        int index2 = 0;
        while (temp1 != 0) {
            if ((temp1 & 1) != 0) {
                count1++;
                num1A[index1] = 1;
            }
            index1 ++;
            temp1 >>= 1;
        }
        while (temp2 != 0) {
            if ((temp2 & 1) != 0) {
                count2++;
                num2A[index2] = 1;
            }
            index2 ++;
            temp2 >>= 1;
        }
        if (count1 == count2) {
            return num1;
        }
        if (count1 > count2) {
            int diff = count1 - count2;
            int startIndex = 0;
            int result = num1;
            while (startIndex < 32) {
                if (num1A[startIndex] == 1) {
                    result &= ~(1 << startIndex);
                    diff--;
                }
                if (diff == 0) {
                    break;
                }
                startIndex++;
            }
            return result;
        } else {
            int diff = count2 - count1;
            int startIndex = 0;
            int result = num1;
            while (startIndex < 32) {
                if (num1A[startIndex] == 0) {
                    result |= (1 << startIndex);
                    diff--;
                }
                if (diff == 0) {
                    break;
                }
                startIndex++;
            }
            return result;
        }
    }
}
