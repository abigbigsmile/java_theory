package design_pattern.observer_designpattern;

public class ReadreA implements Observer {

    @Override
    public void change(Object o) {
        System.out.println("i am readerA, "+o.toString());
    }
}
