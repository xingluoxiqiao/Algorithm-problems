package 代码随想录.day22;

import java.util.ArrayList;
import java.util.List;

public class letterCombinations {
    static String[] strs = new String[]{"abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
    static List<String> res = new ArrayList<>();
    public static List<String> letterCombinations(String digits){
        if(digits == null || digits.length() == 0){
            return res;
        }
        back("",digits);
        return res;
    }
    private static void back(String s,String digits){
        if(s.length() == digits.length()){
            res.add(s);
            return;
        }
        int len = s.length();
        String str = strs[digits.charAt(len) - '2'];
        for(int i = 0; i < str.length(); i++){
            back(s + str.charAt(i),digits);
        }
    }

    public static void main(String[] args) {
        String digits = "";
        List<String> res = letterCombinations(digits);
        for(String s : res){
            System.out.println(s);
        }
    }
}
