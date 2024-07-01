package 代码随想录.day9;

import java.util.Scanner;

public class rightHandedString {
    private static String rightHandedString(String s, int k) {
        int len = s.length();
        if(k > len) k = k % len;
        int left = 0, right = len - 1;
        char[] parse = s.toCharArray();
        reverse(parse, 0, len - 1);
        reverse(parse, 0, k - 1);
        return new String(reverse(parse, k, len - 1));
    }

    private static char[] reverse(char[] parse, int start, int end) {
        char temp;
        while (start <= end) {
            temp = parse[start];
            parse[start] = parse[end];
            parse[end] = temp;

            start++;
            end--;
        }
        return parse;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int k = Integer.parseInt(sc.nextLine());
        String s = sc.nextLine();
        System.out.println(rightHandedString(s, k));
    }
}
