package 代码随想录.day40;

public class rob2 {
    public int rob(int[] nums) {
        rob rob = new rob();
        int steel0 = rob.rob(cut(nums,2,nums.length-1))+nums[0];
        int nosteel0 = rob.rob(cut(nums,1,nums.length));
        return Math.max(steel0,nosteel0);
    }
    private int[] cut(int[] nums,int start, int end){
        if(end <= start) return new int[]{};
        int[] res = new int[end-start];
        int index = 0;
        for(int i = start; i < end; i++){
            res[index++] = nums[i];
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3};
        System.out.println(new rob2().rob(nums));
    }
}
