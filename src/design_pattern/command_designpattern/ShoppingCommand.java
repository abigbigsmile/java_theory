package design_pattern.command_designpattern;

public class ShoppingCommand implements Command {

    //命令接收者
    private Boy boy;

    public ShoppingCommand(Boy boy) {
        this.boy = boy;
    }

    @Override
    public void execute() {
        boy.shopping();
    }
}
