package design_pattern.bridge_designpattern;

public class BasketBallPlayer extends Player {


    public BasketBallPlayer(Ball ball) {
        super(ball);
    }

    @Override
    public void play() {

        System.out.print("BasketballPlayer :" );
        ball.beep();
    }
}
