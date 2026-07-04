class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int indexDiff, int valueDiff) {
        if (valueDiff<0) return false;

        Map<Long, Long> buckets = new HashMap<>();
        long size = (long) valueDiff + 1;

        for (int i = 0; i < nums.length; i++) {
            long num = nums[i];
            long id = getBucketId(num, size);

            if (buckets.containsKey(id)) return true;

            if (buckets.containsKey(id - 1) &&
                Math.abs(num - buckets.get(id - 1)) <= valueDiff)
                return true;

            if (buckets.containsKey(id + 1) &&
                Math.abs(num - buckets.get(id + 1)) <= valueDiff)
                return true;

            buckets.put(id, num);

            if (i >= indexDiff) {
                buckets.remove(getBucketId(nums[i - indexDiff], size));
            }
        }

        return false;
    }

    private long getBucketId(long num, long size) {
        if (num >= 0) return num / size;
        return ((num + 1) / size) - 1;
    }
}