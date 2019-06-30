package design_pattern.command_designpattern;

public class FlowerCommand implements Command {

    //命令接收者
    private Boy boy;

    public FlowerCommand(Boy boy) {
        this.boy = boy;
    }

    @Override
    public void execute() {
        boy.flowers();
    }
}
