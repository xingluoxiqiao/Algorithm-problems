package 代码随想录.day44;

public class isSubsequence {
    public boolean isSubsequence(String s, String t) {
        if(s == null || s.isEmpty()) return true;
        int len1 = s.length();
        int len2 = t.length();
        if(len1 > len2) return false;
        int index = 0;
        for(int i = 0; i < len2; i++){
            if(index == s.length()) return true;
            if(s.charAt(index) == t.charAt(i)){
                index++;
            }
        }
        return index == s.length();
    }

    public static void main(String[] args) {
        String s = "b",t = "abc";
        System.out.println(new isSubsequence().isSubsequence(s,t));
    }
}
