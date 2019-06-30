package design_pattern.observer_designpattern;


//消耗资源
public class design_2 {

    public static void main(String []args){
        Parent2 parent = new Parent2();
        Child2 child = new Child2(parent);
        new Thread(child).start();
    }
}

//父母类
class Parent2{
    public void feed(){
        System.out.println("feeding .");
    }
}

//孩子类
class Child2 implements Runnable{

    private Parent2 parent;
    private boolean wake = false;

    public Child2(Parent2 parent) {
        this.parent = parent;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        parent.feed();
    }


}

