
import commonPackge.ChatClientInt;
import commonPackge.ChatServerInt;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileOutputStream;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.print.DocFlavor;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author azza
 */
public class ClientContoller {

    ClientView view;
    ChatClientInt client;

    ChatServerInt reciveMsg1;
    String msg = new String();

    public ClientContoller() {
    }

    public ClientContoller(ClientView view) {

        this.view = view;
        try {
            Registry reg = LocateRegistry.getRegistry(5005);
            reciveMsg1 = (ChatServerInt) reg.lookup("recivie message");
//            this.reciveMsg1=reciveMsg;
            client = new ChatClientImplModel(this);

            reciveMsg1.register(client);
            //reciveMsg.tellOthers(msg);         //To change body of generated methods, choose Tools | Templates.

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void getMsg(String msg) {
        try {
            //  this.msg=msg;
            reciveMsg1.tellOthers(msg);
        } catch (RemoteException ex) {
            ex.printStackTrace();
        }
    }

    public void getFile(byte[] b, String fileName) {
        try {
            reciveMsg1.UploadFile(b, fileName);
        } catch (RemoteException ex) {
            ex.printStackTrace();
        }
    }

    public void setFile(byte[] file, String fileName) {
        view.displayFile(file, fileName);
    }

    public void setMsg(String msg) {
        view.display(msg);
    }
}
