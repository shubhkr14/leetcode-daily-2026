class Solution {
    public int lengthLongestPath(String input) {
        Stack<Integer> stack = new Stack<>();
        stack.push(0);

        int maxLen = 0;

        for (String s : input.split("\n")) {
            int level = s.lastIndexOf("\t") + 1;

            while (stack.size() > level + 1) {
                stack.pop();
            }

            int len = stack.peek() + s.length() - level + 1;
            stack.push(len);

            if (s.contains(".")) {
                maxLen = Math.max(maxLen, len - 1);
            }
        }

        return maxLen;
    }
}