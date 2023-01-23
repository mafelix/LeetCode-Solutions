class Solution {
    public int findJudge(int n, int[][] trust) {
        int townJudge = -1;
        Map<Integer, Set<Integer>> trustMap = new HashMap();
        
        for (int i = 0; i < trust.length; i++) {
            trustMap.computeIfAbsent(trust[i][0], (k) -> new HashSet());
            trustMap.get(trust[i][0]).add(trust[i][1]);
        }

        Set<Integer> possibleJudges = new HashSet();
        
        for (int i = 1; i <= n; i++) {
            possibleJudges.add(i);
        }

        for (int i = 1; i <= n; i++) {
            if (trustMap.containsKey(i)) {
                possibleJudges.remove(i);
            }
        }
        
        Integer[] candidates = possibleJudges.toArray(new Integer[possibleJudges.size()]);
        if (candidates.length == 1) {
            // check to see if everyone is pointing to the townJudge
            boolean passed = true;
            for (int i = 1; i <= n; i++) {
                if (i == candidates[0]) continue;
                if (trustMap.get(i).contains(candidates[0]) == false) {
                    passed = false;
                    break;
                }
            }
            if (passed == true) {
                townJudge = candidates[0];
            }
        }

        return townJudge;
    }
}
