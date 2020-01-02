package com.javanorth.datastruct.sort;

public class QuickSort1 {
    public static void Swap(int[] A, int i, int j) {
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }

    //从两端扫描交换的方式
    public static int quickSort1(int[] A, int L, int R){
        int pivot = A[L];//最左边的元素作为中轴，L表示left, R表示right
        int i = L+1, j = R;
        //当i == j时，i和j同时指向的元素还没有与中轴元素判断，
        //小于等于中轴元素，i++,大于中轴元素j--,
        //当循环结束时，一定有i = j+1, 且i指向的元素大于中轴，j指向的元素小于等于中轴
        while(i <= j){
            while(i <= j && A[i] <= pivot){
                i++;
            }
            while(i <= j && A[j] > pivot){
                j--;
            }
            //当 i > j 时整个切分过程就应该停止了，不能进行交换操作
            //这个可以改成 i < j， 这里 i 永远不会等于j， 因为有上述两个循环的作用
            if(i <= j){
                Swap(A, i, j);
                i++;
                j--;
            }
        }
        //当循环结束时，j指向的元素是最后一个（从左边算起）小于等于中轴的元素
        Swap(A, L, j);//将中轴元素和j所指的元素互换

        for (int x = 0; x < A.length; x++) {
            System.out.print(A[x] + " ");
        }
        System.out.println();

        return j;
    }

    public static void quickSort(int[] A, int L, int R) {


        if(L < R){//递归的边界条件，当 L == R时数组的元素个数为1个

            int j = quickSort1(A, L, R);

            quickSort(A, L, j-1);//递归左半部分
            quickSort(A, j+1, R);//递归右半部分
        }
    }

    public static void main(String[] args) {
        int[] x = {46,74,53,14,26,38,86,65,27,34};
//        int[] x = { 72, 6, 57, 88, 60, 42, 83, 73, 48, 85 };
        quickSort(x, 0, x.length-1);
//        for (int i = 0; i < x.length; i++) {
//            System.out.print(x[i] + " ");
//        }
//        System.out.println();
    }
}
