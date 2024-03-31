package leetcode.editor.cn;

import java.util.*;

public class Leetcode100128 {
    public static void main(String[] args) {
        Leetcode100128 leetcode100128 = new Leetcode100128();
        System.out.println(leetcode100128.findHighAccessEmployees(Arrays.asList(Arrays.asList("digv","0809"),Arrays.asList("digv","0837"),Arrays.asList("d","0837"),Arrays.asList("digv","0820"))));
    }
    public List<String> findHighAccessEmployees(List<List<String>> access_times) {
        Map<String, List<String>> map = new HashMap<>();
        for (List<String> access : access_times) {
            List<String> current = map.getOrDefault(access.get(0), new ArrayList<>());
            current.add(access.get(1));
            map.put(access.get(0), current);
        }
        List<String> result = new ArrayList<>();
        for (Map.Entry<String, List<String>> entry : map.entrySet()) {
            List<String> sorted = entry.getValue();
            Collections.sort(sorted);
            if (sorted.size() < 3) {
                continue;
            }
            for (int i = 0; i < sorted.size() - 2; i++) {
                int last = i + 2;
                if (get(sorted.get(i), sorted.get(last))) {
                    result.add(entry.getKey());
                    break;
                }
            }

        }
        return result;
    }
    public boolean get(String time1, String time2) {
        long t1 = Integer.parseInt(time1.substring(0, 2)) * 60 + Integer.parseInt(time1.substring(2));
        long t2 = Integer.parseInt(time2.substring(0, 2)) * 60 + Integer.parseInt(time2.substring(2));
        return t2 - t1 <= 60;
    }
}
