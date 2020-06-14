package Crossers.Herb;

import Crossers.Crosser;
import Crossers.ICrosser;

public abstract class Herbivorous extends Crosser implements ICrosser {
    public Herbivorous() {
        setEatingRank(1);
    }
}
