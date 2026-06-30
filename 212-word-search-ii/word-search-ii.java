class Solution {
    class TrieNode {
        TrieNode[] child = new TrieNode[26];
        String word;
    }

    public List<String> findWords(char[][] board, String[] words) {
        TrieNode root = buildTrie(words);
        List<String> ans = new ArrayList<>();

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                dfs(board, i, j, root, ans);
            }
        }

        return ans;
    }

    private void dfs(char[][] board, int i, int j, TrieNode node, List<String> ans) {
        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length)
            return;

        char c = board[i][j];
        if (c == '#' || node.child[c - 'a'] == null)
            return;

        node = node.child[c - 'a'];

        if (node.word != null) {
            ans.add(node.word);
            node.word = null; // avoid duplicates
        }

        board[i][j] = '#';

        dfs(board, i + 1, j, node, ans);
        dfs(board, i - 1, j, node, ans);
        dfs(board, i, j + 1, node, ans);
        dfs(board, i, j - 1, node, ans);

        board[i][j] = c;
    }

    private TrieNode buildTrie(String[] words) {
        TrieNode root = new TrieNode();

        for (String word : words) {
            TrieNode curr = root;

            for (char c : word.toCharArray()) {
                int idx = c - 'a';
                if (curr.child[idx] == null) {
                    curr.child[idx] = new TrieNode();
                }
                curr = curr.child[idx];
            }

            curr.word = word;
        }

        return root;
    }
}