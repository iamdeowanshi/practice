package com.example.practice;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class LongestValidParantheses {

    public int longestValidParentheses(String s) {
        int left = 0, right = 0, maxlength = 0;
        for (Character ch : s.toCharArray()) {
            if (ch == '(') {
                left++;
            } else {
                right++;
            }
            if (left == right) {
                maxlength = Math.max(maxlength, 2 * right);
            } else if (right >= left) {
                left = right = 0;
            }
        }
        left = right = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == '(') {
                left++;
            } else {
                right++;
            }
            if (left == right) {
                maxlength = Math.max(maxlength, 2 * left);
            } else if (left >= right) {
                left = right = 0;
            }
        }
        return maxlength;
    }

    public static String winner(List<Integer> andrea, List<Integer> maria, String s) {
        // Write your code here
        int andreaScore = 0, mariaScore = 0;
        int deck = Math.min(andrea.size(), maria.size());

        if (s.equals("Odd")) {
            andrea.remove(0);
            maria.remove(0);
        }

        for (int i = 0; i < deck ; i++) {
            if (andrea.get(i) == maria.get(i))
                continue;
            andreaScore += andrea.get(i) - maria.get(i);
            mariaScore += maria.get(i) - andrea.get(i);
        }

        System.out.println(mariaScore + " " + andreaScore);

        return andreaScore == mariaScore ? "Tie" : andreaScore > mariaScore ? "Andrea" : "Maria";
    }

    public static int deleteProducts(List<Integer> ids, int m) {
        // Write your code here
        Map<Integer, Integer> map = new HashMap<>();
        for (Integer id : ids)
            map.put(id, map.getOrDefault(id, 0) + 1);
        int result = map.size();
        Map<Integer, Integer> sortedMap = map.entrySet().stream()
                .sorted(Map.Entry.comparingByValue())
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));
        for (Integer value : sortedMap.values()) {
            if (m > 0) {
                if (value <= m) {
                    result = result - 1;
                    m = m - value;
                }
            }
        }

        return result;
    }

    static int consecutive(long num) {
        long start = 1, end = 1;
        long sum = 1 ;
        int count = 0 ;

        for (start = 1 ; start <= num/2 ; ) {
            if (sum < num)
                sum += ++end;
            else if(sum > num)
                sum -= start++;
            else {
                count++;
                sum -= start++;
            }
        }

        return count;
    }
}
