package design_pattern.Factory_designpattern.abstract_factory;

public class Main {

    public static void main(String[] args) {

        AbstractFactory abstractFactory = new MagicFactory();
        Weapon weapon = abstractFactory.getWeapon();
        Food food  = abstractFactory.getFood();
        Vehicle vehicle = abstractFactory.getVehicle();
        vehicle.run();
        food.eat();
        weapon.attack();

    }
}
