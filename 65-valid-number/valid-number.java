class Solution {
    public boolean isNumber(String s) {
        s = s.trim();
        boolean seenDigit = false;
        boolean seenDot = false;
        boolean seenExponent = false;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (Character.isDigit(ch)) {
                seenDigit = true;
            }
            else if (ch == '+' || ch == '-') {
                // sign allowed at start or after e/E
                if (i > 0 && s.charAt(i - 1) != 'e' && s.charAt(i - 1) != 'E') {
                    return false;
                }
            }
            else if (ch == '.') {
                // dot only once and before exponent
                if (seenDot || seenExponent) return false;
                seenDot = true;
            }
            else if (ch == 'e' || ch == 'E') {
                // exponent only once and after digit
                if (seenExponent || !seenDigit) return false;
                seenExponent = true;
                seenDigit = false; // must have digit after exponent
            }
            else {
                return false;
            }
        }
        return seenDigit;
    }
}