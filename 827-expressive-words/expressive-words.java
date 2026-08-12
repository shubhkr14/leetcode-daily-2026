class Solution {
    public int expressiveWords(String s, String[] words) {
        int ans = 0;

        for (String word : words) {
            if (isStretchy(s, word)) {
                ans++;
            }
        }

        return ans;
    }

    private boolean isStretchy(String s, String word) {
        int i = 0;
        int j = 0;

        while (i < s.length() && j < word.length()) {

            if (s.charAt(i) != word.charAt(j)) {
                return false;
            }

            int startS = i;
            int startW = j;

            while (i < s.length() && s.charAt(i) == s.charAt(startS)) {
                i++;
            }

            while (j < word.length() && word.charAt(j) == word.charAt(startW)) {
                j++;
            }

            int countS = i - startS;
            int countW = j - startW;

            if (countW > countS) {
                return false;
            }
            if (countS != countW && countS < 3) {
                return false;
            }
        }

        return i == s.length() && j == word.length();
    }
}