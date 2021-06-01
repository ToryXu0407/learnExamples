package leetcode;

import org.apache.poi.ss.formula.functions.T;

/**
 * @author toryxu
 * @version 1.0
 * @date 2021/4/14 10:03 下午
 */
public class Trie {

    Trie[] children;
    boolean isEnd;

    public Trie() {
        children = new Trie[26];
        isEnd = false;
    }

    public void insert(String word) {
        Trie node = this;
        int index = 0;
        for (int i = 0; i < word.length(); i++) {
            index = word.charAt(i) - 'a';
            if (node.children[index] == null) {
                node.children[index] = new Trie();
            }
            node = node.children[index];
        }
        node.isEnd = true;
    }

    public boolean search(String word) {
        Trie node = this;
        int index;
        for (int i = 0; i < word.length(); i++) {
            index = word.charAt(i) - 'a';
            if (node.children[index] == null) {
                return false;
            }
            node = node.children[index];
        }
        return node.isEnd;
    }

    public boolean startsWith(String prefix) {
        Trie node = this;
        int index;
        for (int i = 0; i < prefix.length(); i++) {
            index = prefix.charAt(i) - 'a';
            if (node.children[index] == null) {
                return false;
            }
            node = node.children[index];
        }
        return true;
    }
}
