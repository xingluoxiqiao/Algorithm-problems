package 代码随想录.day7;

import 代码随想录.Utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class fourSum {
    public static List<List<Integer>> fourSum1(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        for(int i = 0; i< nums.length-3; i++){
            if(i > 0 && nums[i] == nums[i-1]) continue;
            for(int j = i + 1; j < nums.length-2;j++){
                if (j > i + 1 && nums[j - 1] == nums[j]) {  // 对nums[j]去重
                    continue;
                }
                if(nums[j] == nums[j-1]) continue;
                int left = j + 1, right = nums.length - 1;
                while(left < right){
                    int sum = nums[i] + nums[j] + nums[left] + nums[right];
                    if(sum > target) right--;
                    else if(sum < target) left++;
                    else {
                        res.add(List.of(nums[i],nums[j],nums[left],nums[right]));
                        while(left < right && nums[left+1] == nums[left]) left++;
                        while(left < right && nums[right-1] == nums[right]) right--;
                        left++;
                        right--;
                    }
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] nums = Utils.StringToIntArray(sc.nextLine());
        int target = sc.nextInt();
        StringBuilder sb = new StringBuilder();
        sb.append("[[");
        List<List<Integer>> res = fourSum1(nums,target);
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
