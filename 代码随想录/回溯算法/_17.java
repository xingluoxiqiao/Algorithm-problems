package 代码随想录.回溯算法;

import org.w3c.dom.ls.LSInput;

import java.util.ArrayList;
import java.util.List;

public class _17 {
//    给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。
//
//    给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
    List<String> res = new ArrayList<>();
    String[] strs=new String[]{"abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
    public List<String> letterCombinations(String digits) {
        if(digits==null||digits.length()==0){
            return res;
        }
        back(0,new StringBuilder(),digits);
        return res;
    }

    /*
     * @param num 当前已经拼成的长度
     */
    private void back(int num,StringBuilder sb,String digits){
        if(num==digits.length()){
            res.add(sb.toString());
            return;
        }
        String str = strs[digits.charAt(num)-'2'];
        for(int i=0;i< str.length();i++){
            sb.append(str.charAt(i));
            //c
            back(num+1,sb, digits);
            //剔除末尾的继续尝试
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
