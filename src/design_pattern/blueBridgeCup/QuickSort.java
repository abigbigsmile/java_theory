package design_pattern.blueBridgeCup;


public class QuickSort {

    public static void main(String[] args) {

        int a[] = {49,38,65,97,76,13,27,3,5,1,26};
        System.out.print("before sort:");
        print(a);

        quickSort(a);

        System.out.println("after sort");
        print(a);
    }

    private static void quickSort(int[] a) {
        qsort(a, 0, a.length-1);
    }

    private static void qsort(int[] a, int low, int high) {
        if(low < high){
            int pos = partition(a, low, high);
            qsort(a, low , pos-1);
            qsort(a, pos+1, high);
        }

    }

    //划分数组
    private static int partition(int[] a, int low, int high) {
        int pv = a[low];
        int temp;
        while (low < high){
            while (low < high && a[high] >= pv)high--;
            temp = a[low];
            a[low] = a[high];
            a[high] = temp;
            while(low < high && a[low] <= pv)low++;
            temp = a[low];
            a[low] = a[high];
            a[high] = temp;
        }
        //print(a);
        return low;
    }

    //显示输出数组
    public static void print(int a[]){
        for(int i=0; i<a.length; i++){
            System.out.print(a[i]+" ");
        }
        System.out.println();
    }
}
