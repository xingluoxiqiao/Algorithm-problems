package 笔试.B站;

import java.util.Objects;
import java.util.Scanner;

/**
 * 小红拿到了两个长度为 n 的数组 a 和 b，她仅可以执行一次以下翻转操作：
 * 选择a数组中的一个区间[i, j]，（i != j)，将它们翻转。
 * 例如，对于 a = [2,3,4,1,5,6]，小红可以选择左闭右闭区间[2,4]，数组 a 则变成[2,3,5,1,4,6]。
 * 小红希望操作后 a 数组和 b 数组完全相同。请你告诉小红有多少种操作的方案数。
 * 初始 a 数组和 b 数组必定不相同。
 *
 *输入：
 * 4
 * 1 2 3 1
 * 1 3 2 1
 *输出：
 * 2
 */

public class reverse {
    private boolean canReverse(String[] a,String[] b,int left,int right){
        for(int i = left, j = right; i <= right; i++,j--){
            if(!Objects.equals(a[j], b[i])) return false;
        }
        // 检查翻转区间外的值是否匹配
        for (int i = 0; i < left; i++) {
            if (!Objects.equals(a[i], b[i])) {
                return false;
            }
        }
        for (int i = right + 1; i < a.length; i++) {
            if (!Objects.equals(a[i], b[i])) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        String[] nums1 = sc.nextLine().split(" ");
        String[] nums2 = sc.nextLine().split(" ");
        // 遍历所有可能的区间
        int count = 0;
        reverse reverse = new reverse();
        for (int left = 0; left < n; left++) {
            for (int right = left; right < n; right++) {
                // 检查翻转区间 [left, right] 后，a 是否可以变成 b
                if (reverse.canReverse(nums1, nums2, left, right)) {
                    count++;
                }
            }
        }
        System.out.println(count);

    }
}
