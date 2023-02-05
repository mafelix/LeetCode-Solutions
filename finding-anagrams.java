class Solution {
    List<Integer> ans;

    public boolean compare(int[]salpha, int[]palpha) {
        for (int i = 0; i < 26; i++) {
            if (salpha[i] != palpha[i]) return false;
        }
        return true;
    }

    public List<Integer> findAnagrams(String s, String p) {
        ans = new ArrayList();
        if (p.length() > s.length()) return ans;

        int[] palpha = new int[26];
        char[] pcarr = p.toCharArray();
        for (int i = 0; i < pcarr.length; i++) {
            palpha[pcarr[i]-'a']++;
        }
        
        int[] salpha = new int[26];
        char[] scarr = s.substring(0, 0+p.length()).toCharArray();
        for (int i = 0; i < scarr.length; i++) {
            salpha[scarr[i]-'a']++;
        }
        
        if (compare(salpha, palpha)) {
            ans.add(0);
        }

        int l = 0;
        int r = l+p.length();

        while (r < s.length()) {
            // remove l from salpha
            salpha[s.charAt(l)-'a']--;
            // add r to salpha
            salpha[s.charAt(r)-'a']++;

            l++;
            r++;
            if (compare(salpha, palpha)) {
                ans.add(l);
            }    
        }

        return ans;
    }
}
