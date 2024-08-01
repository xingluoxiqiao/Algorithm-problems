package 代码随想录.day39;

import java.util.List;

public class wordBreak {
    //动态规划
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length()+1];
        dp[0] = true;
        for(int i = 0; i < s.length(); i++){
            for(int j = i+1; j <= s.length(); j++){
                String cur = s.substring(i,j);
                for(int k = 0; k <= wordDict.size(); k++){
                    //如果当前字串包含在集合中并且
                    if(wordDict.contains(cur) && dp[i] == true){
                        dp[j] = true;
                    }
                }
            }
        }
        return dp[s.length()];
    }
    //回溯+记忆化
    public boolean wordBreak2(String s, List<String> wordDict){
        boolean[] record = new boolean[s.length()];
        for(int i = 0; i < s.length(); i++){
            record[i] = true;
        }
        return back(s,wordDict,0,record);
    }
    private boolean back(String s,List<String> wordDict,int start,boolean[] record){
        if(start == s.length()){
            return true;
        }
        if(!record[start]) return false;
        for(int i = start; i < s.length(); i++){
            String cur = s.substring(start,i+1);
            if(!wordDict.contains(cur)){
                continue;
            }
            if(back(s,wordDict,i+1,record)) {
                return true;
            }
        }
        record[start] = false;
        return false;
    }


    public static void main(String[] args) {
        String s = "catsandog";
        List<String> wordDict = List.of("cats","dog","sand","and","cat");
        System.out.println(new wordBreak().wordBreak2(s,wordDict));
    }
}

