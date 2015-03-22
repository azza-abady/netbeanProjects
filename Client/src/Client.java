
import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author azza
 */
public class Client {
    Socket mySocket;
    DataInputStream dis;
    PrintStream ps;
   boolean connect=true;
    public static void main(String[]args) throws IOException{
        new Client();
    }
    public Client() throws IOException{
    try{
        
        mySocket=new Socket("127.0.0.1", 5005);
        dis=new DataInputStream(mySocket.getInputStream());
        ps=new PrintStream(mySocket.getOutputStream());
        ps.println("Test azza Test");
        String replyMsg=dis.readLine();
        System.out.println(replyMsg);
        
        
            
    }
    catch(IOException e){
       System.out.println("Connection failed");
        } 
     
    catch (NullPointerException e) {
        
       System.out.println("Connection failed");
    }
    finally{
        try{
        ps.close();
        dis.close();
        mySocket.close();
              
        }
          catch(IOException e){
       System.out.println("Connection failed");
        } 
        catch (NullPointerException e) {
        
       System.out.println("Connection failed");
    }
    }
    }
}
