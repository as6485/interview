package javabasics.datastructure;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.List;
/*
    Refer : https://www.baeldung.com/trie-java
 */
class TrieNode {
    private final Map<Character, TrieNode> children = new HashMap<>();
    private boolean endOfWord;
    Map<Character, TrieNode> getChildren() {
        return children;
    }
    boolean isEndOfWord() {
        return endOfWord;
    }
    void setEndOfWord(boolean endOfWord) {
        this.endOfWord = endOfWord;
    }
}

class Trie {
    private TrieNode root;
    Trie() {
        this.root = new TrieNode();
    }
    void insert(String word) {
        TrieNode current = root;

        for (char l : word.toCharArray()) {
            current = current.getChildren().computeIfAbsent(l, c -> new TrieNode());
        }
        current.setEndOfWord(true);
    }
    boolean delete(String word) {
        return delete(root, word, 0);
    }
    boolean exists(String word) {
        TrieNode current = root;

        for (char l : word.toCharArray()) {
            current = current.getChildren().get(l);
            if (current == null) {
                return false;
            }
        }
        return current.isEndOfWord();
    }
    boolean isEmpty() {
        return root == null;
    }
    private boolean delete(TrieNode current, String word, int index) {
        if (index == word.length()) {
            if (!current.isEndOfWord()) {
                return false;
            }
            current.setEndOfWord(false);
            return current.getChildren().isEmpty();
        }
        char ch = word.charAt(index);
        TrieNode node = current.getChildren().get(ch);
        if (node == null) {
            return false;
        }
        boolean shouldDeleteCurrentNode = delete(node, word, index + 1) && !node.isEndOfWord();

        if (shouldDeleteCurrentNode) {
            current.getChildren().remove(ch);
            return current.getChildren().isEmpty();
        }
        return false;
    }

    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("make");
        trie.insert("maze");

        System.out.println(trie.startsWith("ma"));
    }

    public boolean startsWith(String prefix) {
        TrieNode current = root;
        for (char l : prefix.toCharArray()) {
            current = current.getChildren().get(l);
            if (current == null) {
                return false;
            }
        }
        return true;
    }
    TrieNode find(String word) {
        TrieNode current = root;
        for (char l : word.toCharArray()) {
            if (current == null) {
                return null;
            }
            current = current.getChildren().get(l);
        }
        return current;
    }


    List<String> findAllWordsStartingWith(String searchStr){
        List<String> words = new ArrayList<>();
        TrieNode node = find(searchStr);
        if(node != null){
            System.out.println(node.isEndOfWord());
        }
        return words;
    }
}
