package algorithm.sort;

import java.util.Stack;

//快速排序法
public class Quick {

    public static void swap(int[] arr, int begin, int end){
        int temp = arr[begin];
        arr[begin] = arr[end];
        arr[end] = temp;
    }

    public static void quickSort(int[] arr, int begin, int end){
        if(begin >= end)return;
        //int pivot = partition(arr, begin, end);
//        int pivot = partition_second(arr, begin, end);
        int pivot = partition2(arr, begin, end);
        quickSort(arr, begin, pivot-1);
        quickSort(arr, pivot+1, end);
    }
/* 递归方式 */
    //挖坑法
    private static int partition(int[] arr, int begin, int end) {
        int pivot = arr[begin];
        while(begin < end){
            while(begin < end && pivot <= arr[end])end--;
            if(begin < end)arr[begin++] = arr[end];
            while(begin < end && pivot > arr[begin])begin++;
            if(begin < end)arr[end--] = arr[begin];
        }
        arr[begin] = pivot;
        return begin;
    }

    //左右指针法
    public static int partition2(int[] arr, int begin, int end){
        int temp = begin;
        int key = arr[begin];
        while(begin < end){
//            print(arr);
            while(begin < end && arr[end] >= key)end --;
            while(begin < end && arr[begin] <= key) begin ++;
            swap(arr, begin, end);
        }
        swap(arr, temp, end);
        return end;
    }


    //使用三向切分进行快速排序
    public static void quickSort_triple_partition(int[] arr, int begin, int end){
        if(begin >= end)return;
        int i = begin, j = end;
        int index = begin + 1;
        int key = arr[begin];
        while(index <= end){
            //print(arr);
            int flag = (arr[index]<key)? -1:1;
            if(flag < 0){
                swap(arr, begin, index);
                begin++;
                index++;
            }else if(flag > 0){
                swap(arr, index, end);
                end--;
            }else{
                index++;
            }
        }
        quickSort_triple_partition(arr, i, index-1);
        quickSort_triple_partition(arr, index, j);
    }

    /* 非递归 */
    public static void quickSort_nonRecursive(int[] arr, int begin, int end){
        Stack stack = new Stack();
        stack.push(begin);
        stack.push(end);
        while(!stack.isEmpty()){
            end = (int)stack.pop();
            begin = (int)stack.pop();
            if(begin < end){
                int pivot = partition2(arr, begin, end);
                if(begin < pivot-1){
                    stack.push(begin);
                    stack.push(pivot-1);
                }
                if(end > pivot+1){
                    stack.push(pivot+1);
                    stack.push(end);
                }
            }
        }
    }

    //基于切分的快速选择算法
    public static int quickSelect(int[] arr, int k){
        int begin = 0;
        int end = arr.length - 1;
        while(begin < end){
            int t = partition2(arr, begin, end);
            if(t == k)return arr[t];
            else if(t > k){
                end = t - 1;
            }else{
                begin = t + 1;
            }
        }
        return arr[k];
    }



    public static void print(int[] arr){
        for(int item : arr) System.out.print(item+" ");
        System.out.println();
    }

    //-5 -1 0 3 5 6 7 9 12 16 23 34 38 46 48 54 89 97
    public static void main(String[] args) {
        int[] arr = {0,9,-1,6,7,3,5,12,46,23,16,38,48,97,54,34,89,-5};
        //quickSort(arr, 0, arr.length-1);
        //quickSort_nonRecursive(arr, 0, arr.length-1);
        //System.out.println(quickSelect(arr, 17)); //基于切分的快速选择算法，找出数组中第k大的元素
        quickSort_triple_partition(arr, 0, arr.length-1);
        print(arr);

    }



}
