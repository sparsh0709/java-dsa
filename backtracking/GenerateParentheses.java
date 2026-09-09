22. Generate Parentheses
  https://leetcode.com/problems/generate-parentheses/description/

class Solution {
    List<String> ans = new ArrayList<>();
    StringBuilder path = new StringBuilder();
    public List<String> generateParenthesis(int n) {
        dfs(0,0,n);
        return ans;
    }
    private void dfs(int open, int close, int n){
        if(path.length()== 2*n){
            ans.add(path.toString());
            return;
        }
        if(open<n){
            path.append('(');
            dfs(open+1,close,n);
            path.deleteCharAt(path.length()-1);
        }
        if(close<open){
            path.append(')');
            dfs(open,close+1,n);
            path.deleteCharAt(path.length()-1);
        }
    }
}
