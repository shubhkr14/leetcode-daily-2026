class Solution {
    public boolean makesquare(int[] matchsticks) {
        if (matchsticks.length < 4) {
            return false;
        }

        int sum = 0;
        for (int stick : matchsticks) {
            sum += stick;
        }

        if (sum % 4 != 0) {
            return false;
        }

        int side = sum / 4;

        Arrays.sort(matchsticks);

        int[] sides = new int[4];

        return dfs(matchsticks, matchsticks.length - 1, sides, side);
    }

    private boolean dfs(int[] sticks, int index,
                        int[] sides, int target) {

        if (index < 0) {
            return sides[0] == target &&
                   sides[1] == target &&
                   sides[2] == target &&
                   sides[3] == target;
        }

        int stick = sticks[index];

        for (int i = 0; i < 4; i++) {

            if (sides[i] + stick > target) {
                continue;
            }

            if (i > 0 && sides[i] == sides[i - 1]) {
                continue;
            }

            sides[i] += stick;

            if (dfs(sticks, index - 1, sides, target)) {
                return true;
            }

            sides[i] -= stick;

            if (sides[i] == 0) {
                break;
            }
        }

        return false;
    }
}