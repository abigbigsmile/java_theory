package algorithm.sort;

//希尔排序法
public class Shell {

    public static void swap(int[] arr, int begin, int end){
        int temp = arr[begin];
        arr[begin] = arr[end];
        arr[end] = temp;
    }

    public static void shellSort(int[] arr){
        int n = arr.length;
        int k=n/2;
        while(k>=1){
            for(int i=k; i<n; i++){
                for(int j=i; j>=k; j-=k){
                    if(arr[j]<arr[j-k]){
                        swap(arr, j, j-k);
                    }
                }
            }
            k = k/2;
        }
    }

    //更改步长
    public static void shellSort_second(int[] arr){
        int n = arr.length;
        int k = 1;
        while(k<n/5)k = 5*k+1;
        while(k>=1){
            for(int i=k; i<n; i++){
                for(int j=i; j>=k; j-=k){
                    if(arr[j]<arr[j-k]){
                        swap(arr, j, j-k);
                    }
                }
            }
            k = k/5;
        }
    }


    public static void print(int[] arr){
        for(int item : arr) System.out.print(item+" ");
        System.out.println();
    }

    public static void main(String[] args) {
        int[] arr = {0,9,-1,6,7,3,5,12,46,23,16,38,48,97,54,34,89,-5};
        //shellSort(arr);
        shellSort_second(arr);
        print(arr);
    }



}
