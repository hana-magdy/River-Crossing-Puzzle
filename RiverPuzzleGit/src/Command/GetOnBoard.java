package Command;
import Crossers.ICrosser;

import java.util.List;

public class GetOnBoard implements Command {
    Move move ;
    ICrosser crosser;
    public GetOnBoard (Move move,ICrosser crosser){
        this.move=move;
        this.crosser=crosser;
    }
    @Override
    public List<ICrosser> execute() {
        return move.getOn(crosser);

    }
}
