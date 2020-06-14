package Crossers.Farmer;

import javafx.scene.image.Image;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class FarmersStory2 {
    BufferedImage [] FarmerMan =new BufferedImage[2];
    BufferedImage [] FarmerWoman =new BufferedImage[2];
    BufferedImage [] FarmerGirl =new BufferedImage[2];
    BufferedImage [] FarmerBoy =new BufferedImage[2];


    public BufferedImage[] getFarmerMan() {
        try {
            FarmerMan[0] = ImageIO.read(new File("manLeft2.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            FarmerMan[1] = ImageIO.read(new File ("manRight2.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return FarmerMan;
    }

    public BufferedImage[] getFarmerWoman() {
        try {
            FarmerWoman[0]=ImageIO.read(new File("womanLeft.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            FarmerWoman[1]=ImageIO.read(new File("womanRight.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return FarmerWoman;
    }

    public BufferedImage[] getFarmerGirl() throws IOException {
        try {
            FarmerGirl[0]=ImageIO.read(new File("girlLeft.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
         FarmerGirl[1]=ImageIO.read(new File("girlRight.png"));
        return FarmerGirl;
    }

    public BufferedImage[] getFarmerBoy() throws IOException {
        try {
            FarmerBoy[0]=ImageIO.read(new File("boyLeft.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        FarmerBoy[1]= ImageIO.read(new File("boyRight.png"));

        return FarmerBoy;
    }



}
