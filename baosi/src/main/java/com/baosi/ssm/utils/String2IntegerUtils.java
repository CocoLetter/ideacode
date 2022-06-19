package com.baosi.ssm.utils;

public class String2IntegerUtils {

    public static void main(String[] args) {

        String[] str = new String[]{"123","2","10"};
        int[] arr1 = String2Int(str);
        for (int i : arr1) {
            System.out.println(i);
        }
    }

    //将String数组转换为int数组
    public static int[] String2Int(String[] str) {
        int len = str.length;
        int[] arr = new int[len]; //新建一个同等长度的int[]
        for (int i = 0; i < len; i++) {
            arr[i] = Integer.parseInt(str[i]); //循环遍历
        }
        return arr;
    }
}
