/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package helloworld;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.effect.Reflection;
import javafx.scene.layout.Background;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.Stop;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.effect.Reflection;

/**
 *
 * @author azza
 */
public class HelloWorld extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        Reflection reflection = new Reflection();
        reflection.setFraction(0.7);
       Text helloWorld=new Text("Hello World");
  helloWorld.setId("text");
  helloWorld.getStyleClass().add("text");
  //     helloWorld.setFont(Font.font(null, FontWeight.BOLD, 40));
      // helloWorld.setEffect(reflection);
       StackPane rootPane = new StackPane(helloWorld);
        Scene scene = new Scene(rootPane,400,300);
        Stop[] stops = new Stop[] { new Stop(0, Color.BLACK), new Stop(0.5, Color.WHITE),new Stop(1,Color.BLACK)};
        LinearGradient lg2 = new LinearGradient(0,1, 0,0 , true, CycleMethod.NO_CYCLE, stops);
        scene.setFill(lg2);
       scene.getStylesheets().add(getClass().getResource("Style1.css").toString());
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
