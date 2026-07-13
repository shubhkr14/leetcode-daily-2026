class Solution {
    public List<String> addOperators(String num, int target) {
        List<String> ans = new ArrayList<>();
        backtrack(ans, "", num, target, 0, 0, 0);
        return ans;
    }

    private void backtrack(List<String> ans, String path, String num,
                           int target, int pos, long value, long prev) {

        if (pos == num.length()) {
            if (value == target) {
                ans.add(path);
            }
            return;
        }

        for (int i = pos; i < num.length(); i++) {

            // Skip numbers with leading zeros
            if (i != pos && num.charAt(pos) == '0') {
                break;
            }

            String currStr = num.substring(pos, i + 1);
            long curr = Long.parseLong(currStr);

            if (pos == 0) {
                backtrack(ans, currStr, num, target, i + 1, curr, curr);
            } else {
                backtrack(ans, path + "+" + currStr,
                          num, target, i + 1, value + curr, curr);

                backtrack(ans, path + "-" + currStr,
                          num, target, i + 1, value - curr, -curr);

                backtrack(ans, path + "*" + currStr,
                          num, target, i + 1,
                          value - prev + prev * curr,
                          prev * curr);
            }
        }
    }
}