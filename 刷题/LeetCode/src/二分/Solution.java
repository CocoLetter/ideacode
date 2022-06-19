package 二分;

import javax.swing.tree.TreeNode;
import java.util.ArrayList;
import java.util.Arrays;

import java.util.*;


import java.util.*;
import java.util.stream.Collectors;

import static javax.swing.UIManager.put;

class Solution57675 {
    public static void main(String[] args) {
        Solution57675 solution57675 = new Solution57675();
        ArrayList<String> list = new ArrayList<>();
        Collections.sort(list,String::compareTo);

        System.out.println(solution57675.lengthOfLIS(new int[]{1, 2, -10, -8, -7}));
    }
    public int lengthOfLIS(int[] nums) {
        /**
         dp[i]: 所有长度为i+1的递增子序列中, 最小的那个序列尾数.
         由定义知dp数组必然是一个递增数组, 可以用 maxL 来表示最长递增子序列的长度.
         对数组进行迭代, 依次判断每个数num将其插入dp数组相应的位置:
         1. num > dp[maxL], 表示num比所有已知递增序列的尾数都大, 将num添加入dp
         数组尾部, 并将最长递增序列长度maxL加1
         2. dp[i-1] < num <= dp[i], 只更新相应的dp[i]
         */

        int len = nums.length;
        int[] dp = new int[len+1];
        dp[1] = nums[0];
        int cur = 1;
        for(int i = 1;i < len; i++){
            if(nums[i]>dp[cur]) dp[++cur] = nums[i];
            else{
                int lo = 0,hi = cur;
                while(lo<hi){
                    int mid = lo+(hi-lo)/2;
                    if(dp[mid]>=nums[i]){
                        hi = mid ;
                    }else{
                        lo = mid + 1;
                    }
                }
                dp[lo] = nums[i];
            }
        }
        return cur;
    }
}




class Finder {

    public static void main(String[] args) {
        Finder finder = new Finder();
        int[] ints = {1332802, 1177178, 1514891, 871248, 753214, 123866, 1615405, 328656, 1540395, 968891, 1884022, 252932, 1034406, 1455178, 821713, 486232, 860175, 1896237, 852300, 566715, 1285209, 1845742, 883142, 259266, 520911, 1844960, 218188, 1528217, 332380, 261485, 1111670, 16920, 1249664, 1199799, 1959818, 1546744, 1904944, 51047, 1176397, 190970, 48715, 349690, 673887, 1648782, 1010556, 1165786, 937247, 986578, 798663};
        int[] table = new int[]{1, 3, 5, 3, 33, 4, 56, 566, 65, 43, 343, 2, 2};
        quickSort(ints, 0, ints.length-1, 24);
    }


    public int partition(int[] nums, int left, int right) {
        int pivot = nums[left];
        int j = left;
        for (int i = left + 1; i <= right; i++) {
            if (nums[i] < pivot) {
                // 小于 pivot 的元素都被交换到前面
                j++;
                swap(nums, j, i);
            }
        }
        // 在之前遍历的过程中，满足 [left + 1, j] < pivot，并且 (j, i] >= pivot
        swap(nums, j, left);
        // 交换以后 [left, j - 1] < pivot, nums[j] = pivot, [j + 1, right] >= pivot
        return j;
    }


    private void swap(int[] nums, int index1, int index2) {
        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
    }


    public static void quickSort(int[] a, int left, int right, int k) {
        if (left <= right) {
            int i = left;
            int j = right;
            int x = a[left];
            while (i < j) {
                while (i < j && a[j] > x) {
                    j--;
                }
                if (i < j)
                    a[i++] = a[j];
                while (i < j && a[i] < x) {
                    i++;
                }
                if (i < j)
                    a[j--] = a[i];
            }
            a[i] = x;
            if (i == k - 1) return ;
            else if (i < k - 1) {
                quickSort(a, i + 1, right, k);
            } else {
                quickSort(a, left, i - 1, k);
            }
        }
    }
}


class Finder23535 {
    public int findKth(int[] a, int n, int K) {
        // write code here
        return findK(a, 0, n - 1, K);
    }

    public static int partition(int[] arr, int left, int right) {
        int pivot = arr[left];

        while (left < right) {
            while (left < right && arr[right] <= pivot) {
                right--;
            }
            arr[left] = arr[right];
            while (left < right && arr[left] >= pivot) {
                left++;
            }
            arr[right] = arr[left];
        }
        arr[left] = pivot;
        return left;
    }

    public static int findK(int[] arr, int left, int right, int k) {
        if (left <= right) {
            int pivot = partition(arr, left, right);

            if (pivot == k - 1) {
                return arr[pivot];
            } else if (pivot < k - 1) {
                return findK(arr, pivot + 1, right, k);
            } else {
                return findK(arr, left, pivot - 1, k);
            }
        }
        return -1;
    }
}


class Finder235235 {
    int res = 0;

    public int findKth(int[] a, int n, int K) {
        // write code here
        quickSort(a, 0, n - 1, K);
        return res;
    }

    public void quickSort(int[] a, int left, int right, int k) {
        int i = left;
        int j = right;
        int x = a[left];
        while (i < j) {
            while (i < j && a[j] > x) {
                j--;
            }
            a[i++] = a[j];
            while (i < j && a[i] < x) {
                i++;
            }
            a[j--] = a[i];
        }
        a[i] = x;
        if (i == k - 1) res = a[i];
        else if (i < k - 1) {
            quickSort(a, i + 1, right, k);
        } else {
            quickSort(a, left, i - 1, k);
        }


    }
}

class Solution453463 {
    public String complexNumberMultiply(String a, String b) {
        String[] split_a = a.split("\\+");
        String[] split_b = b.split("\\+");
        int m = converse(split_a[0]);
        int n = converse(split_b[0]);
        int p = (split_a[1].charAt(0) == '-') ? -converse(split_a[1].substring(1, split_a[1].length() - 1)) : converse(split_a[1].substring(0, split_a[1].length() - 1));
        int q = (split_b[1].charAt(0) == '-') ? -converse(split_b[1].substring(1, split_b[1].length() - 1)) : converse(split_b[1].substring(0, split_b[1].length() - 1));
        int res = m * n - p * q;
        int res_i = m * q + n * p;
        return "" + res + "+" + res_i + "i";
    }

    public int converse(String str) {
        int m = 0;
        for (int i = 0; i <= str.length() - 1; i++) {
            m = m * 10 + m - '0';
        }
        return m;
    }
}


public class Solution {
    public ArrayList<Integer> spiralOrder(int[][] matrix) {
        ArrayList<Integer> list = new ArrayList<>();
        int row = matrix.length;
        if (row == 0) return list;
        int col = matrix[0].length;
        int left = 0;
        int right = col - 1;
        int up = 0;
        int down = row - 1;
        int i = 0, j = 0;
        while (list.size() < row * col) {
            while (j != right) {
                list.add(matrix[i][j]);
                j++;
            }
            up++;
            while (i != down) {
                list.add(matrix[i][j]);
                i++;
            }
            right--;
            while (j != left) {
                list.add(matrix[i][j]);
                j--;
            }
            down--;
            while (i != up) {
                list.add(matrix[i][j]);
                i--;
            }
            left++;
        }
        return list;
    }
}


//[2,1,5,3,6,4,8,9,7]





