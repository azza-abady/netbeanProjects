/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package browsesystem;


import java.io.File;
import java.text.NumberFormat;
import javafx.application.Platform;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.effect.ImageInput;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;

/**
 *
 * @author azza
 */
public class ListCellfactory extends ListCell<File>{
    Image foldericon=new Image(getClass().getResourceAsStream("folderIcon.jpg"));
    Image fileIcon = new Image(getClass().getResourceAsStream("fileIcon.png"));
   
    @Override
    protected void updateItem(File item,boolean empty){
    super.updateItem(item, empty);
    Label tx = null;
    if(item!=null&& item.isDirectory()){
       tx =new Label(item.getName(),new ImageView(foldericon)); 
       // setTextFill(Color.RED);
       
       
     //  this.setGraphic(new ImageView(foldericon));
    } 
    else if(item!=null &&item.isFile()){
         //tx=new Text(item.getName());
tx =new Label(item.getName(),new ImageView(fileIcon));         
//setTextFill(Color.GOLD);
         //this.setGraphic(new ImageView(fileIcon));
    }
    setGraphic(tx);
    
    }
    
}
