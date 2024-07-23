package 代码随想录.day32;

public class monotoneIncreasingDigits {
    public int monotoneIncreasingDigits(int n) {
        char[] num = String.valueOf(n).toCharArray();
        int flag = num.length;
        //从最后开始遍历，可以复用上一次的结果
        for(int i = num.length - 1; i > 0; i--){
            if(num[i] < num[i-1]){
                flag = i;
                num[i-1]--;
            }
        }
        for (int i = flag; i < num.length; i++) {
            num[i] = '9';
        }
        return Integer.parseInt(new String(num));
    }

    public static void main(String[] args) {
        int n = 100;
        System.out.println(new monotoneIncreasingDigits().monotoneIncreasingDigits(n));
    }
}
