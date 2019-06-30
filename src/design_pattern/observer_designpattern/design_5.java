package design_pattern.observer_designpattern;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class design_5 {

    public static void main(String []args){
        Child5 child = new Child5();
        String[] childMinders = PropsUtil.getProps("ChildMinders").split(",");
        for(String s : childMinders){
            try {
                child.addChildMinder((ChildMinder5)Class.forName(s).newInstance());
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
        new Thread(child).start();
    }
}

//封装读配置文件辅助类
//单例模式
class PropsUtil{

    private static Properties properties;

    static {
        properties = new Properties();
        try {
            properties.load(design_5.class.getClassLoader().getResourceAsStream("design_pattern/observer_designpattern/design_5.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String getProps(String key){
        return properties.getProperty(key);
    }

}

class Event5{

    private Long time;
    private String location;
    private Child5 child;

    public Event5(Long time, String location, Child5 child) {
        this.time = time;
        this.location = location;
        this.child = child;
    }
}

interface ChildMinder5{
    public void actionToChild(Event5 childEvent);
}

//父母类
class Parent5 implements ChildMinder5{
    public void actionToChild(Event5 childEvent){
        System.out.println("parent: feeding .");
    }
}

class GrandParent5 implements ChildMinder5{
    public void actionToChild(Event5 childEvent){
        System.out.println("grandparent: hugging .");
    }
}

class Dog5 implements ChildMinder5{
    @Override
    public void actionToChild(Event5 childEvent) {
        System.out.println("wang wang .");
    }
}



//孩子类
class Child5 implements Runnable{

    private List<ChildMinder5> childMinders = new ArrayList<>();

    public void addChildMinder(ChildMinder5 cm){
        childMinders.add(cm);
    }

    @Override
    public void run() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        this.wakeUp(new Event5(System.currentTimeMillis(),"bed",this));
    }

    public void wakeUp(Event5 event){
        for(ChildMinder5 cm : childMinders){
            cm.actionToChild(event);
        }
    }


}

