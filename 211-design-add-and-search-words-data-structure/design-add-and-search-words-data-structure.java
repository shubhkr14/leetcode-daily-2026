class WordDictionary {

    class TrieNode {
        TrieNode[] child = new TrieNode[26];
        boolean isEnd;
    }

    private TrieNode root;

    public WordDictionary() {
        root = new TrieNode();
    }

    public void addWord(String word) {
        TrieNode curr = root;

        for (char c : word.toCharArray()) {
            int idx = c - 'a';

            if (curr.child[idx] == null) {
                curr.child[idx] = new TrieNode();
            }

            curr = curr.child[idx];
        }

        curr.isEnd = true;
    }

    public boolean search(String word) {
        return dfs(word, 0, root);
    }

    private boolean dfs(String word, int index, TrieNode node) {
        if (node == null) return false;

        if (index == word.length()) {
            return node.isEnd;
        }

        char c = word.charAt(index);

        if (c == '.') {
            for (TrieNode child : node.child) {
                if (dfs(word, index + 1, child)) {
                    return true;
                }
            }
            return false;
        }

        return dfs(word, index + 1, node.child[c - 'a']);
    }
}