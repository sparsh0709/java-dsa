215. Kth Largest Element in an Array
https://leetcode.com/problems/kth-largest-element-in-an-array/description/


class Solution {
    PriorityQueue<Integer> pq = new PriorityQueue<>();
    public int findKthLargest(int[] nums, int k) {
        for(int i = 0; i<nums.length;i++){
            pq.add(nums[i]); 
            if(pq.size()>k){
                pq.poll();
            }
        }           
        return pq.peek();
    }
}
