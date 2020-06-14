package Events;

import Crossers.Carn.Wolf;
import Crossers.Farmer.Farmer;
import Crossers.Herb.Sheep;
import Crossers.ICrosser;
import Crossers.Plant.Plant;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import sample.LevelOne;
import sample.S1Controller;

import java.util.Iterator;
import java.util.List;

public class S1Events {
    public S1Controller getController() {
        return controller;
    }

    public void setController(S1Controller controller) {
        this.controller = controller;
    }


    private S1Controller controller;
    private LevelOne levelOne;
    private boolean temp = true;
boolean readbool=true;
    public S1Events(LevelOne l) {
        this.levelOne = l;
        //Events();
    }

    public LevelOne getLevelOne() {
        return levelOne;
    }

    public void setLevelOne(LevelOne levelOne) {
        this.levelOne = levelOne;
    }


    public void prepare() {
        levelOne.PrepareScene();
    }

    public EventHandler<ActionEvent> farmerLeft_Boat() {
        EventHandler<ActionEvent> farmerLeft = new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (levelOne.getFarmerOnBoard() == false) {
                    levelOne.setPathLF().play();
                    levelOne.setFarmerOnBoard(true);
                    controller.onFarmer();
                } else {
                    controller.offFarmer();
                    levelOne.setFarmerOnBoard(false);

                    if (controller.isBoatOnTheLeftBank())
                        levelOne.setPathLFBack().play();
                    else {
                        levelOne.getFarmerLeftButton().setVisible(false);
                        levelOne.PrepareRightFarmer();
                    }
                    // levelOne.setBoatOnRight(true);

                    controller.setEvents();

                }


            }
        };
        return farmerLeft;
    }

    public EventHandler<ActionEvent> farmerRight_Boat() {
        EventHandler<ActionEvent> farmerRight = new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (levelOne.getFarmerOnBoard() == false) {
                    levelOne.setPathRF().play();
                    levelOne.setFarmerOnBoard(true);
                    controller.onFarmer();

                } else {
                    controller.offFarmer();
                    levelOne.setFarmerOnBoard(false);
                    if (controller.isBoatOnTheLeftBank() == false)
                        levelOne.setPathRFBack().play();
                    else {
                        levelOne.getFarmerRightButton().setVisible(false);
                        levelOne.PrepareLeftFarmer();
                        //levelOne.setBoatOnRight(false);
                    }
                    controller.setEvents();


                }
            }
        };
        return farmerRight;
    }


    // >>>>>>>>>>>>>>>>> Moving the boat <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
    //
    //
    //
    //
    public EventHandler<MouseEvent> move() {
        EventHandler<MouseEvent> move_;
        if (controller.isBoatOnTheLeftBank()) {
            move_ = new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) {

                    if (controller.canMove(controller.getBoatRiders(), true)) {
                        System.out.println("yala");
                        temp = controller.isBoatOnTheLeftBank();
                        System.out.println(temp);
                        levelOne.setPathBoatLeft().play();
                        controller.doMove(controller.getBoatRiders(), true);
                    } else
                        levelOne.errorLabel();
                }
            };

        } else {
            move_ = new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) {
                    System.out.println("size of  boat" + controller.getBoatRiders().size());
                    System.out.println("size of left" + controller.getCrossersOnLeftBank().size());
                    System.out.println("size of right" + controller.getCrossersOnRightBank().size());
                    if (controller.canMove(controller.getBoatRiders(), false)) {
                        temp = controller.isBoatOnTheLeftBank();

                        levelOne.setPathBoatRight().play();
                        controller.doMove(controller.getBoatRiders(), false);
                    } else
                        levelOne.errorLabel();
                }
            };

        }
        return move_;

    }


    //>>>>>>>>>>>>>>>>>>>>>>...End of Movement of Boat...<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<


