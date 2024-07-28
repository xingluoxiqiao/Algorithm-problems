package 代码随想录.day30;

import java.sql.ClientInfoStatus;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class partitionLabels {
    public List<Integer> partitionLabels(String s) {
        List<Integer> res = new ArrayList<>();
        int[] letters = new int[26];
        for(int i = 0; i < s.length(); i++){
            letters[s.charAt(i) - 'a'] = i;
        }
        int left = 0;
        int right = 0;
        for(int i = 0; i < s.length(); i++){
            right = Math.max(right,letters[s.charAt(i) - 'a']);
            if(i == right){
                res.add(right - left + 1);
                left = i + 1;
            }
        }
        return res;
    }
}
