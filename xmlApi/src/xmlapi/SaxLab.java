/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xmlapi;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.ws.handler.Handler;
import javax.xml.ws.handler.MessageContext;
import org.xml.sax.*;
import org.xml.sax.ext.DefaultHandler2;
import org.xml.sax.helpers.DefaultHandler;

/**
 *
 * @author azza
 */
public class SaxLab {

    public static void main(String[] args) {
        try {
            SAXParserFactory sFactory = SAXParserFactory.newInstance();
            SAXParser sPars = sFactory.newSAXParser();
            sPars.parse(new File("src/xmlapi/father.xml"), new handler());
        } catch (ParserConfigurationException ex) {
            ex.printStackTrace();
        } catch (SAXException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}

class handler extends DefaultHandler {

    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        for (int i = 0; i < attributes.getLength(); i++) {
            System.out.println(qName + "\n" + "attributes: " + attributes.getLocalName(i));
          //  characters(qName.toCharArray(), i, qName.toCharArray().length);

        }
    }
    /*public void startElement(String name,AttributeList attributes){
     System.out.println();
     for(int i=0; i<attributes.getLength();i++){
     System.out.println(name+"\n"+"attributes: "+attributes.getName(i));
     }
     }*/

    public void characters(char[] ch, int start, int length) throws SAXException {
        for (int i = start; i < length; i++) {
            System.out.print(ch[i]);
        }
    }
//public void ignorableWhitespace(char[] ch,int start,int length)throws SAXException{
//        for(int i=start;i<length;i++){
//        System.out.print(ch[i]);
//}
//}
}
