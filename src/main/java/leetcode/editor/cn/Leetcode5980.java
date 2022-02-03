package leetcode.editor.cn;

public class Leetcode5980 {
    public static void main(String[] args) {
        Leetcode5980 soultion = new Leetcode5980();
        System.out.println(soultion.divideString("abcdefghi", 3, 'x'));
    }
    public String[] divideString(String s, int k, char fill) {
        int n = s.length();
        int count = n / k + (n % k > 0 ? 1 : 0);
        String[] result = new String[count];
        for (int i = 0; i < count; i++) {
            if (i != count - 1) {
                result[i] = s.substring(i * k,  (i + 1) * k);
            } else {
                result[i] = s.substring(i * k);
                int length = k - n % k;
                if (length == k) {
                    continue;
                }
                for (int j = 0; j < length; j++) {
                    result[i] += fill;
                }
            }
        }
        return result;
    }
}
