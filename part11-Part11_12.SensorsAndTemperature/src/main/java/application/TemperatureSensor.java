/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application;

import java.util.Random;

/**
 *
 * @author Pc
 */
public class TemperatureSensor implements Sensor{

    private boolean powered;
    
    public TemperatureSensor() {
        this.powered = false;
    }
    
    @Override
    public boolean isOn() {
        return this.powered;
    }

    @Override
    public void setOn() {
        this.powered = true;
    }

    @Override
    public void setOff() {
        this.powered = false;
    }

    @Override
    public int read() {
        if(this.powered = false) {
            throw new IllegalArgumentException("Sensor is off");
        }
        
        return new Random().nextInt(61)-30;
    }
    
}
