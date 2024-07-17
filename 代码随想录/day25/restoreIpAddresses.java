package 代码随想录.day25;

import java.util.ArrayList;
import java.util.List;

public class restoreIpAddresses {
    //将给定的字符串分割成四个0-255的整数（不含前导0）
    List<String> res = new ArrayList<>();
    public List<String> restoreIpAddresses(String s) {
        if(s.length() > 12) return res;
        back(s,0,0);
        return res;
    }
    //左闭右开
    private void back(String s,int start,int pointCount){
        if(pointCount == 3){
            if(isValid(s,start,s.length() - 1)){
                res.add(s);
                return;
            }
        }
        for(int i = start; i < s.length(); i++){
            if(isValid(s,start,i)){
                s = s.substring(0,i+1) + '.' + s.substring(i+1);
                pointCount++;
                back(s,i+2,pointCount);
                pointCount--;
                s = s.substring(0, i + 1) + s.substring(i + 2);// 回溯删掉逗点
            }else {
                break;
            }
        }
    }
    private boolean isValid(String s,int start,int end){
        if(end < start) return false;
        if(s.charAt(start) == '0' && start != end) return false;
        int num = 0;
        for(int i = start; i <= end; i++){
            if(s.charAt(i) < '0' || s.charAt(i) > '9') return false;
            num = num * 10 + (s.charAt(i) - '0');
            if(num > 255) return false;
        }
        return true;
    }
}

