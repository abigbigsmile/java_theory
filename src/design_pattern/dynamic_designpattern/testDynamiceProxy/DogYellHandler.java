package design_pattern.dynamic_designpattern.testDynamiceProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class DogYellHandler implements InvocationHandler {

    Object target;

    public DogYellHandler(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("张开嘴。");
        Object o = method.invoke(target, args);
        System.out.println("闭上嘴。 ");
        return o;

    }
}
