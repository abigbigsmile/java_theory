package jvm;

public class Main {

    public void sayHello(Parent p){
        p.smile();
    }

    public static void main(String[] args) {
        Main main = new Main();
        Parent son = new Son();
        Parent daughter = new Daughter();
        main.sayHello(son);
        main.sayHello(daughter);
    }


}

class Parent{
    public void smile(){
        System.out.println("Parent smile");
    }
}

class Son extends Parent{
    public void smile(){
        System.out.println("Son smile");
    }
}

class Daughter extends Parent{
    public void smile(){
        System.out.println("Daughter smile");
    }
}
