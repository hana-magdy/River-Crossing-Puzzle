package sample;

import Command.ButtonMover;
import Command.Command;
import Command.Move;
import Command.GetOnBoard;
import Command.GetOffBoard;
import Crossers.Boat.Boat;
import Crossers.Farmer.Farmer;
import Crossers.ICrosser;
import Events.S1Events;
import Events.S2Events;
import Strategy.ICrossingStrategy;
import Strategy.StoryOne;
import Strategy.StoryTwo;
import XML_Factories.ReadXMLFile;
import XML_Factories.ReadXMLFileS2;
import XML_Factories.XMLWriterDOM;
import XML_Factories.XMLWriterDOMS2;
import jdk.internal.util.xml.impl.XMLWriter;
import sample.IRiverCrossingController;
import sample.LevelTwo;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class S2Controller implements IRiverCrossingController {
    public S2Controller() {

    }
XMLWriterDOMS2 x;

    public XMLWriterDOMS2 getX() {
        return x;
    }

    public void setX(XMLWriterDOMS2 x) {
        this.x = x;
    }

    public ReadXMLFileS2 getY() {
        return y;
    }

    public void setY(ReadXMLFileS2 y) {
        this.y = y;
    }

    ReadXMLFileS2 y;
    LevelTwo levelTwo = null;
    S2Events s2Events;
    private List<ICrosser> redoLeft;
    private List<ICrosser> redoRight;

    public List<ICrosser> getRedoLeft() {
        return redoLeft;
    }

    public void setRedoLeft(List<ICrosser> redoLeft) {
        this.redoLeft = redoLeft;
    }

    public List<ICrosser> getRedoRight() {
        return redoRight;
    }

    public void setRedoRight(List<ICrosser> redoRight) {
        this.redoRight = redoRight;
    }

    private ICrossingStrategy strategy;
    private List<ICrosser> leftBank;
    private List<ICrosser> rightBank = new ArrayList<>();
    private List<ICrosser> boatRiders = new ArrayList<>();
    int undoFlag=0;
    private List<ICrosser> twoPopLeft;

    public List<ICrosser> getTwoPopLeft() {
        return twoPopLeft;
    }

    public void setTwoPopLeft(List<ICrosser> twoPopLeft) {
        this.twoPopLeft = twoPopLeft;
    }

    public List<ICrosser> getTwoPopRight() {
        return twoPopRight;
    }

    public void setTwoPopRight(List<ICrosser> twoPopRight) {
        this.twoPopRight = twoPopRight;
    }

    private List<ICrosser> twoPopRight;


    private Boat boat = new Boat();

    public S2Events getS2Events() {
        return s2Events;
    }

    public void setS2Events(S2Events s2Events) {
        this.s2Events = s2Events;
    }

    List<List<ICrosser>> pattern = new ArrayList<>();
    public List<List<ICrosser>> vergu = new ArrayList<>();

    public List<ICrosser> getBoatRiders() {
        return boatRiders;
    }

    Stack<List> stackUndo = new Stack<>();
    Stack<List> stackRedo = new Stack<>();


    @Override
    public void newGame(ICrossingStrategy gameStrategy) {
        levelTwo = s2Events.getLevelTwo();
        strategy = gameStrategy;
        leftBank = strategy.getInitialCrossers();
        boat.setNo_of_sails(0);
        boat.setPos(0);
        pattern.add(leftBank);
        pattern.add(boatRiders);
        pattern.add(rightBank);
        setEvents();

    }

    public void setEvents() {
        levelTwo.saving(s2Events.save());
        levelTwo.loading(s2Events.load());
        levelTwo.redoMovement(s2Events.RedoMovement());
        levelTwo.undoMovement(s2Events.UndoMovement());
        levelTwo.play(s2Events.move());
        levelTwo.LM(s2Events.manLeft());
        levelTwo.RM(s2Events.manRight());
        levelTwo.LW(s2Events.womanLeft());
        levelTwo.RW(s2Events.womanRight());
        levelTwo.LG(s2Events.girlLeft());
        levelTwo.RG(s2Events.girlRight());
        levelTwo.LB(s2Events.boyLeft());
        levelTwo.RB(s2Events.boyRight());
        levelTwo.LG(s2Events.girlLeft());
        levelTwo.RG(s2Events.girlRight());
        levelTwo.LGoat(s2Events.goatLeft());
        levelTwo.RGoat(s2Events.goatRight());
        //  levelOne.LSB(s1Events.sheepLeft());
        //levelOne.RSB(s1Events.sheepRight());
        //levelOne.FLB(s1Events.farmerLeft_Boat());
        //levelOne.FRB(s1Events.farmerRight_Boat());
        //levelOne.LWB(s1Events.wolfLeft());
        //levelOne.RWB(s1Events.wolfRight());
        //levelOne.playSet(s1Events.move());
        //levelOne.LPB(s1Events.plantLeft());
        //levelOne.RPB(s1Events.plantRight());
    }

    @Override
    public void resetGame() {
        if (strategy instanceof StoryOne)
            newGame(new StoryOne());
        else
            newGame(new StoryTwo());
    }

    @Override
    public String[] getInstructions() {
        return strategy.getInstructions();
    }

    @Override
    public List<ICrosser> getCrossersOnRightBank() {
        return rightBank;
    }

    @Override
    public List<ICrosser> getCrossersOnLeftBank() {
        return leftBank;
    }

    @Override
    public boolean isBoatOnTheLeftBank() {
        //view.getFlag lw zero return true else return false;
        //hnb3t l getOn w off mkanha 3shan lma tnady 3la canMove tb3tlha boolean
        if (levelTwo.getBoatOnRight())
            return false;
        else
            return true;
    }

    @Override
    public int getNumberOfSails() {
        return boat.getNo_of_sails();
    }

    @Override
    public boolean canMove(List<ICrosser> crossers, boolean fromLeftToRightBank) {

        if (strategy.isValid(getCrossersOnRightBank(), getCrossersOnLeftBank(), boatRiders)) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public void doMove(List<ICrosser> crossers, boolean fromLeftToRightBank) {
        crossers = boatRiders;
        boat.setNo_of_sails(boat.getNo_of_sails() + 1);
        boat.setPos(boat.getNo_of_sails() % 2);
        if (fromLeftToRightBank) {
            levelTwo.setBoatOnRight(true);
        } else {
            levelTwo.setBoatOnRight(false);
        }
undoFlag=0;
    }

    @Override
    public boolean canUndo() {
        if (stackUndo.isEmpty())
            return false;
        else
            return true;
    }

    @Override
    public boolean canRedo() {
        if (stackRedo.isEmpty())
            return false;
        else
            return true;
    }

    @Override
    public void undo() {
        List<List<ICrosser>> list;
        List<ICrosser> left=new ArrayList<>();
        List<ICrosser> right=new ArrayList<>();
        List<List<ICrosser>> list2=new ArrayList<>();

        if(canUndo()) {
            list = stackUndo.pop();
            twoPopLeft=list.get(0);
            twoPopRight=list.get(1);
            System.out.println("from undo  :" +twoPopLeft);
            System.out.println("from undo  :" +twoPopRight);

            for(ICrosser x:leftBank){
                left.add(x);
            }
            for(ICrosser y:rightBank){
                right.add(y);
            }
            list2.add(left);
            list2.add(right);
            stackRedo.push(list2);
            System.out.println("pushed in redo left"+list2.get(0));
            System.out.println("pushed in redo right"+list2.get(1));

            //leftBank=list.get(0);
            // boatRiders=list.get(1);
            //rightBank=list.get(1);
        }



    }

    @Override
    public void redo() {
        List<List> list;
        if(canRedo()){
            List<List<ICrosser>> RedoPattern;
            RedoPattern=stackRedo.pop();
            redoLeft=RedoPattern.get(0);
            redoRight=RedoPattern.get(1);
            System.out.println(redoLeft);
            System.out.println(redoRight);


        }
    }

    @Override
    public void saveGame() {

        x.write();
    }

    @Override
    public void loadGame() {
        vergu = y.Read();
        boat.setNo_of_sails(y.getNumberOfSails());

    }

    @Override
    public List<List<ICrosser>> solveGame() {
        return null;
    }

    ButtonMover button = new ButtonMover();
    Move move = new Move();

    public ICrossingStrategy getStrategy() {
        return strategy;
    }

    public void setStrategy(ICrossingStrategy strategy) {
        this.strategy = strategy;
    }


    public void manOn() {
        if(undoFlag==0) {
            List<List<ICrosser>> pattern=new ArrayList<>();
            List<ICrosser> x0 = new ArrayList<>();
            List<ICrosser> y = new ArrayList<>();

            for (ICrosser f : leftBank)
                x0.add(f);
            for (ICrosser d : rightBank)
                y.add(d);
            pattern.add(x0);
            pattern.add(y);
            stackUndo.push(pattern);
            System.out.println("left pushed   "+x0);

            System.out.println("right pushed   "+y);
            undoFlag=1;
        }
        ICrosser crosser = null;

        // 0 left 1 boat 2 right
        int flag = 1;

        for (ICrosser x : leftBank) {
            if (x.getWeight() == 90) {
                crosser = x;
                flag = 0;
            }
        }
        if (flag == 1) {
            for (ICrosser x : rightBank) {
                if (x.getWeight() == 90) {
                    crosser = x;
                    flag = 2;
                }
            }
        }
        if (flag == 0 && isBoatOnTheLeftBank()) {
            System.out.println("man tala3 boat mn al left");
            Command getOn = new GetOnBoard(move, crosser);
            button.setCommand(getOn);
            boatRiders = button.pressButton();
            //boatRiders.add(crosser);
            leftBank.remove(crosser);
            //System.out.println(leftBank.size());
            //System.out.println(boatRiders.get(0).getEatingRank());
            //if (levelOne.getFarmerOnBoard() == true)
            //setEvents();
        } else if (flag == 2 && !isBoatOnTheLeftBank()) { // is boat on right ??
            System.out.println("man tala3 boat mn al right");
            Command getOn = new GetOnBoard(move, crosser);
            button.setCommand(getOn);
            boatRiders = button.pressButton();
            //boatRiders.add(crosser);
            rightBank.remove(crosser);

        }
        if (leftBank.size() == 0 && boatRiders.size() == 0)
            levelTwo.LevelCompleted(boat.getNo_of_sails());
          //  stackUndo.push(pattern);

    }


    public void manOff() {
        ICrosser crosser = null;
        for (ICrosser x : boatRiders) {
            if (x.getWeight() == 90)
                crosser = x;
        }


        Command getOff = new GetOffBoard(move, crosser);
        button.setCommand(getOff);
        boatRiders = button.pressButton();
        // boatRiders.remove(crosser);
        System.out.println("size of  boat" + getBoatRiders());
        if (isBoatOnTheLeftBank()) {
            leftBank.add(crosser);
            System.out.println("man boat nazal ra7 left");
        } else {
            rightBank.add(crosser);
            System.out.println("man boat nazal ra7 right");
            // if (levelOne.getFarmerOnBoard() == true)
            //setEvents();
        }
        if (leftBank.size() == 0 && boatRiders.size() == 0)
             levelTwo.LevelCompleted(boat.getNo_of_sails());

            //stackUndo.push(pattern);
    }


    public void womanOn() {
        if(undoFlag==0) {
            List<List<ICrosser>> pattern=new ArrayList<>();
            List<ICrosser> x0 = new ArrayList<>();
            List<ICrosser> y = new ArrayList<>();

            for (ICrosser f : leftBank)
                x0.add(f);
            for (ICrosser d : rightBank)
                y.add(d);
            pattern.add(x0);
            pattern.add(y);
            stackUndo.push(pattern);
            System.out.println("left pushed   "+x0);

            System.out.println("right pushed   "+y);
            undoFlag=1;
        }
        ICrosser crosser = null;

        // 0 left 1 boat 2 right
        int flag = 1;

        for (ICrosser x : leftBank) {
            if (x.getWeight() == 80) {
                crosser = x;
                flag = 0;
            }
        }
        if (flag == 1) {
            for (ICrosser x : rightBank) {
                if (x.getWeight() == 80) {
                    crosser = x;
                    flag = 2;
                }
            }
        }
        if (flag == 0 && isBoatOnTheLeftBank()) {
            System.out.println("woman tala3 boat mn al left");
            Command getOn = new GetOnBoard(move, crosser);
            button.setCommand(getOn);
            boatRiders = button.pressButton();
            //boatRiders.add(crosser);
            leftBank.remove(crosser);
            //System.out.println(leftBank.size());
            //System.out.println(boatRiders.get(0).getEatingRank());
            //if (levelOne.getFarmerOnBoard() == true)
            //setEvents();
        } else if (flag == 2 && !isBoatOnTheLeftBank()) { // is boat on right ??
            System.out.println("woman tala3 boat mn al right");
            Command getOn = new GetOnBoard(move, crosser);
            button.setCommand(getOn);
            boatRiders = button.pressButton();
            //boatRiders.add(crosser);
            rightBank.remove(crosser);

        }
        if (leftBank.size() == 0 && boatRiders.size() == 0)
            levelTwo.LevelCompleted(boat.getNo_of_sails());
           // stackUndo.push(pattern);

    }


    public void womanOff() {
        ICrosser crosser = null;
        for (ICrosser x : boatRiders) {
            if (x.getWeight() == 80)
                crosser = x;
        }


        Command getOff = new GetOffBoard(move, crosser);
        button.setCommand(getOff);
        boatRiders = button.pressButton();
        // boatRiders.remove(crosser);
        System.out.println("size of  boat" + getBoatRiders());
        if (isBoatOnTheLeftBank()) {
            leftBank.add(crosser);
            System.out.println("woman boat nazal ra7 left");
        } else {
            rightBank.add(crosser);
            System.out.println("woman boat nazal ra7 right");
            // if (levelOne.getFarmerOnBoard() == true)
            //setEvents();
        }
        if (leftBank.size() == 0 && boatRiders.size() == 0)
             levelTwo.LevelCompleted(boat.getNo_of_sails());

            //stackUndo.push(pattern);
    }


    public void girlOn() {
        if(undoFlag==0) {
            List<List<ICrosser>> pattern=new ArrayList<>();
            List<ICrosser> x0 = new ArrayList<>();
            List<ICrosser> y = new ArrayList<>();

            for (ICrosser f : leftBank)
                x0.add(f);
            for (ICrosser d : rightBank)
                y.add(d);
            pattern.add(x0);
            pattern.add(y);
            stackUndo.push(pattern);
            System.out.println("left pushed   "+x0);

            System.out.println("right pushed   "+y);
            undoFlag=1;
        }
        ICrosser crosser = null;

        // 0 left 1 boat 2 right
        int flag = 1;

        for (ICrosser x : leftBank) {
            if (x.getWeight() == 60) {
                crosser = x;
                flag = 0;
            }
        }
        if (flag == 1) {
            for (ICrosser x : rightBank) {
                if (x.getWeight() == 60) {
                    crosser = x;
                    flag = 2;
                }
            }
        }
        if (flag == 0 && isBoatOnTheLeftBank()) {
            System.out.println("girl tala3 boat mn al left");
            Command getOn = new GetOnBoard(move, crosser);
            button.setCommand(getOn);
            boatRiders = button.pressButton();
            //boatRiders.add(crosser);
            leftBank.remove(crosser);
            //System.out.println(leftBank.size());
            //System.out.println(boatRiders.get(0).getEatingRank());
            //if (levelOne.getFarmerOnBoard() == true)
            //setEvents();
        } else if (flag == 2 && !isBoatOnTheLeftBank()) { // is boat on right ??
            System.out.println("girl tala3 boat mn al right");
            Command getOn = new GetOnBoard(move, crosser);
            button.setCommand(getOn);
            boatRiders = button.pressButton();
            //boatRiders.add(crosser);
            rightBank.remove(crosser);

        }
        if (leftBank.size() == 0 && boatRiders.size() == 0)
            levelTwo.LevelCompleted(boat.getNo_of_sails());
           // stackUndo.push(pattern);

    }


    public void girlOff() {
        ICrosser crosser = null;
        for (ICrosser x : boatRiders) {
            if (x.getWeight() == 60)
                crosser = x;
        }


        Command getOff = new GetOffBoard(move, crosser);
        button.setCommand(getOff);
        boatRiders = button.pressButton();
        // boatRiders.remove(crosser);
        System.out.println("size of  boat" + getBoatRiders());
        if (isBoatOnTheLeftBank()) {
            leftBank.add(crosser);
            System.out.println("girl boat nazal ra7 left");
        } else {
            rightBank.add(crosser);
            System.out.println("girl boat nazal ra7 right");
            // if (levelOne.getFarmerOnBoard() == true)
            //setEvents();
        }
        if (leftBank.size() == 0 && boatRiders.size() == 0)
             levelTwo.LevelCompleted(boat.getNo_of_sails());

           // stackUndo.push(pattern);
    }


    public void boyOn() {
        if(undoFlag==0) {
            List<List<ICrosser>> pattern=new ArrayList<>();
            List<ICrosser> x0 = new ArrayList<>();
            List<ICrosser> y = new ArrayList<>();

            for (ICrosser f : leftBank)
                x0.add(f);
            for (ICrosser d : rightBank)
                y.add(d);
            pattern.add(x0);
            pattern.add(y);
            stackUndo.push(pattern);
            System.out.println("left pushed   "+x0);

            System.out.println("right pushed   "+y);
            undoFlag=1;
        }
        ICrosser crosser = null;

        // 0 left 1 boat 2 right
        int flag = 1;

        for (ICrosser x : leftBank) {
            if (x.getWeight() == 40) {
                crosser = x;
                flag = 0;
            }
        }
        if (flag == 1) {
            for (ICrosser x : rightBank) {
                if (x.getWeight() == 40) {
                    crosser = x;
                    flag = 2;
                }
            }
        }
        if (flag == 0 && isBoatOnTheLeftBank()) {
            System.out.println("boy tala3 boat mn al left");
            Command getOn = new GetOnBoard(move, crosser);
            button.setCommand(getOn);
            boatRiders = button.pressButton();
            //boatRiders.add(crosser);
            leftBank.remove(crosser);
            //System.out.println(leftBank.size());
            //System.out.println(boatRiders.get(0).getEatingRank());
            //if (levelOne.getFarmerOnBoard() == true)
            //setEvents();
        } else if (flag == 2 && !isBoatOnTheLeftBank()) { // is boat on right ??
            System.out.println("boy tala3 boat mn al right");
            Command getOn = new GetOnBoard(move, crosser);
            button.setCommand(getOn);
            boatRiders = button.pressButton();
            //boatRiders.add(crosser);
            rightBank.remove(crosser);

        }
        if (leftBank.size() == 0 && boatRiders.size() == 0)
            levelTwo.LevelCompleted(boat.getNo_of_sails());
          //  stackUndo.push(pattern);

    }


    public void boyOff() {
        ICrosser crosser = null;
        for (ICrosser x : boatRiders) {
            if (x.getWeight() == 40)
                crosser = x;
        }


        Command getOff = new GetOffBoard(move, crosser);
        button.setCommand(getOff);
        boatRiders = button.pressButton();
        // boatRiders.remove(crosser);
        System.out.println("size of  boat" + getBoatRiders());
        if (isBoatOnTheLeftBank()) {
            leftBank.add(crosser);
            System.out.println("boy boat nazal ra7 left");
        } else {
            rightBank.add(crosser);
            System.out.println("boy boat nazal ra7 right");
            // if (levelOne.getFarmerOnBoard() == true)
            //setEvents();
        }
        if (leftBank.size() == 0 && boatRiders.size() == 0)
             levelTwo.LevelCompleted(boat.getNo_of_sails());

            //stackUndo.push(pattern);
    }

    public void goatOn() {
        if(undoFlag==0) {
            List<List<ICrosser>> pattern=new ArrayList<>();
            List<ICrosser> x0 = new ArrayList<>();
            List<ICrosser> y = new ArrayList<>();

            for (ICrosser f : leftBank)
                x0.add(f);
            for (ICrosser d : rightBank)
                y.add(d);
            pattern.add(x0);
            pattern.add(y);
            stackUndo.push(pattern);
            System.out.println("left pushed   "+x0);

            System.out.println("right pushed   "+y);
            undoFlag=1;
        }
        ICrosser crosser = null;

        // 0 left 1 boat 2 right
        int flag = 1;

        for (ICrosser x : leftBank) {
            if (x.getWeight() == 20) {
                crosser = x;
                flag = 0;
            }
        }
        if (flag == 1) {
            for (ICrosser x : rightBank) {
                if (x.getWeight() == 20) {
                    crosser = x;
                    flag = 2;
                }
            }
        }
        if (flag == 0 && isBoatOnTheLeftBank()) {
            System.out.println("goat tala3 boat mn al left");
            Command getOn = new GetOnBoard(move, crosser);
            button.setCommand(getOn);
            boatRiders = button.pressButton();
            //boatRiders.add(crosser);
            leftBank.remove(crosser);
            //System.out.println(leftBank.size());
            //System.out.println(boatRiders.get(0).getEatingRank());
            //if (levelOne.getFarmerOnBoard() == true)
            //setEvents();
        } else if (flag == 2 && !isBoatOnTheLeftBank()) { // is boat on right ??
            System.out.println("goat tala3 boat mn al right");
            Command getOn = new GetOnBoard(move, crosser);
            button.setCommand(getOn);
            boatRiders = button.pressButton();
            //boatRiders.add(crosser);
            rightBank.remove(crosser);

        }
        if (leftBank.size() == 0 && boatRiders.size() == 0)
            levelTwo.LevelCompleted(boat.getNo_of_sails());
           // stackUndo.push(pattern);

    }


    public void goatOff() {
        ICrosser crosser = null;
        for (ICrosser x : boatRiders) {
            if (x.getWeight() == 20)
                crosser = x;
        }


        Command getOff = new GetOffBoard(move, crosser);
        button.setCommand(getOff);
        boatRiders = button.pressButton();
        // boatRiders.remove(crosser);
        System.out.println("size of  boat" + getBoatRiders());
        if (isBoatOnTheLeftBank()) {
            leftBank.add(crosser);
            System.out.println("goat boat nazal ra7 left");
        } else {
            rightBank.add(crosser);
            System.out.println("goat boat nazal ra7 right");
            // if (levelOne.getFarmerOnBoard() == true)
            //setEvents();
        }
        if (leftBank.size() == 0 && boatRiders.size() == 0)
             levelTwo.LevelCompleted(boat.getNo_of_sails());

           // stackUndo.push(pattern);
    }


}

