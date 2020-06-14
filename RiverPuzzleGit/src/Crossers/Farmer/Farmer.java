package Crossers.Farmer;

import Crossers.Crosser;
import Crossers.ICrosser;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Farmer extends Crosser implements ICrosser {
    BufferedImage [] bufferedImage =  new BufferedImage[2];
    public Farmer(double weight){
        setWeight(weight);
        setEatingRank(4);

    }
    public Farmer() {
        setEatingRank(4);
        setPosition(super.getPosition());
    }

    @Override
    public boolean canSail() {
        return true;
    }

    @Override
    public BufferedImage[] getImages() {

        try {
            bufferedImage[0]= ImageIO.read(new File("paintleftfarmer_burned.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            bufferedImage[1] = ImageIO.read(new File("paintrighttfarmer_burned.png"));
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
