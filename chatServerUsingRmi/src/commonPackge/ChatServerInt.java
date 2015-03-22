package commonPackge;


import java.rmi.*;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author azza
 */

public interface ChatServerInt extends Remote {
    void tellOthers(String msg)throws RemoteException;
    void UploadFile(byte[]file,String fileName)throws RemoteException;
    void register (ChatClientInt clientRef)throws RemoteException;
    void unRegister(ChatClientInt clientRef)throws RemoteException;
}
