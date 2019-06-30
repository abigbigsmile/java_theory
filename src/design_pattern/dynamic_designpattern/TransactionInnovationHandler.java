package design_pattern.dynamic_designpattern;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class TransactionInnovationHandler implements InnovationHandler {

    private Object target;

    public TransactionInnovationHandler(Object target) {
        this.target = target;
    }

    @Override
    public void invoke(Object object, Method method) {
        System.out.println("Session.beginTransaction .");
        try {
            method.invoke(target);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        System.out.println("Session.getTransaction.submit.");

    }
}
