package algorithm.sort;

//插入排序法
public class Insection {

    public static void swap(int[] arr, int begin, int end){
        int temp = arr[begin];
        arr[begin] = arr[end];
        arr[end] = temp;
    }


    public static void insectionSort(int[] arr){
        int n = arr.length;
        for(int i=1; i<=n-1; i++){
            for(int j=i; j>0; j--){
                if(arr[j]<arr[j-1]){
                    swap(arr, j, j-1);
                }
            }

        }
    }
    public static void print(int[] arr){
        for(int item : arr) System.out.print(item+" ");
        System.out.println();
    }

    public static void main(String[] args) {
        int[] arr = {0,9,-1,6,7,3,5,12,46,23,16,38,48,97,54,34,89,-5};
        insectionSort(arr);
        print(arr);
    }



}
