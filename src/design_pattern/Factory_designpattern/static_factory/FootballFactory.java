package design_pattern.Factory_designpattern.static_factory;

public class FootballFactory extends BallFactory {

    @Override
    public Ball produce() {
        return new Football();
    }
}
