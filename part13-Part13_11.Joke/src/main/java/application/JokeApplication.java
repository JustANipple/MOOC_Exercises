package application;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class JokeApplication extends Application {


    public static void main(String[] args) {
        launch(JokeApplication.class);
    }

    @Override
    public void start(Stage window) throws Exception {
        
        VBox layout = new VBox();
        BorderPane layoutTwo = new BorderPane();
        
        Button firstButton = new Button("Joke");
        Button secondButton = new Button("Answer");
        Button thirdButton = new Button("Explanation");
        
        layout.getChildren().addAll(firstButton,secondButton,thirdButton);
        
        StackPane firstLayout = createView("What do you call a bear with no teeth?");
        StackPane secondLayout = createView("A gummy bear.");
        StackPane thirdLayout = createView("No explanation needed");
        
        layoutTwo.setTop(layout);
        
        firstButton.setOnAction((event) -> {
            layoutTwo.setCenter(firstLayout);
        });
        
        secondButton.setOnAction((event) -> {
            layoutTwo.setCenter(secondLayout);
        });
        
        thirdButton.setOnAction((event) -> {
            layoutTwo.setCenter(thirdLayout);
        });
        
        layoutTwo.setCenter(firstLayout);
        
        Scene scene = new Scene(layoutTwo);
        
        window.setScene(scene);
        window.show();        
    }

    private StackPane createView(String text) {
        StackPane layout = new StackPane();
        layout.setPrefSize(300, 180);
        layout.getChildren().add(new Label(text));
        layout.setAlignment(Pos.CENTER);

        return layout;
    }
}
