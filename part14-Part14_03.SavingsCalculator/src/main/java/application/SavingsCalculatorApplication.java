package application;

import javafx.application.Application;
import javafx.beans.value.ObservableValue;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class SavingsCalculatorApplication extends Application{

    public static void main(String[] args) {
        launch(SavingsCalculatorApplication.class);
    }

    @Override
    public void start(Stage stage) throws Exception {
        VBox box = new VBox();
        BorderPane main = new BorderPane();
        
        //monthly savings block
        BorderPane monthlySavings = new BorderPane();
        Label savings = new Label("Monthly savings");
        Label savingsValue = new Label();
        Slider savingsSlider = new Slider(25, 250, 0);
        savingsSlider.setShowTickMarks(true);
        savingsSlider.setShowTickLabels(true);
        savingsSlider.setBlockIncrement(1);
        monthlySavings.setLeft(savings);
        monthlySavings.setCenter(savingsSlider);
        monthlySavings.setRight(savingsValue);
        
        
        
        //yearly interest rate block
        BorderPane yearlyInterestRate = new BorderPane();
        Label interest = new Label("Yearly interest rate");
        Label interestValue = new Label();
        Slider interestSlider = new Slider(0, 10, 0);
        interestSlider.setShowTickMarks(true);
        interestSlider.setShowTickLabels(true);
        interestSlider.setBlockIncrement(1);
        yearlyInterestRate.setLeft(interest);
        yearlyInterestRate.setCenter(interestSlider);
        yearlyInterestRate.setRight(interestValue);
        
        
        
        box.getChildren().add(monthlySavings);
        box.getChildren().add(yearlyInterestRate);
        
        //chart block
        //creating axes for chart
        NumberAxis xAxis = new NumberAxis(0, 30, 1);
        NumberAxis yAxis = new NumberAxis(0, 20000, 2500);
        //creating line chart
        LineChart<Number, Number> lineChart = new LineChart<>(xAxis, yAxis);
        lineChart.setTitle("Savings");
        //creating data set that is going to be added to the line chart
        XYChart.Series rankingData = new XYChart.Series();
        rankingData.setName("Savings");
        
        //monthly savings event
        savingsSlider.valueProperty().addListener((ObservableValue<? extends Number> ov, Number oldValue, Number newValue) -> {
            savingsSlider.setValue((Math.round(newValue.doubleValue())));
            savingsValue.setText(String.valueOf(savingsSlider.getValue()));
            
        });
        //yearly interest rate event
        interestSlider.valueProperty().addListener((ObservableValue<? extends Number> ov, Number oldValue, Number newValue) -> {
            interestSlider.setValue((Math.round(newValue.doubleValue())));
            interestValue.setText(String.valueOf(interestSlider.getValue()));
        });
        
        rankingData.getData().add(new XYChart.Data(interestSlider.getValue(), savingsSlider.getValue()));
        
        //add the data set to the line chart
        lineChart.getData().add(rankingData);
        //display the line chart giving width and hight to view it
        main.setBottom(lineChart);
        
        main.setTop(box);
        
        
        Scene scene = new Scene(main);
        stage.setScene(scene);
        stage.show();
        
    }

}
