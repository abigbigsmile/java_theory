package design_pattern.bridge_designpattern;

public class FootBall implements Ball {

    @Override
    public void beep() {
        System.out.println("足球：砰砰砰………………");
    }
}
