package algorithm.sort;

//堆排序法
public class Heap {

    public static void swap(int[] arr, int begin, int end){
        int temp = arr[begin];
        arr[begin] = arr[end];
        arr[end] = temp;
    }

    //参考博客
    public static void heapSort(int[] arr){
        for(int i=arr.length/2-1;i>=0;i--){
            //从第一个非叶子结点从下至上，从右至左调整结构
            adjustHeap(arr,i,arr.length);
        }
        //2.调整堆结构+交换堆顶元素与末尾元素
        for(int j=arr.length-1;j>0;j--){
            swap(arr,0,j);//将堆顶元素与末尾元素进行交换
            adjustHeap(arr,0,j);//重新对堆进行调整
        }
    }

    public static void adjustHeap(int[] arr, int i, int length) {
        int temp = arr[i];//先取出当前元素i
        for(int k=i*2+1;k<length;k=k*2+1){//从i结点的左子结点开始，也就是2i+1处开始
            if(k+1<length && arr[k]<arr[k+1]){//如果左子结点小于右子结点，k指向右子结点
                k++;
            }
            if(arr[k] >temp){//如果子节点大于父节点，将子节点值赋给父节点（不用进行交换）
                arr[i] = arr[k];
                i = k;
            }else{
                break;
            }
        }
        arr[i] = temp;//将temp值放到最终的位置
    }

    //自己写的
    public static void heapSort_second(int[] arr){
        int length = arr.length;
        for(int i=length/2-1; i>=0; i--){
            heapify(arr, i, length);
        }
        while(length>0){
            swap(arr, 0, length-1);
            length--;
            heapify(arr, 0, length);
        }
    }

    public static void heapify(int[] arr, int k, int length){
        while(2*k+1 < length){
            int child = 2*k+1;
            if(child+1<length && arr[child] < arr[child+1]) child++;
            if(arr[k] > arr[child])break;
            swap(arr, k, child);
            k = child;
        }

    }




    public static void print(int[] arr){
        for(int item : arr) System.out.print(item+" ");
        System.out.println();
    }

    //0,9,-1,6,7,3,5,12,46,23,16,38,48,97,54,34,89,-5
    public static void main(String[] args) {
        int[] arr = {0,9,-1,6,7,3,5,12,46,23,16,38,48,97,54,34,89,-5};
        //heapSort(arr);
        heapSort_second(arr);
        print(arr);
    }



}
