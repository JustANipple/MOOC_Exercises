package application;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class MultipleViews extends Application {

    public static void main(String[] args) {
        launch(MultipleViews.class);
    }

    @Override
    public void start(Stage window) throws Exception {
        //prima pagina
        BorderPane firstLayout = new BorderPane();
        
        Label firstText = new Label("First view!");
        Button firstButton =  new Button("To the second view!");
        
        firstLayout.setTop(firstText);        
        firstLayout.setCenter(firstButton);
        
        Scene first = new Scene(firstLayout);
        
        //seconda pagina
        VBox secondLayout = new VBox();
        
        Button secondButton = new Button("To the third view!");
        Label secondText = new Label("Second view!");
        
        secondLayout.getChildren().addAll(secondButton,secondText);
        
        Scene second = new Scene(secondLayout);
        
        //terza pagina
        GridPane thirdLayout = new GridPane();
        
        Label thirdText = new Label("Third view!");
        Button thirdButton = new Button("To the first view!");
        
        thirdLayout.add(thirdText, 0, 0);
        thirdLayout.add(thirdButton, 1, 1);
        
        Scene third = new Scene(thirdLayout);
        
        
        
        firstButton.setOnAction((event) -> {
            window.setScene(second);
        });
        
        secondButton.setOnAction((event) -> {
            window.setScene(third);
        });
        
        thirdButton.setOnAction((event) -> {
            window.setScene(first);
        });
        
        
        
        window.setScene(first);
        window.show();
        
    }

}
