package Crossers.Carn;

import Crossers.Crosser;
import Crossers.ICrosser;

public abstract class Carnivorous extends Crosser implements ICrosser {
    public Carnivorous() {
        setEatingRank(2);
    }
}
