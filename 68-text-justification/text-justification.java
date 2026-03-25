class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> result = new ArrayList<>();
        int i = 0;

        while (i < words.length) {
            int j = i + 1;
            int lineLength = words[i].length();

            // find how many words fit
            while (j < words.length && 
                   lineLength + 1 + words[j].length() <= maxWidth) {
                lineLength += 1 + words[j].length();
                j++;
            }

            int gaps = j - i - 1;
            StringBuilder line = new StringBuilder();

            // last line or single word → left justified
            if (j == words.length || gaps == 0) {
                for (int k = i; k < j; k++) {
                    line.append(words[k]);
                    if (k < j - 1) line.append(" ");
                }
                // fill remaining spaces
                while (line.length() < maxWidth) line.append(" ");
            } 
            else {
                int totalSpaces = maxWidth;
                for (int k = i; k < j; k++) totalSpaces -= words[k].length();

                int spaceEach = totalSpaces / gaps;
                int extra = totalSpaces % gaps;

                for (int k = i; k < j; k++) {
                    line.append(words[k]);
                    if (k < j - 1) {
                        int spaces = spaceEach + (extra-- > 0 ? 1 : 0);
                        for (int s = 0; s < spaces; s++) line.append(" ");
                    }
                }
            }

            result.add(line.toString());
            i = j;
        }

        return result;
    }
}