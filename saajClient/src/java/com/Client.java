/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com;


import java.net.URL;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.namespace.QName;
import javax.xml.soap.MessageFactory;
import javax.xml.soap.Name;
import javax.xml.soap.SOAPBody;
import javax.xml.soap.SOAPBodyElement;
import javax.xml.soap.SOAPConnection;
import javax.xml.soap.SOAPConnectionFactory;
import javax.xml.soap.SOAPElement;
import javax.xml.soap.SOAPEnvelope;
import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPFactory;
import javax.xml.soap.SOAPHeader;
import javax.xml.soap.SOAPMessage;
import javax.xml.soap.SOAPPart;

/**
 *
 * @author azza
 */
public class Client  {
     static QName bodyName=new QName("http://localhost:8080/saajServer/","HelloSaajServer","hi");
     static QName methodName=new QName("sayHello");
    private static SOAPMessage createSoapRequest() throws Exception{
		 MessageFactory messageFactory = MessageFactory.newInstance();
		 SOAPMessage soapMessage = messageFactory.createMessage();
		 SOAPHeader header = soapMessage.getSOAPHeader();
                 SOAPPart soapPart = soapMessage.getSOAPPart();
    	         SOAPEnvelope soapEnvelope = soapPart.getEnvelope();
		 SOAPBody soapBody = soapEnvelope.getBody();
		 SOAPBodyElement bodyElement=soapBody.addBodyElement(bodyName);
                 SOAPElement soapElement = bodyElement.addChildElement(methodName);
                 soapElement.addTextNode("azza");
		 soapMessage.saveChanges();
                
		 System.out.println("SOAP Request");
		 soapMessage.writeTo(System.out);
		 return soapMessage;
	 }
    public static void main(String args[]){
	        try{    
                        //hit soapRequest to the server to get response
			SOAPConnectionFactory soapConnectionFactory = SOAPConnectionFactory.newInstance();
			SOAPConnection soapConnection = soapConnectionFactory.createConnection();
			URL endpoint =new URL("http://localhost:8080/saajServer/saajResponse");
			SOAPMessage soapResponse = soapConnection.call(createSoapRequest(),endpoint);
                         soapConnection.close();
                         //get response from server
                         SOAPBody responseBody=soapResponse.getSOAPBody();
                         Iterator it=responseBody.getChildElements(bodyName);
                         SOAPBodyElement bodyElement1=(SOAPBodyElement) it.next();
                         Iterator it1=bodyElement1.getChildElements(methodName);
                         SOAPElement soapElement=(SOAPElement) it1.next();
                         String name=soapElement.getValue();
                         System.out.println("Hello from");
                         System.out.println(name);
			System.out.println(soapResponse.getSOAPBody().getTextContent());
                       
                        
		}catch (Exception e) {
		     e.printStackTrace();
		}
	 }
}
