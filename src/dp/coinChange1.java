package dp;

public class coinChange1 {
    public static void main(String[] args) {
        int[] arr = {1,2,5};
        System.out.println(coinChange(arr,11));
    }
    public static int coinChange(int[] coins, int amount) {
        return find(coins,amount,coins.length-1);
    }
    public static int find(int[] coins, int target, int i) {
        if(i==0){
            if(target%coins[0]==0){
                return target/coins[0];
            }else{
                return Integer.MAX_VALUE;
            }
        }
        int np = find(coins, target, i - 1);
        int p = Integer.MAX_VALUE;
        if(coins[i]<=target){
            p = 1 + find(coins,target-coins[i],i);
        }
        return Math.min(p,np);
    }
}
