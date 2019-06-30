package design_pattern.observer_designpattern;

public class ReaderB implements Observer {

    @Override
    public void change(Object o) {
        System.out.println("i am readerB, "+o.toString());
    }
}
