package com.test;

import java.math.BigInteger;
import java.util.Scanner;

public class Test06 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String current = in.nextLine();
        BigInteger result = BigInteger.ZERO;
        int index = 0;
        int n = current.length();
        boolean isPositve = true;
        while (index < n) {
            char currentChar = current.charAt(index);
            if (isPositve && Character.isDigit(currentChar)) {
                result = result.add(BigInteger.valueOf(currentChar - '0'));
            } else if (currentChar == '-') {
                isPositve = false;
                index++;
                BigInteger tempResult = BigInteger.ZERO;
                while (index < n && Character.isDigit(current.charAt(index))) {
                    tempResult = tempResult .multiply(BigInteger.TEN).add(BigInteger.valueOf(current.charAt(index) - '0'));
                    index++;
                }
                result = result.subtract(tempResult);
                isPositve = true;
            }
            index++;
        }
        System.out.println(result);
    }
}
