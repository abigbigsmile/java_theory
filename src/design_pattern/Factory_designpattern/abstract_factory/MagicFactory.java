package design_pattern.Factory_designpattern.abstract_factory;

public class MagicFactory extends AbstractFactory{

    @Override
    public Weapon getWeapon(){
        return new Wand();
    }

    @Override
    public Vehicle getVehicle(){
        return new Broom();
    }

    @Override
    public Food getFood(){
        return new Mushroom();
    }

}
