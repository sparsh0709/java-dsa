LeetCode: 733. Flood Fill
Difficulty: Easy
Topic: Graphs, DFS

Approach:
- Store original color.
- DFS from starting pixel.
- Change only pixels having the original color.
- Skip out-of-bound cells and already changed cells.

Time Complexity: O(m × n)
Space Complexity: O(m × n)

Concepts Learned:
- DFS
- Matrix Traversal
- Base Cases
  class Solution {

    int m, n;

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {

        m = image.length;
        n = image[0].length;

        int originalColor = image[sr][sc];

        
        if (originalColor == color) {
            return image;
        }

        dfs(image, sr, sc, originalColor, color);

        return image;
    }

    private void dfs(int[][] image, int sr, int sc, int originalColor, int newColor) {

        
        if (sr < 0 || sr >= m || sc < 0 || sc >= n) {
            return;
        }

        
        if (image[sr][sc] != originalColor) {
            return;
        }

        
        image[sr][sc] = newColor;

        
        dfs(image, sr + 1, sc, originalColor, newColor);
        dfs(image, sr - 1, sc, originalColor, newColor);
        dfs(image, sr, sc + 1, originalColor, newColor);
        dfs(image, sr, sc - 1, originalColor, newColor);
    }
}
