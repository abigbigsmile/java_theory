package design_pattern.bridge_designpattern;

public class Main {

    public static void main(String[] args) {
        Ball basketball = new Basketball();
        Ball footBall = new FootBall();

        Player basketBallPlayer = new BasketBallPlayer(basketball);
        Player footballPlayer = new FootballPlayer(footBall);

        basketBallPlayer.play();
        footballPlayer.play();

    }
}
