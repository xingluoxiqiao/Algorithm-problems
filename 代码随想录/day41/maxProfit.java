package 代码随想录.day41;

public class maxProfit {
    public int maxProfit(int[] prices) {
        int min = Integer.MAX_VALUE;
        int res = 0;
        for(int i = 0; i < prices.length; i++){
            if(prices[i] < min){
                min = prices[i];
            }else if(res < prices[i] - min) {
                res = prices[i] - min;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] price = new int[]{7,1,5,3,6,4};
        System.out.println(new maxProfit().maxProfit(price));
    }
}
