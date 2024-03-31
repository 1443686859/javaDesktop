package leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

public class Leetcode6417 {


    public static void main(String[] args) {
//        FrequencyTracker frequencyTracker = new FrequencyTracker();
//        frequencyTracker.add(3);
//        frequencyTracker.add(6);
//        frequencyTracker.add(2);
//        frequencyTracker.add(6);
//        frequencyTracker.deleteOne(6);
//        frequencyTracker.deleteOne(6);
//        frequencyTracker.add(2);
//        System.out.println(frequencyTracker.hasFrequency(1));
    }

}
class FrequencyTracker2{
    Map<Integer, Integer> countMap;
    Map<Integer, Integer> map ;
    public FrequencyTracker2() {
        map = new HashMap<>();
        countMap = new HashMap<>();
    }

    public void add(int number) {
        if (countMap.containsKey(number)) {
            int currentFrequency = countMap.get(number);
            int preCount = map.get(currentFrequency);
            map.put(currentFrequency,  preCount - 1);
            if (map.get(currentFrequency) == 0) {
                map.remove(currentFrequency);
            }
            countMap.put(number, currentFrequency + 1);
            map.put(currentFrequency + 1, map.getOrDefault(currentFrequency + 1, 0) + 1);
        } else {
            countMap.put(number,1);
            map.put(1, map.getOrDefault(1, 0) + 1);
        }
    }

    public void deleteOne(int number) {
        if (countMap.containsKey(number)) {
            int currentFrequency = countMap.get(number);
            int preCount = map.get(currentFrequency);
            map.put(currentFrequency,  preCount - 1);
            if (map.get(currentFrequency) == 0) {
                map.remove(currentFrequency);
            }
            if (currentFrequency != 1) {
                map.put(currentFrequency - 1, map.getOrDefault(currentFrequency - 1, 0) + 1);
            }
            countMap.put(number, currentFrequency - 1);
            if (countMap.get(number) == 0) {
                countMap.remove(number);
            }
        }
    }

    public boolean hasFrequency(int frequency) {
        return map.containsKey(frequency);
    }
}
