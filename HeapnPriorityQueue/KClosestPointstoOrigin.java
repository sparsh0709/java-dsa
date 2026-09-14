973. K Closest Points to Origin
https://leetcode.com/problems/k-closest-points-to-origin/description/
class Solution {

    PriorityQueue<int[]> pq = new PriorityQueue<>(
        (a, b) -> {
            int distA = a[0] * a[0] + a[1] * a[1];
            int distB = b[0] * b[0] + b[1] * b[1];

            return distB - distA;
        }
    );

    public int[][] kClosest(int[][] points, int k) {

        for (int[] point : points) {

            pq.add(point);

            if (pq.size() > k) {
                pq.poll();
            }
        }

        int[][] ans = new int[k][2];

        for (int i = 0; i < k; i++) {
            ans[i] = pq.poll();
        }

        return ans;
    }
}
