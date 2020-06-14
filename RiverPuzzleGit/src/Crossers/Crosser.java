package Crossers;

public abstract class Crosser {
    private int position=0;
    private double weight;

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    private int eatingRank;

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public int getEatingRank() {
        return eatingRank;
    }

    public void setEatingRank(int eatingRank) {
        this.eatingRank = eatingRank;
    }



}
