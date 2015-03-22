/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package xmlapi;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.Text;
import org.xml.sax.SAXException;

/**
 *
 * @author azza
 */
public class XmlApi {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            DocumentBuilderFactory dFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder bulider = dFactory.newDocumentBuilder();
            Document dTree= bulider.parse(new File ("src/xmlapi/intro.xml")); 
            NodeList nodeList= dTree.getElementsByTagName("message");
            for(int i=0;i<nodeList.getLength();i++){
//               Text t=dTree.createTextNode("Hello Dom1"); 
//               Node old=nodeList.item(i).getFirstChild();
//                nodeList.item(i).replaceChild(t, old );
              //  nodeList.item(i).getFirstChild().setNodeValue("Hello Dom2");
                nodeList.item(i).setTextContent("hello Dom3");
            }
            TransformerFactory tFactory=TransformerFactory.newInstance();
           
            DOMSource source=new DOMSource(dTree);
            Transformer transformar=tFactory.newTransformer();
            StreamResult res= new StreamResult(new FileOutputStream("src/xmlapi/out3.xml"));
            transformar.transform(source, res);
        }
        // TODO code application logic here
             catch (SAXException ex) {
                ex.printStackTrace();
            } catch (IOException ex) {
                ex.printStackTrace();
                    }
         catch (ParserConfigurationException ex) {
            ex.printStackTrace();
        } catch (TransformerConfigurationException ex) {
            ex.printStackTrace();
        } catch (TransformerException ex) {
           ex.printStackTrace();
        }
    }
    
}
