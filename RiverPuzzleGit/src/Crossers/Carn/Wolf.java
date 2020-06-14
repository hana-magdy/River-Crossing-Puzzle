package Crossers.Carn;

import Crossers.ICrosser;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import static javax.imageio.ImageIO.read;

public class Wolf extends Carnivorous implements ICrosser {
   // private int eatingRank;
    BufferedImage[]  bufferedImage = new BufferedImage[2];
    public Wolf() {
setEatingRank(super.getEatingRank());
        setPosition(super.getPosition());

    }

    @Override
    public boolean canSail() {
        return false;
    }

    @Override
    public BufferedImage[] getImages() {
        try {
            bufferedImage[0]= ImageIO.read(new File("leftwolfpaint_burned.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            bufferedImage[1]=read(new File("rightwolfpaint_burned.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return  bufferedImage;
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
