class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums); // important
        boolean[] used = new boolean[nums.length];
        backtrack(nums, ans, new ArrayList<>(), used);
        return ans;
    }

    private void backtrack(int[] nums, List<List<Integer>> ans, List<Integer> temp, boolean[] used) {
        if (temp.size() == nums.length) {
            ans.add(new ArrayList<>(temp));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (used[i]) continue;

            // skip duplicates
            if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) continue;

            used[i] = true;
            temp.add(nums[i]);

            backtrack(nums, ans, temp, used);

            temp.remove(temp.size() - 1);
            used[i] = false;
        }
    }
}