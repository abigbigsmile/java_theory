package design_pattern.dynamic_designpattern;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class TimeInnovationHandler implements InnovationHandler {

    private Object target;

    public TimeInnovationHandler(Object target) {
        this.target = target;
    }

    @Override
    public void invoke(Object object, Method method) {
        System.out.println("start time.....");
        try {
            method.invoke(target, new Object[]{});
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        System.out.println("stop time.....");
    }
}
