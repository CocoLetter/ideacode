import jdk.jfr.StackTrace;
import org.junit.Test;

import java.util.HashMap;

public class FindMedianSortedArrays {


    public double findMedianSortedArrays2(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;
        int left = (n + m + 1) / 2;
        int right = (n + m + 2) / 2;
        //将偶数和奇数的情况合并，如果是奇数，会求两次同样的 k 。
        return (getKth(nums1, 0, n - 1, nums2, 0, m - 1, left) + getKth(nums1, 0, n - 1, nums2, 0, m - 1, right)) * 0.5;
    }

    private int getKth(int[] nums1, int start1, int end1, int[] nums2, int start2, int end2, int k) {
        int len1 = end1 - start1 + 1;
        int len2 = end2 - start2 + 1;
        //让 len1 的长度小于 len2，这样就能保证如果有数组空了，一定是 len1
        if (len1 > len2) return getKth(nums2, start2, end2, nums1, start1, end1, k);
        if (len1 == 0) return nums2[start2 + k - 1];

        if (k == 1) return Math.min(nums1[start1], nums2[start2]);

        int i = start1 + Math.min(len1, k / 2) - 1;
        int j = start2 + Math.min(len2, k / 2) - 1;

        if (nums1[i] > nums2[j]) {
            return getKth(nums1, start1, end1, nums2, j + 1, end2, k - (j - start2 + 1));
        }
        else {
            return getKth(nums1, i + 1, end1, nums2, start2, end2, k - (i - start1 + 1));
        }
    }





    @Test
    public void test(){
        int[] hello=null;
        hello[0]=1;
        System.out.println( hello[0]);
        System.out.println( hello[-1]);


    }


/*
* 给定两个大小为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。

请你找出这两个正序数组的中位数，并且要求算法的时间复杂度为 O(log(m + n))。

你可以假设 nums1 和 nums2 不会同时为空。

 

示例 1:

nums1 = [1, 3]
nums2 = [2]

则中位数是 2.0
示例 2:

nums1 = [1, 2]
nums2 = [3, 4]

则中位数是 (2 + 3)/2 = 2.5

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/median-of-two-sorted-arrays
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。*/


    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int numsLen1=nums1.length;
        int numsLen2=nums2.length;
        int sum=numsLen1+numsLen2;
        int start1=0;
        int start2=0;
        double median=0;
        int left =sum/2;

        //利用排除法删除掉前面sum/2个较小的数字
        while(left>0){
            int skip1=Math.min(start1+Math.max(1,left/2),(numsLen1-1)<0?0:(numsLen1-1))-start1;
            int skip2=Math.min(start2+Math.max(1,left/2),(numsLen2-1)<0?0:(numsLen2-1))-start2;
            start1=Math.min(start1+Math.max(1,left/2),(numsLen1-1)<0?0:(numsLen1-1));
            start2=Math.min(start2+Math.max(1,left/2),(numsLen1-1)<0?0:(numsLen1-1));
            left=left-skip1-skip2;
        }
        if(sum %2==0){
            int nums10=(start1-1)<0?0:nums1[start1-1];
            int nums20=(start2-1)<0?0:nums2[start2-1];
            median=(Math.max(nums10,nums20)+Math.min(nums1[start1],nums2[start2]))*0.5;
        }else{
            median=Math.min(nums1[start1],nums2[start2]);
        }


        return median;

    }


    @Test
    public void hello(){
    int[] a={};
    int[] b={3,6,7,8,56,70,434};
        System.out.println(findMedianSortedArrays(a,b));
    }



    public double findMedianSortedArrays3(int[] nums1, int[] nums2) {
        if(nums1.length>nums2.length){
            int[] temp;
            temp=nums2;
            nums2=nums1;
            nums1=temp;
        }
        int m=nums1.length;
        int n=nums2.length;
        int left=0;
        int right=m;
        int leftTotal=(n+m+1)/2;
        while(left<right){
            int i =left+(right-left+1)/2;
            int j=leftTotal-i;
            if(nums1[i-1]>nums2[j]){
                right=i-1;
            }else{
                left=i;
            }
        }
        int i =left;
        int j =leftTotal-left;

        int nums1LeftMax=i==0?Integer.MIN_VALUE:nums1[i-1];
        int nums1RightMin=i==m?Integer.MAX_VALUE:nums1[i];
        int nums2LeftMax=j==0?Integer.MIN_VALUE:nums2[j-1];
        int nums2RightMin=j==n?Integer.MAX_VALUE:nums2[j];

        if((m+n)%2==0){
            return 0.5*(Math.max(nums1LeftMax,nums2LeftMax)+Math.min(nums1RightMin,nums2RightMin));
        }else{
            return Math.max(nums1LeftMax,nums2LeftMax);
        }
    }

    @Test
    public void test3(){
        int[] a={};
        int[] b={3,6,7,8,56,70,434};
        System.out.println(findMedianSortedArrays3(a,b));
    }





}

