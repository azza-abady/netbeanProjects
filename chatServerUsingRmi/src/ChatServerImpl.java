
import commonPackge.ChatClientInt;
import commonPackge.ChatServerInt;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Vector;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author azza
 */
public class ChatServerImpl extends UnicastRemoteObject implements ChatServerInt{

    static Vector<ChatClientInt> clientsVector =new Vector<ChatClientInt>();
    public ChatServerImpl()throws RemoteException{}
    public void tellOthers(String msg) throws RemoteException {
        System.out.println("Message received: "+msg);
        for(ChatClientInt clientRef:clientsVector){
            try{
                clientRef.receive(msg);
            }catch(RemoteException ex){
                System.out.println("Can't send message to client");
                ex.printStackTrace();
            }
        }
    }
    public void UploadFile(byte[]file,String fileName)throws RemoteException{
        for(ChatClientInt clientRef:clientsVector){
            clientRef.downloadFile(file, fileName);
        }
    }
    public void register(ChatClientInt clientRef) throws RemoteException {
        clientsVector.add(clientRef);
        System.out.println("Client Added");
    }
    public void unRegister(ChatClientInt clientRef) throws RemoteException {
        clientsVector.remove(clientRef);
        System.out.println("Client Removed");
    }
    
}
