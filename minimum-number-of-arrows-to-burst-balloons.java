class Solution {
    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points, (a, b) -> {
            if (a[0] < b[0]) return -1;
            if (a[0] == b[0]) {
                if (a[1] < b[1]) return -1;
                else return 1;
            } 
            else return 1;
        });
        // order by desc of end range of balloons
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>((a, b) -> {
            return b[1]-a[1];
        });
        pq.add(points[0]);

        for (int i = 1; i < points.length; i++) {
            if (pq.peek()[1] < points[i][0]) {
                pq.add(points[i]);            
            } else { // merge 
                int[] last = pq.poll();
                last[0] = Math.max(last[0], points[i][0]);
                last[1] = Math.min(last[1], points[i][1]);

                pq.add(last);
            }
        }

        return pq.size();
    }
}
