class Solution {
    public NestedInteger deserialize(String s) {
        if (s.charAt(0) != '[') {
            return new NestedInteger(Integer.parseInt(s));
        }

        Stack<NestedInteger> stack = new Stack<>();
        NestedInteger curr = null;
        int numStart = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c == '[') {
                if (curr != null) {
                    stack.push(curr);
                }
                curr = new NestedInteger();
                numStart = i + 1;
            } else if (c == ']') {
                if (i > numStart) {
                    curr.add(new NestedInteger(
                        Integer.parseInt(s.substring(numStart, i))));
                }

                if (!stack.isEmpty()) {
                    NestedInteger parent = stack.pop();
                    parent.add(curr);
                    curr = parent;
                }

                numStart = i + 1;
            } else if (c == ',') {
                if (s.charAt(i - 1) != ']') {
                    curr.add(new NestedInteger(
                        Integer.parseInt(s.substring(numStart, i))));
                }
                numStart = i + 1;
            }
        }

        return curr;
    }
}