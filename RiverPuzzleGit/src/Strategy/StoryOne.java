package Strategy;

import Crossers.*;
import Crossers.Carn.Wolf;
import Crossers.Farmer.Farmer;
import Crossers.Herb.Sheep;
import Crossers.Plant.Plant;

import java.util.ArrayList;
import java.util.List;

public class StoryOne implements ICrossingStrategy {
    @Override
    public boolean isValid(List<ICrosser> rightBankCrossers, List<ICrosser> leftBankCrossers, List<ICrosser> boatRiders) {
        int i=0;
        for( i=0;i<boatRiders.size();i++){
            if(boatRiders.get(i).canSail()) {

                break;
            }
        }
        if(boatRiders.size()>2 || i==boatRiders.size() || boatRiders.size()==0)
        return false;
        else {
            for (int j = 1; j < rightBankCrossers.size(); j++) {

                if (Math.abs(rightBankCrossers.get(0).getEatingRank() - (rightBankCrossers.get(j).getEatingRank())) == 1) {
                    return false;
                }
            }
            for (int j = 1; j < leftBankCrossers.size(); j++) {
                if (Math.abs(leftBankCrossers.get(0).getEatingRank() - (leftBankCrossers.get(j).getEatingRank())) == 1) {
                    return false;
                }
            }

        }
        System.out.println("dddd");

        return true;
    }


    @Override
    public List<ICrosser> getInitialCrossers() {
        List<ICrosser> initCrossers=new ArrayList<>();
        ICrosser farmer=new Farmer();
        ICrosser wolf=new Wolf();
        ICrosser sheep=new Sheep();
        ICrosser plant=Plant.getCabbage();
        initCrossers.add(farmer);
        initCrossers.add(wolf);
        initCrossers.add(sheep);
        initCrossers.add(plant);
        return initCrossers;
    }

    @Override
    public String[] getInstructions() {
String[] instructions={"Story one : \r\n A farmer wants to cross a river and takes with him a wolf,a goat and a cabbage.\r\n Rules: \r\n 1)" +
        " The farmer is the only one who can steer the raft\r\n .He can only take one passenger \r\n( the wolf,the goat,or the cabbage" +
        "in addition to himself).\r\n 2) If the wolf and the goat are alone on the same riverbank ,\r\n the wolf will eat the goat.\r\n " +
        " 3) If the goat and the cabbage are alone on the same bank\r\n ,the goat will eat the cabbage.\r\n " +
        "How can the farmer get the wolf, the goat, and the cabbage across the river \r\n" +
        "without any of them being eaten ?"};
        return instructions;
    }



}
