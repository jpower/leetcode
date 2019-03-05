package com.wmh.sort;

/**
 * 基数排序
 * Created by 周大侠
 * 2019-02-22 18:29
 */
public class RadixSort {
    public void radixSort(int[] array) {
        int max = getMax(array);
        int bit = 1;
        while(max / bit > 0) {
            radix(array, bit);
            bit *= 10;
        }
    }
    private void radix(int[] array, int bit) {
        int[] temp = new int[array.length];
        int[] bucket = new int[10];
        for(int i = 0; i < array.length; i++) {
            bucket[(array[i] / bit) % 10]++;
        }
        for(int i = 1; i < bucket.length; i++) {
            bucket[i] += bucket[i-1];
        }
        for(int i = array.length - 1; i >= 0; i--) {
            temp[bucket[(array[i] / bit) % 10] - 1] = array[i];
            bucket[(array[i] / bit) % 10]--;
        }
        for(int i = 0; i < temp.length; i++) {
            array[i] = temp[i];
        }
    }

    private int getMax(int[] array) {
        int max = array[0];
        for(int i = 1; i < array.length; i++){
            if(array[i] > max) {
                max = array[i];
            }
        }
        return max;
    }
    public static void main(String[] args) {
        int[] array = {0,2,11,3,1,5,9,8,7};
        new RadixSort().radixSort(array);
        for (int i : array) {
            System.out.println(i);
        }
    }
}
