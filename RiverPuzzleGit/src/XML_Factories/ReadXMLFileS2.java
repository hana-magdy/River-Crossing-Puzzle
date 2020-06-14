package XML_Factories;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;

import Crossers.Farmer.Farmer;
import Crossers.Herb.Goat;
import Crossers.Herb.Sheep;
import Crossers.ICrosser;
import sample.S2Controller;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class ReadXMLFileS2 {
    static NodeList nList;
    static Node nNode;
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


        try {

            File fXmlFile = new File("D:\\c files\\Desktop\\reads2");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(fXmlFile);

            //optional, but recommended
            //read this - http://stackoverflow.com/questions/13786607/normalization-in-dom-parsing-with-java-how-does-it-work
            doc.getDocumentElement().normalize();

            System.out.println("Root element :" + doc.getDocumentElement().getNodeName());

            nList = doc.getElementsByTagName("CrossersOnLeftBank");
            read(nList,0,0);

            nList = doc.getElementsByTagName("CrossersOnBoat");
            read(nList,0,1);
            nList = doc.getElementsByTagName("CrossersOnRightBank");
            read(nList,0,2);
            //nList = doc.getElementsByTagName("PositionOfBoat");
            //read(nList,1);
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

    public  void read(NodeList nodeList,int x,int flag) {
        String b=null;
        String str = null;


        for (int temp = 0; temp < nList.getLength(); temp++) {
            nNode = nList.item(temp);

            System.out.println("\nCurrent Element :" + nNode.getNodeName());

            if (nNode.getNodeType() == Node.ELEMENT_NODE) {

                Element eElement = (Element) nNode;
                if (x == 0) {
                    System.out.println("Weight : " + eElement.getElementsByTagName("Weight").item(0).getTextContent());
                    str = eElement.getElementsByTagName("Weight").item(0).getTextContent();
                }

               //  else if(x==1) {
                 //  System.out.println("LeftOrRight: " + eElement.getElementsByTagName("LeftOrRight").item(0).getTextContent());
                //}

                else {
                    b=eElement.getElementsByTagName("NumberOfSails").item(0).getTextContent();
                    String[]k=b.split("\n");
                    numberOfSails=Integer.parseInt(k[1]);
                    System.out.println("NumberOfSails: " + eElement.getElementsByTagName("NumberOfSails").item(0).getTextContent());

                }

            }
        }
        if (flag == 0&&str!=null) {
            String[] t = str.split("\n");
            for (int k = 1; k < t.length; k++) {
                System.out.println(t[k]);
                if (t[k].contains("90")) {
                    System.out.println("guwa if");

                    leftBank.add(new Farmer(90));
                }
                else if(t[k].contains("80"))
                    leftBank.add(new Farmer(80));
                else if(t[k].contains("60"))
                    leftBank.add(new Farmer(60));
                else if(t[k].contains("40"))
                    leftBank.add(new Farmer(40));
                else if(t[k].contains("20"))
                    leftBank.add(new Goat(20));

            }

        }
        else  if (flag == 1&&str!=null) {
            System.out.println("guwa boat");
            String[] t = str.split("\n");
            for (int k = 1; k < t.length; k++) {
                if (t[k].contains("90"))
                    boatRiders.add(new Farmer(90));
                else if(t[k].contains("80"))
                    boatRiders.add(new Farmer(80));
                else if(t[k].contains("60"))
                    boatRiders.add(new Farmer(60));
                else if(t[k].contains("40"))
                    boatRiders.add(new Farmer(40));
                else
                    boatRiders.add(new Goat(20));

            }

        }
        else  if (flag == 2&&str!=null) {
            String[] t = str.split("\n");
            for (int k = 1; k < t.length; k++) {
                if (t[k].contains("90"))
                    rightBank.add(new Farmer(90));
                else if(t[k].contains("80"))
                    rightBank.add(new Farmer(80));
                else if(t[k].contains("60"))
                    rightBank.add(new Farmer(60));
                else if(t[k].contains("40"))
                    rightBank.add(new Farmer(40));
                else
                    rightBank.add(new Goat(20));

            }

        }
    }
}