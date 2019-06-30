package design_pattern.strategy_designpattern;

//比较器，通过实现这个接口，可以任意增加扩展比较功能
public interface Comparator {

    int compare(Object o1, Object o2);

}
