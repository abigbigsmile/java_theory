package design_pattern.dynamic_designpattern.testDynamiceProxy;


import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

public class Main {

    public static void main(String[] args) {
        Animal dog = new Dog();
        InvocationHandler dogYellHandler = new DogYellHandler(dog);
        Animal dogProxy = (Animal)Proxy.newProxyInstance(dog.getClass().getClassLoader(), dog.getClass().getInterfaces(), dogYellHandler);
        dogProxy.yell();
    }
}
