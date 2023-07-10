package solutions;

import java.util.ArrayList;
import java.util.List;

/**
 * 1268. Search Suggestions System
 */

public class S1268 {
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        List<List<String>> suggestions = new ArrayList<>();

        Trie t = new Trie();
        for (String product : products) {
            t.insert(product);
        }

        for (int i = 0; i < searchWord.length(); i++) {
            suggestions.add(t.getWordsStartWith(searchWord.substring(0, i + 1), 3));
        }

        return suggestions;
    }

    class Trie {
        TrieNode root;
        
        public Trie() {
            root = new TrieNode();
        }

        public void insert(String word) {
            TrieNode p = root;
            for (int i = 0; i < word.length(); i++) {
                int u = word.charAt(i) - 'a';
                if (p.childs[u] == null) p.childs[u] = new TrieNode();
                p = p.childs[u];
            }
            p.end = true;
        }

        public List<String> getWordsStartWith(String prefix, int limit) {
            TrieNode p = root;
            List<String> words = new ArrayList<>();
            for (int i = 0; i < prefix.length(); i++) {
                int u = prefix.charAt(i) - 'a';
                if (p.childs[u] == null) return words;
                p = p.childs[u];
            }

            getWordsByDfs(p, new StringBuilder(prefix), words, limit);
            
            return words;
        }

        public void getWordsByDfs(TrieNode p, StringBuilder sb, List<String> words, int limit) {
            if (words.size() >= limit) return;
            if (p.end) {
                words.add(sb.toString());
            }

            for (int i = 0; i < 26; i++) {
                if (p.childs[i] != null) {
                    sb.append((char)(i + 'a'));
                    getWordsByDfs(p.childs[i], sb, words, limit);
                    sb.deleteCharAt(sb.length() - 1);
                }
            }
        }
    }

    class TrieNode {
        TrieNode[] childs;
        boolean end;

        public TrieNode() {
            childs = new TrieNode[26];
            end = false;
        }
    }
}
