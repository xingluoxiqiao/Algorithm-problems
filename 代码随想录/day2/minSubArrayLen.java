package 代码随想录.day2;

//前缀和不好用，可能把nums[0]给忽略了，直接当时算就好了
public class minSubArrayLen {
    public static int minSubArrayLen(int target, int[] nums) {
        int left = 0;
        int res = Integer.MAX_VALUE;
        int sum = 0;
        for(int right = 0; right < nums.length; right++){
            //一边遍历一边计算当前子数组的和
            sum += nums[right];
            while(sum >= target){
                res = Math.min(res,right - left + 1);
                sum -= nums[left++];
            }
        }
        return res == Integer.MAX_VALUE ? 0 :res;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3,4,5};
        System.out.println(minSubArrayLen(15,nums));
    }
}
