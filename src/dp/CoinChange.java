package dp;

import java.util.Arrays;

public class CoinChange {
    public static void main(String[] args) {
        int[] arr = {1,2,5};
        System.out.println(change(5,arr));
    }
    public static int change(int amount, int[] coins) {
        int[][] dp = new int[coins.length][amount+1];
        for(int[] r : dp){
            Arrays.fill(r,-1);
        }

        return findP(coins.length-1,amount,coins,dp);
    }
// memorization technique
    private static int findP(int i, int amount, int[] coins, int[][] dp) {
        if(i==0){
            return (amount%coins[0]==0)? 1 : 0;
        }
        if(dp[i][amount] != -1){
            return dp[i][amount];
        }
        int np = findP(i-1,amount,coins,dp);
        int p = 0;
        if(amount>=coins[i]){
            p = findP(i,amount-coins[i],coins,dp);
        }
        dp[i][amount]=p+np;
        return dp[coins.length-1][amount];
    }

    private static int find(int i, int amount, int[] coins) {

        if(i==0){
            return (amount%coins[0]==0)? 1 : 0;
        }
        int np = find(i-1,amount,coins);
        int p = 0;
        if(amount>=coins[i]){
            p = find(i,amount-coins[i],coins);
        }
        return p+np;

    }

}
