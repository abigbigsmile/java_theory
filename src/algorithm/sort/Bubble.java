package algorithm.sort;

//冒泡排序法
public class Bubble {

    public static void swap(int[] arr, int begin, int end){
        int temp = arr[begin];
        arr[begin] = arr[end];
        arr[end] = temp;
    }

    //外层循环优化：若循环一趟后没有进行交换，则表明数组已经是有序
    public static void bubbleSort(int[] arr){
        int n = arr.length;
        boolean isSorted = false;
        for(int i=n-1; i>=0&&!isSorted; i--){
            isSorted = true;
            for(int j=0; j<i; j++){
                if(arr[j]>arr[j+1]){
                    swap(arr, j, j+1);
                    isSorted = false;
                }
            }
        }
    }

    //内层优化：记住交换的最后位置，下一轮遍历从最后位置的前一个开始
    public static void bubbleSort_seconde(int[] arr){
        int n = arr.length;
        int last = 0;
        for(int i=n-1; i>=0; i--){
            for(int j=last; j<i; j++){
                if(arr[j]>arr[j+1]){
                    last = j;
                    swap(arr, j, j+1);
                }
            }
            last = 0;
        }
    }




    public static void print(int[] arr){
        for(int item : arr) System.out.print(item+" ");
        System.out.println();
    }

    public static void main(String[] args) {
        int[] arr = {0,9,-1,6,7,3,5,12,46,23,16,38,48,97,54,34,89,-5};
        //bubbleSort(arr);
        bubbleSort_seconde(arr);
        print(arr);
    }



}

