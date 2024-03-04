package javabasics.datastructure;

import java.util.*;

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
        /*Trie trie = new Trie();
        trie.insert("make");
        trie.insert("maze");
        System.out.println(trie.search("make"));
        System.out.println(trie.startsWith("ma"));*/

        Trie trie = new Trie();
        trie.insert("mobile");
        trie.insert("mouse");
        trie.insert("moneypot");
        trie.insert("monitor");
        trie.insert("mousepad");

        System.out.println(trie.suggestedProducts("mouse"));

        //trie.findAllWords(trie.root,  new StringBuilder()).forEach(System.out::println);

    }

    public boolean search(String word) {
        TrieNode current = root;
        for (char l : word.toCharArray()) {
            current = current.getChildren().get(l);
            if (current == null) {
                return false;
            }
        }
        return current.isEndOfWord();
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

    public List<List<String>> suggestedProducts(String searchWord) {
        TrieNode tn = null;
        List<List<String>> listOfsuggestions = new ArrayList<>();
        for(int i = 1; i<=searchWord.length(); i++){
            String prefix = searchWord.substring(0,i);
            List<String> suggestions = findAllWords(findNodeWithPrefix(prefix), new StringBuilder(prefix));
            if(!suggestions.isEmpty()){
                Collections.sort(suggestions);
                listOfsuggestions.add(suggestions.subList(0,Math.min(3, suggestions.size())));
            }
        }
        return listOfsuggestions;
    }

    private TrieNode findNodeWithPrefix(String prefix) {
        TrieNode current = root;
        for (char l : prefix.toCharArray()) {
            current = current.getChildren().get(l);
            if (current == null) {
                return null;
            }
        }
        return current;
    }

    private List<String> findAllWords(TrieNode node, StringBuilder sb) {
        TrieNode current = node;
        List<String> words = new ArrayList<>();

        if(current.isEndOfWord()){
            words.add(sb.toString());
        }

        current.getChildren().forEach((k,v) -> {
            StringBuilder sbChild = new StringBuilder(sb.toString());
            sbChild.append(k);
            words.addAll(findAllWords(current.getChildren().get(k), sbChild));
        });
        return words;
    }

    /*public List<String> startsWithString(String str, TrieNode node) {
        List<String> suggestions = new ArrayList<>();
        TrieNode current = node;
        StringBuilder sb = new StringBuilder();
        //prefix with str
        for (char l : str.toCharArray()) {
            current = current.getChildren().get(l);
            if (current == null) {
                return null;
            }
            sb.append(l);
        }
        //check if end
        if(current.isEndOfWord()){
            suggestions.add(sb.toString());
        }

        //children of this prefix
        current.getChildren().forEach((k, v) -> {
            suggestions.addAll(startsWithString(sb.substring(sb.length()-1, sb.length()), v));
        });

        return suggestions;
    }*/

}
