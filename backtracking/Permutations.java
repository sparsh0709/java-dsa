46.Permutations
https://leetcode.com/problems/permutations/description/


class Solution {
    List<List<Integer>> ans = new ArrayList<>();
    List<Integer> path = new ArrayList<>();
    public List<List<Integer>> permute(int[] nums) {
        boolean [] visited   = new boolean[nums.length];
        dfs(nums,visited);
        return ans;
    }
    private void dfs(int [] nums, boolean [] visited){
        if(path.size() == nums.length){
            ans.add(new ArrayList<>(path));
            return;
        }
        for(int i = 0; i<nums.length;i++){
            if(visited[i]){
                continue;
            }
            path.add(nums[i]);
            visited[i] = true;
            dfs(nums, visited);
            path.remove(path.size()-1);
            visited[i] = false;
        }
    }
}
