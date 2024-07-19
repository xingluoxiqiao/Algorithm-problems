package 代码随想录.day02;

public class generateMatrix {
    //理清思路
    //左闭右开
    public static int[][] generateMatrix(int n) {
        //记录当前需要写的数
        int count = 1;
        int res[][] = new int[n][n];
        //记录当前的层数
        int record = 0;
        while(record < n/2){
            //j不一定从0开始
            for(int j = record; j < n - 1 - record; j++){
                res[record][j] = count++;
            }
            for(int i = record; i < n - 1 - record; i++){
                res[i][n-1-record] = count++;
            }
            for(int j = n - 1 - record; j > record; j--){
                res[n-1-record][j] = count++;
            }
            for(int i = n - 1 - record; i > record; i--){
                res[i][record] = count++;
            }
            record++;
        }
        if(n%2 != 0){
            res[n/2][n/2] = n*n;
        }
        return res;
    }

    public static void main(String[] args) {
        generateMatrix(3);
    }

}
