package Command;

import Crossers.ICrosser;

import java.util.List;

public interface Command {
    public List<ICrosser> execute();
}
