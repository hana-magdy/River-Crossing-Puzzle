package Crossers.Plant;

import Crossers.Crosser;
import Crossers.ICrosser;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Plant extends Crosser implements ICrosser {

    private static Plant Cabbage;

    private Plant() {
        setEatingRank(0);
        setPosition(super.getPosition());
    }

    public static Plant getCabbage() {
        if(Cabbage == null) {
            synchronized (Plant.class) {
                if(Cabbage == null) {
                    Cabbage = new Plant();
                }
            }
        }

        return Cabbage;
    }



    BufferedImage[] bufferedImage= new BufferedImage[2];
 //   public Plant (){
   //     setEatingRank(0);
     //   setPosition(super.getPosition());
    //}
    @Override
    public boolean canSail() {
        return false;
    }

    @Override
    public BufferedImage[] getImages() {

        try {
            bufferedImage[0]= ImageIO.read(new File("leftcabbage1.png"));
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
