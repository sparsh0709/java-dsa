LeetCode: 994. Rotting Oranges
Difficulty: Medium
Topic: Graphs, Multi-Source BFS

Approach:
- Store all rotten oranges in a queue.
- Count fresh oranges.
- Perform Multi-Source BFS.
- Process one BFS level at a time.
- Each level represents one minute.
- Return -1 if fresh oranges remain.

Time Complexity: O(m × n)
Space Complexity: O(m × n)

Concepts Learned:
- Multi-Source BFS
- Queue of coordinates
- Level Order Traversal
- BFS for shortest time/spreading problems
class Solution {

    public int orangesRotting(int[][] grid) {

        int m = grid.length;
        int n = grid[0].length;

        Queue<int[]> q = new LinkedList<>();

        int fresh = 0;

        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                if (grid[i][j] == 2) {
                    q.offer(new int[]{i, j});
                }

                if (grid[i][j] == 1) {
                    fresh++;
                }
            }
        }

        
        if (fresh == 0) {
            return 0;
        }

        int[][] dir = {
            {1, 0},
            {-1, 0},
            {0, 1},
            {0, -1}
        };

        int minutes = 0;

        while (!q.isEmpty() && fresh > 0) {

            int size = q.size();

            for (int i = 0; i < size; i++) {

                int[] curr = q.poll();

                int row = curr[0];
                int col = curr[1];

                for (int[] d : dir) {

                    int newRow = row + d[0];
                    int newCol = col + d[1];

                    if (newRow < 0 || newRow >= m ||
                        newCol < 0 || newCol >= n) {
                        continue;
                    }

                    if (grid[newRow][newCol] == 1) {

                        grid[newRow][newCol] = 2;
                        fresh--;

                        q.offer(new int[]{newRow, newCol});
                    }
                }
            }

            minutes++;
        }

        return fresh == 0 ? minutes : -1;
    }
}
