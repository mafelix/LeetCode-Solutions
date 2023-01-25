class Solution {
    Map<Integer, int[]> map = new HashMap();
    Boolean[] forwardDirection;
    
    public int bfs(int[][] board, int pos) {
        int bestSteps = Integer.MAX_VALUE;
        int steps = 0, n = board.length; 
        int GOAL = n*n;
        
        Queue<Integer> q = new LinkedList();
        Set<Integer> visited = new HashSet();
        q.add(pos);
        visited.add(pos);
        
        while (q.isEmpty() == false) {
            int qn = q.size();
            steps++;

            while (qn > 0) {
                int visit = q.poll();
                // System.out.println("visit: " + visit + " " + steps + " " + q);
                if (steps > bestSteps) {
                    // reset 
                    q = new LinkedList();
                    qn = 0;
                    break;
                }
                
                // visit+1..visit+6 range
                for (int next = visit+1; next <= GOAL && next <= visit+6; next++) {
                    int[] npos = map.get(next); // board coordinates of next pos
                    int nr = npos[0], nc = npos[1];

                    if (next == GOAL) {
                        bestSteps = Math.min(bestSteps, steps);
                    }
                    else if (visited.contains(next) == false) {
                    // else {
                        if (board[nr][nc] == -1) {
                            q.add(next);
                            visited.add(next);
                        } else {
                            q.add(board[nr][nc]);
                            // visited.add(board[nr][nc]);
                            visited.add(next);
                            if (board[nr][nc] == GOAL) {
                                // System.out.println("reached goal: " + steps);
                                bestSteps = Math.min(bestSteps, steps);
                            }
                        }
                    }
                }
                qn--;
            }
        }
        return bestSteps == Integer.MAX_VALUE ? -1 : bestSteps;
    }

    public int snakesAndLadders(int[][] board) {
        int n = board.length;
        int goal = (int) Math.pow(n, 2);
        forwardDirection = new Boolean[board.length];
        
        // build map coordinates and position of count
        int count = 1;
        boolean forward = true;
        for (int i = n-1; i >= 0; i--) {
            // we need to check if it's forwards or backwards';
            if (i < n-1) {
                forward = !forwardDirection[i+1];
            }
            forwardDirection[i] = forward;
            // System.out.println(i + " " + forward);
            if (forward) {
                for (int j = 0; j < n; j++) {
                    map.put(count++, new int[]{i, j});
                }
            } else {
                for (int j = n-1; j >= 0; j--) {
                    map.put(count++, new int[]{i, j});
                }
            }
        }


        return bfs(board, 1);
    }
}
