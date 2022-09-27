/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FlightControl.domain;

/**
 *
 * @author Pc
 */
public class Flight {
    
    private Airplane airplane;
    private String id;
    private String depId;
    private String tarId;
    
    public Flight(Airplane airplane, String depId, String tarId) {
        this.airplane = airplane;
        this.depId = depId;
        this.tarId = tarId;
    }

    public String getDepId() {
        return depId;
    }

    public String getTarId() {
        return tarId;
    }
    
    @Override
    public String toString() {
        return airplane.toString() + "(" + this.getDepId() + "-" + this.getTarId() + ")";
    }
}
