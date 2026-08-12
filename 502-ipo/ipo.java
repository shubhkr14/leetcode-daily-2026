class Solution {
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        PriorityQueue<int[]> projects =
            new PriorityQueue<>((a, b) -> a[0] - b[0]);
        PriorityQueue<Integer> maxProfit =
            new PriorityQueue<>((a, b) -> b - a);

        for (int i = 0; i < profits.length; i++) {
            projects.offer(new int[]{capital[i], profits[i]});
        }

        for (int i = 0; i < k; i++) {
            while (!projects.isEmpty() &&
                   projects.peek()[0] <= w) {

                maxProfit.offer(projects.poll()[1]);
            }
            if (maxProfit.isEmpty()) {
                break;
            }
            w += maxProfit.poll();
        }

        return w;
    }
}