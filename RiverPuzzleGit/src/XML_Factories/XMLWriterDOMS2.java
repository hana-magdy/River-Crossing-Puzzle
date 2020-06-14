package XML_Factories;

import sample.S2Controller;
import Strategy.StoryTwo;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;

public class XMLWriterDOMS2 {
    static Element rootElement;
    S2Controller s2Controller;

    public S2Controller getController() {
        return s2Controller;
    }

    public void setController(S2Controller controller) {
        this.s2Controller = controller;
    }

    static Document doc;
    public   void write() {
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
            Element node = doc.createElement("Weight");
            node.appendChild(doc.createTextNode(String.valueOf("\n")));
            for( i=0;i<s2Controller.getCrossersOnLeftBank().size();i++) {
                node.appendChild(doc.createTextNode(String.valueOf(s2Controller.getCrossersOnLeftBank().get(i).getWeight())));
                appending(node,crosser);

            }



            crosser = doc.createElement("CrossersOnBoat");
            node = doc.createElement("Weight");
            node.appendChild(doc.createTextNode(String.valueOf("\n")));
            for( i=0;i<s2Controller.getBoatRiders().size();i++) {
                node.appendChild(doc.createTextNode(String.valueOf(s2Controller.getBoatRiders().get(i).getWeight())));
                appending(node,crosser);

            }

            //append second child
            crosser = doc.createElement("CrossersOnRightBank");
            node = doc.createElement("Weight");
            node.appendChild(doc.createTextNode(String.valueOf("\n")));
            for( i=0;i<s2Controller.getCrossersOnRightBank().size();i++) {
                node.appendChild(doc.createTextNode(String.valueOf(s2Controller.getCrossersOnRightBank().get(i).getWeight())));
                appending(node,crosser);

            }


            /*if(s1Controller.isBoatOnTheLeftBank())
                str="left";
            else
                str="right";

            crosser = doc.createElement("PositionOfBoat");
            node = doc.createElement("LeftOrRight");
            node.appendChild(doc.createTextNode(String.valueOf("\n")));
            node.appendChild(doc.createTextNode(str));
            appending(node,crosser);*/


            crosser = doc.createElement("SailsNumber");
            node=doc.createElement("NumberOfSails");
            node.appendChild(doc.createTextNode(String.valueOf("\n")));
            node.appendChild(doc.createTextNode(String.valueOf(s2Controller.getNumberOfSails())));
            appending(node,crosser);

            //for output to file, console
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            //for pretty print
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            DOMSource source = new DOMSource(doc);

            //write to console or file
            StreamResult console = new StreamResult(System.out);
            StreamResult file = new StreamResult(new File("D:\\c files\\Desktop\\reads2"));

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


