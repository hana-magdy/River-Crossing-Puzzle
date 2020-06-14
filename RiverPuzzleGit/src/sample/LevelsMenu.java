package sample;

import Events.S1Events;
import Events.S2Events;
import Strategy.StoryOne;
import Strategy.StoryTwo;
import XML_Factories.ReadXMLFile;
import XML_Factories.ReadXMLFileS2;
import XML_Factories.XMLWriterDOM;
import XML_Factories.XMLWriterDOMS2;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class LevelsMenu {

    Stage stage;
    Scene levelsMenuScene;
    LevelOne levelOneScene;
    LevelTwo levelTwoScene;
    Button L1Start;
    Button L2Start;
    Button L1Continue;
    Button L2Continue;


    public LevelsMenu(Stage stage) {
        this.stage = stage;
    }

    public void prepareScene() {

        Group root = new Group();

        Label mainMenu = new Label("Main Menu");
        mainMenu.setFont(Font.font("Calibri", 20));
        mainMenu.setLayoutX(100);
        mainMenu.setLayoutY(0);

        Image level1 = new Image("file:levelOne.jpg");
        ImageView image1 = new ImageView(level1);
        Button levelOne = new Button();
        levelOne.setStyle("-fx-background-color: transparent;");
        levelOne.setGraphic(image1);

        image1.setFitWidth(100);
        image1.setFitHeight(150);
        levelOne.setLayoutX(50);
        levelOne.setLayoutY(30);

        Image level2 = new Image("file:levelTwo.jpg");
        ImageView image2 = new ImageView(level2);
        Button levelTwo = new Button();
        levelTwo.setStyle("-fx-background-color: transparent;");
        levelTwo.setGraphic(image2);
        image2.setFitWidth(100);
        image2.setFitHeight(150);
        levelTwo.setLayoutX(260);
        levelTwo.setLayoutY(30);

        L1Start = new Button();
        L1Continue = new Button();
        L2Start = new Button();
        L2Continue = new Button();

        Image newGame = new Image("file:newGame.png");
        ImageView newView = new ImageView(newGame);
        L1Start.setStyle("-fx-background-color: transparent;");
        L1Start.setGraphic(newView);
        Image contGame = new Image("file:continue.png");
        ImageView contView = new ImageView(contGame);
        L1Continue.setStyle("-fx-background-color: transparent;");
        L1Continue.setGraphic(contView);

        newView.setFitWidth(100);
        newView.setFitHeight(60);
        L1Start.setLayoutX(40);
        L1Start.setLayoutY(180);
        contView.setFitWidth(100);
        contView.setFitHeight(60);
        L1Continue.setLayoutX(100);
        L1Continue.setLayoutY(180);

        Image newGame2 = new Image("file:newGame.png");
        ImageView newView2 = new ImageView(newGame2);
        L2Start.setStyle("-fx-background-color: transparent;");
        L2Start.setGraphic(newView2);
        Image contGame2 = new Image("file:continue.png");
        ImageView contView2 = new ImageView(contGame2);
        L2Continue.setStyle("-fx-background-color: transparent;");
        L2Continue.setGraphic(contView2);
        newView2.setFitWidth(100);
        newView2.setFitHeight(60);
        L2Start.setLayoutX(260);
        L2Start.setLayoutY(180);
        contView2.setFitWidth(100);
        contView2.setFitHeight(60);
        L2Continue.setLayoutX(340);
        L2Continue.setLayoutY(180);


        root.getChildren().add(mainMenu);
        root.getChildren().add(levelOne);
        root.getChildren().add(levelTwo);
        root.getChildren().add(L1Start);
       // root.getChildren().add(L1Continue);
        root.getChildren().add(L2Start);
       // root.getChildren().add(L2Continue);


        levelsMenuScene = new Scene(root, 400, 300);

        L1Start.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                XMLWriterDOM write=new XMLWriterDOM();
                ReadXMLFile read=new ReadXMLFile();
                LevelOne x=new LevelOne(new Stage());
                x.PrepareScene();
                S1Events y=new S1Events(x);
                // y.Events();
                S1Controller z=new S1Controller();
                write.setS1Controller(z);
                y.setController(z);
                z.setS1Events(y);
                z.setX(read);
                z.setY(write);
                z.newGame(new StoryOne());
               // stage.setScene(levelOneScene.levelOneScene);

            }

        });

        L1Continue.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                stage.setScene(levelOneScene.levelOneScene);

            }

        });

        L2Start.setOnAction(new EventHandler<ActionEvent>() {

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

        L2Continue.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                stage.setScene(levelTwoScene.levelTwoScene);

            }

        });
    }


    public void setLevelOneScene(LevelOne levelOneScene) {

        this.levelOneScene = levelOneScene;
    }

    public void setLevelTwoScene(LevelTwo levelTwoScene) {
        this.levelTwoScene = levelTwoScene;
    }
}