//
//
//
//class Solution {
//    public String longestPalindrome(String s) {
////最长回文子串两种情况 镜面对称abba和字母aba
//        int ans=0;
//        HashMap<Integer,String> map=new HashMap<>();
//
//        for( int i =0 ;i<s.length();i++){
//            if(checkNegative1(i,s)){
//                checkNegative2()
//            }
//        }
//
//
//
//
//    }
//
//    public boolean check(int index,String s,int ans){
//        return
//        ans=1;
//        if(ans==1){
//            return checkN
//            return s.charAt(index)==s.charAt(index-1);
//        }
//
//    }
//    public boolean checkNegative2(int index,String s){
//        return s.charAt(index)==s.charAt(index-2);
//    }
//}
//
//
//
//
//public class Solution {
//
///*
//时间复杂度：O(N^{2}) O(N 2 )。
//空间复杂度：O(N^{2})O(N 2 )，
// */
//    public String longestPalindrome(String s) {
//        // 特判
//        int len = s.length();
//        if (len < 2) {
//            return s;
//        }
//
//        int maxLen = 1;
//        int begin = 0;
//
//        // dp[i][j] 表示 s[i, j] 是否是回文串
//        boolean[][] dp = new boolean[len][len];
//        char[] charArray = s.toCharArray();
//
//        for (int i = 0; i < len; i++) {
//            dp[i][i] = true;
//        }
//        for (int j = 1; j < len; j++) {
//            for (int i = 0; i < j; i++) {
//                if (charArray[i] != charArray[j]) {
//                    dp[i][j] = false;
//                } else {
//                    if (j - i < 3) {
//                        dp[i][j] = true;
//                    } else {
//                        dp[i][j] = dp[i + 1][j - 1];
//                    }
//                }
//
//                // 只要 dp[i][j] == true 成立，就表示子串 s[i..j] 是回文，此时记录回文长度和起始位置
//                if (dp[i][j] && j - i + 1 > maxLen) {
//                    maxLen = j - i + 1;
//                    begin = i;
//                }
//            }
//        }
//        return s.substring(begin, begin + maxLen);
//    }
//
//
//
//
//    public class Solution {
//
//        public String longestPalindrome(String s) {
//            int len = s.length();
//            if (len < 2) {
//                return s;
//            }
//            int maxLen = 1;
//            String res = s.substring(0, 1);
//            // 中心位置枚举到 len - 2 即可
//            for (int i = 0; i < len - 1; i++) {
//                String oddStr = centerSpread(s, i, i);
//                String evenStr = centerSpread(s, i, i + 1);
//                String maxLenStr = oddStr.length() > evenStr.length() ? oddStr : evenStr;
//                if (maxLenStr.length() > maxLen) {
//                    maxLen = maxLenStr.length();
//                    res = maxLenStr;
//                }
//            }
//            return res;
//        }
//
//        private String centerSpread(String s, int left, int right) {
//            // left = right 的时候，此时回文中心是一个字符，回文串的长度是奇数
//            // right = left + 1 的时候，此时回文中心是一个空隙，回文串的长度是偶数
//            int len = s.length();
//            int i = left;
//            int j = right;
//            while (i >= 0 && j < len) {
//                if (s.charAt(i) == s.charAt(j)) {
//                    i--;
//                    j++;
//                } else {
//                    break;
//                }
//            }
//            // 这里要小心，跳出 while 循环时，恰好满足 s.charAt(i) != s.charAt(j)，因此不能取 i，不能取 j
//            return s.substring(i + 1, j);
//        }
//    }
//
//}
//
//
//
//
//
//
