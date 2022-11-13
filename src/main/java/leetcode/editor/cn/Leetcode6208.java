package leetcode.editor.cn;

public class Leetcode6208 {
    public int countTime(String time) {
        int result = 1;
        String[] times = time.split(":");
        if (times[0].contains("?")) {
            if (times[0].charAt(0) == '?' && times[0].charAt(1) == '?') {
                result *= 24;
            } else if (times[0].charAt(0) == '?') {
                int i = times[0].charAt(1) - '0';
                if (i >= 4) {
                    result *= 2;
                } else {
                    result *= 3;
                }
            } else if (times[0].charAt(1) == '?') {
                int i = times[0].charAt(0) - '0';
                if (i == 2) {
                    result *= 4;
                } else {
                    result *= 10;
                }
            }
        }
        if (times[1].contains("?")) {
            if (times[1].charAt(0) == '?' && times[1].charAt(1) == '?') {
                result *= 60;
            } else if (times[1].charAt(0) == '?') {
                int i = times[1].charAt(1) - '0';
                result *= 6;
            } else if (times[1].charAt(1) == '?') {
                int i = times[1].charAt(0) - '0';
                result *= 10;
            }
        }
        return result;
    }
}
