
/*
 * Problem: 130. Surrounded Regions
 * Difficulty: Medium
 * Topic: Graphs, DFS, Matrix
 *
 * Idea:
 * Any 'O' connected to the boundary cannot be surrounded.
 * Start DFS from all boundary 'O' cells and mark them as safe.
 * Convert the remaining 'O' cells to 'X' and restore the safe cells.
 *
 * Strategy:
 * 1. Traverse all boundary cells.
 * 2. Run DFS for every boundary 'O'.
 * 3. Mark visited cells as '#'.
 * 4. Convert remaining 'O' to 'X'.
 * 5. Restore '#' back to 'O'.
 *
 * Time Complexity: O(m × n)
 * Space Complexity: O(m × n)
 */
class Solution {
    int rows, cols;

    public void solve(char[][] board) {
        rows = board.length;
        cols = board[0].length;


        for (int i = 0; i < rows; i++) {
            if (board[i][0] == 'O')
                dfs(board, i, 0);

            if (board[i][cols - 1] == 'O')
                dfs(board, i, cols - 1);
        }


        for (int j = 0; j < cols; j++) {
            if (board[0][j] == 'O')
                dfs(board, 0, j);

            if (board[rows - 1][j] == 'O')
                dfs(board, rows - 1, j);
        }


        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (board[i][j] == 'O')
                    board[i][j] = 'X';
                else if (board[i][j] == '#')
                    board[i][j] = 'O';
            }
        }
    }

    private void dfs(char[][] board, int r, int c) {
        if (r < 0 || c < 0 || r >= rows || c >= cols ||
            board[r][c] != 'O')
            return;

        board[r][c] = '#';

        dfs(board, r + 1, c);
        dfs(board, r - 1, c);
        dfs(board, r, c + 1);
        dfs(board, r, c - 1);
    }
}
