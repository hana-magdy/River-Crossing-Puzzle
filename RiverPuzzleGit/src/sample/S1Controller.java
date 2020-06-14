package sample;
import Command.*;
import Crossers.Boat.Boat;
import Crossers.Carn.Wolf;
import Crossers.Farmer.Farmer;
import Crossers.Herb.Sheep;
import Crossers.ICrosser;
import Crossers.Plant.Plant;
import Events.S1Events;
import Strategy.ICrossingStrategy;
import Strategy.StoryOne;
import Strategy.StoryTwo;
import XML_Factories.ReadXMLFile;
import XML_Factories.XMLWriterDOM;

import javax.swing.event.ListDataEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class S1Controller implements IRiverCrossingController{
    public S1Controller(){

    }
    LevelOne levelOne=null;
    S1Events s1Events;
    int undoFlag=0;
    private ICrossingStrategy strategy;
    private List<ICrosser>leftBank;
    private List<ICrosser>rightBank=new ArrayList<>();
   private List<ICrosser> boatRiders=null;
   private List<ICrosser>twoPopLeft=null;
   ReadXMLFile x;
    XMLWriterDOM y;

    public ReadXMLFile getX() {
        return x;
    }

    public void setX(ReadXMLFile x) {
        this.x = x;
    }

    public XMLWriterDOM getY() {
        return y;
    }

    public void setY(XMLWriterDOM y) {
        this.y = y;
    }

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

    private List<ICrosser>redoLeft=null;
   private List<ICrosser>redoRight=null;

    public List<ICrosser> getTwoPopLeft() {
        return twoPopLeft;
    }

    public List<ICrosser> getTwoPopRight() {
        return twoPopRight;
    }

    private List<ICrosser>twoPopRight=null;

    private Boat boat=new Boat();

    public S1Events getS1Events() {
        return s1Events;
    }

    public void setS1Events(S1Events s1Events) {
        this.s1Events = s1Events;
    }

   // List<List<ICrosser>> pattern=new ArrayList<>();
    List<List<ICrosser>> twoPopPattern=null;
    List<List<ICrosser>> redoPattern=null;

    public List<List<ICrosser>>vergu=new ArrayList<>();

    public List<ICrosser> getBoatRiders() {
        return boatRiders;
    }

    Stack<List> stackUndo=new Stack<>();
    Stack<List> stackRedo=new Stack<>();



    @Override
    public void newGame(ICrossingStrategy gameStrategy) {
        levelOne=s1Events.getLevelOne();
        strategy=gameStrategy;
        leftBank=strategy.getInitialCrossers();
        boat.setNo_of_sails(0);
        boat.setPos(0);
        //pattern.add(leftBank);
       // pattern.add(boatRiders);
        //pattern.add(rightBank);
       setEvents();

    }
public void setEvents(){
        levelOne.saving(s1Events.save());
        levelOne.loading(s1Events.load());
   levelOne.redoMovement(s1Events.RedoMovement());
    levelOne.LSB(s1Events.sheepLeft());
    levelOne.RSB(s1Events.sheepRight());
    levelOne.FLB(s1Events.farmerLeft_Boat());
    levelOne.FRB(s1Events.farmerRight_Boat());
    levelOne.LWB(s1Events.wolfLeft());
    levelOne.RWB(s1Events.wolfRight());
    levelOne.playSet(s1Events.move());
    levelOne.LPB(s1Events.plantLeft());
    levelOne.RPB(s1Events.plantRight());
    levelOne.UndoMovement(s1Events.UndoMovement());

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
        if(levelOne.boatOnRight)
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

        if(fromLeftToRightBank){
            for(int i=0;i<crossers.size();i++) {
                getCrossersOnLeftBank().remove(crossers.get(i));
                if(strategy.isValid(getCrossersOnRightBank(),getCrossersOnLeftBank(),crossers)) {
                    return true;

                }
                else
                    return false;
            }

        }else {
            for (int i = 0; i < crossers.size(); i++) {
                getCrossersOnRightBank().remove(crossers.get(i));
                if (strategy.isValid(getCrossersOnRightBank(), getCrossersOnLeftBank(), crossers))
                    return true;
                else
                    return false;
            }

        }
     return  false;
    }

    @Override
    public void doMove(List<ICrosser> crossers, boolean fromLeftToRightBank) {
        crossers=boatRiders;
        boat.setNo_of_sails(boat.getNo_of_sails() + 1);
        boat.setPos(boat.getNo_of_sails() % 2);
        if(fromLeftToRightBank) {
            levelOne.boatOnRight=true;
        }else {
            levelOne.boatOnRight=false;
        }
        undoFlag=0;

    }

    @Override
    public boolean canUndo() {
        if(stackUndo.isEmpty())
        return false;
        else
            return true;
    }

    @Override
    public boolean canRedo() {
        if(stackRedo.isEmpty())
        return false;
        else
            return true;
    }

    @Override
    public void undo() {
        List<List<ICrosser>> list;
        List<List<ICrosser>> list2=new ArrayList<>();
        List<ICrosser> left=new ArrayList<>();
        List<ICrosser>right=new ArrayList<>();

        if(canUndo()) {
            list = stackUndo.pop();
            twoPopLeft=list.get(0);
            twoPopRight=list.get(1);
            //System.out.println("from undo  :" +twoPopLeft);
            //System.out.println("from undo  :" +twoPopRight);
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
        y.write();
    }

    @Override
    public void loadGame() {
        vergu=x.Read();
        boat.setNo_of_sails(x.getNumberOfSails());

    }

    @Override
    public List<List<ICrosser>> solveGame() {
        return null;
    }

    ButtonMover button=new ButtonMover();
    Move move=new Move();
    public ICrossingStrategy getStrategy() {
        return strategy;
    }

    public void setStrategy(ICrossingStrategy strategy) {
        this.strategy = strategy;
    }


    // >>>>>>>>>>>>>>>>>>>>>>Event handler of Movement<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<



    // >>>>>>>>>>>>>>>Event handler of Farmer<<<<<<<<<<<<<<<<<<<<<<<<

    public void onFarmer() {
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
            if (x instanceof Farmer) {
                crosser = x;
                flag = 0;
            }
        }
        if (flag == 1) {
            for (ICrosser x : rightBank) {
                if (x instanceof Farmer) {
                    crosser = x;
                    flag = 2;
                }
            }
        }
        if (flag == 0 && isBoatOnTheLeftBank()) {
            System.out.println("farmer tala3 boat mn al left");
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
            System.out.println("armer tala3 boat mn al right");
            Command getOn = new GetOnBoard(move, crosser);
            button.setCommand(getOn);
            boatRiders = button.pressButton();
            //boatRiders.add(crosser);
            rightBank.remove(crosser);

        }
        if(leftBank.size()==0 && boatRiders.size()==0)
            levelOne.LevelCompleted(boat.getNo_of_sails());
       // stackUndo.push(pattern);


    }

       public   void offFarmer() {

           ICrosser crosser=null;
               for (ICrosser x : boatRiders) {
                   if (x instanceof Farmer)
                       crosser = x;
               }


               Command getOff = new GetOffBoard(move, crosser);
               button.setCommand(getOff);
               boatRiders = button.pressButton();
              // boatRiders.remove(crosser);
               System.out.println("size of  boat"+getBoatRiders());
               if (isBoatOnTheLeftBank()) {
                   leftBank.add(crosser);
                   System.out.println("farmer boat nazal ra7 left");
               }
               else {
                   rightBank.add(crosser);
                   System.out.println("farmer boat nazal ra7 right");
                  // if (levelOne.getFarmerOnBoard() == true)
                       //setEvents();
               }
           if(leftBank.size()==0 && boatRiders.size()==0)
               levelOne.LevelCompleted(boat.getNo_of_sails());

       }

    // >>>>>>>>>>>>>>>Event handler of Wolf<<<<<<<<<<<<<<<<<<<<<<<<


    public void onWolf(){
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

            undoFlag = 1;
        }
        ICrosser crosser = null;

        // 0 left 1 boat 2 right
        int flag = 1;

        for (ICrosser x : leftBank) {
            if (x instanceof Wolf) {
                crosser = x;
                flag = 0;
            }
        }
        if (flag == 1) {
            for (ICrosser x : rightBank) {
                if (x instanceof Wolf) {
                    crosser = x;
                    flag = 2;
                }
            }
        }
        if (flag == 0 && isBoatOnTheLeftBank()) {
            System.out.println("wolf tala3 boat mn al left");
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
            System.out.println("wolf tala3 boat mn al right");
            Command getOn = new GetOnBoard(move, crosser);
            button.setCommand(getOn);
            boatRiders = button.pressButton();
            //boatRiders.add(crosser);
            rightBank.remove(crosser);

        }
        if(leftBank.size()==0 && boatRiders.size()==0)
            levelOne.LevelCompleted(boat.getNo_of_sails());
       // stackUndo.push(pattern);

    }



    public void offWolf() {
        ICrosser crosser=null;
        for (ICrosser x : boatRiders) {
            if (x instanceof Wolf)
                crosser = x;
        }


         Command getOff = new GetOffBoard(move, crosser);
        button.setCommand(getOff);
         boatRiders = button.pressButton();
       // boatRiders.remove(crosser);
        System.out.println("size of  boat"+getBoatRiders());
        if (isBoatOnTheLeftBank()) {
            leftBank.add(crosser);
            System.out.println("wolf boat nazal ra7 left");
        }
        else {
            rightBank.add(crosser);
            System.out.println("wolf boat nazal ra7 right");
            // if (levelOne.getFarmerOnBoard() == true)
            //setEvents();
        }
        if(leftBank.size()==0 && boatRiders.size()==0)
            levelOne.LevelCompleted(boat.getNo_of_sails());

     //   stackUndo.push(pattern);
    }




