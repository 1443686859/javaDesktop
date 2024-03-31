package leetcode.editor.cn;

public class Leetcode6298 {

    public boolean makeStringsEqual(String s, String target) {
        int n = s.length();
        if (s.equals(target)) {
            return true;
        }
        int onCount = 0;
        int totalCount = 0;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == target.charAt(i) && s.charAt(i) =='1') {
                return true;
            }
            if (s.charAt(i) != target.charAt(i)) {
                if (s.charAt(i) == '1') {
                    onCount++;
                }
                totalCount++;
            }
        }
        if (onCount != 0 && totalCount - onCount != 0) {
            return true;
        }
        return false;
    }

}
