
import commonPackge.ChatClientInt;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.logging.Level;
import java.util.logging.Logger;
import sun.awt.datatransfer.DataTransferer;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author azza
 */
public class ChatClientImplModel extends UnicastRemoteObject implements ChatClientInt {

    ClientContoller c;

    public ChatClientImplModel(ClientContoller clientContoller) throws RemoteException {
        c = clientContoller;
    }

    public void receive(String msg) throws RemoteException {
        System.out.println(msg);
        c.setMsg(msg);//To change body of generated methods, choose Tools | Templates.
    }
    /*
     public void saveFile(byte[]saveFile){
     JFileChooser jf =new JFileChooser();
     int retval=jf.showSaveDialog(this);
     if(retval==JFileChooser.APPROVE_OPTION){
     String path=jf.getSelectedFile().getPath();
     try{
     FileOutputStream save = new FileOutputStream(path);
     byte [] b = saveFile;
     save.write(b);
     save.flush();
     save.close();
     }catch(Exception e){
     e.printStackTrace();
     }
     }   
     */

    @Override
    public void downloadFile(byte[] file, String fileName) throws RemoteException {

        c.setFile(file, fileName);
        /*try {
         FileOutputStream downloadFile=new FileOutputStream(fileName);
         byte[]b=file;
         downloadFile.write(b);
         downloadFile.flush();
         c.setFile(downloadFile, fileName);
         downloadFile.close();
         } catch (FileNotFoundException ex) {
         ex.printStackTrace();
         } catch (IOException ex) {
         ex.printStackTrace();
         }*/
    }

}
