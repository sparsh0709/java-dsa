https://leetcode.com/problems/combinations/description/
77. Combinations

  class Solution {
    List<List<Integer>> ans = new ArrayList<>();
    List<Integer> path = new ArrayList<>();

    public List<List<Integer>> combine(int n, int k) {

        dfs(1, n, k);

        return ans;
    }

    public void dfs(int start, int n, int k) {

        if (path.size() == k) {
            ans.add(new ArrayList<>(path));
            return;
        }

        for (int i = start; i <= n; i++) {

            path.add(i);

            dfs(i + 1, n, k);

            path.remove(path.size() - 1);
        }
    }
}
