package com.example.practice;

import java.util.*;

public class Ladder {

    public List<List<String>> ladderLength(String beginWord, String endWord, List<String> wordList) {
        int k = beginWord.length(), count = 2;
        Queue<String> queue = new LinkedList<>();
        List<List<String>> result = new ArrayList<>();
        Map<Integer, List<String>> map = new TreeMap<>();
        queue.offer(beginWord);
        Set<String> set = new HashSet<>(wordList);

        if (!wordList.contains(endWord))
            return null;
        while (!queue.isEmpty()) {

            int size = queue.size();
            List<String> subList = new ArrayList<>();
            for (int q = 0 ; q < size ; q++) {
                char[] word = queue.poll().toCharArray();
                subList.add(String.valueOf(word));

                for (int j = 0; j < k ; j++) {
                    char temp = word[j];

                    for (int i = 0 ; i < 26 ; i ++) {
                        word[j] = (char) ('a' + i);
                        String newWord = new String(word);
                        if (set.contains(newWord)) {
                            System.out.println(newWord);
                            if (newWord.equals(endWord)){
                                map.put(count, subList);
                            }
                            else {
                                set.remove(newWord);
                                queue.offer(newWord);
                            }
                        }
                    }
                    word[j] = temp;
                }
            }

            count++;
        }
        Map.Entry<Integer, List<String>>  temp = ((TreeMap<Integer, List<String>>) map).pollFirstEntry();

        result.add(temp.getValue());
        return  result;

    }
}
