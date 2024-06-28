package 代码随想录.day8;

import java.util.Scanner;

//写复杂了，要善于运用for的i可以一次加多个的特性
//还有字符数组转字符串是直接用构造方法或者valueof
public class reverseStr2 {
    public static String reverseStr(String s, int k) {
        StringBuilder sb = new StringBuilder();
        int count = s.length()/(2*k);
        for(int i = 0; i < count; i++){
            sb.append(reverseString(s.substring(i*2*k,i*2*k+k).toCharArray()));
            sb.append(s, i*2*k+k, i*2*k+2*k);
        }
        if(count*2*k + k <= s.length()){
            sb.append(reverseString(s.substring(count*2*k,count*2*k+k).toCharArray()));
            sb.append(s.substring(count*2*k+k));
        } else {
            sb.append(reverseString(s.substring(count*2*k,s.length()).toCharArray()));
        }
        return sb.toString();
    }
    public static String reverseString(char[] s) {
        int left = 0, right = s.length - 1;
        char temp;
        while(left <= right){
            temp = s[left];
            s[left] = s[right];
            s[right] = temp;
            left++;
            right--;
        }
        return String.valueOf(s);
    }

    public String reverseStr2(String s, int k) {
        char[] ch = s.toCharArray();
        for(int i = 0;i < ch.length;i += 2 * k){
            int start = i;
            // 判断尾数够不够k个来取决end指针的位置
            int end = Math.min(ch.length - 1,start + k - 1);
            while(start < end){
                char temp = ch[start];
                ch[start] = ch[end];
                ch[end] = temp;

                start++;
                end--;
            }
        }
        return new String(ch);
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        int k = sc.nextInt();
        System.out.println(s);
        System.out.println(reverseStr(s,k));
    }
}
