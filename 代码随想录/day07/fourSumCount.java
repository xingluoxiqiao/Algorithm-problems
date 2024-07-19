package 代码随想录.day07;

import 代码随想录.Utils;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class fourSumCount {
    public static int fourSumCount2(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        int res = 0;
        int len = nums1.length;
        for(int i = 0; i < len; i++){
            for(int j = 0; j < len; j++){
                for(int k = 0; k < len; k++){
                    for(int l = 0; l < len; l++){
                        if(nums1[i]+nums2[j]+nums3[k]+nums4[l]==0){
                            res++;
                        }
                    }
                }
            }
        }
        return res;
    }

    public static int fourSumCountByHash(int[] nums1, int[] nums2, int[] nums3, int[] nums4){
        int len = nums1.length;
        Map<Integer,Integer> map1 = new HashMap<>();
        Map<Integer,Integer> map2 = new HashMap<>();
        for(int i = 0; i < len; i++){
            for(int j = 0; j < len; j++){
                map1.put(nums1[i]+nums2[j],map1.getOrDefault(nums1[i]+nums2[j],0)+1);
            }
        }
        for(int i = 0; i < len; i++){
            for(int j = 0; j < len; j++){
                map2.put(nums3[i]+nums4[j],map2.getOrDefault(nums3[i]+nums4[j],0)+1);
            }
        }
        int res = 0;
        for(Map.Entry entry1 : map1.entrySet()){
            for(Map.Entry entry2 : map2.entrySet()){
                if((int)entry1.getKey() + (int)entry2.getKey() == 0){
                    res += (int)entry1.getValue() * (int)entry2.getValue();
                }
            }
        }
        return res;
    }
    public static int fourSumCountByHash2(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        int res = 0;
        Map<Integer,Integer> map = new HashMap<>();
        for(int i : nums1){
            for(int j : nums2){
                int sum = i + j;
                map.put(sum,map.getOrDefault(sum,0)+1);
            }
        }
        for(int i : nums3){
            for(int j : nums4){
                int sum = i + j;
                res += map.getOrDefault(0 - sum, 0);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        String[] parse = input.replaceAll("nums[1-4] =","").trim().split(", ");
        int[] nums1 = Utils.StringToIntArray(parse[0]);
        int[][] arg = new int[4][nums1.length];
        for(int i = 0; i < parse.length; i++){
            arg[i] = Utils.StringToIntArray(parse[i].trim());
        }
        System.out.println(fourSumCountByHash2(arg[0],arg[1],arg[2],arg[3]));
    }

}
