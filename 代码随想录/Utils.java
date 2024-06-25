package 代码随想录;

public class Utils {
    //输入形式[2,7,11,15]
    public static int[] StringToIntArray(String input) {
        String[] ans = input.substring(1, input.length() - 1).split(",");
        int[] res = new int[ans.length];
        for (int i = 0; i < ans.length; i++) {
            res[i] = Integer.parseInt(ans[i]);
        }
        return res;
    }
}
