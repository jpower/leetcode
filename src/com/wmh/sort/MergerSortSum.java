package com.wmh.sort;

import org.junit.Test;

/**
 * 使用归并排序求小和
 * Created by 周大侠
 * 2019-02-01 23:22
 */
public class MergerSortSum {

    public int mergerSortSum(int[] arr) {
        return mergerSortSum(arr, 0, arr.length - 1);
    }


    private int mergerSortSum(int[] arr, int left, int right) {
        if (left == right) {
            return 0;
        }
        int middle = left + ((right - left) >> 1);
        return mergerSortSum(arr, left, middle) +
                mergerSortSum(arr, middle + 1, right) +
                merger(arr, left, middle, right);

    }


    private int merger(int[] arr, int left, int middle, int right) {
        int[] temp = new int[right - left + 1];
        int l = left;
        int r = middle + 1;
        int t = 0;
        int result = 0;
        while (l <= middle && r <= right) {
//            if (arr[l] < arr[r]) {
//                result += arr[l] * (right - r + 1);
//                temp[t++] = arr[l++];
//            } else {
//                temp[t++] = arr[r++];
//            }
            result += arr[l] < arr[r] ? arr[l] * (right - r + 1) : 0;
            temp[t++] = arr[l] < arr[r] ? arr[l++] : arr[r++];
        }
        while (l <= middle) {
            temp[t++] = arr[l++];
        }
        while (r <= right) {
            temp[t++] = arr[r++];
        }
        t = 0;
        while (left <= right) {
            arr[left++] = temp[t++];
        }
//        for (int i = 0; i < temp.length; i++) {
//            arr[left++] = temp[i];
//        }

        return result;
    }

    @Test
    public void fun1() {
        int[] a = {1, 2, 3, 4, 324, 123, 657, 9};
        System.out.println(mergerSortSum(a));
        for (int i : a) {
            System.out.println(i);
        }

    }

}
