class Solution {
    public void dfs(int[] edges, int node, int step, Set<Integer> visited, int[] dist) {
        if (dist[node] != -1) return;
        dist[node] = step;
        if (edges[node] != -1) dfs(edges, edges[node], step+1, visited, dist);
    }
    public int closestMeetingNode(int[] edges, int node1, int node2) {
        // Note that edges may contain cycles.
        int[] dist1 = new int[edges.length];
        int[] dist2 = new int[edges.length];
        Arrays.fill(dist1, -1);
        Arrays.fill(dist2, -1);

        dfs(edges, node1, 0, new HashSet(), dist1);
        dfs(edges, node2, 0, new HashSet(), dist2);

        int ans = Integer.MAX_VALUE;
        int node = -1;
        for (int i = 0; i < edges.length; i++) {
            if (dist1[i] != -1 && dist2[i] != -1) {
                if (ans > Math.max(dist1[i], dist2[i])) {
                    ans = Math.max(dist1[i], dist2[i]);
                    node = i;
                }
            }
            
        }
        return node;   
    }
}
