package design_pattern.Factory_designpattern.static_factory;

public class Main {

    public static void main(String[] args) {
        //BallFactory ballFactory = new BasketballFactory();
        BallFactory ballFactory = new FootballFactory();
        Ball ball = ballFactory.produce();
        ball.play();

    }
}
