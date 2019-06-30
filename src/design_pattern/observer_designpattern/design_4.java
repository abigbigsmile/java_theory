package design_pattern.observer_designpattern;


import java.util.ArrayList;
import java.util.List;

//消耗资源
public class design_4 {

    public static void main(String []args){
        Parent4 parent = new Parent4();
        GrandParent4 grandParent = new GrandParent4();
        Child4 child = new Child4();
        child.addChildMinder(parent);
        child.addChildMinder(grandParent);
        new Thread(child).start();
    }
}

class Event4{

    private Long time;
    private String location;
    private Child4 child;

    public Event4(Long time, String location, Child4 child) {
        this.time = time;
        this.location = location;
        this.child = child;
    }
}

interface ChildMinder{
    public void actionToChild(Event4 childEvent);
}

//父母类
class Parent4 implements ChildMinder{
    public void actionToChild(Event4 childEvent){
        System.out.println("parent: feeding .");
    }
}

class GrandParent4 implements ChildMinder{
    public void actionToChild(Event4 childEvent){
        System.out.println("grandparent: hugging .");
    }
}

class Dog implements ChildMinder{
    @Override
    public void actionToChild(Event4 childEvent) {
        System.out.println("wang wang .");
    }
}

//孩子类
class Child4 implements Runnable{

    private List<ChildMinder> childMinders = new ArrayList<>();

    public void addChildMinder(ChildMinder cm){
        childMinders.add(cm);
    }

    @Override
    public void run() {
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        this.wakeUp(new Event4(System.currentTimeMillis(),"bed",this));
    }

    public void wakeUp(Event4 event){
        for(ChildMinder cm : childMinders){
            cm.actionToChild(event);
        }
    }


}

