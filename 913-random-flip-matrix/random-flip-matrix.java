class Solution {

    private int rows;
    private int cols;
    private int total;

    private Random random = new Random();

    private Map<Integer, Integer> map = new HashMap<>();

    public Solution(int m, int n) {
        rows = m;
        cols = n;
        total = m * n;
    }

    public int[] flip() {
        int randomIndex = random.nextInt(total);

        int actualIndex = map.getOrDefault(randomIndex, randomIndex);
        total--;
        map.put(
            randomIndex,
            map.getOrDefault(total, total)
        );

        return new int[] {
            actualIndex / cols,
            actualIndex % cols
        };
    }

    public void reset() {
        total = rows * cols;
        map.clear();
    }
}