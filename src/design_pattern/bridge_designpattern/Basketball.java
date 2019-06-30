package design_pattern.bridge_designpattern;

public class Basketball implements Ball {

    @Override
    public void beep() {
        System.out.println("篮球：咚咚咚…………");
    }
}
