package application;


import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class GreeterApplication extends Application {


    public static void main(String[] args) {
        launch(GreeterApplication.class);
    }

    @Override
    public void start(Stage window) throws Exception {
        
        //prima pagina
        VBox layout = new VBox();
        layout.setAlignment(Pos.CENTER);
        
        Label text = new Label("Enter your name and start.");
        TextField txtBox = new TextField();
        txtBox.setMaxWidth(100);
        Button button = new Button("Start");
        
        layout.getChildren().addAll(text,txtBox,button);
        
        Scene first = new Scene(layout);        
        
        //seconda pagina
        Label secondText = new Label();
        secondText.setAlignment(Pos.CENTER);
        
        Scene second = new Scene(secondText);
        
        button.setOnAction((event) -> {
            secondText.setText("Welcome " + txtBox.getText() + "!");
            window.setScene(second);
        });
        
        window.setScene(first);
        window.show();
    }
}
