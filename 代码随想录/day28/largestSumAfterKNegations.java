package 代码随想录.day28;

import java.util.Arrays;

public class largestSumAfterKNegations {
    public int largestSumAfterKNegations(int[] nums, int k) {
        Arrays.sort(nums);
        for(int i = 0; i < nums.length && k > 0; i++){
            if(nums[i] < 0){
                nums[i] = -nums[i];
                k--;
            }else break;
        }
        Arrays.sort(nums);
        if(k%2 == 1) nums[0] = -nums[0];
        int res = 0;
        for(int j = 0; j < nums.length; j++){
            res += nums[j];
        }
        return res;
    }
}
