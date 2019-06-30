package design_pattern.iterator_designpattern;

public class TestArrayList {

    public static void main(String[] args) {
      Collection arraryList = new ArraryList();
//    Collection linkedList = new LinkedList();
        GenericArrayList<String> genericArrayList = new GenericArrayList();
//        genericArrayList.add("o");
        for(int i=0; i<20; i++){
            Cat cat = new Cat(i);
            arraryList.add(cat);
        }
        System.out.println(arraryList.size());
        Iterator iterator = ((ArraryList) arraryList).iterator();
        //Iterator iterator = ((LinkedList) arraryList).iterator();
        while(iterator.hasNext()){
            Cat cat = (Cat)iterator.next();
            System.out.println("cat:"+cat.getId()+" ");
        }

    }
}
