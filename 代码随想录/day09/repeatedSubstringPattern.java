package 代码随想录.day09;

import java.util.Scanner;

public class repeatedSubstringPattern {
    public static boolean repeatedSubstringPattern(String s) {
        int len = s.length();
        int[] next = getNext(s);
        if (next[len - 1] > 0 && len % (len - next[len - 1]) == 0) {
            return true;
        }
        return false;
    }
    private static int[] getNext(String s){
        int[] next = new int[s.length()];
        int j = 0;
        next[0] = 0;
        for(int i = 1; i < s.length(); i++){
            while(j > 0 && s.charAt(i) != s.charAt(j)){
                j = next[j - 1];
            }
            if(s.charAt(i) == s.charAt(j)){
                j++;
            }
            next[i] = j;
        }
        return next;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        System.out.println(repeatedSubstringPattern(s));

    }
}
