package design_pattern.command_designpattern;

public class Main {
    public static void main(String[] args) {
        Girl girl = new Girl();
        Boy boy = new Boy();
        Command flowerCommand = new FlowerCommand(boy);
        girl.setFlowerCommand(flowerCommand);
        girl.publishCommand(boy);
    }
}
