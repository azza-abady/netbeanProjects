/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package browsesystem;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.TreeCell;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.util.Callback;

/**
 *
 * @author azza
 */
public class FXMLDocumentController implements Initializable {

    @FXML
    private TreeView tree;

    @FXML
    private ListView list;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        
        tree.setRoot(createNode(new File("C:/")));
       
        tree.setCellFactory(new Callback<TreeView<File>, TreeCell<File>>() {

            @Override
            public TreeCell<File> call(TreeView<File> tt) {
                return new TreeCellFactory();
            }
        });
        list.setCellFactory(new Callback<ListView<String>,ListCell<File>>() {

            @Override
            public ListCell<File> call(ListView<String>ll) {
                return new ListCellfactory();//To change body of generated methods, choose Tools | Templates.
            }

            
        });
    }

    private TreeItem<File> createNode(final File file) {
        return new TreeItem<File>(file) {
            private boolean isLeaf;
            private boolean isFirstTimeChild = true;
            private boolean isFirstTimeLeaf = true;

            @Override
            public ObservableList<TreeItem<File>> getChildren() {
                if (isFirstTimeChild) {
                    isFirstTimeChild = false;
                    super.getChildren().setAll(buildChildren(this));
                }
                return super.getChildren();
            }

            private ObservableList<TreeItem<File>> buildChildren(TreeItem<File> TreeItem) {
                File f = TreeItem.getValue();
                if (f != null && f.isDirectory()) {
                    File[] files = f.listFiles();
                    if (files != null) {
                        ObservableList<TreeItem<File>> child = FXCollections.observableArrayList();
                        for (File childFile : files) {
                            child.add(createNode(childFile));
                        }
                        return child;
                    }
                }
                return FXCollections.emptyObservableList();//To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public boolean isLeaf() {
                if (isFirstTimeLeaf) {
                    isFirstTimeLeaf = false;
                    File f = (File) getValue();
                    isLeaf = f.isFile();
                }
                return isLeaf;
            }
        };
    }

//    private TreeView<File>buildFileSystemBrowser(){
//    TreeItem<File> root=createNode(new File("C:/"));
//    tree.setRoot(root);
//    return new TreeView<>(root);
//    }
}
