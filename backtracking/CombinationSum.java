https://leetcode.com/problems/combination-sum/description/
39. Combination Sum

class Solution {
    List<List<Integer>> ans = new ArrayList<>();
    List<Integer> path = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {

        dfs(0, candidates, target);

        return ans;
        
    }
    void dfs(int start, int[] candidates, int target) {

        if (target == 0) {
            ans.add(new ArrayList<>(path));
            return;
        }

        for (int i = start; i < candidates.length; i++) {

            if (candidates[i] > target) continue;

            path.add(candidates[i]);

            dfs(i, candidates, target - candidates[i]);

            path.remove(path.size() - 1);
        }
    }
}
