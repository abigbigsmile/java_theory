package design_pattern.strategy_designpattern;

public class Main {

    public static void main(String[] args) {
        //int[] a = {5, 7, 9, 4 ,6};
        Cat[] cats = {new Cat(13, 13), new Cat(11,11),new Cat(26,26), new Cat(16,16)};
        DataSorter.sort(cats);
        DataSorter.print(cats);
    }
}
