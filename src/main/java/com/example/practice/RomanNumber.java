package com.example.practice;

import java.util.HashMap;
import java.util.Map;

public class RomanNumber {

    static Map<Integer,Character > romanMap;

    public static void main(String[] args) {
        init();
        System.out.println(printRoman(485));
    }

    private static String printRoman(int i) {
        StringBuilder roman = new StringBuilder();
        int len = String.valueOf(i).length();
        int pow = 10;
        while (i > 0 ) {
            int digit = i % pow; // 5
            if (romanMap.containsKey(digit))
                roman.insert(0, romanMap.get(digit));
            else {

            }

            i = i - digit; // 485 -> 480 ->
            if (pow <= Math.pow(10, len))
                pow *= 10;
        }

        return roman.toString(); // 400 = CD , 80 = LXXX , 5 = V
    }

    static void init() {
        romanMap = new HashMap<>();
        romanMap.put(1, 'I');
        romanMap.put(5, 'V');
        romanMap.put(10, 'X');
        romanMap.put(50, 'L');
        romanMap.put(100,'C');
        romanMap.put(500, 'D');
        romanMap.put(1000, 'M');
    }
}
