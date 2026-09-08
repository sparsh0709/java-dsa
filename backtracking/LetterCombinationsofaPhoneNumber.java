//https://leetcode.com/problems/letter-combinations-of-a-phone-number/
17. Letter Combinations of a Phone Number

class Solution {

    List<String> ans = new ArrayList<>();
    StringBuilder path = new StringBuilder();

    String[] mapping = {
        "", "", "abc", "def", "ghi",
        "jkl", "mno", "pqrs", "tuv", "wxyz"
    };

    public List<String> letterCombinations(String digits) {

        if (digits.length() == 0) {
            return ans;
        }

        dfs(0, digits);

        return ans;
    }

    void dfs(int index, String digits) {

        if (path.length() == digits.length()) {
            ans.add(path.toString());
            return;
        }

        String letters = mapping[digits.charAt(index) - '0'];

        for (char c : letters.toCharArray()) {

            path.append(c);

            dfs(index + 1, digits);

            path.deleteCharAt(path.length() - 1);
        }
    }
}
