/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package commonPackge;

import java.rmi.*;


/**
 *
 * @author azza
 */
public interface ChatClientInt extends Remote{
    void receive (String msg)throws RemoteException;
    void downloadFile(byte[]file,String fileName)throws RemoteException;
}
