
import java.io.*;
import java.io.IOException;
import java.net.*;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author azza
 */
public class ChatServer {
ServerSocket serverSoket;
public ChatServer(){
    try{
    serverSoket=new ServerSocket(5005);
    while(true){
    Socket s=serverSoket.accept();
    new ChatHandler(s);
    }   
    }catch(IOException e){
        e.printStackTrace();
    }
    }
public static void main(String[]args){
    new ChatServer();
}
}
class ChatHandler extends Thread{
    DataInputStream dis;
    DataOutputStream ps ;
    static Vector<ChatHandler> clientsVector=new Vector<ChatHandler>();
    public ChatHandler(Socket sc){
        try {
            dis=new DataInputStream(sc.getInputStream());
            ps=new DataOutputStream(sc.getOutputStream());
            clientsVector.add(this);
            start();
            
        } catch (IOException ex) {
            
            System.out.println("Connection failed");
            
        }
    }
    public void run(){
    
    while(true){
    try{
        
        String str= dis.readUTF();
        if(str.equals("|||///|||...**12345"))  
            clientsVector.remove(this);
        
        
        sendMessagetoAll(str);
    }catch(Exception e){
       System.out.println("Connection failed");
       break;
    }
    }
    
       
    }
    void sendMessagetoAll(String msg){
    for(ChatHandler ch:clientsVector){
        try {
            ch.ps.writeUTF(msg);
        } catch (IOException ex) {
            Logger.getLogger(ChatHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
        }
    }
}

