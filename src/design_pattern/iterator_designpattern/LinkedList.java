package design_pattern.iterator_designpattern;

public class LinkedList implements Collection, Iterable{

    private Node head = null;
    private Node tail = null;
    private int size = 0;

    public void add(Object o){

        Node node = new Node();
        node.setData(o);
        node.setNext(null);
        if(head == null){
            head = node;
            tail = node;
        }else{
            tail.setNext(node);
            tail = node;
        }
        size++;
        /*
        if(head == null)head = node;
        else{
            Node np = head;
            while(np.getNext() != null){
                np = np.getNext();
            }
            np.setNext(node);
        }
        */
    }

    public int size(){
        return size;
    }

    @Override
    public Iterator iterator() {
        return new LinkedListIterator();
    }

    class LinkedListIterator implements Iterator{
        private Node currentNode = head;

        @Override
        public boolean hasNext() {
            if(currentNode.getNext()==null)return false;
            else return true;
        }

        @Override
        public Object next() {
            Object o = currentNode.getNext().getData();
            currentNode = currentNode.getNext();
            return o;

        }
    }
}
