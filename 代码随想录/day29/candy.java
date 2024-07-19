package 代码随想录.day29;

public class candy {
    public int candy(int[] ratings) {
        int[] candys = new int[ratings.length];
        candys[0] = 1;
        for(int i = 1; i < candys.length; i++){
            if(ratings[i] > ratings[i-1]){
                candys[i] = candys[i-1] + 1;
            }else{
                candys[i] = 1;
            }
        }
        for(int j = candys.length - 2; j >= 0 ; j--){
            if(ratings[j] > ratings[j+1]){
                candys[j] = Math.max(candys[j],candys[j+1]+1);
            }
        }
        int count = 0;
        for(int i = 0; i < candys.length; i++){
            count += candys[i];
        }
        return count;
    }
}