public void onSheep(){
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

        undoFlag = 1;
    }
    ICrosser crosser = null;

    // 0 left 1 boat 2 right
    int flag = 1;

    for (ICrosser x : leftBank) {
        if (x instanceof Sheep) {
            crosser = x;
            flag = 0;
        }
    }
    if (flag == 1) {
        for (ICrosser x : rightBank) {
            if (x instanceof Sheep) {
                crosser = x;
                flag = 2;
            }
        }
    }
    if (flag == 0 && isBoatOnTheLeftBank()) {
        System.out.println("sheep tala3 boat mn al left");
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
        System.out.println("sheep tala3 boat mn al right");
        Command getOn = new GetOnBoard(move, crosser);
        button.setCommand(getOn);
        boatRiders = button.pressButton();
        //boatRiders.add(crosser);
        rightBank.remove(crosser);

    }
    if(leftBank.size()==0 && boatRiders.size()==0)
        levelOne.LevelCompleted(boat.getNo_of_sails());
   // stackUndo.push(pattern);

}

    public void offSheep() {

        ICrosser crosser=null;
        for (ICrosser x : boatRiders) {
            if (x instanceof Sheep)
                crosser = x;
        }


         Command getOff = new GetOffBoard(move, crosser);
        button.setCommand(getOff);
        boatRiders = button.pressButton();
        //boatRiders.remove(crosser);
        System.out.println("size of  boat"+getBoatRiders());
        if (isBoatOnTheLeftBank()) {
            leftBank.add(crosser);
            System.out.println("sheep boat nazal ra7 left");
        }
        else {
            rightBank.add(crosser);
            System.out.println("sheep boat nazal ra7 right");
            // if (levelOne.getFarmerOnBoard() == true)
            //setEvents();
        }
        if(leftBank.size()==0 && boatRiders.size()==0)
            levelOne.LevelCompleted(boat.getNo_of_sails());


    }




