class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int currentGas = 0, min = 0, ret = 0;

        for (int i = 0; i < gas.length; i++) {
            if (currentGas < min) {
                ret = i;
                min = currentGas;
            }

            currentGas += (gas[i] - cost[i]);
        }
        -6
        return currentGas < 0 ? -1 : ret;
    }
}

