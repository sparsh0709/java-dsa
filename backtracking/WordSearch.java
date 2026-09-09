79. Word Search
  https://leetcode.com/problems/word-search/description/

class Solution {

    public boolean exist(char[][] board, String word) {

        for (int r = 0; r < board.length; r++) {
            for (int c = 0; c < board[0].length; c++) {
                if (dfs(board, r, c, word, 0)) {
                    return true;
                }
            }
        }

        return false;
    }

    public boolean dfs(char[][] board, int r, int c, String word, int wordIndex) {

        if (wordIndex == word.length()) {
            return true;
        }

        if (r < 0 || c < 0 ||
            r >= board.length || c >= board[0].length ||
            board[r][c] != word.charAt(wordIndex)) {
            return false;
        }

        char ch = board[r][c];
        board[r][c] = '#';

        if (dfs(board, r - 1, c, word, wordIndex + 1) ||
            dfs(board, r, c + 1, word, wordIndex + 1) ||
            dfs(board, r + 1, c, word, wordIndex + 1) ||
            dfs(board, r, c - 1, word, wordIndex + 1)) {

            board[r][c] = ch;
            return true;
        }

        board[r][c] = ch;
        return false;
    }
}
