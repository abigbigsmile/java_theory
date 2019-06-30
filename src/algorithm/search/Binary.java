package algorithm.search;

import java.util.Arrays;

public class Binary {

    public static void main(String[] args) {
        int[] arr = {0,9,-1,6,7,3,5,12,46,23,16,38,48,97,54,34,89,-5};
        Arrays.sort(arr);
        print(arr);
        //int pos = binarySearch_recursive(arr, -1, 0, arr.length-1);
        int pos = binarySearch(arr, -1, 0, arr.length-1);
        System.out.println("position:" + pos);
    }

    public static void print(int[] arr){
        for(int item : arr) System.out.print(item+" ");
        System.out.println();
    }

    //递归的二分查找
    public static int binarySearch_recursive(int[] arr, int key, int begin, int end){
        if(begin >= end)return -1;
        int mid = (begin+end)/2;
        if(arr[mid] == key)return mid;
        else if(arr[mid] > key)return binarySearch_recursive(arr, key, begin, mid-1);
        else return binarySearch_recursive(arr, key, mid+1, end);
    }

    public static int binarySearch(int[] arr, int key, int begin, int end){
        while(begin<end){
            int mid = (begin+end)/2;
            if(arr[mid] == key)return mid;
            else if(arr[mid] > key){
                end = mid-1;
            }else{
                begin = mid+1;
            }
        }
        return -1;
    }
}


