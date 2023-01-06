class Solution {
    public int maxIceCream(int[] costs, int coins) {
        Arrays.sort(costs);

        int icecreamBought = 0;
        int i = 0;
        while (i < costs.length && coins >= costs[i]) {
            coins -= costs[i++];
            icecreamBought++;
        }

        return icecreamBought;
    }
}

/*
  Given an array of costs and int coins, figure out the maximum amount of ice creams that can be bought
*/
