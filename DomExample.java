/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

//package domexample;

import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;


/**
 *
 * @author Patrycja
 */
public class DomExample {

    /**
     * @param args the command line arguments
     * @throws Exception 
     */
    public static void main(String[] args) throws Exception {
        
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder docBuilder = factory.newDocumentBuilder();
        File file = new File("map.osm");
        Document doc = docBuilder.parse(file);
        
        // Get a list of all elements in the document
        NodeList list = doc.getElementsByTagName("*");
        int nodeCount = 0;
        
        for (int i = 0; i < list.getLength(); i++)  {
            Element element = (Element)list.item(i);
            String nodeName = element.getNodeName();
            if (nodeName.equals("node"))    {
                nodeCount++;
                System.out.println("NODE " + nodeCount);
                String id = element.getAttribute("node");
                System.out.println("ID " + id);
            }
        }
    }   
}
