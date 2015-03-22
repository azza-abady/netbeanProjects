/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package chatclientusingrmi.fx;

import commonPackge.ChatServerInt;
import java.net.URL;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import commonPackge.*;
import java.rmi.AccessException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
/**
 *
 * @author azza
 */
public class FXMLDocumentController implements Initializable,ViewInterface {
     ChatClientInt client;
    
    ChatServerInt reciveMsg1;
    @FXML
    private Button sendBtn;
    @FXML
    private TextArea inputTextArea;
    @FXML
    private TextArea chatTextArea;
    @FXML
    private void sendButtonAction(ActionEvent event) {
        
        getMsg(inputTextArea.getText());
        inputTextArea.setText(" ");
    }
    public FXMLDocumentController(){
    try {
            // TODO
            Registry reg = LocateRegistry.getRegistry(5005);
            try {
                reciveMsg1 = (ChatServerInt) reg.lookup("recivie message");
            } catch (NotBoundException ex) {
               ex.printStackTrace();
            } catch (AccessException ex) {
               ex.printStackTrace();
            }
//            this.reciveMsg1=reciveMsg;
            client = new ChatClientImplModel(this);
            
            reciveMsg1.register(client);
        } catch (RemoteException ex) {
            ex.printStackTrace();
        }
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }    
    public void getMsg(String msg){
        
      //  this.msg=m-sg;
            Platform.runLater(new Runnable() {

                @Override
                public void run() {
                  try { 
                    reciveMsg1.tellOthers(msg);
        } catch (RemoteException ex) {
            ex.printStackTrace();
        }//To change body of generated methods, choose Tools | Templates.
                }
            });
            
     }
    @Override
    
    public void display(String msg) {
        Platform.runLater(new Runnable() {

            @Override
            public void run() {
                 chatTextArea.appendText(msg+"\n");
        inputTextArea.requestFocus();//To change body of generated methods, choose Tools | Templates.
            }
        });
        //To change body of generated methods, choose Tools | Templates.
    }
    
}
