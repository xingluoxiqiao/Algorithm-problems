package 代码随想录.day8;

import java.util.Scanner;

public class replaceNumber {
        public static void main(String[] args){
            Scanner sc = new Scanner(System.in);
            String s = sc.nextLine();
            StringBuilder sb = new StringBuilder();
            for(int i = 0; i < s.length(); i++){
                char c = s.charAt(i);
                if(c-'a'<=26 && c-'a'>=0){
                    sb.append(c);
                }else{
                    sb.append("number");
                }
            }
            System.out.println(sb.toString());
        }
}
