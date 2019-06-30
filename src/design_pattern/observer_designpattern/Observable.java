package design_pattern.observer_designpattern;

import java.util.ArrayList;
import java.util.List;

//被观察者接口
public abstract class Observable {

    private List<Observer> observers = new ArrayList<>();

    public void addObserver(Observer observer){
        this.observers.add(observer);
    }

    public void delObserver(Observer observer){
        System.out.println("delete observer .");
    }

    public void notifyObserver(Object o){
        for(Observer observer : observers){
            observer.change(o);
        }
    }

}
