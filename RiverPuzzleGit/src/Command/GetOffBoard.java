package Command;
import Crossers.ICrosser;

import java.util.List;

public class GetOffBoard implements Command {
    Move move;
    ICrosser crosser;
    public GetOffBoard (Move move,ICrosser crosser){
        this.move=move;
        this.crosser=crosser;
    }
    @Override
    public List<ICrosser> execute() {

        return move.getOff(crosser);
    }

}
