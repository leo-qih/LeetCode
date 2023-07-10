package solutions;

/**
 * 208. Implement Trie (Prefix Tree)
 */

public class S208 {
    TrieNode root;

    public S208() {
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
    
    public boolean search(String word) {
        TrieNode p = root;
        for (int i = 0; i < word.length(); i++) {
            int u = word.charAt(i) - 'a';
            if (p.childs[u] == null) return false;
            p = p.childs[u];
        }

        return p.end;
    }
    
    public boolean startsWith(String prefix) {
        TrieNode p = root;
        for (int i = 0; i < prefix.length(); i++) {
            int u = prefix.charAt(i) - 'a';
            if (p.childs[u] == null) return false;
            p = p.childs[u];
        }

        return true;
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
