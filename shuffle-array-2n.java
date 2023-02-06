class Solution {
    public int[] shuffle(int[] nums, int n) {
        int[] ans = new int[nums.length];

        int l = 0;
        int r = n;
        int insert = 0;
        while (r < nums.length) {
            ans[insert++] = nums[l++];
            ans[insert++] = nums[r++];
        }

        return ans;
    }
}
