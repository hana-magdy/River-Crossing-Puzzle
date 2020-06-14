package sample;

import Crossers.Carn.Wolf;
import Crossers.Farmer.Farmer;
import Crossers.Herb.Sheep;
import Crossers.Plant.Plant;
import Events.S2Events;
import Strategy.StoryOne;
import Strategy.StoryTwo;
import XML_Factories.ReadXMLFileS2;
import XML_Factories.XMLWriterDOMS2;
import javafx.animation.*;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBase;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.transform.Translate;
import javafx.stage.Stage;
import javafx.util.Duration;
import org.omg.CORBA.TRANSIENT;
import sun.plugin2.message.EventMessage;

import javax.rmi.ssl.SslRMIClientSocketFactory;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.List;

public class LevelOne {
    Stage stage;
    Group root = new Group();
    Scene levelOneScene = new Scene(root, 1400, 800);
    Canvas canvas = new Canvas(1400, 800);
    GraphicsContext gc = canvas.getGraphicsContext2D();
    Button FarmerLeftButton;
    ImageView FarmerLeftView;
    Button FarmerRightButton;
    ImageView FarmerRightView;
    Button WolfLeftButton;
    StoryOne test = new StoryOne();
    Button redo = new Button();
    ButtonBase Save;
    ButtonBase Load;


    public void setFarmerOnBoard(Boolean farmerOnBoard) {
        FarmerOnBoard = farmerOnBoard;
    }

    public Button getFarmerLeftButton() {
        return FarmerLeftButton;
    }

    public Button getFarmerRightButton() {
        return FarmerRightButton;
    }

    public Button getWolfLeftButton() {
        return WolfLeftButton;
    }

    public Button getWolfRightButton() {
        return WolfRightButton;
    }

    public Button getCabbageLeftButton() {
        return CabbageLeftButton;
    }

    public Button getCabbageRightButton() {
        return CabbageRightButton;
    }

    public Button getSheepLeftButton() {
        return SheepLeftButton;
    }

    public Button getSheepRightButton() {
        return SheepRightButton;
    }

    public Button getReadysail() {
        return Readysail;
    }

    public Button getPlay() {
        return play;
    }

    public void setWolfOnBoard(Boolean wolfOnBoard) {
        WolfOnBoard = wolfOnBoard;
    }

    public void setCabbageOnBoard(Boolean cabbageOnBoard) {
        CabbageOnBoard = cabbageOnBoard;
    }

    public void setSheepOnBoard(Boolean sheepOnBoard) {
        SheepOnBoard = sheepOnBoard;
    }

    public void setBoatOnRight(Boolean boatOnRight) {
        this.boatOnRight = boatOnRight;
    }

    ImageView WolfLeftView;
    Button WolfRightButton;
    ImageView WolfRightView;
    Button CabbageLeftButton;

    public Boolean getFarmerOnBoard() {
        return FarmerOnBoard;
    }

    public Boolean getWolfOnBoard() {
        return WolfOnBoard;
    }

    public Boolean getCabbageOnBoard() {
        return CabbageOnBoard;
    }

    public Boolean getSheepOnBoard() {
        return SheepOnBoard;
    }

    public Boolean getBoatOnRight() {
        return boatOnRight;
    }

    ImageView CabbageLeftView;
    Button CabbageRightButton;
    ImageView CabbageRightView;
    Button SheepLeftButton;
    ImageView SheepLeftView;
    Button SheepRightButton;
    ImageView SheepRightView;
    ImageView BoatView;
    Boolean FarmerOnBoard = false;
    Boolean WolfOnBoard = false;
    Boolean CabbageOnBoard = false;
    Boolean SheepOnBoard = false;
    Button Readysail;
    Button play;
    ImageView Sail;
    Boolean boatOnRight = false;
    ImageView readysail;
    Button undo = new Button();

public LevelOne(){

}
    public LevelOne(Stage stage) {
        this.stage = stage;
    }

