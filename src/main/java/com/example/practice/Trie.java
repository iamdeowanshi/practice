package com.example.practice;

import java.util.*;

public class Trie {

    class TrieNode {
        boolean isEndOfWord;
        Map<Character, TrieNode> children;

        public TrieNode() {
            children = new HashMap<>();
            isEndOfWord = false;
        }
    }

    private final TrieNode root;
    private int n,m;

    boolean[][] visited;
    public Trie() {
        root = new TrieNode();
    }

    void insert(String word) {
        TrieNode current = root;

        for (Character ch : word.toCharArray()) {
            TrieNode node = null;
            if (!current.children.containsKey(ch)) {
                node = new TrieNode();
                current.children.put(ch, node);
            }

            current = (node == null) ? current.children.get(ch) : node;
        }

        current.isEndOfWord = true;
    }

    boolean search(String word) {
        TrieNode current = root;

        for (Character ch : word.toCharArray()) {
            TrieNode node = current.children.get(ch);

            if (node == null)
                return false;

            current = node;
        }

        return current.isEndOfWord;
    }

    List<String> suggestions(String input) {
        TrieNode current = root;
        List<String> allSufix = new ArrayList<>();

        TrieNode node = null;
        for (Character ch : input.toCharArray()) {
            node = current.children.get(ch);

            if (node == null) {
                return Collections.emptyList();
            }

            current = node;

        }

        getAllSuffix(current, input,allSufix);

        return allSufix;
    }

    public void getAllSuffix(TrieNode node, String prefix, List<String> allSufix) {
        if (node.isEndOfWord)
            allSufix.add(prefix);

        for (Character key : node.children.keySet()) {
            TrieNode child = node.children.get(key);
            getAllSuffix(child, prefix + key, allSufix);
        }

    }

    public static void main(String[] args) {
        /*String keys[] = {"the", "a", "there", "answer", "any",
                "by", "bye", "their"};
        Trie trie = new Trie();
        for (String key : keys)
            trie.insert(key);



        System.out.println(trie.search("there"));
        System.out.println(trie.suggestions("a").toString());*/

        String dictionary[] = {"GEEKS", "FOR", "QUIZ", "GEE"};

        // root Node of trie
        Trie trie = new Trie();

        // insert all words of dictionary into trie
        int n = dictionary.length;
        for (int i = 0; i < n; i++)
            trie.insert(dictionary[i]);

        char boggle[][] = {{'G', 'I', 'Z'},
                {'U', 'E', 'K'},
                {'Q', 'S', 'E'}
        };

        System.out.println(Arrays.toString(trie.findWords(boggle).toArray()));
    }

    private List<String> findWords(char[][] boggle) {
        List<String> result = new ArrayList<>();

        n = boggle.length;
        m = boggle[0].length;

        visited = new boolean[n][m];

        String str = "";
        for (int i = 0; i < n ; i++) {
            for (int j = 0; j < m; j++) {
                TrieNode node = root.children.get(boggle[i][j]);
                if(node != null) {
                    searchWord(node, str + boggle[i][j], boggle, i, j, result);
                }
            }
        }

        return result;
    }

    boolean isSafe(int i, int j) {
        return (i >=0 && i < n && j >=0 &&
                j < m && !visited[i][j]);
    }

    private void searchWord(TrieNode node, String s, char[][] boggle, int i, int j, List<String> result) {
        if(node.isEndOfWord)
            result.add(s);

        if(isSafe(i,j)) {
            visited[i][j] = true;

            for (Character child : node.children.keySet()) {
                if (isSafe(i+1,j+1) && boggle[i+1][j+1] == child)
                    searchWord(node.children.get(child), s+child , boggle, i+1,j+1,result);
                if (isSafe(i,j+1) && boggle[i][j+1] == child)
                    searchWord(node.children.get(child), s+child , boggle, i,j+1,result);
                if (isSafe(i-1,j+1) && boggle[i-1][j+1] == child)
                    searchWord(node.children.get(child), s+child , boggle, i-1,j+1,result);
                if (isSafe(i+1,j) && boggle[i+1][j] == child)
                    searchWord(node.children.get(child), s+child , boggle, i+1,j,result);
                if (isSafe(i+1,j-1) && boggle[i+1][j-1] == child)
                    searchWord(node.children.get(child), s+child , boggle, i+1,j-1,result);
                if (isSafe(i,j-1) && boggle[i][j-1] == child)
                    searchWord(node.children.get(child), s+child , boggle, i,j-1,result);
                if (isSafe(i-1,j-1) && boggle[i-1][j-1] == child)
                    searchWord(node.children.get(child), s+child , boggle, i-1,j-1,result);
                if (isSafe(i-1,j) && boggle[i-1][j] == child)
                    searchWord(node.children.get(child), s+child , boggle, i-1,j,result);
            }

            visited[i][j] = false;
        }

    }
}