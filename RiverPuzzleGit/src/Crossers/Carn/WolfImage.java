package Crossers.Carn;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;


public class WolfImage {
    public Image LeftImage;
    private   Image RightImage;
    private   double LeftPositionX;
    private double LeftPositionY;
    private double RightPositionX;
    private double RightpositionY;
    private double LeftWidth;
    private double LeftHeight;
    private  double RightWidth;
    private double RightHeight;

    public WolfImage(Image LeftImage , Image RightImage) {
        this.LeftImage=LeftImage;
        this.RightImage=RightImage;
        this.LeftPositionX=180;
        this.LeftPositionY=380;
        this.LeftWidth=80;
        this.LeftHeight=130;
        this.RightPositionX=1075;
        this.RightpositionY=550;
        this.RightWidth=RightImage.getWidth();
        this.RightHeight=RightImage.getHeight();

    }

    public Image getLeftImage() {
        return LeftImage;
    }

    public void setLeftImage(Image leftImage) {
        LeftImage = leftImage;
    }

    public Image getRightImage() {
        return RightImage;
    }

    public void setRightImage(Image rightImage) {
        RightImage = rightImage;
    }

    public double getLeftPositionX() {
        return LeftPositionX;
    }

    public void setLeftPositionX(double leftPositionX) {
        LeftPositionX = leftPositionX;
    }

    public double getLeftPositionY() {
        return LeftPositionY;
    }

    public void setLeftPositionY(double leftPositionY) {
        LeftPositionY = leftPositionY;
    }

    public double getRightPositionX() {
        return RightPositionX;
    }

    public void setRightPositionX(double rightPositionX) {
        RightPositionX = rightPositionX;
    }

    public double getRightpositionY() {
        return RightpositionY;
    }

    public void setRightpositionY(double rightpositionY) {
        RightpositionY = rightpositionY;
    }

    public double getLeftWidth() {
        return LeftWidth;
    }

    public void setLeftWidth(double leftWidth) {
        LeftWidth = leftWidth;
    }

    public double getLeftHeight() {
        return LeftHeight;
    }

    public void setLeftHeight(double leftHeight) {
        LeftHeight = leftHeight;
    }

    public double getRightWidth() {
        return RightWidth;
    }

    public void setRightWidth(double rightWidth) {
        RightWidth = rightWidth;
    }

    public double getRightHeight() {
        return RightHeight;
    }

    public void setRightHeight(double rightHeight) {
        RightHeight = rightHeight;
    }

    public void render(GraphicsContext gc) {

        gc.drawImage(LeftImage,LeftPositionX,LeftPositionY);
    }
    public void render2 (GraphicsContext gc){
        gc.drawImage(RightImage,RightPositionX,RightpositionY);
    }
}


