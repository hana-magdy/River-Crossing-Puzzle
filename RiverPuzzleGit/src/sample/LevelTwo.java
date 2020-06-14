package sample;


import Crossers.Farmer.FarmersStory2;
import Crossers.Herb.Goat;
import Strategy.StoryTwo;
import javafx.animation.ParallelTransition;
import javafx.animation.PathTransition;
import javafx.animation.Transition;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class LevelTwo {
    Button Save;
    Button Load;

    Button redo = new Button();

    Stage stage;
    Group root = new Group();
    Scene levelTwoScene = new Scene(root, 1400, 800);
    // Canvas canvas = new Canvas(1400, 800);
    StoryTwo test = new StoryTwo();
    Button farmerManLeftButton;
    Button farmerManRightButton;
    Button farmerWomanLeftButton;
    Button farmerWomanRightButton;
    Button farmerGirlLeftButton;
    Button farmerGirlRightButton;
    Button farmerBoyLeftButton;
    Button farmerBoyRightButton;
    Button goatLeftButton;
    Button goatRightButton;
    Button play;

    ImageView farmerManLeftView;
    ImageView farmerManRightView;
    ImageView farmerWomanLeftView;
    ImageView farmerWomanRightView;
    ImageView farmerGirlLeftView;
    ImageView farmerGirlRightView;
    ImageView farmerBoyLeftView;
    ImageView farmerBoyRightView;
    ImageView goatLeftView;
    ImageView goatRightView;
    ImageView BoatView;

    Boolean boatOnRight = false;

    public Button getFarmerManLeftButton() {
        return farmerManLeftButton;
    }

    public void setFarmerManLeftButton(Button farmerManLeftButton) {
        this.farmerManLeftButton = farmerManLeftButton;
    }

    public Button getFarmerManRightButton() {
        return farmerManRightButton;
    }

    public void setFarmerManRightButton(Button farmerManRightButton) {
        this.farmerManRightButton = farmerManRightButton;
    }

    public Button getFarmerWomanLeftButton() {
        return farmerWomanLeftButton;
    }

    public void setFarmerWomanLeftButton(Button farmerWomanLeftButton) {
        this.farmerWomanLeftButton = farmerWomanLeftButton;
    }

    public Button getFarmerWomanRightButton() {
        return farmerWomanRightButton;
    }

    public void setFarmerWomanRightButton(Button farmerWomanRightButton) {
        this.farmerWomanRightButton = farmerWomanRightButton;
    }

    public Button getFarmerGirlLeftButton() {
        return farmerGirlLeftButton;
    }

    public void setFarmerGirlLeftButton(Button farmerGirlLeftButton) {
        this.farmerGirlLeftButton = farmerGirlLeftButton;
    }

    public Button getFarmerGirlRightButton() {
        return farmerGirlRightButton;
    }

    public void setFarmerGirlRightButton(Button farmerGirlRightButton) {
        this.farmerGirlRightButton = farmerGirlRightButton;
    }

    public Button getFarmerBoyLeftButton() {
        return farmerBoyLeftButton;
    }

    public void setFarmerBoyLeftButton(Button farmerBoyLeftButton) {
        this.farmerBoyLeftButton = farmerBoyLeftButton;
    }

    public Button getFarmerBoyRightButton() {
        return farmerBoyRightButton;
    }

    public void setFarmerBoyRightButton(Button farmerBoyRightButton) {
        this.farmerBoyRightButton = farmerBoyRightButton;
    }

    public Button getGoatLeftButton() {
        return goatLeftButton;
    }

    public void setGoatLeftButton(Button goatLeftButton) {
        this.goatLeftButton = goatLeftButton;
    }

    public Button getGoatRightButton() {
        return goatRightButton;
    }

    public void setGoatRightButton(Button goatRightButton) {
        this.goatRightButton = goatRightButton;
    }

    public Button getPlay() {
        return play;
    }

    public void setPlay(Button play) {
        this.play = play;
    }

    public Boolean getBoatOnRight() {
        return boatOnRight;
    }

    public void setBoatOnRight(Boolean boatOnRight) {
        this.boatOnRight = boatOnRight;
    }

    public Boolean getManOnBoard() {
        return manOnBoard;
    }

    public void setManOnBoard(Boolean manOnBoard) {
        this.manOnBoard = manOnBoard;
    }

    public Boolean getWomanOnBoard() {
        return womanOnBoard;
    }

    public void setWomanOnBoard(Boolean womanOnBoard) {
        this.womanOnBoard = womanOnBoard;
    }

    public Boolean getGirlOnBoard() {
        return girlOnBoard;
    }

    public void setGirlOnBoard(Boolean girlOnBoard) {
        this.girlOnBoard = girlOnBoard;
    }

    public Boolean getBoyOnBoard() {
        return boyOnBoard;
    }

    public void setBoyOnBoard(Boolean boyOnBoard) {
        this.boyOnBoard = boyOnBoard;
    }

    public Boolean getGoatOnBoard() {
        return goatOnBoard;
    }

    public void setGoatOnBoard(Boolean goatOnBoard) {
        this.goatOnBoard = goatOnBoard;
    }

    Boolean manOnBoard = false;
    Boolean womanOnBoard = false;
    Boolean girlOnBoard = false;
    Boolean boyOnBoard = false;
    Boolean goatOnBoard = false;
    Button undo = new Button();

    public LevelTwo(Stage stage) {

        this.stage = stage;
    }



    public void LevelCompleted() {


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
        Text NumberOfSails = new Text("Number of sails=");
        NumberOfSails.setFont(Font.font(Font.getFontNames().get(0),
                FontWeight.EXTRA_BOLD, 30));
        //  Image exit = new Image("file:buttons-game-png-8.png");
        // ImageView exitView = new ImageView(exit);
        //exitView.setFitHeight(70);
        //exitView.setFitWidth(140);
        //Button exitButton =  new Button();
        //exitButton.setStyle("-fx-background-color: transparent;");
        //exitButton.setGraphic(exitView);
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
        //exitButton.setLayoutX(530);
        //exitButton.setLayoutY(480);
        //root.getChildren().add(exitButton);


    }




    public void LoadBuffer() throws IOException {
        FarmersStory2 loading = new FarmersStory2();

        BufferedImage[] ManBuffer;
        ManBuffer = loading.getFarmerMan();
        Image LeftMan = SwingFXUtils.toFXImage(ManBuffer[0], null);
        farmerManLeftView = new ImageView(LeftMan);
        Image RightMan = SwingFXUtils.toFXImage(ManBuffer[1], null);
        farmerManRightView = new ImageView(RightMan);

        BufferedImage[] WomanBuffer;
        WomanBuffer = loading.getFarmerWoman();
        Image LeftWoman = SwingFXUtils.toFXImage(WomanBuffer[0], null);
        farmerWomanLeftView = new ImageView(LeftWoman);
        Image RightWoman = SwingFXUtils.toFXImage(WomanBuffer[1], null);
        farmerWomanRightView = new ImageView(RightWoman);

        BufferedImage[] GirlBuffer;
        GirlBuffer = loading.getFarmerGirl();
        Image LeftGirl = SwingFXUtils.toFXImage(GirlBuffer[0], null);
        farmerGirlLeftView = new ImageView(LeftGirl);
        Image rightGirl = SwingFXUtils.toFXImage(GirlBuffer[1], null);
        farmerGirlRightView = new ImageView(rightGirl);

        BufferedImage[] BoyBuffer;
        BoyBuffer = loading.getFarmerBoy();
        Image LeftBoy = SwingFXUtils.toFXImage(BoyBuffer[0], null);
        farmerBoyLeftView = new ImageView(LeftBoy);
        Image RightBoy = SwingFXUtils.toFXImage(BoyBuffer[1], null);
        farmerBoyRightView = new ImageView(RightBoy);

        BufferedImage[] GoatBuffer;
        Goat goat = new Goat(20);
        GoatBuffer = goat.getImages();
        Image LeftGoat = SwingFXUtils.toFXImage(GoatBuffer[0], null);
        goatLeftView = new ImageView(LeftGoat);
        Image RightGoat = SwingFXUtils.toFXImage(GoatBuffer[1], null);
        goatRightView = new ImageView(RightGoat);
    }

    public void prepareLeftFarmerMan() {

        farmerManLeftButton = new Button();
        farmerManLeftButton.setGraphic(farmerManLeftView);
        farmerManLeftButton.setStyle("-fx-background-color: transparent;");
        farmerManLeftButton.setLayoutX(400);
        farmerManLeftButton.setLayoutY(280);
        root.getChildren().add(farmerManLeftButton);
        farmerManLeftButton.setVisible(true);

    }

    public void prepareRightFarmerMan() {

        farmerManRightButton = new Button();
        farmerManRightButton.setGraphic(farmerManRightView);
        farmerManRightButton.setStyle("-fx-background-color: transparent;");
        farmerManRightButton.setLayoutX(1000);
        farmerManRightButton.setLayoutY(350);
        root.getChildren().add(farmerManRightButton);
        farmerManRightButton.setVisible(true);

    }


    public void prepareLeftFarmerWoman() {

        farmerWomanLeftButton = new Button();
        farmerWomanLeftButton.setGraphic(farmerWomanLeftView);
        farmerWomanLeftButton.setStyle("-fx-background-color: transparent;");
        farmerWomanLeftButton.setLayoutX(360);
        farmerWomanLeftButton.setLayoutY(350);
        root.getChildren().add(farmerWomanLeftButton);
        farmerWomanLeftButton.setVisible(true);

    }

    public void prepareRightFarmerWoman() {

        farmerWomanRightButton = new Button();
        farmerWomanRightButton.setGraphic(farmerWomanRightView);
        farmerWomanRightButton.setStyle("-fx-background-color: transparent;");
        farmerWomanRightButton.setLayoutX(980);
        farmerWomanRightButton.setLayoutY(480);
        root.getChildren().add(farmerWomanRightButton);
        farmerWomanRightButton.setVisible(true);

    }


    public void prepareLeftFarmerGirl() {

        farmerGirlLeftButton = new Button();
        farmerGirlLeftButton.setGraphic(farmerGirlLeftView);
        farmerGirlLeftButton.setStyle("-fx-background-color: transparent;");
        farmerGirlLeftButton.setLayoutX(290);
        farmerGirlLeftButton.setLayoutY(370);
        root.getChildren().add(farmerGirlLeftButton);
        farmerGirlLeftButton.setVisible(true);

    }

    public void prepareRightFarmerGirl() {

        farmerGirlRightButton = new Button();
        farmerGirlRightButton.setGraphic(farmerGirlRightView);
        farmerGirlRightButton.setStyle("-fx-background-color: transparent;");
        farmerGirlRightButton.setLayoutX(1080);
        farmerGirlRightButton.setLayoutY(500);
        root.getChildren().add(farmerGirlRightButton);
        farmerGirlRightButton.setVisible(true);

    }


    public void prepareLeftFarmerBoy() {

        farmerBoyLeftButton = new Button();
        farmerBoyLeftButton.setGraphic(farmerBoyLeftView);
        farmerBoyLeftButton.setStyle("-fx-background-color: transparent;");
        farmerBoyLeftButton.setLayoutX(230);
        farmerBoyLeftButton.setLayoutY(370);
        root.getChildren().add(farmerBoyLeftButton);
        farmerBoyLeftButton.setVisible(true);

    }


    public void prepareRightFarmerBoy() {

        farmerBoyRightButton = new Button();
        farmerBoyRightButton.setGraphic(farmerBoyRightView);
        farmerBoyRightButton.setStyle("-fx-background-color: transparent;");
        farmerBoyRightButton.setLayoutX(980);
        farmerBoyRightButton.setLayoutY(550);
        root.getChildren().add(farmerBoyRightButton);
        farmerBoyRightButton.setVisible(true);

    }

    public void prepareLeftGoat() {

        goatLeftButton = new Button();
        goatLeftButton.setGraphic(goatLeftView);
        goatLeftButton.setStyle("-fx-background-color: transparent;");
        goatLeftButton.setLayoutX(170);
        goatLeftButton.setLayoutY(450);
        root.getChildren().add(goatLeftButton);
        goatLeftButton.setVisible(true);


    }


    public void prepareRightGoat() {

        goatRightButton = new Button();
        goatRightButton.setGraphic(goatRightView);
        goatRightButton.setStyle("-fx-background-color: transparent;");
        goatRightButton.setLayoutX(930);
        goatRightButton.setLayoutY(630);
        root.getChildren().add(goatRightButton);
        goatRightButton.setVisible(true);
    }

    public void prepareBoat() {

        BoatView = new ImageView("file:raft.png");
        BoatView.setLayoutX(320);
        BoatView.setLayoutY(420);
        root.getChildren().add(BoatView);
    }

    public void prepareScene() {

        try {
            LoadBuffer();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Image river = new Image("file:riverBanks.jpg");
        ImageView riverBanks = new ImageView(river);
        riverBanks.setFitWidth(1400);
        riverBanks.setFitHeight(800);
        root.getChildren().add(riverBanks);


        play = new Button();
        play.setShape(new Circle(50));
        Image sail = new Image("file:sail.png");
        ImageView readysail = new ImageView(sail);
        readysail.setFitWidth(50);
        readysail.setFitHeight(50);
        play.setGraphic(readysail);
        play.setStyle("-fx-background-color: transparent;");
        root.getChildren().add(play);
        readysail.setLayoutX(1200);
        readysail.setLayoutY(50);


        Button restart = new Button();
        restart.setShape(new Circle(20));
        Image restartImg = new Image("file:restart.png");
        ImageView restartView = new ImageView(restartImg);
        restartView.setFitWidth(35);
        restartView.setFitHeight(35);
        restart.setGraphic(restartView);
        restart.setStyle("-fx-background-color: transparent;");
        root.getChildren().add(restart);
        restart.setLayoutX(1300);
        restart.setLayoutY(10);

        Button help = new Button();
        help.setShape(new Circle(20));
        Image helpImg = new Image("file:help.png");
        ImageView helpView = new ImageView(helpImg);
        helpView.setFitWidth(35);
        helpView.setFitHeight(35);
        help.setGraphic(helpView);
        help.setStyle("-fx-background-color: transparent;");
        root.getChildren().add(help);
        help.setLayoutX(1300);
        help.setLayoutY(70);

        Image undoImg = new Image("file:undo.png");
        ImageView undoView = new ImageView(undoImg);
        undoView.setFitWidth(40);
        undoView.setFitHeight(40);
        undo.setGraphic(undoView);
        undo.setStyle("-fx-background-color: transparent;");
        root.getChildren().add(undo);
        undo.setLayoutX(5);
        undo.setLayoutY(50);

        Image redoImg = new Image("file:redo.png");
        ImageView redoView = new ImageView(redoImg);
        redoView.setFitWidth(40);
        redoView.setFitHeight(40);
        redo.setGraphic(redoView);
        redo.setStyle("-fx-background-color: transparent;");

        redo.setLayoutX(5);
        redo.setLayoutY(90);
        root.getChildren().add(redo);

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




        prepareBoat();
        prepareLeftFarmerMan();
        prepareRightFarmerMan();
        prepareLeftFarmerWoman();
        prepareRightFarmerWoman();
        prepareLeftFarmerGirl();
        prepareRightFarmerGirl();
        prepareLeftFarmerBoy();
        prepareRightFarmerBoy();
        prepareLeftGoat();
        prepareRightGoat();

        farmerManRightButton.setVisible(false);
        farmerWomanRightButton.setVisible(false);
        farmerGirlRightButton.setVisible(false);
        farmerBoyRightButton.setVisible(false);
        goatRightButton.setVisible(false);

        stage.setScene(levelTwoScene);
        stage.show();
        ShowInstructions();
        //errorLabel();
//        LevelCompleted();
    }


    public ParallelTransition setPathBoatLeft() {
        PathTransition boatTransition = new PathTransition();
        Line line = new Line();
        line.setStartX(150);
        line.setStartY(140);
        line.setEndX(400);
        line.setEndY(250);
        boatTransition.setNode(BoatView);
        boatTransition.setDuration(Duration.seconds(2));
        boatTransition.setPath(line);

        PathTransition manTransition = new PathTransition();
        Line line2 = new Line();
        line2.setStartX(100);
        line2.setStartY(100);
        line2.setEndX(380);
        line2.setEndY(210);
        manTransition.setNode(farmerManLeftButton);
        manTransition.setDuration(Duration.seconds(2));
        manTransition.setPath(line2);

        PathTransition womanTransition = new PathTransition();
        Line line3 = new Line();
        line3.setStartX(70);
        line3.setStartY(50);
        line3.setEndX(350);
        line3.setEndY(180);
        womanTransition.setNode(farmerWomanLeftButton);
        womanTransition.setDuration(Duration.seconds(2));
        womanTransition.setPath(line3);

        PathTransition girlTransition = new PathTransition();
        Line line4 = new Line();
        line4.setStartX(70);
        line4.setStartY(70);
        line4.setEndX(320);
        line4.setEndY(180);
        girlTransition.setNode(farmerGirlLeftButton);
        girlTransition.setDuration(Duration.seconds(2));
        girlTransition.setPath(line4);

        PathTransition boyTransition = new PathTransition();
        Line line5 = new Line();
        line5.setStartX(80);
        line5.setStartY(50);
        line5.setEndX(320);
        line5.setEndY(160);
        boyTransition.setNode(farmerBoyLeftButton);
        boyTransition.setDuration(Duration.seconds(2));
        boyTransition.setPath(line5);

        PathTransition goatTransition = new PathTransition();
        Line line6 = new Line();
        line6.setStartX(40);
        line6.setStartY(40);
        line6.setEndX(330);
        line6.setEndY(150);
        goatTransition.setNode(goatLeftButton);
        goatTransition.setDuration(Duration.seconds(2));
        goatTransition.setPath(line6);


        ParallelTransition parallelTransition = new ParallelTransition();
        parallelTransition.getChildren().add(boatTransition);

        if (manOnBoard == true)
            parallelTransition.getChildren().add(manTransition);
        if (womanOnBoard == true)
            parallelTransition.getChildren().add(womanTransition);
        if (girlOnBoard == true)
            parallelTransition.getChildren().addAll(girlTransition);
        if (boyOnBoard == true)
            parallelTransition.getChildren().addAll(boyTransition);
        if (goatOnBoard == true)
            parallelTransition.getChildren().addAll(goatTransition);


        parallelTransition.setCycleCount(1);
        return parallelTransition;
    }


    public ParallelTransition setPathBoatRight() {
        PathTransition boatTransition = new PathTransition();
        Line line = new Line();
        line.setStartX(380);
        line.setStartY(250);
        line.setEndX(170);
        line.setEndY(150);
        boatTransition.setNode(BoatView);
        boatTransition.setDuration(Duration.seconds(2));
        boatTransition.setPath(line);

        PathTransition manTransition = new PathTransition();
        Line line2 = new Line();
        line2.setStartX(130);
        line2.setStartY(150);
        line2.setEndX(-100);
        line2.setEndY(20);
        manTransition.setNode(farmerManRightButton);
        manTransition.setDuration(Duration.seconds(2));
        manTransition.setPath(line2);

        PathTransition womanTransition = new PathTransition();
        Line line3 = new Line();
        line3.setStartX(100);
        line3.setStartY(70);
        line3.setEndX(-110);
        line3.setEndY(0);
        womanTransition.setNode(farmerWomanRightButton);
        womanTransition.setDuration(Duration.seconds(2));
        womanTransition.setPath(line3);

        PathTransition girlTransition = new PathTransition();
        Line line4 = new Line();
        line4.setStartX(30);
        line4.setStartY(80);
        line4.setEndX(-170);
        line4.setEndY(0);
        girlTransition.setNode(farmerGirlRightButton);
        girlTransition.setDuration(Duration.seconds(2));
        girlTransition.setPath(line4);

        PathTransition boyTransition = new PathTransition();
        Line line5 = new Line();
        line5.setStartX(50);
        line5.setStartY(80);
        line5.setEndX(-150);
        line5.setEndY(-30);
        boyTransition.setNode(farmerBoyRightButton);
        boyTransition.setDuration(Duration.seconds(2));
        boyTransition.setPath(line5);

        PathTransition goatTransition = new PathTransition();
        Line line6 = new Line();
        line6.setStartX(50);
        line6.setStartY(40);
        line6.setEndX(-180);
        line6.setEndY(-70);
        goatTransition.setNode(goatRightButton);
        goatTransition.setDuration(Duration.seconds(2));
        goatTransition.setPath(line6);

        ParallelTransition parallelTransition = new ParallelTransition();
        parallelTransition.getChildren().add(boatTransition);

        if (manOnBoard == true)
            parallelTransition.getChildren().add(manTransition);
        if (womanOnBoard == true)
            parallelTransition.getChildren().add(womanTransition);
        if (girlOnBoard == true)
            parallelTransition.getChildren().add(girlTransition);
        if (boyOnBoard == true)
            parallelTransition.getChildren().add(boyTransition);
        if (goatOnBoard == true)
            parallelTransition.getChildren().add(goatTransition);

        parallelTransition.setCycleCount(1);
        return parallelTransition;
    }


    public void play(EventHandler<ActionEvent> boatMove) {
        play.setOnAction(boatMove);
    }


    public void setPathML() {
        farmerManLeftButton.setLayoutX(400);
        farmerManLeftButton.setLayoutY(350);
    }

    public void LM(EventHandler<ActionEvent> LFM) {
        farmerManLeftButton.setOnAction(LFM);
    }

    public void setPathMLBack() {
        farmerManLeftButton.setLayoutX(400);
        farmerManLeftButton.setLayoutY(280);
    }


    public void setPathMR() {

        farmerManRightButton.setLayoutX(580);
        farmerManRightButton.setLayoutY(420);
    }

    public void setPathMRBack() {
        farmerManRightButton.setLayoutX(1000);
        farmerManRightButton.setLayoutY(350);
    }

    public void RM(EventHandler<ActionEvent> RFM) {
        farmerManRightButton.setOnAction(RFM);

    }


    public void setPathWL() {
        farmerWomanLeftButton.setLayoutX(410);
        farmerWomanLeftButton.setLayoutY(420);
    }

    public void setPathWLBack() {
        farmerWomanLeftButton.setLayoutX(360);
        farmerWomanLeftButton.setLayoutY(350);

    }

    public void LW(EventHandler<ActionEvent> LW) {
        farmerWomanLeftButton.setOnAction(LW);

    }

    public void setPathWR() {

        farmerWomanRightButton.setLayoutX(600);
        farmerWomanRightButton.setLayoutY(490);
    }

    public void setPathWRBack() {
        farmerWomanRightButton.setLayoutX(980);
        farmerWomanRightButton.setLayoutY(480);

    }

    public void RW(EventHandler<ActionEvent> RW) {
        farmerWomanRightButton.setOnAction(RW);

    }

    public void setPathGL() {
        farmerGirlLeftButton.setLayoutX(380);
        farmerGirlLeftButton.setLayoutY(420);

    }

    public void setPathGLBack() {
        farmerGirlLeftButton.setLayoutX(290);
        farmerGirlLeftButton.setLayoutY(370);
    }

    public void LG(EventHandler<ActionEvent> GL) {
        farmerGirlLeftButton.setOnAction(GL);
    }

    public void setPathGR() {
        farmerGirlRightButton.setLayoutX(610);
        farmerGirlRightButton.setLayoutY(490);
    }

    public void setPathGRBack() {

        farmerGirlRightButton.setLayoutX(1080);
        farmerGirlRightButton.setLayoutY(500);
    }

    public void RG(EventHandler<ActionEvent> GR) {
        farmerGirlRightButton.setOnAction(GR);
    }

    public void setPathBL() {
        farmerBoyLeftButton.setLayoutX(430);
        farmerBoyLeftButton.setLayoutY(440);
    }

    public void setPathBLBack() {
        farmerBoyLeftButton.setLayoutX(230);
        farmerBoyLeftButton.setLayoutY(370);
    }

    public void LB(EventHandler<ActionEvent> LB) {
        farmerBoyLeftButton.setOnAction(LB);
    }

    public void setPathRB() {
        farmerBoyRightButton.setLayoutX(670);
        farmerBoyRightButton.setLayoutY(500);
    }

    public void setPathRBBack() {
        farmerBoyRightButton.setLayoutX(980);
        farmerBoyRightButton.setLayoutY(550);
    }

    public void RB(EventHandler<ActionEvent> BR) {
        farmerBoyRightButton.setOnAction(BR);
    }

    public void setPathLGoat() {
        goatLeftButton.setLayoutX(380);
        goatLeftButton.setLayoutY(500);

    }

    public void setPathLGoatBack() {
        goatLeftButton.setLayoutX(170);
        goatLeftButton.setLayoutY(450);
    }

    public void LGoat(EventHandler<ActionEvent> LGoat) {
        goatLeftButton.setOnAction(LGoat);
    }

    public void setPathRGoat() {
        goatRightButton.setLayoutX(650);
        goatRightButton.setLayoutY(600);
    }

    public void setPathRGoatBack() {
        goatRightButton.setLayoutX(930);
        goatRightButton.setLayoutY(630);
    }

    public void RGoat(EventHandler<ActionEvent> RGoat) {
        goatRightButton.setOnAction(RGoat);
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


    public void ShowInstructions() {
        // ImageView instructionsTitle = new ImageView("file:kisspng-banner-gold-yellow-price-tag-sign-5aa63263eacf52.8791285515208413159618.jpg");
        //root.getChildren().add(instructionsTitle);
        Image instructions = new Image("file:label-removebg.png");
        ImageView instructionsView = new ImageView(instructions);
        Text instructingText = new Text("                                                               INSTRUCTIONS \r\n" + test.getInstructions()[0]);
        instructingText.setFont(Font.font(Font.getFontNames().get(0),
                FontWeight.EXTRA_BOLD, 22));
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


    public void undoMovement(EventHandler<MouseEvent> x){
        undo.setOnMouseClicked(x);
    }

    public void redoMovement(EventHandler<MouseEvent> x){
        redo.setOnMouseClicked(x);
    }




    public  void  saving (EventHandler<ActionEvent> SaveScene){
        Save.setOnAction(SaveScene);

    }

    public void loading (EventHandler<ActionEvent> loadingScene){
        Load.setOnAction(loadingScene);
    }

}
