package algorithm.sort;

//选择排序法
public class Selectioin {

    public static void swap(int[] arr, int begin, int end){
        int temp = arr[begin];
        arr[begin] = arr[end];
        arr[end] = temp;
    }

    public static void selectionSort(int[] arr){
        int n = arr.length;
        int min;
        for(int i=0; i<=n-1; i++){
            min = i;
            for(int j=i; j<=n-1; j++){
                if(arr[j]<arr[min]){
                    min = j;
                }
            }
            swap(arr, i, min);
        }
    }
    public static void print(int[] arr){
        for(int item : arr) System.out.print(item+" ");
        System.out.println();
    }

    public static void main(String[] args) {
        int[] arr = {0,9,-1,6,7,3,5,12,46,23,16,38,48,97,54,34,89,-5};
        selectionSort(arr);
        print(arr);
    }



}
