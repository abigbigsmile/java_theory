package design_pattern.iterator_designpattern;

//泛型
public class GenericArrayList<E>{

    private Object[] objects = new Object[10];
    private int index = 0;

    public void add(E o){
        if(index == objects.length){
            Object[] newObjects = new Object[objects.length+10];
            System.arraycopy(objects, 0, newObjects, 0, objects.length);
            objects = newObjects;
        }
        objects[index] = o;
        index ++;
    }

    public int size(){
        return index;
    }

    public Iterator iterator() {
        return new ArrayListIterator();
    }

    class ArrayListIterator implements Iterator{
        private int currentIndex = 0;

        @Override
        public boolean hasNext() {
            if(currentIndex >= index)return false;
            else return true;
        }

        @Override
        public Object next() {
            Object o = objects[currentIndex];
            currentIndex++;
            return o;
        }
    }


}
