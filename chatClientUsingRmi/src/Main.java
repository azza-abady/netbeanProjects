
import commonPackge.ChatClientInt;
import java.rmi.RemoteException;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author azza
 */
public class Main {

    public static void main(String[] args) throws RemoteException {
        ClientView view = new ClientView();
        ClientContoller contrl = new ClientContoller(view);
      //  view.setController(contrl);
        ChatClientInt model = new ChatClientImplModel(contrl);

        view.setVisible(true);
    }
}
