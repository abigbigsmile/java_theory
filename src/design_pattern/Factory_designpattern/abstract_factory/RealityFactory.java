package design_pattern.Factory_designpattern.abstract_factory;

public class RealityFactory  extends AbstractFactory{


    @Override
    public Weapon getWeapon(){
        return new AK47();
    }

    @Override
    public Vehicle getVehicle(){
        return new Car();
    }

    @Override
    public Food getFood(){
        return new Apple();
    }

}
