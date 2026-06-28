LeetCode: 200. Number of Islands
Difficulty: Medium
Topic: Graphs, DFS

Approach:
- Traverse the grid.
- Whenever an unvisited land cell is found, perform DFS.
- Mark every connected land cell as visited.
- Increment island count after each DFS.

Time Complexity: O(m × n)
Space Complexity: O(m × n)

Concepts Learned:
- DFS
- Connected Components
- Grid Traversal

  class Solution {
    int m = 0;
    int n =0;
    public int numIslands(char[][] grid) {
        m = grid.length;
        n = grid[0].length;
        int count = 0;
        for(int i =0; i<m; i++){
            for(int j =0; j<n;j++){
                if(grid[i][j]=='1'){
                    dfs(grid,i,j);
                    count++;
                }
            }
        }
        return count;
        
    }
    public void dfs(char[][]grid , int i, int j){
        if(i<0 || j>=n|| j<0||i>=m){
            return; 
        }
        if(grid[i][j] =='0'|| grid[i][j] == '2'){
            return;
        }
        grid[i][j] = '2';
        dfs(grid, i+1,j);
        dfs(grid, i-1,j);
        dfs(grid, i,j+1);
        dfs(grid, i,j-1);
    }
}
