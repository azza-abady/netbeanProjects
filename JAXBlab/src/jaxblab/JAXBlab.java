/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jaxblab;
import com.sun.jmx.remote.internal.Unmarshal;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import jaxblab.message.*;

/**
 *
 * @author azza
 */
public class JAXBlab {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            // TODO code application logic here
            JAXBContext context=JAXBContext.newInstance("jaxblab.message");
            Unmarshaller unmarsh=context.createUnmarshaller();
            JAXBElement JAXMessage=(JAXBElement)unmarsh.unmarshal(new File("src/jaxblab/MyMesg.xml"));
            MsgType msg=(MsgType)JAXMessage.getValue();
            System.out.println("msg header="+msg.getHeader());
            BodyType msgBody=(BodyType)msg.getMsg().get(0);
            System.out.println("firstmssage "+"From= "+msgBody.getFrom()+"To "+msgBody.getTo().get(0)+"date "+msgBody.getDate().toString()+"body "+msgBody.getBody());
            msg.setHeader("hello JAXB");
            List lt=msg.getMsg();
            lt.clear();
            ObjectFactory fa = new ObjectFactory();
            BodyType msgbody2= fa.createBodyType(); 
            msgbody2.setFrom("azza");
            msgbody2.setBody("hello");
            String To ="sara";
            msgbody2.getTo().add(To);
            lt.add(msgbody2);
            JAXBElement msg2=fa.createMyMsg(msg);
            Marshaller marsh=context.createMarshaller();
            marsh.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            marsh.marshal(msg2, new FileOutputStream("output.xml"));
            
        } catch (JAXBException ex) {
            ex.printStackTrace();
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }
    }
    
}
