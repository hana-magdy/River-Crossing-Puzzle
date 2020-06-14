package XML_Factories;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;

import Crossers.Boat.Boat;
import Crossers.Carn.Wolf;
import Crossers.Farmer.Farmer;
import Crossers.Herb.Sheep;
import Crossers.ICrosser;
import Crossers.Plant.Plant;
import javafx.stage.Stage;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import sample.LevelOne;
import sample.S1Controller;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class ReadXMLFile {
    static NodeList nList;
    static Node nNode;
    //private static Object numberOfSails;
    private int numberOfSails = 0;
    private List<ICrosser> leftBank = new ArrayList<>();
    private List<ICrosser> boatRiders = new ArrayList<>();
    private List<ICrosser> rightBank = new ArrayList<>();
    private  List<List<ICrosser>> pattern=new ArrayList<>();

    public int getNumberOfSails() {
        return numberOfSails;
    }

    public void setNumberOfSails(int numberOfSails) {
        this.numberOfSails = numberOfSails;
    }


    public List<List<ICrosser>> Read() {
        int f=0;

            try {
                File fXmlFile = new File("D:\\c files\\Desktop\\reads1");
                DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
                DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
                Document doc = dBuilder.parse(fXmlFile);

                //optional, but recommended
                //read this - http://stackoverflow.com/questions/13786607/normalization-in-dom-parsing-with-java-how-does-it-work
                doc.getDocumentElement().normalize();

                System.out.println("Root element :" + doc.getDocumentElement().getNodeName());

                nList = doc.getElementsByTagName("CrossersOnLeftBank");
                read(nList, 0, 0);

                nList = doc.getElementsByTagName("CrossersOnBoat");
                read(nList, 0, 1);
                nList = doc.getElementsByTagName("CrossersOnRightBank");
                read(nList, 0, 2);
          /*  //nList = doc.getElementsByTagName("PositionOfBoat");
            //read(nList,1);*/
            nList = doc.getElementsByTagName("SailsNumber");
            read(nList,2,9);




            } catch (Exception e) {
                e.printStackTrace();
            }
            pattern.add(leftBank);
            pattern.add(boatRiders);
            pattern.add(rightBank);

        return pattern;
    }

    public void read(NodeList nodeList, int x,int flag) {
        String b=null;
        S1Controller s1Controller = new S1Controller();
        Boat boat = new Boat();
        LevelOne levelOne = new LevelOne(new Stage());

        String str = null;
        String str2 = null;
        String str3 = null;

        for (int temp = 0; temp < nList.getLength(); temp++) {
            nNode = nList.item(temp);
            System.out.println("\nCurrent Element :" + nNode.getNodeName());

            if (nNode.getNodeType() == Node.ELEMENT_NODE) {

                Element eElement = (Element) nNode;
                if (x == 0) {
                  // System.out.println("EatingRank : " + eElement.getElementsByTagName("EatingRank").item(0).getTextContent());
                    str = eElement.getElementsByTagName("EatingRank").item(0).getTextContent();
                }


                  /* else if(x==1) {
                    System.out.println("LeftOrRight: " + eElement.getElementsByTagName("LeftOrRight").item(0).getTextContent());
                    if(eElement.getElementsByTagName("LeftOrRight").item(0).getTextContent().equals("right"))
                         levelOne.setBoatOnRight(true);
                    else
                        levelOne.setBoatOnRight(false);

                   }*/

                 else {
                    System.out.println("NumberOfSails: " + eElement.getElementsByTagName("NumberOfSails").item(0).getTextContent());
                    b=eElement.getElementsByTagName("NumberOfSails").item(0).getTextContent();
                    String[]k=b.split("\n");
                    numberOfSails=Integer.parseInt(k[1]);                 }

            }
        }
        if(flag==0&&str!=null) {
            String[] t = str.split("\n");
            for (int k = 1; k < t.length; k++) {
                if (t[k].contains("0")) {
                    leftBank.add(Plant.getCabbage());

                } else if (t[k].contains("1"))
                    leftBank.add(new Sheep());
                else if (t[k].contains("2"))
                    leftBank.add(new Wolf());
                else if(t[k].contains("4")) {
                    leftBank.add(new Farmer());

                }
            }
        }else if(flag==1&&str!=null) {
       String []t2= str.split("\n");

        for (int k = 1; k < t2.length; k++) {

            if (t2[k].contains("0")) {
                boatRiders.add(Plant.getCabbage());

            } else if (t2[k].contains("1"))
                boatRiders.add(new Sheep());
            else if (t2[k].contains("2"))
                boatRiders.add(new Wolf());
            else if(t2[k].contains("4")) {
                boatRiders.add(new Farmer());
            }
        }
        }else if(flag==2&&str!=null){
      String[] t3 = str.split("\n");

        for (int k = 1; k < t3.length; k++) {

            if (t3[k].contains("0")) {
                rightBank.add(Plant.getCabbage());

            } else if (t3[k].contains("1"))
                rightBank.add(new Sheep());
            else if (t3[k].contains("2"))
                rightBank.add(new Wolf());
            else if(t3[k].contains("4")){
                rightBank.add(new Farmer());


            }
        }
        }
    }
}