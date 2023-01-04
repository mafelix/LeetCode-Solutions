class Solution {
    public int minimumRounds(int[] tasks) {
        Map<Integer, Integer> map = new HashMap();
        int nComplete = 0;
        for (int t: tasks) {
            map.put(t, map.getOrDefault(t, 0)+1);
            nComplete++;
        }

        int tComplete = 0;

        for (Map.Entry<Integer,Integer> e: map.entrySet()) {
            int v = e.getValue();
            if (v < 2) {
                break;
            }

            while (v > 0) {
                if (v == 1) break;
                if (v % 3 == 0) {
                    v-=3;
                    tComplete++;
                    nComplete-=3;
                } else {
                    v-=2;
                    tComplete++;
                    nComplete-=2;
                }
            }
        
        }       
        return nComplete == 0 ? tComplete : -1;   
    }
}



/*
  You are given a 0-indexed integer array tasks, where tasks[i] represents the difficulty level of a task. In each round, you can complete either 2 or 3 tasks of the same difficulty level.
  Return the minimum rounds required to complete all the tasks, or -1 if it is not possible to complete all the tasks.

  Constraints:
  1 <= tasks.length <= 105
  1 <= tasks[i] <= 109
*/
