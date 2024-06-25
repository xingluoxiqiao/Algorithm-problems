package 代码随想录.day6;

public class isAnagram {
    public boolean isAnagram(String s, String t) {
        int[] record = new int[26];
        if(s.length() != t.length()) return false;
        for(int i = 0; i < s.length(); i++){
            record[s.charAt(i)-'a']++;
            record[t.charAt(i)-'a']--;
        }
        for(int every : record){
            if(every != 0) return false;
        }
        return true;
    }
}
