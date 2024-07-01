package 代码随想录.day9;

import java.util.Scanner;

public class strStr_KMP____ {
    //暴力解法
    public static int strStr1(String haystack, String needle) {
        if(haystack.length() < needle.length()) return -1;
        for(int i = 0; i < haystack.length() - needle.length(); i++){
            if(haystack.startsWith(needle, i)){
                return i;
            }
        }
        return -1;
    }
    //KMP算法
    public static int strStr2(String haystack, String needle){
        int[] next = getNext(needle);
        int j = 0;
        for(int i = 0; i < haystack.length(); i++){
            while(j > 0 && haystack.charAt(i) != needle.charAt(j)){
                j = next[j - 1];
            }
            if(haystack.charAt(i) == needle.charAt(j)){
                j++;
            }
            if(j == needle.length()){
                return i - needle.length() + 1;
            }
        }
        return -1;
    }
    //next[i] 表示[0，i]最大前后缀相等的字符数，例如aabaacaad的next[4]=2
    //当在某位置m匹配不上时，可使起始匹配点定位至m-next[m-1] ，例如 aabaacaad 与 aacaad 在5匹配不上，可从5-next[4] = 3 开始重新匹配
    private static int[] getNext(String s){
        int[] next = new int[s.length()];
        int j = 0;
        next[0] = 0;
        //i,j分别指向后缀和前缀的末尾
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
        String haystack = sc.nextLine();
        String needle = sc.nextLine();
        System.out.println(strStr2(haystack,needle));
    }
}
