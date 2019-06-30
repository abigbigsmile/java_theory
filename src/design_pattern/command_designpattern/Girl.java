package design_pattern.command_designpattern;


import java.util.ArrayList;
import java.util.List;

public class Girl {

    private Command flowerCommand;

    private Command shoppingCommand;

    private List<Command> commands = new ArrayList<>();

    public void setFlowerCommand(Command flowerCommand) {
        this.flowerCommand = flowerCommand;
    }

    public void setShoppingCommand(Command shoppingCommand) {
        this.shoppingCommand = shoppingCommand;
    }

    public void addCommands(Command command){
        this.commands.add(command);
    }

    public void publishCommand(Boy boy){
        flowerCommand.execute();
    }

    public void publishCommands(){
        for(Command command : commands){
            command.execute();
        }
    }

}
