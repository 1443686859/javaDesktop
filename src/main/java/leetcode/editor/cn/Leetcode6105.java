package leetcode.editor.cn;

public class Leetcode6105 {
    public static void main(String[] args) {
        Leetcode6105 leetcode6105 = new Leetcode6105();
        System.out.println(leetcode6105.maximumXOR(new int[]{1,2,3,9,2}));
    }
    public int maximumXOR(int[] nums) {
        int[] count = new int[32];
        int max = 0;
        for (int i : nums) {
            int index = 0;
            while (i != 0) {
                if ((i & 1) != 0) {
                    count[index]++;
                }
                index++;
                i>>= 1;
            }
            max = Math.max(max, index - 1);
        }
        int result = 0;
        for (int i = max ; i >= 0; i--) {
            result<<=1;
            if ((count[i] & 1) == 1) {
                result++;
            } else {
                if (count[i] >= 2) {
                    result++;
                    continue;
                }
                int left = max;
                int right = i;
                boolean one = false;
                for (int j = left ; j < right; j++) {
                    if ((count[j] >= 3 && (count[j] & 1) !=0)|| (count[j] >= 2 && (count[j] & 1) == 0)) {
                        one = true;
                        break;
                    }
                }
                if (one) {
                    result++;
                }
            }
        }
        return result;
    }
}
