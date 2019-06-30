package algorithm.sort;

import java.util.Arrays;

//计数排序法，主要用于排序非负数，而且数值相差不大的数组
public class Count {

    public static void swap(int[] arr, int begin, int end){
        int temp = arr[begin];
        arr[begin] = arr[end];
        arr[end] = temp;
    }

    public static void countSort(int[] arr){
        int length = arr.length;
        int min=arr[0], max=arr[0];
        for(int i=0; i<arr.length; i++){
            if(arr[i] < min)min=arr[i];
            if(arr[i] > max)max=arr[i];
        }
        int[] a = new int[max+1];
        for(int i=0; i<arr.length; i++){
            a[arr[i]]++;
        }
        arr = Arrays.copyOf(a, a.length);
    }
    public static void print(int[] arr){
        for(int item : arr) System.out.print(item+" ");
        System.out.println();
    }

        public static void countSort(int[] array, int range){
            if (array.length <= 1) {
                return;
            }

            int[] countArray = new int[range + 1];
            for (int i = 0; i < array.length; i++) {
                int value = array[i];
                countArray[value] += 1;
            }

            //这一步是用来找位置的
            for (int i = 1; i < countArray.length; i++) {
                countArray[i] += countArray[i - 1];
            }

            int[] temp = new int[array.length];
            for (int i = array.length - 1; i >= 0; i--) {
                int value = array[i];
                int position = countArray[value] - 1;

                temp[position] = value;
                countArray[value] -= 1;
            }

            for (int i = 0; i < array.length; i++) {
                array[i] = temp[i];
            }
        }


    public static void main(String[] args) {
        int[] arr = {0,9,6,7,3,5,12,46,23,16,38,48,97,54,34,89};
        //countSort(arr);
       // print(arr);
        countSort(arr, 97);
        print(arr);

    }



}
