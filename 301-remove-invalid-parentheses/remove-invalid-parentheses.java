class Solution {
    public List<String> removeInvalidParentheses(String s) {
        List<String> ans = new ArrayList<>();
        Queue<String> q = new LinkedList<>();
        Set<String> vis = new HashSet<>();

        q.offer(s);
        vis.add(s);

        boolean found = false;

        while (!q.isEmpty()) {
            String cur = q.poll();

            if (isValid(cur)) {
                ans.add(cur);
                found = true;
            }

            if (found) continue;

            for (int i = 0; i < cur.length(); i++) {
                char c = cur.charAt(i);

                if (c != '(' && c != ')') continue;

                String next = cur.substring(0, i) + cur.substring(i + 1);

                if (vis.add(next)) {
                    q.offer(next);
                }
            }
        }

        return ans;
    }

    private boolean isValid(String s) {
        int bal = 0;

        for (char c : s.toCharArray()) {
            if (c == '(') bal++;
            else if (c == ')') {
                if (bal == 0) return false;
                bal--;
            }
        }

        return bal == 0;
    }
}