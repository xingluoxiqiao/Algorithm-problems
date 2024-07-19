package 代码随想录.day06;

import 代码随想录.Utils;

import java.util.*;

public class intersection {
    public static int[] intersection(int[] nums1, int[] nums2) {
        int[] record = new int[1000];
        for(int i = 0; i < nums1.length; i++){
            record[nums1[i]]++;
        }
        Set<Integer> set = new HashSet<>();
        for(int i = 0; i < nums2.length; i++){
            if(record[nums2[i]]>0) {
                set.add(nums2[i]);
                record[nums2[i]]--;
            }
        }
        int[] res = new int[set.size()];
        int count = 0;
        for(int every : set){
            if(count >= set.size()) break;
            res[count] = every;
            count++;
        }
        return res;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] nums1 = Utils.StringToIntArray(sc.nextLine());
        int[] nums2 = Utils.StringToIntArray(sc.nextLine());
        int[] res = intersection(nums1,nums2);
        System.out.println(Arrays.toString(res));
    }


}