//>>>>>>>>>>>>>>>>>>>>>>>>>>Start of Wolf Events<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<

    public EventHandler<ActionEvent> wolfLeft() {
        EventHandler<ActionEvent> leftWolf = new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (levelOne.getWolfOnBoard() == false) {
                    levelOne.setPathLW().play();
                    levelOne.setWolfOnBoard(true);
                    controller.onWolf();

                } else {
                    controller.offWolf();
                    levelOne.setWolfOnBoard(false);

                    if (controller.isBoatOnTheLeftBank())
                        levelOne.setPathLWBack().play();
                    else {
                        levelOne.getWolfLeftButton().setVisible(false);
                        levelOne.PrepareRightWolf();
                        levelOne.setBoatOnRight(true);
                    }
                    controller.setEvents();

                }
            }
        };
        return leftWolf;
    }


    public EventHandler<ActionEvent> wolfRight() {
        EventHandler<ActionEvent> rightWolf = new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

                if (levelOne.getWolfOnBoard() == false) {
                    levelOne.onAndOffRW().play();
                    levelOne.setWolfOnBoard(true);
                    controller.onWolf();
                } else {
                    levelOne.setWolfOnBoard(false);
                    controller.offWolf();
                    if (controller.isBoatOnTheLeftBank() == false)
                        levelOne.onAndOffRWBack().play();
                    else {
                        levelOne.getWolfRightButton().setVisible(false);
                        levelOne.PrepareLeftWolf();
                        levelOne.setBoatOnRight(false);
                    }
                    controller.setEvents();

                }
            }
        };

        return rightWolf;
    }

    public EventHandler<ActionEvent> sheepLeft() {
        EventHandler<ActionEvent> leftSheep = new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (levelOne.getSheepOnBoard() == false) {
                    levelOne.setPathLS().play();
                    levelOne.setSheepOnBoard(true);
                    controller.onSheep();

                } else {
                    levelOne.setSheepOnBoard(false);
                    controller.offSheep();
                    if (controller.isBoatOnTheLeftBank())
                        levelOne.setPathLSBack().play();
                    else {
                        levelOne.getSheepLeftButton().setVisible(false);
                        levelOne.PrepareRightSheep();
                        // levelOne.setBoatOnRight(true);
                    }
                    controller.setEvents();


                }

            }
        };
        return leftSheep;
    }


    public EventHandler<ActionEvent> sheepRight() {
        EventHandler<ActionEvent> rightSheep = new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                controller.setEvents();
                if (levelOne.getSheepOnBoard() == false) {
                    levelOne.setPathRS().play();
                    levelOne.setSheepOnBoard(true);
                    controller.onSheep();
                } else {
                    controller.offSheep();
                    levelOne.setSheepOnBoard(false);

                    if (controller.isBoatOnTheLeftBank() == false)
                        levelOne.setPathRSBack().play();
                    else {
                        levelOne.getSheepRightButton().setVisible(false);
                        levelOne.PrepareLeftSheep();
                        //levelOne.setBoatOnRight(false);
                    }
                    controller.setEvents();
                }
            }
        };
        return rightSheep;
    }


    public EventHandler<ActionEvent> plantLeft() {
        EventHandler<ActionEvent> leftPlant = new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (levelOne.getCabbageOnBoard() == false) {
                    levelOne.setPathLP().play();
                    levelOne.setCabbageOnBoard(true);
                    controller.onPlant();
                } else {
                    levelOne.setCabbageOnBoard(false);
                    controller.offPlant();
                    if (controller.isBoatOnTheLeftBank())
                        levelOne.setPathLPBack().play();
                    else {
                        levelOne.getCabbageLeftButton().setVisible(false);
                        levelOne.PrepareRightCabbage();
                        levelOne.setBoatOnRight(true);
                    }
                    controller.setEvents();
                }
            }
        };
        return leftPlant;
    }


    public EventHandler<ActionEvent> plantRight() {
        EventHandler<ActionEvent> rightPlant = new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (levelOne.getCabbageOnBoard() == false) {
                    levelOne.setPathRP().play();
                    levelOne.setCabbageOnBoard(true);
                    controller.onPlant();
                } else {
                    levelOne.setCabbageOnBoard(false);
                    controller.offPlant();
                    if (controller.isBoatOnTheLeftBank() == false)
                        levelOne.setPathRPBack().play();
                    else {
                        levelOne.setBoatOnRight(false);
                        levelOne.getCabbageRightButton().setVisible(false);
                        levelOne.PrepareLeftCabbage();

                    }
                    controller.setEvents();
                }
            }
        };
        return rightPlant;
    }


    public EventHandler<MouseEvent> UndoMovement() {

        EventHandler<MouseEvent> undoMovement = null;

        if (controller.getBoatRiders() != null) {
            undoMovement = new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) {
                    controller.undo();
                    List<ICrosser> Afterleft = controller.getCrossersOnLeftBank();
                    List<ICrosser> AfterRight = controller.getCrossersOnRightBank();
                    List<ICrosser> AfterBoat = controller.getBoatRiders();
                    List<ICrosser> Beforeleft = controller.getTwoPopLeft();
                    List<ICrosser> BeforeRight = controller.getTwoPopRight();

                    System.out.println(Beforeleft);
                    System.out.println(BeforeRight);
                    System.out.println(Afterleft);
                    System.out.println(AfterRight);

                    if (Beforeleft != null && AfterRight != null) {
                        int i = 0;
                        for (ICrosser x : Beforeleft) {
                            //System.out.println("d5al eloop");
                            if (AfterRight.contains(x) && x instanceof Farmer) {
                               // System.out.println(BeforeRight);
                                controller.getCrossersOnLeftBank().add(x);
                                controller.getCrossersOnRightBank().remove(x);
                                //System.out.println(controller.getCrossersOnLeftBank());
                              //  System.out.println("wsalt hna");
                                // if (x instanceof Farmer) {
                                levelOne.getFarmerRightButton().setVisible(false);
                                levelOne.PrepareLeftFarmer();
                                levelOne.setFarmerOnBoard(false);
                                i = 1;
                            }
                        }
                        if (i == 0) {
                            if (BeforeRight != null) {
                                for (ICrosser z : BeforeRight) {

                                    if (Afterleft.contains(z) && z instanceof Farmer ) {
                                        System.out.println("hi");
                                        controller.getCrossersOnRightBank().add(z);
                                        controller.getCrossersOnLeftBank().remove(z);
                                        // System.out.println(controller.getCrossersOnLeftBank());
                                        //System.out.println("wsalt hna");
                                        // if (x instanceof Farmer) {
                                        levelOne.getFarmerLeftButton().setVisible(false);
                                        levelOne.PrepareRightFarmer();
                                        levelOne.setFarmerOnBoard(false);
                                    }
                                }
                            }
                        }


                        i = 0;
                        for (ICrosser x : Beforeleft) {
                           // System.out.println("d5al eloop");
                            if (AfterRight.contains(x) && x instanceof Sheep) {
                                controller.getCrossersOnLeftBank().add(x);
                                controller.getCrossersOnRightBank().remove(x);
                               // System.out.println(controller.getCrossersOnLeftBank());
                                //System.out.println("wsalt hna");
                                // if (x instanceof Farmer) {
                                levelOne.getSheepRightButton().setVisible(false);
                                levelOne.PrepareLeftSheep();
                                levelOne.setSheepOnBoard(false);
                                i = 1;
                            }
                        }
                        if (i == 0) {
                            if (BeforeRight != null) {

                                for (ICrosser z : BeforeRight) {

                                    if (Afterleft.contains(z) && z instanceof Sheep ) {
                                        controller.getCrossersOnRightBank().add(z);
                                        controller.getCrossersOnLeftBank().remove(z);
                                        // System.out.println(controller.getCrossersOnLeftBank());
                                        //System.out.println("wsalt hna");
                                        // if (x instanceof Farmer) {
                                        levelOne.getSheepLeftButton().setVisible(false);
                                        levelOne.PrepareRightSheep();
                                        levelOne.setSheepOnBoard(false);
                                    }
                                }
                            }
                        }


//>>>>>>>>>>>>>>>>>>>>>>wolf<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<


                        i = 0;
                        for (ICrosser x : Beforeleft) {
                          //  System.out.println("d5al eloop");
                            if (AfterRight.contains(x) && x instanceof Wolf) {
                                System.out.println("8lat1");
                                controller.getCrossersOnLeftBank().add(x);
                                controller.getCrossersOnRightBank().remove(x);
                             //   System.out.println(controller.getCrossersOnLeftBank());
                               // System.out.println("wsalt hna");
                                // if (x instanceof Farmer) {
                                levelOne.getWolfRightButton().setVisible(false);
                                levelOne.PrepareLeftWolf();
                                levelOne.setWolfOnBoard(false);
                                i = 1;
                            }
                            if (i == 1)
                                break;
                        }
                        if (i == 0) {
                            if (BeforeRight != null) {
                                    System.out.print(BeforeRight);
                                for (ICrosser z : BeforeRight) {

                                    if (Afterleft.contains(z) && z instanceof Wolf ) {
                                        System.out.println("8lat2");

                                        //  System.out.print(BeforeRight);
                                        controller.getCrossersOnRightBank().add(z);
                                        controller.getCrossersOnLeftBank().remove(z);
                                        // System.out.println(controller.getCrossersOnLeftBank());
                                        //System.out.println("wsalt hna");
                                        // if (x instanceof Farmer) {
                                        levelOne.getWolfLeftButton().setVisible(false);
                                        levelOne.PrepareRightWolf();
                                        levelOne.setWolfOnBoard(false);
                                        i = 1;
                                    }
                                    if (i == 1)
                                        break;
                                }
                            }
                        }


                        //>>>>>>>>>>>>>>>>>>>>>>>>Cabbage<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<


                        i = 0;
                        for (ICrosser x : Beforeleft) {
                            System.out.println("d5al eloop");
                            if (AfterRight.contains(x) && x instanceof Plant) {
                                controller.getCrossersOnLeftBank().add(x);
                                controller.getCrossersOnRightBank().remove(x);
                                System.out.println(controller.getCrossersOnLeftBank());
                                System.out.println("wsalt hna");
                                // if (x instanceof Farmer) {
                                levelOne.getCabbageRightButton().setVisible(false);
                                levelOne.PrepareLeftCabbage();
                                levelOne.setCabbageOnBoard(false);
                                i = 1;
                            }

                        }
                        if (i == 0) {
                            for (ICrosser z : BeforeRight) {

                                if (Afterleft.contains(z) && z instanceof Plant ) {
                                    controller.getCrossersOnRightBank().add(z);
                                    controller.getCrossersOnLeftBank().remove(z);
                                    // System.out.println(controller.getCrossersOnLeftBank());
                                    //System.out.println("wsalt hna");
                                    // if (x instanceof Farmer) {
                                    levelOne.getCabbageLeftButton().setVisible(false);
                                    levelOne.PrepareRightCabbage();
                                    levelOne.setCabbageOnBoard(false);
                                    i = 1;
                                }

                            }
                        }


                        //>>>>>>>>>>>>>>Boat<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<

                        if (temp != controller.isBoatOnTheLeftBank()) {
                            if (temp) {
                                temp=controller.isBoatOnTheLeftBank();
                                levelOne.setBoatOnRight(false);
                                levelOne.setPathBoatRight().play();
                                System.out.println("rg3ha elleft");
                            } else {
                                temp=controller.isBoatOnTheLeftBank();
                                levelOne.setBoatOnRight(true);
                                levelOne.setPathBoatLeft().play();
                            }
                        }

                    }


                    controller.setEvents();
                }

            };
        }

        return undoMovement;
    }


    public EventHandler<MouseEvent> RedoMovement() {

        EventHandler<MouseEvent> redoMovement = null;

        if ( controller.getBoatRiders()!=null) {
            redoMovement = new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) {
                    controller.redo();
                    List<ICrosser> originalleft = controller.getCrossersOnLeftBank();
                    List<ICrosser> originalRight = controller.getCrossersOnRightBank();
                    List<ICrosser> redoleft = controller.getRedoLeft();
                    List<ICrosser> redoRight = controller.getRedoRight();
                    // System.out.println(Beforeleft);
                    // System.out.println(AfterRight);
                    //System.out.println("d5al eloop");

                    if (originalleft != null && redoRight!=null) {
                        int i = 0;
                      //  System.out.println("d5al eloop");

                        for (ICrosser x : redoRight) {
                            //System.out.println("d5al eloop");
                            if (originalleft.contains(x) && x instanceof Farmer) {
                                controller.getCrossersOnLeftBank().remove(x);
                                controller.getCrossersOnRightBank().add(x);
                                System.out.println(controller.getCrossersOnLeftBank());
                               // System.out.println("wsalt hna");
                                // if (x instanceof Farmer) {
                                levelOne.getFarmerLeftButton().setVisible(false);
                                levelOne.PrepareRightFarmer();
                                levelOne.setFarmerOnBoard(false);
                                i = 1;
                            }
                        }
                        if(i==0) {
                            if(originalRight!=null) {
                                for (ICrosser z : redoleft) {

                                    if (originalRight.contains(z) && z instanceof Farmer ) {
                                        controller.getCrossersOnRightBank().remove(z);
                                        controller.getCrossersOnLeftBank().add(z);
                                        // System.out.println(controller.getCrossersOnLeftBank());
                                        //System.out.println("wsalt hna");
                                        // if (x instanceof Farmer) {
                                        levelOne.getFarmerRightButton().setVisible(false);
                                        levelOne.PrepareLeftFarmer();
                                        levelOne.setFarmerOnBoard(false);
                                    }
                                }
                            }
                        }




                        i = 0;
    for (ICrosser x : redoRight) {
        System.out.println("redo sheep");
        if (originalleft.contains(x) && x instanceof Sheep) {
            controller.getCrossersOnLeftBank().remove(x);
            controller.getCrossersOnRightBank().add(x);
            System.out.println(controller.getCrossersOnLeftBank());
            //System.out.println("wsalt hna");
            // if (x instanceof Farmer) {
            levelOne.getSheepLeftButton().setVisible(false);
            levelOne.PrepareRightSheep();
            levelOne.setSheepOnBoard(false);
            i = 1;
        }
    }

                            if (i == 0) {
                                if (originalRight != null) {
                                    for (ICrosser z : redoleft) {

                                        if (originalRight.contains(z) && z instanceof Sheep) {
                                            controller.getCrossersOnRightBank().remove(z);
                                            controller.getCrossersOnLeftBank().add(z);
                                            // System.out.println(controller.getCrossersOnLeftBank());
                                            //System.out.println("wsalt hna");
                                            // if (x instanceof Farmer) {
                                            levelOne.getSheepRightButton().setVisible(false);
                                            levelOne.PrepareLeftSheep();
                                            levelOne.setSheepOnBoard(false);
                                        }
                                    }
                                }
                            }


//                    >>>>>>>>>>>>>>>>>>>>>>wolf<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<


                        for (ICrosser x : originalleft) {
                            System.out.println("d5al eloop");
                            if (redoRight.contains(x) && x instanceof Wolf) {
                                controller.getCrossersOnLeftBank().remove(x);
                                controller.getCrossersOnRightBank().add(x);
                                System.out.println(controller.getCrossersOnLeftBank());
                                System.out.println("wsalt hna");
                                // if (x instanceof Farmer) {
                                levelOne.getWolfLeftButton().setVisible(false);
                                levelOne.PrepareRightWolf();
                                levelOne.setWolfOnBoard(false);
                                i = 1;
                            }
                        }
                        if(i==0) {
                            if(originalRight!=null) {
                                for (ICrosser z : originalRight) {

                                    if (redoleft.contains(z) && z instanceof Wolf ) {
                                        controller.getCrossersOnRightBank().remove(z);
                                        controller.getCrossersOnLeftBank().add(z);
                                        // System.out.println(controller.getCrossersOnLeftBank());
                                        //System.out.println("wsalt hna");
                                        // if (x instanceof Farmer) {
                                        levelOne.getWolfRightButton().setVisible(false);
                                        levelOne.PrepareLeftWolf();
                                        levelOne.setWolfOnBoard(false);
                                    }
                                }
                            }
                        }


                        //>>>>>>>>>>>>>>>>>>>>>>>>Cabbage<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<



                        for (ICrosser x : originalleft) {
                            System.out.println("d5al eloop");
                            if (redoRight.contains(x) && x instanceof Plant) {
                                controller.getCrossersOnLeftBank().remove(x);
                                controller.getCrossersOnRightBank().add(x);
                                System.out.println(controller.getCrossersOnLeftBank());
                                System.out.println("wsalt hna");
                                // if (x instanceof Farmer) {
                                levelOne.getCabbageLeftButton().setVisible(false);
                                levelOne.PrepareRightCabbage();
                                levelOne.setCabbageOnBoard(false);
                                i = 1;
                            }
                        }
                        if(i==0) {
                            if(originalRight!=null) {
                                for (ICrosser z : originalRight) {

                                    if (redoleft.contains(z) && z instanceof Plant ) {
                                        controller.getCrossersOnRightBank().remove(z);
                                        controller.getCrossersOnLeftBank().add(z);
                                        // System.out.println(controller.getCrossersOnLeftBank());
                                        //System.out.println("wsalt hna");
                                        // if (x instanceof Farmer) {
                                        levelOne.getCabbageRightButton().setVisible(false);
                                        levelOne.PrepareLeftCabbage();
                                        levelOne.setCabbageOnBoard(false);
                                    }
                                }
                            }
                        }


                        //>>>>>>>>>>>>>>Boat<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<

                        if(temp!=controller.isBoatOnTheLeftBank()) {
                            if (temp) {
                                levelOne.setBoatOnRight(false);
                                levelOne.setPathBoatRight().play();
                                System.out.println("rg3ha elleft");
                            } else {
                                levelOne.setBoatOnRight(true);
                                levelOne.setPathBoatLeft().play();
                            }


                        }

                    }


                    controller.setEvents();
                }

            };


        }


        return redoMovement;
    }




    public EventHandler<ActionEvent> save(){
        EventHandler<ActionEvent> save = new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println("save");
                controller.saveGame();
            }
        };
        return save;
    }
    public  EventHandler<ActionEvent> load(){
        EventHandler<ActionEvent> load = new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                // levelOne.getFarmerGirlLeftButton().setVisible(false);
                controller.loadGame();
                System.out.println(controller.vergu.get(0).size());

                //LoadedLeft= controller.getCrossersOnLeftBank();
                //LoadedRight= controller.getCrossersOnRightBank();
                //LoadedBoat= controller.getBoatRiders();
                for(int i=0;i<controller.vergu.get(0).size();i++) {
                    if(controller.vergu.get(0).get(i).getEatingRank()==4){
                        levelOne.getFarmerRightButton().setVisible(false);
                        levelOne.PrepareLeftFarmer();}
                    else if(controller.vergu.get(0).get(i).getEatingRank()==1){
                        levelOne.getSheepRightButton().setVisible(false);
                        levelOne.PrepareLeftSheep();}
                    else if(controller.vergu.get(0).get(i).getEatingRank()==2){
                        levelOne.getWolfRightButton().setVisible(false);
                        levelOne.PrepareLeftWolf();
                    }
                    else if(controller.vergu.get(0).get(i).getEatingRank()==0){
                        levelOne.getCabbageRightButton().setVisible(false);
                        levelOne.PrepareLeftCabbage();}

                }
                for(int i=0;i<controller.vergu.get(2).size();i++) {
                    if(controller.vergu.get(2).get(i).getEatingRank()==4){
                        levelOne.getFarmerLeftButton().setVisible(false);
                        levelOne.PrepareRightFarmer();}
                    else if(controller.vergu.get(2).get(i).getEatingRank()==1){
                        levelOne.getSheepLeftButton().setVisible(false);
                        levelOne.PrepareRightSheep();}
                    else if(controller.vergu.get(2).get(i).getEatingRank()==2){
                        levelOne.getWolfLeftButton().setVisible(false);
                        levelOne.PrepareRightWolf();
                    }

                }
System.out.println(controller.getNumberOfSails());
                if(controller.getNumberOfSails()%2==0)
                    readbool=true;
                            else
                                readbool=false;

                if(readbool!=controller.isBoatOnTheLeftBank()) {
                    if (readbool==false) {
                        System.out.println("hi");
                        levelOne.setPathBoatLeft().play();
                        levelOne.setBoatOnRight(true);
                    }else{
                        levelOne.setPathBoatRight().play();
                        levelOne.setBoatOnRight(false);
                    }
                }
                controller.setEvents();
            }

        };
        return load;
    }


}








