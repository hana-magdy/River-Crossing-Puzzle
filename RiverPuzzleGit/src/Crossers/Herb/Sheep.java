package Crossers.Herb;

import Crossers.ICrosser;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Sheep extends Herbivorous implements ICrosser {

    BufferedImage[] bufferedImage = new BufferedImage[2];
    public Sheep(){
       // setWeight(weight);
        setEatingRank(super.getEatingRank());
        setPosition(super.getPosition());
    }
    @Override
    public boolean canSail() {
        return false;
    }

    @Override
    public BufferedImage[] getImages()
    {
        try {
            bufferedImage[0]= ImageIO.read(new File("leftpaintsheep_burned.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            bufferedImage[1] = ImageIO.read(new File("rightpaintsheep_burned.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return bufferedImage;
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
