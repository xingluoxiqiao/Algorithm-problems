package 代码随想录.day7;

import 代码随想录.Utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class threeSum {
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        for(int i = 0; i < nums.length - 2; i++){
            if(nums[i] > 0) return res;
            //对第一个数去重，这里的去重逻辑是nums中的每个元素只能用一次，并且结果集不能有相同的元素
            //循环和双指针保证了前者，后者单独处理
            if(i > 0 && nums[i] == nums[i-1]) continue;
            int left = i + 1,right = nums.length - 1;
            while(left < right){
                int sum = nums[i]+nums[left]+nums[right];
                if(sum > 0) right--;
                else if(sum < 0) left++;
                else{
                    res.add(List.of(nums[i],nums[left],nums[right]));
                    //收集到一个结果集后，对另外两个数去重
                    while(right > left && nums[right] == nums[right-1]) right--;
                    while(right > left && nums[left] == nums[left+1]) left++;
                    left++;
                    right--;
                }

            }
        }
        return res;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        int[] nums = Utils.StringToIntArray(input);
        StringBuilder sb = new StringBuilder();
        sb.append("[[");
        List<List<Integer>> res = threeSum(nums);
        for(int m = 0; m < res.size(); m++){
            for(int i = 0; i < res.get(m).size(); i++){
                if(i == res.get(m).size() - 1) sb.append(res.get(m).get(i));
                else sb.append(res.get(m).get(i)).append(",");
            }
            if(m < res.size()-1){
                sb.append("],[");
            }
        }
        sb.append("]]");
        System.out.println(sb.toString());
    }
}
