package 代码随想录.day27;

public class wiggleMaxLength {
    public int wiggleMaxLength(int[] nums) {
        //贪心：
        //1.记录上一个差值以及当前值，如果是0直接跳过
        //2.如果上一个差值与当前差值符号相同，更新当前值，否则更新结果
        int res = 1;
        int preDiff = 0;
        int curDiff;
        for(int i = 1; i < nums.length; i++){
            curDiff = nums[i] - nums[i-1];
            if((curDiff > 0 && preDiff <= 0) || (curDiff < 0 && preDiff >= 0)) {
                res++;
                preDiff = curDiff;
            }
        }
        return res;
    }
}
