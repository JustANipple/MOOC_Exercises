package application;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;

public class ShanghaiApplication extends Application {

    public static void main(String[] args) {
        launch(ShanghaiApplication.class);
    }

    @Override
    public void start(Stage stage) throws Exception {
        //creating axes for chart
        NumberAxis xAxis = new NumberAxis(2006, 2018, 2);
        NumberAxis yAxis = new NumberAxis(0, 100, 10);
        
        //setting titles for the axes
        xAxis.setLabel("Year");
        yAxis.setLabel("Ranking");
        
        //creating line chart
        LineChart<Number, Number> lineChart = new LineChart<>(xAxis, yAxis);
        lineChart.setTitle("University of Helsinki, Shanghai ranking");
        
        //creating data set that is going to be added to the line chart
        XYChart.Series rankingData = new XYChart.Series();
        rankingData.setName("Rank");
        //single points into the data set
        rankingData.getData().add(new XYChart.Data(2007, 73));
        rankingData.getData().add(new XYChart.Data(2008, 68));
        rankingData.getData().add(new XYChart.Data(2009, 72));
        rankingData.getData().add(new XYChart.Data(2010, 72));
        rankingData.getData().add(new XYChart.Data(2011, 74));
        rankingData.getData().add(new XYChart.Data(2012, 73));
        rankingData.getData().add(new XYChart.Data(2013, 76));
        rankingData.getData().add(new XYChart.Data(2014, 73));
        rankingData.getData().add(new XYChart.Data(2015, 67));
        rankingData.getData().add(new XYChart.Data(2016, 56));
        rankingData.getData().add(new XYChart.Data(2017, 56));
        
        //add the data set to the line chart
        lineChart.getData().add(rankingData);
        
        //display the line chart giving width and hight to view it
        Scene view = new Scene(lineChart, 640, 480);
        stage.setScene(view);
        stage.show();
    }

}
