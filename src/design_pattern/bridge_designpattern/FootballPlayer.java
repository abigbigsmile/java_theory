package design_pattern.bridge_designpattern;

public class FootballPlayer extends Player {

    public FootballPlayer(Ball ball) {
        super(ball);
    }

    @Override
    public void play() {
        System.out.print("FootballPlayer :");
        ball.beep();
    }
}
