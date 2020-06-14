package Crossers.Herb;

import Crossers.ICrosser;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Goat extends Herbivorous implements ICrosser {
    BufferedImage[] bufferedImages = new BufferedImage[2];
    public Goat(double weight)
    {
        setWeight(weight);
        setEatingRank(super.getEatingRank());
    }

    @Override
    public boolean canSail() {
        return false;
    }

    @Override
    public BufferedImage[] getImages() {
        try {
            bufferedImages[0]= ImageIO.read(new File("goatleft.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            bufferedImages[1]=ImageIO.read(new File("goat.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return bufferedImages ;
    }

    @Override
    public ICrosser makeCopy() {
        return null;
    }

    @Override
    public void setLabelToBeShown(String label) {

    }

    @Override
    public String getLabelToBeShown() {
        return null;
    }
    public void getOn(){

    }
    public void getOff(){

    }
}
