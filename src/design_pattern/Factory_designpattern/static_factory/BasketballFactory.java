package design_pattern.Factory_designpattern.static_factory;

public class BasketballFactory extends BallFactory {

    @Override
    public Ball produce() {
        return new Basketball();
    }
}
