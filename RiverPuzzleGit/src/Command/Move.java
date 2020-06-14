package Command;

import Crossers.ICrosser;

import java.util.ArrayList;
import java.util.List;

public class Move {
    List<ICrosser> boatRiders=new ArrayList<>();

    public List<ICrosser> getOn(ICrosser crosser){
    boatRiders.add(crosser);

    return boatRiders;
    }
    public List<ICrosser> getOff(ICrosser crosser){
    boatRiders.remove(crosser);
    return boatRiders;
    }

}
