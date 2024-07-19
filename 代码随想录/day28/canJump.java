package 代码随想录.day28;

public class canJump {
    public boolean canJump(int[] nums) {
        if(nums.length == 1) return true;
        //每次跳跃更新能跳到的最远距离
        int can = 0;
        for(int i = 0; i <= can; i++){
            can = Math.max(can,nums[i]+i);
            if (can >= nums.length - 1) {
                return true;
            }
        }
        return false;
    }
}
