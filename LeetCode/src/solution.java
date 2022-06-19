import org.junit.Before;
import org.junit.Test;

import java.util.HashSet;
import java.util.List;

public class solution{

    public boolean validPalindrome(String s) {
        int i = 0;
        int j = s.length() - 1;
        int[] ij = new int[]{i, j};
        if (!Palindrome(s, ij)) {
            int[] ij0 = new int[]{ij[0]+1,ij[1]};
            int[] ij1 = new int[]{ij[0],ij[1]-1};
            return Palindrome(s, ij0) || Palindrome(s, ij1);
        }
        return true;
    }
    public boolean Palindrome(String shorter,int[] ij){
        int i =ij[0];
        int j =ij[1];
        while(i<=j){
            if (shorter.charAt(i)!=shorter.charAt(j)){
                ij[0]=i;
                ij[1]=j;
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    public static void main(String[] args) {
        solution solution = new solution();
        System.out.println(solution.validPalindrome("abca"));
        int c=0;


    }


    public void merge(int[] nums1, int m, int[] nums2, int n) {
        // two get pointers for nums1 and nums2
        int p1 = m - 1;
        int p2 = n - 1;
        // set pointer for nums1
        int p = m + n - 1;

        // while there are still elements to compare
        while ((p1 >= 0) && (p2 >= 0))
            // compare two elements from nums1 and nums2
            // and add the largest one in nums1
            nums1[p--] = (nums1[p1] < nums2[p2]) ? nums2[p2--] : nums1[p1--];

        // add missing elements from nums2
        System.arraycopy(nums2, 0, nums1, 0, p2 + 1);
    }

}








