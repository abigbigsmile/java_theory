package design_pattern.mediator_designpattern;

//Colleague（抽象同事类）
abstract class Colleague {
    protected  String name;
    protected Mediator mediator;

    public Colleague(String name, Mediator mediator) {
        this.name = name;
        this.mediator = mediator;
    }
}
//Mediator（抽象中介者）
abstract class Mediator {
    public abstract void constact(String message, Colleague colleague);
}
//ConcreteColleague（具体同事类）
class ConcreteColleagueHR extends Colleague {
    public ConcreteColleagueHR(String name, Mediator mediator) {
        super(name, mediator);
    }

    public void constact(String message) {
        mediator.constact(message, this);
    }

    public void getMessage(String msg) {
        System.out.println("HR#"+name+"#:"+msg);
    }
}

class ConcreteColleagueAndroidDeveloper extends Colleague {
    public ConcreteColleagueAndroidDeveloper(String name, Mediator mediator) {
        super(name, mediator);
    }

    public void constact(String message) {
        mediator.constact(message, this);
    }

    public void getMessage(String msg) {
        System.out.println("Android Developer#"+name+"#:"+msg);
    }
}
//ConcreteMediator（具体中介者）
class ConcreteMediator extends Mediator {
    private ConcreteColleagueHR hr;
    private ConcreteColleagueAndroidDeveloper ad;

    public ConcreteColleagueHR getConcreteColleagueHR() {
        return hr;
    }

    public ConcreteColleagueAndroidDeveloper getConcreteColleagueAndroidDeveloper() {
        return ad;
    }

    public void setConcreteColleagueHR(ConcreteColleagueHR hr) {
        this.hr = hr;
    }

    public void setConcreteColleagueAndroidDeveloper(ConcreteColleagueAndroidDeveloper ad) {
        this.ad = ad;
    }

    @Override
    public void constact(String message, Colleague colleague) {
        if (colleague == hr) {
            ad.getMessage(message);
        }
        else {
            hr.getMessage(message);
        }
    }
}
//客户端
public class Main {
    public static void main(String[] args) {
        ConcreteMediator mediator = new ConcreteMediator();
        ConcreteColleagueHR hr = new ConcreteColleagueHR("Google招聘专员", mediator);
        ConcreteColleagueAndroidDeveloper ad = new ConcreteColleagueAndroidDeveloper("屌丝开发者", mediator);

        mediator.setConcreteColleagueHR(hr);
        mediator.setConcreteColleagueAndroidDeveloper(ad);

        hr.constact("Hi，你有意向来我们公司吗？");
        ad.constact("是Google开发Android吗？");
        hr.constact("yes!");
        ad.constact("我愿意！");
    }
}

