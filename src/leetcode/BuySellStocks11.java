package leetcode;

public class BuyAndSellStocks11 {
    public static void main(String[] args) {
        int[] arr = {5,2,3,2,6,6,2,9,1,0,7,4,5,0};
        System.out.println(maxProfit(arr));
    }
    public static int maxProfit(int[] prices) {
        int n = prices.length;
        int current = 0;
        int profit = 0;
        for(int i=1;i<n-1;i++){
            if(prices[current]<prices[i] && prices[i]<prices[i+1]){
                continue;
            }else if(prices[current]<=prices[i] && prices[i]>prices[i+1]){
                profit += prices[i]-prices[current];
                current = i+1;
            }else{
                current = i;
            }
        }
        if(current == 0)
            profit += prices[n-1]-prices[current];
        return profit;
    }
}
