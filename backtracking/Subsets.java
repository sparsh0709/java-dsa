78.Subsets
https://leetcode.com/problems/subsets/description/

class Solution {

    List<List<Integer>> ans = new ArrayList<>();
    List<Integer> path = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {

        dfs(0, nums);

        return ans;
    }

    public void dfs(int index, int[] nums) {


        ans.add(new ArrayList<>(path));

        for (int i = index; i < nums.length; i++) {


            path.add(nums[i]);


            dfs(i + 1, nums);


            path.remove(path.size() - 1);
        }
    }
}
