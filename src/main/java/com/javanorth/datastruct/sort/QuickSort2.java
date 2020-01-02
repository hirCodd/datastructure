package com.javanorth.datastruct.sort;

public class QuickSort2 {
    static int count = 0;

    private static int partition(int[] array,int low,int high){
        int pivot = array[low];
//        System.out.print("pivot:" + pivot);


        while(low<high){
            while(low<high && array[high]>=pivot){  //从右端开始扫描，定位到第一个比pivot小的元素
                high--;  //如果array[high]比基准pivot大，就不管，继续向前移动
            }
            array[low] = array[high];  //如果array[high]比基准pivot小，就交换low和high

            while(low<high && array[low]<=pivot){  //从左端开始扫描，定位到第一个比pivot大的元素
                low++;    //如果array[low]比基准pivot小，就不管，继续向后移动
            }
            array[high] = array[low];  //如果array[low]比基准pivot大，就交换low和high
        }

        array[low] = pivot;
        return low;

    }
    public static void QuickSort(int[] array, int low, int high) {
        if(low < high){
            count++;
            System.out.print(" count:" + count + " 排序完成：");
            for (int i = 0; i < 10; i++) {
                System.out.print(array[i] + " ");
            }
            System.out.println();
            int local = partition(array, low, high);
            QuickSort(array, low, local-1);
            QuickSort(array, local+1, high);
        }
    }

    public static void main(String[] args) {
//        int[] x = {20,15,14,18,21,36,40,10};
//        int[] x = {46,74,53,14,26,38,86,65,27,34};
        int[] x = {13,17,2,5,11,23,15,9,12,1};
//        int[] x = { 72, 6, 57, 88, 60, 42, 83, 73, 48, 85 };
        QuickSort(x, 0, x.length-1);

    }
}
