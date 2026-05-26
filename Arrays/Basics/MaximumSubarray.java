// LeetCode 53 - Maximum Subarray
// Pattern: Kadane’s Algorithm
// Time Complexity: O(n)
// Space Complexity: O(1)
import java.util.*;
class Solution {
    public int maxSubArray(int[] nums) {
        int cs = 0;
        int maxnum = Integer.MIN_VALUE;
        for(int i = 0; i<nums.length; i++){
            cs += nums[i];
            maxnum = Math.max(cs,maxnum);
            if(cs<0){
                cs =0;
            }
        }
        return maxnum;
        
    }
}
