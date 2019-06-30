package design_pattern.bridge_designpattern;

public abstract class Player {

    protected Ball ball;

    public Player(Ball ball) {
        this.ball = ball;
    }

    public abstract void play();

}
