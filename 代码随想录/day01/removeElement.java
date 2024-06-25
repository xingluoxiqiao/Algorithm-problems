package 代码随想录.day01;

//将所有等于k的数移到数组末尾，并返回不等于k的元素数量
public class removeElement {
    public static int removeElement(int[] nums, int val) {
        int n = nums.length;
        int left = 0,right = n - 1;
        int count = 0;
        while(left <= right){
            if(nums[right]==val){
                right--;
            }else if(nums[left]==val) {
                nums[left] = nums[right];
                nums[right] = val;
                right--;
            }else{
                count++;
                left++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{3,2,2,3};
        System.out.println(removeElement(nums,3));
    }
}
