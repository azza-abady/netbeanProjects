/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package caranimi;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.animation.PathTransition;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.ArcTo;
import javafx.scene.shape.ArcToBuilder;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.scene.shape.PathBuilder;
import javafx.util.Duration;

/**
 *
 * @author azza
 */
public class FXMLDocumentController implements Initializable {
    PathTransition pathTransition;
    @FXML
    private ImageView car;
    @FXML
    private Path path;
    @FXML
    private Path path1;
    @FXML
    private void mouseClik(MouseEvent event){
     pathTransition.setRate(pathTransition.getCurrentRate() * -1);
    }
//   car.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
//
//     @Override
//      public void handle(MouseEvent event) {
//        
//     }
//});
 

    @Override
    public void initialize(URL url, ResourceBundle rb) {
      path1.getStrokeDashArray().addAll(50D,50D);

        pathTransition = new PathTransition();
        pathTransition.setDuration(Duration.millis(10000));
        pathTransition.setNode(car);
        
        pathTransition.setPath(path1);
        pathTransition.setOrientation(PathTransition.OrientationType.ORTHOGONAL_TO_TANGENT);
        pathTransition.setCycleCount(Timeline.INDEFINITE);
//      
        pathTransition.play();
       // TODO
    }
    

}
