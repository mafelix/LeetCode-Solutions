class Solution {
    private List<String> ans;

    private boolean valid(String s) {
        String[] sarr = s.split("\\.");

        if (sarr.length != 4) {
            return false;
        }
        if (s.equals("")) return true;

        for (int i = 0; i < sarr.length; i++) {
            String si = sarr[i];
            int formatInt = Integer.valueOf(si);

            if (formatInt < 0 || formatInt > 255) {
                return false;
            }
            
            // no leading zeros
            if (sarr[i].charAt(0) == '0' && sarr[i].length() > 1) {
                return false;
            }
        }

        return true;
    }

    public void backtrack(String s, int segments, StringBuilder sb) {
        if (s.length() > 0 && sb.length() > 0) {
            sb.append(".");
            segments++;
        }
        if (s.equals("") || s == null || s.length() == 0) {
            if (valid(sb.toString())) {
                ans.add(sb.toString());
                return;
            }
        }
        if (segments > 3) return;

        String oneClone = String.valueOf(s), twoClone = String.valueOf(s), threeClone = String.valueOf(s);
        StringBuilder sb1 = new StringBuilder(sb.toString()),
            sb2 = new StringBuilder(sb.toString()),
            sb3 = new StringBuilder(sb.toString());

        if (s.length() > 0) {
            sb1.append(oneClone.substring(0, 1));
            backtrack(oneClone.substring(1), segments, sb1);
        }
        if (s.length() > 1) {
            sb2.append(twoClone.substring(0, 2));
            backtrack(twoClone.substring(2), segments, sb2);
        }
        if (s.length() > 2) {
            sb3.append(threeClone.substring(0, 3));
            backtrack(threeClone.substring(3), segments, sb3);
        }
    }

    public List<String> restoreIpAddresses(String s) {
        ans = new ArrayList();

        backtrack(s, 0, new StringBuilder());

        return ans;    
    }
}
