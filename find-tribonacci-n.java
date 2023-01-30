class Solution {
    private Map<Integer, Integer> cache = new HashMap();
    
    private void initCache() {
        if (cache.size() == 0) {
            cache.put(0, 0);
            cache.put(1, 1);
            cache.put(2, 1);
        }
    }

    public int tribonacci(int n) {
        initCache();
        if (cache.containsKey(n)) return cache.get(n);
        else {
            int start = cache.size();
            while (start <= n) {
                cache.put(start, cache.get(start-1)+cache.get(start-2)+cache.get(start-3));
                start++;
            }
        }

        return cache.get(n);
    }
}
