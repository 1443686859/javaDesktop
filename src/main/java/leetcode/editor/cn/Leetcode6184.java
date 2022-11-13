package leetcode.editor.cn;

public class Leetcode6184 {
    public static void main(String[] args) {
        Leetcode6184 leetcode6184 = new Leetcode6184();
        System.out.println(leetcode6184.countDaysTogether("08-15",
                "08-18",
                "08-16",
                "08-19"));
    }
    int[] days = new int[]{31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    public int countDaysTogether(String arriveAlice, String leaveAlice, String arriveBob, String leaveBob) {

        if (arriveBob.compareTo(leaveAlice) > 0 || leaveBob.compareTo(arriveAlice) < 0) {
            return 0;
        }
        String start = arriveBob.compareTo(arriveAlice) >= 0 ? arriveBob : arriveAlice;
        String end =  leaveAlice.compareTo(leaveBob) <= 0 ? leaveAlice : leaveBob;
        return getDay(end) - getDay(start) + 1;
    }
    public int getDay(String current) {
        String[] splited = current.split("-");
        int start = splited[0].startsWith("0") ? splited[0].charAt(1) - '0' - 1 : Integer.parseInt(splited[0]) - 1;
        int day = splited[1].startsWith("0") ? splited[1].charAt(1) - '0'  : Integer.parseInt(splited[1]);
        int result = 0;
        for (int i = 0; i < start; i++) {
            result += days[i];
        }
        return result + day;
    }

}
