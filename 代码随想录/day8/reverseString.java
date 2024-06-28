package 代码随想录.day8;

public class reverseString {
    public void reverseString(char[] s) {
        int left = 0, right = s.length - 1;
        char temp;
        while(left <= right){
            temp = s[left];
            s[left] = s[right];
            s[right] = temp;
            left++;
            right--;
        }
    }
}
