class Solution {
    public boolean chomp(String a, String chomp) {
        if (chomp.equals("")) return false;
        if (a.equals("")) return true;
        int chompi = a.indexOf(chomp);
        if (chompi > -1) {
            if (chompi == 0) {
                return chomp(a.substring(chompi+chomp.length()), chomp);
            }
            else {
                return false;
            }
        } 
        return false;
    }

    public String gcdOfStrings(String str1, String str2) {
        String longestStr = "";
        String compare, base, proposed;
        int r;

        // determine which is the shorter string
        int str1len = str1.length(), str2len = str2.length();

        if (str2len < str1len) {
            compare = str2;
            proposed = compare;
            base = str1;
            r = str2len-1;
        } else {
            compare = str1;
            proposed = compare;
            base = str2;
            r = str1len-1;
        }

        boolean result = (chomp(base, proposed) && chomp(compare, proposed));
        while (result == false && r > 0) {
            r--;
            proposed = proposed.substring(0, r);
            result = (chomp(base, proposed) && chomp(compare, proposed));
        }

        if (result == true) {
            longestStr = proposed;
        }

        return longestStr;
    }
}
