/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FlightControl.ui;
import java.util.Scanner;
import FlightControl.domain.Airplane;
import FlightControl.domain.Flight;
import FlightControl.logic.FlightControl;

/**
 *
 * @author Pc
 */
public class TextUI {
    private Scanner scanner;
    private FlightControl flightControl;
    
    public TextUI(Scanner scanner, FlightControl flightControl) {
        this.scanner = scanner;
        this.flightControl = flightControl;
    }
    public void start() {
        System.out.println("Airport Asset Control");
        while(true) {
            
            System.out.println("Choose an action:");
            System.out.println("[1] Add an airplane");
            System.out.println("[2] Add a flight");
            System.out.println("[x] Exit Airport Asset Control");
            
            String answer = scanner.nextLine();
            
            if(answer.equals("1")) {
                addAirplane();                
            } else if (answer.equals("2")) {
                addFlight();
            } else if (answer.equals("x")) {
                break;
            }
        }
    }
    
    private void addAirplane() {
        System.out.println("Give the airplane id:");
        String id = scanner.nextLine();
        System.out.println("Give the airplane capacity:");
        int capacity = Integer.valueOf(scanner.nextLine());
        this.flightControl.addAirplane(id, capacity);
    }
    
    private void addFlight() {
        System.out.println("Give the airplane id:");
        Airplane airplane = askForAirplane();
        System.out.println("Give the departure airport id:");
        String depId = scanner.nextLine();
        System.out.println("Give the target airport id: ");
        String tarId = scanner.nextLine();
        this.flightControl.addFlight(airplane, depId, tarId);
    }
    
    private Airplane askForAirplane() {
        Airplane airplane = null;
        while(airplane == null) {
            String id = scanner.nextLine();
            airplane = flightControl.getAirplaneId(id);
            
            if(airplane == null) {
                System.out.println("No airplane with the id " + id + ".");
            }
        }
        return airplane;
    }
    
    public void startFlightControl() {
        System.out.println("Flight Control");
        while(true) {
            
            System.out.println("Choose an action:");
            System.out.println("[1] Print airplanes");
            System.out.println("[2] Print flights");
            System.out.println("[3] Print airplane details");
            System.out.println("[x] Quit");
            
            String answer = scanner.nextLine();
            
            if(answer.equals("1")) {
                flightControl.printAirplanes();
            } else if (answer.equals("2")) {
                flightControl.printFlights();
            } else if (answer.equals("3")) {
                System.out.println("Give the airplane id:");
                String id = scanner.nextLine();
                flightControl.printDetails(id);
            } else if (answer.equals("x")) {
                break;
            }
        }
    }
}
