class Solution {

    private int[] original;
    private int[] array;
    private Random random;

    public Solution(int[] nums) {
        original = nums.clone();
        array = nums.clone();
        random = new Random();
    }

    public int[] reset() {
        array = original.clone();
        return array;
    }

    public int[] shuffle() {
        for (int i = array.length - 1; i > 0; i--) {
            int j = random.nextInt(i + 1);

            int temp = array[i];
            array[i] = array[j];
            array[j] = temp;
        }

        return array;
    }
}