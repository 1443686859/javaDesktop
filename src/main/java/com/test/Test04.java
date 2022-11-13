package com.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Test04 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int length = Integer.parseInt(sc.nextLine());
        int count = Integer.parseInt(sc.nextLine());
        List<List<Integer>> arrays = new ArrayList<>();
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < count; i++) {
            String current = sc.nextLine();
            String[] currents = current.split(",");
            List<Integer> currentList = new ArrayList<>();
            for (String currentString : currents) {
                if (!"".equals(currentString)) {
                    currentList.add(Integer.parseInt(currentString));
                }
            }
            arrays.add(currentList);
            max = Math.max(max, currentList.size());
        }
        List<Integer> result = new ArrayList<>();
        int maxCycle = max / length + (max % length == 0 ? 0: 1);
        for (int i = 0; i < maxCycle; i++) {
            int start = i * length;
            for (int j = 0; j < count; j++) {
                List<Integer> currentList = arrays.get(j);
                if (start < currentList.size()) {
                    List<Integer> currentSubList = currentList.subList(start, Math.min(start + length, currentList.size()));
                    result.addAll(currentSubList);
                }

            }
        }
        StringBuilder resultString = new StringBuilder();
        for (int i = 0; i < result.size(); i++) {

            if (i == result.size() - 1) {
                resultString.append(result.get(i));
            } else {
                resultString.append(result.get(i) + ",");
            }
        }
        System.out.println(resultString.toString());
    }
}