    public void ShowInstructions() {
        // ImageView instructionsTitle = new ImageView("file:kisspng-banner-gold-yellow-price-tag-sign-5aa63263eacf52.8791285515208413159618.jpg");
        //root.getChildren().add(instructionsTitle);
        Image instructions = new Image("file:label-removebg.png");
        ImageView instructionsView = new ImageView(instructions);
        Text instructingText = new Text("                                                               INSTRUCTIONS \r\n" + test.getInstructions()[0]);
        instructingText.setFont(Font.font(Font.getFontNames().get(0),
                FontWeight.EXTRA_BOLD, 20));
        instructingText.setLayoutX(320);
        instructingText.setLayoutY(250);
        instructionsView.setLayoutX(60);
        instructionsView.setLayoutY(50);
        instructionsView.setFitHeight(700);
        instructionsView.setFitWidth(1200);
        Image exit = new Image("file:exitLabel-removebg.png");
        ImageView exitView = new ImageView(exit);
        Button exitButton = new Button();
        exitButton.setGraphic(exitView);
        exitButton.setLayoutX(285);
        exitButton.setLayoutY(195);
        exitView.setFitWidth(40);
        exitView.setFitHeight(40);
        exitButton.setStyle("-fx-background-color: transparent;");
        root.getChildren().add(instructionsView);
        root.getChildren().add(instructingText);
        root.getChildren().add(exitButton);
        instructionsView.setVisible(true);
        instructingText.setVisible(true);
        exitButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                instructionsView.setVisible(false);
                instructingText.setVisible(false);
                exitButton.setVisible(false);
            }
        });


        //    instructionsView.set
    }

    public void loadBufffer() {
        Farmer farmer = new Farmer();
        BufferedImage[] farmerBuffer = farmer.getImages();
        Image farmerLeft = SwingFXUtils.toFXImage(farmerBuffer[0], null);
        FarmerLeftView = new ImageView();
        FarmerLeftView.setImage(farmerLeft);
        Image farmerRight = SwingFXUtils.toFXImage(farmerBuffer[1], null);
        FarmerRightView = new ImageView();
        FarmerRightView.setImage(farmerRight);
        Wolf wolf = new Wolf();
        BufferedImage[] WolfBuffer = wolf.getImages();
        Image WolfLeft = SwingFXUtils.toFXImage(WolfBuffer[0], null);
        WolfLeftView = new ImageView();
        WolfLeftView.setImage(WolfLeft);
        Image wolfRight = SwingFXUtils.toFXImage(WolfBuffer[1], null);
        WolfRightView = new ImageView();
        WolfRightView.setImage(wolfRight);
        Plant Cabbage = Plant.getCabbage();
        BufferedImage[] CabbageBuffredImage = Cabbage.getImages();
        Image CabbageImage = SwingFXUtils.toFXImage(CabbageBuffredImage[0], null);
        CabbageLeftView = new ImageView();
        CabbageLeftView.setImage(CabbageImage);

        Image CabbageImageRight = SwingFXUtils.toFXImage(CabbageBuffredImage[0], null);
        CabbageRightView = new ImageView();
        CabbageRightView.setImage(CabbageImageRight);
        Sheep sheep = new Sheep();
        BufferedImage[] buffersheep = sheep.getImages();
        Image sheepleft = SwingFXUtils.toFXImage(buffersheep[0], null);
        SheepLeftView = new ImageView();
        SheepLeftView.setImage(sheepleft);
        Image SheepRight = SwingFXUtils.toFXImage(buffersheep[1], null);
        SheepRightView = new ImageView();
        SheepRightView.setImage(SheepRight);


    }


    public void PrepareLeftFarmer() {
        FarmerLeftButton = new Button();
        FarmerLeftButton.setGraphic(FarmerLeftView);
        FarmerLeftButton.setStyle("-fx-background-color: transparent;");
        FarmerLeftButton.setLayoutX(110);
        FarmerLeftButton.setLayoutY(350);
        root.getChildren().add(FarmerLeftButton);
        FarmerLeftButton.setVisible(true);
        //Move();

    }

    public void PrepareRightFarmer() {
        FarmerRightButton = new Button();

        FarmerRightButton.setGraphic(FarmerRightView);
        FarmerRightButton.setStyle("-fx-background-color: transparent;");
        FarmerRightButton.setLayoutX(1075);
        FarmerRightButton.setLayoutY(430);
        root.getChildren().add(FarmerRightButton);
        FarmerRightButton.setVisible(true);


    }

    public void PrepareLeftWolf() {
        WolfLeftButton = new Button();
        WolfLeftButton.setGraphic(WolfLeftView);
        WolfLeftButton.setStyle("-fx-background-color: transparent;");
        WolfLeftButton.setLayoutX(180);
        WolfLeftButton.setLayoutY(380);
        root.getChildren().add(WolfLeftButton);
        WolfLeftButton.setVisible(true);
    }

    public void PrepareRightWolf() {
        WolfRightButton = new Button();
        WolfRightButton.setGraphic(WolfRightView);
        WolfRightButton.setStyle("-fx-background-color: transparent;");
        WolfRightButton.setLayoutX(1075);
        WolfRightButton.setLayoutY(550);
        root.getChildren().add(WolfRightButton);
        WolfRightButton.setVisible(true);
    }

    public void PrepareLeftCabbage() {
        CabbageLeftButton = new Button();
        CabbageLeftButton.setGraphic(CabbageLeftView);
        CabbageLeftButton.setStyle("-fx-background-color: transparent;");
        CabbageLeftButton.setLayoutX(280);
        CabbageLeftButton.setLayoutY(420);
        root.getChildren().add(CabbageLeftButton);
        CabbageLeftButton.setVisible(true);
        // Move();

    }

    public void PrepareRightCabbage() {
        CabbageRightButton = new Button();
        CabbageRightButton.setGraphic(CabbageRightView);
        CabbageRightButton.setStyle("-fx-background-color: transparent;");
        CabbageRightButton.setLayoutX(1200);
        CabbageRightButton.setLayoutY(620);
        root.getChildren().add(CabbageRightButton);
        CabbageRightButton.setVisible(true);
        //Move();
    }

    public void PrepareLeftSheep() {
        SheepLeftButton = new Button();

        SheepLeftButton.setGraphic(SheepLeftView);
        SheepLeftButton.setStyle("-fx-background-color: transparent;");
        SheepLeftButton.setLayoutX(360);
        SheepLeftButton.setLayoutY(380);
        root.getChildren().add(SheepLeftButton);
        SheepLeftButton.setVisible(true);
        // Move();
    }

    public void PrepareRightSheep() {
        SheepRightButton = new Button();
        SheepRightButton.setGraphic(SheepRightView);
        SheepRightButton.setStyle("-fx-background-color: transparent;");
        SheepRightButton.setLayoutX(1150);
        SheepRightButton.setLayoutY(520);
        root.getChildren().add(SheepRightButton);
        SheepRightButton.setVisible(true);
        // Move();

    }

    public void PrepareBoat() {
        BoatView = new ImageView("file:raft.png");
        BoatView.setLayoutX(320);
        BoatView.setLayoutY(400);
        root.getChildren().add(BoatView);
    }

    public void PrepareScene() {
        loadBufffer();

        Image river = new Image("file:riverBanks.jpg");
        ImageView riverBanks = new ImageView(river);
        riverBanks.setFitWidth(1400);
        riverBanks.setFitHeight(800);
        root.getChildren().add(riverBanks);

        Image sail = new Image("file:sail.png");
        readysail = new ImageView(sail);
        readysail.setLayoutX(1200);
        readysail.setLayoutY(50);
        //  readysail.setFitWidth(20);
        //  readysail.setFitHeight(20);
        play = new Button();
        //play.setShape(new Circle(20));
        play.setGraphic(readysail);
        play.setStyle("-fx-background-color: transparent;");


        stage.setScene(levelOneScene);
        stage.show();
        root.getChildren().add(canvas);
        PrepareBoat();
        BoatView.setVisible(true);
        PrepareLeftFarmer();
        PrepareRightFarmer();
        FarmerRightButton.setVisible(false);
        PrepareLeftWolf();
        PrepareRightWolf();
        WolfRightButton.setVisible(false);
        PrepareLeftCabbage();
        PrepareRightCabbage();
        CabbageRightButton.setVisible(false);
        PrepareLeftSheep();
        PrepareRightSheep();
        SheepRightButton.setVisible(false);
        root.getChildren().add(play);

        Image undoImg = new Image("file:undo.png");
        ImageView undoView = new ImageView(undoImg);
        undoView.setFitWidth(40);
        undoView.setFitHeight(40);
        undo.setGraphic(undoView);
        undo.setStyle("-fx-background-color: transparent;");
        root.getChildren().add(undo);
        undo.setLayoutX(100);
        undo.setLayoutY(25);




        Image redoImg = new Image("file:redo.png");
        ImageView redoView = new ImageView(redoImg);
        redoView.setFitWidth(40);
        redoView.setFitHeight(40);
        redo.setGraphic(redoView);
        redo.setStyle("-fx-background-color: transparent;");
        root.getChildren().add(redo);
        redo.setLayoutX(5);
        redo.setLayoutY(90);


        Save = new Button();
        Image SaveImage = new Image("file:save.jpg");
        ImageView SaveView = new ImageView(SaveImage);
        Save.setGraphic(SaveView);
        SaveView.setFitWidth(40);
        SaveView.setFitHeight(40);
        Save.setLayoutX(150);
        Save.setLayoutY(150);
        Save.setStyle("-fx-background-color: transparent;");
        root.getChildren().add(Save);

        Load = new Button();
        Image LoadImage = new Image ("file:load.png");
        ImageView loadView = new ImageView(LoadImage);
        Load.setGraphic(loadView);
        loadView.setFitHeight(40);
        loadView.setFitWidth(40);
        Load.setLayoutX(150);
        Load.setLayoutY(200);
        Load.setStyle("-fx-background-color: transparent;");
        root.getChildren().add(Load);





         ShowInstructions();
        //LevelCompleted();
    }


    //  >>>>>>   Start of Left Farmer Button    <<<<<<<<<<<<<<<<<


    public Timeline setPathLF() {
        Line line = new Line();
        line.setStartX(50);
        line.setStartY(100);
        line.setEndX(400);
        line.setEndY(120);
        PathTransition transition = new PathTransition();
        transition.setNode(FarmerLeftButton);
        transition.setDuration(Duration.seconds(2));
        transition.setPath(line);
        Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(0), event1 -> transition.play()), new KeyFrame(Duration.seconds(5), event1 -> transition.pause()));
        transition.setCycleCount(1);
        timeline.play();
        return timeline;
    }

    public Timeline setPathLFBack() {
        Line line = new Line();
        line.setEndX(50);
        line.setEndY(100);
        line.setStartX(400);
        line.setStartY(120);
        PathTransition transition = new PathTransition();
        transition.setNode(FarmerLeftButton);
        transition.setDuration(Duration.seconds(2));
        transition.setPath(line);
        Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(0), event1 -> transition.play()), new KeyFrame(Duration.seconds(5), event1 -> transition.pause()));
        transition.setCycleCount(1);
        timeline.play();
        return timeline;
    }

    public void FLB(EventHandler<ActionEvent> leftFarmer) {
        FarmerLeftButton.setOnAction(leftFarmer);
    }
    public  void  saving (EventHandler<ActionEvent> SaveScene){
        Save.setOnAction(SaveScene);

    }

    public void loading (EventHandler<ActionEvent> loadingScene){
        Load.setOnAction(loadingScene);
    }


    //   >>>>>>>>>>>>>>>>>>>>>>>  End of left Farmer Button   <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<


    //    >>>>>>>>>>>>>>>>>>>>>>>>>>> Start of Right Farmer Button    <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<


    public Timeline setPathRF() {
        Line line = new Line();
        line.setStartX(0);
        line.setStartY(120);
        line.setEndX(-280);
        line.setEndY(210);
        PathTransition transition = new PathTransition();
        transition.setNode(FarmerRightButton);
        transition.setDuration(Duration.seconds(2));
        transition.setPath(line);
        Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(0), event1 -> transition.play()), new KeyFrame(Duration.seconds(5), event1 -> transition.pause()));
        transition.setCycleCount(1);
        return timeline;
    }
    public Timeline setPathRFBack() {
        Line line = new Line();
        line.setStartX(-280);
        line.setStartY(210);
        line.setEndX(0);
        line.setEndY(120);
        PathTransition transition = new PathTransition();
        transition.setNode(FarmerRightButton);
        transition.setDuration(Duration.seconds(2));
        transition.setPath(line);
        Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(0), event1 -> transition.play()), new KeyFrame(Duration.seconds(5), event1 -> transition.pause()));
        transition.setCycleCount(1);
        return timeline;
    }

    public void FRB(EventHandler<ActionEvent> rightFarmer) {
        FarmerRightButton.setOnAction(rightFarmer);
    }


    // >>>>>>>>>>>>>>>>>>>>>>>> End of Right Farmer Button  <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<


    //>>>>>>>>>>>>>>>>>>>>>>>>Start of right wolf button<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<

    public Timeline setPathLW() {
        Line line = new Line();
        line.setStartX(80);
        line.setStartY(50);
        line.setEndX(200);
        line.setEndY(110);
        PathTransition transition = new PathTransition();
        transition.setNode(WolfLeftButton);
        transition.setDuration(Duration.seconds(2));
        transition.setPath(line);
        Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(0), event1 -> transition.play()), new KeyFrame(Duration.seconds(5), event1 -> transition.pause()));
        transition.setCycleCount(1);

        return timeline;
    }



    public Timeline setPathLWBack() {
        Line line = new Line();
        line.setStartX(200);
        line.setStartY(110);
        line.setEndX(80);
        line.setEndY(50);
        PathTransition transition = new PathTransition();
        transition.setNode(WolfLeftButton);
        transition.setDuration(Duration.seconds(2));
        transition.setPath(line);
        Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(0), event1 -> transition.play()), new KeyFrame(Duration.seconds(5), event1 -> transition.pause()));
        transition.setCycleCount(1);

        return timeline;
    }

    public void LWB(EventHandler<ActionEvent> wolfLeft) {
        WolfLeftButton.setOnAction(wolfLeft);
    }


    public Timeline onAndOffRW() {
        Line line = new Line();
        line.setStartX(0);
        line.setStartY(20);
        line.setEndX(-350);
        line.setEndY(120);
        PathTransition transition = new PathTransition();
        transition.setNode(WolfRightButton);
        transition.setDuration(Duration.seconds(2));
        transition.setPath(line);
        Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(0), event1 -> transition.play()), new KeyFrame(Duration.seconds(5), event1 -> transition.pause()));
        transition.setCycleCount(1);

        return timeline;
    }



    public Timeline onAndOffRWBack() {
        Line line = new Line();
        line.setStartX(-350);
        line.setStartY(120);
        line.setEndX(0);
        line.setEndY(20);
        PathTransition transition = new PathTransition();
        transition.setNode(WolfRightButton);
        transition.setDuration(Duration.seconds(2));
        transition.setPath(line);
        Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(0), event1 -> transition.play()), new KeyFrame(Duration.seconds(5), event1 -> transition.pause()));
        transition.setCycleCount(1);

        return timeline;
    }




    public void RWB(EventHandler<ActionEvent> rightWolf) {
        WolfRightButton.setOnAction(rightWolf);
    }


    public Timeline setPathLS() {
        Line line = new Line();
        line.setStartX(80);
        line.setStartY(50);
        line.setEndX(150);
        line.setEndY(150);
        PathTransition transition = new PathTransition();
        transition.setNode(SheepLeftButton);
        transition.setDuration(Duration.seconds(2));
        transition.setPath(line);
        Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(0), event1 -> transition.play()), new KeyFrame(Duration.seconds(5), event1 -> transition.pause()));
        transition.setCycleCount(1);

        return timeline;
    }


    public Timeline setPathLSBack() {
        Line line = new Line();
        line.setStartX(150);
        line.setStartY(150);
        line.setEndX(80);
        line.setEndY(50);
        PathTransition transition = new PathTransition();
        transition.setNode(SheepLeftButton);
        transition.setDuration(Duration.seconds(2));
        transition.setPath(line);
        Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(0), event1 -> transition.play()), new KeyFrame(Duration.seconds(5), event1 -> transition.pause()));
        transition.setCycleCount(1);

        return timeline;
    }



    public void LSB(EventHandler<ActionEvent> leftSheep) {
        SheepLeftButton.setOnAction(leftSheep);
    }


    public Timeline setPathRS() {
        Line line = new Line();
        line.setStartX(0);
        line.setStartY(50);
        line.setEndX(-400);
        line.setEndY(165);
        PathTransition transition = new PathTransition();
        transition.setNode(SheepRightButton);
        transition.setDuration(Duration.seconds(2));
        transition.setPath(line);
        Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(0), event1 -> transition.play()), new KeyFrame(Duration.seconds(5), event1 -> transition.pause()));
        transition.setCycleCount(1);

        return timeline;
    }


    public Timeline setPathRSBack() {
        Line line = new Line();
        line.setStartX(-400);
        line.setStartY(165);
        line.setEndX(0);
        line.setEndY(50);
        PathTransition transition = new PathTransition();
        transition.setNode(SheepRightButton);
        transition.setDuration(Duration.seconds(2));
        transition.setPath(line);
        Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(0), event1 -> transition.play()), new KeyFrame(Duration.seconds(5), event1 -> transition.pause()));
        transition.setCycleCount(1);

        return timeline;
    }




    public void RSB(EventHandler<ActionEvent> rightSheep) {
        SheepRightButton.setOnAction(rightSheep);
    }


    public Timeline setPathLP() {

        Line line = new Line();
        line.setStartX(80);
        line.setStartY(50);
        line.setEndX(200);
        line.setEndY(110);
        PathTransition transition = new PathTransition();
        transition.setNode(CabbageLeftButton);
        transition.setDuration(Duration.seconds(2));
        transition.setPath(line);
        Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(0), event1 -> transition.play()), new KeyFrame(Duration.seconds(5), event1 -> transition.pause()));
        transition.setCycleCount(1);
        return timeline;
    }



    public Timeline setPathLPBack() {

        Line line = new Line();
        line.setStartX(200);
        line.setStartY(110);
        line.setEndX(80);
        line.setEndY(50);
        PathTransition transition = new PathTransition();
        transition.setNode(CabbageLeftButton);
        transition.setDuration(Duration.seconds(2));
        transition.setPath(line);
        Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(0), event1 -> transition.play()), new KeyFrame(Duration.seconds(5), event1 -> transition.pause()));
        transition.setCycleCount(1);
        return timeline;
    }


    public void LPB(EventHandler<ActionEvent> leftPlant) {
        CabbageLeftButton.setOnAction(leftPlant);
    }


    public Timeline setPathRP() {
        Line line = new Line();
        line.setStartX(0);
        line.setStartY(10);
        line.setEndX(-480);
        line.setEndY(55);
        PathTransition transition = new PathTransition();
        transition.setNode(CabbageRightButton);
        transition.setDuration(Duration.seconds(2));
        transition.setPath(line);
        Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(0), event1 -> transition.play()), new KeyFrame(Duration.seconds(5), event1 -> transition.pause()));
        transition.setCycleCount(1);

        return timeline;
    }


    public Timeline setPathRPBack() {
        Line line = new Line();
        line.setStartX(-480);
        line.setStartY(55);
        line.setEndX(0);
        line.setEndY(10);
        PathTransition transition = new PathTransition();
        transition.setNode(CabbageRightButton);
        transition.setDuration(Duration.seconds(2));
        transition.setPath(line);
        Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(0), event1 -> transition.play()), new KeyFrame(Duration.seconds(5), event1 -> transition.pause()));
        transition.setCycleCount(1);

        return timeline;
    }


    public void RPB(EventHandler<ActionEvent> rightPlant) {
        CabbageRightButton.setOnAction(rightPlant);
    }


    public ParallelTransition setPathBoatLeft() {
        Line line = new Line();
        line.setStartX(350);
        line.setStartY(110);
        line.setEndX(640);
        line.setEndY(280);
        PathTransition transition = new PathTransition();
        transition.setNode(FarmerLeftButton);
        transition.setDuration(Duration.seconds(2));
        transition.setPath(line);
        PathTransition transition2 = new PathTransition();
        Line line2 = new Line();
        line2.setStartX(150);
        line2.setStartY(140);
        line2.setEndX(450);
        line2.setEndY(310);
        transition2.setNode(BoatView);
        transition2.setDuration(Duration.seconds(2));
        transition2.setPath(line2);
        PathTransition transition3 = new PathTransition();
        Line line3 = new Line();
        line3.setStartX(150);
        line3.setStartY(140);
        line3.setEndX(450);
        line3.setEndY(310);
        transition3.setNode(SheepLeftButton);
        transition3.setDuration(Duration.seconds(2));
        transition3.setPath(line3);
        PathTransition transition4 = new PathTransition();
        Line line4 = new Line();
        line4.setStartX(250);
        line4.setStartY(140);
        line4.setEndX(580);
        line4.setEndY(310);
        transition4.setNode(WolfLeftButton);
        transition4.setDuration(Duration.seconds(2));
        transition4.setPath(line4);
        PathTransition transition5 = new PathTransition();
        Line line5 = new Line();
        line5.setStartX(140);
        line5.setStartY(90);
        line5.setEndX(460);
        line5.setEndY(280);
        transition5.setNode(CabbageLeftButton);
        transition5.setDuration(Duration.seconds(2));
        transition5.setPath(line5);
        ParallelTransition parallelTransition = new ParallelTransition();
        parallelTransition.getChildren().add(transition2);
        if(FarmerOnBoard)
        parallelTransition.getChildren().add(transition);
        parallelTransition.setCycleCount(1);
        if (SheepOnBoard == true)
            parallelTransition.getChildren().add(transition3);
        if (WolfOnBoard == true)
            parallelTransition.getChildren().add(transition4);
        if (CabbageOnBoard == true)
            parallelTransition.getChildren().add(transition5);
        return parallelTransition;
    }

    public ParallelTransition setPathBoatRight() {
        Line line = new Line();
        line.setStartX(-350);
        line.setStartY(210);
        line.setEndX(-540);
        line.setEndY(50);
        PathTransition transition = new PathTransition();
        transition.setNode(FarmerRightButton);
        transition.setDuration(Duration.seconds(2));
        transition.setPath(line);
        PathTransition transition2 = new PathTransition();
        Line line2 = new Line();
        line2.setStartX(450);
        line2.setStartY(310);
        line2.setEndX(170);
        line2.setEndY(150);
        transition2.setNode(BoatView);
        transition2.setDuration(Duration.seconds(2));
        transition2.setPath(line2);
        PathTransition transition3 = new PathTransition();
        Line line3 = new Line();
        line3.setStartX(-350);
        line3.setStartY(150);
        line3.setEndX(-670);
        line3.setEndY(0);
        transition3.setNode(SheepRightButton);
        transition3.setDuration(Duration.seconds(2));
        transition3.setPath(line3);
        PathTransition transition4 = new PathTransition();
        Line line4 = new Line();
        line4.setStartX(-360);
        line4.setStartY(140);
        line4.setEndX(-600);
        line4.setEndY(-40);
        transition4.setNode(WolfRightButton);
        transition4.setDuration(Duration.seconds(2));
        transition4.setPath(line4);
        PathTransition transition5 = new PathTransition();
        Line line5 = new Line();
        line5.setStartX(-350);
        line5.setStartY(80);
        line5.setEndX(-700);
        line5.setEndY(-100);
        transition5.setNode(CabbageRightButton);
        transition5.setDuration(Duration.seconds(2));
        transition5.setPath(line5);
        ParallelTransition parallelTransition = new ParallelTransition();
        parallelTransition.getChildren().add(transition2);
        if(FarmerOnBoard)
        parallelTransition.getChildren().add(transition);
        if (SheepOnBoard == true)
            parallelTransition.getChildren().add(transition3);
        if (WolfOnBoard == true)
            parallelTransition.getChildren().add(transition4);
        if (CabbageOnBoard == true)
            parallelTransition.getChildren().add(transition5);
        parallelTransition.setCycleCount(1);
        return parallelTransition;
    }

    public void playSet(EventHandler<MouseEvent> playButton) {
        play.setOnMouseClicked(playButton);
    }


    public void errorLabel() {
        Image error = new Image("file:label-removebg.png");
        ImageView errorView = new ImageView(error);
        Text errortext = new Text("\r\nINVALID MOVE :(");
        Image exit = new Image("file:exitLabel-removebg.png");
        ImageView exitView = new ImageView(exit);
        Button exitButton = new Button();
        exitButton.setStyle("-fx-background-color: transparent;");
        exitButton.setGraphic(exitView);
        exitButton.setLayoutX(500);
        exitButton.setLayoutY(250);
        exitView.setFitWidth(40);
        exitView.setFitHeight(40);
        errortext.setFont(Font.font(Font.getFontNames().get(0),
                FontWeight.EXTRA_BOLD, 30));
        errortext.setLayoutX(590);
        errortext.setLayoutY(340);
        errorView.setLayoutX(400);
        errorView.setLayoutY(170);

        root.getChildren().add(errorView);
        root.getChildren().add(errortext);
        root.getChildren().add(exitButton);
        exitButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                errorView.setVisible(false);
                errortext.setVisible(false);
                exitButton.setVisible(false);
            }
        });
    }

    public void LevelCompleted(int no_of_sails) {


        String musicFile = "lololloloyyyy.mp3";
        Media sound = new Media((new File(musicFile)).toURI().toString());
        MediaPlayer mediaPlayer = new MediaPlayer(sound);
        mediaPlayer.setVolume(800D);
        //  mediaPlayer.setStopTime(Duration.minutes(2.36D));
        mediaPlayer.seek(mediaPlayer.getStartTime());
        mediaPlayer.setAutoPlay(true);
        MediaView mediaView = new MediaView(mediaPlayer);
        root.getChildren().add(mediaView);

        ImageView LevelView = new ImageView("file:label-removebg.png");
        ImageView threestars = new ImageView("file:download-removebg.png");
        ImageView LevelComplete = new ImageView("file:LevelComplete.png");
        Text NumberOfSails = new Text("Number of sails= "+ no_of_sails);
        NumberOfSails.setFont(Font.font(Font.getFontNames().get(0),
                FontWeight.EXTRA_BOLD, 30));
        Image exit = new Image("file:buttons-game-png-8.png");
        ImageView exitView = new ImageView(exit);
        exitView.setFitHeight(70);
        exitView.setFitWidth(140);
        Button exitButton = new Button();
        exitButton.setStyle("-fx-background-color: transparent;");
        exitButton.setGraphic(exitView);
        LevelView.setLayoutX(180);
        LevelView.setLayoutY(60);
        LevelView.setFitWidth(900);
        LevelView.setFitHeight(700);
        root.getChildren().add(LevelView);
        threestars.setLayoutX(400);
        threestars.setLayoutY(80);
        root.getChildren().add(threestars);
        LevelComplete.setLayoutX(350);
        LevelComplete.setLayoutY(220);
        LevelComplete.setFitWidth(500);
        root.getChildren().add(LevelComplete);
        NumberOfSails.setLayoutX(400);
        NumberOfSails.setLayoutY(400);
        root.getChildren().add(NumberOfSails);
        exitButton.setLayoutX(530);
        exitButton.setLayoutY(480);
        root.getChildren().add(exitButton);

exitButton.setOnAction(new EventHandler<ActionEvent>() {
    @Override
    public void handle(ActionEvent event) {
        XMLWriterDOMS2 write=new XMLWriterDOMS2();
        ReadXMLFileS2 read=new ReadXMLFileS2();
        LevelTwo x=new LevelTwo(new Stage());
        x.prepareScene();
        S2Events y=new S2Events(x);
        // y.Events();
        S2Controller z=new S2Controller();
        write.setController(z);
        y.setController(z);
        z.setS2Events(y);
        z.setY(read);
        z.setX(write);
        z.newGame(new StoryTwo());
    }
});
    }

    public void UndoMovement(EventHandler<MouseEvent> UndoM) {
        undo.setOnMouseClicked(UndoM);
    }


    public void redoMovement(EventHandler<MouseEvent> redoM){

        redo.setOnMouseClicked(redoM);
    }

}