public void onPlant(){
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

        undoFlag = 1;
    }
    ICrosser crosser = null;

    // 0 left 1 boat 2 right
    int flag = 1;

    for (ICrosser x : leftBank) {
        if (x instanceof Plant) {
            crosser = x;
            flag = 0;
        }
    }
    if (flag == 1) {
        for (ICrosser x : rightBank) {
            if (x instanceof Plant) {
                crosser = x;
                flag = 2;
            }
        }
    }
    if (flag == 0 && isBoatOnTheLeftBank()) {
        System.out.println("plant tala3 boat mn al left");
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
        System.out.println("plant tala3 boat mn al right");
        Command getOn = new GetOnBoard(move, crosser);
        button.setCommand(getOn);
        boatRiders = button.pressButton();
        //boatRiders.add(crosser);
        rightBank.remove(crosser);

    }
    if(leftBank.size()==0 && boatRiders.size()==0)
        levelOne.LevelCompleted(boat.getNo_of_sails());
  //  stackUndo.push(pattern);
}


    public void offPlant() {

        ICrosser crosser=null;
        for (ICrosser x : boatRiders) {
            if (x instanceof Plant)
                crosser = x;
        }


         Command getOff = new GetOffBoard(move, crosser);
        button.setCommand(getOff);
         boatRiders = button.pressButton();
        //boatRiders.remove(crosser);
        System.out.println("size of  boat"+getBoatRiders());
        if (isBoatOnTheLeftBank()) {
            leftBank.add(crosser);
            System.out.println("plant boat nazal ra7 left");
        }
        else {
            rightBank.add(crosser);
            System.out.println("plant boat nazal ra7 right");
            // if (levelOne.getFarmerOnBoard() == true)
            //setEvents();
        }
        if(leftBank.size()==0 && boatRiders.size()==0)
            levelOne.LevelCompleted(boat.getNo_of_sails());
       // stackUndo.push(pattern);
    }










}

