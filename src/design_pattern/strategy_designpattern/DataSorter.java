package design_pattern.strategy_designpattern;

//排序器
public class DataSorter {

    public static void sort(Object[] a){
        for(int i=a.length-1; i>=0; i--){
            for(int j=0; j<i; j++){
                Comparable o1 = (Comparable)a[j];
                Comparable o2 = (Comparable)a[j+1];
                if(o1.compareTo(o2) == 1){
                    swap(a, j, j+1);
                }
            }
        }
    }

    private static void swap(Object[] a, int x, int y) {
        Object temp = a[x];
        a[x] = a[y];
        a[y] = temp;
    }

    public static void print(Object[] a) {
        for(int i=0; i<a.length; i++) System.out.print(a[i]+" ");
    }
}
