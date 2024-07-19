package 代码随想录.day23;

import java.util.ArrayList;
import java.util.List;

public class partition {
    static List<String> path = new ArrayList<>();
    static List<List<String>> res = new ArrayList<>();
    public static List<List<String>> partition(String s) {
        back(s,0,"");
        return res;
    }
    private static void back(String s,int start,String cur){
        if(start == s.length()) {
            res.add(new ArrayList<>(path));
            return;
        }
        for(int i = start; i < s.length(); i++){
            cur = s.substring(start,i + 1);
            if(isValid(cur)) {
                path.add(cur);
                back(s,i+1,"");
                path.remove(path.size() - 1);
            }
        }
    }
    private static boolean isValid(String s){
        int left = 0, right = s.length() - 1;
        while (left <= right){
            if(s.charAt(left) != s.charAt(right)){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "aab";
        List<List<String>> res = partition(s);
        for(List<String> list : res){
            for(String str : list){
                System.out.print(str + ",");
            }
            System.out.println();
        }
    }
}
