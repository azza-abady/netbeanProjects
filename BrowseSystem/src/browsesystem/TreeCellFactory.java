/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package browsesystem;

import java.io.File;
import static java.util.Collections.list;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.scene.control.ListView;
import javafx.scene.control.TreeCell;
import javafx.scene.control.TreeItem;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;

/**
 *
 * @author azza
 */
public class TreeCellFactory extends TreeCell<File> {

    @Override
    protected void updateItem(File item, boolean empty) {
        super.updateItem(item, empty);
        if (item != null && !empty) {
            Text text = new Text(item.getName());
            setGraphic(text);
            text.setOnMousePressed(new EventHandler<MouseEvent>() {

                @Override
                public void handle(MouseEvent event) {

                    ListView<File> ss;
                    ss = (ListView) text.getScene().lookup("#list");
                    if ( item.isDirectory()) {
//                                ObservableList<File> child = FXCollections.observableArrayList();
//                                File[] files = item.listFiles();

                        ss.setItems(FXCollections.observableArrayList(item.listFiles()));

                    }    //To change body of generated methods, choose Tools | Templates.

                    //To change body of generated methods, choose Tools | Templates.
                }
                
                
            });
          //  setGraphic(text);
        }
        else setGraphic(null);

    }
}
