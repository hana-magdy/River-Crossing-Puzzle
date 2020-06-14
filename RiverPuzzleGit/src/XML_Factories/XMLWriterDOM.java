package XML_Factories;


import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import Events.S1Events;
import Strategy.StoryOne;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import sample.S1Controller;


public class XMLWriterDOM {
    static Element rootElement;
    static Document doc;

    public S1Controller getS1Controller() {
        return s1Controller;
    }

    public void setS1Controller(S1Controller s1Controller) {
        this.s1Controller = s1Controller;
    }

    S1Controller s1Controller;

    public  void write() {
        int i=0;
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder;
        try {
            dBuilder = dbFactory.newDocumentBuilder();
            doc = dBuilder.newDocument();
            //add elements to Document
            rootElement = doc.createElement("Crossers");
            //append root element to document
            doc.appendChild(rootElement);
            String str;


            Element crosser = doc.createElement("CrossersOnLeftBank");
            Element node = doc.createElement("EatingRank");
            node.appendChild(doc.createTextNode(String.valueOf("\n")));
            for( i=0;i<s1Controller.getCrossersOnLeftBank().size();i++) {
                //  rootElement.appendChild(getCrosserLeft(doc, s1Controller.getCrossersOnLeftBank().get(i).getEatingRank()));
                node.appendChild(doc.createTextNode(String.valueOf(s1Controller.getCrossersOnLeftBank().get(i).getEatingRank())));
                appending(node,crosser);

            }



            crosser = doc.createElement("CrossersOnBoat");
            node = doc.createElement("EatingRank");
            node.appendChild(doc.createTextNode(String.valueOf("\n")));
            for( i=0;i<s1Controller.getBoatRiders().size();i++) {
                node.appendChild(doc.createTextNode(String.valueOf(s1Controller.getBoatRiders().get(i).getEatingRank())));
                appending(node,crosser);

            }

            //append second child
            crosser = doc.createElement("CrossersOnRightBank");
            node = doc.createElement("EatingRank");
            node.appendChild(doc.createTextNode(String.valueOf("\n")));
            for( i=0;i<s1Controller.getCrossersOnRightBank().size();i++) {
                node.appendChild(doc.createTextNode(String.valueOf(s1Controller.getCrossersOnRightBank().get(i).getEatingRank())));
                appending(node,crosser);

            }


           /* if(s1Controller.isBoatOnTheLeftBank())
                str="left";
            else
                str="right";

            crosser = doc.createElement("PositionOfBoat");
            node = doc.createElement("LeftOrRight");
            node.appendChild(doc.createTextNode(String.valueOf("\n")));
            node.appendChild(doc.createTextNode(str));
            appending(node,crosser);*/


            crosser = doc.createElement("SailsNumber");
            //node = doc.createElement("LeftOrRight");
            node=doc.createElement("NumberOfSails");
            node.appendChild(doc.createTextNode(String.valueOf("\n")));
            node.appendChild(doc.createTextNode(String.valueOf(s1Controller.getNumberOfSails())));
            appending(node,crosser);

            //for output to file, console
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            //for pretty print
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            DOMSource source = new DOMSource(doc);

            //write to console or file
            StreamResult console = new StreamResult(System.out);
            StreamResult file = new StreamResult(new File("D:\\c files\\Desktop\\reads1"));

            //write data
            transformer.transform(source, console);
            transformer.transform(source, file);
            System.out.println("DONE");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void appending(Element node,Element crosser){
        node.appendChild(doc.createTextNode(String.valueOf("\n")));
        crosser.appendChild(node);
        rootElement.appendChild(crosser);
    }
}


