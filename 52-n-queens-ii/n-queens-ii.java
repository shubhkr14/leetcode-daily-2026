class Solution {
    int count = 0;

    public int totalNQueens(int n) {
        boolean[] cols = new boolean[n];
        boolean[] diag = new boolean[2 * n];        // row + col
        boolean[] antiDiag = new boolean[2 * n];    // row - col + n

        backtrack(0, n, cols, diag, antiDiag);
        return count;
    }

    private void backtrack(int row, int n, boolean[] cols, boolean[] diag, boolean[] antiDiag) {
        if (row == n) {
            count++;
            return;
        }
        for (int col = 0; col < n; col++) {
            if (cols[col] || diag[row + col] || antiDiag[row - col + n]) {
                continue;
            }
            // place queen
            cols[col] = true;
            diag[row + col] = true;
            antiDiag[row - col + n] = true;

            backtrack(row + 1, n, cols, diag, antiDiag);

            // remove queen (backtrack)
            cols[col] = false;
            diag[row + col] = false;
            antiDiag[row - col + n] = false;
        }
    }
}