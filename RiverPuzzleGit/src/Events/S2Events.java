package Events;

import Crossers.ICrosser;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import sample.LevelTwo;
import sample.S2Controller;

import java.util.List;


public class S2Events {
    boolean temp=true;
    boolean readbool=true;
    public S2Controller getController() {
        return controller;
    }

    public void setController(S2Controller controller) {
        this.controller = controller;
    }


    private S2Controller controller;
    private LevelTwo levelTwo;

    public S2Events(LevelTwo l) {
        this.levelTwo = l;
        //Events();
    }

    public LevelTwo getLevelTwo() {
        return levelTwo;
    }

    public void setLevelTwo(LevelTwo levelTwo) {
        this.levelTwo = levelTwo;
    }


    public void prepare() {
        levelTwo.prepareScene();
    }


//>>>>>>>>>>>>>>>>>>>>>>>Movement of Boat<<<<<<<<<<<<<<<<<<<<


    public EventHandler<ActionEvent> move() {
        EventHandler<ActionEvent> move_;
        if (controller.isBoatOnTheLeftBank()) {
            move_ = new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    if (controller.canMove(controller.getBoatRiders(), true)) {
                        temp=controller.isBoatOnTheLeftBank();
                        System.out.println("yala");
                        levelTwo.setPathBoatLeft().play();
                        controller.doMove(controller.getBoatRiders(), true);
                    } else
                        levelTwo.errorLabel();
                }
            };

        } else {
            move_ = new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    System.out.println("size of  boat" + controller.getBoatRiders().size());
                    System.out.println("size of left" + controller.getCrossersOnLeftBank().size());
                    System.out.println("size of right" + controller.getCrossersOnRightBank().size());
                    if (controller.canMove(controller.getBoatRiders(), false)) {
                        temp=controller.isBoatOnTheLeftBank();
                        levelTwo.setPathBoatRight().play();
                        controller.doMove(controller.getBoatRiders(), false);
                    } else
                        levelTwo.errorLabel();
                }
            };

        }
        return move_;

    }


    public EventHandler<ActionEvent> manLeft() {
        EventHandler<ActionEvent> leftMan = new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (levelTwo.getManOnBoard() == false) {
                    levelTwo.setManOnBoard(true);
                    levelTwo.setPathML();
                    controller.manOn();

                } else {
                    controller.manOff();
                    levelTwo.setManOnBoard(false);
                    if (controller.isBoatOnTheLeftBank())
                        levelTwo.setPathMLBack();
                    else {
                        levelTwo.getFarmerManLeftButton().setVisible(false);
                        //farmerManRightButton.setVisible(true);
                        levelTwo.prepareRightFarmerMan();
                        //levelTwo.setBoatOnRight(true);
                    }
                    controller.setEvents();
                }
            }
        };


        return leftMan;

    }


    public EventHandler<ActionEvent> manRight() {
        EventHandler<ActionEvent> rightMan = new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (levelTwo.getManOnBoard() == false) {
                    levelTwo.setManOnBoard(true);
                    levelTwo.setPathMR();
                    controller.manOn();

                } else {
                    controller.manOff();
                    levelTwo.setManOnBoard(false);
                    if (controller.isBoatOnTheLeftBank() == false)
                        levelTwo.setPathMRBack();
                    else {
                        levelTwo.getFarmerManRightButton().setVisible(false);
                        //farmerManRightButton.setVisible(true);
                        levelTwo.prepareLeftFarmerMan();
                        //levelTwo.setBoatOnRight(true);
                    }
                    controller.setEvents();
                }
            }
        };


        return rightMan;

    }


    public EventHandler<ActionEvent> womanLeft() {
        EventHandler<ActionEvent> leftWoman = new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (levelTwo.getWomanOnBoard() == false) {
                    levelTwo.setWomanOnBoard(true);
                    levelTwo.setPathWL();
                    controller.womanOn();

                } else {
                    controller.womanOff();
                    levelTwo.setWomanOnBoard(false);
                    if (controller.isBoatOnTheLeftBank())
                        levelTwo.setPathWLBack();
                    else {
                        levelTwo.getFarmerWomanLeftButton().setVisible(false);
                        //farmerManRightButton.setVisible(true);
                        levelTwo.prepareRightFarmerWoman();
                        //levelTwo.setBoatOnRight(true);
                    }
                    controller.setEvents();
                }
            }
        };


        return leftWoman;

    }


    public EventHandler<ActionEvent> womanRight() {
        EventHandler<ActionEvent> rightWoman = new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (levelTwo.getWomanOnBoard() == false) {
                    levelTwo.setWomanOnBoard(true);
                    levelTwo.setPathWR();
                    controller.womanOn();

                } else {
                    controller.womanOff();
                    levelTwo.setWomanOnBoard(false);
                    if (controller.isBoatOnTheLeftBank() == false)
                        levelTwo.setPathWRBack();
                    else {
                        levelTwo.getFarmerWomanRightButton().setVisible(false);
                        //farmerManRightButton.setVisible(true);
                        levelTwo.prepareLeftFarmerWoman();
                        //levelTwo.setBoatOnRight(true);
                    }
                    controller.setEvents();
                }
            }
        };


        return rightWoman;

    }


    public EventHandler<ActionEvent> girlLeft() {
        EventHandler<ActionEvent> leftGirl = new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (levelTwo.getGirlOnBoard() == false) {
                    levelTwo.setGirlOnBoard(true);
                    levelTwo.setPathGL();
                    controller.girlOn();

                } else {
                    controller.girlOff();
                    levelTwo.setGirlOnBoard(false);
                    if (controller.isBoatOnTheLeftBank())
                        levelTwo.setPathGLBack();
                    else {
                        levelTwo.getFarmerGirlLeftButton().setVisible(false);
                        //farmerManRightButton.setVisible(true);
                        levelTwo.prepareRightFarmerGirl();
                        //levelTwo.setBoatOnRight(true);
                    }
                    controller.setEvents();
                }
            }
        };


        return leftGirl;

    }


    public EventHandler<ActionEvent> girlRight() {
        EventHandler<ActionEvent> rightGirl = new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (levelTwo.getGirlOnBoard() == false) {
                    levelTwo.setGirlOnBoard(true);
                    levelTwo.setPathGR();
                    controller.girlOn();

                } else {
                    controller.girlOff();
                    levelTwo.setGirlOnBoard(false);
                    if (controller.isBoatOnTheLeftBank() == false)
                        levelTwo.setPathGRBack();
                    else {
                        levelTwo.getFarmerGirlRightButton().setVisible(false);
                        //farmerManRightButton.setVisible(true);
                        levelTwo.prepareLeftFarmerGirl();
                        //levelTwo.setBoatOnRight(true);
                    }
                    controller.setEvents();
                }
            }
        };


        return rightGirl;

    }

    public EventHandler<ActionEvent> boyLeft() {
        EventHandler<ActionEvent> leftBoy = new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (levelTwo.getBoyOnBoard() == false) {
                    levelTwo.setBoyOnBoard(true);
                    levelTwo.setPathBL();
                    controller.boyOn();

                } else {
                    controller.boyOff();
                    levelTwo.setBoyOnBoard(false);
                    if (controller.isBoatOnTheLeftBank())
                        levelTwo.setPathBLBack();
                    else {
                        levelTwo.getFarmerBoyLeftButton().setVisible(false);
                        //farmerManRightButton.setVisible(true);
                        levelTwo.prepareRightFarmerBoy();
                        //levelTwo.setBoatOnRight(true);
                    }
                    controller.setEvents();
                }
            }
        };


        return leftBoy;

    }


    public EventHandler<ActionEvent> boyRight() {
        EventHandler<ActionEvent> rightBoy = new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (levelTwo.getBoyOnBoard() == false) {
                    levelTwo.setBoyOnBoard(true);
                    levelTwo.setPathRB();
                    controller.boyOn();

                } else {
                    controller.boyOff();
                    levelTwo.setBoyOnBoard(false);
                    if (controller.isBoatOnTheLeftBank() == false)
                        levelTwo.setPathRBBack();
                    else {
                        levelTwo.getFarmerBoyRightButton().setVisible(false);
                        //farmerManRightButton.setVisible(true);
                        levelTwo.prepareLeftFarmerBoy();
                        //levelTwo.setBoatOnRight(true);
                    }
                    controller.setEvents();
                }
            }
        };


        return rightBoy;

    }

    public EventHandler<ActionEvent> goatLeft() {
        EventHandler<ActionEvent> leftGoat = new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (levelTwo.getGoatOnBoard() == false) {
                    levelTwo.setGoatOnBoard(true);
                    levelTwo.setPathLGoat();
                    controller.goatOn();

                } else {
                    controller.goatOff();
                    levelTwo.setGoatOnBoard(false);
                    if (controller.isBoatOnTheLeftBank())
                        levelTwo.setPathLGoatBack();
                    else {
                        levelTwo.getGoatLeftButton().setVisible(false);
                        //farmerManRightButton.setVisible(true);
                        levelTwo.prepareRightGoat();
                        //levelTwo.setBoatOnRight(true);
                    }
                    controller.setEvents();
                }
            }
        };


        return leftGoat;

    }


    public EventHandler<ActionEvent> goatRight() {
        EventHandler<ActionEvent> rightGoat = new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (levelTwo.getGoatOnBoard() == false) {
                    levelTwo.setGoatOnBoard(true);
                    levelTwo.setPathRGoat();
                    controller.goatOn();

                } else {
                    controller.goatOff();
                    levelTwo.setGoatOnBoard(false);
                    if (controller.isBoatOnTheLeftBank() == false)
                        levelTwo.setPathRGoatBack();
                    else {
                        levelTwo.getGoatRightButton().setVisible(false);
                        //farmerManRightButton.setVisible(true);
                        levelTwo.prepareLeftGoat();
                        //levelTwo.setBoatOnRight(true);
                    }
                    controller.setEvents();
                }
            }
        };


        return rightGoat;

    }






    public EventHandler<MouseEvent> UndoMovement() {
        EventHandler<MouseEvent> undoMovement = null;
System.out.println(controller.getBoatRiders());
;        if (controller.getBoatRiders() != null) {
            undoMovement = new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) {
                    System.out.println("hi");

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
                            if (AfterRight.contains(x) && x.getWeight()==90) {
                                // System.out.println(BeforeRight);
                                controller.getCrossersOnLeftBank().add(x);
                                controller.getCrossersOnRightBank().remove(x);
                                //System.out.println(controller.getCrossersOnLeftBank());
                                //  System.out.println("wsalt hna");
                                // if (x instanceof Farmer) {
                                levelTwo.getFarmerManRightButton().setVisible(false);
                                levelTwo.prepareLeftFarmerMan();
                                levelTwo.setManOnBoard(false);
                                i = 1;
                            }
                        }
                        if (i == 0) {
                            if (BeforeRight != null) {
                                for (ICrosser z : BeforeRight) {

                                    if (Afterleft.contains(z) && z.getWeight()==90 ) {
                                        System.out.println("hi");
                                        controller.getCrossersOnRightBank().add(z);
                                        controller.getCrossersOnLeftBank().remove(z);
                                        // System.out.println(controller.getCrossersOnLeftBank());
                                        //System.out.println("wsalt hna");
                                        // if (x instanceof Farmer) {
                                        levelTwo.getFarmerManLeftButton().setVisible(false);
                                        levelTwo.prepareRightFarmerMan();
                                        levelTwo.setManOnBoard(false);
                                    }
                                }
                            }
                        }


                        i = 0;
                        for (ICrosser x : Beforeleft) {
                            // System.out.println("d5al eloop");
                            if (AfterRight.contains(x) && x.getWeight()==80) {
                                controller.getCrossersOnLeftBank().add(x);
                                controller.getCrossersOnRightBank().remove(x);
                                // System.out.println(controller.getCrossersOnLeftBank());
                                //System.out.println("wsalt hna");
                                // if (x instanceof Farmer) {
                                levelTwo.getFarmerWomanRightButton().setVisible(false);
                                levelTwo.prepareLeftFarmerWoman();
                                levelTwo.setWomanOnBoard(false);
                                i = 1;
                            }
                        }
                        if (i == 0) {
                            if (BeforeRight != null) {

                                for (ICrosser z : BeforeRight) {

                                    if (Afterleft.contains(z) && z.getWeight()==80 ) {
                                        controller.getCrossersOnRightBank().add(z);
                                        controller.getCrossersOnLeftBank().remove(z);
                                        // System.out.println(controller.getCrossersOnLeftBank());
                                        //System.out.println("wsalt hna");
                                        // if (x instanceof Farmer) {
                                        levelTwo.getFarmerWomanLeftButton().setVisible(false);
                                        levelTwo.prepareRightFarmerWoman();
                                        levelTwo.setWomanOnBoard(false);
                                    }
                                }
                            }
                        }


//>>>>>>>>>>>>>>>>>>>>>>wolf<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<


                        i = 0;
                        for (ICrosser x : Beforeleft) {
                            //  System.out.println("d5al eloop");
                            if (AfterRight.contains(x) && x.getWeight()==60) {
                                System.out.println("8lat1");
                                controller.getCrossersOnLeftBank().add(x);
                                controller.getCrossersOnRightBank().remove(x);
                                //   System.out.println(controller.getCrossersOnLeftBank());
                                // System.out.println("wsalt hna");
                                // if (x instanceof Farmer) {
                                levelTwo.getFarmerGirlRightButton().setVisible(false);
                                levelTwo.prepareLeftFarmerGirl();
                                levelTwo.setGirlOnBoard(false);
                                i = 1;
                            }
                            if (i == 1)
                                break;
                        }
                        if (i == 0) {
                            if (BeforeRight != null) {
                                System.out.print(BeforeRight);
                                for (ICrosser z : BeforeRight) {

                                    if (Afterleft.contains(z) && z.getWeight()==60 ) {
                                        System.out.println("8lat2");

                                        //  System.out.print(BeforeRight);
                                        controller.getCrossersOnRightBank().add(z);
                                        controller.getCrossersOnLeftBank().remove(z);
                                        // System.out.println(controller.getCrossersOnLeftBank());
                                        //System.out.println("wsalt hna");
                                        // if (x instanceof Farmer) {
                                        levelTwo.getFarmerGirlLeftButton().setVisible(false);
                                        levelTwo.prepareRightFarmerGirl();
                                        levelTwo.setGirlOnBoard(false);
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
                            if (AfterRight.contains(x) && x.getWeight()==40) {
                                controller.getCrossersOnLeftBank().add(x);
                                controller.getCrossersOnRightBank().remove(x);
                                System.out.println(controller.getCrossersOnLeftBank());
                                System.out.println("wsalt hna");
                                // if (x instanceof Farmer) {
                                levelTwo.getFarmerBoyRightButton().setVisible(false);
                                levelTwo.prepareLeftFarmerBoy();
                                levelTwo.setBoyOnBoard(false);
                                i = 1;
                            }

                        }
                        if (i == 0) {
                            for (ICrosser z : BeforeRight) {

                                if (Afterleft.contains(z) && z.getWeight()==40 ) {
                                    controller.getCrossersOnRightBank().add(z);
                                    controller.getCrossersOnLeftBank().remove(z);
                                    // System.out.println(controller.getCrossersOnLeftBank());
                                    //System.out.println("wsalt hna");
                                    // if (x instanceof Farmer) {
                                    levelTwo.getFarmerBoyLeftButton().setVisible(false);
                                    levelTwo.prepareRightFarmerBoy();
                                    levelTwo.setBoyOnBoard(false);
                                    i = 1;
                                }

                            }
                        }





                        i = 0;
                        for (ICrosser x : Beforeleft) {
                            //  System.out.println("d5al eloop");
                            if (AfterRight.contains(x) && x.getWeight()==20) {
                                System.out.println("8lat1");
                                controller.getCrossersOnLeftBank().add(x);
                                controller.getCrossersOnRightBank().remove(x);
                                //   System.out.println(controller.getCrossersOnLeftBank());
                                // System.out.println("wsalt hna");
                                // if (x instanceof Farmer) {
                                levelTwo.getGoatRightButton().setVisible(false);
                                levelTwo.prepareLeftGoat();
                                levelTwo.setGoatOnBoard(false);
                                i = 1;
                            }
                            if (i == 1)
                                break;
                        }
                        if (i == 0) {
                            if (BeforeRight != null) {
                                System.out.print(BeforeRight);
                                for (ICrosser z : BeforeRight) {

                                    if (Afterleft.contains(z) && z.getWeight()==20 ) {
                                        System.out.println("8lat2");

                                        //  System.out.print(BeforeRight);
                                        controller.getCrossersOnRightBank().add(z);
                                        controller.getCrossersOnLeftBank().remove(z);
                                        // System.out.println(controller.getCrossersOnLeftBank());
                                        //System.out.println("wsalt hna");
                                        // if (x instanceof Farmer) {
                                        levelTwo.getGoatLeftButton().setVisible(false);
                                        levelTwo.prepareRightGoat();
                                        levelTwo.setGoatOnBoard(false);
                                        i = 1;
                                    }
                                    if (i == 1)
                                        break;
                                }
                            }
                        }















                        //>>>>>>>>>>>>>>Boat<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<

                        if (temp != controller.isBoatOnTheLeftBank()) {
                            if (temp) {
                                temp=controller.isBoatOnTheLeftBank();
                                levelTwo.setBoatOnRight(false);
                                levelTwo.setPathBoatRight().play();
                                System.out.println("rg3ha elleft");
                            } else {
                                temp=controller.isBoatOnTheLeftBank();
                                levelTwo.setBoatOnRight(true);
                                levelTwo.setPathBoatLeft().play();
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
                            if (originalleft.contains(x) && x.getWeight()==90) {
                                controller.getCrossersOnLeftBank().remove(x);
                                controller.getCrossersOnRightBank().add(x);
                                System.out.println(controller.getCrossersOnLeftBank());
                                // System.out.println("wsalt hna");
                                // if (x instanceof Farmer) {
                                levelTwo.getFarmerManLeftButton().setVisible(false);
                                levelTwo.prepareRightFarmerMan();
                                levelTwo.setManOnBoard(false);
                                i = 1;
                            }
                        }
                        if(i==0) {
                            if(originalRight!=null) {
                                for (ICrosser z : redoleft) {

                                    if (originalRight.contains(z) && z.getWeight()==90 ) {
                                        controller.getCrossersOnRightBank().remove(z);
                                        controller.getCrossersOnLeftBank().add(z);
                                        // System.out.println(controller.getCrossersOnLeftBank());
                                        //System.out.println("wsalt hna");
                                        // if (x instanceof Farmer) {
                                        levelTwo.getFarmerManRightButton().setVisible(false);
                                        levelTwo.prepareLeftFarmerMan();
                                        levelTwo.setManOnBoard(false);
                                    }
                                }
                            }
                        }




                        i = 0;
                        for (ICrosser x : redoRight) {
                            if (originalleft.contains(x) && x.getWeight()==80) {
                                controller.getCrossersOnLeftBank().remove(x);
                                controller.getCrossersOnRightBank().add(x);
                                System.out.println(controller.getCrossersOnLeftBank());
                                //System.out.println("wsalt hna");
                                // if (x instanceof Farmer) {
                                levelTwo.getFarmerWomanLeftButton().setVisible(false);
                                levelTwo.prepareRightFarmerWoman();
                                levelTwo.setWomanOnBoard(false);
                                i = 1;
                            }
                        }

                        if (i == 0) {
                            if (originalRight != null) {
                                for (ICrosser z : redoleft) {

                                    if (originalRight.contains(z) && z.getWeight()==80) {
                                        controller.getCrossersOnRightBank().remove(z);
                                        controller.getCrossersOnLeftBank().add(z);
                                        // System.out.println(controller.getCrossersOnLeftBank());
                                        //System.out.println("wsalt hna");
                                        // if (x instanceof Farmer) {
                                        levelTwo.getFarmerWomanRightButton().setVisible(false);
                                        levelTwo.prepareRightFarmerWoman();
                                        levelTwo.setWomanOnBoard(false);
                                    }
                                }
                            }
                        }


//                    >>>>>>>>>>>>>>>>>>>>>>wolf<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<

i=0;
                        for (ICrosser x : originalleft) {
                            System.out.println("d5al eloop");
                            if (redoRight.contains(x) && x.getWeight()==60) {
                                controller.getCrossersOnLeftBank().remove(x);
                                controller.getCrossersOnRightBank().add(x);
                                System.out.println(controller.getCrossersOnLeftBank());
                                System.out.println("wsalt hna");
                                // if (x instanceof Farmer) {
                                levelTwo.getFarmerGirlLeftButton().setVisible(false);
                                levelTwo.prepareRightFarmerGirl();
                                levelTwo.setGirlOnBoard(false);
                                i = 1;
                            }
                        }
                        if(i==0) {
                            if(originalRight!=null) {
                                for (ICrosser z : originalRight) {

                                    if (redoleft.contains(z) && z.getWeight()==60 ) {
                                        controller.getCrossersOnRightBank().remove(z);
                                        controller.getCrossersOnLeftBank().add(z);
                                        // System.out.println(controller.getCrossersOnLeftBank());
                                        //System.out.println("wsalt hna");
                                        // if (x instanceof Farmer) {
                                        levelTwo.getFarmerGirlRightButton().setVisible(false);
                                        levelTwo.prepareLeftFarmerGirl();
                                        levelTwo.setGirlOnBoard(false);
                                    }
                                }
                            }
                        }


                        //>>>>>>>>>>>>>>>>>>>>>>>>Cabbage<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<


i=0;
                        for (ICrosser x : originalleft) {
                            System.out.println("d5al eloop");
                            if (redoRight.contains(x) && x.getWeight()==40) {
                                controller.getCrossersOnLeftBank().remove(x);
                                controller.getCrossersOnRightBank().add(x);
                                System.out.println(controller.getCrossersOnLeftBank());
                                System.out.println("wsalt hna");
                                // if (x instanceof Farmer) {
                                levelTwo.getFarmerBoyLeftButton().setVisible(false);
                                levelTwo.prepareRightFarmerBoy();
                                levelTwo.setBoyOnBoard(false);
                                i = 1;
                            }
                        }
                        if(i==0) {
                            if(originalRight!=null) {
                                for (ICrosser z : originalRight) {

                                    if (redoleft.contains(z) && z.getWeight()==40 ) {
                                        controller.getCrossersOnRightBank().remove(z);
                                        controller.getCrossersOnLeftBank().add(z);
                                        // System.out.println(controller.getCrossersOnLeftBank());
                                        //System.out.println("wsalt hna");
                                        // if (x instanceof Farmer) {
                                        levelTwo.getFarmerBoyRightButton().setVisible(false);
                                        levelTwo.prepareLeftFarmerBoy();
                                        levelTwo.setBoyOnBoard(false);
                                    }
                                }
                            }
                        }





                        i=0;
                        for (ICrosser x : originalleft) {
                            System.out.println("d5al eloop");
                            if (redoRight.contains(x) && x.getWeight()==20) {
                                controller.getCrossersOnLeftBank().remove(x);
                                controller.getCrossersOnRightBank().add(x);
                                System.out.println(controller.getCrossersOnLeftBank());
                                System.out.println("wsalt hna");
                                // if (x instanceof Farmer) {
                                levelTwo.getGoatLeftButton().setVisible(false);
                                levelTwo.prepareRightGoat();
                                levelTwo.setGoatOnBoard(false);
                                i = 1;
                            }
                        }
                        if(i==0) {
                            if(originalRight!=null) {
                                for (ICrosser z : originalRight) {

                                    if (redoleft.contains(z) && z.getWeight()==20) {
                                        controller.getCrossersOnRightBank().remove(z);
                                        controller.getCrossersOnLeftBank().add(z);
                                        // System.out.println(controller.getCrossersOnLeftBank());
                                        //System.out.println("wsalt hna");
                                        // if (x instanceof Farmer) {
                                        levelTwo.getGoatRightButton().setVisible(false);
                                        levelTwo.prepareLeftGoat();
                                        levelTwo.setGoatOnBoard(false);
                                    }
                                }
                            }
                        }






                        //>>>>>>>>>>>>>>Boat<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<

                        if(temp!=controller.isBoatOnTheLeftBank()) {
                            if (temp) {
                                levelTwo.setBoatOnRight(false);
                                levelTwo.setPathBoatRight().play();
                                System.out.println("rg3ha elleft");
                            } else {
                                levelTwo.setBoatOnRight(true);
                                levelTwo.setPathBoatLeft().play();
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
                controller.saveGame();
            }
        };
        return save;
    }
    public  EventHandler<ActionEvent> load(){
        EventHandler<ActionEvent> load = new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                levelTwo.getFarmerGirlLeftButton().setVisible(false);
                controller.loadGame();
                System.out.println(controller.vergu.get(0).size());



                //LoadedLeft= controller.getCrossersOnLeftBank();
                //LoadedRight= controller.getCrossersOnRightBank();
                //LoadedBoat= controller.getBoatRiders();
                for(int i=0;i<controller.vergu.get(0).size();i++) {
                    if(controller.vergu.get(0).get(i).getWeight()==90){
                        levelTwo.getFarmerManRightButton().setVisible(false);
                        levelTwo.prepareLeftFarmerMan();}
                    else if(controller.vergu.get(0).get(i).getWeight()==80){
                        levelTwo.getFarmerWomanRightButton().setVisible(false);
                        levelTwo.prepareLeftFarmerWoman();}
                    else if(controller.vergu.get(0).get(i).getWeight()==60){
                        levelTwo.getFarmerGirlRightButton().setVisible(false);
                        levelTwo.prepareLeftFarmerGirl();
                    }
                    else if(controller.vergu.get(0).get(i).getWeight()==40){
                        levelTwo.getFarmerBoyRightButton().setVisible(false);
                        levelTwo.prepareLeftFarmerBoy();}
                    else if(controller.vergu.get(0).get(i).getWeight()==20){
                        levelTwo.getGoatRightButton().setVisible(false);
                        levelTwo.prepareLeftGoat();}
                }
                for(int i=0;i<controller.vergu.get(2).size();i++){
                    if(controller.vergu.get(2).get(i).getWeight()==90){
                        levelTwo.getFarmerManLeftButton().setVisible(false);
                        levelTwo.prepareRightFarmerMan();

                    }
                    else if(controller.vergu.get(2).get(i).getWeight()==80){
                        levelTwo.getFarmerWomanLeftButton().setVisible(false);
                        levelTwo.prepareRightFarmerWoman();}
                    else if(controller.vergu.get(2).get(i).getWeight()==60){
                        levelTwo.getFarmerGirlLeftButton().setVisible(false);
                        levelTwo.prepareRightFarmerGirl();


                    }
                    else if(controller.vergu.get(2).get(i).getWeight()==40){
                        levelTwo.getFarmerBoyLeftButton().setVisible(false);
                        levelTwo.prepareRightFarmerBoy();}
                    else if(controller.vergu.get(2).get(i).getWeight()==20){
                        levelTwo.getGoatLeftButton().setVisible(false);
                        levelTwo.prepareRightGoat();}
                }
                if(readbool!=controller.isBoatOnTheLeftBank()) {
                    if (readbool==false) {
                        System.out.println("hi");
                        levelTwo.setPathBoatLeft().play();
                        levelTwo.setBoatOnRight(true);
                    }else{
                        levelTwo.setPathBoatRight().play();
                        levelTwo.setBoatOnRight(false);
                    }
                }
                controller.setEvents();
            }
        };
        return load;
    }



}



