package Command;

import Crossers.ICrosser;


import java.util.List;

public class ButtonMover {
    private Command command;
    public void setCommand(Command command) {
        this.command = command;
    }
    public List<ICrosser> pressButton(){

        return command.execute();
    }


}
