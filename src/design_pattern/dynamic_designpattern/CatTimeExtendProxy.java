package design_pattern.dynamic_designpattern;

public class CatTimeExtendProxy extends Cat{

    @Override
    public void run() {
        System.out.println("start time.....");
        super.run();
        System.out.println("stop time.....");
    }
}
