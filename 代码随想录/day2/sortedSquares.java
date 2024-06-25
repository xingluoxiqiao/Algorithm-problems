package 代码随想录.day2;

import java.util.Arrays;

public class sortedSquares {
    public int[] sortedSquares(int[] nums) {
        for(int i=0; i<nums.length;i++){
            if(nums[i]<0) nums[i]=-nums[i];
        }
        Arrays.sort(nums);
        int[] res = new int[nums.length];
        for(int j=0;j<nums.length;j++){
            res[j] = nums[j]*nums[j];
        }
        return res;
    }

    public int[] sortedSquares2Wrong(int[] nums){
        //从最右侧开始填满数组
        int left = 0, right = nums.length - 1;
        while(left <= right){
            int leftAbs = Math.abs(nums[left]), rightAbs = Math.abs(nums[right]);
            if(leftAbs <= rightAbs){
                nums[right] = nums[right]*nums[right];
            }else {
                //这一步交换不对，有可能使得最大数到中间去了
                nums[left] = rightAbs;
                nums[right] = leftAbs * leftAbs;
            }
            right--;
        }
        return nums;
    }
    public int[] sortedSquares2(int[] nums){
        int left = 0, right = nums.length - 1;
        int index = nums.length - 1;
        int[] res = new int[nums.length];
        while(left <= right){
            if(nums[left]*nums[left] > nums[right]*nums[right]){
                res[index] = nums[left]*nums[left];
                left++;
                index--;
            }else {
                res[index] = nums[right]*nums[right];
                right--;
                index--;
            }
        }
        return res;
    }
}
