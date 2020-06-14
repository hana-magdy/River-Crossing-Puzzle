//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package sample;

import java.io.File;
import java.io.FileNotFoundException;

import javafx.animation.Animation;
import javafx.animation.ParallelTransition;
import javafx.animation.PathTransition;
import javafx.animation.PathTransition.OrientationType;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.effect.Glow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.CubicCurveTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Main extends Application {
    public Main() {
    }

    public static void main(String[] args) {
        launch(args);
    }

    public void start(Stage stage) throws FileNotFoundException {

        LevelsMenu levelsMenuScene = new LevelsMenu(stage);
        levelsMenuScene.prepareScene();

        LevelOne levelOneScene = new LevelOne(stage);
        LevelTwo levelTwoScene= new LevelTwo(stage);
        levelOneScene.PrepareScene();
        levelTwoScene.prepareScene();
        //levelOneScene.Move();
        //levelTwoScene.move();
       // levelOneScene.mouseDragDropped();

        levelsMenuScene.setLevelOneScene(levelOneScene);
        levelsMenuScene.setLevelTwoScene(levelTwoScene);


        String musicFile = "Shaun The Sheep Theme Song - Lagu Anak Terbaru.mp3";
        Media sound = new Media((new File(musicFile)).toURI().toString());
        MediaPlayer mediaPlayer = new MediaPlayer(sound);
        mediaPlayer.setVolume(200.0D);
        mediaPlayer.setStopTime(Duration.minutes(2.36D));
        mediaPlayer.seek(mediaPlayer.getStartTime());
        mediaPlayer.setAutoPlay(true);
        MediaView mediaView = new MediaView(mediaPlayer);

        Image image = new Image("file:nature-background-design_1308-249.jpg");
        ImageView imageView = new ImageView(image);
        imageView.setFitHeight(500.0D);
        imageView.setFitWidth(600.0D);

        Group root = new Group(new Node[]{imageView});
        Path path = new Path();
        MoveTo moveTo = new MoveTo();
        moveTo.setX(0.0D);
        moveTo.setY(0.0D);
        CubicCurveTo cubicTo = new CubicCurveTo();
        cubicTo.setControlX1(0.0D);
        cubicTo.setControlY1(0.0D);
        cubicTo.setControlX2(100.0D);
        cubicTo.setControlY2(100.0D);
        cubicTo.setX(100.0D);
        cubicTo.setY(50.0D);
        path.getElements().add(moveTo);
        path.getElements().add(cubicTo);
        path.setOpacity(0.0D);
        PathTransition pathTransition = new PathTransition();
        pathTransition.setDuration(Duration.seconds(4.0D));
        pathTransition.setDelay(Duration.seconds(0.0D));
        pathTransition.setPath(path);
        Text title = new Text("River Crossing");
        title.setLayoutX(275.0D);
        title.setLayoutY(250.0D);
        title.setFill(Color.YELLOW);
        title.setFont(Font.font("Verdana", 50.0D));
        title.setEffect(new Glow(0.5D));
        pathTransition.setNode(title);
        pathTransition.setOrientation(OrientationType.NONE);
        pathTransition.setCycleCount(-1);
        pathTransition.setAutoReverse(true);
        ParallelTransition parallelTransition = new ParallelTransition(new Animation[]{pathTransition});
        parallelTransition.play();


        Image startGame = new Image("file:red-start-button-concept_23-2147918020_burned.png");
        ImageView imageView2 = new ImageView(startGame);
        imageView2.setFitWidth(80.0D);
        imageView2.setFitHeight(80.0D);

        Button start = new Button();
        start.setGraphic(imageView2);
        start.setStyle("-fx-background-color: transparent;");
        start.setShape(new Circle(40.0D));
        start.setLayoutY(335.0D);
        start.setLayoutX(250.0D);

        root.getChildren().add(path);
        root.getChildren().add(title);
       root.getChildren().add(mediaView);
        root.getChildren().add(start);

        Scene scene = new Scene(root, 600.0D, 500.0D);


        start.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {

                stage.setScene(levelsMenuScene.levelsMenuScene);
            }

        });

        stage.setTitle("River Crossing");
        stage.setScene(scene);
        stage.show();
    }
}
