package design_pattern.observer_designpattern;


//消耗资源
public class design_3 {

    public static void main(String []args){
        Parent3 parent = new Parent3();
        Child3 child = new Child3(parent);
        new Thread(child).start();
    }
}

class Event{

    private Long time;
    private String location;
    private Child3 child;

    public Event(Long time, String location, Child3 child) {
        this.time = time;
        this.location = location;
        this.child = child;
    }
}

//父母类
class Parent3{
    public void actionToChild(Event childEvent){
        System.out.println("do something .");
    }
}

//孩子类
class Child3 implements Runnable{

    private Parent3 parent;

    public Child3(Parent3 parent) {
        this.parent = parent;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        this.wakeUp(new Event(System.currentTimeMillis(),"bed",this));
    }

    public void wakeUp(Event event){
        parent.actionToChild(event);
    }


}

