class Solution{
    class TrieNode {
        TrieNode[] next = new TrieNode[26];
        int index = -1;
        List<Integer> list = new ArrayList<>();
    }

    TrieNode root = new TrieNode();

    public List<List<Integer>> palindromePairs(String[] words){
        for (int i = 0; i < words.length; i++){
            add(words[i], i);
        }

        List<List<Integer>> res = new ArrayList<>();

        for (int i = 0; i < words.length; i++){
            search(words[i], i, res);
        }

        return res;
    }

    private void add(String word, int index){
        TrieNode node = root;

        for (int i = word.length() - 1; i >= 0; i--){
            if (isPalindrome(word, 0, i)){
                node.list.add(index);
            }

            int c = word.charAt(i) - 'a';

            if (node.next[c] == null){
                node.next[c] = new TrieNode();
            }

            node = node.next[c];
        }

        node.list.add(index);
        node.index = index;
    }

    private void search(String word, int index, List<List<Integer>> res){
        TrieNode node = root;

        for (int i = 0; i < word.length(); i++){

            if (node.index >= 0 &&
                node.index != index &&
                isPalindrome(word, i, word.length() - 1)){
                res.add(Arrays.asList(index, node.index));
            }

            node = node.next[word.charAt(i) - 'a'];

            if (node == null){
                return;
            }
        }

        for (int j : node.list) {
            if (j != index) {
                res.add(Arrays.asList(index, j));
            }
        }
    }

    private boolean isPalindrome(String s, int l, int r) {
        while (l < r) {
            if (s.charAt(l++) != s.charAt(r--)) {
                return false;
            }
        }
        return true;
    }
}