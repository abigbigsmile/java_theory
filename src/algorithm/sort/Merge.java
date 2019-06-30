package algorithm.sort;

import java.util.Arrays;

//归并排序法
public class Merge {

    public static void swap(int[] arr, int begin, int end){
        int temp = arr[begin];
        arr[begin] = arr[end];
        arr[end] = temp;
    }

    public static void merge(int[] arr, int begin, int middle, int end){
        //int[] temp = new int[arr.length];
        //for(int i=begin; i<=end; i++)temp[i] = arr[i];
        int[] temp = Arrays.copyOf(arr, arr.length);
        print(temp);
        int i = begin;
        int j = middle+1;
        for(int k=begin; k<=end; k++){
            if(i > middle){
                arr[k] = temp[j++];
            }else if(j > end){
                arr[k] = temp[i++];
            }else if(temp[i] <= temp[j]){
                arr[k] = temp[i++];
            }else{
                arr[k] = temp[j++];
            }
        }
    }


    public static void mergeSort(int[] arr, int begin, int end){
        if(end <= begin)return ;
        int middle = (begin + end)/2;
        mergeSort(arr, begin, middle);
        mergeSort(arr, middle+1, end);
        merge(arr, begin, middle, end);
    }
    public static void print(int[] arr){
        for(int item : arr) System.out.print(item+" ");
        System.out.println();
    }

    public static void main(String[] args) {
        int[] arr = {0,9,-1,6,7,3,5,12,46,23,16,38,48,97,54,34,89,-5};
        mergeSort(arr, 0, arr.length-1);
        print(arr);
    }



}
