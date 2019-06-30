package design_pattern.observer_designpattern;


//消耗资源
public class design_1 {

    public static void main(String []args){
        Child child = new Child();
        new Thread(child).start();
        Parent parent = new Parent(child);
        new Thread(parent).start();
    }
}

//父母类
class Parent implements Runnable{

    private Child child;

    public Parent(Child child) {
        this.child = child;
    }

    @Override
    public void run() {
        while (!child.isWake()){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        feed();
    }

    public void feed(){
        child.eat();
    }
}

//孩子类
class Child implements Runnable{

    private boolean isWake;

    @Override
    public void run() {
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        this.setWake(!isWake);
    }



    public boolean isWake() {
        return isWake;
    }

    public void setWake(boolean wake) {
        isWake = wake;
    }

    public void sleep(){
        System.out.println("sleeping .");
    }

    public void eat(){
        System.out.println("eating .");
    }


}

