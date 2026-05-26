// LeetCode 35 - Search Insert Position
// Pattern: Binary Search
// Time Complexity: O(log n)
// Space Complexity: O(1)

class Solution {
    public int searchInsert(int[] nums, int target) {
        int s = 0;
        int e = nums.length-1;
        
        while(s<=e){
            int mid = s+(e-s)/2;
            if(nums[mid]==target){
                return mid;
            }
            else if(target<nums[mid]){
                e = mid-1;
            }else{
                s = mid+1;
            }

        }
        return s;
        
    }
}
