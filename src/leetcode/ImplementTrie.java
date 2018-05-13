package leetcode;

/**
 * Project Name : Leetcode
 * Package Name : leetcode
 * File Name : ImplementTrie
 * Creator : Edward
 * Date : Sep, 2017
 * Description : TODO
 */
public class ImplementTrie {

    /**
     * 208. Implement Trie (Prefix Tree)
     */

    TrieNode root;

    /** Initialize your data structure here. */
    public ImplementTrie() {
        root = new TrieNode();
    }

    // time : O(n)  n: word.length();
    // O(num of TrieNode * 26) = O(num of Words * word.length() * 26)
    /** Inserts a word into the trie. */
    public void insert(String word) {
        TrieNode node = root;
        for (int i = 0; i < word.length(); i++) {
            int j = word.charAt(i) - 'a';
            if (node.children[j] == null) {
                node.children[j] = new TrieNode();
            }
            node = node.children[j];
        }
        node.isWord = true;
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode node = root;
        for (int i = 0; i < word.length(); i++) {
            int j = word.charAt(i) - 'a';
            if (node.children[j] == null) return false;
            node = node.children[j];
        }
        return node.isWord;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TrieNode node = root;
        for (int i = 0; i < prefix.length(); i++) {
            int j = prefix.charAt(i) - 'a';
            if (node.children[j] == null) return false;
            node = node.children[j];
        }
        return true;
    }
}
