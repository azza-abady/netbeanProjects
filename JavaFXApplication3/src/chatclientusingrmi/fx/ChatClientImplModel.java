package chatclientusingrmi.fx;


import commonPackge.ChatClientInt;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author azza
 */
public class ChatClientImplModel extends UnicastRemoteObject implements ChatClientInt{
    FXMLDocumentController c;
    public ChatClientImplModel(FXMLDocumentController clientContoller)throws RemoteException{
        c=clientContoller;
    }
   
    public void receive(String msg) throws RemoteException {
        System.out.println(msg);
        c.display(msg);//To change body of generated methods, choose Tools | Templates.
    }
    
}
