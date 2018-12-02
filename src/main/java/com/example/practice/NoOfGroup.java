package com.example.practice;

import java.util.*;

public class NoOfGroup {
    public static void main(String[] args) {
        System.out.println(new NoOfGroup().solution(new String[] {"a.b@example.com", "x@example.com", "x@exa.mple.com", "ab+1@example.com", "y@example.com", "y@example.com", "y@example.com"}));
    }

    public int solution(String[] L) {
        Map<String, Set<String>> domainMap = new HashMap<>();

        for (String item : L) {
            String[] itemArray = item.split("@");
            item.toLowerCase();
            if (domainMap.containsKey(itemArray[1])) {
                Set<String> value = domainMap.get(itemArray[1]);
                value.add(itemArray[0].replaceAll("\\.","").split("\\+")[0]);
                domainMap.put(itemArray[1],value);
            } else {
                Set<String> value = new HashSet<>();
                value.add(itemArray[0].replaceAll(".","").split("/+")[0]);
                domainMap.put(itemArray[1], value);
            }
        }
        int max = Integer.MIN_VALUE;
        for (String key : domainMap.keySet()) {
            int value = domainMap.get(key).size();

            max = Math.max(value, max);
        }

        return max;


    }
}
