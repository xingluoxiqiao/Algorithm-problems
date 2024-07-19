package 代码随想录.day06;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class isHappy {
    public static boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();
        set.add(n);
        int now = n;
        while(true){
            now = SquareSum(now);
            if(now == 1) return true;
            if(set.contains(now)){
                return false;
            }
            set.add(now);
        }
    }

    private static int SquareSum(int n){
        int sum = 0;
        while(n != 0){
            int cur = n%10;
            sum += cur * cur;
            n /= 10;
        }
        System.out.println(sum);
        return sum;
    }

    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(isHappy(n));
    }

}
