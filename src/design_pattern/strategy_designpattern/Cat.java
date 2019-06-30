package design_pattern.strategy_designpattern;

public class Cat implements Comparable{
    private int height;
    private int weight;
//    private Comparator catHeightComparator = new CatHeightComparator();
    private Comparator catWeightComparator = new CatWeightComparator();

    public Cat(int height) {
        this.height = height;
    }

    public Cat(int height, int weight) {
        this.height = height;
        this.weight = weight;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    @Override
    public int compareTo(Object o) {
        //使用不同的比较策略
        //return catHeightComparator.compare(this, o);
        return catWeightComparator.compare(this, o);
    }

    /*
    @Override
    public int compareTo(Object o) {
        if(o instanceof Cat){
            Cat cat = (Cat)o;
            if(this.height > cat.height)return 1;
            else if(this.height < cat.height)return -1;
            else return 0;
        }
        else return -100;
    }
    */

    @Override
    public String toString() {
        return "cat( "+height+", "+weight+" )";
    }
}
