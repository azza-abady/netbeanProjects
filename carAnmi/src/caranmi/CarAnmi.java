/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package caranmi;

import javafx.animation.Interpolator;
import javafx.animation.PathTransition;
import javafx.animation.PathTransition.OrientationType;
import javafx.animation.PathTransitionBuilder;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.ArcToBuilder;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.*;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 *
 * @author Hala
 */
public class CarAnmi extends Application {

    ImageView rect;

    @Override
    public void start(Stage primaryStage) {

        rect = new ImageView(new Image(getClass().getResourceAsStream("carIcon.png")));
        rect.setFitHeight(70);
        rect.setFitWidth(100);
      
        ArcTo arc1 = ArcToBuilder.create().x(400).y(200).radiusX(100).radiusY(50).sweepFlag(true).build();
        ArcTo arc2 = ArcToBuilder.create().x(800).y(200).radiusX(100).radiusY(50).sweepFlag(false).build();

        ArcTo arc3 = ArcToBuilder.create().x(400).y(200).radiusX(100).radiusY(50).sweepFlag(false).build();
        ArcTo arc4 = ArcToBuilder.create().x(100).y(200).radiusX(100).radiusY(50).sweepFlag(true).build();

        arc1.setLargeArcFlag(true);

        Path path;
        path = PathBuilder.create()
                .elements(
                        new MoveTo(100, 200), arc1, arc2, arc3, arc4
                ).build();
        path.setStrokeWidth(70);
        path.setFill(Color.AZURE);
        //path.getStrokeDashArray().addAll(20d, 20d);

        path.setOpacity(1);

        ArcTo arc1Dash = ArcToBuilder.create().x(400).y(200).radiusX(100).radiusY(50).sweepFlag(true).build();
        ArcTo arc2Dash = ArcToBuilder.create().x(800).y(200).radiusX(100).radiusY(50).sweepFlag(false).build();

        ArcTo arc3Dash = ArcToBuilder.create().x(400).y(200).radiusX(100).radiusY(50).sweepFlag(false).build();
        ArcTo arc4Dash = ArcToBuilder.create().x(100).y(200).radiusX(100).radiusY(50).sweepFlag(true).build();

        Path pathDash;
        pathDash = PathBuilder.create()
                .elements(
                        new MoveTo(100, 200), arc1Dash, arc2Dash, arc3Dash, arc4Dash
                ).build();
        pathDash.getStrokeDashArray().addAll(15d, 15d);
        pathDash.setStroke(Color.WHITE);
        pathDash.setStrokeWidth(3);

        AnchorPane root = new AnchorPane();

        root.getChildren().add(path);
        root.getChildren().add(pathDash);
        root.getChildren().add(rect);

        final PathTransition anim = PathTransitionBuilder.create()
                .duration(new Duration(5000))
                .node(rect)
                .path(path)
                .orientation(OrientationType.ORTHOGONAL_TO_TANGENT)
                .interpolator(Interpolator.LINEAR)
                //.autoReverse(true)
                .cycleCount(Timeline.INDEFINITE).autoReverse(false)
                .build();
        anim.play();

        path.setOnMouseClicked(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent event) {
                System.out.println("kjhsdfhjgfd");
              
                System.out.println(anim.autoReverseProperty());
                
                anim.setRate(anim.getCurrentRate() * -1);
            
                

            }
        });

        Scene scene = new Scene(root, 900, 00);

        primaryStage.setTitle("Hello World!");
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
