package application;

import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;

public class PartiesApplication extends Application {

    public static void main(String[] args) {
        launch(PartiesApplication.class);
    }

    @Override
    public void start(Stage stage) throws Exception {
        
        //creating axes for chart
        NumberAxis xAxis = new NumberAxis(1968, 2008, 4);
        NumberAxis yAxis = new NumberAxis(0, 30, 5);
        
        //setting titles for the axes
        xAxis.setLabel("Year");
        yAxis.setLabel("Relative support (%)");
        
        //creating line chart
        LineChart<Number, Number> lineChart = new LineChart<>(xAxis, yAxis);
        lineChart.setTitle("Relative support of the parties");
        
        try(Scanner scanFile = new Scanner(Paths.get("partiesdata.tsv"))) {
            ArrayList<Integer> partiesYears = new ArrayList<>();
            while(scanFile.hasNextLine()) {
                //save row to check it
                String row = scanFile.nextLine();
                                
                String[] parts = row.split("\t");
                                
                //save years of parties into an arraylist
                if(parts[0].equals("Party")) {
                    for(int i = 1; i < parts.length; i++) {
                        partiesYears.add(Integer.valueOf(parts[i]));
                    }                                       
                } else {
                    //creating data set that is going to be added to the line chart
                    XYChart.Series rankingData = new XYChart.Series();
                    rankingData.setName(parts[0]);
                    //single points into the data set
                    for(int i = 0; i < partiesYears.size(); i++) {
                        if(!parts[i+1].contains("-")) {
                           rankingData.getData().add(new XYChart.Data(partiesYears.get(i), Double.valueOf(parts[i+1]))); 
                        }                        
                    }
                    
                    //add the data set to the line chart
                    lineChart.getData().add(rankingData);
                }                
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        
        //display the line chart giving width and hight to view it
        Scene view = new Scene(lineChart, 640, 480);
        stage.setScene(view);
        stage.show();
    }
    
}
