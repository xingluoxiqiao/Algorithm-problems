package 代码随想录.day09;

import java.util.Scanner;

public class reverseWords {
    public static String reverseWords(String s) {
        String[] words = s.trim().split("\\s+");
        int left = 0, right = words.length - 1;
        String temp;
        while(left <= right){
            temp = words[left];
            words[left] = words[right];
            words[right] = temp;

            left++;
            right--;
        }
        StringBuilder sb = new StringBuilder();
        for(String word : words){
            sb.append(word).append(" ");
        }
        return sb.toString().trim();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        System.out.println(reverseWords(s));
    }
}
