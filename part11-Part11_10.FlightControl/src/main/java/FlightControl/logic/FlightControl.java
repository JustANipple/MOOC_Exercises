/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FlightControl.logic;

import FlightControl.domain.Airplane;
import FlightControl.domain.Flight;
import java.util.HashMap;

/**
 *
 * @author Pc
 */
public class FlightControl {
    
    private HashMap<String,Airplane> airplanes;
    private HashMap<Flight,String> flights;
    
    public FlightControl() {
        this.airplanes = new HashMap<>();
        this.flights = new HashMap<>();
    }
    
    public void addAirplane(String id, int capacity) {
        Airplane airplane = new Airplane(id,capacity);
        airplanes.put(id, airplane);
    }
    
    public Airplane getAirplaneId(String id) {
        return airplanes.get(id);
    }
    
    public void addFlight(Airplane airplane, String depId, String tarId) {
        Flight flight = new Flight(airplane, depId, tarId);
        flights.put(flight,airplane.getId());
    }
    
    public void printAirplanes() {
        for(String key : airplanes.keySet()) {
            System.out.println(airplanes.get(key));
        }
    }
    
    public void printFlights() {
        for(Flight key : flights.keySet()) {
            System.out.println(flights.keySet());
        }
    }
    
    public void printDetails(String id) {
        System.out.println(airplanes.get(id));        
    }
}
