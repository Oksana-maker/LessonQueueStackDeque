package org.example;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Map<String, String> stringMap = new TreeMap<>();
        stringMap.put("{", "}");
        stringMap.put("(", ")");
        stringMap.put("[", "]");
        ArrayDeque<String> arrayDeque = new ArrayDeque<>();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the text: ");
        String line = /*scanner.nextLine()*/ "({}[]())";
        String[] str = line.split("");
        for (String s : str) {
            arrayDeque.add(s);
        }

        System.out.println(arrayDeque);
        ArrayDeque<String> allKeys = new ArrayDeque<>();
        ArrayDeque<String> allValue = new ArrayDeque<>();
        System.out.println();
        a:
        for (String s : arrayDeque) {
            for (String s1 : stringMap.keySet()) {
                if (s.equals(s1)) {
                    allKeys.add(s);
                    arrayDeque.pop();
                    continue a;
                }
            }
            if (s.equals(stringMap.get(allKeys.getLast()))) {
                allKeys.pollLast();
                arrayDeque.pollFirst();
            } else {
                allValue.add(s);
            }
        }
        if (allKeys.isEmpty() && allValue.isEmpty()) {
            System.out.println("Right");
        } else {
            System.out.println("Not right");
        }
    }
}