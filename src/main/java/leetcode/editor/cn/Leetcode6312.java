package leetcode.editor.cn;

public class Leetcode6312 {
    public static void main(String[] args) {
        Leetcode6312 leetcode6312 = new Leetcode6312();
        System.out.println(leetcode6312.splitNum(4325));
    }
    public int splitNum(int num) {
        int[] count = new int[10];
        while (num != 0) {
            count[num % 10]++;
            num /= 10;
        }
        int pre = 0;
        int after = 0;
        int index = 0;
        int current = 0;
        while (index < count.length) {
            if (count[index] != 0) {
                if ((current & 1) == 0) {
                    pre = pre * 10 + index;
                } else {
                    after = after * 10 + index;
                }
                current++;
                count[index]--;
            } else {
                index++;
            }


        }
        return pre + after;
    }
}
