/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package xmlapi;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.Text;

/**
 *
 * @author azza
 */
public class fatherTree {
    public static void main(String[]args){
        try {
            DocumentBuilderFactory dFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder bulider = dFactory.newDocumentBuilder();
            Document dTree= bulider.newDocument();
            Element fatherElement= dTree.createElement("Father");
            fatherElement.setAttribute("name","");
            Element child =dTree.createElement("Child");
            fatherElement.appendChild(child);
            Element job=dTree.createElement("Job");
            fatherElement.appendChild(job);
            child.setAttribute("Order"," ");
            Element name=dTree.createElement("Name");
            child.appendChild(name);
            Text t = dTree.createTextNode(" ");
            name.appendChild(t);
            Text jobText=dTree.createTextNode(" ");
            job.setAttribute("Title", " ");
            job.appendChild(jobText);
            dTree.appendChild(fatherElement);
             TransformerFactory tFactory=TransformerFactory.newInstance();
           
            DOMSource source=new DOMSource(dTree);
            Transformer transformar=tFactory.newTransformer();
            StreamResult res= new StreamResult(new FileOutputStream("src/xmlapi/father.xml"));
            transformar.setOutputProperty(OutputKeys.INDENT, "yes");
            transformar.transform(source, res);
        } catch (ParserConfigurationException ex) {
            ex.printStackTrace();
        } catch (TransformerConfigurationException ex) {
            ex.printStackTrace();
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (TransformerException ex) {
            ex.printStackTrace();
        }
    }
}
