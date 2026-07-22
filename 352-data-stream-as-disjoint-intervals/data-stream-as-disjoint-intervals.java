class SummaryRanges {

    private TreeMap<Integer, int[]> map;

    public SummaryRanges() {
        map = new TreeMap<>();
    }

    public void addNum(int value) {
        if (map.containsKey(value)) return;

        Integer low = map.floorKey(value);
        Integer high = map.ceilingKey(value);

        if (low != null && map.get(low)[1] >= value) return;

        boolean leftMerge = low != null && map.get(low)[1] + 1 == value;
        boolean rightMerge = high != null && high - 1 == value;

        if (leftMerge && rightMerge) {
            map.get(low)[1] = map.get(high)[1];
            map.remove(high);
        } else if (leftMerge) {
            map.get(low)[1] = value;
        } else if (rightMerge) {
            int[] interval = map.remove(high);
            interval[0] = value;
            map.put(value, interval);
        } else {
            map.put(value, new int[]{value, value});
        }
    }

    public int[][] getIntervals() {
        return map.values().toArray(new int[map.size()][]);
    }
}