package 代码随想录.day07;

public class canConstruct {
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] record = new int[26];
        if(magazine.length() < ransomNote.length()) return false;
        for (int i = 0; i < magazine.length(); i++) {
            record[magazine.charAt(i) - 'a']++;
            if (i < ransomNote.length()) {
                record[ransomNote.charAt(i) - 'a']--;
            }
        }
        for (int m : record) {
            if (m < 0) return false;
        }
        return true;
    }
}
