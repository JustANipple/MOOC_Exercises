/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Pc
 */
public class AverageSensor implements Sensor{
    
    private ArrayList<Sensor> sensors;
    private List<Integer> readings;
    
    public AverageSensor() {
        this.sensors = new ArrayList<>();
        this.readings = new ArrayList<>();
    }

    @Override
    public boolean isOn() {
        for(Sensor s : sensors) {
            if(!s.isOn()) {
                return false;
            }
        }
        return true;
    }

    @Override
    public void setOn() {
        for(Sensor s : sensors) {
            s.setOn();
        }
    }

    @Override
    public void setOff() {
        for(Sensor s : sensors) {
            s.setOff();
        }
    }

    @Override
    public int read() {
        if(!this.isOn() || sensors.size() == 0) {
            throw new IllegalArgumentException("Something is wrong");
        }
        int sum = 0;
        for (Sensor s : sensors) {
            sum += s.read();
        }
        int average = sum / sensors.size();
        this.readings.add(average);
        return average;
    }
    
    public void addSensor(Sensor toAdd) {
        sensors.add(toAdd);
    }
    
    public List<Integer> readings() {
        return this.readings;
    }
    
}
