package 代码随想录.day27;

import java.util.Arrays;

public class findContentChildren {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int count = 0;
        int gright = g.length - 1;
        int sright = s.length - 1;
        while(sright >= 0 && gright >= 0){
            if(s[sright] >= g[gright]){
                count++;
                sright--;
                gright--;
            }else gright--;
        }
        return count;
    }
}
