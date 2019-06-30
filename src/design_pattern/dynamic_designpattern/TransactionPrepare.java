package design_pattern.dynamic_designpattern;

public class TransactionPrepare implements Transactable{

    @Override
    public void saveSomething() {
        System.out.println("save a user to DB ***");
    }

}
