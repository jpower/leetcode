package com.wmh.sort;

/**
 * 桶排序
 * Created by 周大侠
 * 2019-02-22 21:37
 */
public class BucketSort {
    public static void main(String[] args) {
        int[] a = {1,23,45,12,56,22,2};
        bucketSort(a);
        for (int i : a) {
            System.out.println(i);
        }
    }
    public static void bucketSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        //常用写法
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            max = arr[i] > max ? arr[i] : max;
        }

        int[] bucket = new int[max + 1];

        for (int i = 0; i < arr.length; i++) {
            //桶数组此下标有数据，数值就加一
            bucket[arr[i]]++;
        }

        int i = 0;

        for (int j = 0; j < bucket.length; j++) {
            while (bucket[j]-- > 0) {
                arr[i++] = j;
            }
        }
    }
}