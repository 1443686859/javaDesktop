package com.test;

import java.util.Scanner;

public class Test01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String[] strings = str.split(",");
        if (strings.length == 0) {
            System.out.println("/");
            return;
        }
        if (strings.length == 1) {
            StringBuilder temp = new StringBuilder(strings[0]);
            if (temp.charAt(0) != '/') {
                temp.insert(0, '/');
            }
            System.out.println(temp.toString());
            return;
        }
        StringBuilder start = new StringBuilder(strings[0]);
        StringBuilder last = new StringBuilder(strings[1]);
        if (start.length() != 0) {
            if (start.charAt(0) != '/') {
                start.insert(0, '/');
            }
            if (start.charAt(start.length() - 1) == '/') {
                start.deleteCharAt(start.length() - 1);
            }
        }
        if (last.length() != 0) {
            if (last.charAt(0) == '/') {
                last.deleteCharAt(0);
            }
        }
        System.out.println(start.toString() + "/" + last.toString());
    }
}
